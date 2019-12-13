package com.pactera.bg.budsc.bank.yongfu.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

	public static long dateToLong(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		long timeInMillis = c.getTimeInMillis();
		return timeInMillis;
	}
}
