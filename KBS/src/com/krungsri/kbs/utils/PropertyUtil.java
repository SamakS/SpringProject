package com.krungsri.kbs.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PropertyUtil {
	
	private static final String MASTER_PROPERTIES = "/kbsconfig.properties";
	private static final String MESSAGE_PROPERTIES = "/message.properties";
	private static Properties masterProps;
	private static Properties messageProps;
	
	private static Logger log = LoggerFactory.getLogger(PropertyUtil.class);
	
	public static Properties getMasterProperties(){
		 
		if ((masterProps == null) || (masterProps.size()==0)){
			masterProps = new Properties();
			try {
				masterProps.load(PropertyUtil.class.getResourceAsStream(MASTER_PROPERTIES));
			} catch (FileNotFoundException e) {
				log.error(CommonUtils.getErrorMessage(e),e);
			} catch (IOException e) {
				log.error(CommonUtils.getErrorMessage(e),e);
			}
		}
		
		return masterProps;
		
	}
	
	public static String getConfigProperty(String valName) {
		Properties propsLocal = getMasterProperties();
		
		return propsLocal.getProperty(valName);
	}
	
	public static Properties getMessageProperties(){
		 
		if ((messageProps == null) || (messageProps.size()==0)){
			messageProps = new Properties();
			try {
				messageProps.load(PropertyUtil.class.getResourceAsStream(MESSAGE_PROPERTIES));
			} catch (FileNotFoundException e) {
				log.error(CommonUtils.getErrorMessage(e),e);
			} catch (IOException e) {
				log.error(CommonUtils.getErrorMessage(e),e);
			}
		}
		
		return messageProps;
		
	}
	
	public static String getMessageProperty(String valName) {
		Properties propsLocal = getMessageProperties();
		
		return propsLocal.getProperty(valName);
	}
}
