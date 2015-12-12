package bean;


public class StoricoPaziente {

	private String idPrenotazione;
	private	String pagato;
	private String note;
	
	
	/**
	 * Gets the id prenotazione.
	 *
	 * @return the id prenotazione
	 */
	public String getIdPrenotazione(){
		return this.idPrenotazione;
	}
	
	/**
	 * Gets the pagato.
	 *
	 * @return the pagato
	 */
	public String getPagato(){
		return this.pagato;
	}
	
	/**
	 * Gets the note.
	 *
	 * @return the note
	 */
	public String getNote(){
		return this.note;
	}
	
	/**
	 * Sets the id prenotazione.
	 *
	 * @param idPrenotazione the new id prenotazione
	 */
	public void setIdPrenotazione(String idPrenotazione){
		this.idPrenotazione=idPrenotazione;
	}
	
	/**
	 * Sets the pagato.
	 *
	 * @param pagato the new pagato
	 */
	public void setPagato(String pagato){
		this.pagato=pagato;
	}
	
	/**
	 * Sets the note.
	 *
	 * @param note the new note
	 */
	public void setNote(String note){
		this.note=note;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return"StoricoPaziente["
		+ " idPrenotazione=" + idPrenotazione
		+ ", pagato=" + pagato 
		+ ", note=" + note
		+"]";

		
	}

	
	
	
}
