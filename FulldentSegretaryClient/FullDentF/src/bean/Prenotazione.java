package bean;


public class Prenotazione {
	
	private String idPrenotazione;
	private String codiceFiscale;
	private String idPrestazione;
	private String idPersonale;
	private String data;
	private String ora;
	
	
	public Prenotazione(){
		
	}
	
	public Prenotazione(String codFisc,String idPrest,String idPers,String data,String ora){
		this.codiceFiscale=codFisc;
		this.idPrestazione=idPrest;
		this.idPersonale=idPers;
		this.data=data;
		this.ora=ora;
	}
	
	
	/**
	 * Gets the id prenotazione.
	 *
	 * @return the id prenotazione
	 */
	public String getIdPrenotazione(){
		return idPrenotazione;
	}
	
	
	/**
	 * Gets the codice fiscale.
	 *
	 * @return the codice fiscale
	 */
	public String getCodiceFiscale(){
		return this.codiceFiscale;
	}
	
	/**
	 * Gets the id prestazione.
	 *
	 * @return the id prestazione
	 */
	public String getIdPrestazione(){
		return this.idPrestazione;
	}
	
	/**
	 * Gets the id personale.
	 *
	 * @return the id personale
	 */
	public String getIdPersonale(){
		return this.idPersonale;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String getData(){
		return this.data;
	}
	
	/**
	 * Gets the ora.
	 *
	 * @return the ora
	 */
	public String getOra(){
		return this.ora;
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
	 * Sets the codice fiscale.
	 *
	 * @param codiceFiscale the new codice fiscale
	 */
	public void setCodiceFiscale(String codiceFiscale){
		this.codiceFiscale=codiceFiscale;
	}
	
	/**
	 * Sets the id personale.
	 *
	 * @param idPersonale the new id personale
	 */
	public void setIdPersonale(String idPersonale){
		this.idPersonale=idPersonale;
	}
	
	/**
	 * Sets the id prestazione.
	 *
	 * @param idPrestazione the new id prestazione
	 */
	public void setIdPrestazione(String idPrestazione){
		this.idPrestazione=idPrestazione;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(String data){
		this.data=data;
	}
	
	/**
	 * Sets the ora.
	 *
	 * @param ora the new ora
	 */
	public void setOra(String ora){
		this.ora=ora;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return"Prenotazione["
		+ " idPrenotazione=" + idPrenotazione		
		+ " codiceFiscale=" + codiceFiscale
		+ ", idPrestazione=" + idPrestazione
		+ ", idPersonale=" + idPersonale
		+ ", data=" + data
		+ ", ora=" + ora 
		+"]";

		
	}
	
}
