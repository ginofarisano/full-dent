package bean;


public class Visita {
	
	private String data="";
	private String pagato="";
	private String note="";
	private String nomePrestazione="";
	private String ora="";
	private String nomePersonale="";
	private String cognomePersonale="";
	
	public String getData(){
		return data;
	}
	
	public void setData(String data){
		this.data=data;
	}
	
	public String getPagato(){
		return pagato;
	}
	
	public void setPagato(String pagato){
		this.pagato=pagato;
	}
	
	public String getNote(){
		return note;
	}
	
	public void setNote(String note){
		this.note=note;
	}
	
	public void setNomePrestazione(String nomePrestazione) {
		this.nomePrestazione=nomePrestazione;
		
	}
	
	public String getNomePrestazione(){
		return nomePrestazione;
	}
	
	
	

	public void setOra(String ora) {
		// TODO Auto-generated method stub
		this.ora=ora;
	}
	
	public String getOra(){
		return ora;
	}
	
	
	public void setNomePersonale(String nomePersonale) {
		// TODO Auto-generated method stub
		this.nomePersonale=nomePersonale;
	}
	
	public String getNomePersonale(){
		return nomePersonale;
	}

	public void setCognomePersonale(String cognomePersonale) {
		// TODO Auto-generated method stub
		this.cognomePersonale=cognomePersonale;
	}
	
	public String getCognomePersonale(){
		return cognomePersonale;
	}

	
	@Override
	public String toString() {
		
		return"["
		+ " data=" + data 
		+ ", pagato=" + pagato 
		+ ", note=" + note
		+ ", nomePrestazione=" + nomePrestazione 
		+ ", ora=" + ora
		+ ", nomePersonale=" + nomePersonale
		+ ", cognomePersonale=" + cognomePersonale
		+"]";
		
	}

	
	
}
