package com.project.fulldentclientandroid.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Funzioni di utilità utilizzate per manipolare le date
 * 
 * @author ginofarisano
 *
 */
import java.util.Set;
import java.util.TreeSet;



public class DateValidator {
	
	Set<Integer> set = new TreeSet<Integer>();
	
	
	/**
	 * Controlla validità della data inserita
	 * 
	 * @param dateToValidate
	 * @param dateFromat
	 * @return
	 */
	public boolean isThisDateValid(String dateToValidate, String dateFromat) {

		if (dateToValidate == null) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);

		sdf.setLenient(false);

		try {

			Date date = sdf.parse(dateToValidate);

		} catch (ParseException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}
	/**
	 * Modifica il mese o il giorno da intero a Stringa (antecedento lo zero se necessario
	 * )
	 * @param dayOrMonth in formato int
	 * @return dayOrMonth in formato String
	 */
	public String modifyFormat(int dayOrMonth) {
		// TODO Auto-generated method stub
		String toReturn;
		String dayOrMonthStr = "" + dayOrMonth;

		if (dayOrMonthStr.length() == 1)
			toReturn = "0" + dayOrMonthStr;
		else
			toReturn = dayOrMonthStr;

		return toReturn;

	}
	/**
	 * Verifica se la data selezionata è antecedente a quella odierna
	 * 
	 * @param date
	 * @return boolean
	 */
	public boolean beforeToday(String date) {
		// TODO Auto-generated method stub

		String myStrdate = date;
		String toDayStrdate = currentTime("-");

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		sdf.setLenient(false);

		try {

			Date mydate = sdf.parse(myStrdate);
			Date toDayDate = sdf.parse(toDayStrdate);

			if (mydate.before(toDayDate))
				return true;
			return false;
		}

		catch (ParseException e) {

			e.printStackTrace();
			return false;
		}

	}
	
	
	/**
	 * Verifica se la data selezionata è antecedente a quella odierna
	 * 
	 * @param date
	 * @return boolean
	 */
	public boolean isNotHoliday(String date) {
		// TODO Auto-generated method stub
		
		
		//insieme di giorni festivi non utilizzabili per
		//la prenotazione
		
		
		
		//inizializzazione
		for(int day: Costanti.festivi)
			set.add(day);
		
		String myStrdate = date;
		String toDayStrdate = currentTime("-");

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		sdf.setLenient(false);

		try {

			Date mydate = sdf.parse(myStrdate);
			
			int dayWeek=mydate.getDay();
			int dayMonth=Integer.parseInt((""+mydate.getDate()+(mydate.getMonth()+1)));
			
			
			
			return (set.remove(dayWeek) || set.remove(dayMonth)) ? true :false;
			
			
		}

		catch (ParseException e) {

			e.printStackTrace();
			return false;
		}
	

	}
	
	
	
	
	
	/**
	 * Controlla se la prima data è antecedente alla seconda
	 * 
	 * @param firstData
	 * @param secondData
	 * @return true se è vero, false altrimenti
	 */
	public boolean beforeOtherDay(String firstData,String secondData) {
		// TODO Auto-generated method stub

		String date1Strdate = firstData;
		String date2Strdate = secondData;
		
		

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		sdf.setLenient(false);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");

		sdf2.setLenient(false);

		try {

			Date date1 = sdf.parse(date1Strdate);
			Date date2 = sdf.parse(date2Strdate);

			if (date1.before(date2))
				return true;
			return false;
		}

		catch (ParseException e) {

			e.printStackTrace();
			return false;
		}

	}
	
	
	/**
	 * Restituisce la data corrente
	 * 
	 * @return data in formato string
	 */
	public String currentTime(String format) {

		StringBuilder toRetun = new StringBuilder();
		Calendar c = Calendar.getInstance();
		int year;
		int month;
		int day;

		String strMonth;
		String strDay;

		year = c.get(Calendar.YEAR);
		month = 1 + c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		
		strDay = modifyFormat(day);
		strMonth = modifyFormat(month);

		return toRetun.append(strDay).append(format).append(strMonth).append(format)
				.append(year).toString();
	}
	
	/**
	 * Le classe sottostante è utilizzata unicamente per il test
	 * aggiunge +1 o -1 all'anno corrente
	 */
	
	public String currentTimeForTest(String format,int value) {

		StringBuilder toRetun = new StringBuilder();
		Calendar c = Calendar.getInstance();
		int year;
		int month;
		int day;

		String strMonth;
		String strDay;

		year = value + c.get(Calendar.YEAR);
		month = 1 + c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		
		strDay = modifyFormat(day);
		strMonth = modifyFormat(month);

		return toRetun.append(strDay).append(format).append(strMonth).append(format)
				.append(year).toString();
	}
	
	
	public String currentTimeForTest2(String format) {

		StringBuilder toRetun = new StringBuilder();
		Calendar c = Calendar.getInstance();
		int year;
		int month;
		int day;

		String strMonth;
		String strDay;

		year = c.get(Calendar.YEAR)-1;
		month = 1 + c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		
		strDay = modifyFormat(day);
		strMonth = modifyFormat(month);

		return toRetun.append(strDay).append(format).append(strMonth).append(format)
				.append(year).toString();
	}


}