package gestioneSala;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import exception.DuplicateException;



// TODO: Auto-generated Javadoc
/**
 * The Class TestDBSala.
 */
public class TestDBSala {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		try{
			
			DBSala x = new DBSala();
			x.openConnection();
			DatiSala y = x.getSala(1);
			y.setDescrizione("mariella");
			x.modificaSala(y);
			x.closeConnection();
			System.out.println(y.toString());
		}catch(SQLException e){
			System.out.println("Problema di connessione con il DataBase!");
		} catch (ClassNotFoundException e) {
			System.out.println("Classe non trovata!");
		} catch (FileNotFoundException e) {
			System.out.println("File non trovato!");
		} catch (IOException e) {
			System.out.println("Problema di comunicazione con il file!");
		} catch(DuplicateException e){
			System.out.println("Sala già presente!");
		}
		
		
	}
	
	
}
