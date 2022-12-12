package pethotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class NewReservation implements ActionListener{
	//only button needed to save the new registration
	JButton button1;
	//gbc object for layout modification
	GridBagConstraints gbc = new GridBagConstraints();
	
	//all the components being added to the centerPanel
	Font f = new Font("Verdana", Font.BOLD, 15);
	JLabel owner = new JLabel("Owner Information ");
	JLabel dStay = new JLabel("Duration of Stay ");
	JTextField from = new JTextField("mm/dd/yyyy");
	JTextField to = new JTextField("mm/dd/yyyy");
	JLabel name = new JLabel("First and Last Name ");
	JTextField test = new JTextField();
	JLabel address = new JLabel("Address ");
	JTextField addr = new JTextField();
	JLabel city = new JLabel("City ");
	JTextField cit = new JTextField();
	JLabel state = new JLabel("State ");
	JTextField stat = new JTextField();
	JLabel zip = new JLabel("Zip Code ");
	JTextField zipc = new JTextField();
	JLabel phone = new JLabel("Phone ");
	JTextField phon = new JTextField();
	JLabel food = new JLabel("Food");
	JRadioButton ofood = new JRadioButton("Owner brings Food");
	JRadioButton hfood = new JRadioButton("Hotel provide's Food(addln 10$)");
	ButtonGroup groupf = new ButtonGroup();
	JLabel walktime = new JLabel("Dog's maximum walking time ");
	JTextField wtime = new JTextField();
	JLabel minutes = new JLabel("(max minutes per day)");
	JLabel specInstr = new JLabel("Owner's special Instructions:");
	JTextField instr = new JTextField();
	JLabel pet = new JLabel("Pet Information: ");
	JLabel type = new JLabel("Type");
	JRadioButton dog = new JRadioButton("Dog");
	JRadioButton cat = new JRadioButton("Cat");
	ButtonGroup groupa = new ButtonGroup();
	JLabel pname = new JLabel("Pet's name");
	JTextField petname = new JTextField();
	JLabel psex = new JLabel("Pet's sex");
	JRadioButton male = new JRadioButton("M");
	JRadioButton female = new JRadioButton("F");
	ButtonGroup groups = new ButtonGroup();
	
	JLabel page = new JLabel("Pet's age(in years)");
	String[] age = {"0-2", "2-4", "4-7", "7-10", "10+"};
	JComboBox ages = new JComboBox(age);
	JLabel pbreed = new JLabel("Breed");
	String[] dogs = {" Poodle", "German Shepherd", "Pitbull", "Caine", "Labrador Retriever", "French Bulldogs", "Golden Retrievers", "Bulldogs", "Beagles", "Rottweilers"};
	JComboBox dogb= new JComboBox(dogs);
	JLabel psize = new JLabel("Pet's size(lbs)");
	JRadioButton lower = new JRadioButton("0-15");
	JRadioButton ulower = new JRadioButton("16-30");
	JRadioButton higher = new JRadioButton("31-50");
	JRadioButton uhigher = new JRadioButton("50+");
	ButtonGroup groupw = new ButtonGroup();
	JLabel hreactive = new JLabel("Is you Pet reactive(or aggressive) to Humans?");
	JRadioButton hYes = new JRadioButton("Yes");
	JRadioButton hNo = new JRadioButton("No");
	ButtonGroup grouph= new ButtonGroup();
	JLabel areactive = new JLabel("Is your Pet reactive(or aggressive) to other animals?");
	JRadioButton aYes = new JRadioButton("Yes");
	JRadioButton aNo = new JRadioButton("No");
	ButtonGroup groupanimal= new ButtonGroup();
	
	
	
	
	public NewReservation() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLayout(null); when we use this method we have to specify the layout of any component we add
		//basically we disable the default layout setting
		
		//CREATING 5 PANELS TO FIT INTO THE MAINPANEL WHICH WILL FIT INTO THE FRAME
		JPanel mainPanel = new JPanel();
		JPanel northPanel = new JPanel();   //the panel with the label:Book a new Reservation
		JPanel southPanel = new JPanel();   //the panel with the button
		JPanel leftPanel = new JPanel();    //the panel on the left
		JPanel rightPanel = new JPanel();   //the panel on the right
		JPanel centerPanel = new JPanel();  //the panel in the center with all the input fields
		
		//COLOURING ALL THE PANELS
		northPanel.setBackground(Color.white);
		leftPanel.setBackground(Color.blue);
		rightPanel.setBackground(Color.blue);
		centerPanel.setBackground(Color.yellow);
		southPanel.setBackground(Color.blue);
		mainPanel.setSize(800,800);
		
		//SETTING THE SIZES FOR ALL THE PANELS
		northPanel.setPreferredSize(new Dimension(60,40));
		southPanel.setPreferredSize(new Dimension(100,60));
		centerPanel.setPreferredSize(new Dimension(700,1000));
		leftPanel.setPreferredSize(new Dimension(50,50));
		rightPanel.setPreferredSize(new Dimension(50,50));
		
		
		//ALL THE NORTHPANEL STUFFS
		JLabel topic = new JLabel("Book a new Reservation:");
		topic.setBounds(48,18, 200,20);
		northPanel.setLayout(null);		
		northPanel.add(topic);
		
		//ALL THE SOUTHPANEL STUFFS
		button1 = new JButton();     //Buttons in the south panel
		button1.setSize(20,15);
		button1.setText("Save Reservation");
		button1.addActionListener(this);
		//southPanel.setLayout(new GridLayout(1,3,25,0));
		//southPanel.setBounds(25,100, 250,250);
		southPanel.add(button1);
		
		//ALL THE CENTERPANEL STUFFS
		//adding the scrollBar
		owner.setFont(f);
		pet.setFont(f);
		JScrollPane bar = new JScrollPane(centerPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		centerPanel.setLayout(new GridBagLayout());
		gbc.anchor= GridBagConstraints.NORTHWEST;
		gbc.weightx=1;
		gbc.weighty =1;
		gbc.gridx=0;
		gbc.gridy=0;
		centerPanel.add(dStay,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		centerPanel.add(from,gbc);
		
		gbc.gridx=2;
		gbc.gridy=1;
		centerPanel.add(to,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		centerPanel.add(owner, gbc);
		
		gbc.gridx =0;
		gbc.gridy=4;
		centerPanel.add(name,gbc);
		
		test.setPreferredSize(new Dimension(250,30));
		gbc.gridx =0;
		gbc.gridy = 5;
		centerPanel.add(test,gbc);
		
		gbc.gridx =0;
		gbc.gridy=6;
		centerPanel.add(address,gbc);
		
		gbc.gridx =0;
		gbc.gridy=7;
		addr.setPreferredSize(new Dimension(250,30));
		centerPanel.add(addr,gbc);
		
		gbc.gridx =0;
		gbc.gridy =8;
		centerPanel.add(city,gbc);
		
		gbc.gridx =1;
		gbc.gridy=8;
		centerPanel.add(state,gbc);
		
		gbc.gridx =2;
		gbc.gridy=8;
		centerPanel.add(zip,gbc);
		
		cit.setPreferredSize(new Dimension(180,30));
		gbc.gridx =0;
		gbc.gridy =9;
		centerPanel.add(cit,gbc);
		
		stat.setPreferredSize(new Dimension(180,30));
		gbc.gridx =1;
		gbc.gridy =9;
		centerPanel.add(stat,gbc);
		
		zipc.setPreferredSize(new Dimension(180,30));
		gbc.gridx =2;
		gbc.gridy =9;
		centerPanel.add(zipc,gbc);
		
		gbc.gridx=0;
		gbc.gridy=10;
		centerPanel.add(phone, gbc);
		
		phon.setPreferredSize(new Dimension(180,30));
		gbc.gridx=0;
		gbc.gridy=11;
		centerPanel.add(phon,gbc);
		
		gbc.gridx=0;
		gbc.gridy=12;
		centerPanel.add(pet,gbc);
		
		gbc.gridx=0;
		gbc.gridy=13;
		centerPanel.add(type,gbc);
		groupa.add(dog);
		groupa.add(cat);
		
		gbc.gridx=1;
		gbc.gridy=13;
		centerPanel.add(dog,gbc);
		
		gbc.gridx=2;
		gbc.gridy=13;
		centerPanel.add(cat,gbc);
		
		gbc.gridx=0;
		gbc.gridy=14;
		centerPanel.add(pname,gbc);
		
		petname.setPreferredSize(new Dimension(100,30));
		gbc.gridx=1;
		gbc.gridy=14;
		centerPanel.add(petname,gbc);
		
		gbc.gridx=0;
		gbc.gridy=15;
		centerPanel.add(psex,gbc);
		groups.add(male);
		groups.add(female);
		
		gbc.gridx=1;
		gbc.gridy=15;
		centerPanel.add(male,gbc);
		
		gbc.gridx=2;
		gbc.gridy=15;
		centerPanel.add(female,gbc);
		
		gbc.gridx=0;
		gbc.gridy=16;
		centerPanel.add(page,gbc);
		
		gbc.gridx=1;
		gbc.gridy=16;
		centerPanel.add(ages,gbc);
		
		gbc.gridx=0;
		gbc.gridy=17;
		centerPanel.add(pbreed,gbc);
		
		gbc.gridx=1;
		gbc.gridy=17;
		centerPanel.add(dogb,gbc);
		
		gbc.gridx=0;
		gbc.gridy=18;
		centerPanel.add(psize,gbc);
		groupw.add(lower);
		groupw.add(ulower);
		groupw.add(higher);
		groupw.add(uhigher);
		
		gbc.gridx =1;
		gbc.gridy=18;
		centerPanel.add(lower,gbc);
		
		gbc.gridx=2;
		gbc.gridy=18;
		centerPanel.add(ulower,gbc);
		
		gbc.gridx=3;
		gbc.gridy=18;
		centerPanel.add(higher,gbc);
		
		gbc.gridx=4;
		gbc.gridy=18;
		centerPanel.add(uhigher,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 19;
		centerPanel.add(food, gbc);
		groupf.add(ofood);
		groupf.add(hfood);
		
		gbc.gridx =1;
		gbc.gridy=19;
		centerPanel.add(ofood, gbc);
		
		gbc.gridx=2;
		gbc.gridy=19;
		centerPanel.add(hfood,gbc);
		
		gbc.gridx =0;
		gbc.gridy=20;
		centerPanel.add(walktime, gbc);
		
		wtime.setPreferredSize(new Dimension(40,30));
		gbc.gridx=1;
		gbc.gridy=20;
		centerPanel.add(wtime,gbc);
		
		gbc.gridx=2;
		gbc.gridy=20;
		centerPanel.add(minutes,gbc);
		
		gbc.gridx=0;
		gbc.gridy=21;
		centerPanel.add(hreactive, gbc);
		grouph.add(hYes);
		grouph.add(hNo);
		
		gbc.gridx=1;
		gbc.gridy=21;
		centerPanel.add(hYes,gbc);
		
		gbc.gridx=2;
		gbc.gridy=21;
		centerPanel.add(hNo,gbc);
		
		gbc.gridx=0;
		gbc.gridy=22;
		centerPanel.add(areactive, gbc);
		groupanimal.add(aYes);
		groupanimal.add(aNo);
		gbc.gridx=1;
		gbc.gridy=22;
		centerPanel.add(aYes,gbc);
		
		gbc.gridx=2;
		gbc.gridy=22;
		centerPanel.add(aNo,gbc);

		gbc.gridx=0;
		gbc.gridy=23;
		centerPanel.add(specInstr,gbc);
		
		instr.setPreferredSize(new Dimension(300,60));
		gbc.gridx=0;
		gbc.gridy=24;
		centerPanel.add(instr,gbc);
	
	
		
		
		//ADDING ALL THE PANELS TO THE MAINPANEL
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(rightPanel, BorderLayout.EAST);
		mainPanel.add(bar, BorderLayout.CENTER);
		
		//ADDING THE MAINPANEL TO THE FRAME
		frame.add(mainPanel);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1) {
			
		}
		
	}
}
