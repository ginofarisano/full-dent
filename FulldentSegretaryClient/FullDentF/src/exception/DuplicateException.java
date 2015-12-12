package exception;

// TODO: Auto-generated Javadoc
/**
 * Classe che gestisce l'eccezione di un elemento presente più volte.
 * @author 
 *
 */
public class DuplicateException extends RuntimeException {

	/**
	 * Crea una nuova eccezione.
	 * @param e il messaggio di notifica.
	 */
	public DuplicateException(String e){
		super(e);
	}
	
}
