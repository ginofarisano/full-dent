package com.project.fulldentclientandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class VisitaUtenteActivity extends Activity {

	TextView txtViewTitle;
	TextView txtViewDottore;
	TextView txtViewInformazioni;
	TextView txtViewPagato;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details_visita);
		txtViewTitle = (TextView) findViewById(R.id.txtViewTitle);
		txtViewDottore = (TextView) findViewById(R.id.txtViewDottore);
		txtViewInformazioni = (TextView) findViewById(R.id.txtViewInformazioni);
		txtViewPagato = (TextView) findViewById(R.id.txtViewPagato);
		Intent intent = getIntent();

		String cognomepersonale = intent.getStringExtra("cognomepersonale");
		String data = intent.getStringExtra("data");
		String nomepersonale = intent.getStringExtra("nomepersonale");
		String nomeprestazione = intent.getStringExtra("nomeprestazione");
		String note = intent.getStringExtra("note");
		String ora = intent.getStringExtra("ora");
		String pagato = intent.getStringExtra("pagato");

		txtViewTitle.setText(nomeprestazione + " del " + data + " alle ore "
				+ ora);
		txtViewDottore.setText("Dott. " + nomepersonale + " "
				+ cognomepersonale);
		txtViewInformazioni.setText(note);
		txtViewPagato.setText("Pagato: " + pagato);

	}

}
