package guiSale;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;

import exception.DuplicateException;
import exception.InvalidDataException;

import gestioneSala.DBSala;
import gestioneSala.DatiSala;
import guiAmministratore.FormAmministratore;

// TODO: Auto-generated Javadoc
/**
 * Interfaccia grafica per l'aggiunta di una nuova sala.
 * @author Filomena Fruncillo
 */
public class FormAggiungiSala extends javax.swing.JFrame {

    /** 
     * Crea un nuovo Form.
     */
    public FormAggiungiSala() {
        try{
        	DBSala x = new DBSala();
        	x.openConnection();
        	cf = x.prelevaCodiceF();
        	x.closeConnection();
        }catch(SQLException e){
        	errore("Errore di accesso al DataBase!");
        } catch (ClassNotFoundException e) {
			errore("Classe non trovata!");
		} catch (FileNotFoundException e) {
			errore("File non trovato!");
		} catch (IOException e) {
			errore("Errore di comunicazione con il file!");
		}
    	initComponents();
    }

    /**
     * Metodo di supporto che inizializza le componenti del Form.
     */
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        {
        	cf1 = new JLabel(cf);
        }
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        GroupLayout layout = new GroupLayout((JComponent)getContentPane());
        getContentPane().setLayout(layout);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Codice Sala");

        jLabel4.setText("Nome Sala");


        jLabel5.setText("CF");

        jLabel6.setText("Descrizione");

        jButton1.setText("Aggiungi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Annulla");
        layout.setVerticalGroup(layout.createSequentialGroup()
        	.addContainerGap(31, 31)
        	.addGroup(layout.createParallelGroup()
        	    .addGroup(layout.createSequentialGroup()
        	        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        	            .addComponent(jTextField2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        	            .addComponent(jLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        	            .addComponent(jLabel6, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
        	        .addGap(25)
        	        .addGroup(layout.createParallelGroup()
        	            .addGroup(layout.createSequentialGroup()
        	                .addGap(0, 0, Short.MAX_VALUE)
        	                .addComponent(cf1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
        	            .addGroup(layout.createSequentialGroup()
        	                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        	                .addGap(0, 0, Short.MAX_VALUE))
        	            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
        	                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        	                .addGap(0, 16, Short.MAX_VALUE)))
        	        .addGap(22))
        	    .addGroup(layout.createSequentialGroup()
        	        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
        	        .addGap(0, 0, Short.MAX_VALUE)))
        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        	    .addComponent(jTextField1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        	    .addComponent(jLabel4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
        	.addGap(0, 38, GroupLayout.PREFERRED_SIZE)
        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        	    .addComponent(jButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        	    .addComponent(jButton1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        	.addContainerGap());
        layout.setHorizontalGroup(layout.createSequentialGroup()
        	.addContainerGap()
        	.addGroup(layout.createParallelGroup()
        	    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
        	        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        	        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
        	    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
        	        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        	        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        	        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        	        .addGap(41))
        	    .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
        	.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        	.addGroup(layout.createParallelGroup()
        	    .addComponent(cf1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
        	    .addGroup(layout.createSequentialGroup()
        	        .addGap(28)
        	        .addGroup(layout.createParallelGroup()
        	            .addComponent(jTextField1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        	            .addComponent(jTextField2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        	            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
        	                .addGap(7)
        	                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        	                .addGap(35)))))
        	.addGap(34)
        	.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        	.addGap(7)
        	.addGroup(layout.createParallelGroup()
        	    .addGroup(layout.createSequentialGroup()
        	        .addGap(0, 0, Short.MAX_VALUE)
        	        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
        	    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
        	        .addGap(0, 18, Short.MAX_VALUE)
        	        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        	        .addGap(153)))
        	.addContainerGap(27, 27));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
     
        jScrollPane1.setViewportView(jTextArea1);
        
        pack();
        this.setTitle("FullDent - Nuova Sala");
    }

    /**
     * Azione eseguita alla pressione del bottone "Aggiungi".
     * @param evt il ricevitore d'evento.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	try{
    		int cod = Integer.parseInt(jTextField2.getText());
    		String nome = jTextField1.getText();
    		String desc = jTextArea1.getText();
    		if(desc.length()<=45){
    			DatiSala x = new DatiSala(nome,desc,cf,cod);
    			DBSala y = new DBSala();
    			y.openConnection();
    			y.inserisciSala(x);
    			y.closeConnection();
    			successo();
    			this.setVisible(false);
    			new FormAmministratore().setVisible(true);
    		}else errore("Descrizione superiore ai 45 caratteri!");
    		
    	}catch(SQLException e){
    		errore("Errore connessione DataBase!");
    	} catch (ClassNotFoundException e) {
    		errore("Classe non trovata!");
		} catch (FileNotFoundException e) {
			errore("File non trovato!");
		} catch (IOException e) {
			errore("Errore di comunicazione con il file!");
		} catch(IllegalArgumentException e){
			errore("Valori inseriti non validi!");
		} catch(InvalidDataException e){
			errore("Dati inseriti non validi!");
		} catch(DuplicateException e){
			errore("Codice sala già presente!");
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

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAggiungiSala().setVisible(true);
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

    /** The cf. */
    private String cf;
    
    /** The cf1. */
    private javax.swing.JLabel cf1;
    
    /** The j button1. */
    private javax.swing.JButton jButton1;
    
    /** The j button2. */
    private javax.swing.JButton jButton2;
    
    /** The j label1. */
    private javax.swing.JLabel jLabel1;
    
    /** The j label3. */
    private javax.swing.JLabel jLabel3;
    
    /** The j label4. */
    private javax.swing.JLabel jLabel4;
    
    /** The j label5. */
    private javax.swing.JLabel jLabel5;
    
    /** The j label6. */
    private javax.swing.JLabel jLabel6;
    
    /** The j scroll pane1. */
    private javax.swing.JScrollPane jScrollPane1;
    
    /** The j text area1. */
    private javax.swing.JTextArea jTextArea1;
    
    /** The j text field1. */
    private javax.swing.JTextField jTextField1;
    
    /** The j text field2. */
    private javax.swing.JTextField jTextField2;

}
