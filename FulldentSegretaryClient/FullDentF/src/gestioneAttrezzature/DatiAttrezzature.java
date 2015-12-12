package gestioneAttrezzature;
// TODO: Auto-generated Javadoc
/**
 * La classe si occupa di conservare i dati riguardante le attrezzature e fornisce i metodi per modificarle.
 * @author Vincenzo D'Alessio.
 */
public class DatiAttrezzature {

	/** The codice tipo. */
	private int codiceTipo;
	
	/** The nome. */
	private String nome;
	
	/** The quantità. */
	private int quantità;
	
	/** The descrizione. */
	private String descrizione;
	
	/** The codice fornitore. */
	private String codiceFornitore;
	
	/** The locazione. */
	private String locazione;
	
	/** The tipo. */
	private String tipo;
	
	/** The costo. */
	private double costo;
	
	/**
	 * Costruttore (crea un'istanza della classe).
	 * @param ct il codice tipo dell'attrezzatura.
	 * @param name il nome dell'attrezzatura.
	 * @param q la quantità dell'attrezzatura.
	 * @param cost il costo dell'attrezzatura.
	 * @param t il tipo dell'attrezzatura.
	 * @param descriz la descrizione dell'attrezzatura.
	 * @param loc la locazione dell'attrezzatura.
	 * @param cf il codice del fornitore.
	 */
	public DatiAttrezzature(int ct,String name,int q,double cost,String t,String descriz,String loc,String cf){
		codiceTipo = ct;
		nome = name;
		quantità = q;
		costo = cost;
		tipo = t;
		descrizione = descriz;
		locazione = loc;
		codiceFornitore = cf;
	}
	
	/**
	 * Restituisce il codice tipo dell'attrezzatura.
	 * @return il codice dell'attrezzatura.
	 */
	public int getCodiceTipo(){
		return codiceTipo;
	}
	
	/**
	 * Restituisce il nome dell'attrezzatura.
	 * @return il nome dell'attrezzatura.
	 */
	public String getNome(){
		return nome;
	}
	
	/**
	 * Restituisce la quantità dell'attrezzatura. 
	 * @return la quantità dell'attrezzatura.
	 */
	public int getQuantità(){
		return quantità;
	}
	
	/**
	 * Modifica la quantità dell'attrezzatura.
	 * @param q la quantità dell'attrezzatura modificata.
	 */
	public void setQuantità(int q){
		quantità = q;
	}
	
	/**
	 * Restituisce la descrizione dell'attrezzatura.
	 * @return la descrizione dell'attrezzatura.
	 */
	public String getDescrizione(){
		return descrizione;
	}
	
	/**
	 * Modifica la descrizione dell'attrezzatura.
	 * @param descriz la descrizione modificata dell'attrezzatura.
	 */
	public void setDescrizione(String descriz){
		descrizione = descriz;
	} 
	
	/**
	 * Restituisce il codice del fornitore.
	 * @return il codice del fornitore.
	 */
	public String getCodiceFornitore(){
		return codiceFornitore;
	}
	
	/**
	 * Restituisce la locazione dell'attrezzatura.
	 * @return la locazione dell'attrezzatura.
	 */
	public String getLocazione(){
		return locazione;
	}
	
	/**
	 * Modifica la locazione dell'attrezzatura.
	 * @param loc la locazione moficata dell'attrezzatura.
	 */
	public void setLocazione(String loc){
		locazione= loc;
	}
	
	/**
	 * Restituisce il tipo dell'attrezzatura.
	 * @return il tipo dell'attrezzatura.
	 */
	public String getTipo(){
		return tipo;
	}
	
	/**
	 * Restituisce il costo dell'attrezzatura.
	 * @return il costo dell'attrezzatura.
	 */
	public double getCosto(){
		return costo;
	}
	
}
