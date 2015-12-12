package com.project.fulldentclientandroid.activity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.fulldentandroid.adapter.VisiteAdapter;
import com.project.fulldentclientandroid.bean.Utente;
import com.project.fulldentclientandroid.bean.Visita;
import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.manager.AppuntamentiManager;
import com.project.fulldentclientandroid.manager.GestioneUtenteManager;
import com.project.fulldentclientandroid.manager.InternetManager;
import com.project.fulldentclientandroid.manager.Login;
import com.project.fulldentclientandroid.manager.Preferenze;
import com.project.fulldentclientandroid.manager.StoricoManager;
import com.project.fulldentclientandroid.util.Costanti;
import com.project.fulldentclientandroid.util.DateValidator;

/**
 * Activity che gestisce ciò che ha a che fare con l'utente (suoi dati -
 * compresa modifica), gestione dello storico (filtraggio per date) e
 * visualizzazione dell'ultimo appuntamento a cui presentarsi
 * 
 * @author ginofarisano
 * 
 */

public class GestioneUtenteActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	static InternetManager internetMan = Engine.getInternetManager();
	static Preferenze preferenze = Engine.getSharedPreferences();

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	static Utente utente = utente = new Utente();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gestione_utente);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));

	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
	}

	/**
	 * Visualizza il titolo della sezione che si sta visualizzando
	 * 
	 * @param number
	 */
	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = Costanti.SECTION1;
			break;
		case 2:
			mTitle = Costanti.SECTION2;
			break;
		case 3:
			mTitle = Costanti.SECTION3;
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.gestione_utente, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * Un placeholder fragment utilizzato per gestire le tre sezioni
	 * disponibili(dati utente - storico - prossimo appuntamento)
	 * 
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		ProgressBar progressBar;

		VisiteAdapter adapter;

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		/**
		 * Visualizza la view selezionata attraverso il drawer. Per ciascuna
		 * sezione è stato creato un metodo che restituisce la view da
		 * visualizzare
		 */

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = null;

			switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
			case 1:

				rootView = datiUtente(inflater, container);

				break;
			case 2:
				rootView = prossimoAppuntamento(inflater, container);
				break;
			case 3:
				rootView = storico(inflater, container);
				break;
			}

			return rootView;
		}

		/***************************************** dati utente section ****************/

		/**
		 * 
		 * Gestione dati utente
		 * 
		 * @param inflater
		 * @param container
		 * @return
		 */
		private View datiUtente(LayoutInflater inflater, ViewGroup container) {
			// TODO Auto-generated method stub

			View rootView = inflater.inflate(R.layout.activity_dati_utente,
					container, false);
			TextView txtViewName = (TextView) rootView
					.findViewById(R.id.textViewNome);
			TextView txtViewCognome = (TextView) rootView
					.findViewById(R.id.textViewCognome);
			TextView txtViewCF = (TextView) rootView
					.findViewById(R.id.textCodiceFiscale);

			final EditText edtTextTelefono = (EditText) rootView
					.findViewById(R.id.editTextTelefono);
			final EditText edtTextEmail = (EditText) rootView
					.findViewById(R.id.editTextEmail);
			final EditText edtTextPassword = (EditText) rootView
					.findViewById(R.id.editPassword);
			final EditText edtTextIndirizzo = (EditText) rootView
					.findViewById(R.id.editIndirizzo);
			final Button btnModifica = (Button) rootView
					.findViewById(R.id.bntModifica);

			progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);

			btnModifica.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					progressBar.setVisibility(View.VISIBLE);
					utente.setEmail(edtTextEmail.getText().toString());
					utente.setIndirizzo(edtTextIndirizzo.getText().toString());
					utente.setPassword(edtTextPassword.getText().toString());
					utente.setTelefono(edtTextTelefono.getText().toString());
					new TaskPostRequest().execute(utente);
				}
			});

			new TaskLogin().execute(txtViewName, txtViewCognome, txtViewCF,
					edtTextTelefono, edtTextEmail, edtTextPassword,
					edtTextIndirizzo, btnModifica);

			return rootView;
		}

		/**
		 * class Task in background utilizzato per l'autenticazione
		 * 
		 * @author ginofarisano
		 * 
		 */
		private class TaskLogin extends AsyncTask<View, Void, Utente> {

			TextView txtViewName;
			TextView txtViewCognome;
			TextView txtViewCF;

			EditText edtTextTelefono;

			EditText edtTextEmail;

			EditText edtTextPassword;

			EditText edtTextIndirizzo;
			Button btnModifica;

			@Override
			protected Utente doInBackground(View... views) {
				// TODO Auto-generated method stub
				txtViewName = (TextView) views[0];
				txtViewCognome = (TextView) views[1];
				txtViewCF = (TextView) views[2];

				edtTextTelefono = (EditText) views[3];

				edtTextEmail = (EditText) views[4];

				edtTextPassword = (EditText) views[5];

				edtTextIndirizzo = (EditText) views[6];

				btnModifica = (Button) views[7];
				// if(!internetMan.checkConnection())
				// return null;
				// bisogna utenticarsi nuovamente perchè i dati dell'utente
				// potrebbero essere cambiati
				Login login = new Login(
						preferenze.getString(Costanti.EXTRA_MAIL),
						preferenze.getString(Costanti.EXTRA_PASS));
				return login.verifica();

			}

			@Override
			protected void onPostExecute(Utente myutente) {
				// TODO Auto-generated method stub
				super.onPostExecute(myutente);

				if (myutente != null) {

					utente.setCodiceFiscale(myutente.getCodiceFiscale());
					utente.setNome(myutente.getNome());
					utente.setCognome(myutente.getCognome());
					utente.setEmail(myutente.getEmail());
					utente.setIndirizzo(myutente.getIndirizzo());
					utente.setPassword(myutente.getPassword());
					utente.setTelefono(myutente.getTelefono());

					txtViewName.setText(utente.getNome());
					txtViewCognome.setText(utente.getCognome());
					txtViewCF.setText(utente.getCodiceFiscale());
					edtTextTelefono.setText(utente.getTelefono());
					edtTextEmail.setText(utente.getEmail());
					edtTextPassword.setText(utente.getPassword());
					edtTextIndirizzo.setText(utente.getIndirizzo());

					TextWatcher watcher = new TextWatcher() {

						boolean flag = false;

						@Override
						public void beforeTextChanged(CharSequence s,
								int start, int count, int after) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onTextChanged(CharSequence s, int start,
								int before, int count) {
							// TODO Auto-generated method stub

						}

						@Override
						public void afterTextChanged(Editable s) {
							// TODO Auto-generated method stub

							if (!flag) {
								flag = true;
								btnModifica.setVisibility(View.VISIBLE);
								Toast.makeText(getActivity(),
										Costanti.CONFERMA, Toast.LENGTH_SHORT)
										.show();
							}

						}

					};

					edtTextTelefono.addTextChangedListener(watcher);
					edtTextEmail.addTextChangedListener(watcher);
					edtTextPassword.addTextChangedListener(watcher);
					edtTextIndirizzo.addTextChangedListener(watcher);
				}

			}

		}

		/**
		 * Task in background per la modifica dei dati. Viene effettua una
		 * chiamata post al web service
		 * 
		 * @author ginofarisano
		 * 
		 */
		private class TaskPostRequest extends
				AsyncTask<Utente, String, Boolean> {

			Utente modify;

			@Override
			protected Boolean doInBackground(Utente... utente) {
				// TODO Auto-generated method stub

				GestioneUtenteManager dataModification = new GestioneUtenteManager();

				// per aggiornare le preferenze in seguito ad un
				// eventuale modifica dei dati
				modify = utente[0];

				boolean toReturn = dataModification.modifyData(
						Costanti.RICHIESTADATI1 + Costanti.RICHIESTADATI2
								+ Costanti.RICHIESTADATI6
								+ utente[0].getEmail() + "/"
								+ utente[0].getPassword(), utente[0]);

				return toReturn;

			}

			@Override
			protected void onPostExecute(Boolean result) {

				super.onPostExecute(result);
				if (result) {

					preferenze.savePreferences(Costanti.EXTRA_MAIL,
							modify.getEmail());
					preferenze.savePreferences(Costanti.EXTRA_PASS,
							modify.getPassword());

					Toast.makeText(getActivity(), Costanti.MSG,
							Toast.LENGTH_SHORT).show();
				} else
					Toast.makeText(getActivity(), Costanti.ERROR,
							Toast.LENGTH_SHORT).show();
				progressBar.setVisibility(View.INVISIBLE);

			}
		}

		/***************************************** fine dati utente section ****************/

		/***************************************** prossimo appuntamento section ****************/

		/**
		 * Visualizza il prossimo appuntamento a cui deve presentarsi l'utente
		 * 
		 * @author ginofarisano
		 * 
		 */
		private View prossimoAppuntamento(LayoutInflater inflater,
				ViewGroup container) {
			// TODO Auto-generated method stub
			View rootView = inflater.inflate(
					R.layout.activity_prossimo_appuntamento, container, false);

			final TextView txtViewData = (TextView) rootView
					.findViewById(R.id.txtViewdata);
			final TextView txtViewWhat = (TextView) rootView
					.findViewById(R.id.txtViewWhat);
			final TextView txtViewDottore = (TextView) rootView
					.findViewById(R.id.txtViewDottore);
			final RelativeLayout rltNotification = (RelativeLayout) rootView
					.findViewById(R.id.relLNotification);

			Button btnRimuovi = (Button) rootView.findViewById(R.id.bntRimuovi);

			progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);

			btnRimuovi.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					progressBar.setVisibility(View.VISIBLE);
					new TaskEliminaAppuntamento().execute(txtViewData,
							txtViewWhat, txtViewDottore, rltNotification);
				}
			});

			new TaskProssimoAppuntamento().execute(txtViewData, txtViewWhat,
					txtViewDottore, rltNotification);
			return rootView;

		}

		/**
		 * Task in background per il download del prossimo appuntamento
		 * 
		 * @author ginofarisano
		 * 
		 */
		private class TaskProssimoAppuntamento extends
				AsyncTask<View, String, Visita> {

			TextView txtViewData;
			TextView txtViewWhat;
			TextView txtViewDottore;
			RelativeLayout rltNotification;

			@Override
			protected Visita doInBackground(View... view) {
				// TODO Auto-generated method stub
				AppuntamentiManager menagerAppuntamenti = new AppuntamentiManager();

				txtViewData = (TextView) view[0];
				txtViewWhat = (TextView) view[1];
				txtViewDottore = (TextView) view[2];
				rltNotification = (RelativeLayout) view[3];

				Visita visita = menagerAppuntamenti
						.prossimoAppuntamento(Costanti.RICHIESTADATI1
								+ Costanti.RICHIESTADATI2
								+ Costanti.RICHIESTADATI5 + utente.getEmail()
								+ "/" + utente.getPassword());
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

					txtViewDottore.setText("Dottor "
							+ visita.getNomePersonale() + " "
							+ visita.getCognomePersonale());
				}

				else
					rltNotification.setVisibility(View.VISIBLE);

			}
		}

		/**
		 * Task in background per l'eliminazione del prossimo appuntamento
		 * 
		 * @author ginofarisano
		 * 
		 */
		protected class TaskEliminaAppuntamento extends
				AsyncTask<View, Void, Boolean> {

			RelativeLayout rltNotification;
			TextView txtViewData;
			TextView txtViewWhat;
			TextView txtViewDottore;

			@Override
			protected Boolean doInBackground(View... view) {
				// TODO Auto-generated method stub

				txtViewData = (TextView) view[0];
				txtViewWhat = (TextView) view[1];
				txtViewDottore = (TextView) view[2];
				rltNotification = (RelativeLayout) view[3];

				AppuntamentiManager menagerAppuntamenti = new AppuntamentiManager();

				// faccio solo una chiamage post con un url
				// il database sa quale è l'ultimo appuntamtno
				boolean bool = menagerAppuntamenti
						.deleteAppuntamento(Costanti.RICHIESTADATI1
								+ Costanti.RICHIESTADATI2
								+ Costanti.RICHIESTADATI11 + utente.getEmail()
								+ "/" + utente.getPassword());

				return bool;

			}

			@Override
			protected void onPostExecute(Boolean bool) {
				// TODO Auto-generated method stub
				super.onPostExecute(bool);

				progressBar.setVisibility(View.INVISIBLE);

				if (bool) {
					Toast.makeText(getActivity(),
							Costanti.CONFERMA_ELIMINAZIONE, Toast.LENGTH_SHORT)
							.show();

					new TaskProssimoAppuntamento().execute(txtViewData,
							txtViewWhat, txtViewDottore, rltNotification);

					// rltNotification.setVisibility(View.VISIBLE);
				} else
					Toast.makeText(getActivity(), Costanti.ERROR,
							Toast.LENGTH_SHORT).show();

			}
		}

		/***************************************** fine prossimo appuntamento section ****************/

		/***************************************** storico section **********************************/

		/**
		 * Visualizza lo storico delle visite dell'utente
		 * 
		 * @author ginofarisano
		 */
		private View storico(LayoutInflater inflater, ViewGroup container) {
			// TODO Auto-generated method stub
			View rootView = inflater.inflate(R.layout.activity_storico,
					container, false);

			final ListView listViewStorico;

			Button btnCerca;
			final EditText edTxtDa;
			final EditText edTxtA;

			listViewStorico = (ListView) rootView
					.findViewById(R.id.listViewStorico);
			btnCerca = (Button) rootView.findViewById(R.id.btnCerca);
			edTxtDa = (EditText) rootView.findViewById(R.id.edtTxtDa);
			edTxtA = (EditText) rootView.findViewById(R.id.edtTxtA);
			final DateValidator dateValidator = new DateValidator();
			btnCerca.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (dateValidator.isThisDateValid(edTxtDa.getText()
							.toString(), "dd-MM-yyyy")
							&& dateValidator.isThisDateValid(edTxtA.getText()
									.toString(), "dd-MM-yyyy")
							&& dateValidator.beforeOtherDay(edTxtDa.getText().toString(),
									edTxtA.getText().toString())) {
						new TaskStorico().execute(edTxtDa.getText().toString(),
								edTxtA.getText().toString(), adapter,
								listViewStorico);
					} else {
						Toast.makeText(getActivity(), Costanti.ERRORDATE,
								Toast.LENGTH_SHORT).show();
					}

				}
			});

			listViewStorico
					.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1,
								int position, long arg3) {
							// TODO Auto-generated method stub
							Visita item = (Visita) adapter.getItem(position);
							Intent intentFirst = new Intent(getActivity(),
									VisitaUtenteActivity.class);

							intentFirst.putExtra("cognomepersonale",
									item.getCognomePersonale());
							intentFirst.putExtra("data", item.getData());
							intentFirst.putExtra("nomepersonale",
									item.getNomePersonale());
							intentFirst.putExtra("nomeprestazione",
									item.getNomePrestazione());
							intentFirst.putExtra("note", item.getNote());
							intentFirst.putExtra("ora", item.getOra());
							intentFirst.putExtra("pagato", item.getPagato());

							startActivity(intentFirst);

						}
					});

			return rootView;
		}

		/**
		 * Task in background pre il download dello storico dell'utente
		 * 
		 * @author ginofarisano
		 * 
		 */
		private class TaskStorico extends AsyncTask<Object, String, Void> {

			String da;
			String a;
			ListView listViewStorico;

			List listStorico;

			@Override
			protected Void doInBackground(Object... params) {
				// TODO Auto-generated method stub

				da = (String) params[0];
				a = (String) params[1];
				adapter = (VisiteAdapter) params[2];
				listViewStorico = (ListView) params[3];

				StoricoManager storicoMenager = new StoricoManager();

				listStorico = storicoMenager.getStorico(Costanti.RICHIESTADATI1
						+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI4
						+ utente.getEmail() + "/" + utente.getPassword() + "/"
						+ da + "/" + a);

				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);
				adapter = new VisiteAdapter(getActivity(),
						R.layout.row_list_visite, listStorico);
				listViewStorico.setAdapter(adapter);
			}
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((GestioneUtenteActivity) activity)
					.onSectionAttached(getArguments()
							.getInt(ARG_SECTION_NUMBER));
		}
	}

}
