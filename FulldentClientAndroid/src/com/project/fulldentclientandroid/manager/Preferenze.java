package com.project.fulldentclientandroid.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.util.Costanti;
/**
 * Classe utilizzata per gestire le preferenze.
 * In particolar modo utilizzata per memorizzare
 * mail e password così da non reinserire quest'ultimi ad ogni accesso
 * 
 * @author ginofarisano
 *
 */
public class Preferenze {
	
	String def="nulla";
	SharedPreferences prefs;
	
	
	
	public Preferenze(Context context) {
		// TODO Auto-generated constructor stub
		prefs=context.getSharedPreferences(Costanti.CREDENZIALI,
				Context.MODE_PRIVATE);
	}
	/**
	 * Salva le preferenze
	 * 
	 * @param what cosa si vuole memorizzare (utilizzare la classe Costanti)
	 * @param value valore del parametro memorizzato
	 * 
	 * @see Costanti
	 * 
	 * 
	 */
	public void savePreferences(String what,String value ) {
		// TODO Auto-generated method stub
		SharedPreferences.Editor editor = prefs.edit();
		
		editor.putString(what, value);
		editor.commit();
	}
	/**
	 * Restituisce il valore di un parametro precedentemente salvato
	 * 
	 * @param extra nome del parametro salvato
	 * @return value parametro salvato
	 */
	public String getString(String extra) {
		return prefs.getString(extra, def);
	}
	
}
