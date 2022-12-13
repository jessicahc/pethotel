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
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class ViewReservation implements ActionListener{

	private static final int LEFT_PADDING_SIZE = 10; 
	
	//All the Buttons in the southPanel
	JButton buttonUpdate, buttonCancel, buttonBill;
	
	//gbc object for the Layout
	GridBagConstraints gbc = new GridBagConstraints();
	
	//all the components being added to the centerPanel
	Font f = new Font("Verdana", Font.BOLD, 15);
	Font fLarge = new Font("Verdana", Font.BOLD, 16);
	
	JLabel id = new JLabel();  // reservation ID
	JLabel status = new JLabel(); // active vs. inactive
	
	JLabel lblDepositAmount = new JLabel("Initial Deposit Amount ($)");
	JTextField tfDepositAmount = new JTextField("$0",5);
	
	JLabel dStay = new JLabel("Duration of Stay");
	JLabel dropOff = new JLabel("Drop-Off Date ");
	JTextField from = new JTextField("mm/dd/yyyy", 15);
	JLabel pickUp = new JLabel("Pick-Up Date   ");
	JTextField to = new JTextField("mm/dd/yyyy", 15);
	
	JLabel owner = new JLabel("Owner Information");
	
	JLabel name = new JLabel("First and Last Name ");
	JTextField ownerName = new JTextField(20);
	
	JLabel address = new JLabel("Address ");
	JTextField addr = new JTextField(20);
	
	JLabel city = new JLabel("City ");
	JTextField cit = new JTextField(15);
	
	JLabel state = new JLabel("State ");
	JComboBox<String> stateList = new JComboBox<String>();
	
	JLabel zip = new JLabel("Zip Code ");
	JTextField zipc = new JTextField(10);
	
	JLabel phone = new JLabel("Phone ");
	JTextField phon = new JTextField(15);
		
	JLabel pet = new JLabel("Pet Information");
	
	JLabel type = new JLabel("Type");	
	JRadioButton dog = new JRadioButton("Dog");
	JRadioButton cat = new JRadioButton("Cat");
	ButtonGroup groupa = new ButtonGroup();
	
	JLabel pname = new JLabel("Pet's Name");
	JTextField petname = new JTextField(15);
	
	JLabel psex = new JLabel("Pet's Sex");
	JRadioButton male = new JRadioButton("M");
	JRadioButton female = new JRadioButton("F");
	ButtonGroup groups = new ButtonGroup();
	
	JLabel page = new JLabel("Pet's Age");	
	JComboBox<String> ages = new JComboBox<String>();
	
	JLabel pbreed = new JLabel("Breed");	
	JComboBox<String> breedList = new JComboBox<String>();
	
	JLabel psize = new JLabel("Pet's Size (lbs)");
	JRadioButton lower = new JRadioButton("0-15");
	JRadioButton ulower = new JRadioButton("16-30");
	JRadioButton higher = new JRadioButton("31-50");
	JRadioButton uhigher = new JRadioButton("50+");
	ButtonGroup groupw = new ButtonGroup();
	
	JLabel food = new JLabel("Food");
	JRadioButton ofood = new JRadioButton("Owner Brings Food");
	JRadioButton hfood = new JRadioButton("Hotel Provides Food (add $" + Bill.BILLING_RATE_HOTEL_FOOD + " per day)");
	ButtonGroup groupf = new ButtonGroup();
	
	JLabel walktime = new JLabel("Dog's Maximum Walking Time ");
	JTextField wtime = new JTextField(5);
	JLabel minutes = new JLabel("(max minutes per day)");
	
	JLabel specInstr = new JLabel("Owner's Special Instructions");
	JTextArea instr = new JTextArea(5, 50);
	JScrollPane instrAreaScrollPane = new JScrollPane(instr, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
													JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	JLabel cagenum = new JLabel("Cage #");
	JComboBox<String> cage = new JComboBox<String>();
	
	JLabel comments = new JLabel("Care Attendant's Comments");
	JTextArea comm = new JTextArea(5, 50);
	JScrollPane commAreaScrollPane = new JScrollPane(comm, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
													JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	JPanel mainpanel = new JPanel();
	JScrollPane bar;
	
	Reservation reservation;
	
	
	public ViewReservation(Reservation r) {
		this.reservation = r;
		
		int i;
	
		// Initialize the drop down list for state names		
		for (i = 0; i < Owner.STATE_LIST.length; i++) {
			stateList.addItem(Owner.STATE_LIST[i]);
		}
		stateList.setSelectedItem("NY");
		
		// Initialize pet's age drop down list				
		for (i = 1; i <= 20; i++) { 
			ages.addItem(i + " years");
		}
		
		//CREATING 2 PANELS TO FIT INTO THE MAINPANEL				
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();
		
		//ALL THE SOUTHPANEL STUFFS
		//Buttons in the south panel
		buttonUpdate = new JButton();
		buttonUpdate.setSize(20,15);
		buttonUpdate.setText("Update Reservation");
		buttonUpdate.addActionListener(this);
			
		buttonCancel = new JButton();
		buttonCancel.setSize(20, 15);
		buttonCancel.setText("Cancel Reservation");
		buttonCancel.addActionListener(this);
				
		buttonBill = new JButton();
		buttonBill.setSize(20,15);
		buttonBill.setText("Generate Bill and Report");
		buttonBill.addActionListener(this);
					
		southPanel.add(buttonUpdate);
		southPanel.add(buttonCancel);
		southPanel.add(buttonBill);
		southPanel.setBorder(new EmptyBorder(5, 0, 15, 0));
		
		mainpanel.setLayout(new BorderLayout(0, 15));
		mainpanel.setBorder(new EmptyBorder(30, 50, 0, 50));

		//ALL THE CENTERPANEL STUFFS
		//Layout of the text fields and the labels
		centerPanel.setLayout(new GridBagLayout());		
		bar = new JScrollPane(centerPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						
		id.setFont(fLarge);
		status.setFont(fLarge);
		status.setForeground(Color.RED);
		dStay.setFont(f);
		lblDepositAmount.setFont(fLarge);
		owner.setFont(f);	
		pet.setFont(f);
		specInstr.setFont(f);
		cagenum.setFont(f);
		comments.setFont(f);
		
		centerPanel.setLayout(new GridBagLayout());
		gbc.anchor= GridBagConstraints.NORTHWEST;
		gbc.weightx = 0;
		gbc.weighty = 0; // Push all GUI items to left and up
				
		// Reservation ID and status
		JPanel idStatusPanel = genHorizontalComponentGroup(id, status);
		gbc.gridx = 0;
		gbc.gridy=0;
		gbc.insets = new Insets(20, LEFT_PADDING_SIZE, 20, 0);  //set top and bottom spacing
		centerPanel.add(idStatusPanel,gbc);
		
		// Initial Deposit Amount 
		JPanel depositAmountPanel = genHorizontalComponentGroup(lblDepositAmount, tfDepositAmount);
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.insets = new Insets(0, LEFT_PADDING_SIZE, 12, 0);  //reset top and bottom spacing
		centerPanel.add(depositAmountPanel,gbc);
		
		// Duration of Stay subtitle
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.insets = new Insets(0, LEFT_PADDING_SIZE, 12, 0);  //reset top and bottom spacing
		centerPanel.add(dStay,gbc);
		
		
        gbc.insets = new Insets(0, LEFT_PADDING_SIZE, 8, 0);  //reset bottom spacing
		
        JPanel dropOffPanel = genHorizontalComponentGroup(dropOff, from);
		gbc.gridx=0;
		gbc.gridy=3;				
		centerPanel.add(dropOffPanel,gbc);
		
		JPanel pickUpPanel = genHorizontalComponentGroup(pickUp, to);
		gbc.gridx=0;
		gbc.gridy=4;		
		centerPanel.add(pickUpPanel,gbc);
				
		
		// Owner info subtitle
		gbc.gridx=0;
		gbc.gridy=5;
		gbc.insets = new Insets(12, LEFT_PADDING_SIZE, 12, 0);  //reset top and bottom spacing
		centerPanel.add(owner, gbc);
		
		
		gbc.insets = new Insets(0, LEFT_PADDING_SIZE, 8, 0);  //reset bottom spacing for owner name and address
		
		// Owner Name
		JPanel ownerNamePanel = genHorizontalComponentGroup(name, ownerName);
		gbc.gridx=0;
		gbc.gridy=6;
		centerPanel.add(ownerNamePanel,gbc);
		
		// Address
		JPanel addressPanel = genHorizontalComponentGroup(address, addr);
		gbc.gridx=0;
		gbc.gridy=7;
		centerPanel.add(addressPanel,gbc);
		
		// Wrap the set of label and fill-in field vertically for city, state, zip
		JPanel cityPanel = genVerticalComponentGroup(city, cit, 0);
		JPanel statePanel = genVerticalComponentGroup(state, stateList, 0);
		JPanel zipPanel = genVerticalComponentGroup(zip, zipc, 0);
		
		// Combine city, state, and zip code together in a panel so that 
		// they are pushed to the left side of centerpanel and don't stretch too far out to the right
		JPanel cityStateZipPanel = genHorizontalComponentGroup(cityPanel, statePanel, zipPanel);		
		
		gbc.gridx=0;
		gbc.gridy=8;
		gbc.insets = new Insets(5, LEFT_PADDING_SIZE, 0, 0);  //reset top & bottom spacing for city, state, zip
		centerPanel.add(cityStateZipPanel,gbc);
		
		// Phone
		JPanel phonePanel = genHorizontalComponentGroup(phone, phon);
		gbc.gridx=0;
		gbc.gridy=9;
		gbc.insets = new Insets(8, LEFT_PADDING_SIZE, 10, 0);  //reset top & bottom spacing
		centerPanel.add(phonePanel, gbc);	
		
		gbc.insets = new Insets(15, LEFT_PADDING_SIZE, 20, 0);  //reset top and bottom spacing
		gbc.gridx=0;
		gbc.gridy=10;
		centerPanel.add(pet,gbc);
		
		gbc.insets = new Insets(0, LEFT_PADDING_SIZE, 8, 0);  //reset top and bottom spacing for all pet fields
		
		// Pet Type: dog vs cat
		groupa.add(dog);
		groupa.add(cat);
		// Register ActionListener for radio button Dog and Cat in case the user modifies pet's type
		dog.addActionListener(new PetTypeListener());
		//dog.setActionCommand(dog.getText());
				
		cat.addActionListener(new PetTypeListener());
		//cat.setActionCommand(cat.getText());
			
		
		JPanel petTypePanel = genHorizontalComponentGroup(type, dog, cat);
		gbc.gridx=0;
		gbc.gridy=11;
		centerPanel.add(petTypePanel,gbc);
		
		// Pet Name
		JPanel pnamePanel = genHorizontalComponentGroup(pname, petname);
		gbc.gridx=0;
		gbc.gridy=12;
		centerPanel.add(pnamePanel,gbc);
				
		// Pet Sex: male vs female
		groups.add(male);
		groups.add(female);		
		JPanel psexPanel = genHorizontalComponentGroup(psex, male, female);
		gbc.gridx=0;
		gbc.gridy=13;
		centerPanel.add(psexPanel,gbc);
		
		// Pet Age
		gbc.gridx=0;
		gbc.gridy=14;
		JPanel agePanel = genHorizontalComponentGroup(page, ages);
		centerPanel.add(agePanel,gbc);
		
		gbc.gridx=0;
		gbc.gridy=15;
		JPanel breedPanel = genHorizontalComponentGroup(pbreed, breedList);
		centerPanel.add(breedPanel,gbc);
		
		groupw.add(lower);
		groupw.add(ulower);
		groupw.add(higher);
		groupw.add(uhigher);
		
		JPanel petSizePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));   						
		petSizePanel.add(psize);
		petSizePanel.add(lower);
		petSizePanel.add(ulower);
		petSizePanel.add(higher);
		petSizePanel.add(uhigher);
		
		gbc.gridx=0;
		gbc.gridy=16;
		centerPanel.add(petSizePanel,gbc);		
		
		groupf.add(ofood);
		groupf.add(hfood);		
		JPanel foodPanel = genHorizontalComponentGroup(food, ofood, hfood);
		gbc.gridx = 0;
		gbc.gridy = 17;
		centerPanel.add(foodPanel, gbc);
		
		JPanel walkPanel = genHorizontalComponentGroup(walktime, wtime, minutes);
		gbc.gridx =0;
		gbc.gridy=18;
		centerPanel.add(walkPanel, gbc);
		
		gbc.insets = new Insets(10, LEFT_PADDING_SIZE, 5, 0);  //reset top and bottom spacing
		
		JPanel instrPanel = genVerticalComponentGroup(specInstr, instrAreaScrollPane, 10);		
		gbc.gridx=0;
		gbc.gridy=19;
		centerPanel.add(instrPanel,gbc);
	
		gbc.insets = new Insets(15, LEFT_PADDING_SIZE, 15, 0);  //reset top and bottom spacing		
		JPanel cagePanel = genHorizontalComponentGroup(cagenum, cage, 
							new JLabel("(To change Cage #, select a new cage number from the list)"));
		gbc.gridx=0;
		gbc.gridy=20;
		centerPanel.add(cagePanel, gbc);
		
		gbc.insets = new Insets(0, LEFT_PADDING_SIZE, 15, 0);  //reset top and bottom spacing
		JPanel commentPanel = genVerticalComponentGroup(comments, commAreaScrollPane, 10);
		gbc.gridx=0;
		gbc.gridy=21; 
		gbc.weightx = 0; gbc.weighty = 1; // Push all GUI items up
		centerPanel.add(commentPanel,gbc);
			
		//ADDING ALL THE PANELS TO THE MAIN PANEL		
		mainpanel.add(southPanel, BorderLayout.SOUTH);
		mainpanel.add(bar, BorderLayout.CENTER);
		
		setReservationInfo();
	}

	public JComponent getContent() {
		return mainpanel;
	}
	
	private JPanel genHorizontalComponentGroup(JComponent c1, JComponent c2) {
		JPanel panel = new JPanel(new BorderLayout(10, 0)); //Set horizontal spacing between 2 components to 10		
		panel.add(c1, BorderLayout.WEST);
		panel.add(c2, BorderLayout.CENTER);
		return panel;
	}
	
	private JPanel genHorizontalComponentGroup(JComponent c1, JComponent c2, JComponent c3) {
		JPanel panel = new JPanel(new BorderLayout(10, 0));	//Set horizontal spacing between 2 components to 10	
		panel.add(c1, BorderLayout.WEST);
		panel.add(c2, BorderLayout.CENTER);
		panel.add(c3, BorderLayout.EAST);
		return panel;
	}
	
	private JPanel genVerticalComponentGroup(JComponent c1, JComponent c2, int vgap) {
		JPanel panel = new JPanel(new BorderLayout(0, vgap));		
		panel.add(c1, BorderLayout.NORTH);
		panel.add(c2, BorderLayout.CENTER);
		return panel;
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
		
		// If this reservation is inactive (expired or cancelled),
		// DON'T allow user to update or cancel the reservation.
		// User must create a new reservation instead.
		if (!reservation.isActive()) {
			buttonUpdate.setEnabled(false);
			buttonCancel.setEnabled(false);
		}
		
		Bill bill = reservation.getBill();
		if (bill != null) {
			this.tfDepositAmount.setText(String.format("%.2f", bill.getDepositAmount()));
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
				System.out.println("ViewReservation.setReservationInfo(): cat breed is " + c.getBreedString());
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
		
		Bill bill = reservation.getBill();
		if (bill != null) {
			String deposit = tfDepositAmount.getText();
			if (deposit != null) {
				try {
					double d = Double.parseDouble(deposit);
					bill.setDepositAmount(d);
				}
				catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		}
		
		String fromDate = from.getText();
		String toDate = to.getText();
		
		// Check to make sure fromDate and toDate are valid
		if (!reservation.isValidDuration(fromDate, toDate)) {
			JOptionPane.showMessageDialog(mainpanel, "Invalid DropOff & PickUp dates!\nPickUp date cannot be before DropOff Date",
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
	
	
	public void generateBillReport() {
		Bill bill = reservation.getBill();
		
		JPanel billPanel = bill.generateBillGUIContent();
		
		JFrame frame = new JFrame();
		frame.setSize(400,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
		mainPanel.add(BorderLayout.CENTER, billPanel);
		mainPanel.setBorder(new EmptyBorder(30, 50, 30, 50));
		
		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonUpdate) {
			int confirm = JOptionPane.showConfirmDialog(mainpanel, "Are you sure you want to UPDATE this reservation?");
			if (confirm == 0) {
				if (updateReservation()) {
					// Update status info after reservation is successfully updated
					setStatusInfo();
					// After update, scroll to the top of main panel to show the new reservation status
					JScrollBar verticalBar =  bar.getVerticalScrollBar();
					verticalBar.setValue(verticalBar.getMinimum());
				}
			}	
		}
		else if (e.getSource() == buttonCancel) {
			int confirm = JOptionPane.showConfirmDialog(mainpanel, "Are you sure you want to CANCEL this reservation?");
			if (confirm == 0) {
				reservation.cancel();

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
	}

	private void setDogBreedList() {
		String[] breeds = Dog.DOG_BREED_LIST;
		breedList.removeAllItems();
		for (int i=0; i < breeds.length; i++)
			breedList.addItem(breeds[i]);
	}
	
	private void setCatBreedList() {
		String[] breeds = Cat.CAT_BREED_LIST;
		breedList.removeAllItems();
		for (int i=0; i < breeds.length; i++)
			breedList.addItem(breeds[i]);
	}
	
	private class PetTypeListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (e.getSource() == dog) {
				setDogBreedList();
				wtime.setEnabled(true);
			}
			else if (e.getSource() == cat) {
				setCatBreedList();
				// Disable Dog's Max Walking Time if pet type is changed to Cat
				wtime.setEnabled(false);
			}	
		}
	}	

}