package gestionePersonale;

// TODO: Auto-generated Javadoc
/**
 * Classe che gestisce le operazioni relative ai dati di un dipendente.
 * @author Maria D'Arco.
 *
 */
public class DatiPersonale {

	/** The codfisc. */
	private String codfisc;
	
	/** The nome. */
	private String nome;
	
	/** The cognome. */
	private String cognome;
	
	/** The residenza. */
	private String residenza;
	
	/** The data nascita. */
	private String dataNascita;
	
	/** The luogo nascita. */
	private String luogoNascita;
	
	/** The tel. */
	private int tel;
	
	/** The tipo. */
	private String tipo;
	
	/** The sesso. */
	private String sesso;
	
	/** The cont. */
	private Contratto cont;
	
	/**
	 * Crea un nuovo dipendente.
	 * @param aCodiceFiscale il codice fiscale del dipendente.
	 * @param aNome il nome del dipendente.
	 * @param aCognome il cognome del dipendente.
	 * @param aResidenza l'indirizzo di residenza del dipendente.
	 * @param aDataNascita la data di nascita del dipendente.
	 * @param aLuogoNascita il luogo di nascita del dipendente.
	 * @param aTelefono il recapito telefonico del dipendente.
	 * @param aTipo il tipo di ruolo ricoperto dal dipendente.
	 * @param aSesso il sesso del dipendente.
	 * @param aContratto il tipo di contratto stipulato.
	 */
	public DatiPersonale(String aCodiceFiscale,String aNome,String aCognome,
					String aResidenza,String aDataNascita,String aLuogoNascita,
					int aTelefono,String aTipo,String aSesso,Contratto aContratto){
		codfisc = aCodiceFiscale;
		nome = aNome;
		cognome = aCognome;
		residenza = aResidenza;
		dataNascita = aDataNascita;
		luogoNascita = aLuogoNascita;
		tel = aTelefono;
		tipo = aTipo;
		sesso = aSesso;
		cont = aContratto;
	}
	
	/**
	 * Restituisce il nome del dipendente.
	 * @return il nome del dipendente.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Restituisce il cognome del dipendente.
	 * @return il cognome del dipendente.
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Restituisce l'indirzzo domiciliare del dipendente.
	 * @return l'indirizzo del dipendente.
	 */
	public String getResidenza() {
		return residenza;
	}
	
	/**
	 * Modifica l'indirizzo domiciliare del dipendente.
	 *
	 * @param residenza il nuovo indirizzo.
	 */
	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}
	
	/**
	 * Restituisce il recapito telefonico del dipendente.
	 * @return il numero di telefono.
	 */
	public int getTel() {
		return tel;
	}
	
	/**
	 * Modifica il numero di telelfono del dipendente.
	 *
	 * @param tel il nuovo recapito telefonico.
	 */
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	/**
	 * Restituisce il tipo di ruolo ricoperto dal dipendente.
	 * @return il ruolo del dipendente.
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * Modifica il tipo di ruolo ricoperto dal dipendente.
	 * @param tipo il nuovo tipo di ruolo.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Restituisce il codice fiscale del dipendente.
	 * @return il codice fiscale del dipendente.
	 */
	public String getCodfisc() {
		return codfisc;
	}
	
	/**
	 * Restituisce la data di nascita del dipendente.
	 * @return la data di nascita del dipendente.
	 */
	public String getDataNascita() {
		return dataNascita;
	}
	
	/**
	 * Restituisce il luogo di nascita del dipendente.
	 * @return il luogo di nascita del dipendente.
	 */
	public String getLuogoNascita() {
		return luogoNascita;
	}
	
	/**
	 * Restituisce il sesso del dipendente.
	 * @return il sesso del dipendente.
	 */
	public String getSesso() {
		return sesso;
	}
	
	/**
	 * Restituisce il contratto del dipendente.
	 * @return il contratto stipulato.
	 */
	public Contratto getCont() {
		return cont;
	}
	
	/**
	 * Modifica il contratto stipulato con il dipendente.
	 * @param cont il nuovo tipo di contratto.
	 */
	public void setCont(Contratto cont) {
		this.cont = cont;
	}	
	
}

