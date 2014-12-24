package com.krungsri.kbs.utils;

public class Constants {
    /*
     * System Environment
     */
	public static final String ENV_LOCAL="LOCAL";
	public static final String ENV_DEV="DEV";
	public static final String ENV_PRODUCTION="PRODUCTION";
	public static final String ENV_STRESS_TEST="STRESS_TEST";	
	
	/*
     * Web Constants
     */
    public static final String THEMES = "sunny";
      
    public final static String SUCCESS = "success";
    public final static String ERROR = "error";
    public final static String SESSION_ERROR = "sessionError";
    public final static String ERROR_LOG = "errorLog";
    public static final String PAGE_ENCODING = "UTF-8";
    public static final String EMAIL_ENCODING = "TIS-620";
    public static final String PAGE_CONTEXT_TYPE = "text/html; UTF-8;";
    public static final long AJAX_TIMEOUT = 1800000; // 1800 seconds
    
    public static final String START_TIME = PropertyUtil.getConfigProperty("working.start.time");
	public static final String END_TIME = PropertyUtil.getConfigProperty("working.end.time");
    		
    /*
     * Session Constants
     */    
    public static final String SESSION_USER_AUTHEN = "SESSION_USER_AUTHEN";    
        
	/*
	 * Email Configuration
	 */	
	public static final String MAIL_SMTP   = PropertyUtil.getConfigProperty("mail.smtp");
	public static final String MAIL_PORT   = PropertyUtil.getConfigProperty("mail.port");
	
}
