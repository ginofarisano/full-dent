package com.project.fulldentclientandroid.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.fulldentclientandroid.bean.Utente;
import com.project.fulldentclientandroid.bean.Visita;
import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.manager.AppuntamentiManager;
import com.project.fulldentclientandroid.manager.InternetManager;
import com.project.fulldentclientandroid.manager.Preferenze;
import com.project.fulldentclientandroid.util.Costanti;

/**
 * Visualizza informazioni sull'ultimo appuntamento
 * al quale l'utente deve presentarsi
 * 
 * @author ginofarisano
 *
 */
public class ProssimoAppuntamentoActivity extends Activity {

	TextView txtViewData;
	TextView txtViewWhat;
	TextView txtViewDottore;
	RelativeLayout rltNotification;
	Button btnRimuovi;
	ProgressBar progressBar;

	InternetManager internetMan = Engine.getInternetManager();
	Preferenze preferenze = Engine.getSharedPreferences();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prossimo_appuntamento);
		txtViewData = (TextView) findViewById(R.id.txtViewdata);
		txtViewWhat = (TextView) findViewById(R.id.txtViewWhat);
		txtViewDottore = (TextView) findViewById(R.id.txtViewDottore);
		rltNotification = (RelativeLayout) findViewById(R.id.relLNotification);

		btnRimuovi = (Button) findViewById(R.id.bntRimuovi);

		progressBar = (ProgressBar) findViewById(R.id.progressBar);

		btnRimuovi.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				progressBar.setVisibility(View.VISIBLE);
				new TaskEliminaAppuntamento().execute();
			}
		});

		new TaskProssimoAppuntamento().execute();

	}
	/**
	 * Task in background per scaricare le informazioni
	 * sull'ultimo appuntamento
	 * 
	 * @author ginofarisano
	 *
	 */
	private class TaskProssimoAppuntamento extends
			AsyncTask<Void, Void, Visita> {

		@Override
		protected Visita doInBackground(Void... params) {
			// TODO Auto-generated method stub
			AppuntamentiManager menagerAppuntamenti = new AppuntamentiManager();

			Visita visita = menagerAppuntamenti
					.prossimoAppuntamento(Costanti.RICHIESTADATI1
							+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI12
							+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
							+ preferenze.getString(Costanti.EXTRA_PASS));
			return visita;

		}

		@Override
		protected void onPostExecute(Visita visita) {
			// TODO Auto-generated method stub
			super.onPostExecute(visita);

			if (visita != null) {
				txtViewData.setText("Visita del " + visita.getData()
						+ " alle ore " + visita.getOra());
				txtViewWhat.setText(visita.getNomePrestazione());

				txtViewDottore.setText("Dottor " + visita.getNomePersonale()
						+ " " + visita.getCognomePersonale());
			}

			else
				rltNotification.setVisibility(View.VISIBLE);

		}
	}
	
	/**
	 * Task in background per l'eliminazione di un appuntamento
	 * 
	 * @author ginofarisano
	 *
	 */
	protected class TaskEliminaAppuntamento extends
			AsyncTask<Void, Void, Boolean> {

		@Override
		protected Boolean doInBackground(Void... params) {
			// TODO Auto-generated method stub

			AppuntamentiManager menagerAppuntamenti = new AppuntamentiManager();

			// faccio solo una chiamage post con un url
			// il database sa quale è l'ultimo appuntamtno
			return menagerAppuntamenti
					.deleteAppuntamento(Costanti.RICHIESTADATI1
							+ Costanti.RICHIESTADATI2
							+ Costanti.RICHIESTADATI11
							+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
							+ preferenze.getString(Costanti.EXTRA_PASS));

		}

		@Override
		protected void onPostExecute(Boolean bool) {
			// TODO Auto-generated method stub
			super.onPostExecute(bool);

			progressBar.setVisibility(View.INVISIBLE);

			if (bool) {
				Toast.makeText(ProssimoAppuntamentoActivity.this,
						Costanti.CONFERMA_ELIMINAZIONE, Toast.LENGTH_SHORT)
						.show();
				finish();
			} else
				Toast.makeText(ProssimoAppuntamentoActivity.this, Costanti.ERROR,
						Toast.LENGTH_SHORT).show();

		}
	}

}
