package com.project.fulldentclientandroid.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.manager.InternetManager;
import com.project.fulldentclientandroid.manager.Preferenze;
import com.project.fulldentclientandroid.util.Costanti;

/**
 * Activity che visualizza un messaggio di benvenuto all'utente loggatosi.
 * Permette di effettuare due scelte a seconda se l'utente vuole prenotare una
 * nuova visita oppure consultare i suoi dati (storico, prossimo appuntamento)
 * 
 * @author ginofarisano
 * 
 * @see MainActivityPrenotazione
 * @see GestioneUtenteActivity
 * 
 */
public class FirstActivity extends Activity {

	Preferenze preferenze = Engine.getSharedPreferences();
	InternetManager internetMan = Engine.getInternetManager();

	TextView txtBenvenuto;
	ProgressDialog dialog = null;
	Intent intentfirst;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtBenvenuto = (TextView) findViewById(R.id.txtUsername);
		intentfirst = getIntent();
		String name = intentfirst.getStringExtra(Costanti.EXTRA_NAME);
		String surname = intentfirst.getStringExtra(Costanti.EXTRA_SURNAME);
		txtBenvenuto.setText("Benvenuto " + name + " " + surname);
	}

	/**
	 * Lancia l'attività GestioneUtenteActivity
	 * 
	 * @param View
	 * @see GestioneUtenteActivity
	 * 
	 */
	public void gestioneUtente(View view) {
		// if (!internetMan.checkConnection())
		// showDialog(Costanti.NO_INTERNET);
		// else

		{
			Intent intent = new Intent(FirstActivity.this,
					GestioneUtenteActivity.class);
			startActivity(intent);
		}
	}

	/**
	 * Lancia l'attività CalendarioActivity
	 * 
	 * @param View
	 * @see CalendarioActivity
	 * 
	 */
	public void prenota(View view) {
		// if (!internetMan.checkConnection())
		// showDialog(Costanti.NO_INTERNET);
		// else
		{
			Intent intent = new Intent(FirstActivity.this,
					CalendarioActivity.class);
			startActivity(intent);
		}

	}

	/**
	 * Effettua i logout dell'utente reinderizzando quest'ultimo all'activity
	 * LoginActivity
	 * 
	 * @see Preferenze
	 * @see LoginActivity
	 * 
	 */
	public void logout(View view) {
		preferenze.savePreferences(Costanti.EXTRA_MAIL, "nulla");
		preferenze.savePreferences(Costanti.EXTRA_PASS, "nulla");
		preferenze.savePreferences(Costanti.EXTRA_COD_FISC, "nulla");
		Intent intentFirst = new Intent(FirstActivity.this, LoginActivity.class);
		startActivity(intentFirst);
		finish();

	}

}
