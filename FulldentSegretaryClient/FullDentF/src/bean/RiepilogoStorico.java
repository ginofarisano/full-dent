package bean;

public class RiepilogoStorico {
	
	private String data;
	private String ora;
	private String Prestnome;
	private String PersNome;
	private String PersCognome;
	private String note;
	private String pagato;
	private String idPrenotazione;
	
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * Gets the ora.
	 *
	 * @return the ora
	 */
	public String getOra() {
		return ora;
	}
	
	/**
	 * Sets the ora.
	 *
	 * @param ora the new ora
	 */
	public void setOra(String ora) {
		this.ora = ora;
	}
	
	/**
	 * Gets the prestnome.
	 *
	 * @return the prestnome
	 */
	public String getPrestnome() {
		return Prestnome;
	}
	
	/**
	 * Sets the prestnome.
	 *
	 * @param prestnome the new prestnome
	 */
	public void setPrestnome(String prestnome) {
		Prestnome = prestnome;
	}
	
	/**
	 * Gets the pers nome.
	 *
	 * @return the pers nome
	 */
	public String getPersNome() {
		return PersNome;
	}
	
	/**
	 * Sets the pers nome.
	 *
	 * @param persNome the new pers nome
	 */
	public void setPersNome(String persNome) {
		PersNome = persNome;
	}
	
	/**
	 * Gets the pers cognome.
	 *
	 * @return the pers cognome
	 */
	public String getPersCognome() {
		return PersCognome;
	}
	
	/**
	 * Sets the pers cognome.
	 *
	 * @param persCognome the new pers cognome
	 */
	public void setPersCognome(String persCognome) {
		PersCognome = persCognome;
	}
	
	/**
	 * Gets the note.
	 *
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	
	/**
	 * Sets the note.
	 *
	 * @param note the new note
	 */
	public void setNote(String note) {
		this.note = note;
	}
	
	/**
	 * Gets the pagato.
	 *
	 * @return the pagato
	 */
	public String getPagato() {
		return pagato;
	}
	
	/**
	 * Sets the pagato.
	 *
	 * @param pagato the new pagato
	 */
	public void setPagato(String pagato) {
		this.pagato = pagato;
	}
	
	/**
	 * Gets the id prenotazione.
	 *
	 * @return the id prenotazione
	 */
	public String getIdPrenotazione() {
		return idPrenotazione;
	}
	
	/**
	 * Sets the id prenotazione.
	 *
	 * @param idPrenotazione the new id prenotazione
	 */
	public void setIdPrenotazione(String idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return"RiepilogoStorico["
		+ " data=" + data
		+ ", ora=" + ora 
		+ ", prestnome=" + Prestnome
		+ ", persNome=" + PersNome
		+ ", persCognome=" + PersCognome 
		+ ", note=" + note
		+ ", pagato=" + pagato
		+ ", idPrenotazione=" + idPrenotazione
		+"]";

		
	}
	
	
	
}
