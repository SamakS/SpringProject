package com.krungsri.kbs.utils;

import java.util.Locale;


public class ConstantsBackUp {
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
    public static final String ROOT_CONTEXT = "/CRMPopup";
    public static final String JSP_PATH = ROOT_CONTEXT + "/Page";
    public static final String IMAGE_PATH = ROOT_CONTEXT + "/images";
    public static final String CSS_PATH = ROOT_CONTEXT + "/css";
    public static final String JQUERY_PATH = ROOT_CONTEXT + "/jQuery";
    public static final String JS_PATH = ROOT_CONTEXT + "/js";
    public static final String CAB_PATH = ROOT_CONTEXT + "/cab";
    
    public static final String ROOT_PYM_CONTEXT = "/CRMPopup/planYourMoney";
    public static final String JSP_PYM_PATH = ROOT_PYM_CONTEXT + "/pages";
    public static final String IMAGE_PYM_PATH = ROOT_PYM_CONTEXT + "/images";
    public static final String CSS_PYM_PATH = ROOT_PYM_CONTEXT + "/css";
    public static final String JQUERY_PYM_PATH = ROOT_PYM_CONTEXT + "/jQuery";
    public static final String JS_PYM_PATH = ROOT_PYM_CONTEXT + "/js";
    public static final String JS_ADMIN_PYM_PATH = JS_PYM_PATH+"/admin";

    
    public static final String THEMES = "sunny";
      
    public final static String SUCCESS = "success";
    public final static String ERROR = "error";
    public final static String SESSION_ERROR = "sessionError";
    public final static String ERROR_LOG = "errorLog";
    public static final String PAGE_ENCODING = "UTF-8";
    public static final String EMAIL_ENCODING = "TIS-620";
    public static final String PAGE_CONTEXT_TYPE = "text/html; UTF-8;";
    public static final long AJAX_TIMEOUT = 1800000; // 1800 seconds
    
    public final static String PARAM_REPORT_DATE = "date";
    
    /*
     * Session Constants
     */
    public static final String SESSION_AGENT_INFO = "SESSION_AGENT_INFO";
    public static final String SESSION_HAD_LOGIN = "SESSION_HAD_LOGIN";
    public static final String SESSION_NO_IVR_FLAG = "SESSION_NO_IVR_FLAG";
    public static final String SESSION_AUTO_POPUP_SEARCH_FLAG = "SESSION_AUTO_POPUP_SEARCH_FLAG";
    public static final String SESSION_AUTO_SEARCH_ACCT_NO = "SESSION_AUTO_SEARCH_ACCT_NO";
    public static final String SESSION_CUSTOMER_SEARCH_RESULT = "SESSION_CUSTOMER_SEARCH_RESULT";
    public static final String SESSION_CUSTOMER_NO = "SESSION_CUSTOMER_NO";
    public static final String SESSION_CUSTOMER = "SESSION_CUSTOMER";
    public static final String SESSION_CUSTOMER_PROFILE = "SESSION_CUSTOMER_PROFILE";
    public static final String SESSION_CUSTOMER_ACCOUNT_LIST = "SESSION_CUSTOMER_ACCOUNT_LIST";
        
    /*
     * Plan Your Money Session Constants
     */
    public static final String SESSION_AGENT_PYM_INFO = "SESSION_AGENT_PYM_INFO";
    public static final String SESSION_CUSTOMER_PYM_SEARCH_RESULT = "SESSION_CUSTOMER_PYM_SEARCH_RESULT";
    public static final String SESSION_USER_AUTHEN = "SESSION_USER_AUTHEN";
    
        public static final String PYM_DEPARTMENT_ID = "";
    /*
     * MQ Constants
     */
	
	public static final String SUBSIDIARIES_RESPONSE_CODE = PropertyUtil.getConfigProperty("subsidiaries.response.code");
	public static final String ERROR_MESSAGE_SUBSIDIARIES = PropertyUtil.getConfigProperty("subsidiaries.error.message");
	
	public static final String MQ_PATH_TEMPLATES = "/WEB-INF/templates";
	
