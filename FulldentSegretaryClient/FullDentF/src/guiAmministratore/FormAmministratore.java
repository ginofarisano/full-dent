package guiAmministratore;

import gestionePersonale.DBPersonale;
import gestionePersonale.DatiPersonale;
import gestioneSala.*;
import guiAccessi.FormAccessi;
import guiAttrezzature.FormAggiungiAttrezzatura;
import gestioneAttrezzature.*;
import guiAttrezzature.*;
import guiFornitori.FormElencoFornitori;
import guiPersonale.FormAggiungiPersonale;
import guiPersonale.FormDatiDipendente;
import guiSale.FormAggiungiSala;
import guiSale.FormDatiSale;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
* Interfaccia grafica dell'amministratore.
* @author Vincenzo D'alessio.
*/
public class FormAmministratore extends JFrame {

	/**
     * Crea una nuova interfaccia grafica per un amministratore.
     */
    public FormAmministratore() {
    	setArrayList();
        initComponents();
    }

    /** 
     * Metodo di supporto che inizializza le componenti del Frame.
     */
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Matricola = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


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

        jLabel1.setText("Elenco Personale");

        Matricola.setModel(new javax.swing.table.DefaultTableModel(
            
            new String [] {
                "Codice Fiscale", "Nome", "Cognome", "Residenza", "D. Nascita", "L. Nascita", "Tel.", "Tipo", "Sesso", "Contratto"
            }
        ,dipendenti.size()));
        jScrollPane1.setViewportView(Matricola);
        Matricola.getColumnModel().getColumn(0).setPreferredWidth(120);
        Matricola.getColumnModel().getColumn(1).setPreferredWidth(80);
        Matricola.getColumnModel().getColumn(6).setMinWidth(60);
        Matricola.getColumnModel().getColumn(6).setPreferredWidth(60);
        Matricola.getColumnModel().getColumn(7).setMinWidth(60);
        Matricola.getColumnModel().getColumn(7).setPreferredWidth(60);
        Matricola.getColumnModel().getColumn(8).setPreferredWidth(80);

        jScrollPane5.setViewportView(jScrollPane1);

