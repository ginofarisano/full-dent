package guiSale;

import gestioneSala.DatiSala;
import guiAmministratore.FormAmministratore;

// TODO: Auto-generated Javadoc
/**
* Interfaccia grafica per la visualizzazione dei dati relativi ad una sala.
* @author Vincenzo D'Alessio.
*/
public class FormDatiSale extends javax.swing.JFrame {

    /** 
     * Crea un nuovo Form.
     * @param x i dati della sala da visualizzare.
     */
    public FormDatiSale(DatiSala x) {
    	sala = x;
        initComponents();
    }

    /**
     * Metodo di supporto per l'inizializzazione delle componenti del Form.
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setText("Codice Sala:");

        jLabel2.setText("Descrizione:");

        jLabel3.setText("Nome Sala:");

        jLabel4.setText("CF:");

        jLabel5.setText(""+sala.getCodiceSala());

        jLabel6.setText(sala.getDescrizione());

        jLabel7.setText(sala.getNomeSala());

        jLabel8.setText(sala.getCodiceFiscale());

        jButton1.setText("Modifica");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(34, 34, 34)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2)
                            .add(jLabel3)
                            .add(jLabel4)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(55, 55, 55)
                        .add(jButton1)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(51, 51, 51)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel8)
                            .add(jLabel7)
                            .add(jLabel6)
                            .add(jLabel5))
                        .addContainerGap(116, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(104, 104, 104))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(38, 38, 38)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel5))
                .add(40, 40, 40)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jLabel6))
                .add(43, 43, 43)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jLabel7))
                .add(47, 47, 47)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jLabel8))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 33, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton3)
                    .add(jButton1))
                .add(48, 48, 48))
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
        this.setTitle("FullDent - Informazioni Sala");
    }

    /**
     * Azione eseguita alla pressione del bottone "Modifica".
     * @param evt il ricevitore d'evento.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	FormModificaDatiSala x = new FormModificaDatiSala(sala);
    	x.setVisible(true);
    	this.setVisible(false);
    }

    /**
     * Azione eseguita alla pressione del bottone "Ok".
     * @param evt il ricevitore d'evento.
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    	this.setVisible(false);
    	new FormAmministratore().setVisible(true);
    }

    /** The sala. */
    private DatiSala sala;
    
    /** The j button1. */
    private javax.swing.JButton jButton1;
    
    /** The j button3. */
    private javax.swing.JButton jButton3;
    
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
    
    /** The j label6. */
    private javax.swing.JLabel jLabel6;
    
    /** The j label7. */
    private javax.swing.JLabel jLabel7;
    
    /** The j label8. */
    private javax.swing.JLabel jLabel8;
    
    /** The j panel1. */
    private javax.swing.JPanel jPanel1;

}

