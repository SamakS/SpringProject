package com.krungsri.kbs.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class CommonUtils {
	public CommonUtils() {

	}
	
	public static String concatStackTrace(Exception ex)
    {
        String[] st = ExceptionUtils.getRootCauseStackTrace(ex);

        StringBuffer errorMsg = new StringBuffer("");
        for (int i = 0; i < st.length; i++)
        {
            errorMsg.append(st[i].toString());
            errorMsg.append(" ");
        }

        return errorMsg.toString();
    }

    /**
     * 
     * @param val
     * @param replaces
     * @param defaultValue
     * @return
     */
    public static String replaceAllWithDefaultVal(String val, String[] replaces, String defaultValue)
    {
        if (StringUtils.isNotBlank(val))
        {
            for (int i = 0; i < replaces.length; i++)
            {
                val = val.replaceAll(replaces[i], val);
            }

            return val;

        } else
        {
            return defaultValue;
        }
    }

    /**
     * To convert message character set from ISO8859_1 to UTF-8<br>
     * เปลี่ยน encoding ของข้อความจาก ISO8859_1 เป็น UTF-8
     * <p>
     * @param ori : input String character encode with ISO8859_1
     * @return String character encode with UTF-8
     * @throws java.lang.Exception
     */
    public static String toThai(String ori)
            throws Exception
    {
    	if (ori == null) return null;
        return new String(ori.getBytes("ISO8859_1"), "UTF-8");
    }

    /**
     * ตรวจสอบ format ของ text ว่าเป็น format ตัวเลขหรือไม่
     * <p>
     * @param text : ข้อความที่ต้องการตรวจสอบ
     * @return คืนค่าเป็น true สำหรับ format ที่ถูกต้อง
     *        คืนค่าเป็น false สำหรับ format ที่ไม่ถูกต้อง
     */
    public static boolean isFormatNumber(Object val)
    {
    	if(val == null){
    		return false;
    	}
    	
        return StringUtils.isNumeric(val.toString());
    }

    /**
     * เป็น  Method ที่ใช้ตรวจสอบค่าเป็น String ว่าเป็น Double หรือไม่
     * @param value Data Type เป็น  String
     * @return revalued Data Type เป็น  boolean
     */
    public static boolean isDouble(String textValue)
    {
        boolean isDouble;
        try
        {
            Double.parseDouble(textValue);
            isDouble = false;

        } catch (NumberFormatException e)
        {
            isDouble = false;
        }

        return isDouble;
    }


    /**
     * เป็น Method ที่ใช้ตรวจสอบค่าเป็น Null หรือเปล่า checkNull
     * และทำการ replace " และ \n ที่จะไปแสดงที่ JSON
     * @param value Data Type เป็น  String
     * @return revalued Data Type เป็น  String
     */
    public static String checkNull(String value)
    {
        String revalue = "";

        if (isNotBlank(value))
        {
            value = value.replaceAll("\"", "");
            value = value.replaceAll("\n", "");
            revalue = value;
        }

        return revalue;
    }

    /**
     * 
     * @param val
     * @return
     */
    public static boolean isNotBlank(Object val)
    {
    	return !isBlank(val);
    }

    public static boolean isBlank(Object val)
    {
    	if(val == null)return true;
    	
    	if( val instanceof String){
    		
	        if (StringUtils.equals(val.toString(), "null"))
	        {
	            return true;
	        }
    		
	        if (StringUtils.isBlank(val.toString())){
	        	return true;
	        }
    	}
    	
    	return false;
    }
    
    public static Long toLong(String val){
    	
    	if(isBlank(val))return null;
    	
    	return Long.valueOf(val);
    }
    
    public static Integer toInteger(String val){
    	
    	if(isBlank(val))return null;
    	
    	return Integer.valueOf(val);
    }
    
    public static Date toDate(String val) throws Exception{
    	
    	if(isBlank(val))return null;
    	
    	SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DEFAULT_DATE_FORMAT,DateUtils.SYSTEM_LOCALE);
    	try {
			return sdf.parse(val);
		} catch (ParseException e) {
			throw new Exception(PropertyUtil.getMessageProperty("error.date"));
		}
    }
    
    public static String toStringDate(Object val,String format){
    	
    	if(isBlank(val))return "";
    
    	if( val instanceof Date){
    		
    		try {
				return DateUtils.dateToString(DateUtils.toAD((Date)val),format, DateUtils.SYSTEM_LOCALE);
			} catch (Exception e) {
				return null;
			}
    	}
    	
    	return null;
    
    }
    
    public static String toString(Object val){
    	
    	if(isBlank(val))return "";
    	
    	if( val instanceof String){
    		return val.toString();
    	}
    	
    	if( val instanceof Long || val instanceof Integer){
    		return val.toString();
    	}
    	
    	if( val instanceof Date){
    		try {
				return toStringDate(val, DateUtils.DEFAULT_DATETIME_FORMAT);
			} catch (Exception e) {
				
				return "";
			}
    	}
    	
    	//another case
    	return val.toString();
    }
    
    public static String addDbQuote(String data){
    	if(isNotBlank(data)){
    		data = "\"\'"+ StringUtils.replaceChars(data, '"', '\"') +"\"";
    	}else{
    		data = "\"" + data + "\"";
    	}
    	
    	return data; 
    }
    
	public static String getErrorMessage(Exception e){
		Throwable  cause = e.getCause();
		
		return (cause == null?e.getMessage():cause.getMessage());
	}
	
	public static String formatCurrency(String value, String pattern){
		DecimalFormat formatter = new DecimalFormat(pattern);
		BigDecimal number = new BigDecimal(value);		
		return formatter.format(number);
	}
	
	public static void main(String[] args){
		String pattern = "###,###,###,###.0000";
		System.out.println(formatCurrency("25.8641", pattern));
		System.out.println(formatCurrency("6346.7596", pattern));
		System.out.println(formatCurrency("1009461.0100", pattern));
	}
}
