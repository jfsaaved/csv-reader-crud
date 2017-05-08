package com.jfsaaved.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsaaved.domain.DataEntry;
import com.jfsaaved.repository.DataEntryRepository;

@Service
public class DataEntryService {
	
	private DataEntryRepository dataEntryRepository;
	
	@Autowired
	public DataEntryService(DataEntryRepository dataEntryRepository) {
		this.dataEntryRepository = dataEntryRepository;
	}
	
	public List<DataEntry> list() {
		return dataEntryRepository.findAllByOrderByGmtDateTimeAsc();
	}
	
	public DataEntry get(Long id) {
		return dataEntryRepository.findOne(id);
	}
	
	public DataEntry getByDateTime(Date date) {
		return dataEntryRepository.findByGmtDateTime(date);
	}
	
	public List<DataEntry> filteredByDateTimeBetween(Date startDate, Date endDate) {
		return dataEntryRepository.findByGmtDateTimeBetween(startDate, endDate);
	}

	public DataEntry save(DataEntry dataEntry) {
		return dataEntryRepository.save(dataEntry);
	}
	
	public void delete(Long id) {
		dataEntryRepository.delete(id);
	}

	public List<DataEntry> sortEntriesByGmtDateFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (a.getGmtDateTime().compareTo(d.getGmtDateTime())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByGmtDateLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (a.getGmtDateTime().compareTo(d.getGmtDateTime())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByGmtTimeFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		DateFormat f = new SimpleDateFormat("HH:mm:ss");
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (f.format(a.getGmtDateTime()).compareTo(f.format(d.getGmtDateTime()))); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByGmtTimeLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		DateFormat f = new SimpleDateFormat("HH:mm:ss");
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (f.format(a.getGmtDateTime()).compareTo(f.format(d.getGmtDateTime()))); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByGpsLatFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (a.getGpsLatitude().compareTo(d.getGpsLatitude())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByGpsLatLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
        	{ return (a.getGpsLatitude().compareTo(d.getGpsLatitude())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByGpsLongFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (a.getGpsLongitude().compareTo(d.getGpsLongitude())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByGpsLongLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
        	{ return (a.getGpsLongitude().compareTo(d.getGpsLongitude())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByVocsFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (a.getVocsLcPpm().compareTo(d.getVocsLcPpm())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByVocsLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
        	{ return (a.getVocsLcPpm().compareTo(d.getVocsLcPpm())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByMs3First(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (a.getMs3LcPpm().compareTo(d.getMs3LcPpm())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByMs3Last(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
        	{ return (a.getMs3LcPpm().compareTo(d.getMs3LcPpm())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByHydroSulfFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (a.getHydrogenSulfideLcPpm().compareTo(d.getHydrogenSulfideLcPpm())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByHydroSulfLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
        	{ return (a.getHydrogenSulfideLcPpm().compareTo(d.getHydrogenSulfideLcPpm())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByMethaneFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (a.getMethaneLcPpm().compareTo(d.getMethaneLcPpm())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByMethaneLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
        	{ return (a.getMethaneLcPpm().compareTo(d.getMethaneLcPpm())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByMs2First(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (a.getMs2LcPpm().compareTo(d.getMs2LcPpm())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByMs2Last(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
        	{ return (a.getMs2LcPpm().compareTo(d.getMs2LcPpm())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByAmmoniaFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (a.getAmmoniaLcPpm().compareTo(d.getAmmoniaLcPpm())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByAmmoniaLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
        	{ return (a.getAmmoniaLcPpm().compareTo(d.getAmmoniaLcPpm())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByWindSpdFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (a.getWindSpeed().compareTo(d.getWindSpeed())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByWindSpdLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
        	{ return (a.getWindSpeed().compareTo(d.getWindSpeed())); }});
		Collections.reverse(temp);
		return temp;
	}

	public List<DataEntry> sortEntriesByWindDirFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (a.getWindDirection().compareTo(d.getWindDirection())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByWindDirLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getWindDirection().compareTo(d.getWindDirection())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByRainFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
                        { return (a.getDailyRain().compareTo(d.getDailyRain())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByRainLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
        	{ return (a.getDailyRain().compareTo(d.getDailyRain())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesBySolarSensorFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getSolarSensor().compareTo(d.getSolarSensor())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesBySolarSensorLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getSolarSensor().compareTo(d.getSolarSensor())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByUvSensorFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getUvSensor().compareTo(d.getUvSensor())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByUvSensorLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getUvSensor().compareTo(d.getUvSensor())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByBarometricFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getBarometricPressure().compareTo(d.getBarometricPressure())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByBarometricLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getBarometricPressure().compareTo(d.getBarometricPressure())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByInternalTempFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getInternalTemp().compareTo(d.getInternalTemp())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByInternalTempLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getInternalTemp().compareTo(d.getInternalTemp())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByInternalHumidFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getInternalHummidity().compareTo(d.getInternalHummidity())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByInternalHumidLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getInternalHummidity().compareTo(d.getInternalHummidity())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByExternalTempFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getExternalTemp().compareTo(d.getExternalTemp())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByExternalTempLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getExternalTemp().compareTo(d.getInternalTemp())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByExternalHumidFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getExternalHumidity().compareTo(d.getExternalHumidity())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByExternalHumidLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getExternalHumidity().compareTo(d.getExternalHumidity())); }});
		Collections.reverse(temp);
		return temp;
	}
	
	public List<DataEntry> sortEntriesByOdourUnitFirst(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getOdourUnit().compareTo(d.getOdourUnit())); }});
		return temp;
	}
	
	public List<DataEntry> sortEntriesByOdourUnitLast(List<DataEntry> list) {
		List<DataEntry> temp = new ArrayList<>(list);
		Collections.sort (temp, new Comparator<DataEntry> () { public int compare (final DataEntry a, final DataEntry d)
			{ return (a.getOdourUnit().compareTo(d.getOdourUnit())); }});
		Collections.reverse(temp);
		return temp;
	}
	
}
