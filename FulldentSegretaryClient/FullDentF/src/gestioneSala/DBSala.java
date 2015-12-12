package gestioneSala;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import exception.DuplicateException;
import exception.InvalidDataException;
import exception.NotFoundException;
import gestioneAccessi.DBAccount;
import gestioneAttrezzature.DatiAttrezzature;


import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * La classe che gestisce le funzionalità di connessione con il DataBase della sala .
 *
 * @author Maria D'Arco
 */
public class DBSala {
	
	/** The conn. */
	private Connection conn;
	
	/** The stmt. */
	private Statement stmt;
	
	/**
	 * Costruttore (crea un'istanza della classe).
	 * @throws SQLException errore nell'accesso al DataBase.
	 * @throws ClassNotFoundException classe non trovata.
	 */
	public DBSala() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");	
	}
	
	/**
	 * Apre la connessione con il DataBase.
	 * @throws SQLException errore d'accesso al DataBase.
	 * @throws FileNotFoundException file contenente i dati d'accesso al DataBase non trovato.
	 * @throws IOException errore di comunicazione con il file.
	 * @throws ClassNotFoundException classe non trovata.
	 */
	public void openConnection()throws SQLException, FileNotFoundException, IOException, ClassNotFoundException{
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
	 * Chiude la connessione con il DataBase.
	 * @throws SQLException errore nell'accesso al DataBase.
	 */
	public void closeConnection() throws SQLException{
		stmt.close();
		conn.close();
	}
	
	/**
	 * Ritorna la sala contenuta nel DatatBase che ha come codice identificativo. 
	 * quello passato in input.
	 *
	 * @param cod the cod
	 * @return la sala richiesta.
	 * @throws SQLException errore nell'accesso al DataBase.
	 * @throws InvalidDataException errore nell'inserimento dei dati.
	 */
	public DatiSala getSala(int cod) throws SQLException, InvalidDataException{
		DatiSala s=null;
		ResultSet rs = stmt.executeQuery("SELECT * FROM sala WHERE codiceSala = "
						+cod);
		boolean rsVuoto=true;
		while(rs.next())
			rsVuoto=false;
		rs.first();
		if(!rsVuoto)
			s=new DatiSala(rs.getString(3),rs.getString(2),rs.getString(4),rs.getInt(1));
		rs.close();
		return s;  
	}
	
	/**
	 * Restituisce il codice fiscale dell'amministratore attuale.
	 * @return il codice fiscale.
	 * @throws SQLException errore d'accesso al DataBase.
	 */
	public String prelevaCodiceF() throws SQLException{
		try{
			DBAccount x = new DBAccount();
			x.OpenConnection();
			String k = x.getCF();
			x.closeConnection();
			return k;
		}catch(SQLException e){
			System.out.println("Errore di connessione con il DataBase!");
		} catch (ClassNotFoundException e) {
			System.out.println("Classe non trovata!");
		} catch (FileNotFoundException e) {
			System.out.println("File non trovato!");
		} catch (IOException e) {
			System.out.println("Errore di comunicazione con il file!");
		}
		return "";
	}
	
	/**
	 * Verifica se la sala è presente nel DataBase .
	 *
	 * @param cod the cod
	 * @return true se la stanza è presente, false altrimenti
	 * @throws SQLException errore nell'accesso al DataBase
	 * @throws InvalidDataException errore nell'inserimento dei dati
	 */
	public boolean isPresente(int cod) throws SQLException, InvalidDataException{
		DatiSala a=getSala(cod);
		if (a==null)
			return false;
		return true;
	}
	
	/**
	 * Inserisce una nuova sala nel DataBase.
	 *
	 * @param sala the sala
	 * @throws SQLException errore nell'accesso al DataBase
	 * @throws DuplicateException sala già presente nel DataBase
	 * @throws InvalidDataException errore nell'inserimento dei dati
	 */
	public void inserisciSala(DatiSala sala)throws SQLException, 
										DuplicateException, InvalidDataException{
		if (isPresente(sala.getCodiceSala())) 
			throw new DuplicateException("Sala già presente!");
		String query=("INSERT INTO sala(codiceSala,descrizione,nomeSala," +
				"codiceFiscale) VALUES" +
				"("+sala.getCodiceSala()+",'"+
				sala.getDescrizione()+"','"+sala.getNomeSala()+"','"
				+sala.getCodiceFiscale()+"')");
		stmt.execute(query);
	}
	
	/**
	 * Restituisce l'elenco delle attrezzature legate alla stanza il cui codice 
	 * è dato in input.
	 *
	 * @param codS the cod s
	 * @return la lista delle attrezzature ricercate.
	 * @throws SQLException errore nell'accesso al DataBase
	 */
	public ArrayList<DatiAttrezzature> visualizzaElencoAttrezzature(int codS) throws SQLException{
		String c= (""+codS);
		ArrayList<DatiAttrezzature> elenco = new ArrayList<DatiAttrezzature>();
		String query=("SELECT * FROM servizi WHERE locazione='"+codS+"'");
		ResultSet x = stmt.executeQuery(query);
		boolean vuoto = true;
		while(x.next()){
			vuoto = false;
		}
		if(!vuoto){
			while(x.next()){
			
				DatiAttrezzature z = new DatiAttrezzature(x.getInt(1),x.getString(2)
					,x.getInt(3),x.getDouble(4),x.getString(5),
					x.getString(6),c,x.getString(8));
				elenco.add(z);
			}
		}
		x.close();
		return elenco;
	}
	
	/**
	 * Modifica le informazioni relative ad una sala.
	 *
	 * @param sala la sala modificata.
	 * @throws SQLException errore nell'accesso al DataBase
	 * @throws NotFoundException sala non presente nel DataBase.
	 * @throws InvalidDataException errore nell'inserimento dei dati
	 */
	public void modificaSala(DatiSala sala) throws SQLException,NotFoundException, 
														InvalidDataException {
		int cod = sala.getCodiceSala();
		if(!isPresente(cod))
			throw new NotFoundException("Sala non presente!");
		String query = "DELETE FROM sala WHERE codiceSala = "+cod;
		stmt.execute(query);
		inserisciSala(sala);
	}
	
	/**
	 * Restituisce l'elenco delle sale presenti nel DataBase.
	 * @return l'elenco delle sale.
	 * @throws SQLException errore d'accesso al DataBase.
	 */
	public ArrayList<DatiSala> getElenco() throws SQLException{
		ArrayList<DatiSala> elenco = new ArrayList<DatiSala>();
		String query = "SELECT * FROM sala";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			DatiSala x = new DatiSala(rs.getString(3),rs.getString(2),rs.getString(4),rs.getInt(1));
			elenco.add(x);
		}
		rs.close();
		return elenco;
	}
	
}