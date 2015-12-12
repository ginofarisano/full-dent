package exception;

// TODO: Auto-generated Javadoc
/**
 * Classe che gestisce l'eccezione di un elemento già esistente.
 * @author 
 *
 */
public class AlreadyExistException extends RuntimeException {
	
	/**
	 * Crea una nuova eccezione.
	 * @param e il messaggio di notifica.
	 */
	public AlreadyExistException(String e){
		super(e);
	}
	
}
