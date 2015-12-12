package bean;

public class Personale {

	

		private String codiceFiscale="";
		private String nome="";
		private String cognome="";

		

		public String getCodiceFiscale() {
			return this.codiceFiscale;
		}

		public void setCodiceFiscale(String codiceFiscale) {
			this.codiceFiscale = codiceFiscale;
		}

		public String getNome() {
			return this.nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getCognome() {
			return this.cognome;
		}
		
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}
		
		

		@Override
		public String toString() {
			
			return"Utente["
			+ " codiceFiscale=" + codiceFiscale 
			+ ", nome=" + nome 
			+ ", cognome=" + cognome 
			+"]";	
		}
		
		
}
