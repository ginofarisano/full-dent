package com.project.fulldentclientandroid.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.project.fulldentclientandroid.bean.Utente;

/**
 * Utilizzato per gestire e manipolare i dati dell'utente
 * 
 * @author ginofarisano
 *
 */
public class GestioneUtenteManager {

	public boolean modifyData(String url, Utente utente) {

		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();

			HttpPost postRequest = new HttpPost(url);

			StringEntity input = new StringEntity(utente.toString());
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
