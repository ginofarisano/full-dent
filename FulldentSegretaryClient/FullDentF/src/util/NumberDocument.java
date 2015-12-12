package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumberDocument extends PlainDocument {

	private static final long serialVersionUID = 1L;

	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
       
		if(str.contains(".") || str.contains("0") || str.contains("1") || str.contains("2") || str.contains("3") || str.contains("4") ||
				str.contains("5") ||str.contains("6") ||str.contains("7") ||str.contains("8") ||
				str.contains("9")  && str!=null && str.matches("[\\d]*"))
			super.insertString(offs, str, a);
	
    }
	
	
}