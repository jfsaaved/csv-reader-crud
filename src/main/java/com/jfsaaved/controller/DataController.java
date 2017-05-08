package com.jfsaaved.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jfsaaved.domain.DataEntry;
import com.jfsaaved.service.DataEntryService;

@Controller
@RequestMapping("/data")
public class DataController {
	
	private DataEntryService dataEntryService;
	
	@Autowired
	public DataController(DataEntryService dataEntryService) {
		this.dataEntryService = dataEntryService;
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		String date = dataEntryService.get(id).getGmtDate();
		String time = dataEntryService.get(id).getGmtTime();
		dataEntryService.delete(id);
		
		redirectAttributes.addFlashAttribute("message", "Entry (Date: "+ date + " and Time: " + time +") has been deleted");
		return "redirect:/data/";
	}
	
	@RequestMapping("/{id}")
	public String view(@PathVariable Long id, Model model) {
		
		model.addAttribute("entry", dataEntryService.get(id));
		return "data/view";
	}
	
	@RequestMapping( value = "/save", method = RequestMethod.POST )
	public String save(@Valid DataEntry dataEntry, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			return "data/edit";
		} else {
			if(dataEntryService.getByDateTime(dataEntry.getGmtDateTime()) != null) {
				String date = dataEntry.getGmtDate();
				String time = dataEntry.getGmtTime();
				model.addAttribute("message", "There's already a record that exists for: "+ date + " " + time);
				return "data/edit";
			} else {
				DataEntry savedData = dataEntryService.save(dataEntry);
				redirectAttributes.addFlashAttribute("message", "Update Success!");
				return "redirect:/data/" + savedData.getId();
			}
		}
		
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("dataEntry", dataEntryService.get(id));
		return "data/edit";
	}
	
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public String list(@RequestParam(value = "sort" , required = false) String sort, 
			@RequestParam(value = "dateRange", required =  false) String dateRange, 
			@RequestParam(value = "page", required = false) Integer page, 
			@RequestParam(value = "size", required = false) Integer size, 
			Model model) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
		
		if(page == null) page = 0;
		if(size == null || size == 0) size = 25;
		if(sort == null) sort = "ByGmtDateFirst";
		if(dateRange == null){
			String year = sdfYear.format(new Date());
			dateRange = "01/01/"+year+" 00:00:00" + " - " + "12/31/"+year+" 23:59:59";
		};
		
		String[] dateRangeSplit = dateRange.split(" - ");
		Date startDate = sdf.parse(dateRangeSplit[0]);
		Date endDate = sdf.parse(dateRangeSplit[1]);
		
		PagedListHolder<?> entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByGmtDateFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
		
		switch(sort) {
		case "ByGmtDateFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByGmtDateFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByGmtDateLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByGmtDateLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByGmtTimeFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByGmtTimeFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByGmtTimeLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByGmtTimeLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByGpsLatFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByGpsLatFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByGpsLatLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByGpsLatLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByGpsLongFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByGpsLongFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByGpsLongLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByGpsLongLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByVocsFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByVocsFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByVocsLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByVocsLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByMs3First":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByMs3First(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByMs3Last":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByMs3Last(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByHydroSulfFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByHydroSulfFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByHydroSulfLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByHydroSulfLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByMethaneFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByMethaneFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByMethaneLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByMethaneLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;	
		case "ByMs2First":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByMs2First(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByMs2Last":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByMs2Last(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;	
		case "ByAmmoniaFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByAmmoniaFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByAmmoniaLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByAmmoniaLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByWindSpdFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByWindSpdFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByWindSpdLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByWindSpdLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByWindDirFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByWindDirFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByWindDirLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByWindDirLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByRainFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByRainFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByRainLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByRainLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "BySolarSensorFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesBySolarSensorFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "BySolarSensorLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesBySolarSensorLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByUvSensorFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByUvSensorFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByUvSensorLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByUvSensorLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByBarometricFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByBarometricFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByBarometricLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByBarometricLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByInternalTempFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByInternalTempFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByInternalTempLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByInternalTempLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByInternalHumidFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByInternalHumidFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByInternalHumidLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByInternalHumidLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByExternalTempFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByExternalTempFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByExternalTempLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByExternalTempLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByExternalHumidFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByExternalHumidFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByExternalHumidLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByExternalHumidLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByOdourUnitFirst":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByOdourUnitFirst(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		case "ByOdourUnitLast":
			entryPagedList = new PagedListHolder<DataEntry>(dataEntryService.sortEntriesByOdourUnitLast(dataEntryService.filteredByDateTimeBetween(startDate, endDate))); 
			break;
		}
		
		entryPagedList.setPage(page);
		entryPagedList.setPageSize(size);
		
		model.addAttribute("dateRange", dateRange);
		model.addAttribute("entries", entryPagedList); 
	    model.addAttribute("sort", sort);
	    model.addAttribute("size", size);
		return "data/list";
	}


}
