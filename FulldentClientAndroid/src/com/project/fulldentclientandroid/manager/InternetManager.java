package com.project.fulldentclientandroid.manager;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
/**
 * Classe utilizzata per verificare
 * la presenza della connessione ad internet
 * 
 * @author ginofarisano
 *
 */
public class InternetManager {
	private Context context = null;
	private ConnectivityManager connMan = null;

	public InternetManager(Context c) {
		this.context = c;
		try {
			connMan = (ConnectivityManager) c
					.getSystemService(Context.CONNECTIVITY_SERVICE);
		} catch (Exception ex) {
		}
	}

	public boolean checkConnection() {
		if (connMan == null)
			return false;
		NetworkInfo n = connMan.getActiveNetworkInfo();
		if (n != null && n.getState() == State.CONNECTED) {
			return true;
		}
		return false;
	}
}
