package gestioneSala;

import exception.InvalidDataException;

// TODO: Auto-generated Javadoc
/**
 * La classe si occupa di gestire i dati relativi alle sale del centro odontoiatrico.
 *
 * @author Maria D'Arco
 */
public class DatiSala {

	/** The codice sala. */
	private int codiceSala;
	
	/** The nome sala. */
	private String nomeSala;
	
	/** The descrizione. */
	private String descrizione;
	
	/** The codice fiscale. */
	private String codiceFiscale;
	
	/**
	 * Istanzia un nuovo oggetto di tipo DatiSala.
	 * @param ns il nome identificativo della sala.
	 * @param desc descrizione aggiuntive alla sala.
	 * @param cf il codice fiscale dell'amministratore.
	 * @param cd il codice identificativo della sala.
	 * @throws InvalidDataException dati non validi.
	 */
	public DatiSala(String ns, String desc,String cf,int cd)throws InvalidDataException{
		codiceSala = cd;
		if(ns.length()>=3 && ns.length()<=20)	
			nomeSala=ns;
			else throw new InvalidDataException("Numero caratteri massimo superato!");
		if (desc.length()<=45) 
			descrizione=desc;
			else throw new InvalidDataException("Numero caratteri massimo superato!");
		codiceFiscale=cf; 
	}

	/**
	 * Ritorna il nome della sala.
	 * @return il nome della sala.
	 */
	public String getNomeSala() {
		return nomeSala;
	}
	
	/**
	 * Modifica il nome della sala.
	 *
	 * @param nomeSala the new nome sala
	 * @throws InvalidDataException dati errati.
	 */
	public void setNomeSala(String nomeSala)throws InvalidDataException{
		if(nomeSala.length()>=3 && nomeSala.length()<=20) 
			this.nomeSala = nomeSala;
		else 
			throw new InvalidDataException("Numero caratteri massimo superato!");
		
	}
	
	/**
	 * Restituisce la descrizione associata alla sala.
	 * @return la descrizione della sala.
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * Modifica la descrizione della sala.
	 *
	 * @param descrizione the new descrizione
	 * @throws InvalidDataException dati non validi.
	 */
	public void setDescrizione(String descrizione)throws InvalidDataException {
		if(descrizione.length()<=45)
			this.descrizione = descrizione;
		else 
			throw new InvalidDataException("Numero caratteri massimo superato!");
	}

	/**
	 * Restiutuisce il codice della sala.
	 * @return il codice della sala.
	 */
	public int getCodiceSala() {
		return codiceSala;
	}

	/**
	 * Restituisce il codice fiscale dell'amministratore.
	 * @return il codice fiscale.
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
}
