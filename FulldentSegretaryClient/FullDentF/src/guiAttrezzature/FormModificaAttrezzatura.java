package guiAttrezzature;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import gestioneAttrezzature.DBAttrezzature;
import gestioneAttrezzature.DatiAttrezzature;
import guiAmministratore.FormAmministratore;

// TODO: Auto-generated Javadoc
/**
* Form che permette lo scambio di informazioni tra utente e sistema per la 
* modifica di un'attrezzatura nel DataBase.
* @author Vincenzo D'Alessio.
*/
public class FormModificaAttrezzatura extends javax.swing.JFrame {

   /**
    * Crea un nuovo Form.
    * @param cod il codice dell'attrezzatura.
    */
   public FormModificaAttrezzatura(int cod) {
	   codSala = cod;
       initComponents();
   }

   /** 
    * Metodo di supporto che inizializza le componenti del frame.
    */
   private void initComponents() {

       jPanel1 = new javax.swing.JPanel();
       jLabel1 = new javax.swing.JLabel();
       jTextField1 = new javax.swing.JTextField();
       jLabel2 = new javax.swing.JLabel();
       jScrollPane1 = new javax.swing.JScrollPane();
       jTextArea1 = new javax.swing.JTextArea();
       jButton1 = new javax.swing.JButton();
       jButton2 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

       jLabel1.setText("Locazione:");

       jLabel2.setText("Descrizione:");

       jTextArea1.setColumns(20);
       jTextArea1.setRows(5);
       jScrollPane1.setViewportView(jTextArea1);

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
               .add(45, 45, 45)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                   .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 68, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                   .add(jPanel1Layout.createSequentialGroup()
                       .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                           .add(jLabel1)
                           .add(jLabel2))
                       .add(42, 42, 42)
                       .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                           .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 164, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                           .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                               .add(jButton2)
                               .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
               .addContainerGap(48, Short.MAX_VALUE))
       );
       jPanel1Layout.setVerticalGroup(
           jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(jPanel1Layout.createSequentialGroup()
               .add(64, 64, 64)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel1)
                   .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
               .add(51, 51, 51)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                   .add(jLabel2)
                   .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 30, Short.MAX_VALUE)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jButton1)
                   .add(jButton2))
               .add(31, 31, 31))
       );

       org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(layout.createSequentialGroup()
               .addContainerGap()
               .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(layout.createSequentialGroup()
               .addContainerGap()
               .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
       );

       setText();
       
       pack();
       this.setTitle("FullDent - Modifica Attrezzatura");
   }

   /**
    * Azione eseguita alla pressione del bottone "Ok".
    * @param evt l'evento che indica la pressione del bottone.
    */
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	   try{
		   String locazione = jTextField1.getText();
		   String descrizione = jTextArea1.getText();
		   if(!locazione.equals("")){
			   if(descrizione.length()<=45){
				   DBAttrezzature x = new DBAttrezzature();
				   x.openConnection();
				   x.modificaAttrezzatura(codSala,locazione,descrizione );
				   x.closeConnection();
				   successo();
				   this.setVisible(false);
				   new FormAmministratore().setVisible(true);
			   }else errore("La descrizione non può superare i 45 caratteri!");
		   }else errore("Inserire la locazione!");
	   }catch (SQLException e){
		   	 errore("Errore con il DataBase!");
	   } catch (FileNotFoundException e) {
		     errore("File di accesso al DataBase non trovato!");
	   } catch (IOException e) {
			 errore("Errore di comunicazione con il file!");
	   } catch (ClassNotFoundException e) {
			 errore("");
	   }
	
   }

   /**
    * Azione eseguita alla pressione del bottone "Annulla".
    * @param evt l'evento che indica la pressione del bottone.
    */
   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
	   this.setVisible(false);
	   new FormAmministratore().setVisible(true);
   }
   
   /**
    * Metodo di supporto che setta il testo dei campi della locazione e della descrizione.
    */
   protected void setText(){
	   try{
		   DBAttrezzature x = new DBAttrezzature();
		   x.openConnection();
		   DatiAttrezzature y = x.getAttrezzatura(codSala);
		   x.closeConnection();
		   jTextArea1.setText(y.getDescrizione());
		   jTextField1.setText(y.getLocazione());
	   }catch (SQLException e){
		   	 errore("Errore con il DataBase!");
	   } catch (FileNotFoundException e) {
		     errore("File di accesso al DataBase non trovato!");
	   } catch (IOException e) {
			 errore("Errore di comunicazione con il file!");
	   } catch (ClassNotFoundException e) {
			 errore("Classe non trovata!");
	   }
	
   }

   /**
    * Frame contenente un messaggio di errore scelto.
    * @param mex il messaggio di errore.
    */
   protected void errore(String mex){
   	JOptionPane.showMessageDialog(null,mex);
	}
   
   /**
    * Frame contenente un messaggio di avvenuta operazione.
    */
   protected void successo(){
   	JOptionPane.showMessageDialog(null,"Operazione effettuata!");
   }
  
   /** The cod sala. */
   private int codSala;
   
   /** The j button1. */
   private javax.swing.JButton jButton1;
   
   /** The j button2. */
   private javax.swing.JButton jButton2;
   
   /** The j label1. */
   private javax.swing.JLabel jLabel1;
   
   /** The j label2. */
   private javax.swing.JLabel jLabel2;
   
   /** The j panel1. */
   private javax.swing.JPanel jPanel1;
   
   /** The j scroll pane1. */
   private javax.swing.JScrollPane jScrollPane1;
   
   /** The j text area1. */
   private javax.swing.JTextArea jTextArea1;
   
   /** The j text field1. */
   private javax.swing.JTextField jTextField1;
 
}