    public static final String MQ_HOST = "mq.host";
	public static final String MQ_PORT = "mq.port";
	public static final String MQ_QUEUE_MANAGER = "mq.queuemanager";
	public static final String MQ_INPUT_LOCAL_QUEUE = "mq.inputlocalqueue";
	public static final String MQ_DYNAMIC_QUEUE = "mq.dynamicqueue";
	public static final String MQ_CALLHISTORY_PORT = "mq.callhistory.port";
	public static final String MQ_CALLHISTORY_QUEUE_MANAGER = "mq.callhistory.queuemanager";
	public static final String MQ_CALLHISTORY_INPUT_LOCAL_QUEUE = "mq.callhistory.inputlocalqueue";
	public static final String MQ_CALLHISTORY_DYNAMIC_QUEUE = "mq.callhistory.dynamicqueue";
	public static final String MQ_CCSID = "mq.ccsid";
	public static final String MQ_SERVER_CHANNEL = "mq.serverchannel";
	public static final String MQ_DYNAMIC_QUEUE_PREFIX = "mq.dynamicqueueprefix";
	public static final String MQ_TIMEOUT = "mq.timeout";
	public static final int MQ_DEFAULT_EAI_TIMEOUT = Integer.parseInt(PropertyUtil.getConfigProperty("mq.timeout"));
	
	public static final String FREEMARKER_PATH = "freemarker.path";
	public static final String FREEMARKER_TEMPLATE_SMS = "REGISSMS.template.xml";
	public static final String FREEMARKER_TEMPLATE_SEARCHCUST_ACCOUNT = "GETDEMOGRAPHIC_SEARCH_ACCOUNT.xml";
	public static final String FREEMARKER_TEMPLATE_SEARCHCUST_NAME = "GETDEMOGRAPHIC_SEARCH_NAME.xml";
	public static final String FREEMARKER_TEMPLATE_SEARCHCUST_ID = "GETDEMOGRAPHIC_SEARCH_ID.xml";
	public static final String FREEMARKER_TEMPLATE_SEARCHCUST_PHONE = "GETDEMOGRAPHIC_SEARCH_PHONE.xml";
	public static final String FREEMARKER_TEMPLATE_GETACCOUNT = "GETDEMOGRAPHIC_GETACCOUNT.xml";
	public static final String FREEMARKER_TEMPLATE_GETDEMOGRAPHIC = "GETDEMOGRAPHIC_GETCUSTOMER.xml";
	public static final String FREEMARKER_TEMPLATE_GETCALLHIST = "GETCALLHISTORY.xml";
	
	/*
	 * Email Configuration
	 */	
	public static final String MAIL_SMTP   = PropertyUtil.getConfigProperty("mail.smtp");
	public static final String MAIL_PORT   = PropertyUtil.getConfigProperty("mail.port");
	
	public static final String MAIL_PATH_TEMPLATES = "WEB-INF/templates/";
	
	public static String MAIL_SUBJECT_PLOAN = MAIL_PATH_TEMPLATES+"mail-subject-ploan.vm";
	public static String MAIL_TEMPLATE_PLOAN = MAIL_PATH_TEMPLATES+"mail-message-ploan.vm";
	
	public static String MAIL_SUBJECT_WEALTH = MAIL_PATH_TEMPLATES+"mail-subject-wealth.vm";
	public static String MAIL_TEMPLATE_WEALTH = MAIL_PATH_TEMPLATES+"mail-message-wealth.vm";
	
	public static String MAIL_SUBJECT_HOMELOAN = MAIL_PATH_TEMPLATES+"mail-subject-homeloan.vm";
	public static String MAIL_TEMPLATE_HOMELOAN = MAIL_PATH_TEMPLATES+"mail-message-homeloan.vm";
	
	public static String MAIL_SUBJECT_INSURANCE = MAIL_PATH_TEMPLATES+"mail-subject-insurance.vm";
	public static String MAIL_TEMPLATE_INSURANCE = MAIL_PATH_TEMPLATES+"mail-message-insurance.vm";
	
	public static String MAIL_SUBJECT_KFC = MAIL_PATH_TEMPLATES+"mail-subject-kfc.vm";
	public static String MAIL_TEMPLATE_KFC = MAIL_PATH_TEMPLATES+"mail-message-kfc.vm";
	
	public static String MAIL_SUBJECT_DEBIT = MAIL_PATH_TEMPLATES+"mail-subject-debit.vm";
	public static String MAIL_TEMPLATE_DEBIT = MAIL_PATH_TEMPLATES+"mail-message-debit.vm";
	
	public static String MAIL_SUBJECT_DIRECT_DEBIT = MAIL_PATH_TEMPLATES+"mail-subject-direct-debit.vm";
	public static String MAIL_TEMPLATE_DIRECT_DEBIT = MAIL_PATH_TEMPLATES+"mail-message-direct-debit.vm";
	
