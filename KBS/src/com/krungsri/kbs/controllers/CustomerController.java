package com.krungsri.kbs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.krungsri.kbs.model.elasticsearch.Person;
import com.krungsri.kbs.services.CustomerService;

@Controller
@Deprecated
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/customer", method=RequestMethod.GET)
	public String init(Model model){
		log.info("Start Elasticsearch via Spring MVC & String JPA");
		model.addAttribute("hello", "Start Elasticsearch via Spring MVC & String JPA");
		Person person = customerService.createData();
		
		log.info("Person created : {}",person);
		
		List<Person> personList = customerService.createListData();
						
		log.info("List<Person> created : {}",personList);
		
		Pageable pageable = new PageRequest(1, 10);
		Page<Person> personPage = customerService.listPersonAll(pageable);
		
		int current = personPage.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, personPage.getTotalPages());

	    model.addAttribute("person", personPage);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		
	    log.info("Page<Person> getTotalElements : {}",personPage.getTotalElements());
	    log.info("Page<Person> hasContent : {}",personPage.hasContent());
	    log.info("Page<Person> beginIndex : {}",begin);
	    log.info("Page<Person> endIndex : {}",end);
		log.info("Page<Person> currentIndex : {}",current);
		
		return "customer";				
	}
}
