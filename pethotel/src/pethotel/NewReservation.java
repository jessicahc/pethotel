// NewReservation is a subclass of BaseReservationForm, 
// which inherits all common GUI components that are needed
// in the "New Reservation" screen. It also contains its
// own unique data fields for the "Save Reservation" button
// and other GUI related components. 
//
// NewReservation is also an ActionListener to handle user's
// request to save the info of a new reservation
// when the "Save Reservation" button is clicked.
//
// Author: Vighnesh Dheenadhayalan

package pethotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NewReservation extends BaseReservationForm implements ActionListener{
	
	//only button needed to save the new registration
	private JButton buttonSave;
	
	private JPanel mainPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	
	
	public NewReservation() {
		super();
			
		//ALL THE SOUTHPANEL STUFFS
		buttonSave = new JButton();
		buttonSave.setSize(20,15);
		buttonSave.setText("Save Reservation");
		buttonSave.addActionListener(this);
		southPanel.add(buttonSave);
		southPanel.setBorder(new EmptyBorder(5, 0, 15, 0));
		southPanel.setBackground(MainGUI.BGCOLOR_LIGHTBLUE);
		
	}

	
	public JComponent getContent() {
		centerPanel.setBorder(new EmptyBorder(30, 40, 20, 40));
		
		//ADDING ALL THE PANELS TO THE MAINPANEL
		mainPanel.setLayout(new BorderLayout(0, 10));
		mainPanel.add(BorderLayout.CENTER, bar);		
		mainPanel.add(BorderLayout.SOUTH, southPanel);
		mainPanel.setBackground(MainGUI.BGCOLOR_LIGHTBLUE);
		
		return mainPanel;
	}
	
	public Reservation saveReservation() {
		
		Owner a = new Owner(ownerName.getText(), addr.getText(), phon.getText());
		a.setCity(cit.getText());
		a.setState((String)stateList.getSelectedItem());
		a.setZipCode(zipc.getText());
		
		Animal b = null;
		if(cat.isSelected()) {
			b = new Cat();
		}
		else if (dog.isSelected()) {
			b = new Dog();
			String w = wtime.getText();
			if (w != null && !w.trim().isEmpty()) {
				int walktime = Integer.parseInt(wtime.getText());
				((Dog)b).setMaxWalkingTime(walktime);
			}
			else
				((Dog)b).setMaxWalkingTime(Dog.DEFAULT_MAX_WALKING_TIME);
		}
		
		b.setName(petname.getText());
		
		b.setAge(ages.getSelectedIndex()+1);
		
		if (male.isSelected())
			b.setSex(Animal.SEX_MALE);
		else if (female.isSelected())
			b.setSex(Animal.SEX_FEMALE);
		
		b.setBreed((String)breedList.getSelectedItem());
		
		if(lower.isSelected()) 
			b.setSize(Animal.SIZE_SMALL);	
		else if(ulower.isSelected())
			b.setSize(Animal.SIZE_MEDIUM);	
		else if(higher.isSelected())
			b.setSize(Animal.SIZE_LARGE);
		else if(uhigher.isSelected())
			b.setSize(Animal.SIZE_EXLARGE);
		
		
		if(hYes.isSelected()) {
			b.setHumanReactive(true);
		}
		else if(hNo.isSelected()) {
			b.setHumanReactive(false);
		}
		if(aYes.isSelected()) {
			b.setAnimalReactive(true);
		}
		else if(aNo.isSelected()) {
			b.setAnimalReactive(false);
		}
		
		Reservation res = new Reservation(a, b);
		res.setBeginDate(from.getText());
		res.setEndDate(to.getText());
		
		if(hfood.isSelected()) {
			res.setFoodOption(Reservation.FOOD_FROM_HOTEL);
		}
		else {
			res.setFoodOption(Reservation.FOOD_FROM_OWNER);
		}
			
		res.setOwnerInstruction(instr.getText());

		// Add this new reservation to the static global Reservation.allReservationsList
		Reservation.addNewReservationToList(res);
		
		return res;
	}
	
	public boolean validateInput() {
		if (!Reservation.isValidDuration(from.getText(), to.getText())) {
			JOptionPane.showMessageDialog(mainPanel, "Invalid DropOff & PickUp dates!\nPlease double check.",
					 "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		String s = ownerName.getText();
		if ( s == null || s.trim().isEmpty()) {
			JOptionPane.showMessageDialog(mainPanel, "Missing Owner Name!",
											"ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		String p = pname.getText();
		if ( p == null || p.trim().isEmpty()) {
			JOptionPane.showMessageDialog(mainPanel, "Missing Pet's Name!",
					 						"ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (!dog.isSelected() && !cat.isSelected()) {
			JOptionPane.showMessageDialog(mainPanel, "Missing Pet Type!\nPlease select either Dog or Cat",
											"ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (!male.isSelected() && !female.isSelected()) {
			JOptionPane.showMessageDialog(mainPanel, "Missing Pet's Sex!\nPlease select either Male or Female",
											"ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (!lower.isSelected() && !ulower.isSelected() && !higher.isSelected() && !uhigher.isSelected()) {
			JOptionPane.showMessageDialog(mainPanel, "Missing Pet's Size!\nPlease select a pet size",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		/*
		if (!ofood.isSelected() && !hfood.isSelected()) {
			JOptionPane.showMessageDialog(mainPanel, "Please select a Pet's Food Option.",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		*/
		
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == buttonSave) {
			Reservation newRes = null;
			if (validateInput()) {
				newRes = saveReservation();
				if (newRes != null) {
					JOptionPane.showMessageDialog(mainPanel, "New Reservation Created!\n" +
								"Assigned Reservation ID is " + newRes.getReservationId(),
								"INFO", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		
	}
}