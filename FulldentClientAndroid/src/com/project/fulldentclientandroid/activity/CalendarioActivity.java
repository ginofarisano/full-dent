package com.project.fulldentclientandroid.activity;

import java.util.Calendar;

import com.project.fulldentclientandroid.util.Costanti;
import com.project.fulldentclientandroid.util.DateValidator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

/**
 * Permette di selezionare una data per fissare un appuntamento
 * 
 * @author ginofarisano
 * @see MainActivityPrenotazione
 * 
 */
public class CalendarioActivity extends Activity {

	CalendarView calendarView;
	Long date;
	Calendar c = Calendar.getInstance();
	long ToDayMinus1 = c.getTimeInMillis() - 86400000;

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendario);
		calendarView = (CalendarView) findViewById(R.id.calendarView);

		/**
		 * bug da risolvere - non mi fa cliccare sul giorno selezionato.
		 * Soluzione provvisoria, imposto la data selezionata un giorno prima
		 * del giorno corrente
		 * 
		 * 
		 */

		// (un giorno in ms)24*60*60*1000
		calendarView.setDate(c.getTimeInMillis() - 86400000);

		date = calendarView.getDate();

		calendarView.setOnDateChangeListener(new OnDateChangeListener() {

			@Override
			public void onSelectedDayChange(CalendarView view, int year,
					int month, int dayOfMonth) {

				if (calendarView.getDate() != date) {

					date = calendarView.getDate();

					DateValidator datevalidator = new DateValidator();

					String date = datevalidator.modifyFormat(dayOfMonth) + "-"
							+ datevalidator.modifyFormat(month + 1) + "-"
							+ year;

					if (datevalidator.beforeToday(date)) {
						Toast.makeText(getApplicationContext(),
								Costanti.ERRORDATEAFTERTODAY, 0).show();
					}

					else if (datevalidator.isNotHoliday(date)) {
						Toast.makeText(getApplicationContext(),
								Costanti.ERRORDATEHOLIDAY, 0).show();
					}

					else {
						Toast.makeText(getApplicationContext(), date, 0).show();
						Intent intent = new Intent(CalendarioActivity.this,
								MainActivityPrenotazione.class);
						intent.putExtra("date", date);

						startActivity(intent);
					}
				}

			}

		});

	}
}
