package gestioneFornitori;

import java.sql.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

import exception.DuplicateException;
import exception.InvalidDataException;
import exception.NotFoundException;

// TODO: Auto-generated Javadoc
/**
 * La classe che gestisce le funzionalità di connessione con il DataBase del Fornitore. 
 * @author Maria D'Arco
 */

public class DBFornitore {

	/** The stmt. */
	private Statement stmt;	
	
	/** The conn. */
	private Connection conn;

	/**
	 * Costruttore,crea un'istanza della classe.
	 *
	 * @throws SQLException errore nell'accesso al DataBase.
	 * @throws ClassNotFoundException classe non trovata.
	 */	
	public DBFornitore() throws  SQLException,ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}

	/**
	 * Metodo che apre la connessione al DataBase.
	 * @throws SQLException errore all'accesso al DataBase.
	 * @throws FileNotFoundException file contenente i dati d'accesso al DataBase non trovato.
	 * @throws IOException errore di comunicazione con il file.
	 * @throws ClassNotFoundException classe non trovata.
	 */
	public void OpenConnection()throws SQLException,FileNotFoundException,IOException,ClassNotFoundException {
		String usr="root";
		String psw="root";
		File f=new File("uspsw.txt");
		if (f.exists()) {
			FileReader fileIn = new FileReader(f);
			Scanner scanFile = new Scanner(fileIn);
			usr=scanFile.next();
			psw=scanFile.next();
			fileIn.close();
		}
		String url="jdbc:mysql://localhost/pro?user="+usr+"&password="+psw;
		conn=DriverManager.getConnection(url);
		stmt=conn.createStatement();
	}

	/**
	 * Metodo che chiude la connessione con il DataBase;.
	 *
	 * @throws SQLException errore di comunicazione con il DataBase;
	 */
	public void closeConnection() throws SQLException {
		conn.close();
		stmt.close();
	}

	/**
	 * Metodo che restituisce un fornitore ricercato presente nel DataBase.
	 * @param PartitaIva la Partita Iva del fornitore da ricercare.
	 * @return il fornitore richiesto. 
	 * @throws SQLException errore di comunicazione con il DataBase.
	 * @throws InvalidDataException errore nell'inserimento dei dati.
	 */	
	public DatiFornitore getFornitore(String PartitaIva)throws SQLException,InvalidDataException{
			DatiFornitore d = null;
        	ResultSet rs=stmt.executeQuery("SELECT * FROM fornitori WHERE PIVA = '"+PartitaIva+"'");
        	boolean rsVuoto=true;  
        	while (rs.next())     
        		 rsVuoto=false;
        	 rs.first();
        	 if(!rsVuoto) 
        		 d=new DatiFornitore(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
        	 rs.close();
        	 
        	 return d;
	}
	
	/**
	 * Metodo che verifica se un fornitore è presente nel DataBase. 
	 *
	 * @param PartitaIva the partita iva
	 * @return true se il fornitore è presente, false altrimenti.
	 * @throws SQLException errore nell'accesso al DataBase.
	 * @throws InvalidDataException dati inseriti non validi.
	 */		
	public boolean isPresente (String PartitaIva)throws SQLException,InvalidDataException{
		DatiFornitore a=getFornitore(PartitaIva);
		if (a==null)
			return false;
		return true;
	}

	/**
	 * Inserisce un nuovo fornitore nel DataBase.
	 * @param fornitore il nuovo fornitore da inserire.
	 * @throws SQLException errore nell'accesso al DataBase.
	 * @throws InvalidDataException errore nell'inserimento dei dati.
	 * @throws DuplicateException fornitore già presente nel DataBase.
	 */
	public void InserisciFornitore(DatiFornitore fornitore)throws SQLException,InvalidDataException,DuplicateException{
		if (isPresente(fornitore.getPIva()))
			throw new DuplicateException("Fornitore già presente!");
		String query = "INSERT INTO fornitori VALUES" +
			"('"+fornitore.getPIva()+"','"+fornitore.getNomeResponsabile()+"','"
			+fornitore.getCognomeResponsabile()+"','"+fornitore.getSede()+"','"+
			fornitore.getRecapito()+"','"+fornitore.getEmail()+"')";
		stmt.execute(query);
	}

	/**
	 * Modifica i dati relativi ad un fornitore.
	 * @param fornitore il fornitore modificato.
	 * @throws SQLException errore con il DataBase.
	 * @throws NotFoundException fornitore non trovato.
	 * @throws InvalidDataException dati non validi.
	 */
	public void modificaFornitore(DatiFornitore fornitore) throws SQLException,NotFoundException,InvalidDataException{
		if(!isPresente(fornitore.getPIva()))
			throw new NotFoundException("Fornitore non presente");
		eliminaFornitore(fornitore.getPIva());
		InserisciFornitore(fornitore);
	}

	/**
	 * Elimina un fornitore dal DataBase.
	 * @param aPiva la partita iva del fornitore.
	 * @throws SQLException errore con il DataBase.
	 * @throws NotFoundException fornitore non trovato. 
	 * @throws InvalidDataException dati errati.
	 */
	public void eliminaFornitore(String aPiva)throws SQLException,NotFoundException, InvalidDataException {
		if(!isPresente(aPiva))
			throw new NotFoundException("Fornitore non presente");
		String query=("DELETE FROM fornitori WHERE PIVA = '"+aPiva+"'");
		stmt.execute(query);
	}
	
	/**
	 * Restituisce l'elenco di tutti i fornitori presenti nel DataBase.
	 * @return l'elenco dei fornitori.
	 * @throws SQLException errore con il DataBase.
	 */
	public ArrayList<DatiFornitore> getElenco() throws SQLException{
		ArrayList<DatiFornitore> elenco = new ArrayList<DatiFornitore>();
		String query = "SELECT * FROM fornitori";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			DatiFornitore x = new DatiFornitore(rs.getString(1),rs.getString(2),rs.getString(3),
					rs.getString(4),rs.getString(5),rs.getString(6));
			elenco.add(x);
		}
		rs.close();
		return elenco;
	}

}

