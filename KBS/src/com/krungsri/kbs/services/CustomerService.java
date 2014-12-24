package com.krungsri.kbs.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.krungsri.kbs.model.elasticsearch.Person;

public interface CustomerService {	
	
	public Person createData();
	
	public List<Person> createListData();
	
	public Page<Person> listPersonAll(Pageable pageable);
}
