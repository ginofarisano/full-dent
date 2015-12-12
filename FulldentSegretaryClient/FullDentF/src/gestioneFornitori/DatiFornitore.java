package gestioneFornitori;

import exception.InvalidDataException;

// TODO: Auto-generated Javadoc
/**
 * La classe si occupa di gestire i dati relativi ai fornitori del centro odontoiatrico.
 * @author Giuseppe Valitutto
 */

public class DatiFornitore {
	
	/** The p iva. */
	private String pIva;
	
	/** The nome responsabile. */
	private String nomeResponsabile;
	
	/** The cognome responsabile. */
	private String cognomeResponsabile;
	
	/** The sede. */
	private String sede;
	
	/** The recapito. */
	private String recapito;
	
	/** The email. */
	private String email;

	
	/**
	 * Metodo Costruttore che realizza un nuovo oggetto DatiFornitore.
	 * @param aPIva la p.iva del responsabile.
	 * @param aNomeResponsabile il nome del responsabile. 
	 * @param aCognomeResponsabile il cognome del responsabile.
	 * @param aSede la sede del fornitore.
	 * @param aRecapito il recapito del fornitore.  
	 * @param aEmail l'email del fornitore.
	 */
	public DatiFornitore(String aPIva,String aNomeResponsabile,String aCognomeResponsabile,String aSede,String aRecapito,String aEmail){
		pIva=aPIva;
		nomeResponsabile=aNomeResponsabile;
		cognomeResponsabile=aCognomeResponsabile;
		sede=aSede;
		recapito=aRecapito;
		email=aEmail;
	}

	/**
	 * Metodo che restituisce la P.Iva del fornitore.
	 * @return la partita iva.
	 * */
	public String getPIva() {
		return pIva;
	}
 
	/**
	 * Metodo che restituisce il nome del responsabile.
	 * @return il nome del responsabile. 
	 */
	public String getNomeResponsabile() {
		return nomeResponsabile;
	}
	
	/**
	 * Metodo che modifica il nome del responsabile.
	 *
	 * @param nomeResponsabile il nuovo responsabile.
	 * @throws InvalidDataException the invalid data exception
	 */
	public void setNomeResponsabile(String nomeResponsabile)throws InvalidDataException {
		if (nomeResponsabile.length()<=20)	
			this.nomeResponsabile = nomeResponsabile;
		else throw new InvalidDataException("numeri dei caratteri massimo superato");
	}
	
	/**
	 * Metodo che restituisce il cognome del responsabile.
	 *
	 * @return il cognome del responsabile.
	 */
	public String getCognomeResponsabile() {
		return cognomeResponsabile;
	}

	/**
	 * Metodo che modifica il cognome del responsabile.
	 *
	 * @param cognomeResponsabile il nuovo cognome del responsabile.
	 * @throws InvalidDataException the invalid data exception
	 */
	public void setCognomeResponsabile(String cognomeResponsabile)throws InvalidDataException {
		if(cognomeResponsabile.length()<=20)	
			this.cognomeResponsabile = cognomeResponsabile;
		else throw new InvalidDataException("numeri dei caratteri massimo superato"); 
	}

	/**
	 * Metodo che restituisce la sede del fornitore.
	 *
	 * @return l'indirizzo della sede del fornitore.
	 */
	public String getSede() {
		return sede;
	}

	/**
	 * Metodo che modifica la sede del responsabile.
	 *
	 * @param sede la nuova sede del responsabile.
	 * @throws InvalidDataException the invalid data exception
	 */
	public void setSede(String sede)throws InvalidDataException {
		if(sede.length()<=45)	
			this.sede = sede;
		else throw new InvalidDataException("numeri dei caratteri massimo superato"); 
	}

	/**
	 * Metodo che restituisce il recapito telefonico del fornitore.
	 * @return il recapito del fornitore.
	 */
	public String getRecapito() {
		return recapito;
	}

	/**
	 * Metodo che modifica il recapito del fornitore.
	 *
	 * @param recapito il nuovo recapito del fornitore.
	 * @throws InvalidDataException the invalid data exception
	 */
	public void setRecapito(String recapito)throws InvalidDataException {
		if(recapito.length()<=15)	
			this.recapito = recapito;
		else throw new InvalidDataException("numeri dei caratteri massimo superato");
	}

	/**
	 * Metodo che restituisce l'e-mail del fornitore.
	 *
	 * @return il contatto email del fornitore.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Metodo che modifica l'e-mail del fornitore. 
	 *
	 * @param email la nuova e-mail del fornitore.
	 * @throws InvalidDataException the invalid data exception
	 */
	public void setEmail(String email)throws InvalidDataException {
		if(email.length()<=45)	
			this.email = email;
		else throw new InvalidDataException("numeri dei caratteri massimo superato");
	}


}

