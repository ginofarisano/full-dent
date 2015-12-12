package util;

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
public class DateValidator {
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

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

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
	


}