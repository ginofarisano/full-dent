package guiPersonale;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import exception.DuplicateException;

import gestionePersonale.Contratto;
import gestionePersonale.DBPersonale;
import gestionePersonale.DatiPersonale;
import guiAmministratore.FormAmministratore;

// TODO: Auto-generated Javadoc
/**
* Form che permette lo scambio di informazioni tra utente e sistema per l'aggiunta
* di un dipendente nel DataBase.
* @author Filomena Fruncillo
*/
public class FormAggiungiPersonale extends javax.swing.JFrame {

   /** 
    * Crea un nuovo Form.
    */
   public FormAggiungiPersonale() {
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
       jLabel8 = new javax.swing.JLabel();
       jTextField8 = new javax.swing.JTextField();
       jLabel9 = new javax.swing.JLabel();
       jTextField9 = new javax.swing.JTextField();
       jLabel10 = new javax.swing.JLabel();
       jTextField10 = new javax.swing.JTextField();
       jButton1 = new javax.swing.JButton();
       jButton2 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

       jLabel1.setText("Codice Fiscale");

       jLabel2.setText("Nome");


       jLabel3.setText("Cognome");


       jLabel4.setText("Residenza");
       {
    	   jLabel1TipoContratto = new JLabel();
    	   jLabel1TipoContratto.setText("Tipo Contratto:");
       }
       {
    	   jLabel1Retribuzione = new JLabel();
    	   jLabel1Retribuzione.setText("Retribuzione");
       }
       {
    	   jTextField1Retribuzione = new JTextField();
       }
       {
    	   jLabel11 = new JLabel();
    	   jLabel11.setText("Data stipulazione:");
       }
       {
    	   jTextField1DataContratto = new JTextField();
       }

       jLabel5.setText("Data di Nascita");

       jLabel6.setText("Luogo di Nascita");

       jLabel7.setText("Numero di telefono");

       jLabel8.setText("Tipo");

       jLabel9.setText("Sesso");

       jLabel10.setText("CONTRATTO");

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
       jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
       	.addContainerGap(19, 19)
       	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jTextField6, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel6, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jTextField1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addGap(25)
       	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jTextField7, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel7, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jTextField2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addGap(37)
       	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jTextField8, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel8, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jTextField3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addGap(38)
       	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jTextField9, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel9, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jTextField4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addGap(25)
       	.addGroup(jPanel1Layout.createParallelGroup()
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addGap(0, 0, Short.MAX_VALUE)
       	        .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, GroupLayout.PREFERRED_SIZE)
       	        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	            .addComponent(jTextField10, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	            .addComponent(jLabel1TipoContratto, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	            .addComponent(jLabel1Retribuzione, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	            .addComponent(jTextField1Retribuzione, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
       	    .addGroup(jPanel1Layout.createSequentialGroup()
       	        .addGap(9)
       	        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	            .addComponent(jTextField5, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	            .addComponent(jLabel5, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	        .addGap(19)))
       	.addGap(0, 18, GroupLayout.PREFERRED_SIZE)
       	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jTextField1DataContratto, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jLabel11, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	.addGap(0, 46, GroupLayout.PREFERRED_SIZE)
       	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       	    .addComponent(jButton1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
       	    .addComponent(jButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
       	.addContainerGap(23, 23));
       jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
       	.addContainerGap()
       	.addGroup(jPanel1Layout.createParallelGroup()
       	    .addComponent(jLabel5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(27))
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(26))
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(46))
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
       	.addGroup(jPanel1Layout.createParallelGroup()
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addComponent(jButton1, 0, 91, Short.MAX_VALUE)
       	        .addGap(405))
       	    .addGroup(jPanel1Layout.createSequentialGroup()
       	        .addGap(35)
       	        .addGroup(jPanel1Layout.createParallelGroup()
       	            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
       	                .addGap(0, 8, Short.MAX_VALUE)
       	                .addComponent(jLabel1TipoContratto, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
       	                .addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
       	                .addGap(198))
       	            .addGroup(jPanel1Layout.createSequentialGroup()
       	                .addGroup(jPanel1Layout.createParallelGroup()
       	                    .addComponent(jTextField4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
       	                    .addComponent(jTextField3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
       	                    .addComponent(jTextField2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
       	                    .addComponent(jTextField1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
       	                .addGap(29)
       	                .addGroup(jPanel1Layout.createParallelGroup()
       	                    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                        .addGroup(jPanel1Layout.createParallelGroup()
       	                            .addComponent(jLabel11, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
       	                            .addComponent(jLabel7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	                            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	                                .addGap(15)))
       	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
       	                        .addGroup(jPanel1Layout.createParallelGroup()
       	                            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                                .addComponent(jTextField1DataContratto, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
       	                                .addGap(10))
       	                            .addComponent(jLabel1Retribuzione, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
       	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
       	                        .addComponent(jTextField1Retribuzione, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
       	                        .addGap(0, 0, Short.MAX_VALUE))
       	                    .addGroup(jPanel1Layout.createSequentialGroup()
       	                        .addGroup(jPanel1Layout.createParallelGroup()
       	                            .addComponent(jLabel9, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	                            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
       	                        .addGap(45)
       	                        .addGroup(jPanel1Layout.createParallelGroup()
       	                            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                                .addGap(0, 0, Short.MAX_VALUE)
       	                                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	                                .addGroup(jPanel1Layout.createParallelGroup()
       	                                    .addComponent(jTextField9, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
       	                                    .addComponent(jTextField8, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
       	                                    .addComponent(jTextField7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
       	                                    .addComponent(jTextField6, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
       	                            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                                .addPreferredGap(jLabel10, jButton2, LayoutStyle.ComponentPlacement.INDENT)
       	                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
       	                                .addGap(0, 112, Short.MAX_VALUE)))
       	                        .addGap(11)))))))
       	.addContainerGap(20, 20));

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setVerticalGroup(layout.createSequentialGroup()
       	.addContainerGap()
       	.addComponent(jPanel1, 0, 419, Short.MAX_VALUE));
       layout.setHorizontalGroup(layout.createSequentialGroup()
       	.addContainerGap()
       	.addComponent(jPanel1, 0, 605, Short.MAX_VALUE));

       pack();
       this.setTitle("FullDent - Nuovo Dipendente");
   }


   /**
    * Azione eseguita alla pressione del bottone "Aggiungi".
    * @param evt l'evento che indica la pressione del bottone.
    */
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	   try{
		   String cf = jTextField1.getText();
		   String n = jTextField2.getText();
		   String cg = jTextField3.getText() ;
		   String res = jTextField4.getText();
		   String dn = jTextField5.getText();
		   String ln = jTextField6.getText();
		   int tel = Integer.parseInt(jTextField7.getText());
		   String t = jTextField8.getText();
		   String s = jTextField9.getText();
		   String tipoc = jTextField10.getText();
		   double retrc = Double.parseDouble(jTextField1Retribuzione.getText());
		   String datac = jTextField1DataContratto.getText();
		   if(!(cf.equals("") || n.equals("") || cg.equals("") || res.equals("") || dn.equals("") 
				   || ln.equals("") || jTextField7.getText().equals("") || t.equals("") || s.equals("") 
				   || tipoc.equals("") || datac.equals(""))){
			 if(s.length() == 1 && (t.equals("amministratore") || t.equals("segretaria") || t.equals("medico")) && 
					 (s.equalsIgnoreCase("M") || s.equalsIgnoreCase("F"))){  
			   if(formatoData(datac) && formatoData(dn)){
				   if(jTextField7.getText().length()<11){
					   Contratto k = new Contratto(retrc,tipoc,datac);
					   if(cf.length()==16){
						   DatiPersonale y = new DatiPersonale(cf,n,cg,res,dn,ln,tel,t,s,k);
						   DBPersonale x = new DBPersonale();
						   x.openConnection();
						   x.aggiungiDipendente(y);
						   x.closeConnection();
						   successo();
						   this.setVisible(false);
						   new FormAmministratore().setVisible(true);
					   }else errore("Codice fiscale non corretto!");
				   }else errore("Il numero di telefono non può superare le 10 cifre!");
			   }else errore("Data inserita non valida! (GG/MM/AAAA)");
			 }else errore("Il sesso deve essere un carattere (M o F) ed il tipo amministratore,segretaria o medico!");
		   }else errore("Devono essere inseriti tutti i campi!");
	   }catch(SQLException e){
		   errore("Errore di connessione con il DataBase!");
	   }catch(FileNotFoundException e){
		   errore("File per la connessione con il DataBase non trovato!");
	   }catch(IOException e){
		   errore("Errore di comunicazione con il file!");
	   }catch(ClassNotFoundException e){
		   errore("Classe non trovata!");
	   }catch(IllegalArgumentException e){
		   errore("Dati inseriti non corretti!");
	   }catch(DuplicateException e){
		   errore("Dipendente già presente!");
	   }
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
		   if(giorno < 0 || mese < 0 || anno < 0 || mese > 12)
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
    * @param evt l'evento che indica la pressione del bottone.
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
    * Frame contenente un messaggio di operazione effettuata.
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
               new FormAggiungiPersonale().setVisible(true);
           }
       });
   }

   /** The j button1. */
   private javax.swing.JButton jButton1;
   
   /** The j button2. */
   private javax.swing.JButton jButton2;
   
   /** The j label1. */
   private javax.swing.JLabel jLabel1;
   
   /** The j label10. */
   private javax.swing.JLabel jLabel10;
   
   /** The j label2. */
   private javax.swing.JLabel jLabel2;
   
   /** The j label3. */
   private javax.swing.JLabel jLabel3;
   
   /** The j label4. */
   private javax.swing.JLabel jLabel4;
   
   /** The j label5. */
   private javax.swing.JLabel jLabel5;
   
   /** The j label1 retribuzione. */
   private JLabel jLabel1Retribuzione;
   
   /** The j label1 tipo contratto. */
   private JLabel jLabel1TipoContratto;
   
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
   
   /** The j text field1. */
   private javax.swing.JTextField jTextField1;
   
   /** The j text field10. */
   private javax.swing.JTextField jTextField10;
   
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
   
   /** The j text field1 retribuzione. */
   private JTextField jTextField1Retribuzione;
   
   /** The j text field1 data contratto. */
   private JTextField jTextField1DataContratto;
   
   /** The j label11. */
   private JLabel jLabel11;
   
   /** The j text field7. */
   private javax.swing.JTextField jTextField7;
   
   /** The j text field8. */
   private javax.swing.JTextField jTextField8;
   
   /** The j text field9. */
   private javax.swing.JTextField jTextField9;

}
