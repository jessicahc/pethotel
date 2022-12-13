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
	GridBagConstraints gbc = new GridBagConstraints();
			
	//all the components being added to the centerPanel
	Font fLarge = new Font("Verdana", Font.BOLD, 16);
	Font f = new Font("Verdana", Font.BOLD, 15);
	Font ftext = new Font("Verdana", Font.PLAIN, 13);
	
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
	JRadioButton hfood = new JRadioButton("Hotel Provides Food (add $" +
								String.format("%.0f", Bill.BILLING_RATE_HOTEL_FOOD) + " per day)");
	ButtonGroup groupf = new ButtonGroup();
	
	JLabel walktime = new JLabel("Dog's Maximum Walking Time ");
	JTextField wtime = new JTextField(5);
	JLabel minutes = new JLabel("(max minutes per day)");
	
	JLabel hreactive = new JLabel("Pet Reactive (or aggressive) to Humans?");
	JRadioButton hYes = new JRadioButton("Yes");
	JRadioButton hNo = new JRadioButton("No");
	ButtonGroup grouph= new ButtonGroup();
	
	JLabel areactive = new JLabel("Pet Reactive (or aggressive) to Other Animals?");
	JRadioButton aYes = new JRadioButton("Yes");
	JRadioButton aNo = new JRadioButton("No");
	ButtonGroup groupanimal= new ButtonGroup();
	
	JLabel specInstr = new JLabel("Owner's Special Instructions");
	JTextArea instr = new JTextArea(5, 50);
	JScrollPane instrAreaScrollPane = new JScrollPane(instr, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
													JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	
	JPanel centerPanel = new JPanel(); //the panel in the center with all the input fields
	JScrollPane bar;
	
	
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
		aNo.setFont(ftext);
		areactive.setFont(ftext);
		hYes.setFont(ftext);
		aNo.setFont(ftext);
		
		
		int prefHeight = 30;
		//from.setPreferredSize(new Dimension(100, prefHeight));
		from.setFont(ftext);
		//to.setPreferredSize(new Dimension(100, prefHeight));
		to.setFont(ftext);
		//ownerName.setPreferredSize(new Dimension(120, prefHeight));
		ownerName.setFont(ftext);
		//addr.setPreferredSize(new Dimension(180, prefHeight));
		addr.setFont(ftext);
		//cit.setPreferredSize(new Dimension(150, prefHeight));
		cit.setFont(ftext);
		//stateList.setPreferredSize(new Dimension(120, prefHeight));
		stateList.setFont(ftext);
		//zipc.setPreferredSize(new Dimension(50, prefHeight));
		zipc.setFont(ftext);
		//phon.setPreferredSize(new Dimension(100, prefHeight));
		phon.setFont(ftext);
		//petname.setPreferredSize(new Dimension(150, prefHeight));
		petname.setFont(ftext);
		//ages.setPreferredSize(new Dimension(150, prefHeight));
		ages.setFont(ftext);
		//breedList.setPreferredSize(new Dimension(150, prefHeight));
		breedList.setFont(ftext);
		//wtime.setPreferredSize(new Dimension(150, prefHeight));
		wtime.setFont(ftext);
		instr.setFont(ftext);
		
		
		centerPanel.setLayout(new GridBagLayout());
		
		gbc.anchor= GridBagConstraints.NORTHWEST;
		gbc.weightx = 1; // Push all GUI items to left to line up
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
		gbc.insets = new Insets(0, LEFT_PADDING_SIZE, 8, 0);  //reset bottom spacing for owner name and address
		centerPanel.add(ownerNamePanel,gbc);
		
		// Address
		JPanel addressPanel = genHorizontalComponentGroup(address, addr, 10);
		gbc.gridx=0;
		gbc.gridy=5;
		centerPanel.add(addressPanel,gbc);
		
		// Wrap the set of label and fill-in field vertically for city, state, zip
		JPanel cityPanel = genVerticalComponentGroup(city, cit, 0);
		JPanel statePanel = genVerticalComponentGroup(state, stateList, 0);
		JPanel zipPanel = genVerticalComponentGroup(zip, zipc, 0);
		
		// Combine city, state, and zip code together in a panel so that 
		// they are pushed to the left side of centerPanel and don't stretch too far out to the right
		JPanel cityStateZipPanel = genHorizontalComponentGroup(cityPanel, statePanel, zipPanel, 10);		
		
		gbc.gridx=0;
		gbc.gridy=6;
		gbc.insets = new Insets(5, LEFT_PADDING_SIZE, 0, 0);  //reset top & bottom spacing for city, state, zip
		centerPanel.add(cityStateZipPanel,gbc);
		
		// Phone
		JPanel phonePanel = genHorizontalComponentGroup(phone, phon, 10);
		gbc.gridx=0;
		gbc.gridy=7;
		gbc.insets = new Insets(8, LEFT_PADDING_SIZE, 10, 0);  //reset top & bottom spacing
		centerPanel.add(phonePanel, gbc);	
		
		gbc.insets = new Insets(15, LEFT_PADDING_SIZE, 20, 0);  //reset top and bottom spacing
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
		
		breedList.addItem("Unknown");
		JPanel breedPanel = genHorizontalComponentGroup(pbreed, breedList, 10);
		gbc.gridx=0;
		gbc.gridy=13;
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
		gbc.gridy=14;
		gbc.insets = new Insets(0, LEFT_PADDING_SIZE, 15, 0);
		centerPanel.add(petSizePanel,gbc);		
		
		groupf.add(ofood);
		groupf.add(hfood);
		ofood.setSelected(true); // Default food option to OWNER BRINGS FOOD
		JPanel foodPanel = genHorizontalComponentGroup(food, ofood, hfood, 10);
		gbc.gridx = 0;
		gbc.gridy = 15;
		centerPanel.add(foodPanel, gbc);
		
		JPanel walkPanel = genHorizontalComponentGroup(walktime, wtime, minutes, 10);
		gbc.gridx =0;
		gbc.gridy=16;
		centerPanel.add(walkPanel, gbc);
		
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
