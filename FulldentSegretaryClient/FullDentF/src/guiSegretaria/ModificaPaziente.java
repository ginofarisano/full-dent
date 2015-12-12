package guiSegretaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import util.ControlloCodiceFiscale;
import util.ConvalidaMail;
import util.Costanti;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import bean.Utente;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ModificaPaziente implements MouseListener {

	
	private JDialog dia;
	private JTextField email,Telefono,Indirizzo;
	
	private JButton Resetta,Modifica,esci;
	private JLabel codFis,mail,tel,ind,cogn,nome,cod,Nome,Cognome;
	private ActionListener modificaPaziente,esciModifica,resettaModifica;
	
	private GuiModificaPaziente p;
	
	/**
	 * Classe che modifica un paziente.
	 *
	 * @author V.Esposito
	 * @param p the p
	 */

	public ModificaPaziente(GuiModificaPaziente p){
		this.p=p;
	}
	
	public ModificaPaziente(){
		
	}
	
	/**
	 * Metodo che disegna l'interfaccia per la modifica di un cliente.
	 */

	public void mouseClicked(MouseEvent arg0) {
		dia=new JDialog(new JFrame(),true);	
	
		dia.setTitle("Modifica Paziente");
		dia.setAlwaysOnTop(true);
	    dia.setBounds(480, 290, 480, 170);
		modificaPaziente=new EffettuaModifichePaziente(null, null, null, null, null, null);
		esciModifica=new esci();
		resettaModifica=new resetta();
		try {
			{
				dia.setLayout(null);
				{
					cod = new JLabel();
					cod.setText(""+p.getTable().getValueAt(p.getTable().getSelectedRow(), 6));
					dia.add(cod);
					cod.setBounds(157, 25, 316, 23);
				}
				{
					Nome = new JLabel();
					Nome.setText(""+p.getTable().getValueAt(p.getTable().getSelectedRow(), 1));
					dia.add(Nome);
					Nome.setBounds(159, 73, 120, 23);
				}
				{
					Cognome = new JLabel();
					Cognome.setText(""+p.getTable().getValueAt(p.getTable().getSelectedRow(), 2));
					dia.add(Cognome);
					Cognome.setBounds(355, 73, 119, 23);
				}
				{
					Indirizzo = new JTextField();
					Indirizzo.setText(""+p.getTable().getValueAt(p.getTable().getSelectedRow(), 3));
					dia.add(Indirizzo);
					Indirizzo.setBounds(160, 118, 120, 23);
				}
				{
					Telefono = new JTextField();
					Telefono.setText(""+p.getTable().getValueAt(p.getTable().getSelectedRow(), 4));
					dia.add(Telefono);
					Telefono.setBounds(356, 122, 119, 23);
				}
				{
					email = new JTextField();
					email.setText(""+p.getTable().getValueAt(p.getTable().getSelectedRow(), 5));
					dia.add(email);
					email.setBounds(159, 169, 316, 23);
				}
				{
					Modifica = new JButton();
					Modifica.addActionListener(modificaPaziente);
					dia.add(Modifica);
					Modifica.setText("Modifica");
					Modifica.setBounds(62, 218, 86, 23);
				}
				{
					Resetta = new JButton();
					Resetta.addActionListener(resettaModifica);
					dia.add(Resetta);
					Resetta.setText("Resetta");
					Resetta.setBounds(234, 218, 86, 23);
				}
				{
					codFis = new JLabel();
					dia.add(codFis);
					codFis.setText("Codice Fiscale");
					codFis.setBounds(62, 28, 103, 16);
				}
				{
					nome = new JLabel();
					dia.add(nome);
					nome.setText("Nome");
					nome.setBounds(65, 76, 54, 16);
				}
				{
					cogn = new JLabel();
					dia.add(cogn);
					cogn.setText("Cognome");
					cogn.setBounds(290, 76, 81, 16);
				}
				{
					ind = new JLabel();
					dia.add(ind);
					ind.setText("Indirizzo");
					ind.setBounds(65, 125, 62, 16);
				}
				{
					tel = new JLabel();
					dia.add(tel);
					tel.setText("Telefono");
					tel.setBounds(292, 125, 65, 16);
				}
				{
					mail = new JLabel();
					dia.add(mail);
					mail.setText("Email");
					mail.setBounds(62, 172, 44, 16);
				}
				{
					esci = new JButton();
					dia.add(esci);
					esci.addActionListener(esciModifica);
					esci.setText("Esci");
					esci.setBounds(389, 218, 86, 23);
				}
			}
			dia.setSize(549, 300);
			dia.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
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

	
	/**
	 * Classe che effettua le modifiche su un paziente.
	 */

	public class EffettuaModifichePaziente implements ActionListener{

		private String cF,n,cogn,i,t,e;
		
		public EffettuaModifichePaziente(String codice,String nome,String cognome,String ind,String tel,String email){
			this.cF=codice;
			this.n=nome;
			this.cogn=cognome;
			this.i=ind;
			this.t=tel;
			this.e=email;
		}


		public String getcF() {
			return cF;
		}

		public void setcF(String cF) {
			this.cF = cF;
		}

		public String getN() {
			return n;
		}

		public void setN(String n) {
			this.n = n;
		}

		public String getCogn() {
			return cogn;
		}

		public void setCogn(String cogn) {
			this.cogn = cogn;
		}

		public String getI() {
			return i;
		}

		public void setI(String i) {
			this.i = i;
		}

		public String getT() {
			return t;
		}

		public void setT(String t) {
			this.t = t;
		}

		public String getE() {
			return e;
		}

		public void setE(String e) {
			this.e = e;
		}
		
		public void actionPerformed(ActionEvent arg0) {
		
			   
			    this.setcF(cod.getText());
				this.setN(Nome.getText());
				this.setCogn(Cognome.getText());
				this.setI(Indirizzo.getText());
				this.setT(Telefono.getText());
				this.setE(email.getText());
				
				
				if(ControlloCodiceFiscale.checkCodiceFiscale(cod.getText())){
					
					if(ConvalidaMail.validateMail(email.getText())){
						
						if(!cod.getText().equals("") && !Nome.getText().equals("") && !Cognome.getText().equals("") && !Indirizzo.getText().equals("") 
								&& !Telefono.getText().equals("") && !email.getText().equals("")){

							if(Nome.getText().length()>2 && Cognome.getText().length()>2){
								
								if(Indirizzo.getText().length()>7){
								
									if(email.getText().length()>10){
								
										 String codiceF=(String)p.getTable().getValueAt(p.getTable().getSelectedRow(), 6);

									    	Utente u=new Utente(codiceF,n,cogn,i,t,e,"");
									    	applicaModifica(u); 
											chiudi();
								
								
									}else{
										JOptionPane.showMessageDialog(null, "Inserisci mail di minimo 10 caratteri");
									}				
								}else{
									JOptionPane.showMessageDialog(null, "Inserisci indirizzo con minimo 7 caratteri");
								}
							}else{
								JOptionPane.showMessageDialog(null, "Inserisci nome/cognome con minimo 2 caratteri");
							}		
						}else{

							JOptionPane.showMessageDialog(null, "Inserisci tutti i campi");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Formato mail non valido!");
					}
				}
						
		}	
		
		
		public void applicaModifica(Utente u){
						 
			Client client = Client.create();
			 
				WebResource webResource = client.resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/modificaPaziente/segret/abcd");
					 			 
				String input = "{\"codiceFiscale\":\""+u.getCodiceFiscale()+"\",\"nome\":\""+u.getNome()+"\",\"cognome\":\""
						+ ""+u.getCognome()+"\",\"telefono\":\""+u.getTelefono()+"\",\"email\":\""+u.getEmail()+"\""
						+ ",\"indirizzo\":\""+u.getIndirizzo()+"\",\"password\":\""+u.getPassword()+"\"}";                
	 
				ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
				
				
				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}	
			
		}
		
		public Utente getUtente(String codiceFiscale){

			Client client = Client.create();	 
			WebResource webResource = client
					.resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaResetClienti/segret/abcd/"+codiceFiscale);
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

				for(int j=0;j<u.size();j++)
					return u.get(j);



			} catch (JSONException ex) {
				ex.printStackTrace();
			}

			return null;

		}

		
	}
	
	public void chiudi(){
		dia.dispose();
		JOptionPane.showMessageDialog(null, "Modifica effettuata correttamente");
		while (p.getModelTable().getRowCount() > 0) 
            p.getModelTable().removeRow(0);
        
		p.getPazienti();
		
	}	


	/**
	 * Classe che esce dalla schermata di modifica.
	 */

	public class esci implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			dia.dispose();
		}
	
	}
	
	/**
	 * Classe che resetta l'inserimento dei dati.
	 */

	public class resetta implements ActionListener{

		public void actionPerformed(ActionEvent e) {
	
			String codiceF=(String)p.getTable().getValueAt(p.getTable().getSelectedRow(), 6);
			
			Client client = Client.create();	 
			WebResource webResource = client
			   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaResetClienti/segret/abcd/"+codiceF);
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
	        		
	        		     Indirizzo.setText(u.get(j).getIndirizzo());
					    Telefono.setText(u.get(j).getIndirizzo());
					    email.setText(u.get(j).getEmail());
	        	}
	     
	        		
			} catch (JSONException ex) {
				ex.printStackTrace();
			}
			
		}
		
	}
	
}