	public static final String CITIZEN_ID_CARD_TYPE = "01";
	public static final String BRANCH_CODE_PATTERN = "0000";
	public static final String CARD_NO_PATTERN = "0000000000000000";
	public static final String CUST_NO_PATTERN = "00000000000000";
	public static final String DOB_PATTERN = "yyyyMMdd";
	public static final int MAX_CALL_HISTORY = Integer.parseInt(PropertyUtil.getConfigProperty("max.contact.history"));//3 

	public static final String DOB_DISPLAY_PATTERN = "dd-MM-yyyy";
	
	public static final String RESPONSE_CODE_COMPLETE = "0000";
	public static final String RESPONSE_CODE_ERROR = "0074";
	public static final String RESPONSE_CODE_NOT_FOUND = "0077";
	public static final String RESPONSE_CODE_NOT_OPEN = "0078";
	public static final String RESPONSE_CODE_CLOSED = "0081";
	public static final String RESPONSE_CODE_EAI_EXCEPTION = "9999";
	public static final String RESPONSE_TO_HOST_EXCEPTION = "9964"; 
	
	public static final String RESPONSE_CODE_ERROR_MSG = "0074:Error";
	public static final String RESPONSE_CODE_NOT_FOUND_MSG = PropertyUtil.getMessageProperty("label.pym.global.message.notfound");
	public static final String RESPONSE_CODE_NOT_OPEN_MSG = "0078:Not open";
	public static final String RESPONSE_CODE_CLOSED_MSG = "0081:Closed";
	public static final String RESPONSE_CODE_EAI_EXCEPTION_MSG = "9999:EAI Exception ";
	public static final String RESPONSE_TO_HOST_EXCEPTION_MSG = "9964:TO HOST EXCEPTION"; 

	/*
	 * Screen constant
	 */
	public static final String DEFAULT_DATETIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
	public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
	public static final Locale SYSTEM_LOCALE = new Locale("en", "US");
	public static final String ACTIVE_STATUS = "1";
	public static final String MESSATE_TYPE_ERROR   = "-1";
	public static final String MESSATE_TYPE_SUCCESS = "1";	
	
	public static final String NOT_SELECT = "ไม่ระบุ";
	
	public static final int START_MONTH = 0; //Month range from 0 to 11
	public static final int START_YEAR = 2008;
	
	public static final String START_TIME = PropertyUtil.getConfigProperty("working.start.time");
	public static final String END_TIME = PropertyUtil.getConfigProperty("working.end.time");
	
	public static final int START_MONTH_KEY = 157;
	public static final int DEFAULT_START_SEQUENCE_VALUE = 9100001;
	
	public static final int DEFAULT_MONTH_PERIOD = Integer.parseInt(PropertyUtil.getConfigProperty("history.recent.month"));
	
	public static final String ACCOUNT_TYPE_ST = "ST";	
	public static final String ACCOUNT_TYPE_IM = "IM";
	public static final String ACCOUNT_TYPE_MF = "MF";
	
	public static final String ACCOUNT_TYPE_TD_NO = "2";
	
	public static final String PRODUCT_TYPE_DEPOSIT = PropertyUtil.getMessageProperty("label.pym.global.product.deposit");
	public static final String PRODUCT_TYPE_FUND = PropertyUtil.getMessageProperty("label.pym.global.product.fund");	
	
	public static final String ACCOUNT_TYPE_ST_DESC = PropertyUtil.getMessageProperty("label.pym.global.accountType.st");	
	public static final String ACCOUNT_TYPE_IM_DESC = PropertyUtil.getMessageProperty("label.pym.global.accountType.im");	
	public static final String ACCOUNT_TYPE_SA_DESC = PropertyUtil.getMessageProperty("label.pym.global.accountType.sa");
	public static final String ACCOUNT_TYPE_TD_DESC = PropertyUtil.getMessageProperty("label.pym.global.accountType.td");
	
	public static final String SMS_SERVICE_ACTIVE = "00";
	public static final String SMS_SERVICE_NOT_ACTIVE = "01";
	public static final String SMS_STATUS_ACTIVE = "Y";
	public static final String SMS_STATUS_NOT_ACTIVE = "X";
	public static final String SMS_STATUS_NOT_FOUND = "NOT FOUND";
	
