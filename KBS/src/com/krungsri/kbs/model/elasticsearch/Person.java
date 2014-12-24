package com.krungsri.kbs.model.elasticsearch;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "person-index", type = "person-type", indexStoreType = "memory", shards = 5, replicas = 0, refreshInterval = "-1")
public class Person {
	
	@Id
	private String id;
	
	private String name;
	
	@Field(type=FieldType.Nested)
	private List<Car> car;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Car> getCar() {
		return car;
	}

	public void setCar(List<Car> car) {
		this.car = car;
	}
	
	public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
