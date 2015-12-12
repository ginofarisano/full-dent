package util;

import java.util.Calendar;

public class CurrentTime {
	static StringBuilder toRetun=new StringBuilder();
	static Calendar c = Calendar.getInstance();
	static int year;
	static int month;
	static int day;
	
	
	
	
	public static String currentTime(){
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		return toRetun.append(day).append("-").append(month+1).append("-").append(year).toString();
	}
	
	
	
}
