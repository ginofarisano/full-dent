package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlloCodiceFiscale {
	
	
	/**

	* metodo per una prima verifica del codice fiscale - verifica se la stringa passata

	* come parametro ha le lettere e le cifre al posto giusto (non controlla

	* se il CF è ESATTO)

	* @param codiceFiscale la stringa da verificare

	* @return true se lettere e cifre sono nella quantita' giusta e al posto giusto

	* false altrimenti

	*/

	public static boolean checkCodiceFiscale(String codiceFiscale){

	//lo metto maiuscolo

	codiceFiscale = codiceFiscale.toUpperCase();

	//6 lettere 2 numeri 1 lettera 2 numeri 1 lettera 3 numeri 1 lettera

	Pattern pattern = Pattern.compile("[A-Z]{6}[0-9]{2}[A-Z]{1}[0-9]{2}[A-Z]{1}[0-9]{3}[A-Z]{1}");

	Matcher matcher = pattern.matcher(codiceFiscale);

		
	
	return matcher.matches();

	}
}
