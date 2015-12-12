package com.manager.project.fulldentandroid.manager;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.project.fulldentclientandroid.bean.Appuntamento;
import com.project.fulldentclientandroid.bean.Dottore;
import com.project.fulldentclientandroid.bean.Prenotazione;
import com.project.fulldentclientandroid.bean.Visita;
import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.manager.AppuntamentiDottoriManager;
import com.project.fulldentclientandroid.manager.AppuntamentiManager;
import com.project.fulldentclientandroid.manager.InternetManager;
import com.project.fulldentclientandroid.manager.Preferenze;
import com.project.fulldentclientandroid.util.Costanti;
import com.project.fulldentclientandroid.util.DateValidator;

/**
 * 
 * Caso di test: inserisco un appuntamento e vedo se realmente quel dottore ha
 * quegli appuntamenti. Inoltre controllo che i dottori visualizzati siano
 * effettivamente tutti quelli che operano nel centro.
 * 
 * @author ginofarisano
 * 
 */
public class AppuntamentiDottoriManagerTest extends TestCase {

	AppuntamentiDottoriManager appuntamentiDottoriMenager;
	AppuntamentiManager appuntamentiMenager;
	DateValidator dateValidator;
	Prenotazione prenotazione;
	Preferenze preferenze;
	ArrayList<Dottore> dottoriAxpected;
	Dottore dottore1;
	Dottore dottore2;
	Appuntamento appuntamento;

	// codice fiscale dell'utente che prenota
	private static final String CODICEFISCALE = "frsgni89e01i422h";

	/** dottori che mi aspetto di ricevere **/

	private static final String IDPERSONALE1 = "abcdefghil";
	private static final String NOMEPERSONALE = "simone";
	private static final String COGNOMEPERSONALE = "trotta";

	private static final String IDPERSONALE2 = "ccccbbbbaaaa";
	private static final String NOMEPERSONALE2 = "mario";
	private static final String COGNOMEPERSONALE2 = "rossi";

	/**
	 * id prestazione e sua relativa durata. Mi apetto di ricevere questa
	 * prenotazione visto che la invio al server nel metodo setUp()
	 * **/

	private static final String IDPRESTAZIONE = "3";
	private static final String DURATA_PRESTAZIONE = "2";
	private static final String NOMEPRESTAZIONE = "Estrazione molare";
	private static final String ORA = "10:00";

	public AppuntamentiDottoriManagerTest(String s) {
		super(s);
	}

	// inizializzo i vari valori
	public void setUp() {
		try {
			appuntamentiDottoriMenager = new AppuntamentiDottoriManager();

			preferenze = new Preferenze(Engine.getContext());
			appuntamentiMenager = new AppuntamentiManager();
			dateValidator = new DateValidator();

			/** prenotazione da mandare al server **/

			prenotazione = new Prenotazione();
			prenotazione.setCodiceFiscale(CODICEFISCALE);
			//lo prenoto tra un anno così non da problemi
			//con gli appuntamenti esistenti
			prenotazione.setData(dateValidator.currentTimeForTest("/",1));
			prenotazione.setIdPersonale(IDPERSONALE1);
			prenotazione.setIdPrestazionee(IDPRESTAZIONE);
			prenotazione.setOra(ORA);

			appuntamentiMenager.sendNewAppuntamento(Costanti.RICHIESTADATI1
					+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI10
					+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
					+ preferenze.getString(Costanti.EXTRA_PASS), prenotazione);

			/** dottori e loro appuntamenti in base a quelli creati sopra **/

			dottoriAxpected = new ArrayList<Dottore>();

			dottore1 = new Dottore();
			dottore2 = new Dottore();

			// il primo dottore ha un appuntamento
			dottore1.setNome(NOMEPERSONALE);
			dottore1.setCognome(COGNOMEPERSONALE);
			dottore1.setIdDottore(IDPERSONALE1);

			appuntamento = new Appuntamento();
			appuntamento.setOra(ORA);
			appuntamento.setDurata(DURATA_PRESTAZIONE);

			dottore1.setAppuntamento(appuntamento);

			dottore2.setNome(NOMEPERSONALE2);
			dottore2.setCognome(COGNOMEPERSONALE2);
			dottore2.setIdDottore(IDPERSONALE2);

			dottoriAxpected.add(dottore1);
			dottoriAxpected.add(dottore2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testPreConditions() {

		assertNotNull(appuntamentiMenager);
		assertNotNull(prenotazione);
		assertNotNull(preferenze);
		assertNotNull(dateValidator);
		assertNotNull(appuntamentiDottoriMenager);

	}
	
	/**
	 * testa se i dottori e i loro appuntamenti vengono correttamente
	 * visualizzati
	 * 
	 */
	public void testCheckAppuntamentiDottori() {

		ArrayList<Dottore> dottoriActual = appuntamentiDottoriMenager
				.getLisDottori(Costanti.RICHIESTADATI1
						+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI7
						+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
						+ preferenze.getString(Costanti.EXTRA_PASS),
						dateValidator.currentTimeForTest("-",1));

		// visto che è un arraylisr devo testarlo per tutti i dottori

		if (dottoriActual.size() == dottoriAxpected.size())
			for (int i = 0; i < dottoriActual.size(); i++) {
				if (dottoriActual.get(i).equals(dottoriAxpected.get(i)))
					assertTrue(true);
				else
					assertTrue(false);
			}

	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		appuntamentiMenager.deleteAppuntamento(Costanti.RICHIESTADATI1
				+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI13
				+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
				+ preferenze.getString(Costanti.EXTRA_PASS));
	}
	
	

}
