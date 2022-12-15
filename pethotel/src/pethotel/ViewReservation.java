// ViewReservation is a subclass of BaseReservationForm, 
// which inherits all common GUI components that are needed
// in the "View/Modify Reservation" screen. It also contains its
// own unique data fields for 3 buttons: "Update Reservation",
// "Cancel Reservation", and "Generate Bill and Report",
// plus other GUI related components. 
//
// NewReservation is also an ActionListener to handle user's
// request when each of the 3 buttons is clicked.
//
// Author: Vighnesh Dheenadhayalan, Jessica Chen

package pethotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class ViewReservation extends BaseReservationForm implements ActionListener{

	public static Color FGCOLOR_DEEPRED = new Color(176, 35, 63);
	
	//All the Buttons in the southPanel
	private JButton buttonUpdate = new JButton();
	private JButton buttonCancel = new JButton();
	private JButton buttonBill = new JButton();
		
	private JLabel id = new JLabel();  // reservation ID
	private JLabel status = new JLabel(); // active vs. inactive
	
	private JLabel lblDepositAmount = new JLabel("Initial Deposit Amount ($)");
	private JTextField tfDepositAmount = new JTextField("0.00",5);
	
	private JLabel cagenum = new JLabel("Cage #");
	private JComboBox<String> cage = new JComboBox<String>();
	private JLabel cageInstr = new JLabel("(To change Cage #, select a new cage number from the list)");
	
	private JLabel comments = new JLabel("Care Attendant's Comments");
	private JTextArea comm = new JTextArea(5, 50);
	private JScrollPane commAreaScrollPane = new JScrollPane(comm, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
													JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	private JPanel mainPanel = new JPanel();
	private JPanel formPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();

	private Reservation reservation;
	
	private Bill bill;
	private ActivityReport report;
	private JButton saveFile = new JButton("Save to File");
	
	
	public ViewReservation(Reservation r) {
		super();
		
		this.reservation = r;
		
		id.setFont(fLarge);
		status.setFont(fLarge);
		status.setForeground(FGCOLOR_DEEPRED);
		lblDepositAmount.setFont(ftext);
		tfDepositAmount.setFont(ftext);
		cagenum.setFont(f);
		cageInstr.setFont(ftext);
		comments.setFont(f);
		
		// NorthPanel containing ReservationID, Status, DepositAmount
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.anchor= GridBagConstraints.NORTHWEST;
		gbc1.weightx = 1; // Push all GUI items to left to line up
		gbc1.weighty = 0; 
		
		gbc1.insets = new Insets(15, LEFT_PADDING_SIZE, 20, 0);  //set top and bottom spacing
		gbc1.gridx=0;
		gbc1.gridy=0;
		JPanel idStatusPanel = genHorizontalComponentGroup(id, status, 10);
		northPanel.add(idStatusPanel, gbc1);
		
		gbc1.insets = new Insets(0, LEFT_PADDING_SIZE, 10, 0);  //reset top and bottom spacing
		gbc1.gridx=0;
		gbc1.gridy=1;
		JPanel depositAmountPanel = genHorizontalComponentGroup(lblDepositAmount, tfDepositAmount, 10);
		northPanel.add(depositAmountPanel, gbc1);
		
		
		// South Panel containing Cage#, Care Attendant's Comment
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.anchor= GridBagConstraints.NORTHWEST;
		gbc2.weightx = 1; // Push all GUI items to left to line up
		gbc2.weighty = 0; 
		
		gbc2.insets = new Insets(15, LEFT_PADDING_SIZE, 15, 0);  //reset top and bottom spacing		
		gbc2.gridx=0;
		gbc2.gridy=0;
		JPanel cagePanel = genHorizontalComponentGroup(cagenum, cage, cageInstr, 10);
		southPanel.add(cagePanel, gbc2);
		
		gbc2.insets = new Insets(0, LEFT_PADDING_SIZE, 15, 0);  //reset top and bottom spacing
		gbc2.gridx=0;
		gbc2.gridy=1;
		JPanel commentPanel = genVerticalComponentGroup(comments, commAreaScrollPane, 10);
		southPanel.add(commentPanel, gbc2);
			
		
		//ADDING ALL THE PANELS TO THE SCROLL PANE
		formPanel.setLayout(new BorderLayout(0, 15));
		formPanel.setBorder(new EmptyBorder(10, 40, 0, 40));
		formPanel.add(BorderLayout.NORTH, northPanel);
		formPanel.add(BorderLayout.CENTER, centerPanel);
		formPanel.add(BorderLayout.SOUTH, southPanel);
		bar.setViewportView(formPanel);
		
		//ALL THE SOUTHPANEL STUFFS
		//Buttons in the south panel
		buttonUpdate.setSize(20,40);
		buttonUpdate.setText("Update Reservation");
		buttonUpdate.addActionListener(this);
					
		buttonCancel = new JButton();
		buttonCancel.setSize(20, 40);
		buttonCancel.setText("Cancel Reservation");
		buttonCancel.addActionListener(this);
						
		buttonBill = new JButton();
		buttonBill.setSize(20,40);
		buttonBill.setText("Generate Bill and Report");
		buttonBill.addActionListener(this);
							
		buttonPanel.add(buttonUpdate);
		buttonPanel.add(buttonCancel);
		buttonPanel.add(buttonBill);
		buttonPanel.setBorder(new EmptyBorder(5, 0, 15, 0));
		buttonPanel.setBackground(MainGUI.BGCOLOR_LIGHTBLUE);
		
		// Must do setReservationInfo() after all GUI items including buttons are set up
		// otherwise might crash
		setReservationInfo();
	}
	

	public JComponent getContent() {
		//ADDING ALL THE PANELS TO THE MAINPANEL
		mainPanel.setLayout(new BorderLayout(0, 10));
		mainPanel.add(BorderLayout.CENTER, bar);		
		mainPanel.add(BorderLayout.SOUTH, buttonPanel);
		mainPanel.setBackground(MainGUI.BGCOLOR_LIGHTBLUE);
		
		return mainPanel;
	}
	
	
	public void setStatusInfo() {
		String statusInfo = "(";
		if (reservation.isActive())
			statusInfo += "Active - ";
		else 
			statusInfo += "Inactive - ";
		statusInfo += reservation.getStatusString() + ")";
		status.setText(statusInfo);
	}

	
	public void setReservationInfo() {
		if (reservation != null)
			id.setText("Reservation " + Integer.toString(reservation.getReservationId()));
		else 
			id.setText("Reservation ?");
		
		setStatusInfo();
		
		// If this reservation is inactive (Expired or Cancelled),
		// DON'T allow user to update or cancel the reservation.
		// User must create a new reservation instead.
		if (!reservation.isActive()) {
			buttonUpdate.setEnabled(false);
			buttonCancel.setEnabled(false);
		}
		
		double deposit = reservation.getDepositPaid();
		if (deposit > 0) {
			this.tfDepositAmount.setText(String.format("%.2f", deposit));
		}
		
		String beginDate = Reservation.dateFormatter.format(reservation.getBeginDate());
		String endDate = Reservation.dateFormatter.format(reservation.getEndDate());
		from.setText(beginDate);
		to.setText(endDate);
		
		Owner owner = reservation.getOwner();
		if (owner != null) {  
			ownerName.setText(owner.getName());
			addr.setText(owner.getAddress());
			cit.setText(owner.getCity());
			stateList.setSelectedItem(owner.getState());
			zipc.setText(owner.getZipCode());
			phon.setText(owner.getPhone());
		}
		
		Animal a = reservation.getAnimal();
		if (a != null) {
			String type = a.getSpecies();
			if (type.equalsIgnoreCase(dog.getText())) { //For Dog
				dog.setSelected(true);
				
				// If this reservation is for a dog, display Dog's breed list
				// with this dog's specific breed selected
				setDogBreedList();
				Dog d = (Dog)a;
				breedList.setSelectedItem(d.getBreedString());
				
				int maxWalkTime = (d.getMaxWalkingTime());
				wtime.setEnabled(true);
				wtime.setText(Integer.toString(maxWalkTime));
			}
			else if (type.equalsIgnoreCase(cat.getText())) { //For Cat
				cat.setSelected(true);
				
				// If this reservation is for a cat, display Cat's breed list
				// with this cat's specific breed selected
				setCatBreedList();
				Cat c = (Cat)a;
				breedList.setSelectedItem(c.getBreedString());
				
				// Disable the input text field "Dot's Max Walking Time" since this is a cat
				wtime.setEnabled(false);
			}
			petname.setText(a.getName());
			
			char sex = a.getSex();
			if (sex == Animal.SEX_MALE)
				male.setSelected(true);
			else if (sex == Animal.SEX_FEMALE)
				female.setSelected(true);
			
			int age = a.getAge();
			ages.setSelectedIndex(age-1);
			
			int weight = a.getSize();
			switch (weight) {
				case Animal.SIZE_SMALL: lower.setSelected(true); break;
				case Animal.SIZE_MEDIUM: ulower.setSelected(true); break;
				case Animal.SIZE_LARGE:  higher.setSelected(true); break;
				case Animal.SIZE_EXLARGE: uhigher.setSelected(true); break;
			}
			
			if (a.getHumanReactive())
				hYes.setSelected(true);
			else
				hNo.setSelected(true);
			
			if (a.getAnimalReactive())
				aYes.setSelected(true);
			else
				aNo.setSelected(true);
		}
		
		char food = reservation.getFoodOption();
		if (food == Reservation.FOOD_FROM_OWNER)
			ofood.setSelected(true);
		else if (food == Reservation.FOOD_FROM_HOTEL)
			hfood.setSelected(true);
		
		instr.setText(reservation.getOwnerInstruction());
		
		int assignedCage = reservation.getCageNumber();
		// If Cage# is not yet assigned to this reservation, display "To Be Assigned"
		// at the top of the cage list. Otherwise, display the assigned cage# at the top
		// followed by other available cage numbers in case the user needs to change cage#
		if (assignedCage < 0) {
			cage.addItem("To Be Assigned");
		}
		else {
			cage.addItem(Integer.toString(assignedCage));
		}
		ArrayList<Integer> availableCages = Reservation.getAvailableCages();
		for (int i = 0; i < availableCages.size(); i++) {
			cage.addItem(Integer.toString(availableCages.get(i)));
		}
		
		comm.setText(reservation.getCareTakerComment());
		
	}
	
	
	public boolean updateReservation() {
		
		String deposit = tfDepositAmount.getText();
		if (deposit != null) {
			try {
				double d = Double.parseDouble(deposit);
				reservation.setDepositPaid(d);
			}
			catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		String fromDate = from.getText();
		String toDate = to.getText();
		
		// Check to make sure fromDate and toDate are valid
		if (!reservation.isValidDuration(fromDate, toDate)) {
			JOptionPane.showMessageDialog(mainPanel, "Invalid DropOff & PickUp dates!\nPickUp date cannot be before DropOff Date",
										 "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}				
		reservation.setBeginDate(fromDate);
		reservation.setEndDate(toDate);
		
		Owner owner = reservation.getOwner();
		owner.setName(ownerName.getText());
		owner.setAddress(addr.getText().trim());
		owner.setCity(cit.getText().trim());
		owner.setState((String)stateList.getSelectedItem());
		owner.setZipCode(zipc.getText().trim());
		owner.setPhone(phon.getText());
		
		Animal pet = reservation.getAnimal();
		
		// Check if pet type is changed. If so, create a new Dog or Cat
		// and update reserveration's animal object
		if (dog.isSelected() && !(pet instanceof Dog)) {
			pet = new Dog();
			reservation.setAnimal(pet);
		}
		else if (cat.isSelected() && !(pet instanceof Cat)) {
			pet = new Cat();
			reservation.setAnimal(pet);
		}
		
		pet.setName(petname.getText());
		
		if (male.isSelected())
			pet.setSex(Animal.SEX_MALE);
		else if (female.isSelected())
			pet.setSex(Animal.SEX_FEMALE);
		
		pet.setAge(ages.getSelectedIndex()+1);
		
		pet.setBreed((String)breedList.getSelectedItem());
		
		if (lower.isSelected())
			pet.setSize(Animal.SIZE_SMALL);
		else if (ulower.isSelected())
			pet.setSize(Animal.SIZE_MEDIUM);
		else if (higher.isSelected())
			pet.setSize(Animal.SIZE_LARGE);
		else if (uhigher.isSelected())
			pet.setSize(Animal.SIZE_EXLARGE);
		
		if (ofood.isSelected())
			reservation.setFoodOption(Reservation.FOOD_FROM_OWNER);
		else if (hfood.isSelected())
			reservation.setFoodOption(Reservation.FOOD_FROM_HOTEL);
		
		if (hYes.isSelected())
			pet.setHumanReactive(true);
		else if (hNo.isSelected())
			pet.setHumanReactive(false);
		
		if (aYes.isSelected())
			pet.setAnimalReactive(true);
		else if (aNo.isSelected())
			pet.setAnimalReactive(false);
		
		reservation.setOwnerInstruction(instr.getText());
		
		int cageNum;
		String sCage = (String)cage.getSelectedItem();
		if (sCage.equalsIgnoreCase("To Be Assigned")) {
			cageNum = -1;
		}
		else 
			cageNum = Integer.valueOf(sCage);
		reservation.setCageNumber(cageNum);
		
		reservation.setCareTakerComment(comm.getText());
		
		return true;
	}
	
	
	public void cancelReservation() {
		reservation.cancel();
	}
	
	
	public void generateBillReport() {
		bill = new Bill(this.reservation);
		report = new ActivityReport(this.reservation);
		
		JPanel billPanel = bill.generateBillGUIContent();
		JPanel reportPanel = report.generateReportGUIContent();
		
		
		saveFile.addActionListener(this);
		
		JPanel saveFilePanel = new JPanel();
		saveFilePanel.add(saveFile);
		
		JFrame billFrame = new JFrame("Bill - Reservation ID" + reservation.getReservationId());
		billFrame.setSize(600,700);
		
		JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
		mainPanel.add(BorderLayout.NORTH, billPanel);
		mainPanel.add(BorderLayout.CENTER, reportPanel);
		mainPanel.add(BorderLayout.SOUTH, saveFilePanel);
		mainPanel.setBorder(new EmptyBorder(30, 35, 30, 35));
		
		billFrame.getContentPane().add(mainPanel);
		billFrame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonUpdate) {
			int confirm = JOptionPane.showConfirmDialog(mainPanel, "Are you sure you want to UPDATE this reservation?");
			if (confirm == 0) {
				boolean updateSuccess = updateReservation();
				
				if (updateSuccess) {
					// Update status info after reservation is successfully updated
					setStatusInfo();
					
					// After update, scroll to the top of main panel to show the new reservation status
					JScrollBar verticalBar =  bar.getVerticalScrollBar();
					verticalBar.setValue(verticalBar.getMinimum());
				}
			}	
		}
		else if (e.getSource() == buttonCancel) {
			int confirm = JOptionPane.showConfirmDialog(mainPanel, "Are you sure you want to CANCEL this reservation?");
			if (confirm == 0) {
				cancelReservation();

				// Update status info after reservation is successfully cancelled
				setStatusInfo();
				
				// After update, scroll to the top of main panel to show the new reservation status
				JScrollBar verticalBar =  bar.getVerticalScrollBar();
				verticalBar.setValue(verticalBar.getMinimum());
			}
		}
		else if (e.getSource() == buttonBill) {
			generateBillReport();
		}
		else if (e.getSource() == saveFile) {
			System.out.println("Save File clicked");
			if (bill != null && report != null) {
				String fileName = "BillReport_Res"+ this.reservation.getReservationId()
									+ "_" + new SimpleDateFormat("MMddyyyy").format(Reservation.todayDate)
									+ ".txt";
				bill.generateBill(fileName, false);
				report.generateReport(fileName, true);
				
				JOptionPane.showMessageDialog(mainPanel, "File " + fileName + " was saved successfully!\n",
												"INFO", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(mainPanel, "Cannot save file!\nBill or Report not found.",
												"ERROR", JOptionPane.ERROR_MESSAGE);
										
			}
		}
	}

}