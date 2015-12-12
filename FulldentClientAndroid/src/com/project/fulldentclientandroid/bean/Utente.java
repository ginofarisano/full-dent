package com.project.fulldentclientandroid.bean;



/**
 * @author ginofarisano
 *bean contenente informazioni sull'utente.
 *Il metodo toString è stato riscritto per creare automaticamente
 *un file json da mandare al server
 */
public class Utente {

	private String codiceFiscale = "";
	private String nome = "";
	private String cognome = "";
	private String telefono = "";
	private String email = "";
	private String password = "";
	private String indirizzo = "";

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Override
	public String toString() {

		return "{\"email\":\"" + this.getEmail() + "\"," + "\"nome\":\""
				+ this.getNome() + "\"," + "\"codiceFiscale\":\""
				+ this.codiceFiscale + "\"," + "\"cognome\":\""
				+ this.getCognome() + "\"," + "\"telefono\":\""
				+ this.getTelefono() + "\"," + "\"indirizzo\":\""
				+ this.getIndirizzo() + "\"," + "\"password\":\""
				+ this.getPassword() + "\"}";

	}

}
