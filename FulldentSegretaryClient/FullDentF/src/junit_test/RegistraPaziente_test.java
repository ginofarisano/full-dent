package junit_test;


import bean.Utente;
import guiSegretaria.RegistraPaziente;
import junit.framework.TestCase;

public class RegistraPaziente_test extends TestCase{

	RegistraPaziente.InserisciPaziente a;
	
	protected void setUp() throws Exception{
   	 a = new RegistraPaziente().new InserisciPaziente("SPSVNC20VP202SO","Vincenzo","Esposito",
   			 "Via Ponte Izzo","0818619292","mail@mail.it");

		
	}
	
	protected void tearDown() throws Exception{
		a=null;
	}
	
	
	public void testGetCodiceFiscale(){
		assertEquals("SPSVNC20VP202SO",a.getcF());	
	}
	
	public void testGetNome(){
		assertEquals("Vincenzo",a.getN());
	}
	
	public void testGetCognome(){
		assertEquals("Esposito",a.getCogn());
	}
	
	public void testGetIndirizzo(){
		assertEquals("Via Ponte Izzo",a.getI());
	}
	
	public void testGetTelefono(){
		assertEquals("0818619292",a.getT());
	}
	
	public void testGetEmail(){
		assertEquals("mail@mail.it",a.getE());
	}
	
	
	public void testSetCodiceFiscale(){
		try{
			a.setcF("VLTGPP303DLDIEK");
		}catch(Exception e){
			e.printStackTrace();	
		}
		assertEquals("VLTGPP303DLDIEK", a.getcF());
	}
	
	
	public void testSetNome(){
		try{
			a.setN("Giuseppe");
		}catch(Exception e){
			e.printStackTrace();	
		}
		assertEquals("Giuseppe", a.getN());
	}
	
	public void testSetCognome(){
		try{
			a.setCogn("Valitutto");
		}catch(Exception e){
			e.printStackTrace();	
		}
		assertEquals("Valitutto", a.getCogn());
	}
	
	public void testSetIndirizzo(){
		try{
			a.setI("Via Roma");
		}catch(Exception e){
			e.printStackTrace();	
		}
		assertEquals("Via Roma", a.getI());
	}
	
	public void testSetTelefono(){
		try{
			a.setT("06334455");
		}catch(Exception e){
			e.printStackTrace();
		}
		assertEquals("06334455", a.getT());
	}
	
	public void testSetMail(){
		try{
			a.setE("peppe@mail.it");
		}catch(Exception e){
			e.printStackTrace();	
		}
		
		assertEquals("peppe@mail.it", a.getE());
	}
	
	public void testInserimentoDati(){

		Utente u=new Utente("99999","Vincenzo","Esposito","Via Ponte Izzo","0818619292","mail@mail.it","asd");
		
		if(a.getUtente(u.getCodiceFiscale())==null)
			a.inserisciNelDb(u);
		
		assertNotNull(a.getUtente(u.getCodiceFiscale()));
		
	}
	
	
}