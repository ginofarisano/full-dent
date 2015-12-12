package com.project.fulldentclientandroid.activity;

import java.util.ArrayList;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.fulldentandroid.adapter.ServiziAdapter;
import com.project.fulldentclientandroid.bean.Appuntamento;
import com.project.fulldentclientandroid.bean.Dottore;
import com.project.fulldentclientandroid.bean.Prenotazione;
import com.project.fulldentclientandroid.bean.Servizio;
import com.project.fulldentclientandroid.bean.Visita;
import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.manager.AppuntamentiDottoriManager;
import com.project.fulldentclientandroid.manager.AppuntamentiManager;
import com.project.fulldentclientandroid.manager.InternetManager;
import com.project.fulldentclientandroid.manager.Preferenze;
import com.project.fulldentclientandroid.manager.ServiziManager;
import com.project.fulldentclientandroid.util.Costanti;

public class MainActivityPrenotazione extends ActionBarActivity implements
		ActionBar.TabListener {

	InternetManager internetMan = Engine.getInternetManager();
	Preferenze preferenze = Engine.getSharedPreferences();

	static int selectedView;
	ArrayList<Servizio> servizi = new ArrayList<Servizio>();
	String idDottore;
	String ora;

	public void prenota(View view) {

		ora = ((TextView) view).getText().toString();
		idDottore = dottori.get(selectedView).getIdDottore();
		new TaskServizio().execute();
	}

	protected class TaskServizio extends AsyncTask<Void, String, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub

			ServiziManager serviziMenager = new ServiziManager();

			servizi = serviziMenager.getSerVizi(Costanti.RICHIESTADATI1
					+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI9
					+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
					+ preferenze.getString(Costanti.EXTRA_PASS));

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			showDialog(Costanti.SELEZIONA_SERVIZIO);
		}
	}

	protected Dialog onCreateDialog(int id) {

		TextView text;
		ImageView image;
		Dialog dialog;
		switch (id) {
		case Costanti.SELEZIONA_SERVIZIO:
			dialog = new Dialog(this, R.style.cust_dialog);
			dialog.setContentView(R.layout.custom_dialog_seleziona_servizio);
			dialog.setTitle("Seleziona servizio");
			ListView listView = (ListView) dialog
					.findViewById(R.id.listViewServizi);
			final ServiziAdapter adapter;
			adapter = new ServiziAdapter(this, R.layout.row_list_servizi,
					servizi);
			listView.setAdapter(adapter);

			listView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					Servizio item = (Servizio) adapter.getItem(position);

					Prenotazione prenotazione = new Prenotazione();

					prenotazione.setCodiceFiscale(preferenze
							.getString(Costanti.EXTRA_COD_FISC));
					prenotazione.setIdPrestazionee(item.getIdPrestazione());
					prenotazione.setIdPersonale(idDottore);
					prenotazione.setData(date.replaceAll("-", "/"));
					prenotazione.setOra(ora);

					AppuntamentiManager appuntamentiMenager = new AppuntamentiManager();

					if (appuntamentiMenager.checkIfisValid(ora, item
							.getDurata(), dottori.get(selectedView)
							.getAppuntamenti())) {

						new TaskNewAppuntamento().execute(prenotazione);
						removeDialog(Costanti.SELEZIONA_SERVIZIO);

					} else {
						removeDialog(Costanti.SELEZIONA_SERVIZIO);
						Toast.makeText(MainActivityPrenotazione.this,
								Costanti.ERRORPRENOTAZIONE, Toast.LENGTH_SHORT)
								.show();
					}

				}

			});

			break;
		default:
			dialog = null;
		}
		return dialog;
	}

	protected class TaskNewAppuntamento extends
			AsyncTask<Prenotazione, String, Boolean> {

		Prenotazione prenotazione;

		@Override
		protected Boolean doInBackground(Prenotazione... prenotazioni) {
			// TODO Auto-generated method stub

			prenotazione = prenotazioni[0];

			String ora = prenotazione.getOra();
			if (ora.length() == 4)
				prenotazione.setOra("0" + ora);

			AppuntamentiManager appuntamentiMenager = new AppuntamentiManager();

			boolean toReturn = appuntamentiMenager.sendNewAppuntamento(
					Costanti.RICHIESTADATI1 + Costanti.RICHIESTADATI2
							+ Costanti.RICHIESTADATI10
							+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
							+ preferenze.getString(Costanti.EXTRA_PASS),
					prenotazione);

			return toReturn;

		}

		@Override
		protected void onPostExecute(Boolean result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (result) {
				Toast.makeText(MainActivityPrenotazione.this,
						Costanti.CONFERMAPRENOTAZIONE, Toast.LENGTH_SHORT)
						.show();
				Intent intentFirst = new Intent(MainActivityPrenotazione.this,
						ProssimoAppuntamentoActivity.class);
				
				

				startActivity(intentFirst);

				finish();

			}

			else
				Toast.makeText(MainActivityPrenotazione.this, Costanti.ERROR,
						Toast.LENGTH_SHORT).show();

		}
	}

	private class TaskDottori extends AsyncTask<Void, Void, Void> {
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub

			AppuntamentiDottoriManager dottoriMenager = new AppuntamentiDottoriManager();

			dottori = dottoriMenager.getLisDottori(Costanti.RICHIESTADATI1
					+ Costanti.RICHIESTADATI2 + Costanti.RICHIESTADATI7
					+ preferenze.getString(Costanti.EXTRA_MAIL) + "/"
					+ preferenze.getString(Costanti.EXTRA_PASS), date);

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			// Create the adapter that will return a fragment for each of the
			// three
			// primary sections of the activity.
			final ActionBar actionBar = getSupportActionBar();
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			mSectionsPagerAdapter = new SectionsPagerAdapter(
					getSupportFragmentManager());

			// Set up the ViewPager with the sections adapter.
			mViewPager = (ViewPager) findViewById(R.id.pager);
			mViewPager.setAdapter(mSectionsPagerAdapter);

			// When swiping between different sections, select the corresponding
			// tab. We can also use ActionBar.Tab#select() to do this if we have
			// a reference to the Tab.
			mViewPager
					.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
						@Override
						public void onPageSelected(int position) {
							actionBar.setSelectedNavigationItem(position);
						}
					});

			// For each of the sections in the app, add a tab to the action bar.
			for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
				// Create a tab with text corresponding to the page title
				// defined by
				// the adapter. Also specify this Activity object, which
				// implements
				// the TabListener interface, as the callback (listener) for
				// when
				// this tab is selected.
				actionBar.addTab(actionBar.newTab()
						.setText(mSectionsPagerAdapter.getPageTitle(i))
						.setTabListener(MainActivityPrenotazione.this));
			}
		}
	}

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	String date;

	static ArrayList<Dottore> dottori = new ArrayList<Dottore>();

	private Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_prenotazione);

		Intent intent = getIntent();
		date = intent.getStringExtra("date");

		new TaskDottori().execute();

	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	//
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }

	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// // Handle action bar item clicks here. The action bar will
	// // automatically handle clicks on the Home/Up button, so long
	// // as you specify a parent activity in AndroidManifest.xml.
	// int id = item.getItemId();
	// if (id == R.id.action_settings) {
	// return true;
	// }
	// return super.onOptionsItemSelected(item);
	// }

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		selectedView = tab.getPosition();
		mViewPager.setCurrentItem(selectedView);
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).
			return PlaceholderFragment.newInstance(position + 1, context);
		}

		@Override
		public int getCount() {

			return dottori.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {

			return dottori.get(position).toString();

		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		static Context contex;
		ListView listView;

		TextView txt0800;
		TextView txt0830;
		TextView txt0900;
		TextView txt0930;
		TextView txt1000;
		TextView txt1030;
		TextView txt1100;
		TextView txt1130;
		TextView txt1200;
		TextView txt1230;
		TextView txt1300;
		TextView txt1330;
		TextView txt1400;
		TextView txt1430;
		TextView txt1500;
		TextView txt1530;
		TextView txt1600;
		TextView txt1630;
		TextView txt1700;
		TextView txt1730;
		TextView txt1800;
		TextView txt1830;
		TextView txt1900;
		TextView txt1930;
		TextView txt2000;
		TextView txt2100;
		TextView txt2130;

		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 * 
		 * @param context
		 */
		public static PlaceholderFragment newInstance(int sectionNumber,
				Context context) {
			contex = context;
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			View rootView = inflater.inflate(R.layout.activity_appuntamento,
					container, false);
			ArrayList<Appuntamento> appuntamenti = dottori.get(
					getArguments().getInt(ARG_SECTION_NUMBER) - 1)
					.getAppuntamenti();

			for (int i = 0; i < appuntamenti.size(); i++) {

				int oraInt;
				int durataInt;

				String ora = appuntamenti.get(i).getOra().replace(":", "");
				String durata = appuntamenti.get(i).getDurata();

				if (ora.startsWith("0"))
					oraInt = Integer.parseInt(ora.substring(1));
				else
					oraInt = Integer.parseInt(ora);

				durataInt = Integer.parseInt(durata);

				durataInt = durataInt * 60;

				TextView changeColor;

				while (true) {
					switch (oraInt) {
					case 800:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView800);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 830:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView830);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 900:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView900);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 930:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView930);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1000:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1000);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1030:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1030);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1100:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1100);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1130:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1130);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1200:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1200);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1230:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1230);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1300:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1300);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1330:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1330);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1400:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1400);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1430:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1430);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1500:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1500);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1530:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1530);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1600:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1600);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1630:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1630);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1700:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1700);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1730:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1730);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1800:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1800);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1830:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1830);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1900:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1900);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 1930:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView1930);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;
					case 2000:
						changeColor = (TextView) rootView
								.findViewById(R.id.textView2000);
						changeColor.setBackgroundColor(Color.RED);
						changeColor.invalidate();
						break;

					}

					if (durataInt > 30) {
						durataInt = durataInt - 30;
						if (oraInt % 100 != 30) {
							oraInt = oraInt + 30;
						} else
							oraInt = oraInt + 70;
					}

					else
						break;

				}

			}

			return rootView;
		}
	}

}
