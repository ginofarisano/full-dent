package junit_test;

import junit.framework.TestCase;
import gestioneAttrezzature.DatiAttrezzature;

// TODO: Auto-generated Javadoc
/**
 * The Class DatiAttrezzature_test.
 */
public class DatiAttrezzature_test extends TestCase{

	/** The attrezzatura. */
	private DatiAttrezzature attrezzatura;
	
	/**
	 * Instantiates a new dati attrezzature_test.
	 *
	 * @param s the s
	 */
	public DatiAttrezzature_test(String s){
		super(s);
	}
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	public void setUp(){
		try {
			attrezzatura = new DatiAttrezzature(1,"spazzolino",10,1.5,"materiale","lava i denti","bagno","asdfghjklzxcvbnm");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test get codice tipo.
	 */
	public void testGetCodiceTipo(){
		assertEquals(1, attrezzatura.getCodiceTipo());
	}
	
	/**
	 * Test get nome.
	 */
	public void testGetNome(){
		assertEquals("spazzolino", attrezzatura.getNome());
	}
	
	/**
	 * Test get quantità.
	 */
	public void testGetQuantità(){
		assertEquals(10, attrezzatura.getQuantità());
	}
	
	/**
	 * Test get costo.
	 */
	public void testGetCosto(){
		assertEquals(1.5, attrezzatura.getCosto());
	}
	
	/**
	 * Test get tipo.
	 */
	public void testGetTipo(){
		assertEquals("materiale", attrezzatura.getTipo());
	}
	
	/**
	 * Test get descizione.
	 */
	public void testGetDescizione(){
		assertEquals("lava i denti", attrezzatura.getDescrizione());
	}
	
	/**
	 * Test get locazione.
	 */
	public void testGetLocazione(){
		assertEquals("bagno", attrezzatura.getLocazione());
	}
	
	/**
	 * Test get codice fornitore.
	 */
	public void testGetCodiceFornitore(){
		assertEquals("asdfghjklzxcvbnm", attrezzatura.getCodiceFornitore());
	}
		
	/**
	 * Test set quantità.
	 */
	public void testSetQuantità(){
		try{
			attrezzatura.setQuantità(15);
		}catch(Exception e){
			e.printStackTrace();
			assertEquals(15, attrezzatura.getQuantità());
		}
	}

	/**
	 * Test set descrizione.
	 */
	public void testSetDescrizione(){
		try{
			attrezzatura.setDescrizione("non lava più");
		}catch(Exception e){
			e.printStackTrace();
			assertEquals("non lava più", attrezzatura.getDescrizione());
		}
	}
	
	/**
	 * Test set locazione.
	 */
	public void testSetLocazione(){
		try{
			attrezzatura.setLocazione("deposito");
		}catch(Exception e){
			e.printStackTrace();
			assertEquals("deposito", attrezzatura.getLocazione());
		}
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	public void tearDown(){
		attrezzatura = null;
	}
	
}
