package bean;

public class RiepilogoStorico {
	
	private String data;
	private String ora;
	private String Prestnome;
	private String PersNome;
	private String PersCognome;
	private String note;
	private String pagato;
	private String idPrenotazione;
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
	public String getPrestnome() {
		return Prestnome;
	}
	public void setPrestnome(String prestnome) {
		Prestnome = prestnome;
	}
	public String getPersNome() {
		return PersNome;
	}
	public void setPersNome(String persNome) {
		PersNome = persNome;
	}
	public String getPersCognome() {
		return PersCognome;
	}
	public void setPersCognome(String persCognome) {
		PersCognome = persCognome;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPagato() {
		return pagato;
	}
	public void setPagato(String pagato) {
		this.pagato = pagato;
	}
	public String getIdPrenotazione() {
		return idPrenotazione;
	}
	public void setIdPrenotazione(String idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	
	
	
	
	@Override
	public String toString() {
		
		return"RiepilogoStorico["
		+ " data=" + data
		+ ", ora=" + ora 
		+ ", Prestnome=" + Prestnome
		+ ", persNome=" + PersNome
		+ ", persCognome=" + PersCognome 
		+ ", note=" + note
		+ ", pagato=" + pagato
		+ ", idPrenotazione=" + idPrenotazione
		+"]";

		
	}
	
	
	
}
