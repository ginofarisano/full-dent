package com.project.fulldentclientandroid.manager;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.fulldentclientandroid.bean.Visita;
import com.project.fulldentclientandroid.util.Costanti;
import com.project.fulldentclientandroid.util.JsonReader;
/**
 * Classe utilizzata per gestire lo storico
 * delle visite effettuate dall'utente
 * 
 * @author ginofarisano
 *
 */
public class StoricoManager {
	
	List listStorico = new LinkedList();

	public List getStorico(String url) {
		// TODO Auto-generated method stub
		try {

			JSONArray array = JsonReader

			.readJsonArrayFromUrl(url);

			int size = array.length();

			JSONObject object;

			for (int i = 0; i < size; i++) {
				object = array.getJSONObject(i);
				Visita visita = new Visita();
				visita.setCognomePersonale(object.getString("cognomePersonale"));
				visita.setData(object.getString("data"));
				visita.setNomePersonale(object.getString("nomePersonale"));
				visita.setNomePrestazione(object.getString("nomePrestazione"));
				visita.setNote(object.getString("note"));
				visita.setOra(object.getString("ora"));
				visita.setPagato(object.getString("pagato"));
				listStorico.add(visita);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listStorico;
	}
	
	

}
