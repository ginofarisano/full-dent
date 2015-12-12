package guiCalendario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import gestioneCalendario.DBCalendario;
import gestioneCalendario.DatiAppuntamento;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.WindowConstants;


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
 * Interfaccia grafica per la visualizzazione dei dati di un appuntamento.
 * @author 
 *
 */
public class FormDatiAppuntamento extends javax.swing.JFrame {
	
	/** The appuntamento. */
	private DatiAppuntamento appuntamento;
	
	/** The y. */
	private ArrayList<DatiAppuntamento> y;
	
	/** The tipo servizio. */
	private JLabel tipoServizio;
	
	/** The ts. */
	private JLabel ts;
	
	/** The nome paziente. */
	private JLabel nomePaziente;
	
	/** The dt. */
	private JLabel dt;
	
	/** The elimina. */
	private JButton elimina;
	
	/** The ok. */
	private JButton ok;
	
	/** The or. */
	private JLabel or;
	
	/** The ora. */
	private JLabel ora;
	
	/** The j label2. */
	private JLabel jLabel2;
	
	/** The data. */
	private JLabel data;
	
	/** The cognome medico. */
	private JLabel cognomeMedico;
	
	/** The j label1. */
	private JLabel jLabel1;
	
	/** The nome medico. */
	private JLabel nomeMedico;
	
	/** The nm. */
	private JLabel nm;
	
	/** The cognome paziente. */
	private JLabel cognomePaziente;
	
	/** The np. */
	private JLabel np;

	/**
	 * Crea un nuovo From.
	 * @param x i dati dell'appuntamento da visualizzare.
	 */
	public FormDatiAppuntamento(DatiAppuntamento x) {
		super();
		appuntamento = x;
		try{
			DBCalendario c = new DBCalendario();
			c.openConnection();
			y = c.visualizza(appuntamento.getTipoServizio(),appuntamento.getDataAppuntamento());
			c.closeConnection();
		}catch(SQLException e){
			errore("Errore d'accesso al DataBase!");
		}catch(FileNotFoundException e){
			errore("File di accesso al DataBase non trovato!");
		} catch (ClassNotFoundException e) {
			errore("Classe non trovata!");
		} catch (IOException e) {
			errore("Errore di comunicazione con il file!");
		}
		initGUI();
	}
	
	/**
	 * Metodo di supporto che inizializza le componenti del Frame. 
	 */
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				tipoServizio = new JLabel();
				getContentPane().add(tipoServizio);
				tipoServizio.setText("Tipo Servizio:");
				tipoServizio.setBounds(12, 25, 83, 15);
			}
			{
				ts = new JLabel();
				getContentPane().add(ts);
				ts.setText(appuntamento.getTipoServizio());
				ts.setBounds(132, 25, 98, 15);
			}
			{
				nomePaziente = new JLabel();
				getContentPane().add(nomePaziente);
				nomePaziente.setText("Nome Paziente:");
				nomePaziente.setBounds(12, 57, 89, 14);
			}
			{
				np = new JLabel();
				getContentPane().add(np);
				np.setText(appuntamento.getNomePaziente());
				np.setBounds(132, 56, 98, 14);
			}
			{
				cognomePaziente = new JLabel();
				getContentPane().add(cognomePaziente);
				cognomePaziente.setText("Cognome Paziente:");
				cognomePaziente.setBounds(12, 83, 114, 14);
			}
			{
				nm = new JLabel();
				getContentPane().add(nm);
				nm.setText(appuntamento.getCognomePaziente());
				nm.setBounds(132, 83, 104, 14);
			}
			{
				nomeMedico = new JLabel();
				getContentPane().add(nomeMedico);
				nomeMedico.setText("Nome Medico:");
				nomeMedico.setBounds(12, 109, 98, 14);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText(appuntamento.getNomeMedico());
				jLabel1.setBounds(132, 109, 98, 14);
			}
			{
				cognomeMedico = new JLabel();
				getContentPane().add(cognomeMedico);
				cognomeMedico.setText("Cognome Medico:");
				cognomeMedico.setBounds(12, 141, 108, 14);
			}
			{
				data = new JLabel();
				getContentPane().add(data);
				data.setText(appuntamento.getCognomeMedico());
				data.setBounds(132, 141, 98, 14);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Data: ");
				jLabel2.setBounds(236, 20, 33, 14);
			}
			{
				dt = new JLabel();
				getContentPane().add(dt);
				dt.setText(appuntamento.getDataAppuntamento().getData());
				dt.setBounds(281, 20, 69, 14);
			}
			{
				ora = new JLabel();
				getContentPane().add(ora);
				ora.setText("Ora:");
				ora.setBounds(236, 51, 33, 14);
			}
			{
				or = new JLabel();
				getContentPane().add(or);
				or.setText(appuntamento.getDataAppuntamento().getOra());
				or.setBounds(281, 51, 69, 14);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("Ok");
				ok.setBounds(72, 190, 60, 21);
				ok.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                jButton1ActionPerformed(evt);
		            }
		        });
			}
			{
				elimina = new JButton();
				getContentPane().add(elimina);
				elimina.setText("Rimuovi");
				elimina.setBounds(203, 190, 94, 21);
				elimina.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                jButton2ActionPerformed(evt);
		            }
		        });
			}
			pack();
			this.setTitle("FullDent - Appuntamento");
			this.setSize(500, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Azione eseguita alla pressione del bottone "Ok".
	 * @param evt il ricevitore d'evento.
	 */
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {  
		this.setVisible(false);
		new FormVisualizzaAppuntamenti(y).setVisible(true);
	}
	
    /**
     * Azione eseguita alla pressione del bottone "Rimuovi".
     * @param evt il ricevitore d'evento.
     */
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {  
		try{
			DBCalendario x = new DBCalendario();
			x.openConnection();
			x.eliminaAppuntamento(appuntamento);
			y = x.visualizza(appuntamento.getTipoServizio(), appuntamento.getDataAppuntamento());
			x.closeConnection();
			successo();
			this.setVisible(false);
			new FormVisualizzaAppuntamenti(y).setVisible(true);
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
    
}
