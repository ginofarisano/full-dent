package com.manager.project.fulldentandroid.manager;

import java.util.ArrayList;

import com.project.fulldentclientandroid.bean.Servizio;
import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.manager.Login;
import com.project.fulldentclientandroid.manager.Preferenze;
import com.project.fulldentclientandroid.manager.ServiziManager;
import com.project.fulldentclientandroid.util.Costanti;

import junit.framework.TestCase;

/**
 * Test sui servizi offerti dal centro
 * 
 * @author ginofarisano
 * 
 */
public class ServiziManagerTest extends TestCase {

	private static final String axpectedServices = "[Pulizia Denti € 100 (1), Cura Carie € 50 (2), Estrazione molare € 150 (2), Sbiancamento dentiera € 200 (1), Piombatura € 250 (2), Devitalizzazione dente € 500 (3)]";

	private Preferenze preferenze;
	ServiziManager serviziMenager;

	public ServiziManagerTest(String s) {
		super(s);
	}

	// eseguita prima di ogni test
	public void setUp() {
		
			preferenze = new Preferenze(Engine.getContext());
			
			serviziMenager = new ServiziManager();

			
	}


	public void testPreConditions() {

		assertNotNull(preferenze);

	}

	/**
	 * Verifica se i servizi restituiti sono quelli attesi
	 */
	public void testVerifyServices() {
		
		ArrayList<Servizio> servizi = new ArrayList<Servizio>();
		
		servizi = serviziMenager.getSerVizi(Costanti.RICHIESTADATI1
				+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI9
				+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
				+ preferenze.getString(Costanti.EXTRA_PASS));
		assertEquals(axpectedServices, servizi.toString());

	}

}