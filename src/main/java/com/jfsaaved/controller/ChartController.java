package com.jfsaaved.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jfsaaved.domain.DataEntry;
import com.jfsaaved.service.DataEntryService;

@Controller
@RequestMapping("/chart")
public class ChartController {
	
	private DataEntryService dataEntryService;
	
	@Autowired
	public ChartController(DataEntryService dataEntryService) {
		this.dataEntryService = dataEntryService;
	}
	
	@RequestMapping(value="/" , method = RequestMethod.GET) 
    public String view(@RequestParam(value = "yVal", required =  false) String yVal, 
    		@RequestParam(value = "dateRange", required =  false) String dateRange, 
    		Model model) throws ParseException { 
		
		List<String> dates = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
		
		if(yVal == null) yVal="GPS-Latitude";
		if(dateRange == null){
			String year = sdfYear.format(new Date());
			dateRange = "01/01/"+year+" 00:00:00" + " - " + "12/31/"+year+" 23:59:59";
		};
		
		String[] dateRangeSplit = dateRange.split(" - ");
		Date startDate = sdf.parse(dateRangeSplit[0]);
		Date endDate = sdf.parse(dateRangeSplit[1]);
		
    	String[] options = {"GPS-Latitude", "GPS-Longitude", "VOCs-LC-PPM", "MS3-LC-PPM", "Hydrogen-Sulfide-LC-PPM", "Methane-LC-PPM",
    			"MS2-LC-PPM", "Ammonia-LC-PPM", "Wind-Speed m/s", "Wind-Direction", "Daily-Rain mm", "Solar-Sensor W/m2", "UV-Sensor UV index", "Barometric-Pressure KPa",
    			"Internal-Temperature C", "Internal-Humidity %", "External-Temperature C","External-Humidity %","Odour-Unit"};

    	for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate))
			dates.add(sdf.format(val.getGmtDateTime()));
    	
		switch(yVal) {

			case "GPS-Latitude":
				List<BigDecimal> gpsLatList = new ArrayList<BigDecimal>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate))
					gpsLatList.add(val.getGpsLatitude());
				model.addAttribute("data",gpsLatList);
			break;
			case "GPS-Longitude":
				List<BigDecimal> gpsLongList = new ArrayList<BigDecimal>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					gpsLongList.add(val.getGpsLongitude());
				model.addAttribute("data",gpsLongList);
			break;
			case "VOCs-LC-PPM":
				List<BigDecimal> vocPPM = new ArrayList<BigDecimal>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					vocPPM.add(val.getVocsLcPpm());
				model.addAttribute("data",vocPPM);
			break;
			case "MS3-LC-PPM":
				List<BigDecimal> ms3PPM = new ArrayList<BigDecimal>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					ms3PPM.add(val.getMs3LcPpm());
				model.addAttribute("data",ms3PPM);
			break;
			case "Hydrogen-Sulfide-LC-PPM":
				List<BigDecimal> hydroSulf = new ArrayList<BigDecimal>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					hydroSulf.add(val.getHydrogenSulfideLcPpm());
				model.addAttribute("data",hydroSulf);
			break;
			case "Methane-LC-PPM":
				List<BigDecimal> methane = new ArrayList<BigDecimal>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					methane.add(val.getMethaneLcPpm());
				model.addAttribute("data",methane);
			break;
			case "MS2-LC-PPM":
				List<BigDecimal> ms2 = new ArrayList<BigDecimal>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					ms2.add(val.getMs2LcPpm());
				model.addAttribute("data",ms2);
			break;
			case "Ammonia-LC-PPM":
				List<BigDecimal> ammonia = new ArrayList<BigDecimal>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					ammonia.add(val.getAmmoniaLcPpm());
				model.addAttribute("data",ammonia);
			break;
			case "Wind-Speed m/s":
				List<Double> windSpd = new ArrayList<Double>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					windSpd.add(val.getWindSpeed());
				model.addAttribute("data",windSpd);
			break;
			case "Wind-Direction":
				List<Integer> windDir = new ArrayList<Integer>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					windDir.add(val.getWindDirection());
				model.addAttribute("data",windDir);
			break;
			case "Daily-Rain mm":
				List<Double> dailyRain = new ArrayList<Double>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					dailyRain.add(val.getDailyRain());
				model.addAttribute("data",dailyRain);
			break;
			case "Solar-Sensor W/m2":
				List<BigDecimal> solarSensor = new ArrayList<BigDecimal>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					solarSensor.add(val.getSolarSensor());
				model.addAttribute("data",solarSensor);
			break;
			case "UV-Sensor UV index":
				List<BigDecimal> uvSensor = new ArrayList<BigDecimal>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					uvSensor.add(val.getUvSensor());
				model.addAttribute("data",uvSensor);
			break;
			case "Barometric-Pressure KPa":
				List<BigDecimal> baroPressure = new ArrayList<BigDecimal>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					baroPressure.add(val.getBarometricPressure());
				model.addAttribute("data",baroPressure);
			break;
			case "Internal-Temperature C":
				List<Double> internalTemp = new ArrayList<Double>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					internalTemp.add(val.getInternalTemp());
				model.addAttribute("data",internalTemp);
			break;
			case "Internal-Humidity %":
				List<Double> internalHumid = new ArrayList<Double>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					internalHumid.add(val.getInternalHummidity());
				model.addAttribute("data",internalHumid);
			break;
			case "External-Temperature C":
				List<Double> externalTemp = new ArrayList<Double>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					externalTemp.add(val.getExternalTemp());
				model.addAttribute("data",externalTemp);
			break;
			case "External-Humidity %":
				List<Double> externalHumid = new ArrayList<Double>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate)) 
					externalHumid.add(val.getExternalHumidity());
				model.addAttribute("data",externalHumid);
			break;
			case "Odour-Unit":
				List<Integer> odourUnit = new ArrayList<Integer>();
				for(DataEntry val : dataEntryService.filteredByDateTimeBetween(startDate, endDate))
					odourUnit.add(val.getOdourUnit());
				model.addAttribute("data",odourUnit);
			break;
		}
		
    	model.addAttribute("options",options);
    	model.addAttribute("optionSelected",yVal);
    	model.addAttribute("dateRange", dateRange);
    	model.addAttribute("dates",dates);

		 return "chart/view"; 
    } 
    

}
