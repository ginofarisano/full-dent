package bean;


public class Appuntamento {
	
		
		private String nomePers;
		private String cognPers;
		private String nomeUte;
		private String cognUte;
		private String nomePres;
		private String pagato;
		private String durata;
		

		
		
		
		
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
		 * @param s the new durata
		 */
		public void setDurata(String s){
			this.durata=s;
		}
		
		
		/**
		 * Gets the nome pers.
		 *
		 * @return the nome pers
		 */
		public String getNomePers() {
			return this.nomePers;
		}
		
		/**
		 * Sets the nome pers.
		 *
		 * @param nome the new nome pers
		 */
		public void setNomePers(String nome) {
			this.nomePers = nome;
		}
		
		/**
		 * Gets the cognome pers.
		 *
		 * @return the cognome pers
		 */
		public String getCognomePers(){
			return this.cognPers;
		}
		
		/**
		 * Sets the cognome pers.
		 *
		 * @param cognome the new cognome pers
		 */
		public void setCognomePers(String cognome){
			this.cognPers=cognome;
		}
		
		
		
		
		
		/**
		 * Gets the nome utente.
		 *
		 * @return the nome utente
		 */
		public String getNomeUtente() {
			return this.nomeUte;
		}
		
		/**
		 * Sets the nome utente.
		 *
		 * @param nome the new nome utente
		 */
		public void setNomeUtente(String nome) {
			this.nomeUte = nome;
		}
		
		/**
		 * Gets the cognome utente.
		 *
		 * @return the cognome utente
		 */
		public String getCognomeUtente(){
			return this.cognUte;
		}
		
		/**
		 * Sets the cognome utente.
		 *
		 * @param cognome the new cognome utente
		 */
		public void setCognomeUtente(String cognome){
			this.cognUte=cognome;
		}
		
		
		
		
		/**
		 * Gets the nome prestazione.
		 *
		 * @return the nome prestazione
		 */
		public String getNomePrestazione() {
			return this.nomePres;
		}
		
		/**
		 * Sets the nome prestazione.
		 *
		 * @param nome the new nome prestazione
		 */
		public void setNomePrestazione(String nome) {
			this.nomePres = nome;
		}
		
		
		/**
		 * Gets the pagato.
		 *
		 * @return the pagato
		 */
		public String getPagato() {
			return this.pagato;
		}
		
		/**
		 * Sets the pagato.
		 *
		 * @param nome the new pagato
		 */
		public void setPagato(String nome) {
			this.pagato=nome;
		}
		
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
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
