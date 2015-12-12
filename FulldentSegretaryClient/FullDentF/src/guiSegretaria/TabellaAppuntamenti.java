package guiSegretaria;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class TabellaAppuntamenti extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;
	private Color currentColor = Color.white;
		Map<Integer,String> colori = new HashMap<>();
	  
      public TabellaAppuntamenti(Map<Integer, String> colori2) {
    	this.colori=colori2;
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int col) {

    	if(col!=0 && col!=1){
    		
	         if (table.getValueAt(row, col)!=null) {
		            super.setForeground(Color.white);
		            super.setBackground(new Color(243,105,113));
	         	} else {
	        		super.setForeground(Color.black);
	        		super.setBackground(currentColor);
	         }
    	
    	}
    	
        setFont(table.getFont());
        setValue(value);
        return this;
    }
}
