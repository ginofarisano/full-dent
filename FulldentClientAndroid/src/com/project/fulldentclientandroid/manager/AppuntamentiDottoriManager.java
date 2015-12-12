package com.project.fulldentclientandroid.manager;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.fulldentclientandroid.bean.Appuntamento;
import com.project.fulldentclientandroid.bean.Dottore;
import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.util.Costanti;
import com.project.fulldentclientandroid.util.JsonReader;
/**
 * Menager utilizzato per interrogare il web service su informazioni che
 * riguardano i dottori (dati di quest'ultimi e appuntamenti in una determinata data).
 * 
 * @author ginofarisano
 * @see dottori
 *
 */
public class AppuntamentiDottoriManager {

	ArrayList<Dottore> dottori = new ArrayList<Dottore>();
	
	public ArrayList<Dottore> getLisDottori(String string, String date) {
		// TODO Auto-generated method stub
		try {

			JSONArray array = JsonReader

			.readJsonArrayFromUrl(Costanti.RICHIESTADATI1
					+ Costanti.RICHIESTADATI2
					+ Costanti.RICHIESTADATI7
					+ Engine.getSharedPreferences().getString(
							Costanti.EXTRA_MAIL)
					+ "/"
					+ Engine.getSharedPreferences().getString(
							Costanti.EXTRA_PASS));

			int size = array.length();

			JSONObject object;

			for (int i = 0; i < size; i++) {
				object = array.getJSONObject(i);
				Dottore dottore = new Dottore();
				dottore.setNome(object.getString("nome"));
				dottore.setCognome(object.getString("cognome"));
				dottore.setIdDottore(object.getString("idDottore"));
				dottori.add(dottore);
			}

			for (int i = 0; i < dottori.size(); i++) {
				array = JsonReader

				.readJsonArrayFromUrl(Costanti.RICHIESTADATI1
						+ Costanti.RICHIESTADATI2
						+ Costanti.RICHIESTADATI8
						+ Engine.getSharedPreferences().getString(
								Costanti.EXTRA_MAIL)
						+ "/"
						+ Engine.getSharedPreferences().getString(
								Costanti.EXTRA_PASS) + "/" + date + "/"
						+ dottori.get(i).getIdDottore());

				size = array.length();

				for (int j = 0; j < size; j++) {
					object = array.getJSONObject(j);
					Appuntamento appuntamento = new Appuntamento();
					appuntamento.setDurata(object.getString("durata"));
					appuntamento.setOra(object.getString("ora"));
					dottori.get(i).setAppuntamento(appuntamento);
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dottori;

	}

}
