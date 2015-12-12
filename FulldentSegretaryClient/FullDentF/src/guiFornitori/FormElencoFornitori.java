package guiFornitori;

import gestioneFornitori.DBFornitore;
import gestioneFornitori.DatiFornitore;
import guiAmministratore.FormAmministratore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;

// TODO: Auto-generated Javadoc
/**
* Interfaccia grafica per la visualizzazione di un elenco di fornitori.
* @author Gius
*/
public class FormElencoFornitori extends javax.swing.JFrame {

   /** 
    * Crea un nuovo Form.
    */
   public FormElencoFornitori() {
	   try{
		   DBFornitore x = new DBFornitore();
		   x.OpenConnection();
		   elenco = x.getElenco();
		   x.closeConnection();
	   }catch(SQLException e){
		   errore("Errore di comunicazione con il DataBase!");
	   }catch (ClassNotFoundException e) {
		   errore("Classe non trovata!");
	   }catch(FileNotFoundException e) {
		   errore("File contenente i dati d'accesso al DataBase non trovato!");
	   }catch(IOException e) {
		   errore("Errore di comunicazione con il file!");
	   }
       initComponents();
   }

   /**
    * Metodo di supporto che inizializza le componenti del Frame.                         
    */
   private void initComponents() {

       jPanel1 = new javax.swing.JPanel();
       jLabel1 = new javax.swing.JLabel();
       jTextField1 = new javax.swing.JTextField();
       jButton1 = new javax.swing.JButton();
       jButton3 = new javax.swing.JButton();
       jScrollPane2 = new javax.swing.JScrollPane();
       {
    	   piva = new JLabel();
    	   piva.setText("PIVA:");
    	   piva.setForeground(new java.awt.Color(0,51,254));
       }
       jScrollPane1 = new javax.swing.JScrollPane();
       jTable1 = new javax.swing.JTable();
       jButton2 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

       jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
       jLabel1.setForeground(new java.awt.Color(0, 51, 255));
       jLabel1.setText("Elenco Fornitori");


       jButton1.setText("Cerca");
       jButton1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton1ActionPerformed(evt);
           }
       });
       

       jButton3.setText("Aggiungi");
       jButton3.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton3ActionPerformed(evt);
           }
       });

       jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
       jTable1.setModel(new javax.swing.table.DefaultTableModel(
           
           new String [] {
               "PartitaIva", "NomeResponsabile", "CognomeResponsabile", "Sede", "Recapito", "E-Mail"
           },elenco.size()
       ));
       jScrollPane1.setViewportView(jTable1);

       jScrollPane2.setViewportView(jScrollPane1);

       jButton2.setText("Annulla");
       jButton2.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton2ActionPerformed(evt);
           }
       });

       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
       jPanel1.setLayout(jPanel1Layout);
       jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
       	.addContainerGap()
       	.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
       	.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
       	.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
       	.addComponent(piva, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
       	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jTextField1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jButton1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jButton3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addContainerGap(16, 16));
       jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
       	.addContainerGap()
       	.addGroup(jPanel1Layout.createParallelGroup()
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addGroup(jPanel1Layout.createParallelGroup()
       	            .addComponent(jTextField1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
       	            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	                .addGap(116))
       	            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                .addComponent(piva, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
       	                .addGap(165)))
       	        .addGap(28)
       	        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
       	        .addGap(40)
       	        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(0, 261, Short.MAX_VALUE)
       	        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(17))
       	    .addGroup(jPanel1Layout.createSequentialGroup()
       	        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 736, GroupLayout.PREFERRED_SIZE)
       	        .addGap(0, 0, Short.MAX_VALUE)))
       	.addContainerGap(30, 30));

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(18, 18, 18)
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(20, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(20, 20, 20)
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(19, Short.MAX_VALUE))
       );
       
       for(int i = 0; i<elenco.size();i++){
    	   DatiFornitore x = elenco.get(i);
    	   jTable1.setValueAt(x.getPIva(), i, 0);
    	   jTable1.setValueAt(x.getNomeResponsabile(), i, 1);
    	   jTable1.setValueAt(x.getCognomeResponsabile(), i, 2);
    	   jTable1.setValueAt(x.getSede(), i, 3);
    	   jTable1.setValueAt(x.getRecapito(), i, 4);
    	   jTable1.setValueAt(x.getEmail(), i, 5);
       }
       
       pack();
       this.setTitle("FullDent - Fornitori");
   }                   

   /**
    * Azione esguita alla pressione del bottone "Cerca".
    * @param evt il ricevitore d'evento.
    */
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
   	  try{
		  String piva = jTextField1.getText();
		  if(piva.length() == 16){
			  DBFornitore x = new DBFornitore();
			  x.OpenConnection();
			  DatiFornitore y = x.getFornitore(piva);
			  x.closeConnection();
			  if(y != null){
				  FormDatiFornitore z = new FormDatiFornitore(y);
				  z.setVisible(true);
				  this.setVisible(false);
			  }else errore("Fornitore non presente!");
		  }else errore("Partita Iva inserita non valida!");
	  }catch(SQLException e){
			errore("Errore di connessione con il DataBase!");
		}catch(FileNotFoundException e){
			errore("File non trovato!");
		}catch(IOException e) {
			errore("Errore di comunicazione con il file!");
		}catch(ClassNotFoundException e) {
			errore("Classe non trovata!");
		}
   }                                        


   /**
    * Azione seguita alla pressione del bottone "Aggiungi".
    * @param evt il ricevitore d'evento.
    */
   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) { 
       FormAggiungiFornitore x = new FormAggiungiFornitore();
       x.setVisible(true);
       this.setVisible(false);
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
    * The main method.
    *
    * @param args the arguments
    */
   public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new FormElencoFornitori().setVisible(true);
           }
       });
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

   /** The elenco. */
   private ArrayList<DatiFornitore> elenco;
   
   /** The j button1. */
   private javax.swing.JButton jButton1;
   
   /** The j button2. */
   private javax.swing.JButton jButton2;
   
   /** The j button3. */
   private javax.swing.JButton jButton3;
   
   /** The j label1. */
   private javax.swing.JLabel jLabel1;
   
   /** The j panel1. */
   private javax.swing.JPanel jPanel1;
   
   /** The j scroll pane1. */
   private javax.swing.JScrollPane jScrollPane1;
   
   /** The j scroll pane2. */
   private javax.swing.JScrollPane jScrollPane2;
   
   /** The piva. */
   private JLabel piva;
   
   /** The j table1. */
   private javax.swing.JTable jTable1;
   
   /** The j text field1. */
   private javax.swing.JTextField jTextField1;
   
}

