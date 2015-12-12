package com.project.fulldentclientandroid.bean;

import java.util.ArrayList;

/**
 * Bean dottore contenente informazioni su ciascun dottore
 * compresi gli appuntamenti per il giorno in cui l'utente
 * intende prenotare una vistia
 * 
 * @author ginofarisano
 * @see Appuntamento
 *
 */
public class Dottore {

	
	private String nome="";
	private String cognome="";
	private String idDottore="";
	private ArrayList<Appuntamento> appuntamenti=new ArrayList<Appuntamento>();

	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getIdDottore() {
		return this.idDottore;
	}
	
	public void setIdDottore(String idDottore) {
		this.idDottore = idDottore;
	}
	
	public ArrayList<Appuntamento> getAppuntamenti() {
		return this.appuntamenti;
	}
	
	public void setAppuntamento(Appuntamento appuntamento) {
		this.appuntamenti.add(appuntamento);
	}
	
	
	
	@Override
	public String toString() {
		
		return"Dottor "+ nome+" "+cognome;
	

		
	}

	@Override public boolean equals(Object o) {
	     // Return true if the objects are identical.
	     // (This is just an optimization, not required for correctness.)
	     if (this == o) {
	       return true;
	     }

	     // Return false if the other object has the wrong type.
	     // This type may be an interface depending on the interface's specification.
	     if (!(o instanceof Dottore)) {
	       return false;
	     }

	     // Cast to the appropriate type.
	     // This will succeed because of the instanceof, and lets us access private fields.
	     Dottore dottore = (Dottore) o;

	     // Check each field. Primitive fields, reference fields, and nullable reference
	     // fields are all treated differently.
	     boolean boolName=this.nome.equals(dottore.nome);
	     boolean boolCognome=this.cognome.equals(dottore.cognome);
	     
	     if(!boolName || !boolCognome)
	    	 return false;
	     
	     String durata;
	     String ora;
	     
	     for(int i=0;i<dottore.appuntamenti.size();i++){
	    	 if(!dottore.appuntamenti.get(i).equals(this.appuntamenti.get(i)))
	    		 return false;
	     }
	     
	     return true;
	    	 
	   }
	 
	
	
	
	
	
}