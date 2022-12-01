package pethotel;
import java.awt.Color;

import javax.swing.*;


public class NewReservationForm {

	JLabel lblName;
	JTextField txtName;
	
	JPanel mainPanel;
	
	public NewReservationForm() {
		lblName = new JLabel("First and Last Name");
		txtName = new JTextField(30);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.MAGENTA);
	}
	
	public JComponent getContent() {
		mainPanel.add(lblName);
		mainPanel.add(txtName);
		return mainPanel;
	}
}