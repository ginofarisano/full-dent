package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LetterDocument extends PlainDocument {

	private static final long serialVersionUID = 1L;

	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
	       
		        if(str.contains("a") || str.contains("b") || str.contains("c") || str.contains("d") || str.contains("e") || str.contains("f")
				|| str.contains("g") || str.contains("h") || str.contains("i") || str.contains("l") || str.contains("m")
				|| str.contains("n") || str.contains("o") || str.contains("p") || str.contains("q") || str.contains("r") 
				|| str.contains("s") || str.contains("t") || str.contains("u") || str.contains("v") || str.contains("z")
				|| str.contains("j") || str.contains("k") || str.contains("x") || str.contains("y") ||str.contains("A") 
				|| str.contains("B") || str.contains("C") || str.contains("D") || str.contains("E") || str.contains("F")
				|| str.contains("G") || str.contains("H") || str.contains("I") || str.contains("L") || str.contains("M")
				|| str.contains("N") || str.contains("O") || str.contains("P") || str.contains("Q") || str.contains("R") 
				|| str.contains("S") || str.contains("T") || str.contains("U") || str.contains("V") || str.contains("Z")
				|| str.contains("j") || str.contains("K") || str.contains("X") || str.contains("Y")&& str!=null)
			super.insertString(offs, str, a);
	
    }
	
	
}