package guiAttrezzature;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import exception.NotFoundException;

import gestioneAttrezzature.DBAttrezzature;
import gestioneAttrezzature.DatiAttrezzature;
import guiAmministratore.FormAmministratore;

// TODO: Auto-generated Javadoc
/**
* Form che permette lo scambio di informazioni tra utente e sistema per la visualizzazione,
* la modifica o l'eliminazione di un'attrezzatura nel DataBase.
* @author Vincenzo D'Alessio.
*/
public class FormDatiAttrezzature extends javax.swing.JFrame {

    /**
     * Crea un nuovo Form.
     *
     * @param x the x
     */
    public FormDatiAttrezzature(DatiAttrezzature x) {
    	attr = x;
        initComponents();
    }

    /** 
     * Metodo di supporto che inizializza le componenti del frame.
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
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setText("Codice Tipo:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Quantità:");

        jLabel4.setText("Costo:");

        jLabel5.setText(""+attr.getCodiceTipo());

        jLabel6.setText(""+attr.getNome());

        jLabel7.setText(""+attr.getQuantità());

        jLabel8.setText(""+attr.getCosto());

        jLabel9.setText("Tipo:");

        jLabel10.setText("Descrizione:");

        jLabel11.setText("Locazione:");

        jLabel12.setText("Codice Fornitore:");

        jLabel13.setText(""+attr.getCodiceFornitore());

        jLabel14.setText(""+attr.getLocazione());

        jLabel15.setText(""+attr.getDescrizione());

        jLabel16.setText(""+attr.getTipo());

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
                .add(63, 63, 63)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jLabel2)
                    .add(jLabel3)
                    .add(jLabel4))
                .add(34, 34, 34)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5)
                    .add(jLabel6)
                    .add(jLabel7)
                    .add(jLabel8))
                .add(139, 139, 139)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel12)
                    .add(jLabel11)
                    .add(jLabel10)
                    .add(jLabel9))
                .add(44, 44, 44)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel16)
                    .add(jLabel15)
                    .add(jLabel14)
                    .add(jLabel13))
                .addContainerGap(184, Short.MAX_VALUE))
            .add(jPanel1Layout.createSequentialGroup()
                .add(103, 103, 103)
                .add(jButton1)
                .add(137, 137, 137)
                .add(jButton2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 129, Short.MAX_VALUE)
                .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(129, 129, 129))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(54, 54, 54)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel5)
                    .add(jLabel9)
                    .add(jLabel16))
                .add(37, 37, 37)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jLabel6)
                    .add(jLabel10)
                    .add(jLabel15))
                .add(42, 42, 42)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jLabel7)
                    .add(jLabel11)
                    .add(jLabel14))
                .add(44, 44, 44)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jLabel8)
                    .add(jLabel12)
                    .add(jLabel13))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 60, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1)
                    .add(jButton2)
                    .add(jButton3))
                .add(50, 50, 50))
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
        this.setTitle("FullDent - Informazioni Attrezzatura");
    }

    /**
     * Azione eseguita alla pressione del bottone "Modifica".
     * @param evt l'evento che indica la pressione del bottone.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	FormModificaAttrezzatura x = new FormModificaAttrezzatura(attr.getCodiceTipo());
    	x.setVisible(true);
    	this.setVisible(false);
    }

    /**
     * Azione eseguita alla pressione del bottone "Rimuovi".
     * @param evt l'evento che indica la pressione del bottone.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    	try{
    		DBAttrezzature x = new DBAttrezzature();
    		x.openConnection();
    		x.eliminaAttrezzature(attr);
    		x.closeConnection();
    		successo();
    		this.setVisible(false);
    		new FormAmministratore().setVisible(true);
    	}catch(SQLException e){
    		errore("Errore di connessione con il DataBase!");
    	}catch(NotFoundException e){
    		errore("Attrezzatura non presente!");
    	}catch(FileNotFoundException e){
    		errore("File non trovato!");
    	} catch (IOException e) {
			errore("Errore di comunicazione con il file!");
		} catch (ClassNotFoundException e) {
			errore("Classe non trovata!");
		}
    	
    }

    /**
     * Azione eseguita alla pressione del bottone "Ok".
     * @param evt l'evento che indica la pressione del bottone.
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
     * Frame contenente un messaggio di avvenuta operazione.
     */
    protected void successo(){
    	JOptionPane.showMessageDialog(null,"Operazione effettuata!");
    }

    /** The attr. */
    private DatiAttrezzature attr;
    
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

