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
* Interfaccia grafica per l'aggiunta di una nuova attrezzatura.
* @author Vincenzo D'Alessio.
*/
public class FormAggiungiAttrezzatura extends javax.swing.JFrame {

   /**
	* Crea un nuovo Form.
    */
   public FormAggiungiAttrezzatura() {
       initComponents();
   }

   /**
    * Metodo di supporto che inizializza le componenti del Form.
    */
   private void initComponents() {

       jPanel1 = new javax.swing.JPanel();
       jLabel1 = new javax.swing.JLabel();
       jTextField1 = new javax.swing.JTextField();
       jLabel2 = new javax.swing.JLabel();
       jComboBox1 = new javax.swing.JComboBox();
       jButton1 = new javax.swing.JButton();
       jButton2 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

       jLabel1.setText("Codice Attrezzatura:");



       jLabel2.setText("Tipo Attrezzatura:");

       jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<<Seleziona Tipo>>", "Attrezzatura", "Materiale" }));
       jComboBox1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jComboBox1ActionPerformed(evt);
           }
       });

       org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
       jPanel1.setLayout(jPanel1Layout);
       jPanel1Layout.setHorizontalGroup(
           jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(jPanel1Layout.createSequentialGroup()
               .add(67, 67, 67)
               .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                   .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                   .add(jLabel1)
                   .add(jLabel2)
                   .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
               .addContainerGap(72, Short.MAX_VALUE))
       );
       jPanel1Layout.setVerticalGroup(
           jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(jPanel1Layout.createSequentialGroup()
               .addContainerGap()
               .add(jLabel1)
               .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
               .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(44, 44, 44)
               .add(jLabel2)
               .add(28, 28, 28)
               .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(37, Short.MAX_VALUE))
       );

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

       org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(layout.createSequentialGroup()
               .add(26, 26, 26)
               .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .add(32, 32, 32))
           .add(layout.createSequentialGroup()
               .add(58, 58, 58)
               .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 82, Short.MAX_VALUE)
               .add(jButton2)
               .add(63, 63, 63))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
           .add(layout.createSequentialGroup()
               .add(38, 38, 38)
               .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(38, 38, 38)
               .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                   .add(jButton1)
                   .add(jButton2))
               .addContainerGap(23, Short.MAX_VALUE))
       );

       pack();
       this.setTitle("FullDent - Nuova Attrezzatura");
   }

   /**
    * J combo box1 action performed.
    *
    * @param evt the evt
    */
   private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           

   }                                          

    /**
     * Azione eseguita alla pressione del bottone "Ok".
     * @param evt l'evento che indica la pressione del bottone.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)  {
    	try{
    		 int cod = Integer.parseInt(jTextField1.getText());
    		 String tipo = (String)jComboBox1.getSelectedItem();
    		 if(!tipo.equals("<<Seleziona Tipo>>")){
    			 DBAttrezzature x = new DBAttrezzature();
    			 x.openConnection();
    			 DatiAttrezzature y = x.getAttrezzatura(cod);
    			 x.closeConnection();
    			 if(y != null){
    				 FormAggiornaAttrezzature z = new FormAggiornaAttrezzature(y);
    				 z.setVisible(true);
    				 this.setVisible(false);
    			 }else {
    				 FormElencoFornitori2 k = new FormElencoFornitori2(cod,tipo);
    				 k.setVisible(true);
    				 this.setVisible(false);
    			 }
    		 }else errore("Seleziona un tipo di attrezzatura!");
    		
    		}catch(IllegalArgumentException e){
    			errore("Valori inseriti non validi!");
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
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)  {
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
                new FormAggiungiAttrezzatura().setVisible(true);
            }
        });
    }
   
    /** The j button1. */
    private javax.swing.JButton jButton1;
    
    /** The j button2. */
    private javax.swing.JButton jButton2;
    
    /** The j combo box1. */
    private javax.swing.JComboBox jComboBox1;
    
    /** The j label1. */
    private javax.swing.JLabel jLabel1;
    
    /** The j label2. */
    private javax.swing.JLabel jLabel2;
    
    /** The j panel1. */
    private javax.swing.JPanel jPanel1;
    
    /** The j text field1. */
    private javax.swing.JTextField jTextField1;
   
}

