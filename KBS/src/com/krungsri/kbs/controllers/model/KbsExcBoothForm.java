package com.krungsri.kbs.controllers.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class KbsExcBoothForm {
	private String id;
	private String location;
	private String telephone;
	private String updateTime;
	private String highlightedMessage;	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getHighlightedMessage() {
		return highlightedMessage;
	}
	public void setHighlightedMessage(String highlightedMessage) {
		this.highlightedMessage = highlightedMessage;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
