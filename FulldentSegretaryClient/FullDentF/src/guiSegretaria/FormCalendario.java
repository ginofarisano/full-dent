package guiSegretaria;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.Costanti;
import bean.Appuntamento;
import bean.Personale;
import bean.Prenotazione;
import bean.Prestazione;
import bean.StoricoPaziente;
import bean.Utente;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Classe che specifica un calendario con gli appuntamenti prenotati.
 * @author V.Esposito
 */

public class FormCalendario extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	/** 
     * Crea un nuovo Form.
     */

	private JButton btnSu,btnGiu,button,button_1,button_2,button_3;
	private JTextField textField,textAnno,textGiorni,textMese;
	private JLabel nomeGiorno;
	private ActionListener actEsciSchermata,ricercaApp,actStorico,modificaCliente,registraNuovoCliente,aumentaAnno,diminuisciAnno,aumentaMese,
	diminuisciMese,aumentaGiorno,diminuisciGiorno,actEliminaAppuntamento,actChiudiElimina,ActChiudi,actModificaStorico,actAggiungiPren;
	private int maxDay;
	private JTable table3;
    private DefaultTableModel modelTab2,modelTab3;
    private MouseListener actTab;
    private JTableHeader th;
    private JScrollPane sp3;
	private String codiceCliente,nameCol="";
	MatteBorder border = new MatteBorder(0,0,1,0, Color.gray);
	private ConnessioneDB conn=new ConnessioneDB();
	private JComboBox<String> servizi;
	private KeyListener guiListaPazienti;
	private JDialog d,dins;
	private JCheckBox check;
	private JTextArea t;
	Map<Integer,String> colori2 = new HashMap<>();
	private Costanti c=new Costanti();
	/**
	 * Instanzia nuovo FormCalendario
	 */
	public FormCalendario() {
		initComponents();
    }

    /**
     * Metodo di supporto che inizializza le componenti del Frame.
     */
    private void initComponents() {
 
    	registraNuovoCliente=new RegistraPaziente();
    	modificaCliente=new GuiModificaPaziente("");
    	guiListaPazienti=new GuiListaPazienti(this);
    	aumentaGiorno=new AumGiorni();
		diminuisciGiorno=new DimGiorni();
		aumentaMese=new AumMes();
		diminuisciMese=new DimMes();
		aumentaAnno=new AumAnno();
		diminuisciAnno=new DimAnno();
		actTab=new RegistraAppuntamento();
		actEliminaAppuntamento=new EliminaAppuntamento(null,null,null,null,null);
		actChiudiElimina=new chiudiElimina();
		ActChiudi=new chiudiTutto(this);
		actModificaStorico=new modificaStorico();
		actAggiungiPren=new AggiungiApp(null,null,null,null,null);
		actStorico=new GuiModificaPaziente("storico");
		ricercaApp=new RicercaAppuntamento();
		actEsciSchermata=new ChiudiSchermata();
		
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    
        
       	JPanel contentPanel =new JPanel();		
		contentPanel.setLayout(new BorderLayout());
        String noSet="";
		Calendar cal = Calendar.getInstance();
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);

		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

	
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(null, "Calendario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.setLayout(null);
		panel1.setPreferredSize(new Dimension(1350,150));
		

		
	
		
		JLabel lblDataAppuntamento = new JLabel("Data Appuntamento");
		lblDataAppuntamento.setBounds(275, 58, 120, 14);
		panel1.add(lblDataAppuntamento);
		
		
		nomeGiorno= new JLabel(noSet);
		nomeGiorno.setBounds(310, 95, 120, 14);
		panel1.add( nomeGiorno);
		
		
		btnSu = new JButton("");
		btnSu.setIcon(new ImageIcon("img\\FrecciaSu.png"));
		btnSu.addActionListener(aumentaGiorno);
		btnSu.setBounds(405, 23, 59, 23);
		panel1.add(btnSu);
		
		textGiorni = new JTextField();
		textGiorni.setEditable(false);
		textGiorni.setHorizontalAlignment( JTextField.CENTER);
		textGiorni.setFont(new Font("Tahoma", Font.PLAIN, 17));
		if(day>9)
			textGiorni.setText(""+day);
		else
			textGiorni.setText("0"+day);
		textGiorni.setBounds(405, 49, 59, 33);
		panel1.add(textGiorni);
		textGiorni.setColumns(10);
		
	    btnGiu = new JButton("");
		btnGiu.addActionListener(diminuisciGiorno);
		btnGiu.setIcon(new ImageIcon("img\\FrecciaGiu.png"));
		btnGiu.setBounds(405, 86, 59, 23);
		panel1.add(btnGiu);
		
		button = new JButton("");
		button.addActionListener(aumentaMese);
		button.setIcon(new ImageIcon("img\\FrecciaSu.png"));
		button.setBounds(474, 23, 59, 23);
		panel1.add(button);
		
		textMese = new JTextField();
		textMese.setEditable(false);
		textMese.setHorizontalAlignment( JTextField.CENTER);
		textMese.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textMese.setColumns(10);
		if(month>9)
			textMese.setText(""+month);
		else
			textMese.setText("0"+month);
		textMese.setColumns(10);
		textMese.setBounds(474, 49, 59, 33);
		panel1.add(textMese);
		
		button_1 = new JButton("");
		button_1.addActionListener(diminuisciMese);
		button_1.setIcon(new ImageIcon("img\\FrecciaGiu.png"));
		button_1.setBounds(474, 86, 59, 23);
		panel1.add(button_1);
		
		button_2 = new JButton("");
		button_2.addActionListener(aumentaAnno);
		button_2.setIcon(new ImageIcon("img\\FrecciaSu.png"));
		button_2.setBounds(543, 23, 59, 23);
		panel1.add(button_2);
		
		textAnno = new JTextField();
		textAnno.setEditable(false);
		textAnno.setHorizontalAlignment( JTextField.CENTER);
		textAnno.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textAnno.setText(""+year);
		textAnno.setColumns(10);
		textAnno.setBounds(543, 49, 59, 33);
		panel1.add(textAnno);
		
		button_3 = new JButton("");
		button_3.addActionListener(diminuisciAnno);
		button_3.setIcon(new ImageIcon("img\\FrecciaGiu.png"));
		button_3.setBounds(543, 86, 59, 23);
		panel1.add(button_3);
			
		JButton vai=new JButton("Ricerca");
		vai.addActionListener(ricercaApp);
		vai.setBounds(670,50, 100, 30);
		panel1.add(vai);
		contentPanel.add(panel1, BorderLayout.NORTH);
	

		
		ArrayList<String> co=getCollaboratori();
		
	
		Object[] columnHeaders3 =  new Object[co.size()+3];
		columnHeaders3[0]="";
		columnHeaders3[1]="Orario";
		
		int qwe=2;
		for(int i=0;i<co.size();i++){
			columnHeaders3[qwe]=co.get(i);
			qwe++;
		}
		columnHeaders3[4]=" ";
		modelTab3=new DefaultTableModel(null,columnHeaders3) {
		
				private static final long serialVersionUID = 1L;
				
				public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
	
		
		
		    table3 = new JTable(modelTab3);
		    
		    table3.getColumn(" ").setWidth(1);
		    table3.getColumn("").setWidth(1);
			table3.getColumn("").setMinWidth(1);
			
		    table3.getColumn("").setWidth(20);
			table3.getColumn("").setMinWidth(20);
			table3.getColumn("").setMaxWidth(20);
			table3.getColumn("Orario").setWidth(100);
			table3.getColumn("Orario").setMinWidth(100);
			table3.getColumn("Orario").setMaxWidth(100);
		    getAppuntamenti();
		    table3.addMouseListener(actTab);
	        table3.setPreferredScrollableViewportSize(new Dimension(100,650));
	        table3.setDefaultRenderer(Object.class, new TabellaAppuntamenti(colori2));
	        table3.getTableHeader().setReorderingAllowed(false);
	        table3.setRowHeight(25);
		    table3.setFillsViewportHeight(true);
			
			
			
	    sp3=new JScrollPane(table3);
		sp3.setBorder(border);
		contentPanel.add(sp3, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(200,100));
		contentPanel.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Registra Nuovo Paziente");
		btnNewButton.addActionListener(registraNuovoCliente);
		btnNewButton.setIcon(new ImageIcon("img\\ggPrec.png"));
		btnNewButton.setBounds(10, 11, 200, 50);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton2 = new JButton("Modifica Paziente");
		btnNewButton2.addActionListener(modificaCliente);
		btnNewButton2.setIcon(new ImageIcon("img\\ggPrec.png"));
		btnNewButton2.setBounds(250, 11, 200, 50);
		panel_3.add(btnNewButton2);
		
		
		JButton button23 = new JButton("Storico Paziente");
		button23.addActionListener(actStorico);
		button23.setIcon(new ImageIcon("img\\ggPrec.png"));
		button23.setBounds(500, 11, 200, 50);
		panel_3.add(button23);
		
		JButton button24 = new JButton("Esci");
		button24.setIcon(new ImageIcon("img\\ggPrec.png"));
		button24.addActionListener(ActChiudi);
		button24.setBounds(800, 11, 200, 50);
		panel_3.add(button24);
		


	
		contentPanel.add(panel_3, BorderLayout.SOUTH);
        this.setTitle("FullDent - Calendario");
        
        this.add(contentPanel);
        pack();
    }
    

    /**
     * Classe che elenca gli appuntamenti odierni.
     */
	public class RicercaAppuntamento implements ActionListener{

	
		public void actionPerformed(ActionEvent arg0) {

				getAppuntamenti();
		}
	
	}
	
    public class ChiudiSchermata implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			dins.dispose();
		}

    }
	
	
	 /**
 	 * Metodo che ritorna il cognome del paziente da ricercare.
 	 *
 	 * @return the cognome paziente
 	 */
    public String getCognomePaziente(){
    	return textField.getText();
    }

    /**
     * Metodo che ritorna la lista dei medici.
     *
     * @return the collaboratori
     */
	public ArrayList<String> getCollaboratori(){
		ArrayList<String>coll=new ArrayList<String>();
		String nome="null",cognome="null";
			Client client = Client.create();	 
			
			
			WebResource webResource = client
			   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaDottori/segret/abcd/"+nome+"/"+cognome);
			
			ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
			
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			
			String output = response.getEntity(String.class);
			
			try {
				JSONArray array=new JSONArray(output);
				JSONObject object;
				ArrayList<Personale>u=new ArrayList<Personale>();
				
				
				for(int i=0;i<array.length();i++){
					object=array.getJSONObject(i);
					Personale utente=new Personale();
					utente.setNome(object.getString("nome"));
					utente.setCognome(object.getString("cognome"));
					u.add(utente);
				}
				
				
					
	        	for(int j=0;j<u.size();j++)
	        		coll.add(u.get(j).getNome()+" "+u.get(j).getCognome());
	        	
	     
	        		
			} catch (JSONException e) {
				e.printStackTrace();
			}
		 
		return coll;
	}
	
	
	 /**
     * Classe che permetta la modifica dello storico cliente.
     */
	public class modificaStorico implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
		
			String idPren=getIdPren(),pagato="NO",note="";

   
			   if(check.isSelected())
				   pagato="SI";
			   
			   note=t.getText();
   
			  Client client = Client.create();
				 
				WebResource webResource = client.resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/modificaStorico/segret/abcd");
					 			 
				String input = "{\"idPrenotazione\":\""+idPren+"\",\"pagato\":\""+pagato+"\",\"note\":\""+note+"\"}";                
 
				ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
				
				
				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}	
		   
					JOptionPane.showMessageDialog(null, "Modifica Effettuata ! ");
			
					   while(modelTab3.getRowCount()>0)
					    	modelTab3.removeRow(0);
					getAppuntamenti();
					d.dispose();
			
		}
		
	}
	
	
	 /**
 	 * Classe che gestisce quale interfaccia mostrare.
 	 */
	public class RegistraAppuntamento implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			
			if(arg0.getClickCount()==2){
		

				int r=table3.getSelectedRow();
				int cl=table3.getSelectedColumn();
			

				Calendar cal = Calendar.getInstance();
				int day=cal.get(Calendar.DAY_OF_MONTH);
				int month = cal.get(Calendar.MONTH) + 1;
				int year = cal.get(Calendar.YEAR);
				
				Calendar c1=Calendar.getInstance();
				Calendar c2=Calendar.getInstance();
				
				c1.set(year,month,day);	
				c2.set(Integer.parseInt(textAnno.getText()), Integer.parseInt(textMese.getText()),Integer.parseInt(textGiorni.getText()));

				String oraSel=(String) table3.getValueAt(r, 1);
				String[] or=oraSel.split(":");
				
				Calendar c=Calendar.getInstance();
				c.set(Integer.parseInt(textAnno.getText()), Integer.parseInt(textMese.getText())-1,Integer.parseInt(textGiorni.getText()));
				String[] data=c.getTime().toString().split(" ");
				
				
				if(c2.before(c1)){
					   JOptionPane.showMessageDialog(null, "Non puoi prenotare una data precedente a quella odierna! ");
						
				}else if(data[0].equals("Sun") || data[0].equals("Sat")){
					JOptionPane.showMessageDialog(null, "Non puoi prenotare in un giorno festivo ");
				
				}else if(c2.equals(c1)){
	
						Date a=new Date();
						
						if(Integer.parseInt(or[0])<a.getHours() && Integer.parseInt(textGiorni.getText())<=day )
							JOptionPane.showMessageDialog(null, "Orario passato! ");	
						
						if(Integer.parseInt(or[0])>a.getHours()){
							if(table3.getValueAt(r, cl)==null)
								guiInserimentoPrenotazione();
							else
								guiEliminazione(r,cl);
							
						}
						
						else if(Integer.parseInt(or[0])==a.getHours()){
					
							if(Integer.parseInt(or[1])<a.getMinutes()){
								JOptionPane.showMessageDialog(null, "Orario passato! ");	
							}else{
								if(table3.getValueAt(r, cl)==null)
									guiInserimentoPrenotazione();
								else
									guiEliminazione(r,cl);		
							}
							
						
				     }
				
					}else if(c2.after(c1)){
						if(table3.getValueAt(r, cl)==null)
							guiInserimentoPrenotazione();
						else
							guiEliminazione(r,cl);
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
     * Classe che aggiunge un appuntamento.
     */
	public class AggiungiApp implements ActionListener{
		
		private String codiceFiscale;
		private String idPrestazione;
		private String idPersonale;
		private String data;
		private String ora;

		public AggiungiApp(String cod,String idPrest,String idPers,String data,String ora){
			this.codiceFiscale = cod;
			this.idPrestazione = idPrest;
			this.idPersonale = idPers;
			this.data = data;
			this.ora = ora;
		}

	

		public String getCodiceFiscale() {
			return codiceFiscale;
		}

		public void setCodiceFiscale(String codiceFiscale) {
			this.codiceFiscale = codiceFiscale;
		}

		public String getIdPrestazione() {
			return idPrestazione;
		}

		public void setIdPrestazione(String idPrestazione) {
			this.idPrestazione = idPrestazione;
		}

		public String getIdPersonale() {
			return idPersonale;
		}

		public void setIdPersonale(String idPersonale) {
			this.idPersonale = idPersonale;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public String getOra() {
			return ora;
		}

		public void setOra(String ora) {
			this.ora = ora;
		}


		
		public String verificaCodiceMedico(String codice){
			
			Client client = Client.create();	 
			String codFis=null;
			WebResource webResource = client
			   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaDottoriCodice/segret/abcd/"+codice);
			
			ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
			
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			
			String output = response.getEntity(String.class);
			
			try {
				JSONArray array=new JSONArray(output);
				JSONObject object;
				ArrayList<Personale>u=new ArrayList<Personale>();
				
				
				for(int i=0;i<array.length();i++){
					object=array.getJSONObject(i);
					Personale utente=new Personale();
					utente.setCodiceFiscale(object.getString("codiceFiscale"));
					utente.setNome(object.getString("nome"));
					utente.setCognome(object.getString("cognome"));
					u.add(utente);
				}
				
		
	        	for(int j=0;j<u.size();j++){
	        		codFis=u.get(j).getCodiceFiscale();
	        	}
	     
	        		
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			return codFis;	
			
			
		}
		
		public String verificaCodiceFiscale(String codice){
			
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
					return u.get(j).getCodiceFiscale();



			} catch (JSONException ex) {
				ex.printStackTrace();
			}

			return null;
			
		}
		
		
		public String verificaIdPrenotazione(String codice){
			String idPren=null;
			Client client = Client.create();	 
			WebResource webResource = client
			   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/codicePrenotazione/segret/abcd/"+codice);
			
			ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
			
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			
			String output = response.getEntity(String.class);
			
			try {
				JSONArray array=new JSONArray(output);
				JSONObject object;
				ArrayList<Prenotazione>u=new ArrayList<Prenotazione>();
				
				for(int i=0;i<array.length();i++){
					object=array.getJSONObject(i);
					Prenotazione p=new Prenotazione();
					p.setIdPrenotazione(object.getString("idPrenotazione"));
					p.setCodiceFiscale(object.getString("codiceFiscale"));
					p.setIdPrestazione(object.getString("idPrestazione"));
					p.setIdPersonale(object.getString("idPersonale"));
					p.setData(object.getString("data"));
					p.setOra(object.getString("ora"));
					u.add(p);
				}
				
			
				for(int j=0;j<u.size();j++){
	        		
					idPren=u.get(j).getIdPrenotazione();
	               };
				
			} catch (JSONException e) {
				e.printStackTrace();
			}    
		
		return idPren;
			
			
		}
		
		
		public void actionPerformed(ActionEvent arg0) {

			String idPrestazione=getInfoServizio(""+servizi.getSelectedItem());
			String nomeMedico=(String)table3.getColumnName(table3.getSelectedColumn());
			String[] medico=nomeMedico.split(" ");
			
			int durata =((getDurataServizio(idPrestazione))*2);
			
			String codiceMedico=getCodiceMedico(medico[0],medico[1]);
		    String data=textGiorni.getText()+"-"+textMese.getText()+"-"+textAnno.getText();
			String ora=(String)modelTab3.getValueAt((int)table3.getSelectedRow(), 1);
			int riga=table3.getSelectedRow();
			int colonna=table3.getSelectedColumn();
	
				if((String)modelTab3.getValueAt(riga+durata, colonna)!=null){
				JOptionPane.showMessageDialog(null, "Non puoi prenotare! ");
				dins.dispose();
			}
			else if((String)modelTab3.getValueAt(riga+durata, colonna)==null){
			
							int choice = JOptionPane.showOptionDialog(null, 
							      "Confermi la prenotazione?", 
							      "Conferma", 
							      JOptionPane.YES_NO_OPTION, 
							      JOptionPane.QUESTION_MESSAGE, 
							      null, null, null);
						
						if(choice==JOptionPane.YES_OPTION){
						 	   
							Prenotazione a=new Prenotazione(codiceCliente,idPrestazione,codiceMedico,data,ora);
							AggiungiAppuntamento(a);
							chiudi();
						  
						}
			}
		}
		
		public void AggiungiAppuntamento(Prenotazione a){

			Client client = Client.create();
			 
			WebResource webResource = client.resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/insertPrenotazione/segret/abcd");
				 			 
			String input = "{\"codiceFiscale\":\""+a.getCodiceFiscale()+"\",\"idPrestazione\":\""+a.getIdPrestazione()+"\",\"idPersonale\":\""+a.getIdPersonale()+"\",\"data\":\""+a.getData()+"\",\"ora\":\""+a.getOra()+"\"}";                
	 
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
			
			
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}
			
			
			 String idPren=getIdPren(),pagato="NO",note="";
			
				WebResource webResource2 = client.resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/insertStorico/segret/abcd");
					 			 
				String input2 = "{\"idPrenotazione\":\""+idPren+"\",\"pagato\":\""+pagato+"\",\"note\":\""+note+"\"}";                
		 
				ClientResponse response2 = webResource2.type("application/json").post(ClientResponse.class, input2);
				
				
				if (response2.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response2.getStatus());
				}
			
		}
	
		
		public void getAppuntamenti(){
			
			  while (table3.getRowCount() > 0) 
				  modelTab3.removeRow(0);
	        
			String dataEst=textGiorni.getText()+"-"+textMese.getText()+"-"+textAnno.getText();
		    String minuti="00",or="";
			
		    int ore=8,contr=2;
		     ArrayList<String> idColla=getCollaboratori();
			
				  
		     		while(ore!=21){
		     
		     			if(contr%2==0){
		     				if(ore>9)
		     					or=""+ore;
		     				else
		     					or="0"+ore;
		     				minuti="00";
		     				contr++;
		     		
		     			}else{
		     				
		     				if(ore>9)
		     					or=""+ore;
		     				else
		     					or="0"+ore;
		     				minuti="30";
		     				contr++;
		     				ore++;
		     			}
		     			
		    	 	  Object[] rowData=new Object[idColla.size()+2];
	    			  rowData[0]="";
	    			  rowData[1]=or+":"+minuti; 
	   
	    			  
	    				 try {
	    					 
	    					 
	    					 Client client = Client.create();	 
	    						
	    						WebResource webResource = client
	    						   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/getAppuntamenti/segret/abcd/"+dataEst+"/"+or+":"+minuti);
	    					
	    						ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
	    						
	    						
	    						if (response.getStatus() != 200) {
	    						   throw new RuntimeException("Failed : HTTP error code : "
	    							+ response.getStatus());
	    						}
	    						
	    						String output = response.getEntity(String.class);
	    						
	    						JSONArray array=new JSONArray(output);
	    						JSONObject object;
	    						ArrayList<Appuntamento>u=new ArrayList<Appuntamento>();
	    						
	    						
	    						for(int z=0;z<array.length();z++){
	    							object=array.getJSONObject(z);
	    							Appuntamento a=new Appuntamento();
	    							a.setNomeUtente(object.getString("nomeUtente"));
	    							a.setCognomeUtente(object.getString("cognomeUtente"));
	    							a.setNomePers(object.getString("nomePers"));
	    							a.setCognomePers(object.getString("cognomePers"));
	    							a.setNomePrestazione(object.getString("nomePrestazione"));
	    							a.setPagato(object.getString("pagato"));
	    							a.setDurata(object.getString("durata"));
	    							u.add(a);
	    						}
	    						
	    						
	    					    	 for(int q=0;q<u.size();q++) {
	    					    		  for(int j=2;j<table3.getColumnCount();j++){
	    					    			 
	    					    			  if(table3.getColumnName(j).equals(u.get(q).getNomePers()+" "+u.get(q).getCognomePers())){
	    					    				  
	    					    				  rowData[j]=u.get(q).getDurata()+" "+u.get(q).getNomeUtente()+" "+u.get(q).getCognomeUtente()+" ("+u.get(q).getNomePrestazione()+")"+" PAGATO: "+u.get(q).getPagato();
	    			
	    					    			  }
	    					    			 
	    					    		  }
	    					    		
	    					    	  }
	    					    	  modelTab3.addRow(rowData);
	    					    	 
	    			     } catch (JSONException e) {

							e.printStackTrace();
						}   		  
	    			  
	    		  	
				  }
		     		 controllaAppuntamenti();
		}
		
		public void chiudi(){
			JOptionPane.showMessageDialog(null, "Prenotazione Effettuata ! ");
			textField.setText("");
			   while(modelTab3.getRowCount()>0)
			    	modelTab3.removeRow(0);
			getAppuntamenti();
			dins.dispose();
		}
		
		}
	
	//}
	
	 /**
	 * Metodo che genera l'interfaccia per la prenotazione.
	 */
	public void guiInserimentoPrenotazione(){
		dins=new JDialog();
		dins.setSize(500,250);
		dins.setLocation(400, 200);
		dins.setTitle("Prenotazione");
		JPanel panel1=new JPanel();
		panel1.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 58, 68, 14);
		panel1.add(lblCliente);
		
		textField = new JTextField();
		textField.setBounds(100, 55, 125, 20);
		textField.addKeyListener(guiListaPazienti);
		panel1.add(textField);
		textField.setColumns(10);
		

		JLabel lblOrario = new JLabel("Seleziona Servizio");
		lblOrario.setBounds(240, 58, 133, 14);
		panel1.add(lblOrario);

		
		servizi = new JComboBox<String>();
		servizi.addItem("       ");
		servizi.setSelectedIndex(-1);
		servizi.setBounds(350, 49, 100, 33);
		getServizi(servizi);
		panel1.add(servizi);
		
		JButton but=new JButton("Prenota");
		but.addActionListener(actAggiungiPren);
		but.setBounds(100, 150, 100, 30);
		JButton but2=new JButton("Annulla");
		but2.addActionListener(actEsciSchermata);
		but2.setBounds(280, 150, 100, 30);
		panel1.add(but);
		panel1.add(but2);
		
		dins.add(panel1);
		dins.setVisible(true);
	}
	
	 /**
 	 * Metodo che ritorna un determinato id di una prenotazione.
 	 *
 	 * @return the id pren
 	 */
	public String getIdPren(){
		 String idPren="";
			
			String nomeMedico=(String)table3.getColumnName(table3.getSelectedColumn());
			String[] medico=nomeMedico.split(" ");
			
			String codiceMedico=getCodiceMedico(medico[0],medico[1]);
			
			String data=textGiorni.getText()+"-"+textMese.getText()+"-"+textAnno.getText();
			String ora=(String)modelTab3.getValueAt((int)table3.getSelectedRow(), 1);
			
			Client client = Client.create();	 
			WebResource webResource = client
			   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaPrenotazione/segret/abcd/"+data+"/"+ora+"/"+codiceMedico);
			
			ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
			
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			
			String output = response.getEntity(String.class);
			
			try {
				JSONArray array=new JSONArray(output);
				JSONObject object;
				ArrayList<Prenotazione>u=new ArrayList<Prenotazione>();
				
				for(int i=0;i<array.length();i++){
					object=array.getJSONObject(i);
					Prenotazione p=new Prenotazione();
					p.setIdPrenotazione(object.getString("idPrenotazione"));
					p.setCodiceFiscale(object.getString("codiceFiscale"));
					p.setIdPrestazione(object.getString("idPrestazione"));
					p.setIdPersonale(object.getString("idPersonale"));
					p.setData(object.getString("data"));
					p.setOra(object.getString("ora"));
					u.add(p);
				}
				
			
				for(int j=0;j<u.size();j++){
	        		
					idPren=u.get(j).getIdPrenotazione();
	               };
				
			} catch (JSONException e) {
				e.printStackTrace();
			}    
		
		return idPren;
		
	}
	

	 /**
 	 * Classe che gestisce l'eliminazione di un appuntamento.
 	 */
	public class EliminaAppuntamento implements ActionListener{

		private String codiceFiscale,idPrestazione,codMedico,data,ora;
		
		public EliminaAppuntamento(String codiceFiscale,String idPrestazione,String codiceMedico,String data,String ora){
			this.codiceFiscale=codiceFiscale;
			this.idPrestazione=idPrestazione;
			this.codMedico=codiceMedico;
			this.data=data;
			this.ora=ora;
		}
		
	
		public String getCodiceFiscale() {
			return codiceFiscale;
		}


		public void setCodiceFiscale(String codiceFiscale) {
			this.codiceFiscale = codiceFiscale;
		}


		public String getIdPrestazione() {
			return idPrestazione;
		}


		public void setIdPrestazione(String idPrestazione) {
			this.idPrestazione = idPrestazione;
		}


		public String getCodMedico() {
			return codMedico;
		}


		public void setCodMedico(String codiceMedico) {
			this.codMedico = codiceMedico;
		}


		public String getData() {
			return data;
		}


		public void setData(String data) {
			this.data = data;
		}


		public String getOra() {
			return ora;
		}


		public void setOra(String ora) {
			this.ora = ora;
		}

		public String verificaIdPrenotazione(String codice){
			String idPren=null;
			Client client = Client.create();	 
			WebResource webResource = client
			   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/codicePrenotazione/segret/abcd/"+codice);
			
			ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
			
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			
			String output = response.getEntity(String.class);
			
			try {
				JSONArray array=new JSONArray(output);
				JSONObject object;
				ArrayList<Prenotazione>u=new ArrayList<Prenotazione>();
				
				for(int i=0;i<array.length();i++){
					object=array.getJSONObject(i);
					Prenotazione p=new Prenotazione();
					p.setIdPrenotazione(object.getString("idPrenotazione"));
					p.setCodiceFiscale(object.getString("codiceFiscale"));
					p.setIdPrestazione(object.getString("idPrestazione"));
					p.setIdPersonale(object.getString("idPersonale"));
					p.setData(object.getString("data"));
					p.setOra(object.getString("ora"));
					u.add(p);
				}
				
			
				for(int j=0;j<u.size();j++){
	        		
					idPren=u.get(j).getIdPrenotazione();
	               };
				
			} catch (JSONException e) {
				e.printStackTrace();
			}    
		
		return idPren;
			
			
		}
		
		
		public String verificaDataPrenotazione(String data,String ora){
			String idPren=null;
			Client client = Client.create();	 
			WebResource webResource = client
			   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaPrenotazioneData/segret/abcd/"+data.replace("/", "-")+"/"+ora);
			
			ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
			
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			
			String output = response.getEntity(String.class);
			
			try {
				JSONArray array=new JSONArray(output);
				JSONObject object;
				ArrayList<Prenotazione>u=new ArrayList<Prenotazione>();
				
				for(int i=0;i<array.length();i++){
					object=array.getJSONObject(i);
					Prenotazione p=new Prenotazione();
					p.setIdPrenotazione(object.getString("idPrenotazione"));
					p.setCodiceFiscale(object.getString("codiceFiscale"));
					p.setIdPrestazione(object.getString("idPrestazione"));
					p.setIdPersonale(object.getString("idPersonale"));
					p.setData(object.getString("data"));
					p.setOra(object.getString("ora"));
					u.add(p);
				}
				
			
				for(int j=0;j<u.size();j++){
	        		
					idPren=u.get(j).getIdPrenotazione();
	               };
				
			} catch (JSONException e) {
				e.printStackTrace();
			}    
		
		return idPren;
			
		}
		
		public String verificaCodiceMedico(String codice){
			
			Client client = Client.create();	 
			String codFis=null;
			WebResource webResource = client
			   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaDottoriCodice/segret/abcd/"+codice);
			
			ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
			
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			
			String output = response.getEntity(String.class);
			
			try {
				JSONArray array=new JSONArray(output);
				JSONObject object;
				ArrayList<Personale>u=new ArrayList<Personale>();
				
				
				for(int i=0;i<array.length();i++){
					object=array.getJSONObject(i);
					Personale utente=new Personale();
					utente.setCodiceFiscale(object.getString("codiceFiscale"));
					utente.setNome(object.getString("nome"));
					utente.setCognome(object.getString("cognome"));
					u.add(utente);
				}
				
		
	        	for(int j=0;j<u.size();j++){
	        		codFis=u.get(j).getCodiceFiscale();
	        	}
	     
	        		
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			return codFis;	
			
			
		}
		
		public String verificaCodiceFiscale(String codice){
			
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
					return u.get(j).getCodiceFiscale();



			} catch (JSONException ex) {
				ex.printStackTrace();
			}

			return null;
			
		}

		public void actionPerformed(ActionEvent arg0) {
				
			String ora=(String)table3.getValueAt(table3.getSelectedRow(), 1);
			String data=textGiorni.getText()+"/"+textMese.getText()+"/"+textAnno.getText();
			
			
			String nomeMedico=(String)table3.getColumnName(table3.getSelectedColumn());
			String[] medico=nomeMedico.split(" ");
			
			String codiceMedico=getCodiceMedico(medico[0],medico[1]);
			String codice="",idPr="";
			
			
			
			int choice = JOptionPane.showOptionDialog(null, 
				      "Sei sicuro di eliminare la prenotazione?", 
				      "Conferma", 
				      JOptionPane.YES_NO_OPTION, 
				      JOptionPane.QUESTION_MESSAGE, 
				      null, null, null);
			
			if(choice==JOptionPane.YES_OPTION){	
				
				Prenotazione a=new Prenotazione(codice,idPr,codiceMedico,data,ora);
				togliAppuntamento(a);
				chiudi();
			}
			
		}
		
		public void chiudi(){
			JOptionPane.showMessageDialog(null, "Eliminazione Effettuata ! ");
			
		    while(modelTab3.getRowCount()>0)
		    	modelTab3.removeRow(0);
		    
			getAppuntamenti();
			d.dispose();
		}
		
		public void togliAppuntamento(Prenotazione a){
			conn.connetti();
			
			
			Client client = Client.create();
			 
			WebResource webResource = client.resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/eliminaPrenotazione/segret/abcd");
				 			 
			String input = "{\"codiceFiscale\":\""+a.getCodiceFiscale()+"\",\"idPrestazione\":\""+a.getIdPrestazione()+"\",\"idPersonale\":\""+a.getIdPersonale()+"\",\"data\":\""+a.getData()+"\",\"ora\":\""+a.getOra()+"\"}";                
	 
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
			
			
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}
		}
		
		
	}
	
	 /**
 	 * Classe che chiude il frame di eliminazione.
 	 */
	public class chiudiElimina implements ActionListener{

			public void actionPerformed(ActionEvent e) {
			d.dispose();
		}
	
	}
	
	 /**
 	 * Metodo che genera l'interfaccia di eliminazione appuntamento.
 	 *
 	 * @param riga the riga
 	 * @param colonna the colonna
 	 */
	public void guiEliminazione(int riga,int colonna){
		
		d=new JDialog();
		d.setTitle("Gestione Prenotazione");
		d.setLocation(450, 300);
		d.setSize(420, 250);
		JPanel p=new JPanel();
		p.setLayout(null);
		
		String ora=(String)table3.getValueAt(table3.getSelectedRow(), 1);
		String data=textGiorni.getText()+"/"+textMese.getText()+"/"+textAnno.getText();
		
	    String asd=(String)table3.getValueAt(riga, colonna);
		JLabel lab=new JLabel(data+" "+ora+" "+asd);
		lab.setBounds(0, 0, 400, 30);
		p.add(lab);
		
		
		String idPren=getIdPren(),pag="",note="";
		Client client = Client.create();	 
		WebResource webResource = client
		   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaStorico/segret/abcd/"+idPren);
		
		ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
		
		
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}
		
		String output = response.getEntity(String.class);
		
		try {
			JSONArray array=new JSONArray(output);
			JSONObject object;
			ArrayList<StoricoPaziente>u=new ArrayList<StoricoPaziente>();
			
			
			for(int i=0;i<array.length();i++){
				object=array.getJSONObject(i);
				StoricoPaziente storicoP=new StoricoPaziente();
				storicoP.setIdPrenotazione(object.getString("idPrenotazione"));
				storicoP.setNote(object.getString("note"));
				storicoP.setPagato(object.getString("pagato"));
				u.add(storicoP);
			}
					
        	for(int j=0;j<u.size();j++){
        		pag=u.get(j).getPagato();
        		note=u.get(j).getNote();
        	}
	  
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
		check=new JCheckBox("Pagato");
		check.setBounds(0, 40, 100, 30);
		if(pag.equals("SI"))
			check.setSelected(true);
		
		JLabel label=new JLabel("Note");
		label.setBounds(120, 40, 100, 30);
		
		t=new JTextArea(10,30);
		t.setText(note);
		t.setBounds(150, 40, 250, 100);
		
		p.add(check);
		p.add(label);
		p.add(t);
		
		JButton bu=new JButton("Modifica");
		bu.addActionListener(actModificaStorico);
		bu.setBounds(0, 170, 100, 40);
		
		JButton bu2=new JButton("Elimina");
		bu2.addActionListener(actEliminaAppuntamento);
		bu2.setBounds(150, 170, 100, 40);
		
		JButton bu3=new JButton("Esci");
		bu3.addActionListener(actChiudiElimina);
		bu3.setBounds(300, 170, 100, 40);
		
		p.add(bu);
		p.add(bu2);
		p.add(bu3);
		
		
		d.add(p);
		d.setVisible(true);
				
	}
	
	 /**
     * Classe che aumenta l'anno della data della ricerca appuntamenti.
     */
	public class AumAnno implements ActionListener {
		
		public void actionPerformed(ActionEvent Event) {
		    String mese=textAnno.getText();
			int gg=Integer.parseInt(mese);
	
			
				textAnno.setText(""+(gg+1));

				
		}
	}
	
	 /**
     * Classe che diminuisce l'anno della data della ricerca appuntamenti.
     */
	public class DimAnno implements ActionListener {
		
		public void actionPerformed(ActionEvent Event) {
			String mese=textAnno.getText();
			int gg=Integer.parseInt(mese);
			Calendar calendar = GregorianCalendar.getInstance();
			int annoCorrente=calendar.get( Calendar.YEAR )-2;

			if((gg-1)>annoCorrente)
			    textAnno.setText(""+(gg-1));
	
			   
		}
	}
		
	 /**
     * Classe che aumenta il mese della data della ricerca appuntamenti.
     */
	public class AumMes implements ActionListener {
		
		public void actionPerformed(ActionEvent Event) {
		    String mese=textMese.getText();
			int gg=Integer.parseInt(mese);
			
			if(gg>=12)
				textMese.setText("01");
			else{
				
				if((gg+1)>9)
					textMese.setText(""+(gg+1));
				else
					textMese.setText("0"+(gg+1));	
			}
		
		}
	}
	
	
	 /**
     * Classe che diminuisce il mese della data della ricerca appuntamenti.
     */
	public class DimMes implements ActionListener {
		
		public void actionPerformed(ActionEvent Event) {
			String mese=textMese.getText();
			int gg=Integer.parseInt(mese);
			
			if(gg>1){
				if((gg-1)>9)
					textMese.setText(""+(gg-1));
				else
					textMese.setText("0"+(gg-1));
			    
			}
			else
				textMese.setText("12");
		

		}
	}
	
	 /**
     * Classe che aumenta i giorni della data della ricerca appuntamenti.
     */
	public class AumGiorni implements ActionListener{
		
		public void actionPerformed(ActionEvent Event) {
			GregorianCalendar cal = new GregorianCalendar(Integer.parseInt(textAnno.getText()), Integer.parseInt(textMese.getText())-1, Integer.parseInt(textGiorni.getText()));
			cal.set(Calendar.DAY_OF_MONTH, (Integer.parseInt(textGiorni.getText())+1));
		   
		   String[] data=cal.getTime().toString().split(" ");
		   
     	   textAnno.setText(data[5]);
		   textGiorni.setText(data[2]);
		   
		   if(data[1].equals("Oct"))
			   textMese.setText("10");
		   else if(data[1].equals("Nov"))
			   textMese.setText("11");
		   else if(data[1].equals("Dec"))
			   textMese.setText("12");
		   else if(data[1].equals("Jan"))
			   textMese.setText("01");
		   else if(data[1].equals("Feb"))
			   textMese.setText("02");
		   else if(data[1].equals("Mar"))
			   textMese.setText("03");
		   else if(data[1].equals("Apr"))
			   textMese.setText("04");
		   else if(data[1].equals("May"))
			   textMese.setText("05");
		   else if(data[1].equals("Jun"))
			   textMese.setText("06");
		   else if(data[1].equals("Jul"))
			   textMese.setText("07");
		   else if(data[1].equals("Aug"))
			   textMese.setText("08");
		   else if(data[1].equals("Sep"))
			   textMese.setText("09");
	      
		}
	}
	
	 /**
     * Classe che diminuisce i giorni della data della ricerca appuntamenti.
     */
	public class DimGiorni implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			GregorianCalendar cal = new GregorianCalendar(Integer.parseInt(textAnno.getText()), Integer.parseInt(textMese.getText())-1, Integer.parseInt(textGiorni.getText()));
			cal.set(Calendar.DAY_OF_MONTH, (Integer.parseInt(textGiorni.getText())-1));
		   
		   String[] data=cal.getTime().toString().split(" ");
		   
     	   textAnno.setText(data[5]);
		   textGiorni.setText(data[2]);
		   
		   if(data[1].equals("Oct"))
			   textMese.setText("10");
		   else if(data[1].equals("Nov"))
			   textMese.setText("11");
		   else if(data[1].equals("Dec"))
			   textMese.setText("12");
		   else if(data[1].equals("Jan"))
			   textMese.setText("01");
		   else if(data[1].equals("Feb"))
			   textMese.setText("02");
		   else if(data[1].equals("Mar"))
			   textMese.setText("03");
		   else if(data[1].equals("Apr"))
			   textMese.setText("04");
		   else if(data[1].equals("May"))
			   textMese.setText("05");
		   else if(data[1].equals("Jun"))
			   textMese.setText("06");
		   else if(data[1].equals("Jul"))
			   textMese.setText("07");
		   else if(data[1].equals("Aug"))
			   textMese.setText("08");
		   else if(data[1].equals("Sep"))
			   textMese.setText("09");
	

		}
	}
	
	 /**
 	 * Metodo che ritorna il codice di un medico.
 	 *
 	 * @param nome the nome
 	 * @param cognome the cognome
 	 * @return the codice medico
 	 */
	public String getCodiceMedico(String nome, String cognome){
		
		String codFis="";
		
		Client client = Client.create();	 
		
		WebResource webResource = client
		   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaDottori/segret/abcd/"+nome+"/"+cognome);
		
		ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
		
		
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}
		
		String output = response.getEntity(String.class);
		
		try {
			JSONArray array=new JSONArray(output);
			JSONObject object;
			ArrayList<Personale>u=new ArrayList<Personale>();
			
			
			for(int i=0;i<array.length();i++){
				object=array.getJSONObject(i);
				Personale utente=new Personale();
				utente.setCodiceFiscale(object.getString("codiceFiscale"));
				utente.setNome(object.getString("nome"));
				utente.setCognome(object.getString("cognome"));
				u.add(utente);
			}
			
	
        	for(int j=0;j<u.size();j++){
        		codFis=u.get(j).getCodiceFiscale();
        	}
     
        		
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return codFis;	
    }

	 /**
 	 * Metodo che ritorna tutti gli appuntamenti per una determinata data.
 	 *
 	 * @return the appuntamenti
 	 */
	public void getAppuntamenti(){
	
		  while (table3.getRowCount() > 0) {
			  modelTab3.removeRow(0);
          }
		
		String dataEst=textGiorni.getText()+"-"+textMese.getText()+"-"+textAnno.getText();
	    String minuti="00",or="";
	    int ore=8,contr=2;
	     ArrayList<String> idColla=getCollaboratori();
	     
			  
	     		while(ore!=21){
	     
	     			if(contr%2==0){
	     				if(ore>9)
	     					or=""+ore;
	     				else
	     					or="0"+ore;
	     				minuti="00";
	     				contr++;
	     		
	     			}else{
	     				
	     				if(ore>9)
	     					or=""+ore;
	     				else
	     					or="0"+ore;
	     				minuti="30";
	     				contr++;
	     				ore++;
	     			}
	     			
	    	 	  Object[] rowData=new Object[idColla.size()+2];
    			  rowData[0]="";
    			  rowData[1]=or+":"+minuti; 
   
    			  
    				 try {
    					 
    					 
    					 Client client = Client.create();	 
    					 
    						WebResource webResource = client
    						   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/getAppuntamenti/segret/abcd/"+dataEst+"/"+or+":"+minuti);
    						
    						ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
    						
    						
    						if (response.getStatus() != 200) {
    						   throw new RuntimeException("Failed : HTTP error code : "
    							+ response.getStatus());
    						}
    						
    						String output = response.getEntity(String.class);
    						
    						JSONArray array=new JSONArray(output);
    						JSONObject object;
    						ArrayList<Appuntamento>u=new ArrayList<Appuntamento>();
    						
    						
    						for(int z=0;z<array.length();z++){
    							object=array.getJSONObject(z);
    							Appuntamento a=new Appuntamento();
    							a.setNomeUtente(object.getString("nomeUtente"));
    							a.setCognomeUtente(object.getString("cognomeUtente"));
    							a.setNomePers(object.getString("nomePers"));
    							a.setCognomePers(object.getString("cognomePers"));
    							a.setNomePrestazione(object.getString("nomePrestazione"));
    							a.setPagato(object.getString("pagato"));
    							a.setDurata(object.getString("durata"));
    							u.add(a);
    						}
    						
    						
    					    	 for(int q=0;q<u.size();q++) {
    					    		  for(int j=2;j<table3.getColumnCount();j++){
    					    			 
    					    			  if(table3.getColumnName(j).equals(u.get(q).getNomePers()+" "+u.get(q).getCognomePers())){
    					    				  
    					    				  rowData[j]=u.get(q).getDurata()+" "+u.get(q).getNomeUtente()+" "+u.get(q).getCognomeUtente()+" ("+u.get(q).getNomePrestazione()+")"+" PAGATO: "+u.get(q).getPagato();
    			
    					    			  }
    					    			 
    					    		  }
    					    		
    					    	  }
    					    	  modelTab3.addRow(rowData);
    					    	 
    			     } catch (JSONException e) {

						e.printStackTrace();
					}   		  
    			  
    		  	
			  }
	     		 controllaAppuntamenti();
	}

	 /**
 	 * Metodo che controlla graficamente la durata di un appuntamento.
 	 */
	public void controllaAppuntamenti(){

		int durata=0;
		ArrayList<Tab>tabella=new ArrayList<Tab>();
		
		for(int i=2;i<modelTab3.getColumnCount();i++){
			for(int y=0;y<modelTab3.getRowCount();y++){
			
				
				if(modelTab3.getValueAt(y, i)!=null && !((String)modelTab3.getValueAt(y, i)).equals("prenotato")){
					
				   String[] asd=((String)modelTab3.getValueAt(y, i)).split(" ");
					
					if(!asd[0].equals(""))
				     durata=Integer.parseInt(asd[0]);
					
					if(durata>=1){
						
						int next=y+(durata*2);
						Tab t=new Tab();
						t.setColonnaCorrente(i);
						t.setRigaCorrente(y);
						t.setRigaFinale(next);
						tabella.add(t);
					
					}
				}
				
				
			}
		}
		for(int i=0;i<tabella.size();i++){
			
			int rigaCorrente=tabella.get(i).getRigaCorrente();
			int colonnaCorrente=tabella.get(i).getColonnaCorrente();
			int rigaFinale=tabella.get(i).getRigaFinale();
			
			for (int j=(rigaCorrente+1);j<rigaFinale;j++){
				   modelTab3.setValueAt("prenotato", j,colonnaCorrente);
			}
		}
			
		
	}
	
	 /**
 	 * Metodo che ritorna la durata di un servizio.
 	 *
 	 * @param idServizio the id servizio
 	 * @return the durata servizio
 	 */
	public int getDurataServizio(String idServizio){
		int durata=0;
		Client client = Client.create();	 
		String nome="null";
		WebResource webResource = client
		   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaServizi/segret/abcd/"+nome);
		
		ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
		
		
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}
		
		String output = response.getEntity(String.class);
		
		try {
			JSONArray array=new JSONArray(output);
			JSONObject object;
			ArrayList<Prestazione>u=new ArrayList<Prestazione>();
			
			for(int i=0;i<array.length();i++){
				object=array.getJSONObject(i);
				Prestazione p=new Prestazione();
				p.setIdPrest(object.getString("idPrest"));
				p.setDurata(object.getString("durata"));
				p.setNomePrest(object.getString("nomePrest"));
				u.add(p);
			}
			
		
			for(int j=0;j<u.size();j++){
        		if(u.get(j).getIdPrest().equals(idServizio))
        			durata=Integer.parseInt(u.get(j).getDurata());
				
               };
			
		} catch (JSONException e) {
			e.printStackTrace();
		}   
		
		return durata;
	}
	
	 /**
 	 * Metodo che ritorna i servizi effettuati.
 	 *
 	 * @param combo the combo
 	 * @return the servizi
 	 */
	public void getServizi(JComboBox<String> combo){
			Client client = Client.create();	 
			String nome="null";
			WebResource webResource = client
			   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaServizi/segret/abcd/"+nome);
			
			ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
			
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			
			String output = response.getEntity(String.class);
			
			try {
				JSONArray array=new JSONArray(output);
				JSONObject object;
				ArrayList<Prestazione>u=new ArrayList<Prestazione>();
				
				for(int i=0;i<array.length();i++){
					object=array.getJSONObject(i);
					Prestazione p=new Prestazione();
					p.setIdPrest(object.getString("idPrest"));
					p.setDurata(object.getString("durata"));
					p.setNomePrest(object.getString("nomePrest"));
					u.add(p);
				}
				
			
				for(int j=0;j<u.size();j++){
	        		
					combo.addItem(""+u.get(j).getNomePrest());
	               };
				
			} catch (JSONException e) {
				e.printStackTrace();
			}   
		
	
	}

	 /**
 	 * Metodo che ritorna il codice di un servizio.
 	 *
 	 * @param tipo the tipo
 	 * @return the info servizio
 	 */
	public String getInfoServizio(String tipo){
			String id="";
			
			Client client = Client.create();	 
			WebResource webResource = client
			   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaServizi/segret/abcd/"+tipo.replace(" ", "_"));
			
			ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
			
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			
			String output = response.getEntity(String.class);
			
			try {
				JSONArray array=new JSONArray(output);
				JSONObject object;
				ArrayList<Prestazione>u=new ArrayList<Prestazione>();
				
				for(int i=0;i<array.length();i++){
					object=array.getJSONObject(i);
					Prestazione p=new Prestazione();
					p.setIdPrest(object.getString("idPrest"));
					p.setDurata(object.getString("durata"));
					p.setNomePrest(object.getString("nomePrest"));
					u.add(p);
				}
				
			
				for(int j=0;j<u.size();j++){
	        		
					id=u.get(j).getIdPrest();
	               };
				
			} catch (JSONException e) {
				e.printStackTrace();
			}    
			
			return id;	
	}
	
	
	 /**
 	 * Metodo che ritorna una JTable.
 	 *
 	 * @return the table
 	 */
	public JTable getTable(){
		return table3;
	}
	
	 /**
 	 * Metodo che ritorna un ModelTab.
 	 *
 	 * @return the model tab
 	 */
	public DefaultTableModel getModelTab(){
		return modelTab3;
	}
	
	 /**
 	 * Metodo che setta il nome di un paziente.
 	 *
 	 * @param nome the nome
 	 * @param codice the codice
 	 */
	public void setNome(String nome,String codice){
		textField.setText(""+nome);
		codiceCliente=codice;
	}
	
	
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCalendario().setVisible(true);
            }
        });
    }

    /**
     * Metodo che chiude il frame appuntamenti.
     */ 
    public void esci(){
    	
    	this.dispose();
    }
    
    /**
     * Classe che chiude la schermata appuntamenti.
     */ 
    public class chiudiTutto implements ActionListener{

	    private FormCalendario c;
    	
    	/**
	     * Instantiates a new chiudi tutto.
	     *
	     * @param <c><Form da chiudere>
	     */
	    public chiudiTutto(FormCalendario c){
    		this.c=c;
    	}
		public void actionPerformed(ActionEvent e) {
			c.esci();
			
		}

    }
    
    

    
}
