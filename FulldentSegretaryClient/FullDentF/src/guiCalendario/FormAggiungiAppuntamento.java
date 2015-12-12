package guiCalendario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import exception.AlreadyExistException;

import gestioneCalendario.DBCalendario;
import gestioneCalendario.DatiAppuntamento;
import guiSegretaria.FormCalendario;

// TODO: Auto-generated Javadoc
/**
* Interfaccia grafica per l'aggiunta di un nuovo appuntamento.
* @author Fruncillo Filomena
*/
public class FormAggiungiAppuntamento extends javax.swing.JFrame {

   /** 
    * Crea un nuovo Form.
    */
   public FormAggiungiAppuntamento() {
       initComponents();
   }

   /**
    * Metodo di supporto che inizializza le componenti del Frame.
    */
   private void initComponents() {

       jPanel1 = new javax.swing.JPanel();
       jLabel1 = new javax.swing.JLabel();
       jTextField1 = new javax.swing.JTextField();
       jLabel2 = new javax.swing.JLabel();
       jTextField2 = new javax.swing.JTextField();
       jLabel3 = new javax.swing.JLabel();
       jTextField3 = new javax.swing.JTextField();
       jLabel4 = new javax.swing.JLabel();
       jTextField4 = new javax.swing.JTextField();
       jLabel5 = new javax.swing.JLabel();
       jTextField5 = new javax.swing.JTextField();
       jLabel6 = new javax.swing.JLabel();
       jTextField6 = new javax.swing.JTextField();
       jLabel7 = new javax.swing.JLabel();
       jTextField7 = new javax.swing.JTextField();
       jButton1 = new javax.swing.JButton();
       jButton2 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

       jLabel1.setText("Tipo Servizio");

       jLabel2.setText("Nome Paziente");

       jLabel3.setText("Cognome Paziente");

       jLabel4.setText("Nome Medico");

       jLabel5.setText("Cognome Medico");

       jLabel6.setText("Data");

       jLabel7.setText("Ora");

       jButton1.setText("Annulla");
       jButton1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton1ActionPerformed(evt);
           }
       });

       jButton2.setText("Aggiungi");
       jButton2.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton2ActionPerformed(evt);
           }
       });

       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
       jPanel1.setLayout(jPanel1Layout);
       jPanel1Layout.setHorizontalGroup(
           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(jPanel1Layout.createSequentialGroup()
               .addGap(19, 19, 19)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addComponent(jLabel1)
                   .addComponent(jLabel2)
                   .addComponent(jLabel3)
                   .addComponent(jLabel4))
               .addGap(40, 40, 40)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(jTextField4)
                   .addComponent(jTextField3)
                   .addComponent(jTextField2)
                   .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
               .addGap(32, 32, 32)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addComponent(jLabel5)
                   .addComponent(jLabel6)
                   .addComponent(jLabel7))
               .addGap(32, 32, 32)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(jTextField7)
                   .addComponent(jTextField6)
                   .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
               .addContainerGap(28, Short.MAX_VALUE))
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
               .addContainerGap(173, Short.MAX_VALUE)
               .addComponent(jButton2)
               .addGap(187, 187, 187)
               .addComponent(jButton1)
               .addGap(78, 78, 78))
       );
       jPanel1Layout.setVerticalGroup(
           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(jPanel1Layout.createSequentialGroup()
               .addGap(26, 26, 26)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel1)
                   .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel5)
                   .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(38, 38, 38)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel2)
                   .addComponent(jLabel6)
                   .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(28, 28, 28)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                   .addComponent(jLabel3)
                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                       .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(jLabel7)
                       .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGap(36, 36, 36)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                   .addComponent(jLabel4)
                   .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jButton2)
                   .addComponent(jButton1))
               .addContainerGap())
       );

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addContainerGap())
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap())
       );

       pack();
       this.setTitle("FullDent - Nuovo Appuntamento");
   }
   
   /**
    * Azione eseguita alla pressione del bottone "aggiungi".
    * Inserisce un nuovo appuntamento.
    * @param evt il ricevitore d'evento.
    */
   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {  
	   try{
		   String ts = jTextField2.getText();
		   String np = jTextField3.getText();
		   String cp = jTextField4.getText();
		   String nm = jTextField5.getText();
		   String cm = jTextField1.getText();
		   String d = jTextField6.getText();
		   String o = jTextField7.getText();
		   
	
		   if(!(ts.equals("") || np.equals("") || cp.equals("") || nm.equals("")
				|| cm.equals("") || d.equals("") || o.equals(""))){
			   if(formatoData(d,o)){
				   if(controlloDataMaggiore(d,o)){
	
					   
					   DatiAppuntamento y = new DatiAppuntamento(ts,np,cp,nm,cm,d,o);
					   DBCalendario x = new DBCalendario();
					   x.openConnection();
					   x.inserisciAppuntamento(y);
					   x.closeConnection();
					   successo();
					   this.setVisible(false);
					   new FormCalendario().setVisible(true);
				   }else errore("La data e/o ora inserita è antecedente a quella odierna!");
			   }else errore("Il formato data e/o ora non è valido! (GG/MM/AAAA HH:MM)");
		}else errore("Tutti i campi devono essere inseriti!");
	   }catch(SQLException e){
			errore("Errore d'accesso al DataBase!");
		}catch(FileNotFoundException e){
			errore("File di accesso al DataBase non trovato!");
		} catch (ClassNotFoundException e) {
			errore("Classe non trovata!");
		} catch (IOException e) {
			errore("Errore di comunicazione con il file!");
		} catch(AlreadyExistException e){
			errore("Orario occupato!");
		}
   } 
   
   /**
    * Metodo di supporto che controlla se la data passata è 
    * successiva a quella odierna.
    * @param data la data da controllare.
    * @param ora l'ora da controllare.
    * @return true nel caso sia corretta, false altrimenti.
    */
   protected boolean controlloDataMaggiore(String data,String ora){
	   Date x = new Date();
	   int g = x.getDate();
	   int m = x.getMonth()+1;
	   int y = x.getYear()+1900;
	   int h = x.getHours();
	   int mi = x.getMinutes();
	   
	   int giorno = Integer.parseInt(data.substring(0, 2));
	   int mese = Integer.parseInt(data.substring(3,5));
	   int anno = Integer.parseInt(data.substring(6));
	   int hour = Integer.parseInt(ora.substring(0,2));
	   int min = Integer.parseInt(ora.substring(3));
	   
	   GregorianCalendar dataInserita = new GregorianCalendar (anno, mese, giorno,hour,min);
	   GregorianCalendar dataOdierna = new GregorianCalendar (y, m, g,h,mi);
				
	
	   if(dataInserita.getTimeInMillis()<dataOdierna.getTimeInMillis())
		   	    return false;
		   else 
			   return true;
	
   }
   
   /**
    * Metodo di supporto che verifica la correttezza del formato della data.
    * @param data la data da controllare.
    * @param ora l'ora da controllare.
    * @return true nel caso sia corretta,false altrimenti.
    */
   protected boolean formatoData(String data,String ora){
	   try{
		   int giorno = Integer.parseInt(data.substring(0,2));
		   int mese = Integer.parseInt(data.substring(3,5));
		   int anno = Integer.parseInt(data.substring(6));
		   int hour = Integer.parseInt(ora.substring(0,2));
		   int min = Integer.parseInt(ora.substring(3));
		   if(giorno < 0 || mese < 0 || anno < 0 || hour < 0 || min < 0 || mese > 12 || hour > 24 || min > 59)
			   return false;
		   if(mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8
				   || mese == 10 || mese == 12){
			   if(giorno > 31)
				   return false;
				   
		   }
		   if(mese == 11 || mese == 4 || mese == 6 || mese == 9){
			   if(giorno > 30)
				   return false;
		   } 
		   if(mese == 2){
			   if(((anno%4 == 0) || (anno%400)==0)&& (anno%100 != 0))
			   		if(giorno>29)
			   			return false;
			   if(giorno > 28)
				   return false;
		   }
		   return true;
	   }catch(IndexOutOfBoundsException e){
		   return false;
	   }catch(IllegalArgumentException e){
		   return false;
	   }
   }

   /**
    * Azione eseguita alla pressione del bottone "Annulla".
    * @param evt il ricevitore d'evento.
    */
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {    
	   this.setVisible(false);
	   new FormCalendario().setVisible(true);
   }                                        

   /**
    * Frame contenente un messaggio di errore scelto.
    * @param mex il messaggio di errore.
    */
   protected void errore(String mex){
   	JOptionPane.showMessageDialog(null,mex);
	}
   
   /**
    * Frame contenente un messaggio di conferma dell'operazione.
    */
   protected void successo(){
   	JOptionPane.showMessageDialog(null,"Operazione effettuata!");
   }
   
   /**
    * The main method.
    *
    * @param args the arguments
    */
   public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new FormAggiungiAppuntamento().setVisible(true);
           }
       });
   }

   /** The j button1. */
   private javax.swing.JButton jButton1;
   
   /** The j button2. */
   private javax.swing.JButton jButton2;
   
   /** The j label1. */
   private javax.swing.JLabel jLabel1;
   
   /** The j label2. */
   private javax.swing.JLabel jLabel2;
   
   /** The j label3. */
   private javax.swing.JLabel jLabel3;
   
   /** The j label4. */
   private javax.swing.JLabel jLabel4;
   
   /** The j label5. */
   private javax.swing.JLabel jLabel5;
   
   /** The j label6. */
   private javax.swing.JLabel jLabel6;
   
   /** The j label7. */
   private javax.swing.JLabel jLabel7;
   
   /** The j panel1. */
   private javax.swing.JPanel jPanel1;
   
   /** The j text field1. */
   private javax.swing.JTextField jTextField1;
   
   /** The j text field2. */
   private javax.swing.JTextField jTextField2;
   
   /** The j text field3. */
   private javax.swing.JTextField jTextField3;
   
   /** The j text field4. */
   private javax.swing.JTextField jTextField4;
   
   /** The j text field5. */
   private javax.swing.JTextField jTextField5;
   
   /** The j text field6. */
   private javax.swing.JTextField jTextField6;
   
   /** The j text field7. */
   private javax.swing.JTextField jTextField7;

}
