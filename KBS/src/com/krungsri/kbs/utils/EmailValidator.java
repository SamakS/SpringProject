package com.krungsri.kbs.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class EmailValidator {
	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	/**
	 * Validate hex with regular expression
	 * 
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public boolean validate(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}

	public boolean validateEmail(String text) {
		String[] emailList = StringUtils.split(text, ",");

		for (String temp : emailList) {
			boolean valid = validate(temp.trim());

			if(!valid){
				return false;
			}
		}
		return true;
	}
	
	public static String[] listAddress(String address){
		String[] mailAddress = address.split(";");
		return mailAddress;
	} 
	
	public static void main(String[] args){
		String address = "Photchanart.Wuttiyan@krungsri.com;";
		
		String[] list = listAddress(address);
		for(String mail : list){
			System.out.println(mail);
		}
		
	}
}
