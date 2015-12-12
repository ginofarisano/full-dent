package guiCalendario;

import gestioneCalendario.DBCalendario;
import gestioneCalendario.Data;
import gestioneCalendario.DatiAppuntamento;
import guiSegretaria.FormCalendario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;


// TODO: Auto-generated Javadoc
/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
* Classe che specifica il form di visualizza appuntamenti
* @author G.Valitutto
*/
public class FormVisualizzaAppuntamenti extends javax.swing.JFrame {

	    /** 
	     * Crea un nuovo Form.
	     * @param elenco l'elenco degli appuntamenti del giorno richiesto.
	     */
	    public FormVisualizzaAppuntamenti(ArrayList<DatiAppuntamento> elenco) {
	    	appuntamenti = elenco;
	        initComponents();
	    }
                      
	    /**
	     * Metodo di supporto che inizializza le componenti del Frame.
	     */
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jPanel1 = new javax.swing.JPanel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTable1 = new javax.swing.JTable();
	        jButton1 = new javax.swing.JButton();
	        jTextField1 = new javax.swing.JTextField();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); 
	        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
	        jLabel1.setText("Visualizza Appuntamenti");

	        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

	        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	        jTable1.setModel(new javax.swing.table.DefaultTableModel(
	            new String [] {
	                "TipoServizio", "NomePaziente", "CognomePaziente", "NomeMedico", "CognomeMedico", "Data", "Ora"
	            },appuntamenti.size())
	        );	        
	        
	        jScrollPane1.setViewportView(jTable1);
	        
	        jButton1.setText("Cerca");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });


	        jButton2.setText("Aggiungi");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jButton3.setText("Annulla");
	        {
	        	ora = new JLabel();
	        	ora.setText("Ora:");
	        }
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
	        	.addContainerGap(20, 20)
	        	.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
	        	.addGap(18)
	        	.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	        	    .addComponent(jTextField1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
	        	    .addComponent(jButton1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
	        	    .addComponent(jButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
	        	    .addComponent(jButton3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
	        	    .addComponent(ora, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
	        	.addContainerGap(18, 18));
	        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
	        	.addContainerGap()
	        	.addGroup(jPanel1Layout.createParallelGroup()
	        	    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, 0, 689, Short.MAX_VALUE)
	        	    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
	        	        .addGap(7)
	        	        .addComponent(ora, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
	        	        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
	        	        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	        	        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
	        	        .addGap(0, 341, Short.MAX_VALUE)
	        	        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
	        	        .addGap(27)
	        	        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
	        	        .addGap(16)))
	        	.addContainerGap());

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jLabel1))
	                .addContainerGap(19, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(20, Short.MAX_VALUE))
	        );
	        
	        for(int i = 0; i< appuntamenti.size(); i++){
	        	DatiAppuntamento x = appuntamenti.get(i);
	        	jTable1.setValueAt(x.getTipoServizio(), i, 0);
	        	jTable1.setValueAt(x.getNomePaziente(), i, 1);
	        	jTable1.setValueAt(x.getCognomePaziente(), i, 2);
	        	jTable1.setValueAt(x.getNomeMedico(), i, 3);
	        	jTable1.setValueAt(x.getCognomeMedico(), i, 4);
	        	jTable1.setValueAt(x.getDataAppuntamento().getData(), i, 5);
	        	jTable1.setValueAt(x.getDataAppuntamento().getOra(), i, 6);
	        }

	        pack();
	        this.setTitle("FullDent - Lista Appuntamenti");
	    }

	    /**
	     * Azione eseguita alla pressione del bottone "Cerca".
	     * @param evt il ricevitore d'evento.
	     */
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
	    	try{
	    		String ora = jTextField1.getText();
	    		int ore = Integer.parseInt(ora.substring(0,2));
	    		int minuti = Integer.parseInt(ora.substring(4));
	    		if(ora.length() == 5 && ora.substring(2,3).equals(":") && ore>= 0 && ore<= 23 && minuti >= 0 && minuti <= 59){	    			
	    			String ts = appuntamenti.get(0).getTipoServizio();
	    			Data dat = new Data(appuntamenti.get(0).getDataAppuntamento().getData(),ora);
	    			DBCalendario x = new DBCalendario();
	    			x.openConnection();
	    			DatiAppuntamento y = x.ricercaAppuntamento(ts,dat);
	    			x.closeConnection();
	    			if(y!=null){
	    				FormDatiAppuntamento k = new FormDatiAppuntamento(y);
	    				this.setVisible(false);
	    				k.setVisible(true);
	    			}else errore("Appuntamento non presente!");
	    		}else errore("Valori inseriti non validi! (HH:MM)");
	    	}catch(SQLException e){
				errore("Errore d'accesso al DataBase!");
			}catch(FileNotFoundException e){
				errore("File di accesso al DataBase non trovato!");
			} catch (ClassNotFoundException e) {
				errore("Classe non trovata!");
			} catch (IOException e) {
				errore("Errore di comunicazione con il file!");
			} catch (IllegalArgumentException e){
				errore("Valori inseriti non validi!");
			} catch(StringIndexOutOfBoundsException e){
				errore("L'orario inserito non è valido! (HH:MM)");
			}
			
	    }                                        

	    /**
	     * Azione eseguita alla pressione del bottone "Aggiungi".
	     * @param evt il ricevitore d'evento.
	     */
	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                        
	    	FormAggiungiAppuntamento x = new FormAggiungiAppuntamento();
	    	x.setVisible(true);
	    	this.setVisible(false);
	    }                                        
	   
	    /**
	     * Azione eseguita alla pressione del bottone "Annulla".
	     * @param evt il ricevitore d'evento.
	     */
	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                        
	    	this.setVisible(false);
	    	new FormCalendario().setVisible(true);
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

	    /** The appuntamenti. */
    	private ArrayList<DatiAppuntamento> appuntamenti;
	    
    	/** The j button1. */
    	private javax.swing.JButton jButton1;
	    
    	/** The ora. */
    	private JLabel ora;
	    
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
	    
    	/** The j table1. */
    	private javax.swing.JTable jTable1;
	    
    	/** The j text field1. */
    	private javax.swing.JTextField jTextField1;	                     

}


