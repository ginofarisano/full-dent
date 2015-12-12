package bean;

import java.util.ArrayList;

public class Storico {
	private ArrayList<Visita> visite = new ArrayList<Visita>();

	public ArrayList<Visita> getStorico(int i) {
		return visite;

	}

	public void setStorico(ArrayList<Visita> visite) {
		this.visite = visite;
	}
	
	
	@Override
	public String toString() {
		return visite.toString();
	}

}
