package com.project.fulldentclientandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.project.fulldentclientandroid.bean.Utente;
import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.manager.InternetManager;
import com.project.fulldentclientandroid.manager.Login;
import com.project.fulldentclientandroid.manager.Preferenze;
import com.project.fulldentclientandroid.util.Costanti;

/**
 * 
 * Prima activity mostrata al lancio del programma. Controlla se l'utente è
 * presente nelle preferenze e in caso affermativo effettua automaticamente il
 * login
 * 
 * @author ginofarisano
 * 
 */
public class SplashActivity extends Activity {

	InternetManager internetMan = Engine.getInternetManager();
	Preferenze preferenze = Engine.getSharedPreferences();

	ProgressBar mProgress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splash);

		mProgress = (ProgressBar) findViewById(R.id.progressBar);
		mProgress.setVisibility(mProgress.VISIBLE);

		String mail = preferenze.getString(Costanti.EXTRA_MAIL);
		String password = preferenze.getString(Costanti.EXTRA_PASS);

		new TaskLogin().execute(mail, password);

	}

	/**
	 * Verifica le credenziali salvate precedentemente nelle preferenze. Se la
	 * segretaria non ha cancellato l'utente quest'ultimo può accedere senza
	 * effettuare il login
	 * 
	 * @author ginofarisano
	 * 
	 */
	private class TaskLogin extends AsyncTask<String, Void, Utente> {

		@Override
		protected Utente doInBackground(String... credenziali) {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// if(!internetMan.checkConnection())
			// return null;

			Login login = new Login(credenziali[0], credenziali[1]);

			return login.verifica();

		}

		@Override
		protected void onPostExecute(Utente utente) {
			// TODO Auto-generated method stub
			super.onPostExecute(utente);

			if (utente != null) {

				Intent intentFirst = new Intent(SplashActivity.this,
						FirstActivity.class);
				intentFirst.putExtra(Costanti.EXTRA_NAME, utente.getNome());
				intentFirst.putExtra(Costanti.EXTRA_SURNAME,
						utente.getCognome());

				startActivity(intentFirst);

			} else {

				Intent intentLogin = new Intent(SplashActivity.this,

				LoginActivity.class);

				startActivity(intentLogin);

			}

			mProgress.setVisibility(mProgress.INVISIBLE);

			finish();

		}

	}
}
