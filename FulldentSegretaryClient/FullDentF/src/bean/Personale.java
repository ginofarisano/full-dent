package bean;


public class Personale {

	
	    private String codiceFiscale="";
		private String nome="";
		private String cognome="";

		

		/**
		 * Gets the codice fiscale.
		 *
		 * @return the codice fiscale
		 */
		public String getCodiceFiscale() {
			return this.codiceFiscale;
		}

		/**
		 * Sets the codice fiscale.
		 *
		 * @param codiceFiscale the new codice fiscale
		 */
		public void setCodiceFiscale(String codiceFiscale) {
			this.codiceFiscale = codiceFiscale;
		}

		/**
		 * Gets the nome.
		 *
		 * @return the nome
		 */
		public String getNome() {
			return this.nome;
		}
		
		/**
		 * Sets the nome.
		 *
		 * @param nome the new nome
		 */
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		/**
		 * Gets the cognome.
		 *
		 * @return the cognome
		 */
		public String getCognome() {
			return this.cognome;
		}
		
		/**
		 * Sets the cognome.
		 *
		 * @param cognome the new cognome
		 */
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