        jLabel5.setText("CodiceFiscale:");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(202, 202, 202)
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 28, Short.MAX_VALUE)
                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 38, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jScrollPane5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5)
                    .add(jLabel1))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(jScrollPane5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(55, 55, 55)
                        .add(jButton2)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Personale", jPanel1);


        jLabel2.setText("Elenco Sale");

        jButton6.setText("Cerca");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Aggiungi");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                        new String [] {
                "Codice Sala", "Descrizione", "Nome Sala", "CF           "
            }
        ,sale.size()));
        jScrollPane2.setViewportView(jTable1);

        jScrollPane6.setViewportView(jScrollPane2);

        jLabel6.setText("Codice:");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel2)
                        .add(311, 311, 311)
                        .add(jLabel6)
                        .add(18, 18, 18)
                        .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 261, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jScrollPane6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 702, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(15, 15, 15)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jButton7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jButton6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jButton6)
                        .add(jLabel6))
                    .add(jLabel2))
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(58, 58, 58)
                        .add(jButton7)
                        .add(21, 21, 21))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(jScrollPane6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Sale", jPanel2);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                        new String [] {
                "Codice Tipo", "Nome", "Quantità", "Costo", "Tipo", "Descrizione", "Locazione", "Codice Fornitore"
            }
        ,attrezzature.size()));
        jScrollPane3.setViewportView(jTable2);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(100);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(7).setPreferredWidth(120);

        jScrollPane4.setViewportView(jScrollPane3);

        jButton10.setText("Cerca");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });


        jButton11.setText("Aggiungi");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel3.setText("Elenco Attrezzature");

        jLabel4.setText("Codice :");

        jButton13.setText("Fornitori");
        
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 319, Short.MAX_VALUE)
                        .add(jLabel4)
                        .add(18, 18, 18)
                        .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 231, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 10, Short.MAX_VALUE)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jButton13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jButton10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jButton11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton10)
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4)
                    .add(jLabel3))
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(54, 54, 54)
                        .add(jButton11)
                        .add(58, 58, 58)
                        .add(jButton13)
                        .add(29, 29, 29))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Attrezzature", jPanel3);

        jButton5.setText("Logout");
        
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(684, Short.MAX_VALUE)
                .add(jButton5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 98, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(59, 59, 59))
            .add(layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(23, 23, 23)
                .add(jButton5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        for(int i=0;i<dipendenti.size();i++){
        	DatiPersonale x = dipendenti.get(i);
        	Matricola.setValueAt(x.getCodfisc(), i, 0);
        	Matricola.setValueAt(x.getNome(), i, 1);
        	Matricola.setValueAt(x.getCognome(), i, 2);
        	Matricola.setValueAt(x.getResidenza(), i, 3);
        	Matricola.setValueAt(x.getDataNascita(), i, 4);
        	Matricola.setValueAt(x.getLuogoNascita(), i, 5);
        	Matricola.setValueAt(x.getTel(), i, 6);
        	Matricola.setValueAt(x.getTipo(), i, 7);
        	Matricola.setValueAt(x.getSesso(), i, 8);
        	Matricola.setValueAt(x.getCont().toString(), i, 9);
        }

        for(int i = 0; i< sale.size();i++){
        	DatiSala x = sale.get(i);
        	jTable1.setValueAt(x.getCodiceSala(), i, 0);
        	jTable1.setValueAt(x.getDescrizione(), i, 1);
        	jTable1.setValueAt(x.getNomeSala(), i, 2);
        	jTable1.setValueAt(x.getCodiceFiscale(), i, 3);
        }
        
        for(int i = 0; i< attrezzature.size();i++){
        	DatiAttrezzature x = attrezzature.get(i);
        	jTable2.setValueAt(x.getCodiceTipo(), i, 0);
        	jTable2.setValueAt(x.getNome(), i, 1);
        	jTable2.setValueAt(x.getQuantità(), i, 2);
        	jTable2.setValueAt(x.getCosto(), i, 3);
        	jTable2.setValueAt(x.getTipo(), i, 4);
        	jTable2.setValueAt(x.getDescrizione(), i, 5);
        	jTable2.setValueAt(x.getLocazione(), i, 6);
        	jTable2.setValueAt(x.getCodiceFornitore(), i, 7);
        }
        
        pack();
        this.setTitle("FullDent - Amministratore");
        
    }

    /**
     * Metodo di supporto che inizializza i valori da inserire nelle tabelle del Form.
     */
    protected void setArrayList(){
		try {
			DBPersonale x = new DBPersonale();
			DBSala y = new DBSala();
			DBAttrezzature z = new DBAttrezzature();
			x.openConnection();
			dipendenti = x.getElenco();
			x.closeConnection();
			y.openConnection();
			sale = y.getElenco();
			y.closeConnection();
			z.openConnection();
	    	attrezzature = z.VisualizzaAttrezzature();
	    	z.closeConnection();
		} catch (SQLException e) {
			errore("Connessione con il DataBase fallita!");
		} catch (ClassNotFoundException e) {
			errore("Classe non trovata!");
		} catch (FileNotFoundException e) {
			errore("File non trovato!");
		} catch (IOException e) {
			errore("Errore di comunicazione con il file!");
		}
    	
    }
    
    /**
     * Azione eseguita alla pressione del bottone "Aggiungi" nel pannello delle attrezzature.
     * @param evt l'evento che indica la pressione del bottone.
     */
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	FormAggiungiAttrezzatura x = new FormAggiungiAttrezzatura();
    	x.setVisible(true);
    	this.setVisible(false);
    }  

    /**
     * Azione eseguita alla pressione del bottone "Ordini" nel pannello delle attrezzature.
     * @param evt l'evento che indica la pressione del bottone.
     */
   private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {                                          
	   FormElencoFornitori x = new FormElencoFornitori();
	   x.setVisible(true);
	   this.setVisible(false);
    }
    
   /**
    * Azione eseguita alla pressione del bottone "Logout".
    * @param evt l'evento che indica la pressione del bottone.
    */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
    	this.setVisible(false);
    	new FormAccessi().setVisible(true);
    }

    /**
     * Azione eseguita alla pressione del bottone "Cerca" nel pannello delle attrezzature.
     * @param evt l'evento che indica la pressione del bottone.
     */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	try{
			DBAttrezzature x = new DBAttrezzature();
			int codice = Integer.parseInt(jTextField3.getText());
			x.openConnection();
			DatiAttrezzature attrezzatura = x.getAttrezzatura(codice);
			x.closeConnection();
			if(attrezzatura != null){
				FormDatiAttrezzature form = new FormDatiAttrezzature(attrezzatura);
				form.setVisible(true);
				this.setVisible(false);
			}else errore("Attrezzatura non presente!");
			
		}catch(SQLException e){
			errore("Errore d'accesso al DataBase!");
		}catch(FileNotFoundException e){
			errore("File di accesso al DataBase non trovato!");
		}catch(IllegalArgumentException e){
			errore("Dati inseriti non corretti!");
		} catch (ClassNotFoundException e) {
			errore("Classe non trovata!");
		} catch (IOException e) {
			errore("Errore di comunicazione con il file!");
		}
    	
    }                                         

    /**
     * Azione eseguita alla pressione del bottone "Aggiungi" nel pannello delle sale.
     * @param evt l'evento che indica la pressione del bottone.
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	FormAggiungiSala x = new FormAggiungiSala();
    	x.setVisible(true);
    	this.setVisible(false);
    }                                        

    /**
     * Azione eseguita alla pressione del bottone "Cerca" nel pannello delle sale.
     * @param evt l'evento che indica la pressione del bottone.
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	try{
			DBSala x = new DBSala();
			int codice = Integer.parseInt(jTextField2.getText());
			if(codice<1000 && codice>=0){
				x.openConnection();
				DatiSala sala = x.getSala(codice);
				x.closeConnection();
				if(sala != null){
					FormDatiSale form = new FormDatiSale(sala);
					form.setVisible(true);
					this.setVisible(false);
				}else errore("Sala non presente!");
			}else errore("Codice inserito non valido!");
			
		}catch(SQLException e){
			errore("Errore d'accesso al DataBase!");
		}catch(FileNotFoundException e){
			errore("File di accesso al DataBase non trovato!");
		}catch(IllegalArgumentException e){
			errore("Dati inseriti non validi!");
		} catch (IOException e) {
			errore("Errore di comunicazione con il file!");
		} catch (ClassNotFoundException e) {
			errore("Classe non trovata!");
		}
    }  

    /**
     * Azione eseguita alla pressione del bottone "Aggiungi" nel pannello del personale.
     * @param evt l'evento che indica la pressione del bottone.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	FormAggiungiPersonale x = new FormAggiungiPersonale();
    	x.setVisible(true);
    	this.setVisible(false);
    }  

    /**
     * Azione eseguita alla pressione del bottone "Cerca" nel pannello del personale.
     * @param evt l'evento che indica la pressione del bottone.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){
		try{
			DBPersonale x = new DBPersonale();
			String codice = jTextField1.getText();
			if(codice.length()==16){
				x.openConnection();
				DatiPersonale dipendente = x.ricercaDipendente(codice);
				x.closeConnection();
				if(dipendente != null){
					FormDatiDipendente form = new FormDatiDipendente(dipendente);
					form.setVisible(true);
					this.setVisible(false);
				}else errore("Dipendente non trovato!");
			}else errore("Codice inserito non valido!");
			
		}catch(SQLException e){
			errore("Errore d'accesso al DataBase!");
		}catch(FileNotFoundException e){
			errore("File di accesso al DataBase non trovato!");
		} catch (ClassNotFoundException e) {
			errore("Classe non trovata!");
		} catch (IOException e) {
			errore("Errore di comunicazione con il file!");
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
                                           
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAmministratore().setVisible(true);
            }
        });
    }
    
    /** The attrezzature. */
    private ArrayList<DatiAttrezzature> attrezzature;
    
    /** The sale. */
    private ArrayList<DatiSala> sale;
    
    /** The dipendenti. */
    private ArrayList<DatiPersonale> dipendenti;
    
    /** The Matricola. */
    private javax.swing.JTable Matricola;
    
    /** The j button1. */
    private javax.swing.JButton jButton1;
    
    /** The j button10. */
    private javax.swing.JButton jButton10;
    
    /** The j button11. */
    private javax.swing.JButton jButton11;
    
    /** The j button13. */
    private javax.swing.JButton jButton13;
    
    /** The j button2. */
    private javax.swing.JButton jButton2;
    
    /** The j button5. */
    private javax.swing.JButton jButton5;
    
    /** The j button6. */
    private javax.swing.JButton jButton6;
    
    /** The j button7. */
    private javax.swing.JButton jButton7;
    
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
    
    /** The j panel1. */
    private javax.swing.JPanel jPanel1;
    
    /** The j panel2. */
    private javax.swing.JPanel jPanel2;
    
    /** The j panel3. */
    private javax.swing.JPanel jPanel3;
    
    /** The j scroll pane1. */
    private javax.swing.JScrollPane jScrollPane1;
    
    /** The j scroll pane2. */
    private javax.swing.JScrollPane jScrollPane2;
    
    /** The j scroll pane3. */
    private javax.swing.JScrollPane jScrollPane3;
    
    /** The j scroll pane4. */
    private javax.swing.JScrollPane jScrollPane4;
    
    /** The j scroll pane5. */
    private javax.swing.JScrollPane jScrollPane5;
    
    /** The j scroll pane6. */
    private javax.swing.JScrollPane jScrollPane6;
    
    /** The j tabbed pane1. */
    private javax.swing.JTabbedPane jTabbedPane1;
    
    /** The j table1. */
    private javax.swing.JTable jTable1;
    
    /** The j table2. */
    private javax.swing.JTable jTable2;
    
    /** The j text field1. */
    private javax.swing.JTextField jTextField1;
    
    /** The j text field2. */
    private javax.swing.JTextField jTextField2;
    
    /** The j text field3. */
    private javax.swing.JTextField jTextField3;
    
}
