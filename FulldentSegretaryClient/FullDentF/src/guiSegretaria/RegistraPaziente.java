package guiSegretaria;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.ControlloCodiceFiscale;
import util.ConvalidaMail;
import util.Costanti;
import util.LetterDocument;
import util.LimitateDocument;
import util.NumberDocument;
import bean.Utente;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


/**
 * Classe che registra un paziente nel sistema.
 *
 * @author V.Esposito
 */


public class RegistraPaziente implements ActionListener{

	private JDialog dia;
	private JTextField cod,email,Telefono,Indirizzo,Cognome,Nome;
	private JButton Resetta,esci,Inserisci;
	private JLabel codFis,mail,tel,ind,cogn,nome;
	private ActionListener InserisciPaziente,ActResetta,ActEsci;
	private Costanti c=new Costanti();
	/**
	 * Metodo che crea l'interfaccia di inserimento
	 */

	public void actionPerformed(ActionEvent arg0) {
		dia=new JDialog(new JFrame(),true);	
		ActResetta=new resettaForm();
		ActEsci=new esciForm();
		InserisciPaziente=new InserisciPaziente(null, null, null, null, null, null);
		dia.setTitle("Registra Paziente");
	
		dia.setBounds(480, 290, 480, 170);

		try {
			{
				dia.setLayout(null);
				{
					cod = new JTextField();
					cod.setDocument(new LimitateDocument(16));
					dia.add(cod);
					cod.setBounds(157, 25, 316, 23);
				}
				{
					Nome = new JTextField();
					Nome.setDocument(new LimitateDocument(150));
					Nome.setDocument(new LetterDocument());
					dia.add(Nome);
					Nome.setBounds(159, 73, 120, 23);
				}
				{
					Cognome = new JTextField();
					Cognome.setDocument(new LimitateDocument(150));
					Cognome.setDocument(new LetterDocument());
					dia.add(Cognome);
					Cognome.setBounds(355, 73, 119, 23);
				}
				{
					Indirizzo = new JTextField();
					Indirizzo.setDocument(new LimitateDocument(20));
					dia.add(Indirizzo);
					Indirizzo.setBounds(160, 118, 120, 23);
				}
				{
					Telefono = new JTextField();
					Telefono.setDocument(new NumberDocument());
					Telefono.setDocument(new LimitateDocument(10));
					dia.add(Telefono);
					Telefono.setBounds(356, 122, 119, 23);
				}
				{
					email = new JTextField();
					dia.add(email);
					email.setBounds(159, 169, 316, 23);
				}
				{
					Inserisci = new JButton();
					Inserisci.addActionListener(InserisciPaziente);
					dia.add(Inserisci);
					Inserisci.setText("Inserisci");
					Inserisci.setBounds(62, 218, 86, 23);
				}
				{
					Resetta = new JButton();
					dia.add(Resetta);
					Resetta.addActionListener(ActResetta);
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
					esci.addActionListener(ActEsci);
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


	public InserisciPaziente getInserisciPaziente(){
		return (guiSegretaria.RegistraPaziente.InserisciPaziente) InserisciPaziente;
	}

	/**
	 * Classe che inserisce un paziente nel sistema.
	 */


	public class InserisciPaziente implements ActionListener{

		private String cF,n,cogn,i,t,e,p;



		public InserisciPaziente(String codice,String nome,String cognome,String ind,String tel,String email){
			this.cF=codice;
			this.n=nome;
			this.cogn=cognome;
			this.i=ind;
			this.t=tel;
			this.e=email;

			RandomPassword rp=new RandomPassword();
			p=rp.generate();
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
								
											Utente u=new Utente(cF,n,cogn,i,t,e,p);
											inserisciNelDb(u); 
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
					
				}else{
					JOptionPane.showMessageDialog(null, "Formato Codice Fiscale non valido!");
				}
				
			}
	
		public void inserisciNelDb(Utente u){

			Client client = Client.create();


			WebResource webResource = client
					.resource(c.RICHIESTADATI+"/FulldentServer/jaxrs/services/insertUtente/segret/abcd");

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
					.resource(c.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaResetClienti/segret/abcd/"+codiceFiscale);
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
		JOptionPane.showMessageDialog(null, "Inserimento effettuato correttamente");
	}

	/**
	 * Classe che resetta la form di inserimento.
	 */

	public class resettaForm implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			cod.setText("");
			Nome.setText("");
			Cognome.setText("");
			Indirizzo.setText("");
			Telefono.setText("");
			email.setText("");
		}

	}

	/**
	 * Classe che chiude la form di inserimento.
	 */

	public class esciForm implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			dia.dispose();
		}


	}





}
