package pethotel;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.*;

public class ActiveReservationsTable {
	
	String[] tblColumnNames = {"Drop-Off Date", "Pick-up Date", "Pet Type", "Pet Name", "Owner", "Breed", "Res ID"};
	DefaultTableModel tableModel;
	
	JTable table;
	JScrollPane scrollPane;
	
	
	public ActiveReservationsTable() {
		
		tableModel = new DefaultTableModel(tblColumnNames, 0) {
	        @Override
	        public Class getColumnClass(int columnIndex) {
	            //if (columnIndex == 0)
	            //	return Boolean.class;
	            //else
	            	return String.class;
	        }
	        
	        @Override
	        public boolean isCellEditable(int row, int column) {
	        	//if (column == 0)
	        	//	return true;
	        	//else
	        		return false;
	        }
	     };
	     
		loadActiveReservations();
		table = new JTable(tableModel);
		scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		table.setMinimumSize(new Dimension(760, 400));
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setRowHeight(30);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setSelectionBackground(Color.LIGHT_GRAY);
		table.setSelectionForeground(Color.BLUE);
		
		JTableHeader header = table.getTableHeader();
		header.setDefaultRenderer(new TableHeaderRenderer(header.getDefaultRenderer()));
		header.setPreferredSize(new Dimension(scrollPane.getWidth(), 35));
		header.setToolTipText("Click on a column header to sort by the column");
	}
	
	
	public void loadActiveReservations() {
		Reservation currRes = null;
		int resSize = ReservationFileHandler.activeResList.size();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
		
		for (int r = 0; r < resSize; r++) {
			currRes = ReservationFileHandler.activeResList.get(r);
	    	 Object[] data = new Object[tblColumnNames.length];
	    	 data[0] = dateFormatter.format(currRes.getBeginDate());
	    	 data[1] = dateFormatter.format(currRes.getEndDate());
	    	 data[2] = currRes.getPetTypeString();
	    	 data[3] = currRes.getAnimal().getName();
	    	 data[4] = currRes.getOwner().getName();
	    	 data[5] = currRes.getAnimal().getBreedString();
	    	 data[6] = currRes.getReservationId();
	    	 
		     tableModel.addRow(data);
	      }
	}
	
	
	public JComponent getContent() {
		
		return scrollPane;
	}
}