	public static final String KMA_SMS_TRANSID = "BULK";
	public static final String KMA_SMS_CMD = "SENDMSG";
	public static final String KMA_SMS_FROM = "-Krungsri-";
	public static final String KMA_SMS_CHANNEL = "";
	public static final String KMA_SMS_REPORT = "Y";
	public static final String KMA_SMS_CHARGE = "N";
	public static final String KMA_SMS_CODE = "KRUNGSRI_BULK_Post";
	public static final String KMA_SMS_CTYPE_THAI = "UNICODE";
	public static final String KMA_SMS_CTYPE_ENG = "TEXT";
	public static final String KMA_SMS_CONTENT = PropertyUtil.getConfigProperty("kma.sms.content");;
	
	public static final String DEFAULT_CALL_CENTER_CHANNEL_VALUE = "CC";
	
	public static final String DATA_TYPE_STRING 	= "TEXT";
	public static final String DATA_TYPE_INT 		= "INTEGER";
	public static final String DATA_TYPE_DT 		= "DATETIME";
	public static final String DATE_FORMAT 			= "yyyyMMdd HHmmss";
	
	public static final String STATUS_OFFER 				= "offer";
	public static final String STATUS_NEW_OFFER 			= "newOffer";
	public static final String STATUS_SAVE_OFFER 			= "saveOffer";
	public static final String STATUS_CANCEL_OFFER 			= "cancelOffer";
	public static final String STATUS_OUT_CUSTOMER_OFFER 	= "outCustomerOffer";
	public static final String STATUS_RESPONSE_HISTORY 		= "responseHistory";
	
	//URL
	public static final String SERVLET_HTTP     = PropertyUtil.getConfigProperty("url.http");
	
	public static final String CC_SERVLET_URL   = PropertyUtil.getConfigProperty("url.csbs.ccservlet");
	public static final String KS_TICKET_URL   	= PropertyUtil.getConfigProperty("url.ks.ticket");

	public static final String CAMPAIGN_PATH   	= PropertyUtil.getConfigProperty("campaign.file.path");
	public static final String LOGO_PATH  	 	= PropertyUtil.getConfigProperty("logo.file.path");
	
	public static final String KMA_SMS_URL 		= "URL";
	public static final String KMA_SMS_THAI 	= "THAI";
	public static final String KMA_SMS_ENGLISH 	= "ENGLISH";
	
	public static final String KMA_TRANSID   	= "BULK";
	public static final String KMA_CMD   	 	= "SENDMSG";
	public static final String KMA_FROM   	 	= "-Krungsri-";
	public static final String KMA_CHANNEL   	= "511";
	public static final String KMA_REPORT    	= "Y";
	public static final String KMA_CHARGE    	= "N";
	public static final String KMA_CODE    	 	= "KRUNGSRI_BULK_Post";
	public static final String KMA_CTYPE_THAI 	= "UNICODE";
	public static final String KMA_CTYPE_ENGLISH = "TEXT";
	public static final String KMA_THAI 		 = "TH";
	public static final String KMA_ENGLISH 		 = "EN";
	
	/*
	 * Servlet Context 
	 */
	public static final String CRM_DIRECT_DEBIT_MAPPING_LIST = "CRM_DIRECT_DEBIT_MAPPING_LIST";
	public static final String CRM_COLLATERAL_LIST = "CRM_COLLATERAL_LIST";
	public static final String CRM_REQ_LOAN_AMT_LIST = "CRM_REQ_LOAN_AMT_LIST";
	public static final String CRM_RESPONSE_LIST = "CRM_RESPONSE_LIST";
	public static final String CRM_EMAIL_CONFIG_LIST = "CRM_EMAIL_CONFIG_LIST";
	public static final String CRM_OUT_CAMPAIGN_LIST = "CRM_OUT_CAMPAIGN_LIST";
	public static final String CRM_TELESALE_LIST = "CRM_TELESALE_LIST";
	public static final String CRM_PROVINCE_LIST = "CRM_PROVINCE_LIST";
	public static final String CRM_PROVINCE_MAP = "CRM_PROVINCE_MAP";
	public static final String CRM_CONTACT_PHONE_TYPE = "CRM_CONTACT_PHONE_TYPE";
	public static final String CRM_BRANCH_LIST = "CRM_BRANCH_LIST";
	
