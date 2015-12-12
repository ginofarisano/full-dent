package bean;

public class StoricoPaziente {

	private String idPrenotazione;
	private	String pagato;
	private String note;
	
	
	public String getIdPrenotazione(){
		return this.idPrenotazione;
	}
	
	public String getPagato(){
		return this.pagato;
	}
	
	public String getNote(){
		return this.note;
	}
	
	public void setIdPrenotazione(String idPrenotazione){
		this.idPrenotazione=idPrenotazione;
	}
	
	public void setPagato(String pagato){
		this.pagato=pagato;
	}
	
	public void setNote(String note){
		this.note=note;
	}
	
	@Override
	public String toString() {
		
		return"StoricoPaziente["
		+ " idPrenotazione=" + idPrenotazione
		+ ", pagato=" + pagato 
		+ ", note=" + note
		+"]";

		
	}

	
	
	
}
