package com.manager.project.fulldentandroid.manager;

import com.project.fulldentclientandroid.bean.Utente;
import com.project.fulldentclientandroid.manager.Login;

import junit.framework.TestCase;
import android.test.ActivityInstrumentationTestCase2;


/**
 * Effettua vari controllo sul menager che gestisce il login
 * 
 * @author ginofarisano
 *
 */

public class LoginTest extends TestCase {

	private Login login1;
	private Login login2;
	private Login login3;
	private Login login4;

	// presente nel db
	private static final String jsonGinoFarisano = "{\"email\":\"gino.farisano@gmail.com\",\"nome\":\"gino\",\"codiceFiscale\":\"frsgni89e01i422h\",\"cognome\":\"farisano\",\"telefono\":\"3291864632\",\"indirizzo\":\"via procoio n 125\",\"password\":\"blabla\"}";

	public LoginTest(String s) {
		super(s);
	}

	// permette di eseguire ciascun metodo di test in isolamento
	// senza che i test successivi siano influenzati dai precedenti
	public void setUp() {
		try {
			login1 = new Login("", "");
			login2 = new Login("gino.farisano@gmail.com", "blabla");
			// non presente nel db
			login3 = new Login("giovanni.bianchi@gmail.com", "ciaociao123");
			
			//no chiocciola
			login4 = new Login("gino.farisanogmail.com", "blabla");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// viene eseguito una sola volta e non prima di ogni test come il precedente
	// nel caso fallisse i test successivi sono privi di significato
	// in quanto eseguiti in un contesto non correttamente impostato
	public void testPreConditions() {

		assertNotNull(login1);
		assertNotNull(login2);
		assertNotNull(login3);
		assertNotNull(login4);
		
	} // end of testPreConditions() method definition

	public void testCampivuoti() {
		assertTrue(login1.campivuoti());
		assertFalse(login2.campivuoti());
		assertFalse(login3.campivuoti());
		assertFalse(login4.campivuoti());

	}
	
	/**
	 * Verifica se, in seguito al login, il bean utente atteso
	 * è uguale a quello ricevuto
	 */
	
	public void testVerifica() {

		Utente utente2 = login2.verifica();
		Utente utente3 = login3.verifica();

		String returnjson1 = utente2.toString();
		assertEquals(jsonGinoFarisano,returnjson1);

		assertNull("Utente non presente", utente3);

	}
	/**
	 * Verica se il controllo sulla chiocciola (campo mail)
	 * viene gestito corretamente
	 */
	public void testChiocciola(){
		assertTrue(login4.noChiocciola());
	}
}
