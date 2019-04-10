package by.azhulpa.task4.autoservice.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateInput {

	private static String format = "yyyy-MM-dd";
	private static DateFormat dateFormat =  new SimpleDateFormat(format);
	
	public static Date getDate(String context) {
		System.out.println(context + " in format " + format);
		
		Date date = null;
		Scanner input = new Scanner(System.in);
		try {
			date = dateFormat.parse(input.next());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
