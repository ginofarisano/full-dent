package com.project.fulldentclientandroid.bean;


/**
 * Bean appuntamento utilizzato per 
 * visualizzare gli orari non disponibili al momento della 
 * prenotazione
 * 
 * @author ginofarisano
 *
 */
public class Appuntamento {

	
	private String ora="";
	private String durata="";

	
	public String getOra() {
		return this.ora;
	}
	
	public void setOra(String ora) {
		this.ora = ora;
	}
	
	public String getDurata() {
		return this.durata;
	}
	
	public void setDurata(String durata) {
		this.durata = durata;
	}

	// Use @Override to avoid accidental overloading.
	   @Override public boolean equals(Object o) {
	     // Return true if the objects are identical.
	     // (This is just an optimization, not required for correctness.)
	     if (this == o) {
	       return true;
	     }

	     // Return false if the other object has the wrong type.
	     // This type may be an interface depending on the interface's specification.
	     if (!(o instanceof Appuntamento)) {
	       return false;
	     }

	     // Cast to the appropriate type.
	     // This will succeed because of the instanceof, and lets us access private fields.
	     Appuntamento appuntamento = (Appuntamento) o;

	     // Check each field. Primitive fields, reference fields, and nullable reference
	     // fields are all treated differently.
	     if(this.ora.equals(appuntamento.ora) && this.durata.equals(appuntamento.durata))
	    	 return true;
	     
	     
	     return false;
	     
	   }
	
	
	
}