	public static final String USER_ID_PARAM_NAME = "USER_ID";
	public static final String SESSION_ID_PARAM_NAME = "SESSION_ID";
	public static final String AGENT_ID_PARAM_NAME = "agent_id";
	public static final String KS_SESSION_MAP = "KS_SESSION_MAP";
	
	
	//PYM
	public static final String PYM_PRODUCT = "PYM_PRODUCT";
	public static final String PYM_SUB_PRODUCT = "PYM_SUB_PRODUCT";
	public static final String PYM_SUB_PRODUCT_BY_PRODUCT = "PYM_SUB_PRODUCT_BY_PRODUCT";
	public static final String PYM_ADVICE_STATUS = "PYM_ADVICE_STATUS";
	public static final String PYM_ADVICE_STATUS_STATE = "PYM_ADVICE_STATUS_STATE";
	public static final String PYM_TITLE = "PYM_TITLE";
	public static final String PYM_TITLE_PERSONAL = "PYM_TITLE_PERSONAL";
	public static final String PYM_TITLE_BUSINESS = "PYM_TITLE_BUSINESS";
	public static final String PYM_TITLE_MAPPING = "PYM_TITLE_MAPPING";
	public static final String PYM_IDENTITY_TYPE = "PYM_IDENTITY_TYPE";
	public static final String PYM_USER = "PYM_USER";
	public static final String PYM_REFER_ADVICE_STATUS = "PYM_REFER_ADVICE_STATUS";
	public static final String PYM_ACTION = "PYM_ACTION";
		
	/*
	 * System Setting 
	 */
	public static final String START_LEAD_SEQUENCE = "START_LEAD_SEQUENCE";
	public static final String ENABLE_EMAIL_ALL_REPORT = "ENABLE_EMAIL_ALL_REPORT";
	public static final String ENABLE_EMAIL_BANCASSURANCE_REPORT = "ENABLE_EMAIL_BANCASSURANCE_REPORT";
	public static final String ENABLE_EMAIL_DEBITCARD_REPORT = "ENABLE_EMAIL_DEBITCARD_REPORT";
	public static final String ENABLE_EMAIL_DIRECTDEBIT_REPORT = "ENABLE_EMAIL_DIRECTDEBIT_REPORT";
	public static final String ENABLE_EMAIL_HOMELOAN_REPORT = "ENABLE_EMAIL_HOMELOAN_REPORT";
	public static final String ENABLE_EMAIL_KFC_REPORT = "ENABLE_EMAIL_KFC_REPORT";
	public static final String ENABLE_EMAIL_PLOAN_REPORT = "ENABLE_EMAIL_PLOAN_REPORT";
	public static final String ENABLE_EMAIL_WEALTH_REPORT = "ENABLE_EMAIL_WEALTH_REPORT";
	public static final String PASSWORD_ZIP_KFC = "PASSWORD_ZIP_KFC";
	public static final String SMS_BATCH_MAX_RETRY = "SMS_BATCH_MAX_RETRY";
	public static final String SMS_BATCH_RETRY_WAIT_TIME = "SMS_BATCH_RETRY_WAIT_TIME";
	public static final String SMS_PROMOTION_TYPE = "SMS_PROMOTION_TYPE";
	public static final String DO_NOT_CONTACT_MESSAGE = "DO_NOT_CONTACT_MESSAGE";
	
	/*
	 * Service Bean
	 */
	public static final String SERVICE_STATIC_DATA = "staticDataService";
	public static final String SERVICE_OFFER = "offerService";
	public static final String SERVICE_REPORT = "reportService";
	
	public static final String SERVICE_BAY_CI = "bayCIService";
	public static final String SERVICE_CALL_CENTER = "callCenterService";
	public static final String SERVICE_CSBS = "csbsService";
	public static final String SERVICE_IVR_HISTORY = "ivrHistoryViewService";
	public static final String SERVICE_LM = "lmService";
	public static final String SERVICE_SYNC = "syncService";
	public static final String SERVICE_TELESALE = "telesaleService";
	
	public static final String SERVICE_PLAN_YOUR_MONEY = "pymService";
	public static final String SERVICE_PLAN_YOUR_MONEY_KS_LOG = "pymKSLogService";
	public static final String SERVICE_PLAN_YOUR_MONEY_REPORT = "pymReportService";
	public static final String SERVICE_PLAN_YOUR_MONEY_ADMIN = "pymAdminService";
	
	public static final String ZERO1 = "0";
	public static final String ZERO2 = "00";
	
