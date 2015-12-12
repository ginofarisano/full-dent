package com.manager.project.fulldentandroid.manager;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.project.fulldentclientandroid.bean.Appuntamento;
import com.project.fulldentclientandroid.bean.Prenotazione;
import com.project.fulldentclientandroid.bean.Visita;
import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.manager.AppuntamentiManager;
import com.project.fulldentclientandroid.manager.InternetManager;
import com.project.fulldentclientandroid.manager.Preferenze;
import com.project.fulldentclientandroid.util.Costanti;
import com.project.fulldentclientandroid.util.DateValidator;

/**
 * Verifica se la gestione degli appuntamenti
 * avviene correttamente
 * 
 * @author ginofarisano
 * 
 */
public class AppuntamentiManagerTest extends TestCase {

	AppuntamentiManager appuntamentiMenager;

	DateValidator dateValidator;
	Prenotazione prenotazione;
	Preferenze preferenze;
	
	
	
	
	private static final String CODICEFISCALE = "frsgni89e01i422h";
	
	
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
	
	
	private static final String ORA = "10:00";

	public AppuntamentiManagerTest(String s) {
		super(s);
	}

	// creo un nuovo appuntamento (data di oggi + anno) e vedo se riesce
	// a visualizzarlo e cancellarlo correttamente
	// non poso impostare in teardown la cancellazione
	// perchè c'è da testare anche un metodo di cancellazione (lo cancellerebbe
	// 2 volte!!!!)
	public void setUp() {
		try {
			preferenze = new Preferenze(Engine.getContext());
			appuntamentiMenager = new AppuntamentiManager();
			dateValidator = new DateValidator();

			prenotazione = new Prenotazione();
			prenotazione.setCodiceFiscale(CODICEFISCALE);
			//dieci anni avanti
			prenotazione.setData(dateValidator.currentTimeForTest("/",10));
			prenotazione.setIdPersonale(IDPERSONALE);
			prenotazione.setIdPrestazionee(IDPRESTAZIONE);
			prenotazione.setOra(ORA);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testPreConditions() {

		assertNotNull(appuntamentiMenager);
		assertNotNull(prenotazione);
		assertNotNull(preferenze);
		assertNotNull(dateValidator);

	}

	/**
	 * testa se l'appuntamento è inserito correttamente
	 */
	public void testNewAppuntamento() {

		boolean check = appuntamentiMenager.sendNewAppuntamento(
				Costanti.RICHIESTADATI1 + Costanti.RICHIESTADATI2
						+ Costanti.RICHIESTADATI10
						+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
						+ preferenze.getString(Costanti.EXTRA_PASS),
				prenotazione);

		appuntamentiMenager.deleteAppuntamento(Costanti.RICHIESTADATI1
				+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI13
				+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
				+ preferenze.getString(Costanti.EXTRA_PASS));

		assertTrue(check);

	}

	/**
	 * Verifica se il prossimo appuntamento è eliminato correttamente
	 * 
	 */
	public void testDeleteAppuntamento() {

		appuntamentiMenager.sendNewAppuntamento(
				Costanti.RICHIESTADATI1 + Costanti.RICHIESTADATI2
						+ Costanti.RICHIESTADATI10
						+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
						+ preferenze.getString(Costanti.EXTRA_PASS),
				prenotazione);

		assertTrue(appuntamentiMenager.deleteAppuntamento(Costanti.RICHIESTADATI1
						+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI13
						+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
						+ preferenze.getString(Costanti.EXTRA_PASS)));

	}
	
	/**
	 * Testa se il prossimo appuntamento è uguale a quello atteso
	 * ovvero quello creato con sendNewAppuntamento
	 */
	public void testProssimoAppuntamento() {

		appuntamentiMenager.sendNewAppuntamento(
				Costanti.RICHIESTADATI1 + Costanti.RICHIESTADATI2
						+ Costanti.RICHIESTADATI10
						+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
						+ preferenze.getString(Costanti.EXTRA_PASS),
				prenotazione);
		
		
		
		Visita axpected=new Visita();
		
		axpected.setNomePrestazione(NOMEPRESTAZIONE);
		axpected.setOra(ORA);
		axpected.setData(dateValidator.currentTimeForTest("/",10));
		axpected.setNomePersonale(NOMEPERSONALE);
		axpected.setCognomePersonale(COGNOMEPERSONALE);
		
		
		
		
		Visita toReturn;
		
		toReturn=appuntamentiMenager
				.prossimoAppuntamento(Costanti.RICHIESTADATI1
						+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI12
						+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
						+ preferenze.getString(Costanti.EXTRA_PASS));
		
		this.assertEquals(axpected.toString(), toReturn.toString());
		
		appuntamentiMenager.deleteAppuntamento(Costanti.RICHIESTADATI1
				+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI13
				+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
				+ preferenze.getString(Costanti.EXTRA_PASS));
		
		
	}
	/**
	 * Testa se il controllo sull'inserimento di un appuntamento
	 * funziona correttamente 
	 */
	public void testCheckIfisValid(){
		//alloco una lista di appuntamenti
		ArrayList<Appuntamento> appuntamenti=new ArrayList<Appuntamento>();
		
		/**
		 * c'è un buco di un ora...
		 * un appuntamento di un ora dovrebbe entrarci.
		 * Di due ore no...
		 */
		
		
		Appuntamento appuntamento1=new Appuntamento();
		appuntamento1.setDurata("2");
		appuntamento1.setOra("08:00");
		appuntamenti.add(appuntamento1);
		
		Appuntamento appuntamento2=new Appuntamento();
		appuntamento2.setDurata("2");
		appuntamento2.setOra("11:00");
		appuntamenti.add(appuntamento2);
		
		
		/**
		 * dovrebbe entrarci
		 */
		boolean toReturn =appuntamentiMenager.checkIfisValid("10:00","1",appuntamenti);
		
		this.assertTrue(toReturn);
		
		/**
		 * non dovrebbe entrarci
		 */
		
		toReturn =appuntamentiMenager.checkIfisValid("10:00","2",appuntamenti);
		
		
		this.assertFalse(toReturn);
		
		
		
		
		
	}
	
	

}
