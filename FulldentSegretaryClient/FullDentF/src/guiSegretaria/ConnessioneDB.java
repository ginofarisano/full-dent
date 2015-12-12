package guiSegretaria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;


// TODO: Auto-generated Javadoc
/**
 * The Class ConnessioneDB.
 */
public class ConnessioneDB {
  
	private String nomeDB;      
	private String nomeUtente;  
    private String pwdUtente;  
    private String errore;
     private Connection db;       
    private boolean connesso;    


   /**
    * Instanzia nuova connessione del db
    */
   public ConnessioneDB() {
      this.nomeDB = "pro";
      this.nomeUtente = "";
      this.pwdUtente = "";
      connesso = false;
      errore = "";
   }


   /**
    * Connetti.
    *
    * @return true, if successful
    */
   public boolean connetti(){
      connesso = false;
      
  	File x = new File("uspsw.txt");
  	nomeUtente = "root";
  	pwdUtente = "root";
	if(x.exists()){
		
		try {
			
			
				FileReader n = new FileReader(x);
				Scanner in = new Scanner(n);
				nomeUtente = in.next();
				pwdUtente = in.next();
				
					n.close();
					
					
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	
      try {

         Class.forName("com.mysql.jdbc.Driver");
         if (!nomeDB.equals("")) {
            if (nomeUtente.equals("")) {
               db = DriverManager.getConnection("jdbc:mysql://localhost/" +nomeDB);
            } else {
               if (pwdUtente.equals("")) {
                  db = DriverManager.getConnection("jdbc:mysql://localhost/" +nomeDB + "?user=" + nomeUtente);
               } else {
                  db = DriverManager.getConnection("jdbc:mysql://localhost/" +nomeDB + "?user=" + nomeUtente + "&password=" + pwdUtente);
               }
            }

            connesso = true;
         } else {
            System.out.println("Manca il nome del database!!");
            System.exit(0);
         }
      } catch (Exception e) { errore = e.getMessage(); e.printStackTrace(); }
      return connesso;
   }

   
   
   
   
  
   /**
    * Disconnetti.
    */
   public void disconnetti() {
      try {
         db.close();
         connesso = false;
      } catch (Exception e) { e.printStackTrace(); }
   }

   /**
    * Checks if is connesso.
    *
    * @return true, if is connesso
    */
   public boolean isConnesso() { 
	   return connesso; 
	   }  
   
   /**
    * Gets the errore.
    *
    * @return the errore
    */
   public String getErrore() { 
	   return errore;
      }       
   
   /**
    * Gets the connection.
    *
    * @return the connection
    */
   public Connection getConnection(){
	   return db;
   }

}