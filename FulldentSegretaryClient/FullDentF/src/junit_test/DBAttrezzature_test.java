package junit_test;

import java.util.ArrayList;

import junit.framework.TestCase;
import gestioneAttrezzature.*;

// TODO: Auto-generated Javadoc
/**
 * The Class DBAttrezzature_test.
 */
public class DBAttrezzature_test extends TestCase{

	/** The db. */
	private DBAttrezzature db;
	
	/**
	 * Instantiates a new DB attrezzature_test.
	 *
	 * @param s the s
	 */
	public DBAttrezzature_test(String s){
		super(s);
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception{
		db = new DBAttrezzature();
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception{
		db = null;
	}
	
	/**
	 * Test open connection.
	 */
	public void testOpenConnection() {
		try {
			db.openConnection();
			assertTrue(true);
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Test close connection.
	 */
	public void testCloseConnection() {
		try {
			db.openConnection();
			db.closeConnection();
			assertTrue(true);
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Test get attrezzatura.
	 */
	public void testGetAttrezzatura(){
		try {
			db.openConnection();
			DatiAttrezzature p = db.getAttrezzatura(24);
			assertNotNull(p);
			assertEquals(24,p.getCodiceTipo());
			db.closeConnection();
		} catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * Test visualizza attrezzature.
	 */
	public void testVisualizzaAttrezzature(){
		try {
			db.openConnection();
			ArrayList<DatiAttrezzature>list=db.VisualizzaAttrezzature();
			assertNotNull(list);
			db.closeConnection();
		} catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * Test inserisci attrezzature.
	 */
	public void testInserisciAttrezzature(){
		try {
			db.openConnection();
			DatiAttrezzature p = new DatiAttrezzature(12,"spazzolino",10,1.5,"materiale","lava i denti","bagno","asdfghjklzxcvbnm");
			if(!db.isPresente(12))
				db.inserisciAttrezzature(p);
			assertNotNull(db.getAttrezzatura(12));
			db.closeConnection();
		} catch (Exception e) {
			fail("impossibile eseguire questo test - modificare i valori del test.");
		}	
	}
	
	/**
	 * Test is presente.
	 */
	public void testIsPresente(){
		try{
			db.openConnection();
			assertTrue(db.isPresente(12));
			db.closeConnection();
		} catch(Exception e){
			fail("impossibile eseguire questo test - modificare i valori del test.");
		}
	}
	
	/**
	 * Test aggiorna attrezzatura.
	 */
	public void testAggiornaAttrezzatura(){
		try {
			db.openConnection();
			db.aggiornaAttrezzature(12, 10);
			db.closeConnection();
		} catch (Exception e) {
			fail("impossibile eseguire questo test - modificare i valori del test.");
		}	
	}
	
	/**
	 * Test modifica attrezzatura.
	 */
	public void testModificaAttrezzatura(){
		try{
			db.openConnection();
			db.modificaAttrezzatura(12, "nuova locazione", "compriamo");
			DatiAttrezzature y = db.getAttrezzatura(12);
			db.closeConnection();
			assertEquals("nuova locazione",y.getLocazione());
			assertEquals("compriamo", y.getDescrizione());
		} catch(Exception e){
			fail("impossibile eseguire questo test - modificare i valori del test.");
		}
	}
	
	/**
	 * Test elimina attrezzatura.
	 */
	public void testEliminaAttrezzatura(){
		try{
			db.openConnection();
			DatiAttrezzature x = db.getAttrezzatura(12);
			db.eliminaAttrezzature(x);
			db.closeConnection();
		}catch(Exception e){
			fail("impossibile eseguire questo test - modificare i valori del test.");
		}
	}
	
}
