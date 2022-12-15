// InactiveReservationTable is a GUI class responsible for generating
// a table containing all inactive (expired or cancelled)
// reservations. The table only displays the most important info of
// each reservation, e.g. Status, Drop-Off Date, Pick-Up Date, PetType,
// PetName, Owner, Breed, and ReservationID. It also allows the user
// to select a specific reservation from the table to view its details 
// or generate a bill & report for the reservation.
//
// NOTE: To reduce coding complexity, users are not allowed to
// modify any details of an inactive reservation. Users must create
// a new reservation if they want to change dates, owner, or pet info.
//
// Author: Jessica Chen

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
	
	private String[] tblColumnNames = {"Status", "Drop-Off Date", "Pick-up Date", "Pet Type", "Pet Name", "Owner", "Breed", "Res ID"};
	private DefaultTableModel tableModel;
	private ListSelectionModel selectionModel;
	private ActionListener guiActionListener;
	
	private JTable table;
	private JScrollPane scrollPane;
	
	
	public InactiveReservationsTable(ActionListener actionListener) {
		
		tableModel = new DefaultTableModel(tblColumnNames, 0) {
	        @Override
	        public Class getColumnClass(int columnIndex) {
	        	// Treat the last column ReservationID as Integer
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
		// Get the reservation ID of the selected row
		int row = table.getSelectedRow();	
		Object o = table.getValueAt(row, tblColumnNames.length-1);
			
		int id = ((Integer)o).intValue();
		System.out.println("ActiveReservation: Reservation ID " + id + " is selected");
		Reservation r = Reservation.getReservationFromList(id);
		System.out.println("ActiveReservation: Owner " + r.getOwner().getName()+ " is selected");
		
		return r;
	}
	
	public void loadInactiveReservations() {
		Reservation currRes = null;
		int resSize = Reservation.allReservationsList.size();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
		
		for (int r = 0; r < resSize; r++) {
			currRes = Reservation.allReservationsList.get(r);
			
			if (!currRes.isActive()) {
				Object[] data = new Object[tblColumnNames.length];
				data[0] = currRes.getStatusString();
				data[1] = dateFormatter.format(currRes.getBeginDate());
				data[2] = dateFormatter.format(currRes.getEndDate());
				data[3] = currRes.getAnimal().getSpecies();
				data[4] = currRes.getAnimal().getName();
				data[5] = currRes.getOwner().getName();
				data[6] = currRes.getAnimal().getBreedString();
				data[7] = currRes.getReservationId();
	    	 
				tableModel.addRow(data);
			}
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

