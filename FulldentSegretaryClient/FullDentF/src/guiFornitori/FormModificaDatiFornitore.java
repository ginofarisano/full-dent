package guiFornitori;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import gestioneFornitori.DBFornitore;
import gestioneFornitori.DatiFornitore;
import guiAmministratore.FormAmministratore;

// TODO: Auto-generated Javadoc
/**
* Interfaccia grafica per la modifica dei dati di un fornitore.
* @author Vincenzo D'Alessio.
*/
public class FormModificaDatiFornitore extends javax.swing.JFrame {

   /** 
    * Crea un nuovo Form.
    * @param x i dati del fornitore da modificare.
    */
   public FormModificaDatiFornitore(DatiFornitore x) {
	   fornitore = x;
       initComponents();
   }

   /**
    * Metodo di supporto per l'inizializzazione delle componenti del Frame.
    */
   private void initComponents() {

       jPanel1 = new javax.swing.JPanel();
       jLabel1 = new javax.swing.JLabel();
       jLabel2 = new javax.swing.JLabel();
       jLabel3 = new javax.swing.JLabel();
       jLabel4 = new javax.swing.JLabel();
       jTextField1 = new javax.swing.JTextField();
       jTextField2 = new javax.swing.JTextField();
       jTextField3 = new javax.swing.JTextField();
       jTextField4 = new javax.swing.JTextField();
       jButton1 = new javax.swing.JButton();
       jButton2 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

       jLabel1.setText("Nome:");

       jLabel2.setText("Cognome:");

       jLabel3.setText("Recapito:");

       jLabel4.setText("e-mail:");

       jButton1.setText("OK");
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

       org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
       jPanel1.setLayout(jPanel1Layout);
       jPanel1Layout.setHorizontalGroup(
           jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(jPanel1Layout.createSequentialGroup()
               .addContainerGap()
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                   .add(jLabel2)
                   .add(jLabel3)
                   .add(jLabel4)
                   .add(jLabel1))
               .add(46, 46, 46)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                   .add(jTextField2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                   .add(jTextField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                   .add(org.jdesktop.layout.GroupLayout.LEADING, jTextField4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                   .add(org.jdesktop.layout.GroupLayout.LEADING, jTextField3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
               .addContainerGap())
           .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
               .add(37, 37, 37)
               .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 114, Short.MAX_VALUE)
               .add(jButton2)
               .add(42, 42, 42))
       );
       jPanel1Layout.setVerticalGroup(
           jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(jPanel1Layout.createSequentialGroup()
               .add(21, 21, 21)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                   .add(jLabel1))
               .add(33, 33, 33)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel2)
                   .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
               .add(35, 35, 35)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel3)
                   .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
               .add(45, 45, 45)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel4)
                   .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 42, Short.MAX_VALUE)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jButton1)
                   .add(jButton2))
               .add(37, 37, 37))
       );

       org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(layout.createSequentialGroup()
               .addContainerGap()
               .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addContainerGap())
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(layout.createSequentialGroup()
               .addContainerGap()
               .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(14, Short.MAX_VALUE))
       );
       
       jTextField1.setText(fornitore.getNomeResponsabile());
       jTextField2.setText(fornitore.getCognomeResponsabile());
       jTextField3.setText(fornitore.getRecapito());
       jTextField4.setText(fornitore.getEmail());

       pack();
       this.setTitle("FullDent - Modifica Fornitore");
   }

   /**
    * Azione eseguita alla pressione del bottone "Ok".
    * @param evt il ricevitore d'evento.
    */
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	   try{
		   String nome = jTextField1.getText();
		   String cognome = jTextField2.getText();
		   String recapito = jTextField3.getText();
		   String email = jTextField4.getText();
		   if(!(nome.equals("") || cognome.equals("") || recapito.equals("")
				   || email.equals(""))){
			   fornitore.setNomeResponsabile(nome);
			   fornitore.setCognomeResponsabile(cognome);
			   fornitore.setRecapito(recapito);
			   fornitore.setEmail(email);
			   DBFornitore x = new DBFornitore();
			   x.OpenConnection();
			   x.modificaFornitore(fornitore);
			   x.closeConnection();
			   successo();
			   this.setVisible(false);
			   new FormAmministratore().setVisible(true);
		   }else errore("Tutti i campi devono essere inseriti!");
	   }catch(SQLException e){
		   errore("Errore di comunicazione con il DataBase!");
	   }catch (ClassNotFoundException e) {
		   errore("Classe non trovata!");
	   }catch(FileNotFoundException e) {
		   errore("File contenente i dati d'accesso al DataBase non trovato!");
	   }catch(IOException e) {
		   errore("Errore di comunicazione con il file!");
	   }
   }

   /**
    * Azione eseguita alla pressione del bottone "Annulla".
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
   
   /** The fornitore. */
   private DatiFornitore fornitore;
   
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

}


