package guiSegretaria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.Costanti;
import bean.Utente;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


/**
 * Classe che crea il form per modificare il paziente.
 *
 * @author V.Esposito
 */


public class GuiModificaPaziente implements ActionListener {

	
	private JDialog dia;
	private JTable table;
	
	private JTabbedPane tab;
	
	MatteBorder border = new MatteBorder(0,0,1,0, Color.gray);
    
    private JTextField cognFieAgg,nomeFieAgg,cognFie,nomeFie,indFie,citFie,
    capFie,mailFie,casaFie,uffFie,uffCell,scoFie,ivaFie,codCardFie,puntiCardFie;
	
	private DefaultTableModel modelTab;
	
	private MouseListener actListTab,actStorico;
	
	private ActionListener act;
	
    private String tipo;
	
    private Costanti c=new Costanti();
	/**
	 * Instanzia nuova  gui modifica paziente.
	 *
	 * @param asd the asd
	 */
	public GuiModificaPaziente(String asd){
		tipo=asd;
	}
	
	/**
	 * Metodo che crea l'interfaccia per la modifica.
	 */
	public void actionPerformed(ActionEvent e) {
		 
		
		dia=new JDialog(new JFrame(),true);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		int screenWidth = (int) screen.getWidth();
		int screenHeight = (int) screen.getHeight()-35;
	
		dia.getContentPane().setBackground(new Color(18,26,60));
	    dia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	dia.setTitle("Lista Pazienti");
	
		dia.setSize(screenWidth, screenHeight);	
	
		tab = new JTabbedPane(JTabbedPane.TOP);
		dia.setLayout(new BorderLayout());
			
		actListTab= new ModificaPaziente(this);
		act= new RicercaPaziente(this);
		actStorico=new VisualizzaStorico(this);
		
		pannelloTabPane();
		dia.revalidate();

		dia.setVisible(true);
	}
	
	/**
	 * Metodo che ritorna il ModelTab.
	 *
	 * @return the model table
	 */
	public DefaultTableModel getModelTable(){
		return modelTab;
	}
	
	/**
	 * Metodo che ritorna JTable.
	 *
	 * @return the table
	 */
	public JTable getTable(){
		return table;
	}
	
	/**
	 * Metodo che ritorna il nome da ricercare.
	 *
	 * @return il nome ricerca
	 */
	public String getNomeRicerca(){
		return nomeFie.getText();
	}
	
	/**
	 * Metodo che ritorna il cognome da ricercare.
	 *
	 * @return il cognome ricerca
	 */
	public String getCognomeRicerca(){
		return cognFie.getText();
	}
	
	/**
	 * Metodo che ritorna il codice fiscale dell'utente selezionato.
	 *
	 * @return il codice utente selezionato
	 */
	public String getCodiceUtenteSelezionato(){
		return (String)table.getValueAt((int)table.getSelectedRow(), 6);
	}

	/**
	 * Metodo che ritorna il nome dell'utente selezionato.
	 *
	 * @return il nome utente selezionato
	 */
	
	public String getNomeUtenteSelezionato(){
		return (String)table.getValueAt((int)table.getSelectedRow(), 1);
	}
	
	/**
	 * Metodo che ritorna il cognome dell'utente selezionato.
	 *
	 * @return il cognome utente selezionato
	 */
	
	public String getCognomeUtenteSelezionato(){
		return (String)table.getValueAt((int)table.getSelectedRow(), 2);
	}
	
	/**
	 * Metodo che disegna il frame con la lista dei pazienti.
	 */
	
	public void pannelloTabPane(){
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.setFocusable(false);
        tab.setBorder(border);

        
		tab.addTab("Lista Pazienti", null, pannelloRicerca(), null);	
	
			
			tab.addChangeListener(new ChangeListener() {

                public void stateChanged(ChangeEvent e) {
                    if (e.getSource() instanceof JTabbedPane) {
                        JTabbedPane pane = (JTabbedPane) e.getSource();
                    }}        
            });
			
		 dia.add(tab);

	}
	
	/**
	 * Metodo che crea il pannello di ricerca.
	 *
	 * @return il j panel
	 */
	
