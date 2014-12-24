package com.krungsri.kbs.controllers.model;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class LoginForm {
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
