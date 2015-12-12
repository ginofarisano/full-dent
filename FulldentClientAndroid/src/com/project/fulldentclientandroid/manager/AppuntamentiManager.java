package com.project.fulldentclientandroid.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import com.project.fulldentclientandroid.bean.Appuntamento;
import com.project.fulldentclientandroid.bean.Prenotazione;
import com.project.fulldentclientandroid.bean.Utente;
import com.project.fulldentclientandroid.bean.Visita;
import com.project.fulldentclientandroid.util.JsonReader;


/**
 * Gestisce gli appuntamenti dell'utente
 * 
 * @author ginofarisano
 *
 */
public class AppuntamentiManager {
	
	/**
	 * Elimina l'ultimo appuntamento a cui deve presentarsi l'utente
	 * 
	 * @param url
	 * @return
	 */
	public boolean deleteAppuntamento(String url) {

		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();

			HttpPost postRequest = new HttpPost(url);

			// StringEntity input = new StringEntity(utente.toString());
			// input.setContentType("application/json");
			// postRequest.setEntity(input);

			HttpResponse response = httpClient.execute(postRequest);

			if (response.getStatusLine().getStatusCode() != 201) {

				return false;

				// throw new RuntimeException(
				// "Failed : HTTP error code : "
				// + response.getStatusLine()
				// .getStatusCode());

			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return true;

	}

	/**
	 * Restituisce il prossimo appuntamento a cui dovrà presentarsi l'utente. La
	 * gestione della data corrente è delegata al server
	 * 
	 * @param url
	 * @return Visita
	 */
	public Visita prossimoAppuntamento(String url) {

		Visita visita = new Visita();

		try {

			JSONObject object = JsonReader.readJsonFromUrl(url);

			visita.setCognomePersonale(object.getString("cognomePersonale"));
			visita.setData(object.getString("data"));
			visita.setNomePersonale(object.getString("nomePersonale"));
			visita.setNomePrestazione(object.getString("nomePrestazione"));

			visita.setOra(object.getString("ora"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (visita.getOra().equals("")) ? null : visita;
	}
	
	
	/**
	 * 
	 * Controlla se la visita che vuole prenotare l'utente
	 * è compatibile con quelle già presenti nel database
	 * 
	 * @param ora
	 * @param durata
	 * @param appuntamenti
	 * @return boolean
	 */
	public boolean checkIfisValid(String ora, String durata,
			ArrayList<Appuntamento> appuntamenti) {

		Set<Integer> myHoursAllocation = new HashSet<Integer>();
		Set<Integer> othersHoursAllocation = new HashSet<Integer>();
		
		
		//è possibile prenotare fino alle 20
		othersHoursAllocation.add(2030);
		
		
		
		

		String toParseOthersHours;
		int parsedOtherHours;
		int intOthersTime;

		for (int i = 0; i < appuntamenti.size(); i++) {

			intOthersTime = Integer.parseInt(appuntamenti.get(i).getDurata());

			intOthersTime = intOthersTime * 60;

			toParseOthersHours = appuntamenti.get(i).getOra().replace(":", "");
			parsedOtherHours = appuntamenti.get(i).getOra().startsWith("0") ? Integer
					.parseInt(toParseOthersHours.substring(1)) : Integer
					.parseInt(toParseOthersHours);

			while (true) {

				othersHoursAllocation.add(parsedOtherHours);
				intOthersTime = intOthersTime - 30;

				if (intOthersTime < 30)
					break;
				else {

					if (parsedOtherHours % 100 != 30) {
						parsedOtherHours = parsedOtherHours + 30;
					} else
						parsedOtherHours = parsedOtherHours + 70;
				}
			}

		}
		
		String toParseMyHours;
		int parsedMyHours;
		int intMyTime;
		
		intMyTime = Integer.parseInt(durata);

		intMyTime = intMyTime * 60;

		toParseMyHours = ora.replace(":", "");
		parsedMyHours = toParseMyHours.startsWith("0") ? Integer
				.parseInt(toParseMyHours.substring(1)) : Integer
				.parseInt(toParseMyHours);
		
		
		
		while (true) {

			myHoursAllocation.add(parsedMyHours);
			intMyTime = intMyTime - 30;

			if (intMyTime < 30)
				break;
			else {

				if (parsedMyHours % 100 != 30) {
					parsedMyHours = parsedMyHours + 30;
				} else
					parsedMyHours = parsedMyHours + 70;
			}
		}
		
		return !othersHoursAllocation.removeAll(myHoursAllocation);  
		
		
		
		
	}
	
	/**
	 * Invia un nuovo appuntamento al web service
	 * 
	 * @param string
	 * @param prenotazione
	 * @return boolean
	 */
	public boolean sendNewAppuntamento(String string, Prenotazione prenotazione) {

		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(string);

			StringEntity input = new StringEntity(prenotazione.toString());
			input.setContentType("application/json");
			postRequest.setEntity(input);

			HttpResponse response = httpClient.execute(postRequest);

			if (response.getStatusLine().getStatusCode() != 201) {

				return false;

				// throw new RuntimeException(
				// "Failed : HTTP error code : "
				// + response.getStatusLine()
				// .getStatusCode());

			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return true;

	}

}
