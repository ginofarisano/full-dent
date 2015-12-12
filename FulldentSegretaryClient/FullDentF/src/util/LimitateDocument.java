package util;

import javax.swing.text.*;

	public class LimitateDocument extends DefaultStyledDocument {

		private static final long serialVersionUID = 1L;

		private final int NUMERO_MASSIMO_CARATTERI;
		
		public LimitateDocument(int numeroMassimoCaratteri) {
			NUMERO_MASSIMO_CARATTERI = numeroMassimoCaratteri;
		}
		
		public void insertString(int off, String text, AttributeSet att) 
			throws BadLocationException
		{
			int numeroCaratteriNelDocumento = getLength();
			int lunghezzaNuovoTesto = text.length();
			if(numeroCaratteriNelDocumento + lunghezzaNuovoTesto > 
				NUMERO_MASSIMO_CARATTERI) 
			{
				int numeroCaratteriInseribili = 
					NUMERO_MASSIMO_CARATTERI - numeroCaratteriNelDocumento;	
				if(numeroCaratteriInseribili > 0) { //altrimenti il documento è pieno
					String parteNuovoTesto = text.substring(0, numeroCaratteriInseribili);
					super.insertString(off, parteNuovoTesto, att);
				}
			} else {
				super.insertString(off, text, att);
			}
		}
	}

