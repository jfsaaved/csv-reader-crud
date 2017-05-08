package com.jfsaaved.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jfsaaved.domain.DataEntry;

public interface DataEntryRepository extends CrudRepository<DataEntry, Long>{

	List<DataEntry> findAllByOrderByGmtDateTimeAsc();
	List<DataEntry> findByGmtDateTimeBetween(Date start, Date end);
	DataEntry findByGmtDateTime(Date date);
	
}

