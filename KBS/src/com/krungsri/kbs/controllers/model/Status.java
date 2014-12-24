package com.krungsri.kbs.controllers.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Status {
	private int statusId;
	private String statusName;
	
	public Status(int statusId, String statusName){
		this.statusId = statusId;
		this.statusName = statusName;
	}
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
