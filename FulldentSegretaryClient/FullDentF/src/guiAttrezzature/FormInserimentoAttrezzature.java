package guiAttrezzature;

import gestioneAttrezzature.*;
import guiAmministratore.FormAmministratore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;

// TODO: Auto-generated Javadoc
/**
* Intrefaccia grafica per l'inserimento di una nuova attrezzatura.
* @author vincenzo d'alessio.
*/
public class FormInserimentoAttrezzature extends javax.swing.JFrame {

   /**
    *  
    * Crea un nuovo Form.
    *
    * @param cod the cod
    * @param tip the tip
    * @param piva the piva
    */
   public FormInserimentoAttrezzature(int cod,String tip,String piva) {
       codice = cod;
       tipo = tip;
       Piva = piva;
	   initComponents();
   }

   /**
    * Metodo di supporto che inizializza le componenti del Frame.
    */
   private void initComponents() {

       jLabel1 = new javax.swing.JLabel();
       jLabel2 = new javax.swing.JLabel();
       jLabel3 = new javax.swing.JLabel();
       jLabel4 = new javax.swing.JLabel();
       jLabel5 = new javax.swing.JLabel();
       jLabel6 = new javax.swing.JLabel();
       jLabel7 = new javax.swing.JLabel();
       jLabel8 = new javax.swing.JLabel();
       jTextField2 = new javax.swing.JTextField();
       jTextField3 = new javax.swing.JTextField();
       jTextField4 = new javax.swing.JTextField();
       jTextField6 = new javax.swing.JTextField();
       GroupLayout layout = new GroupLayout((JComponent)getContentPane());
       getContentPane().setLayout(layout);
       jTextField7 = new javax.swing.JTextField();
       jButton1 = new javax.swing.JButton();
       jButton2 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jLabel1.setText("Codice Tipo");

       jLabel2.setText("Nome");

       jLabel3.setText("Quantità");

       jLabel4.setText("Costo");
       {
    	   codF = new JLabel(Piva);
       }
       {
    	   tipo1 = new JLabel(tipo);
       }
       {
    	   codT = new JLabel(""+codice);
       }

       jLabel5.setText("Tipo");

       jLabel6.setText("Descrizione");

       jLabel7.setText("Locazione");

       jLabel8.setText("Codice Fornitore");


       jButton1.setText("Aggiungi");
       jButton1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton1ActionPerformed(evt);
           }
       });

       jButton2.setText("Annulla");
       layout.setVerticalGroup(layout.createSequentialGroup()
       	.addContainerGap(35, 35)
       	.addGroup(layout.createParallelGroup()
       	    .addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	        .addComponent(jLabel5, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addComponent(jLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addComponent(codT, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
       	    .addComponent(tipo1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
       	.addGap(31)
       	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jTextField6, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel6, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jTextField2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addGap(42)
       	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jTextField7, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel7, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jTextField3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addGap(0, 43, Short.MAX_VALUE)
       	.addGroup(layout.createParallelGroup()
       	    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	        .addComponent(jTextField4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addComponent(jLabel8, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addComponent(jLabel4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
       	        .addComponent(codF, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
       	        .addGap(6)))
       	.addGap(0, 16, GroupLayout.PREFERRED_SIZE)
       	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jButton1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addContainerGap());
       layout.setHorizontalGroup(layout.createSequentialGroup()
       	.addContainerGap()
       	.addGroup(layout.createParallelGroup()
       	    .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
       	        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(31))
       	    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
       	        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(18))
       	    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
       	        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(33)))
       	.addGroup(layout.createParallelGroup()
       	    .addGroup(layout.createSequentialGroup()
       	        .addGap(0, 0, Short.MAX_VALUE)
       	        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
       	    .addGroup(layout.createSequentialGroup()
       	        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
       	        .addGap(0, 0, Short.MAX_VALUE))
       	    .addGroup(layout.createSequentialGroup()
       	        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
       	        .addGap(0, 0, Short.MAX_VALUE))
       	    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
       	        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(0, 125, Short.MAX_VALUE))
       	    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
       	        .addGap(18)
       	        .addComponent(codT, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
       	        .addGap(0, 42, Short.MAX_VALUE)))
       	.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
       	.addGroup(layout.createParallelGroup()
       	    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
       	        .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(35))
       	    .addComponent(jLabel8, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
       	        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(28))
       	    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
       	        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(64)))
       	.addGroup(layout.createParallelGroup()
       	    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
       	        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(135))
       	    .addGroup(layout.createSequentialGroup()
       	        .addPreferredGap(jButton2, jTextField7, LayoutStyle.ComponentPlacement.INDENT)
       	        .addGroup(layout.createParallelGroup()
       	            .addComponent(jTextField7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
       	            .addComponent(jTextField6, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
       	            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
       	                .addComponent(codF, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
       	                .addGap(12))
       	            .addComponent(tipo1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))))
       	.addGap(7));
       jButton2.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton2ActionPerformed(evt);
           }
       });

       pack();
       this.setTitle("FullDent - Nuova Attrezzatura");
   }
   
   /**
    * Frame contenente un messaggio di errore scelto.
    * @param mex il messaggio di errore.
    */
   protected void errore(String mex){
   	JOptionPane.showMessageDialog(null,mex);
   }
  
   /**
    * Frame contenente un messaggio di operazione effettuata.
    */
   protected void successo(){
   	JOptionPane.showMessageDialog(null,"Operazione effettuata!");
   }

   /**
    * Azione eseguita alla pressione del bottone "Aggiungi".
    * @param evt il ricevitore d'evento.
    */
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	   try{
		   	int cod = Integer.parseInt(codT.getText());
		   	String nome = jTextField2.getText();
		   	int q = Integer.parseInt(jTextField3.getText());
		   	double c = Double.parseDouble(jTextField4.getText());
		   	String tip = tipo1.getText();
		   	String desc = jTextField6.getText();
		   	String loc = jTextField7.getText();
		   	String codfor = codF.getText();
		   	if(!(nome.equals("") || desc.equals("") || loc.equals(""))){
		   			DatiAttrezzature y = new DatiAttrezzature(cod,nome,q,c,tip,desc,loc,codfor);
		   			DBAttrezzature x = new DBAttrezzature();
		   			x.openConnection();
		   			x.inserisciAttrezzature(y);
		   			x.closeConnection();
		   			successo();
		   			this.setVisible(false);
		   			new FormAmministratore().setVisible(true);
		   	}else errore("Tutti i campi devono essere inseriti!"); 	
	   }catch(IllegalArgumentException e){
		   errore("Dati inseriti errati!");
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
    * Azione eseguita alla pressione del bottone "Annulla".
    * @param evt il ricevitore d'evento.
    */
   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
	   this.setVisible(false);
	   new FormAmministratore().setVisible(true);
   }

   /** The codice. */
   private int codice;
   
   /** The tipo. */
   private String tipo;
   
   /** The Piva. */
   private String Piva;
   
   /** The tipo1. */
   private javax.swing.JLabel tipo1;
   
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
   
   /** The cod t. */
   private JLabel codT;
   
   /** The cod f. */
   private JLabel codF;
   
   /** The j label6. */
   private javax.swing.JLabel jLabel6;
   
   /** The j label7. */
   private javax.swing.JLabel jLabel7;
   
   /** The j label8. */
   private javax.swing.JLabel jLabel8;
   
   /** The j text field2. */
   private javax.swing.JTextField jTextField2;
   
   /** The j text field3. */
   private javax.swing.JTextField jTextField3;
   
   /** The j text field4. */
   private javax.swing.JTextField jTextField4;
   
   /** The j text field6. */
   private javax.swing.JTextField jTextField6;
   
   /** The j text field7. */
   private javax.swing.JTextField jTextField7;

}
