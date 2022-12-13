package pethotel;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI implements ActionListener {

	public static Font FONT_BIG_TITLE = new Font("Verdana", Font.BOLD, 24);
	public static Font FONT_BUTTON = new Font("Verdana", Font.PLAIN, 14);
	public static Font FONT_SUBTITLE = new Font("Verdana", Font.BOLD, 15);
	public static Color BGCOLOR_LIGHTBLUE = new Color(159, 206, 249);
	public static Color FGCOLOR_DARKBLUE = new Color(32, 89, 153);
	JFrame mainFrame;
	JPanel menuPanel;
	JPanel mainPanel;
	
	JLabel lblMainTitle;
	JButton btnNewRes;
	JButton btnViewModifyRes;
	JButton btnViewActiveRes;
	JButton btnViewInactiveRes;
	
	NewReservation newReservationForm;   // Integrate with Vighnesh's code
	ViewReservation viewReservationForm; // Integrate with Vighnesh's code
	ActiveReservationsTable activeReservationsTable;
	InactiveReservationsTable inactiveReservationsTable;
	Reservation lastSelectedReservation = null;
	
	
	public MainGUI() {
		mainFrame = new JFrame();
		
		menuPanel = new JPanel();
		mainPanel = new JPanel();
		
		lblMainTitle = new JLabel("Pet Boarding Management System");		
		
		btnNewRes = new JButton("New Reservation");		
		btnNewRes.setFont(FONT_BUTTON);
		btnNewRes.addActionListener(this);
		
		btnViewModifyRes = new JButton("View / Modify a Reservation");
		btnViewModifyRes.setFont(FONT_BUTTON);
		btnViewModifyRes.addActionListener(this);
		
		btnViewActiveRes = new JButton("View Active Reservations");
		btnViewActiveRes.setFont(FONT_BUTTON);
		btnViewActiveRes.addActionListener(this);
		
		btnViewInactiveRes = new JButton("View Inactive Reservations");
		btnViewInactiveRes.setFont(FONT_BUTTON);
		btnViewInactiveRes.addActionListener(this);
		
	}
	
	
	public void initialize() {
		mainFrame.setSize(400, 900);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//mainFrame.setLocationRelativeTo(null); // doesn't work on Mac
		
		// Title and logo section
		ImageIcon logoIcon = new ImageIcon("logo_sm.png");
		JLabel lblLogo = new JLabel();
		lblMainTitle.setIcon(logoIcon);
		lblMainTitle.setFont(FONT_BIG_TITLE);
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(BGCOLOR_LIGHTBLUE);
		panelTitle.add(lblLogo);
		panelTitle.add(new JLabel("   "));  // add extra gap
		panelTitle.add(lblMainTitle);
		
		
		// Group title panel and buttons together in menuPanel
		menuPanel.setBackground(BGCOLOR_LIGHTBLUE);
		menuPanel.setBorder(new EmptyBorder(20, 40, 10, 40));
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		menuPanel.setLayout(gb);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0; c.gridy = 0; c.gridwidth = 4; c.weightx = 0; c.weighty = 0;
		menuPanel.add(panelTitle, c);
		
		c.insets = new Insets(10, 0, 20, 10);
		c.gridx = 0; c.gridy = 1; c.gridwidth = 1; c.ipady = 5;
		menuPanel.add(btnNewRes, c);
		c.insets = new Insets(10, 10, 20, 10);
		c.gridx = 1; c.gridy = 1; c.gridwidth = 1; c.ipady = 5;
		menuPanel.add(btnViewModifyRes, c);
		c.insets = new Insets(10, 10, 20, 10);
		c.gridx = 2; c.gridy = 1; c.gridwidth = 1; c.ipady = 5;
		menuPanel.add(btnViewActiveRes, c);
		c.insets = new Insets(10, 10, 20, 0);
		c.gridx = 3; c.gridy = 1; c.gridwidth = 1; c.ipady = 5;
		menuPanel.add(btnViewInactiveRes, c);
		
		// Main content section
		mainPanel.setBackground(BGCOLOR_LIGHTBLUE);
		mainPanel.setLayout(new BorderLayout(0, 10)); // set gap between the caption and the content form/table
		mainPanel.setPreferredSize(new Dimension(780, 400));
		mainPanel.setBorder(new EmptyBorder(0, 30, 20, 30));
		
		// Place menuPanel and mainPanel vertically in the frame's contentPane
		Container contentPane = mainFrame.getContentPane();
		contentPane.setBackground(BGCOLOR_LIGHTBLUE);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(BorderLayout.NORTH, menuPanel);
		contentPane.add(BorderLayout.CENTER, mainPanel);
	}
	
	
	public void displayFrame() {
		displayViewActiveReservations();
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	
	protected void displayNewReservation() {
		mainPanel.removeAll();
		
		newReservationForm = new NewReservation();
		JComponent component = newReservationForm.getContent();
		
		JLabel lblNewRes = new JLabel(" Book a New Reserveration:");
		lblNewRes.setFont(FONT_SUBTITLE);
		mainPanel.add(BorderLayout.NORTH, lblNewRes);
		mainPanel.add(BorderLayout.CENTER, component);
		 
		mainPanel.validate();
		mainPanel.repaint();
		
		btnNewRes.setForeground(Color.blue);
		btnViewModifyRes.setForeground(Color.BLACK);
		btnViewActiveRes.setForeground(Color.BLACK);
		btnViewInactiveRes.setForeground(Color.BLACK);
	}
	
	
	protected void displayViewModifyReservation(ActionEvent e) {
		if (lastSelectedReservation != null) {
			viewReservationForm = new ViewReservation(lastSelectedReservation);
		}
		else {
			JOptionPane.showMessageDialog(mainFrame, "No Reservation Selected! Please select a reservation first.",
										"ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
	
		mainPanel.removeAll();
		//viewReservationForm = new ViewReservation(lastSelectedReservation);
		JComponent component = viewReservationForm.getContent();
		
		JLabel lblNewRes = new JLabel(" View or Modify a Reserveration:");
		lblNewRes.setFont(FONT_SUBTITLE);
		mainPanel.add(BorderLayout.NORTH, lblNewRes);
		mainPanel.add(BorderLayout.CENTER, component);
		 
		mainPanel.validate();
		mainPanel.repaint();	
		
		btnNewRes.setForeground(Color.BLACK);
		btnViewModifyRes.setForeground(Color.blue);
		btnViewActiveRes.setForeground(Color.BLACK);
		btnViewInactiveRes.setForeground(Color.BLACK);
		
	}
	
	
	protected void displayViewActiveReservations() {
		mainPanel.removeAll();
		
		activeReservationsTable = new ActiveReservationsTable(this);	
		
		JComponent component = activeReservationsTable.getContent();
		JLabel lblActiveRes = new JLabel(" Active / Upcoming Reserverations:");
		lblActiveRes.setFont(FONT_SUBTITLE);		
		mainPanel.add(BorderLayout.NORTH, lblActiveRes);
		mainPanel.add(BorderLayout.CENTER, component);
		
		mainPanel.validate();
		mainPanel.repaint();
		
		btnNewRes.setForeground(Color.BLACK);
		btnViewModifyRes.setForeground(Color.BLACK);
		btnViewActiveRes.setForeground(Color.blue);
		btnViewInactiveRes.setForeground(Color.BLACK);
	}
	
	protected void displayViewInactiveReservations() {
		mainPanel.removeAll();
		
		inactiveReservationsTable = new InactiveReservationsTable(this);
		
		JComponent component = inactiveReservationsTable.getContent();
		JLabel lblInactiveRes = new JLabel(" Inactive Reserverations:");
		lblInactiveRes.setFont(FONT_SUBTITLE);		
		mainPanel.add(BorderLayout.NORTH, lblInactiveRes);
		mainPanel.add(BorderLayout.CENTER, component);
		
		mainPanel.validate();
		mainPanel.repaint();
		
		btnNewRes.setForeground(Color.BLACK);
		btnViewModifyRes.setForeground(Color.BLACK);
		btnViewActiveRes.setForeground(Color.BLACK);
		btnViewInactiveRes.setForeground(Color.blue);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equalsIgnoreCase(btnNewRes.getText())) {
			System.out.println("NewReservation is clicked");
			displayNewReservation();
		}
		else if (cmd.equalsIgnoreCase(btnViewModifyRes.getText())) {
			System.out.println("ViewModifyAReservation is clicked");
			displayViewModifyReservation(e);
		}
		else if (cmd.equalsIgnoreCase(btnViewActiveRes.getText())) {
			System.out.println("ViewActiveReservations is clicked");
			displayViewActiveReservations();
		}
		else if (cmd.equalsIgnoreCase(btnViewInactiveRes.getText())) {
			System.out.println("ViewInactiveReservations is clicked");
			displayViewInactiveReservations();
		}
		else if (cmd.equalsIgnoreCase("ActiveReservationsTable")) {
			this.lastSelectedReservation = activeReservationsTable.getSelectedReservation();
			System.out.println("MainGUI: update lastSelectedReservation = " 
							+ ((lastSelectedReservation != null) ? lastSelectedReservation.getReservationId() : "null"));
		}
		else if (cmd.equalsIgnoreCase("InactiveReservationsTable")) {
			this.lastSelectedReservation = inactiveReservationsTable.getSelectedReservation();
			System.out.println("MainGUI: update lastSelectedReservation = " 
					+ ((lastSelectedReservation != null) ? lastSelectedReservation.getReservationId() : "null"));			
		}
	}
	
	    
	public static void main(String[] args) {
		ReservationFileHandler.loadReservations("Reservations2022.txt");
		MainGUI base = new MainGUI();
		base.initialize();
		base.displayFrame();
	}

}
