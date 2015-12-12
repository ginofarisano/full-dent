package guiCalendario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import gestioneCalendario.DBCalendario;
import gestioneCalendario.Data;
import gestioneCalendario.DatiAppuntamento;
import guiSegretaria.FormCalendario;

// TODO: Auto-generated Javadoc
/**
 * Classe che specifica il form di visualizza richiami riferito ad appuntamenti. 
 * @author G.Valitutto
 */
public class FormVisualizzaRichiami extends javax.swing.JFrame {

    /** 
     * Crea  un nuovo Form.
     */
    public FormVisualizzaRichiami() {
        try{
        	Date data = new Date();
    		int mese = data.getMonth()+1;
    		int giorno = data.getDate();
    		if(mese<10){
    			if(giorno < 10)
    				tempo = afterDay("0"+data.getDate()+"/0"+(data.getMonth()+1)+"/"+(data.getYear()+1900));
    			else tempo = afterDay(data.getDate()+"/0"+(data.getMonth()+1)+"/"+(data.getYear()+1900));
    		}else tempo = afterDay(data.getDate()+"/"+(data.getMonth()+1)+"/"+(data.getYear()+1900));
        	DBCalendario x = new DBCalendario();
        	x.openConnection();
        	x.initRichiami();
        	richiami = x.visualizzaRichiamiPeriodici();
        	x.closeConnection();
        }catch(SQLException e){
			errore("Errore d'accesso al DataBase!");
		}catch(FileNotFoundException e){
			errore("File di accesso al DataBase non trovato!");
		} catch (ClassNotFoundException e) {
			errore("Classe non trovata!");
		} catch (IOException e) {
			errore("Errore di comunicazione con il file!");
		}
    	initComponents();
    }

    /**
     * Metodo di supporto che inizializza le componenti del Frame.
     */
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    new String [] {
                "TipoServizio", "NomePaziente", "CognomePaziente", "NomeMedico", "CognomeMedico", "Ora"
            },richiami.size()));
        
        jScrollPane2.setViewportView(jTable1);

        jScrollPane1.setViewportView(jScrollPane2);

        jButton1.setText("Conferma");
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
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(28, 28, 28)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Visualizza Richiami");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        for(int i = 0; i < richiami.size(); i++){
        	DatiAppuntamento x = richiami.get(i);
        	jTable1.setValueAt(x.getTipoServizio(), i, 0);
        	jTable1.setValueAt(x.getNomePaziente(), i, 1);
        	jTable1.setValueAt(x.getCognomePaziente(), i, 2);
        	jTable1.setValueAt(x.getNomeMedico(), i, 3);
        	jTable1.setValueAt(x.getCognomeMedico(), i, 4);
        	jTable1.setValueAt(x.getDataAppuntamento().getOra(), i, 5);
        }
        
        pack();
        this.setTitle("FullDent - Lista Richiami");
    }

    /**
     * Azione eseguita alla pressione del bottone "Conferma".
     * @param evt il ricevitore d'evento.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	try{ 
    		int ind = jTable1.getSelectedRow();
    		String ts = (String) jTable1.getValueAt(ind, 0);
    		String ora = (String) jTable1.getValueAt(ind, 5);
    		Data data = new Data(tempo,ora);
    		DBCalendario x = new DBCalendario();
    		x.openConnection();
    		DatiAppuntamento y = x.ricercaAppuntamento(ts, data);
    		x.effettuaRichiamo(y);
    		richiami.remove(ind);
    		x.closeConnection();
    		successo();
    		jTable1.setVisible(false);
    		refreshTabella();
    		jTable1.setVisible(true);
    	}catch(ArrayIndexOutOfBoundsException e){
    		errore("Seleziona una riga!");
    	} catch (SQLException e) {
			errore("Errore di connesione con il DataBase!");
		} catch (ClassNotFoundException e) {
			errore("Classe non trovata!");
		} catch (FileNotFoundException e) {
			errore("File contenente i dati di accesso al DataBase non trovato!");
		} catch (IOException e) {
			errore("Errore di comunicazione con il file!");
		}
    	
    }                                        

    /**
     * Azione eseguita alla pressione del bottone "Annulla".
     * @param evt il ricevitore d'evento.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	this.setVisible(false);
    	new FormCalendario().setVisible(true);
    }                                        

    /**
     * Metodo di supporto che refresha la tabella dei richiami.
     */
    private void refreshTabella(){
    	jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new String [] {
            "TipoServizio", "NomePaziente", "CognomePaziente", "NomeMedico", "CognomeMedico", "Ora"
        },richiami.size()));
    	for(int i = 0; i < richiami.size(); i++){
        	DatiAppuntamento x = richiami.get(i);
        	jTable1.setValueAt(x.getTipoServizio(), i, 0);
        	jTable1.setValueAt(x.getNomePaziente(), i, 1);
        	jTable1.setValueAt(x.getCognomePaziente(), i, 2);
        	jTable1.setValueAt(x.getNomeMedico(), i, 3);
        	jTable1.setValueAt(x.getCognomeMedico(), i, 4);
        	jTable1.setValueAt(x.getDataAppuntamento().getOra(), i, 5);
        }
    	
    }
    
	/**
	 * Metodo di supporto che restituisce la data successiva a quella data in input.
	 * @param time la data da modificare.
	 * @return la data successiva.
	 */
	protected String afterDay(String time) {
		String tempo = "";
		int giorno = Integer.parseInt(time.substring(0,2));
		int mese = Integer.parseInt(time.substring(3,5));
		int anno = Integer.parseInt(time.substring(6));
		int flag = 0;
		if((((anno%4 == 0) || (anno%400)==0) && (anno%100 != 0)) && mese == 2 && giorno == 29){
			tempo="01/"+((mese+1)%12)+"/"+anno;
			flag = 1;
		}
		
		if(((mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8 || mese == 10 || mese == 12) && giorno == 31)
				|| ((mese == 4 || mese == 6 || mese == 9 || mese == 11) && giorno == 30)
				|| (mese == 2 && giorno == 28)){
			if(mese == 12)
				anno++;
			tempo="01/"+((mese+1)%12)+"/"+anno;
			flag = 1;
		}
		if(flag == 0)
			if(mese<10){
			if(giorno < 10)
				tempo="0"+(giorno+1)+"/0"+(mese)+"/"+anno;
				else tempo=""+(giorno+1)+"/0"+(mese)+"/"+anno;
			}else tempo=""+(giorno+1)+"/"+(mese)+"/"+anno;
		return tempo;
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
    
    /** The richiami. */
    private ArrayList<DatiAppuntamento> richiami;
    
    /** The tempo. */
    private String tempo;
    
    /** The j button1. */
    private javax.swing.JButton jButton1;
    
    /** The j button2. */
    private javax.swing.JButton jButton2;
    
    /** The j label1. */
    private javax.swing.JLabel jLabel1;
    
    /** The j panel1. */
    private javax.swing.JPanel jPanel1;
    
    /** The j scroll pane1. */
    private javax.swing.JScrollPane jScrollPane1;
    
    /** The j scroll pane2. */
    private javax.swing.JScrollPane jScrollPane2;
    
    /** The j table1. */
    private javax.swing.JTable jTable1;
   
}


