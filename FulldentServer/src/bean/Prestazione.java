package bean;

public class Prestazione {

	private String idPrest;
	private String nomePrest;
	private String durata;
	
	
	public String getIdPrest() {
		return this.idPrest;
	}
	
	public void setIdPrest(String id) {
		 this.idPrest=id;
	}
	
	public String getNomePrest() {
		return this.nomePrest;
	}
	
	public void setNomePrest(String nome){
		this.nomePrest=nome;
	}
	
	
	public String getDurata(){
		return this.durata;
	}
	
	public void setDurata(String dur){
		this.durata=dur;
	}
	
	@Override
	public String toString() {
		
		return"Prestazione["
		+ " idPrest=" + idPrest 
		+ ", durata=" + durata 
		+ ", nomePrest=" + nomePrest 
		+"]";	
	}
	
	
}
