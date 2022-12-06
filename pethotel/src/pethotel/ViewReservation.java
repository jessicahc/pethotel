package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class ViewReservation implements ActionListener{
	/*
	public JComponent getContent() {
		return panel;
	}*/
	//All the Buttons in the southPanel
	JButton button1, button2, button3;
	
	//All the TextFields required to get user input
	JTextField ownerNam = new JTextField();
	JTextField ads = new JTextField();
	JTextField cit = new JTextField();
	JTextField stat = new JTextField();
	JTextField zi = new JTextField();
	JTextField phon = new JTextField();
	JTextField petnam = new JTextField();
	JTextField walkingTim = new JTextField();
	JTextField specInstructio = new JTextField();
	JTextField cageNu = new JTextField();
	JTextField comment = new JTextField();
	
	//All the labels for the respective TextFields
	JLabel ownerName = new JLabel("First and Last name");
	JLabel address = new JLabel("Address");
	JLabel city = new JLabel("City");
	JLabel state = new JLabel("State");
	JLabel zip = new JLabel("Zip Code");
	JLabel phone = new JLabel("Phone");
	JLabel petname = new JLabel("Pet Name");
	JLabel walkingTime = new JLabel("Maximum Walking time of you Animal");
	JLabel specInstruction = new JLabel("Owner's special Instruction");
	JLabel cageNum = new JLabel("Cage #");
	JLabel comments = new JLabel("Care Attendant's Comment:");
	
			
	public ViewReservation() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLayout(null);
		
			
		
		JPanel mainpanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JLabel topic = new JLabel("View or Modify a Reservation:");
		topic.setBounds(48,18, 200,20);
		JLabel id = new JLabel("Reservation ID");  //i don't know how to dynamically get the ID number
		id.setBounds(600, 18, 200,20);
		
		mainpanel.setLayout(new BorderLayout());
		northPanel.setBackground(Color.white);
		leftPanel.setBackground(Color.blue);
		rightPanel.setBackground(Color.blue);
		centerPanel.setBackground(Color.yellow);
		mainpanel.setSize(800,800);
		northPanel.setLayout(null);
		northPanel.add(topic);
		northPanel.add(id);
		
		ownerName.setBounds(98,18,200,20);
		ownerNam.setPreferredSize(new Dimension(250,30));
		ads.setPreferredSize(new Dimension(250,30));
		cit.setPreferredSize(new Dimension(100,30));
		stat.setPreferredSize(new Dimension(70,30));
		zi.setPreferredSize(new Dimension(50,30));
		phon.setPreferredSize(new Dimension(200,30));
		petnam.setPreferredSize(new Dimension(250,30));
		walkingTim.setPreferredSize(new Dimension(70,30));	
		specInstructio.setPreferredSize(new Dimension(400,70));	
		cageNu.setPreferredSize(new Dimension(50,30));
		comment.setPreferredSize(new Dimension(250,50));	
		
		northPanel.setPreferredSize(new Dimension(60,40));
		southPanel.setPreferredSize(new Dimension(100,60));
		centerPanel.setPreferredSize(new Dimension(100,100));
		leftPanel.setPreferredSize(new Dimension(50,50));
		rightPanel.setPreferredSize(new Dimension(50,50));
		
		
		centerPanel.setLayout(null);
		mainpanel.add(northPanel, BorderLayout.NORTH);
		mainpanel.add(southPanel, BorderLayout.SOUTH);
		mainpanel.add(leftPanel, BorderLayout.WEST);
		mainpanel.add(rightPanel, BorderLayout.EAST);
		mainpanel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.add(ownerNam);
		centerPanel.add(ads);
		centerPanel.add(cit);
		centerPanel.add(stat);
		centerPanel.add(zi);
		centerPanel.add(phon);
		centerPanel.add(petnam);
		centerPanel.add(walkingTim);
		centerPanel.add(specInstructio);
		centerPanel.add(cageNu);
		centerPanel.add(comment);
		centerPanel.add(ownerName);
		
		//Buttons is the south panel
		button1 = new JButton();
		button1.setSize(20,15);
		button1.setText("Update Reservation");
		button1.addActionListener(this);
		
		button2= new JButton();
		button2.setSize(20, 15);
		button2.setText("Cancel Reservation");
		button2.addActionListener(this);
		
		button3 = new JButton();
		button3.setSize(20,15);
		button3.setText("Generate Bill and Report");
		button3.addActionListener(this);
		
		southPanel.setBackground(Color.blue);
		//southPanel.setLayout(new GridLayout(1,3,25,0));
		//southPanel.setBounds(25,100, 250,250);
		southPanel.add(button1);
		southPanel.add(button2);
		southPanel.add(button3);
						
		frame.add(mainpanel);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1) {
			
		}
		else if(e.getSource() == button2) {
			
		}
		else if(e.getSource() == button3) {
			
		}
	}

}
