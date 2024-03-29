// BaseReservationForm is a superclass containing GUI components
// common in both "New Reservation" screen and "View/Modify Reservation" screen.
// Each subclass can add its own unique GUI components and action listeners
// to handle user interactions.
//
// Author: Vighnesh Dheenadhayalan, Jessica Chen

package pethotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class BaseReservationForm {
	
	protected static final int LEFT_PADDING_SIZE = 25; 
	
	//gbc object for the Layout
	protected GridBagConstraints gbc = new GridBagConstraints();
			
	//all the components being added to the centerPanel
	protected Font fLarge = new Font("Verdana", Font.BOLD, 16);
	protected Font f = new Font("Verdana", Font.BOLD, 15);
	protected Font ftext = new Font("Verdana", Font.PLAIN, 13);
	
	protected JLabel dStay = new JLabel("Duration of Stay");
	protected JLabel dropOff = new JLabel("Drop-Off Date ");
	protected JTextField from = new JTextField("mm/dd/yyyy", 15);
	protected JLabel pickUp = new JLabel("Pick-Up Date   ");
	protected JTextField to = new JTextField("mm/dd/yyyy", 15);
	
	protected JLabel owner = new JLabel("Owner Information");
	
	protected JLabel name = new JLabel("First and Last Name ");
	protected JTextField ownerName = new JTextField(20);
	
	protected JLabel address = new JLabel("Address ");
	protected JTextField addr = new JTextField(20);
	
	protected JLabel city = new JLabel("City ");
	protected JTextField cit = new JTextField(15);
	
	protected JLabel state = new JLabel("State ");
	protected JComboBox<String> stateList = new JComboBox<String>();
	
	protected JLabel zip = new JLabel("Zip Code ");
	protected JTextField zipc = new JTextField(10);
	
	protected JLabel phone = new JLabel("Phone ");
	protected JTextField phon = new JTextField(15);
		
	protected JLabel pet = new JLabel("Pet Information");
	
	protected JLabel type = new JLabel("Type");	
	protected JRadioButton dog = new JRadioButton("Dog");
	protected JRadioButton cat = new JRadioButton("Cat");
	protected ButtonGroup groupa = new ButtonGroup();
	
	protected JLabel pname = new JLabel("Pet's Name");
	protected JTextField petname = new JTextField(15);
	
	protected JLabel psex = new JLabel("Pet's Sex");
	protected JRadioButton male = new JRadioButton("M");
	protected JRadioButton female = new JRadioButton("F");
	protected ButtonGroup groups = new ButtonGroup();
	
	protected JLabel page = new JLabel("Pet's Age");	
	protected JComboBox<String> ages = new JComboBox<String>();
	
	protected JLabel pbreed = new JLabel("Breed");	
	protected JComboBox<String> breedList = new JComboBox<String>();
	
	protected JLabel psize = new JLabel("Pet's Size (lbs)");
	protected JRadioButton lower = new JRadioButton("0-15");
	protected JRadioButton ulower = new JRadioButton("16-30");
	protected JRadioButton higher = new JRadioButton("31-50");
	protected JRadioButton uhigher = new JRadioButton("50+");
	protected ButtonGroup groupw = new ButtonGroup();
	
	protected JLabel food = new JLabel("Food");
	protected JRadioButton ofood = new JRadioButton("Owner Brings Food");
	protected JRadioButton hfood = new JRadioButton("Hotel Provides Food (add $" +
								String.format("%.0f", Bill.BILLING_RATE_HOTEL_FOOD) + " per day)");
	protected ButtonGroup groupf = new ButtonGroup();
	
	protected JLabel walktime = new JLabel("Dog's Maximum Walking Time ");
	protected JTextField wtime = new JTextField(5);
	protected JLabel minutes = new JLabel("(max minutes per day)");
	
	protected JLabel hreactive = new JLabel("Pet Reactive (or aggressive) to Humans?");
	protected JRadioButton hYes = new JRadioButton("Yes");
	protected JRadioButton hNo = new JRadioButton("No");
	protected ButtonGroup grouph= new ButtonGroup();
	
	protected JLabel areactive = new JLabel("Pet Reactive (or aggressive) to Other Animals?");
	protected JRadioButton aYes = new JRadioButton("Yes");
	protected JRadioButton aNo = new JRadioButton("No");
	protected ButtonGroup groupanimal= new ButtonGroup();
	
	protected JLabel specInstr = new JLabel("Owner's Special Instructions");
	protected JTextArea instr = new JTextArea(5, 50);
	protected JScrollPane instrAreaScrollPane = new JScrollPane(instr, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
													JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	protected JPanel centerPanel = new JPanel(); //the panel in the center with all the input fields
	protected JScrollPane bar;
	
	
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
	

	public BaseReservationForm() {
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

		//ALL THE CENTERPANEL STUFFS
		//Layout of the text fields and the labels
		centerPanel.setLayout(new GridBagLayout());
		bar = new JScrollPane(centerPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						
		dStay.setFont(f);
		owner.setFont(f);	
		pet.setFont(f);
		specInstr.setFont(f);
		
		
		dropOff.setFont(ftext);
		pickUp.setFont(ftext);
		address.setFont(ftext);
		city.setFont(ftext);
		name.setFont(ftext);
		state.setFont(ftext);
		zip.setFont(ftext);
		phone.setFont(ftext);
		type.setFont(ftext);
		dog.setFont(ftext);
		cat.setFont(ftext);
		pname.setFont(ftext);
		psex.setFont(ftext);
		male.setFont(ftext);
		female.setFont(ftext);
		page.setFont(ftext);
		pbreed.setFont(ftext);
		psize.setFont(ftext);
		food.setFont(ftext);
		ofood.setFont(ftext);
		hfood.setFont(ftext);
		lower.setFont(ftext);
		ulower.setFont(ftext);
		higher.setFont(ftext);
		uhigher.setFont(ftext);
		food.setFont(ftext);
		ofood.setFont(ftext);
		hfood.setFont(ftext);
		walktime.setFont(ftext);
		minutes.setFont(ftext);
		hreactive.setFont(ftext);
		hYes.setFont(ftext);
		hNo.setFont(ftext);
		areactive.setFont(ftext);
		aYes.setFont(ftext);
		aNo.setFont(ftext);
				
		from.setFont(ftext);
		to.setFont(ftext);
		ownerName.setFont(ftext);
		addr.setFont(ftext);
		cit.setFont(ftext);
		stateList.setFont(ftext);
		zipc.setFont(ftext);
		phon.setFont(ftext);
		petname.setFont(ftext);
		ages.setFont(ftext);
		breedList.setFont(ftext);
		wtime.setFont(ftext);
		instr.setFont(ftext);
		
		centerPanel.setLayout(new GridBagLayout());
		
		gbc.anchor= GridBagConstraints.NORTHWEST;
		gbc.weightx = 1; // Push all GUI items to the left to line up
		gbc.weighty = 1; 	
		
		// Duration of Stay subtitle
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets = new Insets(0, LEFT_PADDING_SIZE, 12, 0);  //reset top and bottom spacing
		centerPanel.add(dStay,gbc);
		
        gbc.insets = new Insets(0, LEFT_PADDING_SIZE, 8, 0);  //reset bottom spacing
		
        JPanel dropOffPanel = genHorizontalComponentGroup(dropOff, from, 10);
		gbc.gridx=0;
		gbc.gridy=1;				
		centerPanel.add(dropOffPanel,gbc);
		
		JPanel pickUpPanel = genHorizontalComponentGroup(pickUp, to, 10);
		gbc.gridx=0;
		gbc.gridy=2;		
		centerPanel.add(pickUpPanel,gbc);
				
		// Owner info subtitle
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.insets = new Insets(12, LEFT_PADDING_SIZE, 12, 0);  //reset top and bottom spacing
		centerPanel.add(owner, gbc);
		
		// Owner Name
		JPanel ownerNamePanel = genHorizontalComponentGroup(name, ownerName, 10);
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.insets = new Insets(0, LEFT_PADDING_SIZE, 10, 0);  //reset bottom spacing for owner name and address
		centerPanel.add(ownerNamePanel,gbc);
		
		// Address
		JPanel addressPanel = genHorizontalComponentGroup(address, addr, 10);
		gbc.gridx=0;
		gbc.gridy=5;
		centerPanel.add(addressPanel,gbc);
		
		// Wrap each pair of label and text field vertically for city, state, zip
		JPanel cityPanel = genVerticalComponentGroup(city, cit, 0);
		JPanel statePanel = genVerticalComponentGroup(state, stateList, 0);
		JPanel zipPanel = genVerticalComponentGroup(zip, zipc, 0);
		
		// Combine city, state, and zip code together in a panel so that 
		// they are pushed to the left side of centerPanel and don't stretch too far out to the right
		JPanel cityStateZipPanel = genHorizontalComponentGroup(cityPanel, statePanel, zipPanel, 10);		
		
		gbc.gridx=0;
		gbc.gridy=6;
		gbc.insets = new Insets(5, LEFT_PADDING_SIZE, 5, 0);  //reset top & bottom spacing for city, state, zip
		centerPanel.add(cityStateZipPanel,gbc);
		
		// Phone
		JPanel phonePanel = genHorizontalComponentGroup(phone, phon, 10);
		gbc.gridx=0;
		gbc.gridy=7;
		gbc.insets = new Insets(8, LEFT_PADDING_SIZE, 10, 0);  //reset top & bottom spacing
		centerPanel.add(phonePanel, gbc);	
		
		gbc.insets = new Insets(15, LEFT_PADDING_SIZE, 15, 0);  //reset top and bottom spacing
		gbc.gridx=0;
		gbc.gridy=8;
		centerPanel.add(pet,gbc);
		
		// Pet Type: dog vs cat
		groupanimal.add(dog);
		groupanimal.add(cat);
		// Register ActionListener for radio button Dog and Cat in case the user modifies pet's type
		dog.addActionListener(new PetTypeListener());
		cat.addActionListener(new PetTypeListener());
			
		JPanel petTypePanel = genHorizontalComponentGroup(type, dog, cat, 10);
		gbc.gridx=0;
		gbc.gridy=9;
		gbc.insets = new Insets(0, LEFT_PADDING_SIZE, 8, 0);  //reset top and bottom spacing for all pet fields
		centerPanel.add(petTypePanel,gbc);
		
		// Pet Name
		JPanel pnamePanel = genHorizontalComponentGroup(pname, petname, 10);
		gbc.gridx=0;
		gbc.gridy=10;
		centerPanel.add(pnamePanel,gbc);
				
		// Pet Sex: male vs female
		groups.add(male);
		groups.add(female);		
		JPanel psexPanel = genHorizontalComponentGroup(psex, male, female, 10);
		gbc.gridx=0;
		gbc.gridy=11;
		centerPanel.add(psexPanel,gbc);
		
		// Pet Age
		JPanel agePanel = genHorizontalComponentGroup(page, ages, 10);
		gbc.gridx=0;
		gbc.gridy=12;
		centerPanel.add(agePanel,gbc);
		
		// Pet Breeds List
		breedList.addItem("Unknown");
		JPanel breedPanel = genHorizontalComponentGroup(pbreed, breedList, 10);
		gbc.gridx=0;
		gbc.gridy=13;
		centerPanel.add(breedPanel,gbc);
		
		// Pet Size
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
		gbc.gridy=14;
		gbc.insets = new Insets(0, LEFT_PADDING_SIZE, 15, 0);
		centerPanel.add(petSizePanel,gbc);		
		
		// Pet Food
		groupf.add(ofood);
		groupf.add(hfood);
		ofood.setSelected(true); // Default food option to OWNER BRINGS FOOD
		JPanel foodPanel = genHorizontalComponentGroup(food, ofood, hfood, 10);
		gbc.gridx = 0;
		gbc.gridy = 15;
		centerPanel.add(foodPanel, gbc);
		
		// Dog's Max Walking Time
		JPanel walkPanel = genHorizontalComponentGroup(walktime, wtime, minutes, 10);
		gbc.gridx =0;
		gbc.gridy=16;
		centerPanel.add(walkPanel, gbc);
		
		// Human or Animal Reactive
		grouph.add(hYes);
		grouph.add(hNo);
		hNo.setSelected(true); // default to not human reactive
		JPanel hreactivePanel = genHorizontalComponentGroup(hreactive, hYes, hNo, 15);
		gbc.gridx=0;
		gbc.gridy=17;
		centerPanel.add(hreactivePanel, gbc);

		groupa.add(aYes);
		groupa.add(aNo);
		aNo.setSelected(true); // default to not animal reactive
		JPanel areactivePanel = genHorizontalComponentGroup(areactive, aYes, aNo, 15);
		gbc.gridx=0;
		gbc.gridy=18;
		centerPanel.add(areactivePanel, gbc);
		
		// Owner's Special Instruction
		JPanel instrPanel = genVerticalComponentGroup(specInstr, instrAreaScrollPane, 10);		
		gbc.gridx=0;
		gbc.gridy=19;
		gbc.insets = new Insets(5, LEFT_PADDING_SIZE, 5, 0);  //reset top and bottom spacing
		centerPanel.add(instrPanel,gbc);
	}

	// Allow MainGUI to receive the main content component of this GUI form
	public JComponent getContent() {
		// return the scroll pane that contains centerPanel
		return bar;
	}
	
	
	protected JPanel genHorizontalComponentGroup(JComponent c1, JComponent c2, int hgap) {
		JPanel panel = new JPanel(new BorderLayout(hgap, 0)); //Set horizontal spacing between 2 components to 10		
		panel.add(c1, BorderLayout.WEST);
		panel.add(c2, BorderLayout.CENTER);
		return panel;
	}
	
	protected JPanel genHorizontalComponentGroup(JComponent c1, JComponent c2, JComponent c3, int hgap) {
		JPanel panel = new JPanel(new BorderLayout(hgap, 0));	//Set horizontal spacing between 2 components to 10	
		panel.add(c1, BorderLayout.WEST);
		panel.add(c2, BorderLayout.CENTER);
		panel.add(c3, BorderLayout.EAST);
		return panel;
	}
	
	protected JPanel genVerticalComponentGroup(JComponent c1, JComponent c2, int vgap) {
		JPanel panel = new JPanel(new BorderLayout(0, vgap));		
		panel.add(c1, BorderLayout.NORTH);
		panel.add(c2, BorderLayout.CENTER);
		return panel;
	}
	
	protected void setDogBreedList() {
		String[] breeds = Dog.DOG_BREED_LIST;
		breedList.removeAllItems();
		for (int i=0; i < breeds.length; i++)
			breedList.addItem(breeds[i]);
	}
	
	protected void setCatBreedList() {
		String[] breeds = Cat.CAT_BREED_LIST;
		breedList.removeAllItems();
		for (int i=0; i < breeds.length; i++)
			breedList.addItem(breeds[i]);
	}
}
