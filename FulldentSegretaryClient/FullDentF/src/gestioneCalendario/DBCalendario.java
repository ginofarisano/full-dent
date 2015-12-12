package gestioneCalendario;

import exception.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * Classe che gestisce le funzionalità di connessione con il DataBase del Calendario.
 * @author Max
 *
 */
public class DBCalendario {

	/** The conn. */
	private Connection conn;
	
	/** The stmt. */
	private Statement stmt;
	
	/** The ric. */
	private RichiamiPeriodici ric;
	
	/** The data. */
	private Date data;
	
	/**
	 * Crea un nuovo oggetto DBCalendario.
	 * @throws SQLException errore con il DataBase.	
	 * @throws ClassNotFoundException mancata individuazione della classe.
	 */
	public DBCalendario() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		data = new Date();
	}
	
	/**
	 * Apre la connessione con il DataBase.
	 * @throws SQLException errore con il DataBase.
	 * @throws IOException errore di input.
	 * @throws FileNotFoundException il file non viene trovato.
	 * @throws ClassNotFoundException classe non trovata.
	 */
	public void openConnection() throws SQLException, IOException,FileNotFoundException, ClassNotFoundException {
		File x = new File("uspsw.txt");
		String us = "root";
		String psw = "root";
		if(x.exists()){
			FileReader n = new FileReader(x);
			Scanner in = new Scanner(n);
			us = in.next();
			psw = in.next();
			n.close();
		}
		
		String url = "jdbc:mysql://localhost/pro?user="+us+"&password="+psw;
		 
		conn = DriverManager.getConnection(url);
		stmt = conn.createStatement();
			
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
	 * Metodo di supporto che inizializza l'elenco dei richiami periodici.
	 * @throws SQLException errore con il DataBase
	 * @throws ClassNotFoundException classe non trovata.
	 */
	public void initRichiami()throws SQLException,ClassNotFoundException{
		ric = new RichiamiPeriodici(visualizzaRichiamiPeriodici());
	}

	/**
	 * Restituisce l'appuntamento ricercato.
	 * @param ts il tipo di servizio dell'appuntamento.
	 * @param d la data dell'appuntamento.
	 * @return l'appuntamento desiderato, null altrimenti.
	 * @throws SQLException errore con il DataBase.
	 */
	public DatiAppuntamento ricercaAppuntamento(String ts,Data d) throws SQLException{
		DatiAppuntamento x = null;
		String query = "SELECT * FROM calendario WHERE tipoServizio = '"+ ts +"' AND data = '"+d.getData()+"' AND ora = '"+d.getOra()+"'";
		ResultSet risultato = stmt.executeQuery(query);
		boolean vuoto = true;
		while(risultato.next()){
			vuoto = false;
		}
		risultato.first();
		if(!vuoto)
			x = new DatiAppuntamento(risultato.getString(2),risultato.getString(3),risultato.getString(4),risultato.getString(5),
					risultato.getString(1),risultato.getString(6),risultato.getString(7));
		risultato.close();
		
		return x;
	}
	
	/**
	 * Inserisce un nuovo appuntamento nel calendario.
	 * @param appuntamento l'appuntamento da inserire.
	 * @throws SQLException errore con il DataBase.
	 * @throws AlreadyExistException orario occupato.
	 */
	public void inserisciAppuntamento(DatiAppuntamento appuntamento) throws SQLException, AlreadyExistException{
		DatiAppuntamento x = ricercaAppuntamento(appuntamento.getTipoServizio(),appuntamento.getDataAppuntamento());
		if(x != null)
			throw new AlreadyExistException("Orario già prenotato!");
		String query = "INSERT INTO calendario (tipoServizio,nomePaziente,cognomePaziente,nomeMedico,cognomeMedico,data,ora,richiamo)" +
						"VALUES('"+appuntamento.getTipoServizio()+"','"+appuntamento.getNomePaziente()+"','"+
						appuntamento.getCognomePaziente()+"','"+appuntamento.getNomeMedico()+"','"+appuntamento.getCognomeMedico()+
						"','"+appuntamento.getDataAppuntamento().getData()+"','"+appuntamento.getDataAppuntamento().getOra()+"',"+appuntamento.getRichiamo()+")";
		stmt.execute(query);
			
	}
	
	/**
	 * Restituisce una lista di appuntamenti di un determinato giorno.
	 * @param data il giorno desiderato.
	 * @return la lista di appuntamenti.
	 * @throws SQLException errore con il DataBase.
	 */
	public ArrayList<DatiAppuntamento> calendarioGiornaliero(Data data) throws SQLException{
		ArrayList<DatiAppuntamento> lista = new ArrayList<DatiAppuntamento>();
		String query = "SELECT * FROM calendario WHERE data = '"+data.getData()+"'";
		ResultSet risultato = stmt.executeQuery(query);
		while(risultato.next()){
			DatiAppuntamento x = new DatiAppuntamento(risultato.getString(2),risultato.getString(3),risultato.getString(4),
					risultato.getString(5),risultato.getString(1),risultato.getString(6),risultato.getString(7));
			lista.add(x);
		}
		risultato.close();
		return lista;
	}
	
	/**
	 * Elimina un appuntamento dal calendario.
	 * @param elimina l'appuntamento da eliminare.
	 * @throws SQLException errore con il DataBase.
	 * @throws NotFoundAppuntamentException appuntamento non presente.
	 */
	public void eliminaAppuntamento(DatiAppuntamento elimina) throws SQLException, NotFoundAppuntamentException{
		if(ricercaAppuntamento(elimina.getTipoServizio(), elimina.getDataAppuntamento())== null)
			throw new NotFoundAppuntamentException("Appuntamento non presente!");
		String query = "DELETE FROM calendario WHERE tipoServizio = '"+elimina.getTipoServizio()+"' AND data = '"+
						elimina.getDataAppuntamento().getData()+"' AND ora = '"+elimina.getDataAppuntamento().getOra()+"'";
		stmt.execute(query);
	}

	/**
	 * Modifica un appuntamento nel calendario.
	 * @param appuntamento l'appuntamento prima della modifica.
	 * @param modifica l'appuntamento modificato.
	 * @throws SQLException errore con il DataBase.
	 * @throws NotFoundAppuntamentException appuntamento non trovato.
	 */
	public void modificaAppuntamento(DatiAppuntamento appuntamento,DatiAppuntamento modifica) throws SQLException,NotFoundAppuntamentException{
		if(ricercaAppuntamento(appuntamento.getTipoServizio(), appuntamento.getDataAppuntamento())!= null)
			throw new NotFoundAppuntamentException("Appuntamento non presente!");
		eliminaAppuntamento(appuntamento);
		inserisciAppuntamento(modifica);
		
	}
	
	/**
	 * Visualizza gli appuntamenti relativi ad un servizio ed una data scelti.
	 *
	 * @param ts tipo del servizio.
	 * @param d the d
	 * @return d data richiesta.
	 * @throws SQLException errore con il DataBase.
	 */	
	public ArrayList<DatiAppuntamento> visualizza(String ts,Data d) throws SQLException {
		ArrayList<DatiAppuntamento> lista = new ArrayList<DatiAppuntamento>();
		String query = ("SELECT * FROM calendario WHERE tipoServizio = '"+ts+
				"' AND data = '"+d.getData()+"'");
		ResultSet x = stmt.executeQuery(query);
		while(x.next()){
			DatiAppuntamento z = new DatiAppuntamento(x.getString(2),x.getString(3),x.getString(4),
					x.getString(5),x.getString(1),x.getString(6),x.getString(7));
			lista.add(z);
		}
		x.close();
		return lista;
	}
	
	/**
	 * Restituisce una lista contenente gli appuntamenti del giorno successivo a quello attuale
	 * ai quali non è stato effettuato il richiamo.  
	 * @return la lista creata.
	 * @throws SQLException errore con il DataBase.
	 */
	public ArrayList<DatiAppuntamento> visualizzaRichiamiPeriodici() throws SQLException {
		ArrayList<DatiAppuntamento> lista = new ArrayList<DatiAppuntamento>();
		String tempo = "";
		int mese = data.getMonth()+1;
		int giorno = data.getDate();
		if(mese<10){
			if(giorno < 10)
				tempo = afterDay("0"+data.getDate()+"/0"+(data.getMonth()+1)+"/"+(data.getYear()+1900));
			else tempo = afterDay(data.getDate()+"/0"+(data.getMonth()+1)+"/"+(data.getYear()+1900));
		}else tempo = afterDay(data.getDate()+"/"+(data.getMonth()+1)+"/"+(data.getYear()+1900));
		String query = "SELECT * FROM calendario WHERE data = '"+tempo+"' AND richiamo = 0";
		ResultSet x = stmt.executeQuery(query);
		while(x.next()){
			DatiAppuntamento z = new DatiAppuntamento(x.getString(2),x.getString(3),x.getString(4),
					x.getString(5),x.getString(1),x.getString(6),x.getString(7));
			lista.add(z);
		}
		x.close();
		return lista;
		
	}
	
	/**
	 * Effettua il richiamo di un appuntamento settando il suo valore richiamo ad 1.
	 * @param app l'appuntamento di cui si deve effettuare il richiamo.
	 * @throws SQLException errore con il DataBase.
	 */
	public void effettuaRichiamo(DatiAppuntamento app) throws SQLException{
		String query = "UPDATE calendario SET richiamo = 1 WHERE tipoServizio = '"+app.getTipoServizio()+
			"' AND data = '"+app.getDataAppuntamento().getData()+"' AND ora = '"+ app.getDataAppuntamento().getOra()+"'";
		stmt.executeUpdate(query);
	}
		
	/**
	 * Metodo di supporto.Restituisce la data successiva a quella data in input.
	 * @param time la data da modificare.
	 * @return la data successiva.
	 */
	protected String afterDay(String time) {
		String tempo = "";
		int giorno = Integer.parseInt(time.substring(0,2));
		int mese = Integer.parseInt(time.substring(3,5));
		int anno = Integer.parseInt(time.substring(6));
		int flag = 0;
		if((((anno%4 == 0) || (anno%400)==0) && (anno%100 != 0)) && mese == 2 && giorno == 29){
			tempo="01/"+((mese+1)%12)+"/"+anno;
			flag = 1;
		}
		
		if(((mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8 || mese == 10 || mese == 12) && giorno == 31)
				|| ((mese == 4 || mese == 6 || mese == 9 || mese == 11) && giorno == 30)
				|| (mese == 2 && giorno == 28)){
			if(mese == 12)
				anno++;
			tempo="01/"+((mese+1)%12)+"/"+anno;
			flag = 1;
		}
		if(flag == 0)
			if(mese<10){
				if(giorno < 10)
					tempo="0"+(giorno+1)+"/0"+(mese)+"/"+anno;
				else tempo=""+(giorno+1)+"/0"+(mese)+"/"+anno;
			}else tempo=""+(giorno+1)+"/"+(mese)+"/"+anno;
		return tempo;
	}
	
}
