package com.project.fulldentclientandroid.util;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Varie funzioni di utilità per la lettura di dati in formato json
 * 
 * @author ginofarisano
 *
 */
public class JsonReader {
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	/**
	 * Restuituisce un oggetto json
	 * 
	 * @param url
	 * @return object in formato json
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public static JSONObject readJsonFromUrl(String url) throws IOException,
			JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
	
	
	/**
	 * Restuituisce un array json
	 * 
	 * @param url
	 * @return array in formato json
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public static JSONArray readJsonArrayFromUrl(String url) throws IOException,
	JSONException {
		// TODO Auto-generated method stub
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray array=new JSONArray(jsonText);
			//JSONObject json = new JSONObject("{\"mylist\""+":"+jsonText+"}");
			return array;
		} finally {
			is.close();
		}
	}
	
	
	
}