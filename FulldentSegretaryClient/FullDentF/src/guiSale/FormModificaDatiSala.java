package guiSale;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import gestioneSala.DBSala;
import gestioneSala.DatiSala;
import guiAmministratore.FormAmministratore;

// TODO: Auto-generated Javadoc
/**
 * Interfaccia grafica per la modifica dei dati di una sala.
 * @author Filomena Fruncillo
 */
public class FormModificaDatiSala extends javax.swing.JFrame {

    /** 
     * Crea un nuovo Form.
     * @param x i dati della sala da modificare.
     */
    public FormModificaDatiSala(DatiSala x) {
    	sala = x;
        initComponents();
    }

    /**
     * Metodo di supporto per l'inizializzazione delle componenti del Frame.
     */
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setText("Descrizione:");

        jLabel3.setText("Nome Sala:");

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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jTextField2.setText(sala.getNomeSala());
        jTextArea1.setText(sala.getDescrizione());

        pack();
        this.setTitle("FullDent - Modifica Sala");
    }
    
    /**
     * Azione eseguita alla pressione del bottone "Ok".
     * @param evt il ricevitore d'evento.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	try{
    		String nomeSala = jTextField2.getText();
    		String descrizione = jTextArea1.getText();
    		if(!nomeSala.equals(" ")){
    			sala.setNomeSala(nomeSala);
    			sala.setDescrizione(descrizione);
    			DBSala x = new DBSala();
    			x.openConnection();
    			x.modificaSala(sala);
    			x.closeConnection();
    			successo();
    			this.setVisible(false);
    			new FormAmministratore().setVisible(true);
    		}else errore("Il campo nome sala è vuoto!");
    	}catch(SQLException e){
			errore("Errore d'accesso al DataBase!");
		}catch(FileNotFoundException e){
			errore("File di accesso al DataBase non trovato!");
		} catch (IOException e) {
			errore("Errore di comunicazione con il file!");
		} catch (ClassNotFoundException e) {
			errore("Classe non trovata!");
		}
    	
    }

    /**
     * Azione esguita alla pressione del bottone "Annulla".
     * @param evt il ricevitore d'evento.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    	this.setVisible(false);
    	new FormDatiSale(sala).setVisible(true);
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
    
    /** The sala. */
    private DatiSala sala;
    
    /** The j button1. */
    private javax.swing.JButton jButton1;
    
    /** The j button2. */
    private javax.swing.JButton jButton2;
    
    /** The j label1. */
    private javax.swing.JLabel jLabel1;
    
    /** The j label3. */
    private javax.swing.JLabel jLabel3;
    
    /** The j panel1. */
    private javax.swing.JPanel jPanel1;
    
    /** The j scroll pane1. */
    private javax.swing.JScrollPane jScrollPane1;
    
    /** The j text area1. */
    private javax.swing.JTextArea jTextArea1;
    
    /** The j text field2. */
    private javax.swing.JTextField jTextField2;

}
