package com.manager.project.fulldentandroid.manager;

import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.manager.Login;
import com.project.fulldentclientandroid.manager.Preferenze;
import com.project.fulldentclientandroid.util.Costanti;

import junit.framework.TestCase;

/**
 * Test sul menager preferenze
 * 
 * @author ginofarisano
 *
 */
public class PreferenzeTest extends TestCase {

	private Preferenze preferenze;
	
	private static final String mymail = "gino.farisano@gmail.com";
	
	private String old;
	
	public PreferenzeTest(String s) {
		super(s);
	}
	
	
	//eseguita prima di ogni test
	public void setUp() {
		try {
			preferenze = new Preferenze(Engine.getContext());
			//conservo la preferenze precedentemente salvata
			old=preferenze.getString(Costanti.EXTRA_MAIL);
			preferenze.savePreferences(Costanti.EXTRA_MAIL, mymail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//eseguita dopo ogni test...rimetto tutto a posto
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		preferenze.savePreferences(Costanti.EXTRA_MAIL, old);
	}

	public void testPreConditions() {

		assertNotNull(preferenze);

	} 
	
	
	/**
	 * Verifica se le la classe preferenze vengono 
	 * gestite corretamente
	 */
	public void testSavePreferences(){
		
		
		assertEquals(preferenze.getString(Costanti.EXTRA_MAIL),mymail);
		
	}
	
	

}
