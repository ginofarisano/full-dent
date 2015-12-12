package guiAttrezzature;

import gestioneFornitori.DBFornitore;
import gestioneFornitori.DatiFornitore;
import guiAmministratore.FormAmministratore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;

// TODO: Auto-generated Javadoc
/**
* Interfaccia grafica per la visualizzazione di un elenco di fornitori, utile all'acquisto di una 
* nuova attrezzatura.
* @author 
*/
public class FormElencoFornitori2 extends javax.swing.JFrame {

   /** 
    * Crea un nuovo Form.
    * @param cod il codice dell'attrezzatura.
    * @param tip il tipo dell'attrezzatura.
    */
   public FormElencoFornitori2(int cod,String tip) {
	   try{
		   codice = cod;
		   tipo = tip;
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
       GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
       jPanel1.setLayout(jPanel1Layout);
       jLabel1 = new javax.swing.JLabel();
       jButton3 = new javax.swing.JButton();
       jScrollPane2 = new javax.swing.JScrollPane();
       {
    	   jButtonT = new JButton();
    	   jButtonT.setText("OK");
    	   jButtonT.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   jButtonTActionPerformed(evt);
               }
           });
    	   
       }
       jScrollPane1 = new javax.swing.JScrollPane();
       jTable1 = new javax.swing.JTable();
       jButton2 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

       jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
       jLabel1.setForeground(new java.awt.Color(0, 51, 255));
       jLabel1.setText("Elenco Fornitori");

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
       jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
       	.addContainerGap()
       	.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
       	.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
       	.addGap(18)
       	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jButton3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jButtonT, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addContainerGap(27, 27));
       jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
       	.addContainerGap()
       	.addGroup(jPanel1Layout.createParallelGroup()
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addGroup(jPanel1Layout.createParallelGroup()
       	            .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                .addPreferredGap(jLabel1, jButton3, LayoutStyle.ComponentPlacement.INDENT)
       	                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	                .addGap(11)))
       	        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
       	        .addComponent(jButtonT, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
       	        .addGap(0, 529, Short.MAX_VALUE)
       	        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(11))
       	    .addGroup(jPanel1Layout.createSequentialGroup()
       	        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 736, GroupLayout.PREFERRED_SIZE)
       	        .addGap(0, 0, Short.MAX_VALUE)))
       	.addContainerGap(44, 44));
       jButton2.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton2ActionPerformed(evt);
           }
       });

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
       this.setTitle("Fulldent - Fornitori");
   }                   

   /**
    * Azione esguita alla pressione del bottone "aggiungi".
    * @param evt il ricevitore d'evento.
    */
   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) { 
       FormAggiungiFornitore2 x = new FormAggiungiFornitore2();
       x.setVisible(true);
       this.setVisible(false);
   }                                        

   /**
    * Azione eseguita alla pressione del bottone "annulla".
    * @param evt il ricevitore d'evento.
    */
   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {  
	   this.setVisible(false);
	   new FormAmministratore().setVisible(true);
   }   
 
   /**
    * Azione eseguita alla pressione del bottone "Ok".
    * @param evt il ricevitore d'evento.
    */
   private void jButtonTActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	try{ 
    		String piva = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
    		FormInserimentoAttrezzature x = new FormInserimentoAttrezzature(codice,tipo,piva);
    		this.setVisible(false);
    		x.setVisible(true);
    	}catch(ArrayIndexOutOfBoundsException e){
    		errore("Seleziona una riga!");
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
    * Frame contenente un messaggio di conferma dell'operazione.
    */
   protected void successo(){
   	JOptionPane.showMessageDialog(null,"Operazione effettuata!");
   }

   /** The codice. */
   private int codice;
   
   /** The tipo. */
   private String tipo;
   
   /** The elenco. */
   private ArrayList<DatiFornitore> elenco;
   
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
   
   /** The j button t. */
   private JButton jButtonT;
   
   /** The j table1. */
   private javax.swing.JTable jTable1;

}
