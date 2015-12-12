package gestioneCalendario;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * Classe che gestisce un elenco predefinito di appuntamenti.
 * @author Max
 *
 */
public class RichiamiPeriodici {

	/** The elenco. */
	private ArrayList<DatiAppuntamento> elenco;

	/**
	 * Crea un elenco vuoto.
	 *
	 * @param nuovo the nuovo
	 * @throws SQLException errore con il DataBase.
	 * @throws ClassNotFoundException classe non trovata.
	 */
	public RichiamiPeriodici(ArrayList<DatiAppuntamento> nuovo) throws SQLException, ClassNotFoundException{
		elenco = nuovo;
	}
	
	/**
	 * Aggiunge un elemento alla lista.
	 * @param nuovo l'elemento da aggiungere.
	 */
	public void addElement(DatiAppuntamento nuovo){
		elenco.add(nuovo);
	}
	
	/**
	 * Rimuove un elemento dalla lista.
	 * @param app l'elemento da rimuovere.
	 */
	public void removeElement(DatiAppuntamento app){
		for(int i = 0; i< elenco.size(); i++)
			if(elenco.get(i).equals(app)){
				elenco.remove(i);
				break;
			}
	}

}
