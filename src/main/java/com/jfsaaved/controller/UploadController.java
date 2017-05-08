package com.jfsaaved.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jfsaaved.domain.DataEntry;
import com.jfsaaved.service.DataEntryService;


@Controller
@RequestMapping("/upload")
public class UploadController {
	
	private DataEntryService dataEntryService;
	
	@Autowired
	public UploadController(DataEntryService dataEntryService) {
		this.dataEntryService = dataEntryService;
	}
	
    @RequestMapping("/") 
    public String open() { 
         return "upload/open"; 
    } 
	
    @RequestMapping(value = "/save", method = RequestMethod.POST) 
    public String save(@RequestParam("file") MultipartFile file, Model model) {    
    	
    	String extension = file.getOriginalFilename().split("\\.")[1];
    	if(extension.equalsIgnoreCase("csv")) {
    		
    		BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";
            
            ArrayList<DataEntry> duplicates = new ArrayList<DataEntry>();
 
            try {
            	
                br = new BufferedReader(new FileReader(multipartToFile(file)));
                boolean firstLine = true;
                while ((line = br.readLine()) != null) {
                	if(!firstLine) {
                		
	                    String[] data = line.split(cvsSplitBy);
	                    DataEntry dataEntry = new DataEntry();
	                    dataEntry.setDateUploaded(new Date());
	                    String dateAndTime = data[0] + " " + data[1];
	                    Date gmtDateTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(dateAndTime);
	                    dataEntry.setGmtDateTime(gmtDateTime);
	                    dataEntry.setGpsLatitude(new BigDecimal(data[2]));
	                    dataEntry.setGpsLongitude(new BigDecimal(data[3]));
	                    dataEntry.setVocsLcPpm(new BigDecimal(data[4]));
	                    dataEntry.setMs3LcPpm(new BigDecimal(data[5]));
	                    dataEntry.setHydrogenSulfideLcPpm(new BigDecimal(data[6]));
	                    dataEntry.setMethaneLcPpm(new BigDecimal(data[7]));
	                    dataEntry.setMs2LcPpm(new BigDecimal(data[8]));
	                    dataEntry.setAmmoniaLcPpm(new BigDecimal(data[9]));
	                    dataEntry.setWindSpeed(Double.parseDouble(data[10]));
	                    dataEntry.setWindDirection(Integer.parseInt(data[11]));
	                    dataEntry.setDailyRain(Double.parseDouble(data[12]));
	                    dataEntry.setSolarSensor(new BigDecimal(data[13]));
	                    dataEntry.setUvSensor(new BigDecimal(data[14]));
	                    dataEntry.setBarometricPressure(new BigDecimal(data[15]));
	                    dataEntry.setInternalTemp(Double.parseDouble(data[16]));
	                    dataEntry.setInternalHummidity(Double.parseDouble(data[17]));
	                    dataEntry.setExternalTemp(Double.parseDouble(data[18]));
	                    dataEntry.setExternalHumidity(Double.parseDouble(data[19]));
	                    dataEntry.setOdourUnit(Integer.parseInt(data[20]));

	                    if(dataEntryService.getByDateTime(dataEntry.getGmtDateTime()) == null) {
	                    	dataEntryService.save(dataEntry);
	                    } else {
	                    	duplicates.add(dataEntry);
	                    }
	                    
                	} else {
                		firstLine = false;
                	}
                }
                
            } catch (Exception e) {
				e.printStackTrace();
				return "upload/uploadFailure"; 
			} finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            model.addAttribute("duplicates", duplicates);
            return "upload/uploadSuccess"; 
    	} else {
    		return "upload/uploadFailure"; 
    	}
    	
    } 
    
    public File multipartToFile(MultipartFile file) throws Exception {  
    	
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile(); 
        FileOutputStream fos = new FileOutputStream(convFile); 
        fos.write(file.getBytes());
        fos.close(); 
        return convFile;
        
    }

}
