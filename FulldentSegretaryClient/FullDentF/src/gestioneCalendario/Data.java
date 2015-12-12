package gestioneCalendario;

// TODO: Auto-generated Javadoc
/**
 * Classe che gestisce le operazioni relative alle funzionalità di una data.
 * @author Max
 *
 */
public class Data {
	
	/** The data. */
	private String data;
	
	/** The ora. */
	private String ora;
	
	/**
	 * Crea un nuovo oggetto data.
	 * @param d il giorno, il mese e l'anno della data.
	 * @param o l'ora della data.
	 */
	public Data(String d,String o){
		data = d;
		ora = o;
	}

	/**
	 * Restituisce la data.
	 * @return la data.
	 */
	public String getData() {
		return data;
	}

	/**
	 * Restituisce l'ora.
	 * @return l'ora.
	 */
	public String getOra() {
		return ora;
	}

	/**
	 * Restituisce il giorno della data.
	 * @return il giorno.
	 */
	public String getGiorno(){
		return data.substring(0,2);
	}
	
	/**
	 * Restituisce il mese della data.
	 * @return il mese.
	 */
	public String getMese(){
		return data.substring(3,5);
	}
	
	/**
	 * Restituisce l'anno della data.
	 * @return l'anno.
	 */ 
	public String getAnno(){
		return data.substring(6);
	}
	
	/**
	 * Sovrascrittura del metodo generico equals. Verifica se gli oggetti sono uguali.
	 * @param x l'oggetto da confrontare.
	 * @return true se sono uguali, false altrimenti.
	 */
	public boolean equals(Object x){
		if(x == null) return false;
		if(x.getClass() != this.getClass()) return false;
		Data y = (Data) x;
		return data.equals(y.getData()) && ora.equals(y.getOra());
	}

}
