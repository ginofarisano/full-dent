package guiAttrezzature;


import javax.swing.GroupLayout;
import javax.swing.JComponent;

import javax.swing.JOptionPane;

import gestioneFornitori.DatiFornitore;

// TODO: Auto-generated Javadoc
/**
* Interfaccia grafica per la selezione del fornitore per l'aggiunta di una nuova attrezzatura.
* @author Vincenzo D'Alessio.
*/
public class FormDatiFornitore2 extends javax.swing.JFrame {

   /**
    *  
    * Crea un nuovo Form.
    *
    * @param x the x
    */
   public FormDatiFornitore2(DatiFornitore x) {
	   fornitore = x;
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

       jButton3.setText("OK");
       jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
       	.addContainerGap(29, 29)
       	.addGroup(jPanel1Layout.createParallelGroup()
       	    .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addGap(8)
       	        .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(8)))
       	.addGap(28)
       	.addGroup(jPanel1Layout.createParallelGroup()
       	    .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addGap(8)
       	        .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(8)))
       	.addGap(34)
       	.addGroup(jPanel1Layout.createParallelGroup()
       	    .addComponent(jLabel3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addGap(8)
       	        .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(8)))
       	.addGap(39)
       	.addGroup(jPanel1Layout.createParallelGroup()
       	    .addComponent(jLabel4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addGap(8)
       	        .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(8)))
       	.addGap(37)
       	.addGroup(jPanel1Layout.createParallelGroup()
       	    .addComponent(jLabel5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addGap(8)
       	        .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(8)))
       	.addGap(37)
       	.addGroup(jPanel1Layout.createParallelGroup()
       	    .addComponent(jLabel6, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addGap(8)
       	        .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(8)))
       	.addGap(0, 37, Short.MAX_VALUE)
       	.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	.addContainerGap(25, 25));
       jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
       	.addContainerGap(23, 23)
       	.addGroup(jPanel1Layout.createParallelGroup()
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addGroup(jPanel1Layout.createParallelGroup()
       	            .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	                .addGap(77))
       	            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	                .addGap(80))
       	            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	                .addGap(59))
       	            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	                .addGap(71)))
       	        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
       	        .addGap(0, 0, Short.MAX_VALUE))
       	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
       	        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
       	        .addGap(31)
       	        .addGroup(jPanel1Layout.createParallelGroup()
       	            .addGroup(jPanel1Layout.createSequentialGroup()
       	                .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	            .addGroup(jPanel1Layout.createSequentialGroup()
       	                .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	            .addGroup(jPanel1Layout.createSequentialGroup()
       	                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	            .addGroup(jPanel1Layout.createSequentialGroup()
       	                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	            .addGroup(jPanel1Layout.createSequentialGroup()
       	                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
       	            .addGroup(jPanel1Layout.createSequentialGroup()
       	                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
       	        .addGap(0, 24, Short.MAX_VALUE)))
       	.addContainerGap(165, 165));
       jButton3.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton3ActionPerformed(evt);
           }
       });

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
    * Azione eseguita alla pressione del bottone "Ok".
    * @param evt il ricevitore d'evento.
    */
   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
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
    * Frame contenente un messaggio di conferma dell'operazione.
    */
   protected void successo(){
   	JOptionPane.showMessageDialog(null,"Operazione effettuata!");
   }

   /** The fornitore. */
   private DatiFornitore fornitore;
   
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
