package com.project.fulldentclientandroid.engine;

import android.content.Context;
import android.content.SharedPreferences;

import com.project.fulldentclientandroid.manager.InternetManager;
import com.project.fulldentclientandroid.manager.Preferenze;
import com.project.fulldentclientandroid.util.Costanti;
/**
 * Classe con variabili statiche utilizzata per:
 * -settare e restituire il context dell'applicazione lì dove quest'ultimo
 * non è accessibile attraverso l'activity
 * -controllare la presenza della connessione ad internet
 * -salvare le pregerenze
 * 
 * 
 * @author ginofarisano
 * @see Context
 * @see InternetMenager
 * @see Preferenze
 *
 */
public class Engine {

	static Context context;
	static InternetManager internetMan;
	static Preferenze preferenze;

	public static void startApplication(Context c) {
		try {
			context = c;
			internetMan = new InternetManager(context);
			preferenze=new Preferenze(context);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Context getContext() {
		return context;
	}

	public static InternetManager getInternetManager() {
		return internetMan;
	}

	public static Preferenze getSharedPreferences() {
		return preferenze;
	}
}
