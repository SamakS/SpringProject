package com.krungsri.kbs.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {
    private static Logger log = LoggerFactory.getLogger(DateUtils.class);
    public static DateFormat DB_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd", Locale.US);
    public static Locale SYSTEM_LOCALE = new Locale("en", "US");
    public static Locale USER_LOCALE = new Locale("th", "TH");
    public static String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
    public static String DEFAULT_DATETIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static String DEFAULT_DATETIME_FORMAT2 = "dd/MM/yyyy HH:mm:ss.S";
    public static String DEFAULT_DATE_CRMPOPUP_FORMAT = "dd-MM-yyyy";
    public static String DEFAULT_DATE_CRMPOPUP_FORMAT2 = "yyyy-MM-dd";
    public static String DEFAULT_DATETIME_CRMPOPUP_FORMAT = "dd-MM-yyyy HH:mm:ss";
    public static String DEFAULT_DATETIME_PYM_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
    public static String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    public static String YYYYMMDD_FORMAT = "yyyyMMdd";
    public static String YYMMDD_FORMAT = "yyMMdd";
    public static String YYMMDDHHMMSS_FORMAT = "yyMMddHHmmss";
    public static String MMDDYY_FORMAT = "MM/dd/yy";
    public static String YEAR_FORMAT = "yyyy";
    public static String MONTH_FORMAT = "MM";
    public static String DATETIME_NO_SEC = "dd/MM/yyyy HH:mm";
    private static final int DEFAULT_FROMDAY = -10;
    public static String PYM_DATE_FORMAT = "dd/MM/yyyy";//Local Thai 24 hr
    public static String PYM_DATETIME_FORMAT = "dd/MM/yyyy HH.mm";//Local Thai 24 hr
    public static String PYM_TIME_FORMAT = "HH.mm";//Local Thai 24 hr
    public static String ELASTICSEARCH_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ";
    
    /**
     * Get present date.
     * @return Present date.
     * @throws ParseException 
     */

	// verify working hour
    public static boolean isWorkingHour() throws ParseException {
    	
    	boolean workingHour = false;
    	
    	if(PropertyUtil.getConfigProperty("system.env").equalsIgnoreCase(Constants.ENV_DEV) ||
				PropertyUtil.getConfigProperty("system.env").equalsIgnoreCase(Constants.ENV_STRESS_TEST) ||
				PropertyUtil.getConfigProperty("system.env").equalsIgnoreCase(Constants.ENV_LOCAL)) {
    		workingHour = true;
    	}else{
    		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
    		Date current = sdf.parse(sdf.format(new Date()));
    		workingHour = (sdf.parse(Constants.START_TIME).compareTo(current) <= 0) && (sdf.parse(Constants.END_TIME).compareTo(current) >= 0);

    	}
    
		return workingHour;
	}
    
    public static Date getCurrentDateTimeDB()
    {
        Calendar calendar = Calendar.getInstance(SYSTEM_LOCALE);
        return calendar.getTime();
    }
    
    public static Date getCurrentDateTime()
    {
        Calendar calendar = Calendar.getInstance(SYSTEM_LOCALE);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * Get present date.
     * @return Present date except hour, minute and second.
     */
    public static Date getCurrentDate()
    {
        Calendar calendar = Calendar.getInstance(SYSTEM_LOCALE);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
    
    public static String getCurrentTime(){
    	String time = "";
    	
    	Calendar calendar = Calendar.getInstance(SYSTEM_LOCALE);
    	int hour = calendar.get(Calendar.HOUR);
    	int minute = calendar.get(Calendar.MINUTE);    	
    	
    	String sHour = "";
    	if(hour < 10){
    		sHour = "0" + hour;
    	}else{
    		sHour = String.valueOf(hour);
    	}
    	
    	String sMinute = "";
    	if(minute < 10){
    		sMinute = "0" + minute;
    	}else{
    		sMinute = String.valueOf(minute);
    	}
    	
    	time = sHour + ":" + sMinute;
    	
    	return time;
    }

    /**
     * Get present date.
     * @return Calendar of Present date except hour, minute and second.
     */
    public static Calendar getNowCalendarWithDateOnly()
    {
        Calendar calendar = Calendar.getInstance(SYSTEM_LOCALE);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar;
    }

    /**
     * Calculate total day between given date.
     * @param startDate
     * @param endDate
     * @return Total day.
     */
    public static int diffDate(Date startDate, Date endDate)
    {
        int difInDays = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60L * 24));
        log.debug("OUT:diffDate: " + difInDays);
        return difInDays;
    }

    /**
     * @param startDate
     * @param num
     * @return
     */
    public static Date addYear(Date startDate, int num)
    {
        Calendar cal = Calendar.getInstance(SYSTEM_LOCALE);
        cal.setTime(startDate);
        cal.add(Calendar.YEAR, num);
        return cal.getTime();
    }

    /**
     * @param startDate
     * @param num
     * @return
     */
    public static Date addMonth(Date startDate, int num)
    {
        Calendar cal = Calendar.getInstance(SYSTEM_LOCALE);
        cal.setTime(startDate);
        cal.add(Calendar.MONTH, num);
        return cal.getTime();
    }

    /**
     *
     * @param startDate
     * @param num
     * @return
     */
    public static Date addDate(Date startDate, int num)
    {
        Calendar cal = Calendar.getInstance(SYSTEM_LOCALE);
        cal.setTime(startDate);
        cal.add(Calendar.DATE, num);
        return cal.getTime();
    }

    /**
     *  Format string Date to Date
     * @param dateStr
     *            The date string parameter want to convert to Date จาก dd/MM/yyyy
     * @return Date after convert
     */
    public static Date formatDateStrToDate(String dateStr)
            throws Exception
    {

        if (StringUtils.isBlank(dateStr))
        {
            return null;
        }

        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT, SYSTEM_LOCALE);
        try
        {
            date = dateFormat.parse(dateStr);
        } catch (Exception e)
        {
            date = null;
            throw e;
        }
        return date;
    }
    
    /**
     * 
     * @param dateStr
     * @return DateTime
     * @throws Exception
     */
    public static Date formatDateTimeStrToDateTimeNoSec(String dateStr)
            throws Exception
    {

        if (StringUtils.isBlank(dateStr))
        {
            return null;
        }

        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATETIME_NO_SEC, SYSTEM_LOCALE);
        try
        {
            date = dateFormat.parse(dateStr.trim());
        } catch (Exception e)
        {
            date = null;
            throw e;
        }
        return date;
    }
    
    public static Date formatDateTimeStrToDateTime(String dateStr) throws Exception {

		if (StringUtils.isBlank(dateStr)) {
			return null;
		}

		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT,
				SYSTEM_LOCALE);
		try {
			date = dateFormat.parse(dateStr);
		} catch (Exception e) {
			date = null;
			throw e;
		}
		return date;
	}
    
    /**
     * 
     * @param dateStr dd-MM-yyyy
     * @return date
     * @throws Exception
     */
    public static Date formatDateStrToDateDash(String dateStr)
            throws Exception
    {

        if (StringUtils.isBlank(dateStr))
        {
            return null;
        }

        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_CRMPOPUP_FORMAT, SYSTEM_LOCALE);
        try
        {
            date = dateFormat.parse(dateStr);
        } catch (Exception e)
        {
            date = null;
            throw e;
        }
        return date;
    }

    /**
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date)
    {
        return dateToString(date, DEFAULT_DATE_FORMAT, SYSTEM_LOCALE);
    }
    
    public static String date4Log()
    {
        return dateToString(getCurrentDateTime(), YYMMDDHHMMSS_FORMAT, SYSTEM_LOCALE);
    }
    
    /**
     * 
     * @param date
     * @return
     */
    public static String dateTimeToStringNoSec(Date date)
    {
        return dateToString(date, DATETIME_NO_SEC, SYSTEM_LOCALE);
    }

    /**
     *
     * @param thisdate
     * @param format
     * @param locale
     * @return
     */
    public static String dateToString(java.util.Date thisdate, String format, java.util.Locale locale)
    {
        if (thisdate != null)
        {
            SimpleDateFormat sf = new SimpleDateFormat(format, locale);
            return (String) sf.format(thisdate);
        } else
        {
            return "";
        }
    }
    
    /**
     * ขอข้อมูลวันที่ปัจจุบันในรูปแบบตาม dd/MM/yyyy
     * <p>
     * @return String of current date
     */
    public static String getDefaultFromDate()
    {
        return DateUtils.dateToString(addDate(getCurrentDate(),DEFAULT_FROMDAY), DEFAULT_DATE_FORMAT, SYSTEM_LOCALE);
    }
    
    /**
     * ขอข้อมูลวันที่ปัจจุบันในรูปแบบตาม dd/MM/yyyy
     * <p>
     * @return String of current date
     */
    public static String getDefaultToDate()
    {
        return DateUtils.dateToString(getCurrentDate(), DEFAULT_DATE_FORMAT, SYSTEM_LOCALE);
    }
    /**
     * ขอข้อมูลวันที่ปัจจุบันในรูปแบบตาม dd/MM/yyyy H:mm
     * <p>
     * @return String of current date
     */
    public static String getDefaultToDateTimeNoSec()
    {
        return DateUtils.dateToString(getCurrentDateTime(), DATETIME_NO_SEC, SYSTEM_LOCALE);
    }
    /**
     * ขอข้อมูลวันที่ปัจจุบันในรูปแบบตาม dd-MM-yyyy
     * <p>
     * @return String of current date
     */
    public static String getCurrentCrmPopupDateStr()
    {
    	
        return DateUtils.dateToString(getCurrentDate(), DEFAULT_DATE_CRMPOPUP_FORMAT, SYSTEM_LOCALE);
    }
    
    /**
     * ขอข้อมูลวันที่ปัจจุบันในรูปแบบตาม dd-MM-yyyy
     * <p>
     * @return String of current date
     */
    public static Date getCrmPopupDate(Date date)
    {
    	//System.out.println("date : " + date);
    	Calendar calendar = Calendar.getInstance(Locale.US);
    	calendar.setTime(date);
    	//System.out.println("calendar year : " + calendar.get(Calendar.YEAR));
    	
    	calendar.setTime(date);
    	//System.out.println("calendar year2 : " + calendar.get(Calendar.YEAR));
    	Date result = null;
    	try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_CRMPOPUP_FORMAT, SYSTEM_LOCALE);
            SimpleDateFormat dateFormat2 = new SimpleDateFormat(DEFAULT_DATETIME_CRMPOPUP_FORMAT, SYSTEM_LOCALE);
            result = dateFormat.parse(dateFormat2.format(calendar.getTime()));
            //System.out.println("result date : " + result);
		} catch (Exception e) {
			result = null;
		}
    	return result;
    }
    
    /**
     * ขอข้อมูลวันที่ปัจจุบันในรูปแบบตาม          dd-MM-yyyy HH:mm:ss
     * <p>
     * @return String of current date
     */
    public static Date getCrmPopupDateTime(Date date)
    {
    	//System.out.println("date : " + date);
    	Calendar calendar = Calendar.getInstance(Locale.US);
    	calendar.setTime(date);
    	//System.out.println("calendar year : " + calendar.get(Calendar.YEAR));
    	
    	calendar.setTime(date);
    	//System.out.println("calendar year2 : " + calendar.get(Calendar.YEAR));
    	Date result = null;
    	try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATETIME_CRMPOPUP_FORMAT, SYSTEM_LOCALE);
            SimpleDateFormat dateFormat2 = new SimpleDateFormat(DEFAULT_DATETIME_CRMPOPUP_FORMAT, SYSTEM_LOCALE);
            result = dateFormat.parse(dateFormat2.format(calendar.getTime()));
            //System.out.println("result date : " + result);
		} catch (Exception e) {
			result = null;
		}
    	return result;
    }
    
    /**
     * ขอข้อมูลวันที่ปัจจุบันในรูปแบบตาม dd-MM-yyyy
     * <p>
     * @return String of current date
     */
    public static String getCurrentCrmPopupDateTimeStr()
    {
        return DateUtils.dateToString(getCurrentDateTime(), DEFAULT_DATETIME_CRMPOPUP_FORMAT, SYSTEM_LOCALE);
    }
    

    /**
     * ขอข้อมูลวันที่ปัจจุบันในรูปแบบตาม dd/MM/yyyy HH:mm:ss
     * <p>
     * @return String of current date
     */
    public static String getCurrentDateTimeStr()
    {
        return DateUtils.dateToString(getCurrentDateTime(), DEFAULT_DATETIME_CRMPOPUP_FORMAT, SYSTEM_LOCALE);
    }

    /**
     * ขอข้อมูลวันที่ปัจจุบันในรูปแบบตาม dd/MM/yyyy HH:mm:ss แบบ พ.ศ.
     * <p>
     * @return String of current date
     */
    public static String getCurrentDateTimeBEStr()
    {
        return DateUtils.dateToString(getCurrentDateTime(), DEFAULT_DATETIME_FORMAT, USER_LOCALE);
    }

    /**
     * เปลี่ยนรูปแบบปี จากคริสต์ศักราช(ค.ศ.) เป็นพุทธศักราช(พ.ศ.)
     *  <p>
     * @param ad :  String format 'dd/mm/yyyy' (yyyy is A.D.)
     * @return String format 'dd/mm/yyyy' (yyyy is B.E.)
     */
    public static String toBE(String ad)
    {
        String be = ad;
        if (StringUtils.isNotBlank(ad))
        {
        	if(Integer.parseInt(ad.substring(6, 10)) < 2300){
        		be = ad.substring(0, 6) + (Integer.parseInt(ad.substring(6, 10)) + 543) + (ad.length() > 10 ? ad.substring(10) : "");
        	}
            
        }

        return be;
    }

    /**
     * เปลี่ยนรูปแบบปี จากพุทธศักราช(พ.ศ.) เป็นคริสต์ศักราช(ค.ศ.)
     *  <p>
     * @param be : String format 'dd/mm/yyyy' (yyyy is B.E.)
     * @return String format 'dd/mm/yyyy' (yyyy is A.D.)
     */
    public static String toAD(String be)
    {
        String ad = be;

        if (StringUtils.isNotBlank(be))
        {
        	if(Integer.parseInt(ad.substring(6, 10)) > 2300){
        		ad = be.substring(0, 6) + (Integer.parseInt(be.substring(6, 10)) - 543) + (be.length() > 10 ? be.substring(10) : "");
        	}
            
        }

        return ad;
    }

    /**
     * กำหนด Pattern ของ date time สำหรับการค้นหา format date time
     * @return list ของ properties ที่จัดเก็บ key   : format date time
     *                                   value : pattern date time
     */
    public static List<Properties> getPatternDateTime()
    {
        List<Properties> pList = new ArrayList<Properties>();
        Properties prop = new Properties();
        prop.setProperty("yyyy-MM-dd", "([0-9][0-9][0-9][0-9])-(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01])|([0-9][0-9][0-9][0-9])-(0[469]|1[1])-(0[1-9]|[12][0-9]|3[0])|([0-9]{4})-(02)-(0[1-9]|1[0-9]|2[0-9])");
        pList.add(prop);
        prop.setProperty("dd-MM-yyyy", "(0[1-9]|[12][0-9]|3[01])-(0[13578]|1[02])-([0-9][0-9][0-9][0-9])|(0[1-9]|[12][0-9]|3[0])-(0[469]|1[1])-([0-9][0-9][0-9][0-9])|(0[1-9]|1[0-9]|2[0-9])-(02)-([0-9]{4})");
        pList.add(prop);
        prop.setProperty("MM-dd-yyyy", "(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01])-([0-9][0-9][0-9][0-9])|(0[469]|1[1])-(0[1-9]|[12][0-9]|3[0])-([0-9][0-9][0-9][0-9])|(02)-(0[1-9]|1[0-9]|2[0-9])-([0-9]{4})");
        pList.add(prop);
        prop.setProperty("yyyy/MM/dd", "([0-9][0-9][0-9][0-9])/(0[13578]|1[02])/(0[1-9]|[12][0-9]|3[01])|([0-9][0-9][0-9][0-9])/(0[469]|1[1])/(0[1-9]|[12][0-9]|3[0])|([0-9]{4})/(02)/(0[1-9]|1[0-9]|2[0-9])");
        pList.add(prop);
        prop.setProperty("dd/MM/yyyy", "(0[1-9]|[12][0-9]|3[01])/(0[13578]|1[02])/([0-9][0-9][0-9][0-9])|(0[1-9]|[12][0-9]|3[0])/(0[469]|1[1])/([0-9][0-9][0-9][0-9])|(0[1-9]|1[0-9]|2[0-9])/(02)/([0-9]{4})");
        pList.add(prop);
        prop.setProperty("MM/dd/yyyy", "(0[13578]|1[02])/(0[1-9]|[12][0-9]|3[01])/([0-9][0-9][0-9][0-9])|(0[469]|1[1])/(0[1-9]|[12][0-9]|3[0])/([0-9][0-9][0-9][0-9])|(02)/(0[1-9]|1[0-9]|2[0-9])/([0-9]{4})");
        pList.add(prop);
        prop.setProperty("yyyy-MM-dd hh:mm", "([0-9][0-9][0-9][0-9])-(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])|([0-9][0-9][0-9][0-9])-(0[469]|1[1])-(0[1-9]|[12][0-9]|3[0]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])|([0-9]{4})-(02)-(0[1-9]|1[0-9]|2[0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])");
        pList.add(prop);
        prop.setProperty("dd-MM-yyyy hh:mm", "(0[1-9]|[12][0-9]|3[01])-(0[13578]|1[02])-([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])|(0[1-9]|[12][0-9]|3[0])-(0[469]|1[1])-([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])|(0[1-9]|1[0-9]|2[0-9])-(02)-([0-9]{4}) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])");
        pList.add(prop);
        prop.setProperty("MM-dd-yyyy hh:mm", "(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01])-([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])|(0[469]|1[1])-(0[1-9]|[12][0-9]|3[0])-([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])|(02)-(0[1-9]|1[0-9]|2[0-9])-([0-9]{4}) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])");
        pList.add(prop);
        prop.setProperty("yyyy/MM/dd hh:mm", "([0-9][0-9][0-9][0-9])/(0[13578]|1[02])/(0[1-9]|[12][0-9]|3[01]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])|([0-9][0-9][0-9][0-9])/(0[469]|1[1])/(0[1-9]|[12][0-9]|3[0]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])|([0-9]{4})/(02)/(0[1-9]|1[0-9]|2[0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])");
        pList.add(prop);
        prop.setProperty("dd/MM/yyyy hh:mm", "(0[1-9]|[12][0-9]|3[01])/(0[13578]|1[02])/([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])|(0[1-9]|[12][0-9]|3[0])/(0[469]|1[1])/([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])|(0[1-9]|1[0-9]|2[0-9])/(02)/([0-9]{4}) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])");
        pList.add(prop);
        prop.setProperty("MM/dd/yyyy hh:mm", "(0[13578]|1[02])/(0[1-9]|[12][0-9]|3[01])/([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])|(0[469]|1[1])/(0[1-9]|[12][0-9]|3[0])/([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])|(02)/(0[1-9]|1[0-9]|2[0-9])/([0-9]{4}) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9])");
        pList.add(prop);
        prop.setProperty("yyyy-MM-dd hh:mm:ss", "([0-9][0-9][0-9][0-9])-(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])|([0-9][0-9][0-9][0-9])-(0[469]|1[1])-(0[1-9]|[12][0-9]|3[0]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])|([0-9]{4})-(02)-(0[1-9]|1[0-9]|2[0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])");
        pList.add(prop);
        prop.setProperty("dd-MM-yyyy hh:mm:ss", "(0[1-9]|[12][0-9]|3[01])-(0[13578]|1[02])-([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])|(0[1-9]|[12][0-9]|3[0])-(0[469]|1[1])-([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])|(0[1-9]|1[0-9]|2[0-9])-(02)-([0-9]{4}) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])");
        pList.add(prop);
        prop.setProperty("MM-dd-yyyy hh:mm:ss", "(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01])-([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])|(0[469]|1[1])-(0[1-9]|[12][0-9]|3[0])-([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])|(02)-(0[1-9]|1[0-9]|2[0-9])-([0-9]{4}) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])");
        pList.add(prop);
        prop.setProperty("yyyy/MM/dd hh:mm:ss", "([0-9][0-9][0-9][0-9])/(0[13578]|1[02])/(0[1-9]|[12][0-9]|3[01]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])|([0-9][0-9][0-9][0-9])/(0[469]|1[1])/(0[1-9]|[12][0-9]|3[0]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])|([0-9]{4})/(02)/(0[1-9]|1[0-9]|2[0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])");
        pList.add(prop);
        prop.setProperty("dd/MM/yyyy hh:mm:ss", "(0[1-9]|[12][0-9]|3[01])/(0[13578]|1[02])/([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])|(0[1-9]|[12][0-9]|3[0])/(0[469]|1[1])/([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])|(0[1-9]|1[0-9]|2[0-9])/(02)/([0-9]{4}) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])");
        pList.add(prop);
        prop.setProperty("MM/dd/yyyy hh:mm:ss", "(0[13578]|1[02])/(0[1-9]|[12][0-9]|3[01])/([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])|(0[469]|1[1])/(0[1-9]|[12][0-9]|3[0])/([0-9][0-9][0-9][0-9]) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])|(02)/(0[1-9]|1[0-9]|2[0-9])/([0-9]{4}) ([0-1]?[0-9]|2[0-3]):([0-5]?[0-9]):([0-5]?[0-9])");
        pList.add(prop);
        prop.setProperty("ddMMyyyy", "(0[1-9]|[12][0-9]|3[01])(0[13578]|1[02])([0-9][0-9][0-9][0-9])|(0[1-9]|[12][0-9]|3[0])(0[469]|1[1])([0-9][0-9][0-9][0-9])|(0[1-9]|1[0-9]|2[0-9])(02)([0-9]{4})");
        pList.add(prop);
        return pList;
    }

    /**
     * ค้นหา format ของ date time จากข้อมูลวันที่ และ เวลาที่ส่งเข้ามาตรวจสอบ
     * @param patternList : รับข้อมูล Pattern จาก getPatternDateTime method
     * @param date : ข้อมูลวันที่ และ เวลาที่ส่งเข้ามาตรวจสอบ
     * @return format ของ date time
     *         ถ้าคืนค่าเป็นว่างไป แสดงว่าไม่พบ format date time
     */
    public static String getFormatDateTime(List<Properties> patternList, String date)
    {
        String[] formats =
        {
            "yyyy-MM-dd", "dd-MM-yyyy", "MM-dd-yyyy",
            "yyyy/MM/dd", "dd/MM/yyyy", "MM/dd/yyyy",
            "yyyy-MM-dd hh:mm", "dd-MM-yyyy hh:mm", "MM-dd-yyyy hh:mm",
            "yyyy/MM/dd hh:mm", "dd/MM/yyyy hh:mm", "MM/dd/yyyy hh:mm",
            "yyyy-MM-dd hh:mm:ss", "dd-MM-yyyy hh:mm:ss", "MM-dd-yyyy hh:mm:ss",
            "yyyy/MM/dd hh:mm:ss", "dd/MM/yyyy hh:mm:ss", "MM/dd/yyyy hh:mm:ss",
            "ddMMyyyy"
        };
        String format = "";
        int i = 0;
        //Util.debug("Found : " + date.indexOf("1900/01/01"));
        if (date.indexOf("1900/01/01") < 0 && date.indexOf("1900-01-01") < 0 && date.indexOf("01/01/1900") < 0 && date.indexOf("01-01-1900") < 0 && date.indexOf("01011900") < 0)
        {
            for (Properties prop : patternList)
            {
                Pattern datePatt = Pattern.compile(prop.getProperty(formats[i]));
                Matcher matcher = datePatt.matcher(date);
                if (matcher.matches())
                {
                    format = formats[i];
                    break;
                }
                i++;
            }
        }
        return format;
    }

    /**
     *
     * @param date
     * @return
     */
    public static String toDocumentumDate(String date)
    {
        if (CommonUtils.isNotBlank(date))
        {
            String dateSplit[] = date.split("/");
            
            if (Integer.parseInt(dateSplit[2]) < 2500)
            {
            	date = new StringBuffer().append(dateSplit[0]).append("/").append(dateSplit[1]).append("/").append((Integer.parseInt(dateSplit[2]) + 543)).toString();
            } else
            {
            	date = new StringBuffer().append(dateSplit[0]).append("/").append(dateSplit[1]).append("/").append(dateSplit[2]).toString();
            }

        }

        return date;
    }

    public static Date dateDiff(Date startDate, Date endDate)
    {

        return new Date(endDate.getTime() - startDate.getTime());
    }
    
    public static Date toAD(String field, Map<String, Object> row) throws Exception{
    	
    	if(row.get(field) == null){
    		return null;
    	}
    	
		Date date = new Date();
		if(DateUtils.diffDate(DateUtils.formatDateStrToDate("01/01/1900"),(Date)row.get(field)) < 0){
			date = DateUtils.addYear((Date)row.get(field), 543);
		}else{
			date = (Date)row.get(field);
		}
		
		return date;
	}
    
    public static Date toAD(Date date) throws Exception{
    	
    	if(date == null){
    		return null;
    	}
    	
		Date adDate = new Date();
		if(DateUtils.diffDate(DateUtils.formatDateStrToDate("01/01/1900"),date) < 0){
			adDate = DateUtils.addYear(date, 543);
		}else{
			adDate = date;
		}
		
		return adDate;
	}
    
    public static boolean checkFormatDateReport(String date){	
    	String pattern = "(0[1-9]|[12][0-9]|3[01])(0[13578]|1[02])([0-9][0-9][0-9][0-9])|(0[1-9]|[12][0-9]|3[0])(0[469]|1[1])([0-9][0-9][0-9][0-9])|(0[1-9]|1[0-9]|2[0-9])(02)([0-9]{4})";
    	
    	Pattern datePatt = Pattern.compile(pattern);
    	Matcher matcher = datePatt.matcher(date);
        if (matcher.matches())
        {
            return true;
        }
        return false;
    }
    
    public static Date changeFormatDate(String date) throws Exception{
    	
    	String sDate = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 8);
    	return formatDateStrToDate(sDate);
    }
    
    public static String changeFormatEAIDate(String date){
    	if(CommonUtils.isBlank(date) || date.length() < 8 || date.equals("00000000")){
    		return "";
    	}
    	
    	String year = date.substring(0,4);
    	if(Integer.parseInt(year) < 2500){
    		return date.substring(6,8) + "-" + date.substring(4,6) + "-" + (Integer.parseInt(year) + 543);
    	}else{
    		return date.substring(6,8) + "-" + date.substring(4,6) + "-" + year;
    	}
    }
    
	public static String dateToString(Date date, String format) {
		String result = null;
		if(date != null){
			SimpleDateFormat dateFormat = getSimpleDate(format);
			result = dateFormat.format(date);
		}
		return result;
	}
	
	public static Date stringToDate(String dateStr, String format)
			throws ParseException {
		SimpleDateFormat dateFormat = getSimpleDate(format);
		return dateFormat.parse(dateStr);
	}

	public static Date stringToDate(String dateStr, String format, Locale locale)
			throws ParseException {
		SimpleDateFormat dateFormat = getSimpleDate(format, locale);
		return dateFormat.parse(dateStr);
	}
	
	public static Date elasticsearchDateTime2utilsDate(String dateStr){
		DateTimeFormatter formatter = DateTimeFormat.forPattern(DateUtils.ELASTICSEARCH_DATETIME_FORMAT);
		DateTime dateTime = formatter.parseDateTime(dateStr);
    	Date date = dateTime.toDate();
    	return date;
	}		
	
	private static SimpleDateFormat getSimpleDate(String format) {
		return new SimpleDateFormat(format);
	}
	
	private static SimpleDateFormat getSimpleDate(String format, Locale locale) {
		return new SimpleDateFormat(format, locale);
	}
	
	public static String convertLongToDateFormat(long dateLong){
    	long millisecond = ((dateLong - ((dateLong / 1000)* 1000)));
    	long second = (dateLong / 1000) % 60;
    	long minute = (dateLong / (1000 * 60)) % 60;
    	long hour = (dateLong / (1000 * 60 * 60)) % 24;
    	long day = (dateLong / (1000 * 60 * 60 * 24));

    	String time = "";
    	if(day > 0){
    		time = String.format("%02d day : %02d hour :%02d minute :%02d second :%d milli second",day ,hour, minute, second, millisecond);
    	}else if(hour > 0){
    		time = String.format("%02d hour :%02d minute :%02d second :%d milli second" ,hour, minute, second, millisecond);
    	}else if(minute > 0){
    		time = String.format("%02d minute :%02d second :%d milli second" , minute, second, millisecond);
    	}else if(second > 0){
    		time = String.format("%02d second :%d milli second" , second, millisecond);
    	}else if(millisecond > 0){
    		time = String.format("%d milli second" , millisecond);
    	}
    	return time;
    }
      
    public static void main(String[] args) throws Exception{
    	//1982-04-09 14:35:47.0
//    	
//    	String test = "1982-04-09 14:35:47.0";
//    	String[] day = StringUtils.split(test," ");
//    	System.out.println("day : " + day[0]);
//    	
//    	String test2 = "1982-04-09";
//    	String[] day2 = StringUtils.split(test2," ");
//    	System.out.println("day : " + day2[0]);
//    	
//		Date date2  = stringToDate(day[0], DateUtils.DEFAULT_DATE_CRMPOPUP_FORMAT2);
//    	String sDate2 = DateUtils.toBE(DateUtils.dateToString(date2, DateUtils.DEFAULT_DATE_FORMAT));
//		System.out.println("dateLog : " + date2 + "|" +sDate2);    	
    	
    	//Date d = stringToDate(dt, "yyyy-MM-dd HH:mm:ss", SYSTEM_LOCALE);
    	//System.out.println(dateTime);
    	//System.out.println(date);
    }
}
