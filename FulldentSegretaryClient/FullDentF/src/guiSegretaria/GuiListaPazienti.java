package guiSegretaria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
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
 * Classe che mostra la lista di tutti i pazienti presenti nel sistema.
 * @author V.Esposito
 */

public class GuiListaPazienti implements KeyListener {

	private JDialog dia;
	private JTable table;
	private JTabbedPane tab;
	MatteBorder border = new MatteBorder(0,0,1,0, Color.gray);
	private DefaultTableModel modelTab;	
	private MouseListener actListTab;
	private FormCalendario cal;
	private ActionListener actChiudi,act;
	private JTextField cognFie,nomeFie;
	private Costanti c=new Costanti();
	/**
	 * Istanzia una nuova gui lista pazienti.
	 *
	 * @param <cal><Form calendario>
	 */
	public GuiListaPazienti(FormCalendario cal){
		this.cal=cal;
	}
	

	/**
	 * Classe che ritorna la classe FormCalendario.
	 *
	 * @return the form
	 */
	public FormCalendario getForm(){
		return cal;
	}
	

	/**
	 * Metodo che apre il frame con la lista dei pazienti.
	 */
	public void keyPressed(KeyEvent arg0) {
		
			if(arg0.getKeyCode()==KeyEvent.VK_ENTER ){
				
				dia=new JDialog(new JFrame(),true);
				act= new RicercaPaziente();
				dia.setSize(930, 570);	
			
	
				dia.getContentPane().setBackground(new Color(18,26,60));
			    dia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dia.setTitle("Seleziona Paziente");
	
				actChiudi=new ChiudiFinestra();
			
				tab = new JTabbedPane(JTabbedPane.TOP);
				dia.setLayout(new BorderLayout());
					
				actListTab = new AggiungiPaziente(this);
		     	pannelloTabPane();
				dia.revalidate();
				dia.setVisible(true);
			
			}
		}
	

	/**
	 * Metodo che crea la grafica del frame con la lista dei pazienti e la ricerca.
	 */
	public void pannelloTabPane(){
		
		JPanel ric=new JPanel();
		ric.setLayout(new BorderLayout());
		
		    JPanel nPa=new JPanel();
			JLabel cognome = new JLabel("Cognome");
			
			
			 cognFie = new JTextField();
			cognFie.setColumns(15);
			

			JLabel nome = new JLabel("Nome");
			
			 nomeFie = new JTextField();
			nomeFie.setColumns(15);
			
			JButton b=new JButton("Ricerca");
			b.addActionListener(act);
				
			nPa.add(cognome);
			nPa.add(cognFie);
			nPa.add(nome);
			nPa.add(nomeFie);
			nPa.add(b);
			
			dia.add(nPa,BorderLayout.NORTH);
		
		
		 Object[] columnHeaders = {"", "Nome","Cognome", "Indirizzo","Telefono","Email","cod"};
		    
		 	modelTab=new DefaultTableModel(null,columnHeaders) {
				
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int col) {
					return false;
				}
			};
			getPazienti();
	        table = new JTable(modelTab);
	       
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

	       
	    dia.add(sp,BorderLayout.CENTER);	
	    
	    JPanel panel=new JPanel();
	    JButton butt=new JButton("Chiudi");
	    butt.addActionListener(actChiudi);
	    panel.add(butt);
	    dia.add(panel,BorderLayout.SOUTH);
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}


	/**
	 * Metodo che ritorna tutti i pazienti disponibili.
	 *
	 * @return pazienti
	 */
	public void getPazienti(){
		String cognome="";
		String nome="null";
		
		if(cal.getCognomePaziente().equals(""))
			cognome="null";
		else
			cognome=cal.getCognomePaziente();
		
		Client client = Client.create();	 
		WebResource webResource = client
		   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaClienti/segret/abcd/"+cognome+"/"+nome);
		System.out.println(cal.getCognomePaziente());
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

	

	/**
	 * Classe che aggiunge il nome e il cognome di una paziente nell'aria di ricerca.
	 */
	public class AggiungiPaziente implements MouseListener{

		
		private GuiListaPazienti p;
		
		public AggiungiPaziente(GuiListaPazienti p){
			this.p=p;
		}

		public void mouseClicked(MouseEvent arg0) {
			
			if(arg0.getClickCount()==2){
				
				int index = table.getSelectedRow();
				String codiceFisc = table.getModel().getValueAt(index, 6).toString();
				String nome = table.getModel().getValueAt(index, 1).toString();
				String cognome = table.getModel().getValueAt(index, 2).toString();
				
				p.getForm().setNome(nome+" "+cognome, codiceFisc);
				
				
					dia.dispose();
				
			}
		}
	public void mouseEntered(MouseEvent arg0) {
			
		}

		public void mouseExited(MouseEvent arg0) {
			
		}

		public void mousePressed(MouseEvent arg0) {
			
		}

		public void mouseReleased(MouseEvent arg0) {
			
		}
		
	}
	
	/**
	 * Classe che chiude il frame di ricerca.
	 */
	public class ChiudiFinestra implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {

			dia.dispose();
		}
		
		
	}
	
	/**
	 * Classe che ricerca un paziente.
	 */
	public class RicercaPaziente implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		
			String nome=nomeFie.getText();
			String cognome=cognFie.getText();
			
			Client client = Client.create();	 
			
			if(nome.equals(""))
				nome="null";
			if(cognome.equals(""))
				cognome="null";
			
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
}