	public JPanel pannelloRicerca(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
	    panel.setBorder(border);
		
		JPanel ric=new JPanel();
		ric.setLayout(new BorderLayout());
		
		    JPanel nPa=new JPanel();
			JLabel cognome = new JLabel("Cognome");
			
			
			cognFie = new JTextField();
			cognFie.setColumns(15);
			

			JLabel nome = new JLabel("Nome");
			
			nomeFie = new JTextField();
			nomeFie.setColumns(15);
				
			nPa.add(cognome);
			nPa.add(cognFie);
			nPa.add(nome);
			nPa.add(nomeFie);

			ric.add(nPa,BorderLayout.CENTER);
	
			JPanel panelRic=new JPanel();
			panelRic.setLayout(new BorderLayout());
			
			JButton ricerca=new JButton("Ricerca");
	        ricerca.addActionListener(act);
			ricerca.setFocusable(false);
	 
			JLabel la=new JLabel("     ");
			JLabel la2=new JLabel("     ");
	
			
	
			panelRic.add(ricerca,BorderLayout.WEST);
			panelRic.add(la,BorderLayout.CENTER);
			panelRic.add(la2,BorderLayout.SOUTH);
			
			ric.add(panelRic,BorderLayout.EAST);
		
			panel.add(ric,BorderLayout.NORTH);	

	 
		    Object[] columnHeaders = {"", "Nome","Cognome", "Indirizzo","Telefono","Email","cod"};
		    
		 	modelTab=new DefaultTableModel(null,columnHeaders) {
				
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int col) {
					return false;
				}
			};
		     getPazienti();
		        
		 	
	        table = new JTable(modelTab);
	       
	        if(tipo.equals("storico"))
	        	table.addMouseListener(actStorico);
	        else
	            table.addMouseListener(actListTab);
	       
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
	        table.getTableHeader().setReorderingAllowed(false);

	        table.getColumn("").setWidth(50);
	        table.getColumn("").setMinWidth(50);
	        table.getColumn("").setMaxWidth(50);
	        
	        table.getColumn("cod").setWidth(0);
	        table.getColumn("cod").setMinWidth(0);
	        table.getColumn("cod").setMaxWidth(0);
	        
	        
	        table.getColumnModel().getColumn(1).setResizable(false);
	        table.getColumnModel().getColumn(2).setResizable(false);
	        table.getColumnModel().getColumn(3).setResizable(false);
	        table.getColumnModel().getColumn(4).setResizable(false);
	
	        table.setRowHeight(40);
	        table.setFillsViewportHeight(true);
	        
	       JScrollPane sp=new JScrollPane(table);
	       sp.setBorder(border);

	       
	     panel.add(sp,BorderLayout.CENTER);	        
			
			
			 
	  return panel;
	}

	/**
	 * Metodo che ritorna la lista dei clienti.
	 */
	
	public void getPazienti(){
				Client client = Client.create();	 
				String cognome="null";
				String nome="null";
				WebResource webResource = client
				   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaClienti/segret/abcd/"+cognome+"/"+nome);
				
				ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
				
				
				if (response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
				}
				
				String output = response.getEntity(String.class);
				
				try {
					JSONArray array=new JSONArray(output);
					JSONObject object;
					ArrayList<Utente>u=new ArrayList<Utente>();
					
					
					for(int i=0;i<array.length();i++){
						object=array.getJSONObject(i);
						Utente utente=new Utente();
						utente.setNome(object.getString("nome"));
						utente.setCognome(object.getString("cognome"));
						utente.setCodiceFiscale(object.getString("codiceFiscale"));
						utente.setEmail(object.getString("email"));
						utente.setIndirizzo(object.getString("indirizzo"));
						utente.setTelefono(object.getString("telefono"));
						u.add(utente);
					}
					
					while (modelTab.getRowCount() > 0) 
						modelTab.removeRow(0);
						
		        	for(int j=0;j<u.size();j++){
		        		
		            	Object[] rowData = {
		                 "",u.get(j).getNome(), u.get(j).getCognome(), u.get(j).getIndirizzo(),
		                u.get(j).getTelefono(), u.get(j).getEmail(),u.get(j).getCodiceFiscale()
		               };
           
		            	modelTab.addRow(rowData);
		        		
		        		
		        	}
		     
		        		
				} catch (JSONException e) {
					e.printStackTrace();
				}
		}
	
	

}
