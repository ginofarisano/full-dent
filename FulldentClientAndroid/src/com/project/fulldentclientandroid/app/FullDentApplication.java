package com.project.fulldentclientandroid.app;

import com.project.fulldentclientandroid.engine.Engine;

import android.app.Application;


/**
 * Inizializza oggetti utilizzati dall'applicazione
 * 
 * @author ginofarisano
 * @see Engine
 *
 */
public class FullDentApplication extends Application {
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Engine.startApplication(this);
	}
}
