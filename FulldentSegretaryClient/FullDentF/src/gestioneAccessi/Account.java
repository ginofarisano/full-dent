package gestioneAccessi;

// TODO: Auto-generated Javadoc
/**
 * Gestisce le operazioni relative ad un account.
 * @author 
 *
 */
public class Account {
	
	/** The tipo. */
	private String tipo;
	
	/** The user id. */
	private String userId;
	
	/** The psw. */
	private String psw;
	
	/**
	 * Crea un nuovo account.
	 * @param aType il tipo di account.
	 * @param anUserID il nome utente dell'account.
	 * @param aPassword la password dell'account.
	 */
	public Account(String aType,String anUserID,String aPassword){
		tipo = aType;
		userId = anUserID;
		psw = aPassword;
	}

	/**
	 * Restiutisce il tipo dell'account.
	 * @return il tipo dell'account.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Restiutisce il nome utente dell'account.
	 * @return il nome utente dell'account.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Restiutisce la password dell'account.
	 * @return la password dell'account.
	 */
	public String getPsw() {
		return psw;
	}

}
