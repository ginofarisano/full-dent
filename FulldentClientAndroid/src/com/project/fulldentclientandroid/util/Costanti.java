package com.project.fulldentclientandroid.util;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Costanti utilizzate per parole ricorrenti da usare nell'applicazione
 * 
 * @author ginofarisano
 * 
 */
public class Costanti {

	/**
	 * Costanti numeriche utilizzate per gestire le chiamate delle varie dialogs
	 */
	
	public static final int NO_INTERNET = 0;

	public static final int CAMPI_VUOTI_NOCHIOCCIOLA = 1;

	public static final int CAMPI_ERRATI = 2;
	
	public final static int VERIFICA_CREDENZIALI = 3;

	public static final int NOTHING = 5;
	
	public static final int DATE = 6;

	public static final int SELEZIONA_SERVIZIO = 7;

	/**
	 * Extras salvabili nelle preferenze
	 */
	public final static String CREDENZIALI = "Credenziali";
	
	public static final String EXTRA_NAME = "name";
	
	public final static String EXTRA_MAIL = "mail";
	
	public final static String EXTRA_PASS = "password";
	
	public final static String EXTRA_COD_FISC = "cod_fisc";
	
	public final static String EXTRA_TEL = "tel";
	
	public final static String EXTRA_IND = "ind";
	
	public static final String EXTRA_SURNAME = "surname";
	
	/**
	 * Messaggi vari utilizzati all'interno di toast o dialogs
	 */

	public static final String CONFERMA = "Se modifiche i tuoi dati ricordati di confermare "
			+ "la modifica attraverso il pulsante \"Invio dati\"";

	public static final String CONFERMA_ELIMINAZIONE = "L'appuntamento è stato eliminato correttamente! Puoi riprenotarne unaltro dall'area Gestione Appuntamenti";

	public static final String ERRORDATE = "Il formato delle date non è corretto...";
	
	public static final String ERRORDATEAFTERTODAY = "Hai scelto una data antecedente a quella odierna...";

	public static final String ERRORDATEHOLIDAY = "Non puoi prenotare in un giorno festivo...";
	
	public static final String MSG = "Dati modificati correttamente!";
	
	public static final String ERROR = "Si è verificato un errore!";

	public static final String ERRORPRENOTAZIONE = "Impossibile effettuare la prenotazione! Riprova con un altro orario!";
	
	public static final String ERRORPRENOTAZIONE2 = "Hai già un altra visita prenotata. Per prenotarne un'altra cancella la precendente!";
	
	public static final String CONFERMAPRENOTAZIONE = "Prenotazione effettuata correttamente!";

	/**
	 * Sezione utilizzate nella sezione gestione utente
	 */

	public static final String SECTION1 = "Dati utente";
	
	public static final String SECTION2 = "Prossimo appuntamento";
	
	public static final String SECTION3 = "Storico";

	/**
	 * Tutte le chiamate al web service. Costruire la chimata concatenando
	 * RICHIESTADATI1 (varia a seconda dell'host su cui si lancia il web
	 * service) RICHIESTADATI2 e RICHIESTADATIi (i da 3 11) a seconda del
	 * servizio che si vuole chiamare
	 * 
	 * 
	 */

	public static final String RICHIESTADATI1 = "http://192.168.43.143:8080/";

	public static final String RICHIESTADATI2 = "FulldentServer/jaxrs/servicesandroid/";

	public static final String RICHIESTADATI3 = "login/";

	public static final String RICHIESTADATI4 = "storico/";

	public static final String RICHIESTADATI5 = "appuntamento/";
	
	public static final String RICHIESTADATI6 = "modifica/";

	public static final String RICHIESTADATI7 = "dottori/";

	public static final String RICHIESTADATI8 = "appuntamenti/";

	public static final String RICHIESTADATI9 = "servizi/";

	public static final String RICHIESTADATI10 = "inserisciPrenotazione/";

	public static final String RICHIESTADATI11 = "eliminaAppuntamento/";
	
	public static final String RICHIESTADATI12 = "ultimoappuntamento/";
	
	public static final String RICHIESTADATI13 = "eliminaUltimoAppuntamento/";
	
	/**
	 * giorni festivi - AGGIUNGI in questo array
	 * 
	 */
	                                    //domenica//sabato//natale//capodanno
	public static final int[] festivi = new int[]{0,6,2512,3112};

	
	
	
	
	

}
