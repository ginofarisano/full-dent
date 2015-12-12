package gestioneFornitori;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class TstDBFornitori.
 */
public class TstDBFornitori {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		Date dat = new Date();
		
		int giorno = dat.getDate();
		int mese = dat.getMonth()+1;
		int anno = dat.getYear()+1900;
		String tempo = giorno+"/0"+mese+"/"+anno;
		System.out.println(tempo);
		int g = Integer.parseInt(tempo.substring(0,2));
		System.out.println(g);
		int m = Integer.parseInt(tempo.substring(3,5));
		System.out.println(m+" "+tempo.substring(6));
	}
	
}
