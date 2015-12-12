package gestioneCalendario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class test.
 */
public class test {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			DatiAppuntamento elimina = new DatiAppuntamento("Massimo","Caruso","Enzo","Alessio","mariella","28/06/2009","12:00");
			DBCalendario x = new DBCalendario();
			x.openConnection();
			x.eliminaAppuntamento(elimina);
			x.closeConnection();
		}catch(SQLException e){
			System.out.println("Errore database");
		} catch (ClassNotFoundException e) {
			System.out.println("classe non trovata");
		} catch (FileNotFoundException e) {
			System.out.println("File non trovato");
		} catch (IOException e) {
			System.out.println("erore comunicazione file");
		}
		
		
	}

}
