package db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import util.CurrentTime;
import bean.Appuntamento;
import bean.Personale;
import bean.Prenotazione;
import bean.Prestazione;
import bean.RiepilogoStorico;
import bean.StoricoPaziente;
import bean.Utente;
import bean.Visita;

/**
 * Classe che gestisce le funzionalit� di connessione con il DataBase degli
 * Account.
 * 
 * @author
 * 
 */
public class DBAccount {

	private Statement stmt;
	private Connection conn;

	/**
	 * Crea un nuovo oggetto DBAccount.
	 * 
	 * @throws SQLException
	 *             errore con il DataBase.
	 * @throws ClassNotFoundException
	 *             mancata individuazione della classe.
	 */
	public DBAccount() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}

	/**
	 * Apre la connessione con il DataBase.
	 * 
	 * @throws SQLException
	 *             errore con il DataBase.
	 * @throws IOException
	 *             errore di input.
	 * @throws FileNotFoundException
	 *             il file non viene trovato.
	 * @throws ClassNotFoundException
	 *             la classe non viene trovata.
	 */
	public void openConnection() throws SQLException, FileNotFoundException,
			IOException, ClassNotFoundException {
		String usr = "root";
		String psw="psd";
		// File x=new File("uspsw.txt");
		// if (x.exists()) {
		// FileReader fileAttrez=new FileReader(x);
		// Scanner scanFile=new Scanner(fileAttrez);
		// usr=scanFile.next();
		// psw=scanFile.next();
		// fileAttrez.close();
		// }
		String url = "jdbc:mysql://localhost/pro?user=" + usr +"&password=psd";
		conn = DriverManager.getConnection(url);
		stmt = conn.createStatement();
	}

	/**
	 * Metodo che chiude la connessione con il DataBase;
	 * 
	 * @throws SQLException
	 *             errore all'accesso al DataBase;
	 */
	public void closeConnection() throws SQLException {
		conn.close();
		stmt.close();
	}

	public Utente getAccount(String user, String password) throws SQLException {
		Utente a = new Utente();
		ResultSet rs = stmt.executeQuery("SELECT * FROM utente WHERE email = '"
				+ user + "' AND password = '" + password + "'");

		if (rs.next()) {
			a.setCodiceFiscale(rs.getString("codiceFiscale"));
			a.setCognome(rs.getString("cognome"));
			a.setEmail(rs.getString("email"));
			a.setIndirizzo(rs.getString("indirizzo"));
			a.setNome(rs.getString("nome"));
			a.setPassword(rs.getString("password"));
			a.setTelefono(rs.getString("telefono"));

		}
		rs.close();
		return a;
	}
	
	private boolean controlla(String user, String password) throws SQLException {
		ResultSet rs = stmt.executeQuery("SELECT * FROM account WHERE userId = '"+user+"' AND password = '"+password+"'");
		
		if(rs.next()){
			
			return true;
		}
			
		
		return false;
	}

	public Visita getAppuntamento (String user, String password) throws SQLException{
		// TODO Auto-generated method stub
		final Calendar c = Calendar.getInstance();
		final int year;
		final int month;
		final int day;
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		ResultSet rs = stmt
				.executeQuery("SELECT prenotazione.data,  prenotazione.ora , prestazione.Nome,personale.nome,personale.cognome FROM utente,"
						+ "prenotazione,prestazione,personale WHERE utente.email = '"
						+ user
						+ "' AND utente.password = '"
						+ password
						+ "' AND utente.codiceFiscale=prenotazione.codiceFiscale AND "
						+ "personale.codiceFiscale=prenotazione.idPersonale AND "
						+ "prenotazione.data>='"
						+ CurrentTime.currentTime()
						+ "' and prenotazione.idPrestazione=prestazione.idPrestazione");
		
		Visita visita = new Visita();
		
		while (rs.next()) {

	
			visita.setData(rs.getString("prenotazione.data"));
			visita.setOra(rs.getString("prenotazione.ora"));		
			visita.setNomePrestazione(rs.getString("prestazione.Nome"));
			visita.setNomePersonale(rs.getString("personale.nome"));
			visita.setCognomePersonale(rs.getString("personale.cognome"));

			

		}
		
		return visita;
		
		
		

	}

	public ArrayList<Visita> getStorico(String user, String password,
			String da, String a) throws SQLException {

		// Select
		// utente.codiceFiscale,prenotazione.data,prenotazione.ora,storico.pagato,storico.note,personale.nome,personale.cognome
		// from
		// utente,prenotazione,storico,personale where
		// utente.codiceFiscale='frsgni89e01i422h' and utente.password='blabla'
		// and
		// utente.codiceFiscale=prenotazione.codiceFiscale and
		// prenotazione.idPrenotazione=storico.idPrenotazione
		// and prenotazione.data>='22/05/2013' and
		// prenotazione.data<='22/05/2014' and
		// prenotazione.idPersonale=personale.codiceFiscale

		ResultSet rs = stmt
				.executeQuery("SELECT prenotazione.data,  prenotazione.ora,storico.pagato,storico.note, prestazione.Nome,personale.nome,personale.cognome FROM utente,"
						+ "prenotazione,storico,prestazione,personale WHERE utente.email = '"
						+ user
						+ "' AND utente.password = '"
						+ password
						+ "' AND utente.codiceFiscale=prenotazione.codiceFiscale AND "
						+ "personale.codiceFiscale=prenotazione.idPersonale AND "
						+ "prenotazione.idPrenotazione=storico.idPrenotazione AND "
						+ "prenotazione.data>='"
						+ da
						+ "' and prenotazione.data<='"
						+ a
						+ "' and prenotazione.idPrestazione=prestazione.idPrestazione");

		ArrayList<Visita> visite = new ArrayList<Visita>();
		

		while (rs.next()) {
			

			Visita visitaI = new Visita();

			visitaI.setData(rs.getString("prenotazione.data"));
			visitaI.setOra(rs.getString("prenotazione.ora"));
			visitaI.setPagato(rs.getString("storico.pagato"));
			visitaI.setNote(rs.getString("storico.note"));
			visitaI.setNomePrestazione(rs.getString("prestazione.Nome"));
			visitaI.setNomePersonale(rs.getString("personale.nome"));
			visitaI.setCognomePersonale(rs.getString("personale.cognome"));

			visite.add(visitaI);

		}

		return visite;
	}

	/**
	 * Inserisce un nuovo Account nel DataBase.
	 * 
	 * @param acc
	 *            il nuovo account da inserire.
	 * @throws SQLException
	 *             errore nell'accesso al DataBase.
	 * @throws InvalidDataException
	 *             errore nell'inserimento dei dati.
	 * @throws DuplicateException
	 *             account gi� presente nel DataBase.
	 */
	// public void inserisciAccount(Account acc)throws
	// SQLException,InvalidDataException,DuplicateException{
	// if (isPresente(acc))
	// throw new DuplicateException("Account gi� presente");
	// String query= ("INSERT INTO account VALUES" +
	// "('"+acc.getTipo()+"','"+acc.getUserId()+"','"
	// +acc.getPsw()+"')");
	// stmt.execute(query);
	// }

	/**
	 * Metodo che verifica se un account � presente nel DataBase.
	 * 
	 * @throws SQLException
	 *             errore nell'accesso al DataBase.
	 * @return true se l'account � presente, false altrimenti.
	 */
	// public boolean isPresente (Account acc)throws SQLException{
	// Account a= getAccount(acc.getUserId(),acc.getPsw());
	// if (a == null)
	// return false;
	// return true;
	// }
	//
	/**
	 * Metodo che ritorna l'account presente nel DataBase che ha come userId e
	 * password quelli dati in input.
	 * 
	 * @throws SQLException
	 *             errore all'accesso al DataBase.
	 * @return l'account richiesto, null altrimenti.
	 * */
	// public Account getAccount(String us,String psw)throws SQLException{
	// Account a = null;
	// ResultSet rs =
	// stmt.executeQuery("SELECT * FROM account WHERE userId = '"+us+"' AND password = '"+psw+"'");
	// boolean rsVuoto=true;
	// while(rs.next()){
	// rsVuoto=false;
	// }
	// rs.first();
	// if(!rsVuoto)
	// a = new Account(rs.getString(3),rs.getString(1),rs.getString(2));
	// rs.close();
	// return a;
	// }

	/**
	 * Restituisce il codice fiscale dell'amministatore del centro.
	 * 
	 * @return il codice fiscale dell'amministratore.
	 * @throws SQLException
	 *             errore con il DataBase.
	 */
	public String getCF() throws SQLException {
		String query = "SELECT * FROM account WHERE Tipo = 'amministratore'";
		ResultSet x = stmt.executeQuery(query);
		x.first();
		return x.getString(4);
	}

	/**
	 * Elimina un account dal DataBase.
	 * 
	 * @param acc
	 *            l'account da eliminare.
	 * @throws SQLException
	 *             errore con il DataBase.
	 * @throws NotFoundException
	 *             account non trovato.
	 * @throws InvalidDataException
	 *             dati errati.
	 */
	// public void eliminaAccount(Account acc)throws
	// SQLException,NotFoundException, InvalidDataException {
	// if(!isPresente(acc))
	// throw new NotFoundException("Account non presente");
	// String
	// query=("DELETE FROM account WHERE userId = '"+acc.getUserId()+"' AND password = '"+acc.getPsw()+"'");
	// stmt.execute(query);
	// }

	/**
	 * Restituisce l'elenco di tutti gli account presenti nel DataBase.
	 * 
	 * @return l'elenco degli account.
	 * @throws SQLException
	 *             errore con il DataBase.
	 */
	// public ArrayList<Account> getElenco() throws SQLException{
	// ArrayList<Account> elenco = new ArrayList<Account>();
	// String query = "SELECT * FROM account";
	// ResultSet rs = stmt.executeQuery(query);
	// while(rs.next()){
	// Account x = new Account(rs.getString(1),rs.getString(2),rs.getString(3));
	// elenco.add(x);
	// }
	// rs.close();
	// return elenco;
	// }
	
	
	// -------------------------------- FUNZIONI LATO CLIENT ----------------------------------------
	
	

	public String insertUtente(Utente u, String user, String password){
		
		 try {	

			 
			 if(controlla(user,password)){
				 PreparedStatement st;
					String SQL=null;
					
				         SQL = "INSERT INTO utente(codiceFiscale,nome,cognome,telefono,email,password,indirizzo)" +
				         		"VALUES(?,?,?,?,?,?,?)";
					   
					   
							st= conn.prepareStatement(SQL);
					
					     
						    st.setString(1, u.getCodiceFiscale());
						    st.setString(2, u.getNome());
						    st.setString(3, u.getCognome());
						    st.setString(4, u.getTelefono());
						    st.setString(5, u.getEmail());
						    st.setString(6, u.getPassword());
						    st.setString(7, u.getIndirizzo());
						   
							st.executeUpdate();
							closeConnection();
							return "ok";
							
			 }
			 
					   			
		 closeConnection();
		 } catch (SQLException e1) {
				e1.printStackTrace();
			}
		 return "no";	
		    
	    }
	
				  
	public String insertPrenotazione(Prenotazione p , String user, String password){
			 try {	

			 
			 if(controlla(user,password)){
				 PreparedStatement st;
					String SQL=null;
					 
					SQL = "INSERT INTO prenotazione(codiceFiscale,idPrestazione,idPersonale,data,ora,richiamo) "
							+ "VALUES(?,?,?,?,?,?)";
					    
					   
							st= conn.prepareStatement(SQL);
						    st.setString(1, p.getCodiceFiscale());
						    st.setString(2, p.getIdPrestazione());
						    st.setString(3, p.getIdPersonale());
					        st.setString(4, p.getData().replace("-", "/"));
					        st.setString(5, p.getOra());
						    st.setInt(6, 1);
						   
							st.executeUpdate();
							closeConnection();
							return "ok";
			 }
			 
					   			
			 closeConnection();
			 } catch (SQLException e1) {
					e1.printStackTrace();
				}
		 return "no";	
		    
	    }
	
	
	public String insertStorico(StoricoPaziente p , String user, String password){
		 try {	

		 
		 if(controlla(user,password)){
			 PreparedStatement st;
				String SQL=null;
				 
				SQL = "INSERT INTO storico(idPrenotazione,pagato,note) VALUES(?,?,?)";
				    
				   
						st= conn.prepareStatement(SQL);
					    st.setString(1, p.getIdPrenotazione());
					    st.setString(2, p.getPagato());
					    st.setString(3, p.getNote());
						st.executeUpdate();
						closeConnection();
						return "ok";
		 }
		 
				   			
	
		 closeConnection();
		 } catch (SQLException e1) {
				e1.printStackTrace();
			}
		 return "no";	
	    
   }

	public String eliminaPrenotazione(Prenotazione p , String user, String password){
		 try {	

		 
		 if(controlla(user,password)){
			 PreparedStatement st;
				String SQL = "DELETE FROM prenotazione WHERE data='"+p.getData()+"' and ora='"+p.getOra()+"' and idPersonale='"+p.getIdPersonale()+"'";
			    st= conn.prepareStatement(SQL);
		        st.executeUpdate();
				    
		        		closeConnection();
						return "ok";
		 }
		 
				    	
		 closeConnection();
		 } catch (SQLException e1) {
				e1.printStackTrace();
			}		
	 return "no";	
	    
  }

	public String modificaStorico(StoricoPaziente p , String user, String password){
		 try {	

		 
		 if(controlla(user,password)){
			 PreparedStatement st;
				String SQL = "UPDATE storico SET pagato = ?,note=? WHERE idPrenotazione = ?";
				st= conn.prepareStatement(SQL);
			    st.setString(1, p.getPagato());
			    st.setString(2, p.getNote());
			    st.setString(3, p.getIdPrenotazione());
				st.executeUpdate();
				    closeConnection();
						return "ok";
		 }
		 
		 closeConnection();
		 } catch (SQLException e1) {
				e1.printStackTrace();
			}			
	
	 return "no";	
	    
 }
	
	public String modificaPagatoStorico(StoricoPaziente p , String user, String password){
		 try {	

		 
		 if(controlla(user,password)){
			 PreparedStatement st;
				String SQL = "UPDATE storico SET pagato = ? WHERE idPrenotazione = ?";
				st= conn.prepareStatement(SQL);
			    st.setString(1, p.getPagato());
			    st.setString(2, p.getIdPrenotazione());
				st.executeUpdate();
				    closeConnection();
						return "ok";
		 }
		 
		 closeConnection();
		 } catch (SQLException e1) {
				e1.printStackTrace();
			}				
	
	 return "no";	
	    
}
	
	public String modificaPaziente(Utente p , String user, String password){
		 try {	

		 
		 if(controlla(user,password)){
			 PreparedStatement st;
				String SQL = "UPDATE utente SET nome=?,cognome=?,telefono=?,indirizzo=?,email=? WHERE codiceFiscale= '" + p.getCodiceFiscale() + "'";
				st= conn.prepareStatement(SQL);
			    st.setString(1, p.getNome());
			    st.setString(2, p.getCognome());
			    st.setString(3, p.getTelefono());
			    st.setString(4, p.getIndirizzo());
			    st.setString(5, p.getEmail());
				st.executeUpdate();
				    closeConnection();
						return "ok";
		 }
		 
		 closeConnection();
		 } catch (SQLException e1) {
				e1.printStackTrace();
			}				
	
	 return "no";	
	    
}
	
	public ArrayList<Utente> getClienti(String user, String password,String cognome,String nome) throws SQLException {
		ArrayList<Utente> u = new ArrayList<Utente>();
		

		if(controlla(user,password)){
			ResultSet rs=null;
			  if(nome.equals("null") && !cognome.equals("null"))
				    rs = stmt.executeQuery("SELECT * FROM utente WHERE Cognome LIKE '" + cognome + "%%'");
			    else if(cognome.equals("null") && !nome.equals("null"))
				   rs = stmt.executeQuery("SELECT * FROM utente WHERE Nome LIKE '" + nome + "%%'");
			    else if(!cognome.equals("null") && !nome.equals("null"))
				    rs = stmt.executeQuery("SELECT * FROM utente WHERE Cognome LIKE '" + cognome + "%%' and Nome LIKE '" + nome + "%%'");
			    else if(nome.equals("null") && cognome.equals("null"))
				    rs = stmt.executeQuery("SELECT * FROM utente");
						
			while (rs.next()) {
				Utente a=new Utente();
				a.setCodiceFiscale(rs.getString("codiceFiscale"));
				a.setNome(rs.getString("nome"));
				a.setCognome(rs.getString("cognome"));
				a.setEmail(rs.getString("email"));
				a.setIndirizzo(rs.getString("indirizzo"));
				a.setTelefono(rs.getString("telefono"));
	
				u.add(a);
			}
			rs.close();
			closeConnection();
		}
		
		return u;
	}


	public ArrayList<Utente> getResetClienti(String user, String password,String idCliente) throws SQLException {
		ArrayList<Utente> u = new ArrayList<Utente>();
		

		if(controlla(user,password)){
			ResultSet rs = stmt.executeQuery("SELECT * FROM utente WHERE codiceFiscale= '" + idCliente + "'");
						
			while (rs.next()) {
				Utente a=new Utente();
				a.setCodiceFiscale(rs.getString("codiceFiscale"));
				a.setNome(rs.getString("nome"));
				a.setCognome(rs.getString("cognome"));
				a.setEmail(rs.getString("email"));
				a.setIndirizzo(rs.getString("indirizzo"));
				a.setTelefono(rs.getString("telefono"));
	
				u.add(a);
			}
			closeConnection();
			rs.close();
		}
		
		return u;
	}
	
	
	public ArrayList<Personale> getCollaboratori(String user, String password,String nome,String cognome) throws SQLException {
		ArrayList<Personale> u = new ArrayList<Personale>();
		

		if(controlla(user,password)){
			ResultSet rs=null;
			
			if(nome.equals("null") && cognome.equals("null"))
				rs = stmt.executeQuery("SELECT * FROM personale WHERE tipo='medico'");
			else 
				rs = stmt.executeQuery("SELECT * FROM personale WHERE tipo='medico' and nome='"+nome+"' and cognome='"+cognome+"'");
			
			
			while (rs.next()) {
				Personale a=new Personale();
				a.setCodiceFiscale(rs.getString("codiceFiscale"));
				a.setNome(rs.getString("nome"));
				a.setCognome(rs.getString("cognome"));
	            u.add(a);
			}
			closeConnection();
			rs.close();
		}
		
		return u;
	}
	
	public ArrayList<Appuntamento> getAppuntamenti(String user, String password,
			String data, String ora) throws SQLException {
		
		ArrayList<Appuntamento> visite = new ArrayList<Appuntamento>();

		
		if(controlla(user,password)){
			
			
			ResultSet rs = stmt
					.executeQuery("SELECT Prest.*, Pren.*, u.*, Pers.*,s.* FROM prenotazione AS Pren"
				    		+ " INNER JOIN prestazione AS Prest ON Prest.idPrestazione=Pren.idPrestazione"
				    		+ " INNER JOIN utente AS u ON u.codiceFiscale=Pren.codiceFiscale"
				    		+ " INNER JOIN personale AS Pers ON Pers.codiceFiscale=Pren.idPersonale"
				    		+ " INNER JOIN storico AS s ON s.idPrenotazione=Pren.idPrenotazione"
				    		+ " WHERE Pren.data='"+data+"' and Pren.ora='"+ora+"'");

			while (rs.next()) {
				
	
				Appuntamento visitaI = new Appuntamento();
	
				visitaI.setNomePers(rs.getString("Pers.nome"));
				visitaI.setCognomePers(rs.getString("Pers.cognome"));
				visitaI.setNomeUtente(rs.getString("u.nome"));
				visitaI.setCognomeUtente(rs.getString("u.cognome"));
				visitaI.setNomePrestazione(rs.getString("Prest.Nome"));
				visitaI.setPagato(rs.getString("s.pagato"));
				visitaI.setDurata(rs.getString("Prest.durata"));
				
				visite.add(visitaI);
	
			}
			closeConnection();
		}
		return visite;
	}
		
	public ArrayList<Prestazione> getServizi(String user, String password,String nome) throws SQLException {
		ArrayList<Prestazione> u = new ArrayList<Prestazione>();
		ResultSet rs=null;

		if(controlla(user,password)){
			
			if(nome.equals("null"))
				rs = stmt.executeQuery("SELECT * FROM prestazione");
			else
				rs = stmt.executeQuery("SELECT * FROM prestazione WHERE Nome='"+nome.replace("_", " ")+"'");
			while (rs.next()) {
				Prestazione a=new Prestazione();
				a.setIdPrest(rs.getString("idPrestazione"));
				a.setDurata(rs.getString("durata"));
				a.setNomePrest(rs.getString("Nome"));
	
				u.add(a);
			}
			rs.close();
			closeConnection();
		}
		
		return u;
	}
	
	public ArrayList<Prenotazione> getPrenotazioneCodice(String user, String password,String codice) throws SQLException {
		ArrayList<Prenotazione> u = new ArrayList<Prenotazione>();
		

		if(controlla(user,password)){
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM prenotazione WHERE idPrestazione='"+codice+"'");
			   
			while (rs.next()) {
				Prenotazione p=new Prenotazione();
				p.setIdPrenotazione(rs.getString("idPrenotazione"));
				p.setCodiceFiscale(rs.getString("codiceFiscale"));
				p.setIdPrestazione(rs.getString("idPrestazione"));
				p.setIdPersonale(rs.getString("idPersonale"));
				p.setData(rs.getString("data"));
				p.setOra(rs.getString("ora"));
				u.add(p);
			}
			rs.close();
			closeConnection();
		}
		
		return u;
	}
	
	public ArrayList<StoricoPaziente> getStorico(String user, String password,String idPrenotazione) throws SQLException {
		ArrayList<StoricoPaziente> u = new ArrayList<StoricoPaziente>();
		

		if(controlla(user,password)){
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM storico WHERE idPrenotazione='"+idPrenotazione+"'");
			while (rs.next()) {
				StoricoPaziente p=new StoricoPaziente();
				p.setIdPrenotazione(rs.getString("idPrenotazione"));
				p.setNote(rs.getString("note"));
				p.setPagato(rs.getString("pagato"));
				u.add(p);
			}
			rs.close();
			closeConnection();
		}
		
		return u;
	}
	
	public ArrayList<Prenotazione> getPrenotazione(String user, String password,String data,String ora,String codiceMedico) throws SQLException {
		ArrayList<Prenotazione> u = new ArrayList<Prenotazione>();
		

		if(controlla(user,password)){
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM prenotazione WHERE data='"+data+"' and ora='"+ora+"' and idPersonale='"+codiceMedico+"'");
			   
			while (rs.next()) {
				Prenotazione p=new Prenotazione();
				p.setIdPrenotazione(rs.getString("idPrenotazione"));
				p.setCodiceFiscale(rs.getString("codiceFiscale"));
				p.setIdPrestazione(rs.getString("idPrestazione"));
				p.setIdPersonale(rs.getString("idPersonale"));
				p.setData(rs.getString("data"));
				p.setOra(rs.getString("ora"));
				u.add(p);
			}
			rs.close();
			closeConnection();
		}
		
		return u;
	}
	
	public ArrayList<RiepilogoStorico> getRiepilogoStorico(String user, String password,String idUtente) throws SQLException {
		ArrayList<RiepilogoStorico> u = new ArrayList<RiepilogoStorico>();
		

		if(controlla(user,password)){
			
			ResultSet rs=stmt.executeQuery("SELECT Prest.*, Pren.*, u.*, Pers.*,s.* FROM prenotazione AS Pren"
		    		+ " INNER JOIN prestazione AS Prest ON Prest.idPrestazione=Pren.idPrestazione"
		    		+ " INNER JOIN utente AS u ON u.codiceFiscale=Pren.codiceFiscale"
		    		+ " INNER JOIN personale AS Pers ON Pers.codiceFiscale=Pren.idPersonale"
		    		+ " INNER JOIN storico AS s ON s.idPrenotazione=Pren.idPrenotazione"
		    		+ " WHERE Pren.codiceFiscale='"+idUtente+"'"
		    		);
			
			while (rs.next()) {
				RiepilogoStorico p=new RiepilogoStorico();
				
				p.setData(rs.getString("Pren.data"));
				p.setOra(rs.getString("Pren.ora"));
				p.setPrestnome(rs.getString("Prest.Nome"));
                p.setPersNome(rs.getString("Pers.nome"));
                p.setPersCognome(rs.getString("Pers.cognome"));
                p.setNote(rs.getString("s.note"));
                p.setPagato(rs.getString("s.pagato"));
                p.setIdPrenotazione(rs.getString("s.idPrenotazione"));
				
                
                u.add(p);
			}
			closeConnection();
			rs.close();
		}
		
		return u;
	}
	
	
	public ArrayList<Personale> getCollaboratoriCodice(String user, String password,String codice) throws SQLException {
		ArrayList<Personale> u = new ArrayList<Personale>();
		

		if(controlla(user,password)){
			ResultSet rs=null;
		
				rs = stmt.executeQuery("SELECT * FROM personale WHERE tipo='medico' and codiceFiscale='"+codice+"'");
			
			
			while (rs.next()) {
				Personale a=new Personale();
				a.setCodiceFiscale(rs.getString("codiceFiscale"));
				a.setNome(rs.getString("nome"));
				a.setCognome(rs.getString("cognome"));
	            u.add(a);
			}
			closeConnection();
			rs.close();
		}
		
		return u;
	}
	
	
	public ArrayList<Prenotazione> getPrenotazioneData(String user, String password,String data,String ora) throws SQLException {
		ArrayList<Prenotazione> u = new ArrayList<Prenotazione>();
		

		if(controlla(user,password)){
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM prenotazione WHERE data='"+data+"' and ora='"+ora+"'");
			   
			while (rs.next()) {
				Prenotazione p=new Prenotazione();
				p.setIdPrenotazione(rs.getString("idPrenotazione"));
				p.setCodiceFiscale(rs.getString("codiceFiscale"));
				p.setIdPrestazione(rs.getString("idPrestazione"));
				p.setIdPersonale(rs.getString("idPersonale"));
				p.setData(rs.getString("data"));
				p.setOra(rs.getString("ora"));
				u.add(p);
			}
			rs.close();
			closeConnection();
		}
		
		return u;
	}

}
