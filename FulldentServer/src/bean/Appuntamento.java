package bean;

public class Appuntamento {
	
		
		
		private String nomePers;
		private String cognPers;
		private String nomeUte;
		private String cognUte;
		private String nomePres;
		private String pagato;
		private String durata;
		
		
		public String getDurata(){
			return this.durata;
		}
		
		public void setDurata(String s){
			this.durata=s;
		}
		
		
		public String getNomePers() {
			return this.nomePers;
		}
		
		public void setNomePers(String nome) {
			this.nomePers = nome;
		}
		
		public String getCognomePers(){
			return this.cognPers;
		}
		
		public void setCognomePers(String cognome){
			this.cognPers=cognome;
		}
		
		
		
		
		
		public String getNomeUtente() {
			return this.nomeUte;
		}
		
		public void setNomeUtente(String nome) {
			this.nomeUte = nome;
		}
		
		public String getCognomeUtente(){
			return this.cognUte;
		}
		
		public void setCognomeUtente(String cognome){
			this.cognUte=cognome;
		}
		
		
		
		
		public String getNomePrestazione() {
			return this.nomePres;
		}
		
		public void setNomePrestazione(String nome) {
			this.nomePres = nome;
		}
		
		
		public String getPagato() {
			return this.pagato;
		}
		
		public void setPagato(String nome) {
			this.pagato=nome;
		}
		
		
		@Override
		public String toString() {
			
			return"Appuntamento["
			+ " nomePers=" + nomePers
			+ ", cognomePers=" + cognPers 
			+ ", nomeUtente=" + nomeUte
			+ ", cognomeUtente=" + cognUte 
			+ ", nomePrestazione=" + nomePres 
			+ ", pagato=" + pagato 
			+ ",durata="+ durata
			+"]";

			
		}


}
