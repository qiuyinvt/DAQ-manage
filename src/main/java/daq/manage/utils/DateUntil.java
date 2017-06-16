package daq.manage.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUntil {
	  public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
	  public static final String DATE_FORMAT_YMD = "yyyy-MM-dd";
	//  private static final Log logger = LogFactory.getLog(DateUtil.class);


	  public static final String SIMPLE_FORMAT = "yyyy-MM-dd";
	  public static final String SIMPLE_FORMAT_YYYYMMDD = "yyyyMMdd";
	  public static final String SIMPLE_FORMAT_YYYY_MM = "yyyy-MM";
	  public static final String SIMPLE_FORMAT2 = "yyyy-MM-dd";
	  public static final String NORMAL_FORMAT = "yyyy-MM-dd HH:mm:ss";
	  public static final String NORMAL_FORMAT1 = "yyyy/MM/dd HH:mm:ss";
	  public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	  public static final String TIME_FORMAT = "HH:mm:ss";
	  public static final String NOT_FORMAT = "yyyyMMddHHmmss";
	  public static final String NOT_SS = "yyyy-MM-dd HH:mm";

	/**
	 * 获取多少分钟前或后的时间
	 * @param date
	 * @param min
	 * @param isBefore
	 * @return
	 */
	public static Date DateMinute(Date date,int min,Boolean isBefore) {
		Long timestamp=date.getTime();
		if(isBefore)
		{
			timestamp -= min * 60 * 1000;
		}else
		{
			timestamp += min * 60 * 1000;
		}
		return new Date(timestamp);
	}
	/**
	 * 时间转str
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date ,String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	
	public static Date str2Date(String str ,String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date=null;
		try {
			date = dateFormat.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
      //  System.out.println(dateFormat.format(DateMinute(new Date(),20,false)));
	}
}
