package bean;


public class Utente {

	private String codiceFiscale="";
	private String nome="";
	private String cognome="";
	private String telefono="";
	private String email="";
	private String password="";
	private String indirizzo="";
	
	
	public Utente(){
		
	}
	
	public Utente(String cF,String n,String c,String i,String t,String m,String p){
		this.codiceFiscale=cF;
		this.nome=n;
		this.cognome=c;
		this.indirizzo=i;
		this.telefono=t;
		this.email=m;
		this.password=p;
	}
		
				

	/**
	 * Gets the codice fiscale.
	 *
	 * @return the codice fiscale
	 */
	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	/**
	 * Sets the codice fiscale.
	 *
	 * @param codiceFiscale the new codice fiscale
	 */
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the cognome.
	 *
	 * @return the cognome
	 */
	public String getCognome() {
		return this.cognome;
	}
	
	/**
	 * Sets the cognome.
	 *
	 * @param cognome the new cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 * Gets the telefono.
	 *
	 * @return the telefono
	 */
	public String getTelefono() {
		return this.telefono;
	}
	
	/**
	 * Sets the telefono.
	 *
	 * @param telefono the new telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the indirizzo.
	 *
	 * @return the indirizzo
	 */
	public String getIndirizzo() {
		return this.indirizzo;
	}
	
	/**
	 * Sets the indirizzo.
	 *
	 * @param indirizzo the new indirizzo
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return"Utente["
		+ " codiceFiscale=" + codiceFiscale 
		+ ", nome=" + nome 
		+ ", cognome=" + cognome 
		+ ", telefono=" + telefono 
		+ ", email=" + email 
		+ ", password=" + password 
		+ ", indirizzo=" + indirizzo 
		+"]";

		
	}
	


}
