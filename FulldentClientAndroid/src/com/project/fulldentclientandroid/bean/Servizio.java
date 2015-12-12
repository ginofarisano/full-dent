package com.project.fulldentclientandroid.bean;


/**
 * Bean servizio utilizzato per visualizzare
 * i servizi friubili nel centro dentistico
 * 
 * @author ginofarisano
 *
 */
public class Servizio {

	
	private String nome="";
	private String costo="";
	private String durata="";
	private String idPrestazione="";

	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCosto() {
		return this.costo;
	}
	
	public void setCosto(String costo) {
		this.costo = costo;
	}
	
	public String getDurata() {
		return this.durata;
	}
	
	public void setDurata(String durata) {
		this.durata = durata;
	}
	
	public String getIdPrestazione() {
		return this.idPrestazione;
	}
	
	public void setIdPrestazione(String idPrestazione) {
		this.idPrestazione = idPrestazione;
	}
	
	
	@Override
	public String toString() {
		
		return nome 
		+" € "+costo 
		+ " (" + durata 
		+")";

		
	}
	
}