package com.project.fulldentclientandroid.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.project.fulldentclientandroid.bean.Utente;
import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.manager.InternetManager;
import com.project.fulldentclientandroid.manager.Login;
import com.project.fulldentclientandroid.manager.Preferenze;
import com.project.fulldentclientandroid.util.Costanti;

/**
 * Utilizzata per effettuare il login
 * 
 * @author ginofarisano
 * 
 */
public class LoginActivity extends Activity {

	InternetManager internetMan = Engine.getInternetManager();
	Preferenze preferenze = Engine.getSharedPreferences();

	RelativeLayout loginLayout;
	ImageView imageLogo;
	EditText edtTxtmail;
	EditText edtTxtpass;
	ProgressBar mProgres;
	String mailData = null;
	String passData = null;
	Button btnAccedi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		loginLayout = (RelativeLayout) findViewById(R.id.login);
		imageLogo = (ImageView) findViewById(R.id.imageLogo);
		edtTxtmail = (EditText) findViewById(R.id.editUsername);
		edtTxtpass = (EditText) findViewById(R.id.editPassword);
		btnAccedi = (Button) findViewById(R.id.bntRichista);
		mProgres = (ProgressBar) findViewById(R.id.progressBar);
		final Animation top = AnimationUtils.loadAnimation(this,
				R.anim.animation_top);
		final Animation down = AnimationUtils.loadAnimation(this,
				R.anim.animation_down);
		final View activityRootView = findViewById(R.id.rlLogin);
		activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(
				new OnGlobalLayoutListener() {
					@Override
					public void onGlobalLayout() {
						int heightDiff = activityRootView.getRootView()
								.getHeight() - activityRootView.getHeight();
						if (heightDiff > 100) { // if more than 100 pixels, its
												// probably a keyboard...
							imageLogo.setVisibility(View.INVISIBLE);
							loginLayout.startAnimation(top);
						} else {
							imageLogo.setVisibility(View.VISIBLE);
							loginLayout.startAnimation(down);
						}
					}
				});
		btnAccedi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String email = edtTxtmail.getText().toString();
				String password = edtTxtpass.getText().toString();
				Login login = new Login(email, password);
				if (login.campivuoti() || login.noChiocciola())
					showDialog(Costanti.CAMPI_VUOTI_NOCHIOCCIOLA);
				// else if (!internetMan.checkConnection())
				// showDialog(Costanti.NO_INTERNET);
				else {
					showDialog(Costanti.VERIFICA_CREDENZIALI);
					new TaskLogin().execute(email, password);
				}
			}
		});
	}

	/**
	 * class Task in background utilizzato per l'autenticazione
	 * 
	 * @author ginofarisano
	 * 
	 */
	private class TaskLogin extends AsyncTask<String, Void, Utente> {

		@Override
		protected Utente doInBackground(String... credenziali) {
			// TODO Auto-generated method stub

			Login login = new Login(credenziali[0], credenziali[1]);

			return login.verifica();

		}

		@Override
		protected void onPostExecute(Utente utente) {
			// TODO Auto-generated method stub
			super.onPostExecute(utente);
			removeDialog(Costanti.VERIFICA_CREDENZIALI);
			if (utente != null) {
				Intent intentFirst = new Intent(LoginActivity.this,
						FirstActivity.class);

				preferenze.savePreferences(Costanti.EXTRA_MAIL,
						utente.getEmail());
				preferenze.savePreferences(Costanti.EXTRA_PASS,
						utente.getPassword());
				preferenze.savePreferences(Costanti.EXTRA_COD_FISC,
						utente.getCodiceFiscale());

				intentFirst.putExtra(Costanti.EXTRA_NAME, utente.getNome());
				intentFirst.putExtra(Costanti.EXTRA_SURNAME,
						utente.getCognome());
				startActivity(intentFirst);
				finish();
			} else
				showDialog(Costanti.CAMPI_ERRATI);
		}
	}

	/**
	 * Utilizzato per visualizzare informazioni sull'app
	 * 
	 * @param View
	 * 
	 */
	public void info(View view) {
		// Intent info = new Intent(this, InfoActivity.class);
		// startActivity(info);
	}

	/**
	 * Utilizzato per creare una Dialog. Gestisce diverse situazioni in cui può
	 * trovarsi l'activity che gestisce il login
	 * 
	 * @param int
	 * @return Dialog
	 */
	protected Dialog onCreateDialog(int id) {

		TextView text;
		ImageView image;
		Dialog dialog;
		switch (id) {
		// connessione internet assente
		case Costanti.NO_INTERNET:
			dialog = new Dialog(this, R.style.cust_dialog);
			dialog.setContentView(R.layout.custom_dialog);
			dialog.setTitle("Accesso");
			text = (TextView) dialog.findViewById(R.id.text);
			text.setText("La connessione ad Internet sembra essere disattivata!");
			image = (ImageView) dialog.findViewById(R.id.image);
			image.setImageResource(R.drawable.ic_launcher);
			dialog.setCancelable(true);
			break;
		// manca la chiocciola
		case Costanti.CAMPI_VUOTI_NOCHIOCCIOLA:
			dialog = new Dialog(this, R.style.cust_dialog);
			dialog.setContentView(R.layout.custom_dialog);
			dialog.setTitle("Accesso");
			text = (TextView) dialog.findViewById(R.id.text);
			text.setText("Inserisci correttamente user e password!");
			image = (ImageView) dialog.findViewById(R.id.image);
			image.setImageResource(R.drawable.ic_launcher);
			dialog.setCancelable(true);
			break;
		// i campi inseriti sono errati
		case Costanti.CAMPI_ERRATI:
			dialog = new Dialog(this, R.style.cust_dialog);
			dialog.setContentView(R.layout.custom_dialog);
			dialog.setTitle("Accesso");
			text = (TextView) dialog.findViewById(R.id.text);
			text.setText("Le credenziali inserite non sono corrette!");
			image = (ImageView) dialog.findViewById(R.id.image);
			image.setImageResource(R.drawable.ic_launcher);
			dialog.setCancelable(true);
			break;
		// dialog verifica credenziali
		case Costanti.VERIFICA_CREDENZIALI:
			dialog = new Dialog(this, R.style.cust_dialog);
			dialog.setContentView(R.layout.verifica_dialog);
			dialog.setTitle("Accesso");
			text = (TextView) dialog.findViewById(R.id.text);
			text.setText("Sto verificando le credenziali!");
			dialog.setCancelable(true);
			break;

		default:
			dialog = null;
		}
		return dialog;
	}

}
