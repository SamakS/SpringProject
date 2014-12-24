package com.krungsri.kbs.model.elasticsearch;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class Car {
	private String name;
	private String model;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
