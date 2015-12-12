package junit_test;

import bean.Prenotazione;
import junit.framework.TestCase;
import guiSegretaria.FormCalendario;


public class EliminaAppuntamento_test extends TestCase{

	FormCalendario.EliminaAppuntamento a;
	
	
	protected void setUp() throws Exception{
	   	 a = new FormCalendario().new EliminaAppuntamento("00000","1","asdfghjklòàùzxcv","06/06/2014","12:00");
		}
	
	
	protected void tearDown() throws Exception{
		a=null;
	}
	
	
	public void testGetCodiceFiscale(){
		assertEquals("00000",a.getCodiceFiscale());	
	}
	
	public void testIdPrestazione(){
		assertEquals("1",a.getIdPrestazione());
	}
	
	public void testGetCodMedico(){
		assertEquals("asdfghjklòàùzxcv",a.getCodMedico());
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
			a.setCodMedico("ASDASDASD");
		}catch(Exception e){
			e.printStackTrace();	
		}
		assertEquals("ASDASDASD", a.getCodMedico());
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
	
	
	
	public void testEliminazioneDati(){

		Prenotazione u=new Prenotazione("00000","1","asdfghjklòàùzxcv","11/06/2014","18:00");
		
		if(a.verificaCodiceFiscale("00000")!=null && a.verificaCodiceMedico("asdfghjklòàùzxcv")!=null && 
				a.verificaIdPrenotazione("1")!=null && a.verificaDataPrenotazione("11/06/2014", "18:00")!=null)
		   a.togliAppuntamento(u);
		//assertNotNull(a.getUtente(u.getCodiceFiscale()));
		
		
	}
	

}
