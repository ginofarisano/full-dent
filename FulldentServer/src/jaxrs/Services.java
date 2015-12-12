package jaxrs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import db.DBAccount;
import bean.Appuntamento;
import bean.Personale;
import bean.Prenotazione;
import bean.Prestazione;
import bean.RiepilogoStorico;
import bean.Storico;
import bean.StoricoPaziente;
import bean.Utente;
import bean.Visita;

@Path("/services")
public class Services {

	@GET
	@Path("/login/{user}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Utente login(@PathParam("user") String user,
			@PathParam("password") String password) {
		try {
			DBAccount db = new DBAccount();
			

			try {
				db.openConnection();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return db.getAccount(user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Utente();

	}

	@GET
	@Path("/storico/{user}/{password}/{da}/{a}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Visita> storico(@PathParam("user") String user,
			@PathParam("password") String password, @PathParam("da") String da,
			@PathParam("a") String a) {
		DBAccount db;
		try {
			db = new DBAccount();
			try {
				db.openConnection();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

			return db.getStorico(user, password,da.replace("-", "/"),a.replace("-", "/"));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	@GET
	@Path("/appuntamento/{user}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Visita appuntamento(@PathParam("user") String user,
			@PathParam("password") String password) {
		DBAccount db;
		try {
			db = new DBAccount();
			try {
				db.openConnection();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return db.getAppuntamento(user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
	
	@POST
	@Path("/insertUtente/{user}/{password}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserisci(Utente u,@PathParam("user") String user,@PathParam("password") String password){
		DBAccount db = null;
		try {
			db = new DBAccount();
			try {
				db.openConnection();
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if(db.insertUtente(u,user,password).equals("ok")){
				return Response.status(201).entity("ok").build();
			}
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
				
	}
	
	
	@POST
	@Path("/insertPrenotazione/{user}/{password}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserisciPren(Prenotazione p,@PathParam("user") String user,@PathParam("password") String password){
		DBAccount db = null;
		try {
			db = new DBAccount();
			try {
				db.openConnection();
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if(db.insertPrenotazione(p,user,password).equals("ok")){
				return Response.status(201).entity("ok").build();
			}
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
				
	}
	
	
	@POST
	@Path("/insertStorico/{user}/{password}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserisciStorico(StoricoPaziente p,@PathParam("user") String user,@PathParam("password") String password){
		DBAccount db = null;
		try {
			db = new DBAccount();
			try {
				db.openConnection();
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if(db.insertStorico(p,user,password).equals("ok")){
				return Response.status(201).entity("ok").build();
			}
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
				
	}
	
	
	
	@POST
	@Path("/eliminaPrenotazione/{user}/{password}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response eliminaPrenotazione(Prenotazione p,@PathParam("user") String user,@PathParam("password") String password){
		DBAccount db = null;
		try {
			db = new DBAccount();
			try {
				db.openConnection();
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if(db.eliminaPrenotazione(p,user,password).equals("ok")){
				return Response.status(201).entity("ok").build();
			}
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
				
	}
	

	
	@GET
	@Path("/listaClienti/{user}/{password}/{cognome}/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Utente> listaClienti(@PathParam("user") String user,@PathParam("password") String password,
			@PathParam("cognome") String cognome,@PathParam("nome") String nome){
		DBAccount db = null;
			try {
				db = new DBAccount();
		
				try {
					db.openConnection();
		
			return db.getClienti(user, password,cognome,nome);
	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();}
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		return null;
				
	}
	
	@GET
	@Path("/listaDottori/{user}/{password}/{nome}/{cognome}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Personale> listaDottori(@PathParam("user") String user,@PathParam("password") String password,
			@PathParam("nome") String nome,@PathParam("cognome") String cognome){
		DBAccount db = null;
			try {
				db = new DBAccount();
		
				try {
					db.openConnection();
		
			return db.getCollaboratori(user, password,nome,cognome);
	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();}
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		return null;
				
	}

	
	@GET
	@Path("/listaDottoriCodice/{user}/{password}/{codice}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Personale> listaDottori(@PathParam("user") String user,@PathParam("password") String password,
			@PathParam("codice") String codice){
		DBAccount db = null;
			try {
				db = new DBAccount();
		
				try {
					db.openConnection();
		
			return db.getCollaboratoriCodice(user, password,codice);
	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();}
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		return null;
				
	}
	
	@GET
	@Path("/getAppuntamenti/{user}/{password}/{data}/{ora}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Appuntamento> getAppuntamenti(@PathParam("user") String user,
			@PathParam("password") String password, @PathParam("data") String data,
			@PathParam("ora") String ora) {
		DBAccount db;
		try {
			db = new DBAccount();
			try {
				db.openConnection();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return db.getAppuntamenti(user, password,data.replace("-", "/"),ora);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	
	@GET
	@Path("/listaServizi/{user}/{password}/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Prestazione> listaServizi(@PathParam("user") String user,@PathParam("password") String password,
			@PathParam("nome") String nome){
		DBAccount db = null;
			try {
				db = new DBAccount();
		
				try {
					db.openConnection();
		
			return db.getServizi(user, password,nome);
	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();}
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		return null;
				
	}

	@GET
	@Path("/listaStorico/{user}/{password}/{idPrenotazione}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<StoricoPaziente> listaStorico(@PathParam("user") String user,@PathParam("password") String password,
			@PathParam("idPrenotazione") String idPrenotazione){
		DBAccount db = null;
			try {
				db = new DBAccount();
		
				try {
					db.openConnection();
		
			return db.getStorico(user, password,idPrenotazione);
	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();}
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		return null;
				
	}
	
	
	@GET
	@Path("/listaPrenotazione/{user}/{password}/{data}/{ora}/{codiceMedico}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Prenotazione> listaPrenotazione(@PathParam("user") String user,@PathParam("password") String password,
			@PathParam("data") String data,@PathParam("ora") String ora,@PathParam("codiceMedico") String codiceMedico){
		DBAccount db = null;
			try {
				db = new DBAccount();
		
				try {
					db.openConnection();
		
			return db.getPrenotazione(user, password,data.replace("-", "/"),ora,codiceMedico);
	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();}
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		return null;
				
	}
	
	
	@GET
	@Path("/listaPrenotazioneData/{user}/{password}/{data}/{ora}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Prenotazione> listaPrenotazioneData(@PathParam("user") String user,@PathParam("password") String password,
			@PathParam("data") String data,@PathParam("ora") String ora){
		DBAccount db = null;
			try {
				db = new DBAccount();
		
				try {
					db.openConnection();
		
			return db.getPrenotazioneData(user, password,data.replace("-", "/"),ora);
	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();}
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		return null;
				
	}
	
	@GET
	@Path("/codicePrenotazione/{user}/{password}/{codice}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Prenotazione> codicePrenotazione(@PathParam("user") String user,@PathParam("password") String password,
			@PathParam("codice") String codice){
		DBAccount db = null;
			try {
				db = new DBAccount();
		
				try {
					db.openConnection();
		
			return db.getPrenotazioneCodice(user, password,codice);
	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();}
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		return null;
				
	}
	
	
	@POST
	@Path("/modificaStorico/{user}/{password}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificaStorico(StoricoPaziente p,@PathParam("user") String user,@PathParam("password") String password){
		DBAccount db = null;
		try {
			db = new DBAccount();
			try {
				db.openConnection();
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if(db.modificaStorico(p,user,password).equals("ok")){
				return Response.status(201).entity("ok").build();
			}
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
				
	}
	
	
	@POST
	@Path("/modificaPagatoStorico/{user}/{password}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificaPagatoStorico(StoricoPaziente p,@PathParam("user") String user,@PathParam("password") String password){
		DBAccount db = null;
		try {
			db = new DBAccount();
			try {
				db.openConnection();
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if(db.modificaPagatoStorico(p,user,password).equals("ok")){
				return Response.status(201).entity("ok").build();
			}
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
				
	}
	
	@POST
	@Path("/modificaPaziente/{user}/{password}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificaPaziente(Utente p,@PathParam("user") String user,@PathParam("password") String password){
		DBAccount db = null;
		try {
			db = new DBAccount();
			try {
				db.openConnection();
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if(db.modificaPaziente(p,user,password).equals("ok")){
				return Response.status(201).entity("ok").build();
			}
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
				
	}
	


	
	@GET
	@Path("/listaResetClienti/{user}/{password}/{idPaziente}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Utente> listaResetClienti(@PathParam("user") String user,@PathParam("password") String password,
			@PathParam("idPaziente") String idPaziente){
		DBAccount db = null;
			try {
				db = new DBAccount();
		
				try {
					db.openConnection();
		
			return db.getResetClienti(user, password,idPaziente);
	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();}
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		return null;
				
	}
	
	
	@GET
	@Path("/listaRiepilogoServizi/{user}/{password}/{codiceUtente}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<RiepilogoStorico> listaRiepilogoServizi(@PathParam("user") String user,@PathParam("password") String password,
			@PathParam("codiceUtente") String codiceUtente){
		DBAccount db = null;
			try {
				db = new DBAccount();
		
				try {
					db.openConnection();
		
			return db.getRiepilogoStorico(user, password,codiceUtente);
	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();}
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		return null;
				
	}


	
	
	
}