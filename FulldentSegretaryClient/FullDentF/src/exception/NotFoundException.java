package exception;

// TODO: Auto-generated Javadoc
/**
 * Classe che gestisce l'eccezione di un elemento non presente.
 * @author 
 *
 */
public class NotFoundException extends RuntimeException{

	/**
	 * Crea una nuova eccezione.
	 * @param e il messaggio di notifica.
	 */
	public NotFoundException(String e){
		super(e);
	}
	
}
