package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewReservation implements ActionListener{
	JButton button1;
	JTextField test = new JTextField();
	
	public NewReservation() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLayout(null); when we use this method we have to specify the layout of any component we add
		//basically we disable the default layout setting
		
		JPanel mainPanel = new JPanel();
		JPanel northPanel = new JPanel();   //the panel with the label:Book a new Reservation
		JPanel southPanel = new JPanel();   //the panel with the button
		JPanel leftPanel = new JPanel();    //the panel on the left
		JPanel rightPanel = new JPanel();   //the panel on the right
		JPanel centerPanel = new JPanel();  //the panel in the center with all the input fields
		JLabel topic = new JLabel("Book a new Reservation:");
		topic.setBounds(48,18, 200,20);
		test.setPreferredSize(new Dimension(250,30));		
		
		northPanel.setBackground(Color.white);
		leftPanel.setBackground(Color.blue);
		rightPanel.setBackground(Color.blue);
		centerPanel.setBackground(Color.yellow);
		mainPanel.setSize(800,800);
		northPanel.setLayout(null);
		northPanel.add(topic);
		centerPanel.add(test);
		
		mainPanel.setLayout(new BorderLayout());
		northPanel.setPreferredSize(new Dimension(60,40));
		southPanel.setPreferredSize(new Dimension(100,60));
		centerPanel.setPreferredSize(new Dimension(100,100));
		leftPanel.setPreferredSize(new Dimension(50,50));
		rightPanel.setPreferredSize(new Dimension(50,50));
		
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(rightPanel, BorderLayout.EAST);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		frame.add(mainPanel);
		//Buttons is the south panel
		button1 = new JButton();
		button1.setSize(20,15);
		button1.setText("Save Reservation");
		button1.addActionListener(this);
		
		southPanel.setBackground(Color.blue);
		//southPanel.setLayout(new GridLayout(1,3,25,0));
		//southPanel.setBounds(25,100, 250,250);
		southPanel.add(button1);
				
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1) {
			
		}
		
	}
}
