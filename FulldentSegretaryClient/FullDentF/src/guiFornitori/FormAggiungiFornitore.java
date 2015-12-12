package guiFornitori;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import gestioneFornitori.DBFornitore;
import gestioneFornitori.DatiFornitore;
import guiAmministratore.FormAmministratore;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
* Interfaccia grafica per l'aggiunta di un nuovo fornitore.
* @author Filomena Fruncillo
*/
public class FormAggiungiFornitore extends javax.swing.JFrame {

   /** 
    * Crea un nuovo Form.
    */
   public FormAggiungiFornitore() {
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
       jButton1 = new javax.swing.JButton();
       jButton2 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

       jLabel1.setText("P.IVA");

       jLabel2.setText("Nome Responsabile");


       jLabel3.setText("Cognome");

       jLabel4.setText("Sede");

       jLabel5.setText("Recapito");

       jLabel6.setText("E-mail");

       jButton1.setText("Aggiungi");
       jButton1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton1ActionPerformed(evt);
           }
       });

       jButton2.setText("Annulla");
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
               .addContainerGap()
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                       .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                   .addComponent(jLabel3))
               .addGap(34, 34, 34)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addGroup(jPanel1Layout.createSequentialGroup()
                       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                           .addComponent(jTextField2)
                           .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                       .addGap(42, 42, 42)
                       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(jLabel4)
                           .addComponent(jLabel5)
                           .addComponent(jLabel6))
                       .addGap(31, 31, 31)
                       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(jTextField6)
                           .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING)
                           .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                       .addContainerGap())
                   .addGroup(jPanel1Layout.createSequentialGroup()
                       .addComponent(jButton1)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addComponent(jButton2)
                       .addGap(83, 83, 83))))
       );
       jPanel1Layout.setVerticalGroup(
           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(jPanel1Layout.createSequentialGroup()
               .addGap(23, 23, 23)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel1)
                   .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel4)
                   .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(30, 30, 30)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel2)
                   .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel5)
                   .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(33, 33, 33)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                       .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(jLabel6)
                       .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addComponent(jLabel3))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jButton1)
                   .addComponent(jButton2))
               .addGap(38, 38, 38))
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
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
       );

       pack();
       this.setTitle("FullDent - Nuovo Fornitore");
   }


   /**
    * Azione esguita alla pressione del bottone "Aggiungi".
    * @param evt il ricevitore d'evento.
    */
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	   try{
		   String piva = jTextField1.getText();
		   String nomres = jTextField2.getText();
		   String cogn = jTextField3.getText();
		   String sed = jTextField4.getText();
		   String recap = jTextField5.getText();
		   String email = jTextField6.getText();
		   if(!(piva.equals("") || nomres.equals("") || cogn.equals("") ||
				   sed.equals("") || recap.equals("") || email.equals(""))){
			   if(piva.length() == 16){
				   DatiFornitore fornitore = new DatiFornitore(piva,nomres,cogn,sed,recap,email);
				   DBFornitore x = new DBFornitore();
				   x.OpenConnection();
				   x.InserisciFornitore(fornitore);
				   x.closeConnection();
				   successo();
				   this.setVisible(false);
				   new FormAmministratore().setVisible(true);
			   }else errore("Partita Iva non valida!");
		   }else errore("Tutti i campi devono essere inseriti!");
	   }catch(SQLException v){
			errore("Errore con il DataBase!");
		}catch(ClassNotFoundException m){
			errore("Classe non trovata!");
		}catch(FileNotFoundException n){
			errore("File non trovato!");
		}catch(IOException i){
			errore("Errore di apertura con il file!");
		}
	   
   }

   /**
    * Azione esguita alla pressione del bottone "Annulla".
    * @param evt il ricevitore d'evento.
    */
   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
       this.setVisible(false);
	   new FormAmministratore().setVisible(true);
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
               new FormAggiungiFornitore().setVisible(true);
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

}
