package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static DateFormat dateFormat;

	public static String getFullDateAndTime() {
		Date currentDate = new Date();
		dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
		return dateFormat.format(currentDate);
	}
	
	public static String getDateAndTime() {
		Date currentDate = new Date();
		dateFormat = new SimpleDateFormat("YYYYMMddHHmm");
		return dateFormat.format(currentDate);
	}
	
	public static String getShortDateAndTime() {
		Date currentDate = new Date();
		dateFormat = new SimpleDateFormat("YYMMddHHmm");
		return dateFormat.format(currentDate);
	}
	
	public static String getDateFormat203(){     //20150116:1036
		Date currentDate = new Date();
		dateFormat = new SimpleDateFormat("YYYYMMdd:HHmm");
		return dateFormat.format(currentDate);	
	} 
	

	public static String getDateFormat102(){     //20160115
		Date currentDate = new Date();
		dateFormat = new SimpleDateFormat("YYYYMMdd");
		return dateFormat.format(currentDate);	
	} 
}
