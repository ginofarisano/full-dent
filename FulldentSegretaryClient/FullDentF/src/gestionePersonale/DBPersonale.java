package gestionePersonale;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import exception.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// TODO: Auto-generated Javadoc
/**
 * Classe che gestisce le funzionalità di connessione con il DataBase dei Dipendenti.
 * @author Maria D'Arco.
 *
 */
public class DBPersonale {

	/** The conn. */
	private Connection conn;
	
	/** The stmt. */
	private Statement stmt;

	
	/**
	 * Crea un nuovo oggetto DBPersonale.
	 * @throws SQLException errore con il DataBase.	
	 * @throws ClassNotFoundException mancata individuazione della classe.
	 */
	public DBPersonale() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");	
	}
	
	/**
	 * Apre la connessione con il DataBase.
	 *
	 * @throws SQLException errore con il DataBase.
	 * @throws FileNotFoundException il file non viene trovato.
	 * @throws IOException errore di input.
	 * @throws ClassNotFoundException classe non trovata.
	 */
	public void openConnection() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException{
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
	 * @throws SQLException errore con il DataBase.
	 */
	public void closeConnection() throws SQLException {
		stmt.close();
		conn.close();
	}
	
	/**
	 * Inserisce un nuovo dipendente nel DataBase.
	 * @param dipendente il nuovo dipendente da aggiungere.
	 * @throws SQLException errore con il DataBase.
	 * @throws DuplicateException dipendente già presente.
	 */
	public void aggiungiDipendente(DatiPersonale dipendente) throws SQLException, DuplicateException{
		DatiPersonale nuovo = ricercaDipendente(dipendente.getCodfisc());
		if(nuovo != null )
			throw new DuplicateException("Dipendente già presente!");
		String query = "INSERT INTO personale (codiceFiscale,nome,cognome,residenza,dataNascita,luogoNascita," +
				"telefono,tipo,sesso,contratto) " +
				"VALUES("+
			"'"+dipendente.getCodfisc()+"',"+
			"'"+dipendente.getNome()+"',"+
			"'"+dipendente.getCognome()+"',"+
			"'"+dipendente.getResidenza()+"',"+
			"'"+dipendente.getDataNascita()+"',"+
			"'"+dipendente.getLuogoNascita()+"',"+
			dipendente.getTel()+","+
			"'"+dipendente.getTipo()+"',"+
			"'"+dipendente.getSesso()+"',"+
			"'"+dipendente.getCont().toString()+"')";
		stmt.execute(query);
	}
	
	/**
	 * Ricerca un dipendente nel DataBase utilizzando come chiave di ricerca il codice fiscale.
	 * @param codFisc il codice fiscale del dipendente.
	 * @return il dipendente ricercato, null altrimenti.
	 * @throws SQLException errore con il DataBase.
	 */
	public DatiPersonale ricercaDipendente(String codFisc) throws SQLException{
		DatiPersonale result = null;
		String query = "SELECT * FROM personale WHERE codiceFiscale = '"
			+ codFisc+"'";
		ResultSet x = stmt.executeQuery(query);
		if(x.next()){
		   String  ris = x.getString(10);
		   int indice = ris.indexOf(" ");
		   String tipo = ris.substring(0,indice);
		   String nuovo = ris.substring(indice+1);
		   int indice2 = nuovo.indexOf(" ");
		   Double salario = Double.parseDouble(nuovo.substring(0,indice2));
		   String dataa = nuovo.substring(indice2+1);
		   Contratto k = new Contratto(salario,tipo,dataa);
		   result = new DatiPersonale(x.getString(1),x.getString(2),x.getString(3),
					x.getString(4),x.getString(5),x.getString(6),x.getInt(7),
					x.getString(8),x.getString(9),k);
		}
		x.close();
		return result;
	}
	
	/**
	 * Rimuove un dipendente dal DataBase.
	 * @param codFiscale il codice fiscale del dipendente da rimuovere.
	 * @throws SQLException errore con il DataBase.
	 * @throws NotFoundException dipendente non trovato.
	 */
	public void eliminaDipendente(String codFiscale) throws SQLException, NotFoundException{
		DatiPersonale result = ricercaDipendente(codFiscale);
		if(result == null)
			throw new NotFoundException("Dipendente non presente!");
		String query = "DELETE FROM personale WHERE codiceFiscale = '"+codFiscale+"'";
		stmt.executeUpdate(query);
	}
	
	/**
	 * Modifica i dati relativi ad un dipendente.
	 * @param nuovo i dati del dipendente modificati.
	 * @throws SQLException errore con il DataBase.
	 * @throws NotFoundException dipendente non trovato.
	 */
	public void modificaDipendente(DatiPersonale nuovo) throws SQLException, NotFoundException{
		DatiPersonale result = ricercaDipendente(nuovo.getCodfisc());
		if(result == null)
			throw new NotFoundException("Dipendente inesistente!");
		String query = "DELETE FROM personale WHERE codiceFiscale = '"+nuovo.getCodfisc()+"'";
		stmt.execute(query);
		aggiungiDipendente(nuovo);
	}
	
	/**
	 * Restituisce l'elenco dei dipendenti presenti nel DataBase.
	 * @return l'elenco dei dipendenti.
	 * @throws SQLException errore con il dataBase.
	 */
	public ArrayList<DatiPersonale> getElenco() throws SQLException{
		ArrayList<DatiPersonale> elenco = new ArrayList<DatiPersonale>();
		String query = "SELECT * FROM personale";
		ResultSet x = stmt.executeQuery(query);
		while(x.next()){
			String  ris = x.getString(10);
			int indice = ris.indexOf(" ");
			String tipo = ris.substring(0,indice);
			String nuovo = ris.substring(indice+1);
			int indice2 = nuovo.indexOf(" ");
			String salario2 = (nuovo.substring(0,indice2));
			Double salario = Double.parseDouble(salario2);
			String data = nuovo.substring(indice2+1);
			Contratto k = new Contratto(salario,tipo,data);			
			DatiPersonale y = new DatiPersonale(x.getString(1),x.getString(2),x.getString(3),x.getString(4),x.getString(5),
				x.getString(6),x.getInt(7),x.getString(8),x.getString(9),k);
			elenco.add(y);
		}
		x.close();
		return elenco;
	}
	
}
