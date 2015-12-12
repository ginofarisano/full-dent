package gestioneAccessi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import exception.DuplicateException;
import exception.InvalidDataException;
import exception.NotFoundException;

// TODO: Auto-generated Javadoc
/**
 * Classe che gestisce le funzionalità di connessione con il DataBase degli Account.
 * @author 
 *
 */
public class DBAccount {
	
	/** The stmt. */
	private Statement stmt;
	
	/** The conn. */
	private Connection conn;
	
	/**
	 * Crea un nuovo oggetto DBAccount.
	 * @throws SQLException errore con il DataBase.	
	 * @throws ClassNotFoundException mancata individuazione della classe.
	 */
	public DBAccount() throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	/**
	 * Apre la connessione con il DataBase.
	 *
	 * @throws SQLException errore con il DataBase.
	 * @throws FileNotFoundException il file non viene trovato.
	 * @throws IOException errore di input.
	 * @throws ClassNotFoundException la classe non viene trovata.
	 */
	public void OpenConnection()throws SQLException,FileNotFoundException,IOException,ClassNotFoundException {
		String usr="root";
		String psw="psd";
		
		File x=new File("uspsw.txt");
		
		if (x.exists()) {
			FileReader fileAttrez=new FileReader(x);
			Scanner scanFile=new Scanner(fileAttrez);
			usr=scanFile.next();
			psw=scanFile.next();
			fileAttrez.close();
		}

		String url="jdbc:mysql://localhost/pro?user="+usr+"&password="+psw;
		conn=DriverManager.getConnection(url);
		stmt=conn.createStatement();
	}

	/**
	 * Metodo che chiude la connessione con il DataBase;.
	 *
	 * @throws SQLException errore all'accesso al DataBase;
	 */
	public void closeConnection() throws SQLException {
		conn.close();
		stmt.close();
	}

	/**
	 * Inserisce un nuovo Account nel DataBase.
	 * @param acc il nuovo account da inserire.
	 * @throws SQLException errore nell'accesso al DataBase.
	 * @throws InvalidDataException errore nell'inserimento dei dati.
	 * @throws DuplicateException account già presente nel DataBase.
	 */
	public void inserisciAccount(Account acc)throws SQLException,InvalidDataException,DuplicateException{
		if (isPresente(acc))
			throw new DuplicateException("Account già presente");
		String query= ("INSERT INTO account VALUES" +
			"('"+acc.getTipo()+"','"+acc.getUserId()+"','"
			+acc.getPsw()+"')");
		stmt.execute(query);
	}
	
	/**
	 * Metodo che verifica se un account è presente nel DataBase.
	 *
	 * @param acc the acc
	 * @return true se l'account è presente, false altrimenti.
	 * @throws SQLException errore nell'accesso al DataBase.
	 */		
	public boolean isPresente (Account acc)throws SQLException{
		Account a= getAccount(acc.getUserId(),acc.getPsw());
		if (a == null)
			return false;
		return true;
	}
	
	/**
	 * Metodo che ritorna l'account presente nel DataBase che ha come userId e password quelli dati in input.
	 *
	 * @param us the us
	 * @param psw the psw
	 * @return l'account richiesto, null altrimenti.
	 * @throws SQLException errore all'accesso al DataBase.
	 */	
	public Account getAccount(String us,String psw)throws SQLException{
		Account a = null;
        ResultSet rs = stmt.executeQuery("SELECT * FROM account WHERE userId = '"+us+"' AND password = '"+psw+"'");
    	boolean rsVuoto=true;   
        while(rs.next()){
        	rsVuoto=false;
        }
        rs.first();
        if(!rsVuoto) 
        	a = new Account(rs.getString(3),rs.getString(1),rs.getString(2));
        rs.close();
        return a;
	}
	
	/**
	 * Restituisce il codice fiscale dell'amministatore del centro.
	 * @return il codice fiscale dell'amministratore.
	 * @throws SQLException errore con il DataBase.
	 */
	public String getCF() throws SQLException{
		String query = "SELECT * FROM account WHERE Tipo = 'amministratore'";
		ResultSet x = stmt.executeQuery(query);
		x.first();
		return x.getString(4);
	}
	
	/**
	 * Elimina un account dal DataBase.
	 * @param acc l'account da eliminare.
	 * @throws SQLException errore con il DataBase.
	 * @throws NotFoundException account non trovato. 
	 * @throws InvalidDataException dati errati.
	 */
	public void eliminaAccount(Account acc)throws SQLException,NotFoundException, InvalidDataException {
		if(!isPresente(acc))
			throw new NotFoundException("Account non presente");
		String query=("DELETE FROM account WHERE userId = '"+acc.getUserId()+"' AND password = '"+acc.getPsw()+"'");
		stmt.execute(query);
	}
		
	/**
	 * Restituisce l'elenco di tutti gli account presenti nel DataBase.
	 * @return l'elenco degli account.
	 * @throws SQLException errore con il DataBase.
	 */
	public ArrayList<Account> getElenco() throws SQLException{
		ArrayList<Account> elenco = new ArrayList<Account>();
		String query = "SELECT * FROM account";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			Account x = new Account(rs.getString(1),rs.getString(2),rs.getString(3));
			elenco.add(x);
		}
		rs.close();
		return elenco;
	}

	
}
