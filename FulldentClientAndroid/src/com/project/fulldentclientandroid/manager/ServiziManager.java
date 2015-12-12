package com.project.fulldentclientandroid.manager;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.fulldentclientandroid.bean.Servizio;
import com.project.fulldentclientandroid.engine.Engine;
import com.project.fulldentclientandroid.util.Costanti;
import com.project.fulldentclientandroid.util.JsonReader;
/**
 * Restituisce informazioni sui servizi
 * fruibili nel centro dentistico
 * 
 * @author ginofarisano
 *
 */
public class ServiziManager {

	ArrayList<Servizio> servizi = new ArrayList<Servizio>();
	/**
	 * Restituisce una lista di servizi
	 * 
	 * @param url del servizio richiesto
	 * 
	 * @return arraylist dei servizi
	 */
	public ArrayList<Servizio> getSerVizi(String url) {
		// TODO Auto-generated method stub
		try {

			JSONArray array = JsonReader

			.readJsonArrayFromUrl(Costanti.RICHIESTADATI1
					+ Costanti.RICHIESTADATI2
					+ Costanti.RICHIESTADATI9
					+ Engine.getSharedPreferences().getString(
							Costanti.EXTRA_MAIL)
					+ "/"
					+ Engine.getSharedPreferences().getString(
							Costanti.EXTRA_PASS));

			int size = array.length();

			JSONObject object;

			for (int i = 0; i < size; i++) {
				object = array.getJSONObject(i);
				Servizio servizio = new Servizio();
				servizio.setNome(object.getString("nome"));
				servizio.setCosto(object.getString("costo"));
				servizio.setDurata(object.getString("durata"));
				servizio.setIdPrestazione(object.getString("idPrestazione"));
				servizi.add(servizio);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return servizi;

	}
}
