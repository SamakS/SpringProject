package com.krungsri.kbs.controllers.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Group {
	private String key;
	private String value;
	
	public Group(String key, String value)
	{
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
