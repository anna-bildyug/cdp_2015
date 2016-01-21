package com.epam.by.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static DateFormat dateFormat;

	public static String getFullDateRestrictedYear() { // 150115103600
		Date currentDate = new Date();
		dateFormat = new SimpleDateFormat("YYMMddHHmmss");
		return dateFormat.format(currentDate);
	}

	public static String getDateAndTime() { // 20150116:1036
		Date currentDate = new Date();
		dateFormat = new SimpleDateFormat("YYYYMMdd:HHmm");
		return dateFormat.format(currentDate);
	}
}
