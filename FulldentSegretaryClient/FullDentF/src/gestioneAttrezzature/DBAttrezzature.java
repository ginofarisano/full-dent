package gestioneAttrezzature;

import exception.InvalidDataException;

import exception.NotFoundException;
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

// TODO: Auto-generated Javadoc
/**
 * La classe che gestisce le funzionalita di connessione con il database dell'attrezzatura.
 * @author Vincenzo D'alessio.
 */
public class DBAttrezzature {
	
	/** The conn. */
	private Connection conn;
	
	/** The stmt. */
	private Statement stmt;
	
	/**
	 * Costruttore (crea un'istanza della classe).
	 * @throws SQLException errore nell'accesso al database.
	 * @throws ClassNotFoundException classe non trovata.
	 */
	public DBAttrezzature()throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	/**
	 * Apre la connessione con il DataBase.
	 * @throws SQLException errore di comunicazione con il DataBase.
	 * @throws FileNotFoundException file contenente i dati d'accesso al dataBase non trovato.
	 * @throws IOException errore di comunicazione con il file.
	 * @throws ClassNotFoundException classe non trovata.
	 */
	public void openConnection()throws SQLException, FileNotFoundException, IOException, ClassNotFoundException{
		
		String usr="root";
		String psw="root";
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
	 * Chiude la connessione con il database.
	 * @throws SQLException errore nell'accesso al database.
	 */
	public void closeConnection() throws SQLException{
		stmt.close();
		conn.close();
	}
	
	/**
	 * Restituisce l'attrezzatura richiesta.
	 * @param ct il codice identificativo dell'attrezzatura.
	 * @return l'attrezzatura richiesta, null altrimenti.
	 * @throws SQLException errore con il DataBase.
	 * @throws InvalidDataException dati inseriti non validi.
	 */
	public DatiAttrezzature getAttrezzatura(int ct)throws SQLException, InvalidDataException {
		DatiAttrezzature x = null;
		ResultSet xt=stmt.executeQuery("SELECT * FROM servizi WHERE codiceTipo = "+ct);
		boolean xtVuoto=true;	
		while(xt.next())
			xtVuoto=false;
		xt.first();
		if(!xtVuoto)
			x=new DatiAttrezzature(xt.getInt(1),xt.getString(2),xt.getInt(3),xt.getDouble(4),xt.getString(5),xt.getString(6),xt.getString(7),xt.getString(8));
		xt.close();
		return x;
	}
	
	/**
	 * Ritorna la lista contenente tutte le attrezzature del database.
	 * @return la lista delle attrezzature.
	 * @throws SQLException errore con il DataBase.
	 * @throws InvalidDataException dati non validi.
	 */
	public ArrayList<DatiAttrezzature> VisualizzaAttrezzature() throws SQLException, InvalidDataException {
		ResultSet xt=stmt.executeQuery("SELECT * FROM servizi");
		ArrayList<DatiAttrezzature> list=new ArrayList<DatiAttrezzature>();
		while(xt.next()){
			DatiAttrezzature x=new DatiAttrezzature(xt.getInt(1),xt.getString(2),xt.getInt(3),xt.getDouble(4),xt.getString(5),xt.getString(6),xt.getString(7),xt.getString(8));
			list.add(x);
		}
		xt.close();
		return list;
	}
	
	/**
	 * Metodo che controlla se l'attrezzatura con il codice tipo inserito esiste.
	 * @param codiceTipo il codice identificativo dell'attrezzatura.
	 * @return true se l'attrezzatura esiste, false altrimenti.
	 * @throws SQLException errore con il DataBase.
	 */
	public boolean isPresente(int codiceTipo) throws SQLException {
		DatiAttrezzature x =getAttrezzatura(codiceTipo);
		if (x == null)
			return false;
		return true;
	}
	
	/**
	 * Inserisce un attrezzatura nel database controllando che il codice tipo della nuova attrezzatura 
	 * non esista già nel DataBase. 
	 * @param attrezzature la nuova attrezzatura da inserire.
	 * @throws SQLException errore con il DataBase.
	 * @throws InvalidDataException dati inseriti non validi.
	 */
	public void inserisciAttrezzature(DatiAttrezzature attrezzature) throws SQLException,InvalidDataException {
		if (isPresente(attrezzature.getCodiceTipo()))
			throw new InvalidDataException("Attrezzatura già presente!");
		String query=("INSERT INTO servizi " +
				"VALUES("+attrezzature.getCodiceTipo()+",'"+attrezzature.getNome()+"',"+attrezzature.getQuantità()+","+
				attrezzature.getCosto()+",'"+attrezzature.getTipo()+"','"+attrezzature.getDescrizione()+"','"+attrezzature.getLocazione()+"','"+
				attrezzature.getCodiceFornitore()+"')");
		
		stmt.execute(query);
	}
	
	/**
	 * Modifica la quantità di un attrezzatura controllando che il codice tipo inserito corrisponda 
	 * a quello dell'attrezzatura  da sovrascrivere.
	 * @param cod il codice identificativo dell'attrezzatura da aggiornare.
	 * @param val la quantità da aggiungere o sottrarre.
	 * @throws SQLException errore con il DataBase. 
	 * @throws NotFoundException l'attrezzatura non è stata trovata.
	 * @throws InvalidDataException dati non validi.
	 */
	public void aggiornaAttrezzature(int cod, int val) throws SQLException,NotFoundException,InvalidDataException {
		if (!isPresente(cod))
			throw new NotFoundException("Attrezzature non trovata!");
		int quantità = getAttrezzatura(cod).getQuantità();
		if(quantità+val>0)
			stmt.executeUpdate("UPDATE servizi SET quantità = "+(quantità + val)+" WHERE codiceTipo = "+cod);
		else 
			throw new InvalidDataException("Il valore passato richiede una quantità maggiore di quella disponibile");
	}
	
	/**
	 * Elimina un attrezzatura dal DataBase controllando che il codice tipo dell'attrezzatura sia presente
	 * nel dataBase.
	 * @param attrezzature l'attrezzatura da eliminare.
	 * @throws SQLException errore con il DataBase.
	 * @throws NotFoundException attrezzature non presente.
	 */
	public void eliminaAttrezzature(DatiAttrezzature attrezzature) throws SQLException, NotFoundException {
		if(!isPresente(attrezzature.getCodiceTipo()))
			throw new NotFoundException("Attrezzatura non trovata!");
		String query=("DELETE FROM servizi WHERE codiceTipo = "+attrezzature.getCodiceTipo());
		stmt.execute(query);
	}	
	
	/**
	 * Modifica la locazione e la descrizione di un attrezzatura.
	 * @param cod il codice dell'attrezzatura.
	 * @param locazione la nuova locazione.
	 * @param descrizione la nuova descrizione
	 * @throws SQLException errore con il DataBase.
	 */
	public void modificaAttrezzatura(int cod,String locazione,String descrizione) throws SQLException{
		DatiAttrezzature x = getAttrezzatura(cod);
		x.setDescrizione(descrizione);
		x.setLocazione(locazione);
		eliminaAttrezzature(x);
		inserisciAttrezzature(x);
	}
}