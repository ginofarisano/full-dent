package guiSegretaria;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.Costanti;
import bean.RiepilogoStorico;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


/**
 * Classe che mostra la lista dello storico delle operazioni.
 *
 * @author V.Esposito
 */



public class VisualizzaStorico implements MouseListener {

	
	private GuiModificaPaziente p;
	private JTable table;
	MatteBorder border = new MatteBorder(0,0,1,0, Color.gray);
	private DefaultTableModel modelTab;
	private JDialog d;
	private ActionListener actEsci;
	private MouseListener aggiornaStorico;
	
	public VisualizzaStorico(GuiModificaPaziente p){
		this.p=p;
	}
	
	/**
	 * Metodo che mostra l'interfaccia di visualizzazione storico.
	 */

	public void mouseClicked(MouseEvent arg0) {
		
		
		d=new JDialog(new JFrame(),true);
		d.setTitle("Storico di "+p.getNomeUtenteSelezionato()+" "+p.getCognomeUtenteSelezionato());
		d.setSize(800, 500);
		d.setLocation (300,150);
		actEsci=new Esci();
		aggiornaStorico=new aggStorico();
		
		d.add(pannelloRicerca());
		d.setVisible(true);
	}

	/**
	 * Metodo che crea il frame con la lista dello storico.
	 */

	public JPanel pannelloRicerca(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
	    panel.setBorder(border);
		
		JPanel ric=new JPanel();
		ric.setLayout(new BorderLayout());
		
	
	 
		    Object[] columnHeaders = {"", "Data","Ora","Tipo", "Dottore","Note","Pagato","cod"};
		    
		 	modelTab=new DefaultTableModel(null,columnHeaders) {
				
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int col) {
					return false;
				}
			};
		        
		 	
			table = new JTable(modelTab) {

	            private static final long serialVersionUID = 1L;
	            @Override
	            public Class getColumnClass(int column) {
	                switch (column) {
	                    case 0:
	                        return String.class;
	                    case 1:
	                        return String.class;
	                    case 2:
	                        return String.class;
	                    case 3:
	                        return String.class;
	                    case 4:
	                        return String.class;
	                    case 5:
	                        return String.class;
	                    case 6:
	                        return Boolean.class;
	                    default:
	                        return Boolean.class;
	                }
	            }
	        };
	        table.addMouseListener(aggiornaStorico);
	        getStorico();
	       
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
			
	     JPanel pan=new JPanel();
	     JButton b=new JButton("Esci");
	     b.addActionListener(actEsci);
	     pan.add(b);
	     panel.add(pan,BorderLayout.SOUTH);
			
			 
	  return panel;
	}
	
	/**
	 * Classe che modifica il pagamento e le note nello storico.
	 */

	public class aggStorico implements MouseListener{
    	public void mouseClicked(MouseEvent arg0) {
		
			if(((int)table.getSelectedColumn())==6){
				int choice = JOptionPane.showOptionDialog(null, 
					      "Vuoi modificare il pagamento?", 
					      "Conferma", 
					      JOptionPane.YES_NO_OPTION, 
					      JOptionPane.QUESTION_MESSAGE, 
					      null, null, null);

				if(choice==JOptionPane.YES_OPTION){
					
					modificaPagatoStorico((String)table.getValueAt(table.getSelectedRow(), 7),(boolean)table.getValueAt(table.getSelectedRow(), 6));
				}
				
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
	 * Classe che modifica il pagamento nello storico.
	 *
	 * @param codice the codice
	 * @param stato the stato
	 */

	public void modificaPagatoStorico(String codice,boolean stato){
		
		  	String pagato="",note="null";
			
			if(stato)
				pagato="NO";
			else 
				pagato="SI";

			   
			    Client client = Client.create();
			 
				WebResource webResource = client.resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/modificaPagatoStorico/segret/abcd");
					 			 
				String input = "{\"idPrenotazione\":\""+codice+"\",\"pagato\":\""+pagato+"\",\"note\":\""+note+"\"}";                

				ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
				
				
				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}			
		    
		    while (table.getRowCount() > 0) 
               modelTab.removeRow(0);
		    getStorico();

	}
	
	/**
	 * Metodo che ritorna lo storico di un paziente.
	 *
	 * @return the storico
	 */
	public void getStorico(){
		
			boolean pagato=false;
		    
			try{
				 
				 Client client = Client.create();	 
					
					WebResource webResource = client
					   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaRiepilogoServizi/segret/abcd/"+p.getCodiceUtenteSelezionato());
					
					ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
					
					
					if (response.getStatus() != 200) {
					   throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
					}
					
					String output = response.getEntity(String.class);
					
					JSONArray array=new JSONArray(output);
					JSONObject object;
					ArrayList<RiepilogoStorico>u=new ArrayList<RiepilogoStorico>();
					
					
					for(int z=0;z<array.length();z++){
						object=array.getJSONObject(z);
						
						RiepilogoStorico a=new RiepilogoStorico();
						
						a.setData(object.getString("data"));
						a.setOra(object.getString("ora"));
						a.setIdPrenotazione(object.getString("idPrenotazione"));
						a.setNote(object.getString("note"));
						a.setPagato(object.getString("pagato"));
						a.setPersCognome(object.getString("persCognome"));
						a.setPersNome(object.getString("persNome"));
						a.setPrestnome(object.getString("prestnome"));
						
						u.add(a);
					}
					
					
				    	 for(int j=0;j<u.size();j++) {
				    		 if(u.get(j).getPagato().equals("SI"))
				    			  	pagato=true;
				    		  else
				    			  	pagato=false;
				    		 
				    		 
					    		 
				    		 Object[] rowData = {
					                 "",u.get(j).getData(), u.get(j).getOra(), u.get(j).getPrestnome(),
					                 u.get(j).getPersNome()+" "+u.get(j).getPersCognome(), u.get(j).getNote(),
					                 pagato,u.get(j).getIdPrenotazione()
					               };

				            	modelTab.addRow(rowData);		 
				    	  }
				    	  
			}catch (JSONException e) {
				e.printStackTrace();
			}

	}
	
	/**
	 * Classe che esce dalla schermata di storico.
	 */
	public class Esci implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			d.dispose();
			
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
