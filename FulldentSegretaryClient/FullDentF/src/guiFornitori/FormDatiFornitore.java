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
* Interfaccia grafica per la visualizzazione dei dati relativi ad un fornitore.
* @author Vincenzo D'Alessio.
*/
public class FormDatiFornitore extends javax.swing.JFrame {

   /** 
    * Crea un nuovo Form.
    * @param x i dati del fornitore da visualizzare.
    */
   public FormDatiFornitore(DatiFornitore x) {
	   fornitore = x;
       initComponents();
   }

   /**
    * Metodo di supporto che inizializza le componenti del Frame.
    */
   private void initComponents() {

       jPanel1 = new javax.swing.JPanel();
       jLabel1 = new javax.swing.JLabel();
       jLabel2 = new javax.swing.JLabel();
       jLabel3 = new javax.swing.JLabel();
       jLabel4 = new javax.swing.JLabel();
       jLabel5 = new javax.swing.JLabel();
       jLabel6 = new javax.swing.JLabel();
       jLabel7 = new javax.swing.JLabel();
       jLabel8 = new javax.swing.JLabel();
       jLabel9 = new javax.swing.JLabel();
       jLabel10 = new javax.swing.JLabel();
       jLabel11 = new javax.swing.JLabel();
       jLabel12 = new javax.swing.JLabel();
       jButton1 = new javax.swing.JButton();
       jButton2 = new javax.swing.JButton();
       jButton3 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

       jLabel1.setText("P.IVA:");

       jLabel2.setText("Nome Responsabile:");

       jLabel3.setText("Cognome Responsabile:");

       jLabel4.setText("Sede:");

       jLabel5.setText("Recapito:");

       jLabel6.setText("e-mail:");

       jLabel7.setText(fornitore.getPIva());

       jLabel8.setText(fornitore.getNomeResponsabile());

       jLabel9.setText(fornitore.getCognomeResponsabile());

       jLabel10.setText(fornitore.getSede());

       jLabel11.setText(fornitore.getRecapito());

       jLabel12.setText(fornitore.getEmail());

       jButton1.setText("Modifica");
       jButton1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton1ActionPerformed(evt);
           }
       });

       jButton2.setText("Rimuovi");
       jButton2.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton2ActionPerformed(evt);
           }
       });

       jButton3.setText("OK");
       jButton3.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton3ActionPerformed(evt);
           }
       });

       org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
       jPanel1.setLayout(jPanel1Layout);
       jPanel1Layout.setHorizontalGroup(
           jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(jPanel1Layout.createSequentialGroup()
               .add(23, 23, 23)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                   .add(jLabel1)
                   .add(jLabel2)
                   .add(jLabel3)
                   .add(jLabel4)
                   .add(jLabel5)
                   .add(jLabel6)
                   .add(jButton1))
               .add(31, 31, 31)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                   .add(jLabel12)
                   .add(jLabel11)
                   .add(jLabel10)
                   .add(jLabel9)
                   .add(jLabel8)
                   .add(jLabel7)
                   .add(jPanel1Layout.createSequentialGroup()
                       .add(jButton2)
                       .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 45, Short.MAX_VALUE)
                       .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
               .addContainerGap())
       );
       jPanel1Layout.setVerticalGroup(
           jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(jPanel1Layout.createSequentialGroup()
               .add(29, 29, 29)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel1)
                   .add(jLabel7))
               .add(28, 28, 28)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel2)
                   .add(jLabel8))
               .add(34, 34, 34)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel3)
                   .add(jLabel9))
               .add(39, 39, 39)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel4)
                   .add(jLabel10))
               .add(37, 37, 37)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel5)
                   .add(jLabel11))
               .add(37, 37, 37)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel6)
                   .add(jLabel12))
               .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 34, Short.MAX_VALUE)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jButton1)
                   .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                   .add(jButton3))
               .add(27, 27, 27))
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
               .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addContainerGap())
       );

       pack();
       this.setTitle("FullDent - Informazioni Fornitore");
   }
   
   /**
    * Azione esguita alla pressione del bottone "Modifica".
    * @param evt il ricevitore d'evento.
    */
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	   FormModificaDatiFornitore x = new FormModificaDatiFornitore(fornitore);
	   x.setVisible(true);
	   this.setVisible(false);
   }

   /**
    * Azione esguita alla pressione del bottone "Rimuovi".
    * @param evt il ricevitore d'evento.
    */
   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
	   try{
		   DBFornitore x = new DBFornitore();
		   x.OpenConnection();
		   x.eliminaFornitore(fornitore.getPIva());
		   x.closeConnection();
		   successo();
		   this.setVisible(false);
		   new FormAmministratore().setVisible(true);
	   }catch(SQLException e){
		   errore("Errore di connessione con il DataBase!");
	   }catch (ClassNotFoundException e) {
		   errore("Classe non trovata!");
	   }catch(FileNotFoundException e) {
		   errore("File contenente i dati d'accesso al DataBase non trovato!");
	   }catch(IOException e) {
		   errore("Errore di comunicazione con il file!");
	   }
	   
   }

   /**
    * Azione esguita alla pressione del bottone "Ok".
    * @param evt il ricevitore d'evento.
    */
   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
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
   
   /** The j button3. */
   private javax.swing.JButton jButton3;
   
   /** The j label1. */
   private javax.swing.JLabel jLabel1;
   
   /** The j label10. */
   private javax.swing.JLabel jLabel10;
   
   /** The j label11. */
   private javax.swing.JLabel jLabel11;
   
   /** The j label12. */
   private javax.swing.JLabel jLabel12;
   
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
   
   /** The j label8. */
   private javax.swing.JLabel jLabel8;
   
   /** The j label9. */
   private javax.swing.JLabel jLabel9;
   
   /** The j panel1. */
   private javax.swing.JPanel jPanel1;

}
