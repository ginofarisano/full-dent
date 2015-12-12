package bean;

public class Prenotazione {
	
	private String idPrenotazione;
	private String codiceFiscale;
	private String idPrestazione;
	private String idPersonale;
	private String data;
	private String ora;
	
	
	
	public String getIdPrenotazione(){
		return idPrenotazione;
	}
	
	
	public String getCodiceFiscale(){
		return this.codiceFiscale;
	}
	
	public String getIdPrestazione(){
		return this.idPrestazione;
	}
	
	public String getIdPersonale(){
		return this.idPersonale;
	}
	
	public String getData(){
		return this.data;
	}
	
	public String getOra(){
		return this.ora;
	}
	
	public void setIdPrenotazione(String idPrenotazione){
		this.idPrenotazione=idPrenotazione;
	}
	
	public void setCodiceFiscale(String codiceFiscale){
		this.codiceFiscale=codiceFiscale;
	}
	
	public void setIdPersonale(String idPersonale){
		this.idPersonale=idPersonale;
	}
	
	public void setIdPrestazione(String idPrestazione){
		this.idPrestazione=idPrestazione;
	}
	
	public void setData(String data){
		this.data=data;
	}
	
	public void setOra(String ora){
		this.ora=ora;
	}
	
	
	
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
