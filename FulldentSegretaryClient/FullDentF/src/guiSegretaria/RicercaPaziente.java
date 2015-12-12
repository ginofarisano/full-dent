package guiSegretaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.Costanti;
import bean.Utente;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Classe che ricerca un paziente.
 *
 * @author V.Esposito
 */



public class RicercaPaziente implements ActionListener {

	private GuiModificaPaziente p;
	
	/**
	 * Instantiates a new ricerca paziente.
	 *
	 * @param p the p
	 */
	public RicercaPaziente(GuiModificaPaziente p){
		this.p=p;
	}


	public void actionPerformed(ActionEvent arg0) {

		
		String nom="",cogn="";
		
			nom=p.getNomeRicerca();
			cogn=p.getCognomeRicerca();
	
		if(nom.equals(""))
			nom="null";
		if(cogn.equals(""))
			cogn="null";
			
			Client client = Client.create();	 
			WebResource webResource = client
			   .resource(Costanti.RICHIESTADATI+"/FulldentServer/jaxrs/services/listaClienti/segret/abcd/"+cogn+"/"+nom);
			
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
			
				while (p.getModelTable().getRowCount() > 0) 
            		p.getModelTable().removeRow(0);
				
	        	for(int j=0;j<u.size();j++){
	        		
	            	Object[] rowData = {
	                 "",u.get(j).getNome(), u.get(j).getCognome(), u.get(j).getIndirizzo(),
	                u.get(j).getTelefono(), u.get(j).getEmail(),u.get(j).getCodiceFiscale()
	               };
	   
	            	p.getModelTable().addRow(rowData);
	        		
	        		
	        	}
	     
	        		
			} catch (JSONException e) {
				e.printStackTrace();
			}
		
		
	}

}
