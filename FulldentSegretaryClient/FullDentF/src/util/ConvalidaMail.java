package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvalidaMail {

	/**
	* Funzione per la validazione di un indirizzo e-mail
	* @param mail Indirizzo e-mail da validare
	* @return TRUE se la mail è stata validata correttamente
	*/
	public static boolean validateMail(String mail)
	{
	if (mail == null)
	{
	return false;
	}

	Pattern p = Pattern.compile(".+@.+\\.[a-z]+", Pattern.CASE_INSENSITIVE);
	Matcher m = p.matcher(mail);
	boolean matchFound = m.matches();

	//Condizioni più restrittive rispetto alle precedenti
	String  expressionPlus="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	Pattern pPlus = Pattern.compile(expressionPlus, Pattern.CASE_INSENSITIVE);
	Matcher mPlus = pPlus.matcher(mail);
	boolean matchFoundPlus = mPlus.matches();
	         
	return matchFound && matchFoundPlus;   
	}
	
}
