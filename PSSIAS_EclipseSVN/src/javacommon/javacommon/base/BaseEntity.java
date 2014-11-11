package javacommon.base;


//静态导入日期转换方法
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import cn.org.rapid_framework.util.DateConvertUtils;

/**
 * @author badqiu
 */
public class BaseEntity implements java.io.Serializable {
	
	protected static final String DATE_FORMAT = "yyyy-MM-dd";
	
	protected static final String TIME_FORMAT = "HH:mm:ss";
	
	protected static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	protected static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	
	public static String date2String(java.util.Date date,String dateFormat) {
		return DateConvertUtils.format(date,dateFormat);
	}
	
	public static <T extends java.util.Date> T string2Date(String dateString,String dateFormat,Class<T> targetResultType) {
		return DateConvertUtils.parse(dateString,dateFormat,targetResultType);
	}
	
	
	 public final static java.sql.Date string2Date(String dateString,
				String dateFormatString) {
			try {
				DateFormat dateFormat;
				dateFormat = new SimpleDateFormat(dateFormatString);
				dateFormat.setLenient(false);
				java.util.Date timeDate = dateFormat.parse(dateString);// util类型
				java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());// sql类型
				return dateTime;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	
	
	
	
//	/**
//	  *method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
//	  *@param dateString 需要转换为timestamp的字符串
//	  *@return dataTime timestamp
//	  */
//	 public final static java.sql.Timestamp string2Time(String dateString) 
//	  throws java.text.ParseException {
//	   DateFormat dateFormat;
//	  dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS", Locale.ENGLISH);//设定格式
//	  //dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss", Locale.ENGLISH);
//	  dateFormat.setLenient(false);
//	  java.util.Date timeDate = dateFormat.parse(dateString);//util类型
//	  java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());//Timestamp类型,timeDate.getTime()返回一个long型
//	  return dateTime;
//	 }
//	 /**
//	  *method 将字符串类型的日期转换为一个Date（java.sql.Date）
//	  *@param dateString 需要转换为Date的字符串
//	  *@return dataTime Date
//	  */
//	 public final static java.sql.Date string2Date(String dateString)
//	  throws java.lang.Exception {
//	  DateFormat dateFormat;
//	  dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//	  dateFormat.setLenient(false);
//	  java.util.Date timeDate = dateFormat.parse(dateString);//util类型
//	  java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());//sql类型
//	  return dateTime;
//	 }
}
