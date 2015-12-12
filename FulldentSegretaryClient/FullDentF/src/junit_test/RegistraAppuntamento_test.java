package junit_test;

import guiSegretaria.FormCalendario;

import junit.framework.TestCase;
import bean.Prenotazione;




public class RegistraAppuntamento_test extends TestCase{

	FormCalendario.AggiungiApp a;
	
	protected void setUp() throws Exception{
   	 a = new FormCalendario().new AggiungiApp("gtgffg","1","asdfghjklòàùzxcv","06/06/2014","12:00");

		
	}
	
	protected void tearDown() throws Exception{
		a=null;
	}
	
	
	public void testGetCodiceFiscale(){
		assertEquals("gtgffg",a.getCodiceFiscale());	
	}
	
	public void testIdPrestazione(){
		assertEquals("1",a.getIdPrestazione());
	}
	
	public void testGetCodiceMedico(){
		assertEquals("asdfghjklòàùzxcv",a.getIdPersonale());
	}
	
	public void testGetData(){
		assertEquals("06/06/2014",a.getData());
	}
	
	public void testGetOrario(){
		assertEquals("12:00",a.getOra());
	}

	
	public void testSetCodiceFiscale(){
		try{
			a.setCodiceFiscale("VLTGPP303DLDIEK");
		}catch(Exception e){
			e.printStackTrace();	
		}
		assertEquals("VLTGPP303DLDIEK", a.getCodiceFiscale());
	}
	
	
	public void testSetIdPrestazione(){
		try{  
			a.setIdPrestazione("3");
		}catch(Exception e){
			e.printStackTrace();	
		}
		assertEquals("3", a.getIdPrestazione());
	}
	
	public void testSetCodiceMedico(){
		try{
			a.setIdPersonale("ASDASDASD");
		}catch(Exception e){
			e.printStackTrace();	
		}
		assertEquals("ASDASDASD", a.getIdPersonale());
	}
	
	public void testSetData(){
		try{
			a.setData("10/20/2014");
		}catch(Exception e){
			e.printStackTrace();	
		}
		assertEquals("10/20/2014", a.getData());
	}
	
	public void testSetOra(){
		try{
			a.setOra("20:00");
		}catch(Exception e){
			e.printStackTrace();
		}
		assertEquals("20:00",a.getOra());
	}
	

	
	public void testInserimentoDati(){

		Prenotazione u=new Prenotazione("00000","1","asdfghjklòàùzxcv","11/06/2014","18:00");
		
		if(a.verificaCodiceFiscale("00000")!=null && 
		   a.verificaCodiceMedico("asdfghjklòàùzxcv")!=null &&
		   a.verificaIdPrenotazione("1")!=null)
			
			a.AggiungiAppuntamento(u);
		
		//assertNotNull(a.getUtente(u.getCodiceFiscale()));
		
		
	}
	
	
}