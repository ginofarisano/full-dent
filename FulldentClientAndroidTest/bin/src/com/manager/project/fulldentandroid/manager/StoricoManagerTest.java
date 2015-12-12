package com.manager.project.fulldentandroid.manager;

import com.project.fulldentclientandroid.util.Costanti;

//listStorico = storicoMenager.getStorico(Costanti.RICHIESTADATI1
//		+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI4
//		+ utente.getEmail() + "/" + utente.getPassword() + "/"
//		+ da + "/" + a);









import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.project.fulldentclientandroid.bean.Appuntamento;
import com.project.fulldentclientandroid.bean.Prenotazione;
import com.project.fulldentclientandroid.bean.Visita;
import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.manager.AppuntamentiManager;
import com.project.fulldentclientandroid.manager.InternetManager;
import com.project.fulldentclientandroid.manager.Preferenze;
import com.project.fulldentclientandroid.manager.StoricoManager;
import com.project.fulldentclientandroid.util.Costanti;
import com.project.fulldentclientandroid.util.DateValidator;

/**
 * Verifica se la gestione dello storico
 * avviene correttamente
 * 
 * @author ginofarisano
 * 
 */
public class StoricoManagerTest extends TestCase {

	AppuntamentiManager appuntamentiMenager;
	StoricoManager storicoMenager;
	DateValidator dateValidator;
	Prenotazione prenotazione1;

	Preferenze preferenze;
	
	List listStorico;
	
	
	private String axpected;
	

	
	
	/**
	 * IDPERSONALE->NOMEPERSONALE && COGNOMEPERSONALE
	 */
	private static final String IDPERSONALE = "abcdefghil";
	private static final String NOMEPERSONALE = "simone";
	private static final String COGNOMEPERSONALE = "trotta";
	
	
	/**
	 * IDPRESTAZIONE->NOMEPRESTAZIONE
	 */
	private static final String IDPRESTAZIONE = "3";
	private static final String NOMEPRESTAZIONE = "Estrazione molare";
	
	
	/**
	 * codice fiscale utente
	 */
	private static final String CODICEFISCALE = "frsgni89e01i422h";
	
	
	private static final String ORA = "10:00";
	
	
	//utlizzate per testare intervallo nella sezione storico
	private String date1;
	private String date;
	private String date2;
	

	public StoricoManagerTest(String s) {
		super(s);
	}

	// creo un nuovo appuntamento (data di oggi + 1 anno) e vedo se riesce
	// a visualizzarlo e cancellarlo correttamente
	// non poso impostare in teardown la cancellazione
	// perchè c'è da testare anche un metodo di cancellazione (lo cancellerebbe
	// 2 volte!!!!)
	public void setUp() {
		try {
			preferenze = new Preferenze(Engine.getContext());
			appuntamentiMenager = new AppuntamentiManager();
			dateValidator = new DateValidator();
			storicoMenager=new StoricoManager();
			prenotazione1 = new Prenotazione();
			prenotazione1.setCodiceFiscale(CODICEFISCALE);
			date1=dateValidator.currentTimeForTest("/",-30);
			date=dateValidator.currentTimeForTest("/",-29);
			date2=dateValidator.currentTimeForTest("/",-28);
			
			
			axpected="[Visita[ data="+date+", pagato=NO, note=, nomePrestazione=Estrazione molare, ora=10:00, nomePersonale=simone, cognomePersonale=trotta]]";
			
			//metto 30 anni prima...così non ci sono altri
			//appuntamenti che influenzano il test
			prenotazione1.setData(date);
			prenotazione1.setIdPersonale(IDPERSONALE);
			prenotazione1.setIdPrestazionee(IDPRESTAZIONE);
			prenotazione1.setOra(ORA);
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testPreConditions() {

		assertNotNull(appuntamentiMenager);
		assertNotNull(prenotazione1);
		
		assertNotNull(storicoMenager);
		assertNotNull(preferenze);
		assertNotNull(dateValidator);

	}

	/**
	 * verifica se le date inserite sono la prima più piccola della
	 * seconda
	 */
	public void testCompatibilityDate(){
		assertTrue(dateValidator.beforeOtherDay(date1.replace("/", "-"), date2.replace("/", "-")));
	}
	
	/**
	 * testa se lo storico ricevuto è uguale a quello atteso
	 */
	public void testStorico() {
		
		
		//la prenotazione dovrebbe fallire se fatta in un giorno antecedente
		//a quello odierno
		assertFalse(dateValidator.beforeToday(date));
		
		
		appuntamentiMenager.sendNewAppuntamento(
				Costanti.RICHIESTADATI1 + Costanti.RICHIESTADATI2
						+ Costanti.RICHIESTADATI10
						+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
						+ preferenze.getString(Costanti.EXTRA_PASS),
				prenotazione1);
		

		listStorico = storicoMenager.getStorico(Costanti.RICHIESTADATI1
				+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI4
				+ preferenze.getString(Costanti.EXTRA_MAIL) + "/" + preferenze.getString(Costanti.EXTRA_PASS) + "/"
				+ date1.replace("/", "-") + "/" + date2.replace("/", "-"));
		
		this.assertEquals(axpected, listStorico.toString());
		
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		this.assertTrue("Ricordati di cancellare l'appuntamento appena creato dalla tabella prenotazione!", 1==1);
	}
	
	
	

}
