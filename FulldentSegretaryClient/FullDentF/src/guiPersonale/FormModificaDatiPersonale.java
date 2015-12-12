package guiPersonale;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import gestionePersonale.Contratto;
import gestionePersonale.DBPersonale;
import gestionePersonale.DatiPersonale;

// TODO: Auto-generated Javadoc
/**
* Interfaccia grafica per la modifica dei dati di un dipendente.
* @author vincenzo
*/
public class FormModificaDatiPersonale extends javax.swing.JFrame {

   /** 
    * Crea un nuovo Form.
    * @param x i dati del dipendente da modificare.
    */
   public FormModificaDatiPersonale(DatiPersonale x) {
	   dipendente = x;
       initComponents();
   }

   /**
    * Metodo di supporto per l'inizializzazione delle componenti del Frame.
    */
   private void initComponents() {

       jPanel1 = new javax.swing.JPanel();
       GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
       jPanel1.setLayout(jPanel1Layout);
       jLabel1 = new javax.swing.JLabel();
       jLabel2 = new javax.swing.JLabel();
       jLabel3 = new javax.swing.JLabel();
       jTextField1 = new javax.swing.JTextField();
       jTextField2 = new javax.swing.JTextField();

       GroupLayout layout = new GroupLayout((JComponent)getContentPane());
       getContentPane().setLayout(layout);
       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
       layout.setHorizontalGroup(layout.createSequentialGroup()
       	.addContainerGap()
       	.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
       	.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
       layout.setVerticalGroup(layout.createSequentialGroup()
       	.addContainerGap()
       	.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
       	.addContainerGap(55, 55));

       jLabel1.setText("Residenza:");

       jLabel2.setText("Numero di Telefono:");

       jLabel3.setText("CONTRATTO");
       {
    	   jButton1 = new javax.swing.JButton();
    	   jButton1.setText("OK");
    	   jButton1.addActionListener(new java.awt.event.ActionListener() {
    		   public void actionPerformed(java.awt.event.ActionEvent evt) {
    			   jButton1ActionPerformed(evt);
    		   }
    	   });
       }
       {
    	   jButton2 = new javax.swing.JButton();
    	   jButton2.setText("Annulla");
    	   jButton2.addActionListener(new java.awt.event.ActionListener() {
    		   public void actionPerformed(java.awt.event.ActionEvent evt) {
    			   jButton2ActionPerformed(evt);
    		   }
    	   });
       }
       {
    	   jLabelDataContratto = new JLabel();
    	   jLabelDataContratto.setText("Data stipulazione:");
       }
       {
    	   jTextFieldDataStipulazioneContratto = new JTextField();
       }
       {
    	   tipoContartto = new JLabel();
    	   tipoContartto.setText("Tipo:");
       }
       {
    	   jTextFieldTipoContratto = new JTextField();
       }
       {
    	   jLabelRetribuzioneContratto = new JLabel();
    	   jLabelRetribuzioneContratto.setText("Retribuzione:");
       }
       {
    	   jTextFieldRetribuzione = new JTextField();
       }
       jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
       	.addContainerGap()
       	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jTextField1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addGap(21)
       	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jTextField2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
       	.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
       	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jTextFieldRetribuzione, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jTextFieldTipoContratto, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(tipoContartto, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabelRetribuzioneContratto, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addGap(20)
       	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jTextFieldDataStipulazioneContratto, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabelDataContratto, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addGap(38)
       	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jButton1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addContainerGap(23, 23));
       jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
       	.addContainerGap(30, 30)
       	.addGroup(jPanel1Layout.createParallelGroup()
       	    .addGroup(jPanel1Layout.createSequentialGroup()
       	        .addGroup(jPanel1Layout.createParallelGroup()
       	            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                .addComponent(tipoContartto, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
       	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
       	                .addComponent(jTextFieldTipoContratto, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
       	            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                .addComponent(jLabelDataContratto, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
       	                .addGap(14))
       	            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	                .addGap(14)))
       	        .addGroup(jPanel1Layout.createParallelGroup()
       	            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
       	                .addGap(0, 26, Short.MAX_VALUE))
       	            .addGroup(jPanel1Layout.createSequentialGroup()
       	                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
       	                .addGap(0, 0, Short.MAX_VALUE))
       	            .addGroup(jPanel1Layout.createSequentialGroup()
       	                .addGroup(jPanel1Layout.createParallelGroup()
       	                    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                        .addGap(18)
       	                        .addComponent(jLabelRetribuzioneContratto, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
       	                    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                        .addComponent(jTextFieldDataStipulazioneContratto, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
       	                        .addGap(34)))
       	                .addGap(8)
       	                .addGroup(jPanel1Layout.createParallelGroup()
       	                    .addGroup(jPanel1Layout.createSequentialGroup()
       	                        .addComponent(jTextFieldRetribuzione, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
       	                    .addGroup(jPanel1Layout.createSequentialGroup()
       	                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
       	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE))))
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addGroup(jPanel1Layout.createParallelGroup()
       	            .addComponent(jButton1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
       	            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	                .addGap(14)))
       	        .addGap(25)
       	        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
       	        .addGap(0, 144, Short.MAX_VALUE)))
       	.addContainerGap(39, 39));

       pack();
       
       this.setTitle("FullDent - Modifica Dati Dipendente");
   }

   /**
    * Azione eseguita alla pressione del bottone "Ok".
    * @param evt il ricevitore d'evento.
    */
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	   try{
		   
		   String res = jTextField1.getText();
		   int tel = Integer.parseInt(jTextField2.getText());
		   String datac = jTextFieldDataStipulazioneContratto.getText();
		   String tipoc = jTextFieldTipoContratto.getText();
		   double saldo = Double.parseDouble(jTextFieldRetribuzione.getText());
		   if(jTextField2.getText().length()<11){
			   if(formatoData(datac)){
				   Contratto k = new Contratto(saldo,tipoc,datac);
				   dipendente.setCont(k);
				   dipendente.setResidenza(res);
				   dipendente.setTel(tel);
				   DBPersonale x = new DBPersonale();
				   x.openConnection();
				   x.modificaDipendente(dipendente);
				   x.closeConnection();
				   successo();
				   this.setVisible(false);
				   new FormDatiDipendente(dipendente).setVisible(true);
			   }else errore("Data inserita non corretta! (GG/MM/AAAA)");
		   }else errore("Il numero di telefono non può superare le 10 cifre!");
	   }catch(SQLException e){
		   errore("Errore di connessione con il DataBase!");
	   } catch (ClassNotFoundException e) {
		errore("Classe non trovata!");
	} catch (FileNotFoundException e) {
		errore("File non trovato!");
	} catch (IOException e) {
		errore("Errore di comunicazione con il file!");
	} catch (IllegalArgumentException e){
		errore("Valori inseriti non validi!");
	}
   }

   /**
    * Azione eseguita alla pressione del bottone "Annulla".
    * @param evt il ricevitore d'evento.
    */
   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
       this.setVisible(false);
	   new FormDatiDipendente(dipendente).setVisible(true);
   }
   
   /**
    * Metodo di supporto che verifica la correttezza del formato della data.
    * @param data la data da controllare.
    * @return true nel caso sia corretta,false altrimenti.
    */
   protected boolean formatoData(String data){
	   try{
		   int giorno = Integer.parseInt(data.substring(0,2));
		   int mese = Integer.parseInt(data.substring(3,5));
		   int anno = Integer.parseInt(data.substring(6));
		   if(giorno < 0 || mese < 0 || anno < 0)
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
   
   /** The dipendente. */
   private DatiPersonale dipendente;
   
   /** The j button1. */
   private javax.swing.JButton jButton1;
   
   /** The j text field retribuzione. */
   private JTextField jTextFieldRetribuzione;
   
   /** The j label retribuzione contratto. */
   private JLabel jLabelRetribuzioneContratto;
   
   /** The j text field tipo contratto. */
   private JTextField jTextFieldTipoContratto;
   
   /** The tipo contartto. */
   private JLabel tipoContartto;
   
   /** The j button2. */
   private javax.swing.JButton jButton2;
   
   /** The j label1. */
   private javax.swing.JLabel jLabel1;
   
   /** The j label2. */
   private javax.swing.JLabel jLabel2;
   
   /** The j label3. */
   private javax.swing.JLabel jLabel3;
   
   /** The j label data contratto. */
   private JLabel jLabelDataContratto;
   
   /** The j text field data stipulazione contratto. */
   private JTextField jTextFieldDataStipulazioneContratto;
   
   /** The j panel1. */
   private javax.swing.JPanel jPanel1;
   
   /** The j text field1. */
   private javax.swing.JTextField jTextField1;
   
   /** The j text field2. */
   private javax.swing.JTextField jTextField2;

}
