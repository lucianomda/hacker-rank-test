package com.luciano.hackerranktest.java.introduction;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-date-and-time/problem
 * Java Date and Time
 *
 * @author lucianomda
 */
public class JavaDateAndTime {

	public static String getDay(String day, String month, String year) {
		/*
		 * Write your code here.
		 */
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(day));
		calendar.set(Calendar.MONTH, Integer.valueOf(month) - 1);
		calendar.set(Calendar.YEAR, Integer.valueOf(year));
		return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH).toUpperCase();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String month = in.next();
		String day = in.next();
		String year = in.next();

		System.out.println(getDay(day, month, year));
	}
}
