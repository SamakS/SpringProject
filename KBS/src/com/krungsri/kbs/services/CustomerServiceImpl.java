package com.krungsri.kbs.services;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import com.krungsri.kbs.model.elasticsearch.Car;
import com.krungsri.kbs.model.elasticsearch.Person;
import com.krungsri.kbs.resposity.elasticsearch.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
		
	private void init(){
		elasticsearchTemplate.deleteIndex(Person.class);
		elasticsearchTemplate.createIndex(Person.class);
		elasticsearchTemplate.putMapping(Person.class);
		elasticsearchTemplate.refresh(Person.class, true);
	}
	
	private Person createPerson() {
		String documentId = randomNumeric(5);
		
		Person person1 = new Person();
		person1.setId(documentId);
		person1.setName("name");

		List<Car> cars = new ArrayList<Car>();
		
		Car saturn = new Car();
		saturn.setName("Saturn");
		saturn.setModel("SL");		
		cars.add(saturn);
		
		Car subaru = new Car();
		subaru.setName("Subaru");
		subaru.setModel("Imprezza");
		cars.add(subaru);		
		
		Car toyota = new Car();
		toyota.setName("Toyota");
		toyota.setModel("Vios");
		cars.add(toyota);

		Car ford = new Car();
		ford.setName("Ford");
		ford.setModel("Focus");
		cars.add(ford);
		
		person1.setCar(cars);
				
		return person1;
	}
	
	private List<Person> createPersons() {
		List<Person> persons = new ArrayList<Person>();
		
		Person person1 = new Person();
		person1.setId("1");
		person1.setName("name1");

		List<Car> cars = new ArrayList<Car>();
		
		Car saturn = new Car();
		saturn.setName("Saturn");
		saturn.setModel("SL");		
		cars.add(saturn);
		
		Car subaru = new Car();
		subaru.setName("Subaru");
		subaru.setModel("Imprezza");
		cars.add(subaru);	
		
		person1.setCar(cars);
		persons.add(person1);
				
		Person person2 = new Person();
		person2.setId("2");
		person2.setName("name2");
		
		cars = new ArrayList<Car>();
		
		Car toyota = new Car();
		toyota.setName("Toyota");
		toyota.setModel("Vios");
		cars.add(toyota);

		Car ford = new Car();
		ford.setName("Ford");
		ford.setModel("Focus");
		cars.add(ford);
		
		person2.setCar(cars);
		
		persons.add(person2);
		
		return persons;
	}

	@Override
	public Person createData() {				
		init();
				
		Person person = createPerson();						
		
		return customerRepo.save(person);
	}

	@Override
	public List<Person> createListData() {		
		List<Person> persons = createPersons();
		return (List<Person>) customerRepo.save(persons);
	}
	
	@Override
	public Page<Person> listPersonAll(Pageable pageable) {			
		return customerRepo.findAll(pageable);
	}

	
}