	public static final int ALL_PRODUCT_GROUP_ID = 0;
	public static final int PLOAN_PRODUCT_GROUP_ID = 1;
	public static final int WEALTH_PRODUCT_GROUP_ID = 2;
	public static final int BANCASSURANCE_PRODUCT_GROUP_ID = 3;
	public static final int HOMELOAN_PRODUCT_GROUP_ID = 4;
	public static final int KFC_PRODUCT_GROUP_ID = 5;
	public static final int DEBIT_PRODUCT_GROUP_ID = 6;
	public static final int SMS_PRODUCT_GROUP_ID = 7;
	public static final int DIRECT_DEBIT_GROUP_ID = 8;
	public static final int KMA_PRODUCT_GROUP_ID = 9;
	
	public static final String PLOAN_MAIL_STRING = "PLOAN";
	public static final String WEALTH_MAIL_STRING = "WEALTH";
	public static final String HOMELOAN_MAIL_STRING = "HOMELOAN";
	public static final String BANCASSURANCE_MAIL_STRING = "BANCASSURANCE";
	public static final String KFC_MAIL_STRING = "KFC";
	public static final String DEBIT_MAIL_STRING = "DEBITCARD";
	public static final String DIRECT_DEBIT_MAIL_STRING = "DIRECTDEBIT"; 
	
	public static final String ALL_PRODUCT_REPORT_STRING = "ALLREPORT";
	
	public static final String EMAIL_FROM = "F";
	public static final String EMAIL_TO = "T";
	public static final String EMAIL_CC = "C";
	public static final String EMAIL_BCC = "B";

	public static final String NO_DATA = "NO_DATA";
	
	public static final String LOG_PROCESS_SUCCESS = "Success";
	public static final String LOG_PROCESS_FAILED = "Failed";
	
	public static final String MQ_USERNAME = "mq.requestUserName";
	public static final String MQ_PASSWORD = "mq.requestPassword";
	
	public static final String CUST_TYPE_PERSONAL = "P";
	public static final String CUST_TYPE_PERSONAL_TH=PropertyUtil.getMessageProperty("label.pym.searchCustomerPage.custType.P");
	public static final String CUST_TYPE_BUSSINESS = "C";
	public static final String CUST_TYPE_BUSSINESS_TH=PropertyUtil.getMessageProperty("label.pym.searchCustomerPage.custType.B");
	
	public static final String SEARCH_BY_RM = "RM";
	public static final String SEARCH_BY_ADVICE_HISTORY = "AH";
	
	public static final String MODE_RM = "RM";
	public static final String MODE_AH = "AH";
	public static final String MODE_AA = "AA";
	public static final String MODE_EDIT = "E";
	public static final String MODE_RENEW = "RN";
	public static final String MODE_VIEW = "V";
	
	public static final String SEARCH_NOT_FOUND = PropertyUtil.getMessageProperty("label.pym.global.message.notfound");
	public static final String EAI_NOT_FOUND = PropertyUtil.getMessageProperty("label.pym.global.message.eai");
	public static final String FOUND_CUSTID = PropertyUtil.getMessageProperty("label.pym.global.message.custId");
	public static final String SEARCH_VALIDATE_NAME = PropertyUtil.getMessageProperty("label.pym.global.validate.name");
	public static final String SEARCH_VALIDATE_LASTNAME = PropertyUtil.getMessageProperty("label.pym.global.validate.lastname");
	public static final String SEARCH_VALIDATE_ACCOUNT_NO = PropertyUtil.getMessageProperty("label.pym.global.validate.accountNo");
	public static final String SEARCH_VALIDATE_CITIZEN_ID = PropertyUtil.getMessageProperty("label.pym.global.validate.citizenId");
	public static final String SEARCH_VALIDATE_CUST_TYPE = PropertyUtil.getMessageProperty("label.pym.global.validate.custType");
	public static final String SEARCH_VALIDATE_ALL = PropertyUtil.getMessageProperty("label.pym.global.validate.all");	
	public static final String SEARCH_VALIDATE_RM_SEARCH_CHOOSE = PropertyUtil.getMessageProperty("label.pym.global.validate.rm.choose");	
	
	public static final String PATTERN_FUND_BALANCE = "###,###,###,##0.0000"; 
	public static final String DEFAULT_FUND_BALANCE = "0.0000";
	
	//
	public static final int SEARCH_PREVIOUS = -30;
}
