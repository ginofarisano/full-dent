package com.project.fulldentclientandroid.bean;


/**
 * Bean Prenotazione utilizzato per inviare al web service
 * informazioni riguardanti la visita prenotata
 * 
 * @author ginofarisano
 *
 */
public class Prenotazione {
	
	private String codiceFiscale="";
	private String idPrestazione="";
	private String idPersonale="";
	private String data="";
	private String ora="";
	
	
	
	
	

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getIdPrestazione() {
		return this.idPrestazione;
	}
	
	public void setIdPrestazionee(String idPrestazione) {
		this.idPrestazione = idPrestazione;
	}
	
	public String getIdPersonale() {
		return this.idPersonale;
	}
	
	public void setIdPersonale(String idPersonale) {
		this.idPersonale = idPersonale;
	}
	
	public String getData() {
		return this.data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getOra() {
		return this.ora;
	}
	
	public void setOra(String ora) {
		this.ora = ora;
	}

	@Override
	public String toString() {

		return "{\"codiceFiscale\":\""+this.codiceFiscale+"\","+"\"idPrestazione\":\""+this.idPrestazione+"\","+"\"idPersonale\":\""+this.idPersonale+"\","+"\"data\":\""+this.getData()+"\","+"\"ora\":\""+this.ora+"\"}";

	}

}