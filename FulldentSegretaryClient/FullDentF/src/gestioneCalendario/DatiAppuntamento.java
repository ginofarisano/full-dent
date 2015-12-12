package gestioneCalendario;

// TODO: Auto-generated Javadoc
/**
 * Classe che gestisce le operazioni relative ad un appuntamento.
 * @author Max
 *
 */
public class DatiAppuntamento {

	/** The nome paziente. */
	private String nomePaziente;
	
	/** The cognome paziente. */
	private String cognomePaziente;
	
	/** The nome medico. */
	private String nomeMedico;
	
	/** The cognome medico. */
	private String cognomeMedico;
	
	/** The tipo servizio. */
	private String tipoServizio;
	
	/** The richiamo. */
	private int richiamo;
	
	/** The data appuntamento. */
	private Data dataAppuntamento;
	
	/**
	 * Crea un nuovo appuntamento.
	 * @param np il nome del paziente.
	 * @param cp il cognome del paziente.
	 * @param nm il nome del medico.
	 * @param cm il cognome del medico.
	 * @param ts il tipo di servizio.
	 * @param d la data dell'appuntamento.
	 * @param o l'ora dell'appuntamento.
	 */
	public DatiAppuntamento(String np,String cp, String nm, String cm, String ts, String d, String o){
		nomePaziente = np;
		cognomePaziente = cp;
		nomeMedico = nm;
		cognomeMedico = cm;
		tipoServizio = ts;
		richiamo = 0;
		dataAppuntamento = new Data(d,o);
	}

	/**
	 * Restituisce il nome del paziente.
	 * @return il nome del paziente.
	 */
	public String getNomePaziente() {
		return nomePaziente;
	}

	/**
	 * Restituisce il cognome del paziente.
	 * @return il cognome del paziente.
	 */
	public String getCognomePaziente() {
		return cognomePaziente;
	}

	/**
	 * Restituisce il nome del medico a cui è stato assegnato il paziente.
	 * @return il nome del medico.
	 */
	public String getNomeMedico() {
		return nomeMedico;
	}

	/**
	 * Restituisce il cognome del medico a cui è stato assegnato il paziente.
	 * @return il cognome del medico.
	 */
	public String getCognomeMedico() {
		return cognomeMedico;
	}

	/**
	 * Restituisce il tipo di servizio richiesto.
	 * @return il tipo di servizio.
	 */
	public String getTipoServizio() {
		return tipoServizio;
	}

	/**
	 * Restituisce la data dell'appuntamento.
	 * @return la data.
	 */
	public Data getDataAppuntamento() {
		return dataAppuntamento;
	}

	/**
	 * Restituisce lo stato di richiamo dell'appuntamento.
	 * @return 1 se e' stato effettuato il richiamo, 0 altrimenti.
	 */
	public int getRichiamo(){
		return richiamo;
	}
	
	/**
	 * Esegue il richiamo di un appuntamento settando il valore del richiamo a 1.
	 */
	public void setRichiamo(){
		richiamo = 1;
	}
	
	/**
	 * Sovrascrittura del metodo generico equals. Verifica se l'oggetto passato è uguale al paramero implicito.
	 * @param x l'oggetto da confrontare.
	 * @return true se sono uguali, false altrimenti.
	 */
	public boolean equals(Object x){
		if(x == null) return false;
		if(x.getClass() != this.getClass()) return false;
		DatiAppuntamento y = (DatiAppuntamento) x;
		return nomePaziente.equals(y.getNomePaziente()) && cognomePaziente.equals(y.getCognomePaziente()) &&
				nomeMedico.equals(y.getNomeMedico()) && cognomeMedico.equals(y.getCognomeMedico()) &&
				tipoServizio.equals(y.getTipoServizio()) && richiamo == y.getRichiamo() &&
				dataAppuntamento.equals(y.getDataAppuntamento());
		
	}
	
}
