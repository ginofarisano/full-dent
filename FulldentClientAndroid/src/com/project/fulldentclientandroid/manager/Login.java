package com.project.fulldentclientandroid.manager;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.project.fulldentclientandroid.bean.Utente;
import com.project.fulldentclientandroid.util.Costanti;
import com.project.fulldentclientandroid.util.JsonReader;

/**
 * 
 * 
 * classe per gestire l'autenticazione
 * 
 * @author ginofarisano
 * @param mail
 * @param password
 * @see Utente
 * 
 */
public class Login {
	private String mail;
	private String password;

	public Login(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * 
	 * Verifica se l'utente è presente nel database e in caso affermativo
	 * restituisce il bean contenente tutte le sue informazioni. Se
	 * tutti i campi del bean sono vuoti significa che l'utente non è presente
	 * nel database quindi restituisce null
	 * 
	 * @return Utente
	 * @see Utente
	 */
	public Utente verifica() {
		// TODO Auto-generated method stub
		
		
//		if(campivuoti() || noChiocciola())
//			return null;
		
		JSONObject object;

		Utente utente = new Utente();

		try {
			object = JsonReader.readJsonFromUrl(Costanti.RICHIESTADATI1
					+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI3 + mail
					+ "/" + password);
			utente.setCodiceFiscale(object.getString("codiceFiscale"));
			utente.setCognome(object.getString("cognome"));
			utente.setEmail(object.getString("email"));
			utente.setIndirizzo(object.getString("indirizzo"));
			utente.setNome(object.getString("nome"));
			utente.setPassword(object.getString("password"));
			utente.setTelefono(object.getString("telefono"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// l'utente potrebbe essere stato cancellato dalla segretaria
		// e le preferenze lasciate settatw
		if (!utente.getCodiceFiscale().equals(""))
			return utente;

		return null;

	}

	public boolean campivuoti() {
		if (mail.equals("") || password.equals(""))
			return true;
		return false;
	}
	
	/**
	 * controllo blando sulla mail
	 * se non è presente la chiocciola nel campo mail
	 * non può essere una mail
	 * 
	 * 
	 * @return boolean
	 */
	public boolean noChiocciola() {
		if(!mail.contains("@"))
			return true;
		return false;
	}
	
	

}
