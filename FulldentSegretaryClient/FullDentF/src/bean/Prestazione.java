package bean;


public class Prestazione {

	private String idPrest;
	private String nomePrest;
	private String durata;
	
	
	/**
	 * Gets the id prest.
	 *
	 * @return the id prest
	 */
	public String getIdPrest() {
		return this.idPrest;
	}
	
	/**
	 * Sets the id prest.
	 *
	 * @param id the new id prest
	 */
	public void setIdPrest(String id) {
		 this.idPrest=id;
	}
	
	/**
	 * Gets the nome prest.
	 *
	 * @return the nome prest
	 */
	public String getNomePrest() {
		return this.nomePrest;
	}
	
	/**
	 * Sets the nome prest.
	 *
	 * @param nome the new nome prest
	 */
	public void setNomePrest(String nome){
		this.nomePrest=nome;
	}
	
	
	/**
	 * Gets the durata.
	 *
	 * @return the durata
	 */
	public String getDurata(){
		return this.durata;
	}
	
	/**
	 * Sets the durata.
	 *
	 * @param dur the new durata
	 */
	public void setDurata(String dur){
		this.durata=dur;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return"Prestazione["
		+ " idPrest=" + idPrest 
		+ ", durata=" + durata 
		+ ", nomePrest=" + nomePrest 
		+"]";	
	}
	
	
	
}
