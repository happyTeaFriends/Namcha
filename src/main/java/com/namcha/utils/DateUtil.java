package com.namcha.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat simpleDateFormat;
	private static final String DATE_FORMAT = "dd/MM/yyyy";

	/**
	 * Convert date to string.
	 * @param inputDate
	 * @return
	 */
	public static String convertToString(Date inputDate) {
		if (inputDate != null) {
			simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
			return simpleDateFormat.format(inputDate);
		}
		return "";
	}
}
