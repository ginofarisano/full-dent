package gestionePersonale;

// TODO: Auto-generated Javadoc
/**
 * Classe che gestisce le funzionalità di un contratto.
 * @author Maria D'arco.
 *
 */
public class Contratto {

	/** The salario. */
	private double salario;
	
	/** The tipo. */
	private String tipo;
	
	/** The data. */
	private String data;
	
	/**
	 * Crea un nuovo contratto.
	 * @param s il salario stipulato.
	 * @param t il tipo di contratto.
	 * @param d la data di creazione del contratto.
	 */
	public Contratto(double s,String t,String d){
		salario = s;
		tipo = t;
		data = d;
	}

	/**
	 * Restituisce il salario stipulato nel contratto.
	 * @return il salario.
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Modifica il salario stipulato per il contratto.
	 * @param salario il nuovo valore.
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * Restituisce il tipo di contratto stipulato.
	 * @return il tipo di contatto.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Modifica il tipo del contratto.
	 * @param tipo il nuovo tipo.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Restituisce la data di stipulazione del contratto.
	 * @return la data del contratto.
	 */
	public String getData() {
		return data;
	}

	/**
	 * Modifica la data di stipulazione del contratto.
	 * @param data la nuova data.
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Restituisce una descrizione in formato di stringa dell'oggetto.
	 * @return la descrizione.
	 */
	public String toString(){
		return ""+tipo+" "+salario+" "+data;
	}

	
}

