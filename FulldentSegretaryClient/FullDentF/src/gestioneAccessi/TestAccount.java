package gestioneAccessi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class TestAccount.
 */
public class TestAccount {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Account y = null;
			DBAccount x = new DBAccount();
			x.OpenConnection();
			y = x.getAccount("segret","abcd");
			x.closeConnection();
			System.out.println(y.getUserId()+" "+y.getPsw()+" "+y.getTipo());
		}catch(SQLException e){
			System.out.println("SQL");
		} catch (ClassNotFoundException e) {
			System.out.println("Class");
		} catch (FileNotFoundException e) {
			System.out.println("File");
		} catch (IOException e) {
			System.out.println("File 2");
		}
	}

}
