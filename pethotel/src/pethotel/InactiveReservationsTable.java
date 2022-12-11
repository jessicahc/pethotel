package pethotel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;


public class InactiveReservationsTable implements ListSelectionListener {
	
	String[] tblColumnNames = {"Drop-Off Date", "Pick-up Date", "Pet Type", "Pet Name", "Owner", "Breed", "Res ID"};
	DefaultTableModel tableModel;
	ListSelectionModel selectionModel;
	ActionListener guiActionListener;
	
	JTable table;
	JScrollPane scrollPane;
	
	
	public InactiveReservationsTable(ActionListener actionListener) {
		
		tableModel = new DefaultTableModel(tblColumnNames, 0) {
	        @Override
	        public Class getColumnClass(int columnIndex) {	            
	        	if (columnIndex == tblColumnNames.length-1)
	        		return Integer.class;
	        	else
	            	return String.class;
	        }
	        
	        @Override
	        public boolean isCellEditable(int row, int column) {	        	
	        		return false;
	        }
	     };
	     	
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
		
		this.selectionModel = table.getSelectionModel();		
		this.selectionModel.addListSelectionListener(this);	
		this.guiActionListener = actionListener;
		
		JTableHeader header = table.getTableHeader();
		header.setDefaultRenderer(new TableHeaderRenderer(header.getDefaultRenderer()));
		header.setPreferredSize(new Dimension(scrollPane.getWidth(), 35));
		header.setToolTipText("Click on a column header to sort by the column");
	}
	
	public Reservation getSelectedReservation() {
		int row = table.getSelectedRow();
		System.out.println("INactiveResTable: selected row=" + row);
		// Get the reservation ID of the selected row
		Object o = table.getValueAt(row, tblColumnNames.length-1);
		//Object o = tableModel.getValueAt(row, tblColumnNames.length-1);
		System.out.println("INactiveResTable: selected sid =" + (Integer)o);
		
		int id = ((Integer)o).intValue();
		System.out.println("INactiveResTable: selected id =" + id);
		System.out.println("Reservation ID " + id + " is selected");
		Reservation r = ReservationFileHandler.allReservationsList.get(id-1);
		return r;
	}
	
	public void loadInactiveReservations() {
		Reservation currRes = null;
		int resSize = ReservationFileHandler.allReservationsList.size();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
		
		for (int r = 0; r < resSize; r++) {
			currRes = ReservationFileHandler.allReservationsList.get(r);
			//TODO: Check reservation status before adding to table
			
	    	 Object[] data = new Object[tblColumnNames.length];
	    	 data[0] = dateFormatter.format(currRes.getBeginDate());
	    	 data[1] = dateFormatter.format(currRes.getEndDate());
	    	 data[2] = currRes.getAnimal().getPetType();
	    	 data[3] = currRes.getAnimal().getPetName();
	    	 data[4] = currRes.getOwner().getName();
	    	 data[5] = currRes.getAnimal().getBreedString();
	    	 data[6] = currRes.getReservationId();
	    	 
		     tableModel.addRow(data);
	      }
	}
		
	
	public JComponent getContent() {
		loadInactiveReservations();
		return scrollPane;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(selectionModel)) {			
			System.out.println("INactiveReservationsTable notifying GUI: selected row=" + table.getSelectedRow());			
			ActionEvent ae = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "InactiveReservationsTable");
			guiActionListener.actionPerformed(ae);
		}		
	}
}

