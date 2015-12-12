package guiPersonale;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import gestionePersonale.DBPersonale;
import gestionePersonale.DatiPersonale;
import guiAmministratore.FormAmministratore;

// TODO: Auto-generated Javadoc
/**
* Interfaccia grafica per la visualizzazione dei dati relativi ad un dipendente.
* @author vincenzo d'alessio.
*/
public class FormDatiDipendente extends javax.swing.JFrame {

   /** 
    * Crea un nuovo Form.
    * @param x i dati del dipendente da visualizzare.
    */
   public FormDatiDipendente(DatiPersonale x) {
	   dipendente = x;
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
       jLabel5 = new javax.swing.JLabel();
       jLabel6 = new javax.swing.JLabel();
       jLabel7 = new javax.swing.JLabel();
       jLabel8 = new javax.swing.JLabel();
       jLabel9 = new javax.swing.JLabel();
       jLabel10 = new javax.swing.JLabel();
       jLabel11 = new javax.swing.JLabel();
       jLabel12 = new javax.swing.JLabel();
       jLabel13 = new javax.swing.JLabel();
       jLabel14 = new javax.swing.JLabel();
       jLabel16 = new javax.swing.JLabel();
       jLabel17 = new javax.swing.JLabel();
       jLabel18 = new javax.swing.JLabel();
       jLabel19 = new javax.swing.JLabel();
       jLabel20 = new javax.swing.JLabel();
       jLabel15 = new javax.swing.JLabel();
       jButton1 = new javax.swing.JButton();
       jButton2 = new javax.swing.JButton();
       jButton3 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

       jLabel1.setText("Codice Fiscale:");

       jLabel2.setText("Nome:");

       jLabel3.setText("Cognome:");

       jLabel4.setText("Residenza:");

       jLabel5.setText("Data di Nascita:");

       jLabel6.setText(dipendente.getCodfisc());

       jLabel7.setText(dipendente.getNome());

       jLabel8.setText(dipendente.getCognome());

       jLabel9.setText(dipendente.getResidenza());

       jLabel10.setText(dipendente.getDataNascita());

       jLabel11.setText("Luogo di Nascita:");

       jLabel12.setText("Num.Telefono:");

       jLabel13.setText("Tipo:");

       jLabel14.setText("Sesso:");

       jLabel16.setText(dipendente.getLuogoNascita());

       jLabel17.setText(""+dipendente.getTel());

       jLabel18.setText(dipendente.getTipo());

       jLabel19.setText(dipendente.getSesso());

       jLabel20.setText(dipendente.getCont().toString());

       jLabel15.setText("Contratto:");

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
               .add(44, 44, 44)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                   .add(jLabel1)
                   .add(jLabel2)
                   .add(jLabel3)
                   .add(jLabel5)
                   .add(jLabel4))
               .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                   .add(jPanel1Layout.createSequentialGroup()
                       .add(207, 207, 207)
                       .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                           .add(jLabel15)
                           .add(jLabel14))
                       .add(58, 58, 58)
                       .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                           .add(jLabel20)
                           .add(jLabel19)))
                   .add(jPanel1Layout.createSequentialGroup()
                       .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                           .add(jPanel1Layout.createSequentialGroup()
                               .add(15, 15, 15)
                               .add(jLabel6))
                           .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                               .add(jLabel8)
                               .add(jLabel7)
                               .add(jLabel9)
                               .add(jLabel10)))
                       .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 154, Short.MAX_VALUE)
                       .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                           .add(jLabel11)
                           .add(jLabel13)
                           .add(jLabel12))
                       .add(18, 18, 18)
                       .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                           .add(jLabel17)
                           .add(jLabel18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                           .add(jLabel16))
                       .add(9, 9, 9)))
               .add(148, 148, 148))
           .add(jPanel1Layout.createSequentialGroup()
               .add(70, 70, 70)
               .add(jButton1)
               .add(125, 125, 125)
               .add(jButton2)
               .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 131, Short.MAX_VALUE)
               .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 68, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(97, 97, 97))
       );
       jPanel1Layout.setVerticalGroup(
           jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(jPanel1Layout.createSequentialGroup()
               .add(39, 39, 39)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel1)
                   .add(jLabel11)
                   .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                   .add(jLabel16))
               .add(40, 40, 40)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel2)
                   .add(jLabel12)
                   .add(jLabel7)
                   .add(jLabel17))
               .add(40, 40, 40)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel3)
                   .add(jLabel13)
                   .add(jLabel8)
                   .add(jLabel18))
               .add(44, 44, 44)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel4)
                   .add(jLabel19)
                   .add(jLabel14)
                   .add(jLabel9))
               .add(31, 31, 31)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jLabel5)
                   .add(jLabel15)
                   .add(jLabel20)
                   .add(jLabel10))
               .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 51, Short.MAX_VALUE)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jButton1)
                   .add(jButton2)
                   .add(jButton3))
               .add(36, 36, 36))
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
               .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addContainerGap())
       );

       pack();
       this.setTitle("FullDent - Informazioni Dipendente");
   }

   /**
    * Azione eseguita alla pressione del bottone "Ok".
    * @param evt il ricevitore d'evento.
    */
   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
       this.setVisible(false);
	   new FormAmministratore().setVisible(true);
   }

   /**
    * Azione eseguita alla pressione del bottone "Rimuovi".
    * @param evt il ricevitore d'evento.
    */
   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
	   try{
		   DBPersonale x = new DBPersonale();
		   x.openConnection();
		   x.eliminaDipendente(dipendente.getCodfisc());
		   x.closeConnection();
		   successo();
		   this.setVisible(false);
		   new FormAmministratore().setVisible(true);
	   }catch(SQLException e){
   			errore("Errore di connessione con il DataBase!");
   		}catch(FileNotFoundException e){
   			errore("File non trovato!");
   		} catch (IOException e) {
			errore("Errore di comunicazione con il file!");
		} catch (ClassNotFoundException e) {
			errore("Classe non trovata!");
		}
   	
   }

   /**
    * Azione esguita alla pressione del bottone "Modifica".
    * @param evt il ricevitore d'evento.
    */
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	   FormModificaDatiPersonale x = new FormModificaDatiPersonale(dipendente);
	   x.setVisible(true);
	   this.setVisible(false);
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
   
   /** The dipendente. */
   private DatiPersonale dipendente;
   
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
   
   /** The j label13. */
   private javax.swing.JLabel jLabel13;
   
   /** The j label14. */
   private javax.swing.JLabel jLabel14;
   
   /** The j label15. */
   private javax.swing.JLabel jLabel15;
   
   /** The j label16. */
   private javax.swing.JLabel jLabel16;
   
   /** The j label17. */
   private javax.swing.JLabel jLabel17;
   
   /** The j label18. */
   private javax.swing.JLabel jLabel18;
   
   /** The j label19. */
   private javax.swing.JLabel jLabel19;
   
   /** The j label2. */
   private javax.swing.JLabel jLabel2;
   
   /** The j label20. */
   private javax.swing.JLabel jLabel20;
   
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

