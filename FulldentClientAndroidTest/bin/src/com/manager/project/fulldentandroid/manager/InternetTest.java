package com.manager.project.fulldentandroid.manager;



import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.manager.InternetManager;
import com.project.fulldentclientandroid.manager.Login;
import com.project.fulldentclientandroid.manager.Preferenze;
import com.project.fulldentclientandroid.util.Costanti;

import junit.framework.TestCase;

/**
 * Verifica se la connessione ad 
 * internet è gestita correttamente
 * 
 * @author ginofarisano
 *
 */

public class InternetTest extends TestCase {

	private InternetManager internetMenager;
	
	
	public InternetTest(String s) {
		super(s);
	}

	public void setUp() {
		try {
			internetMenager = new InternetManager(Engine.getContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testPreConditions() {

		assertNotNull(internetMenager);

	} 
	
	
	/**
	 * Verifica se il test sulla presenza di internet è corretto
	 * (mi aspetto che restituisca true se internet nello smartphone è attivato,
	 *  false altrimenti)
	 * 
	 */
	public void testInternetConnection(){
		
		
		assertTrue(internetMenager.checkConnection());
		
	}

}