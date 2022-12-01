package pethotel;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class BaseGUI implements ActionListener {

	JFrame mainFrame;
	JPanel menuPanel;
	JPanel mainPanel;
	
	JLabel lblMainTitle;
	JButton btnNewRes;
	JButton btnViewModifyRes;
	JButton btnViewActiveRes;
	JButton btnViewInactiveRes;
	
	NewReservationForm newResForm;
	ActiveReservationsTable activeResTable;
	
	Font fontTitle, fontButton, fontContent;
	Color bgColor;
	
	
	public BaseGUI() {
		mainFrame = new JFrame();
		
		menuPanel = new JPanel();
		mainPanel = new JPanel();
		
		lblMainTitle = new JLabel("Pet Boarding Management System");
		
		btnNewRes = new JButton("New Reservation");
		btnNewRes.addActionListener(this);
		
		btnViewModifyRes = new JButton("View / Modify a Reservation");
		btnViewModifyRes.addActionListener(this);
		
		btnViewActiveRes = new JButton("View Active Reservations");
		btnViewActiveRes.addActionListener(this);
		
		btnViewInactiveRes = new JButton("View Inactive Reservations");
		btnViewInactiveRes.addActionListener(this);
		
		newResForm = new NewReservationForm();
		activeResTable = new ActiveReservationsTable();
		
		fontTitle = new Font("Verdana", Font.BOLD, 24);
		fontButton = new Font("Arial", Font.PLAIN, 15);
		fontContent = new Font("Arial", Font.BOLD, 15);
		bgColor = new Color(159, 206, 249);
	}
	

	public void initialize() {
		mainFrame.setSize(800, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		
		// Title and logo section
		ImageIcon logoIcon = new ImageIcon("logo_sm.png");
		JLabel lblLogo = new JLabel();
		lblMainTitle.setIcon(logoIcon);
		lblMainTitle.setFont(fontTitle);
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(bgColor);
		panelTitle.add(lblLogo);
		panelTitle.add(new JLabel("   "));  // add extra gap
		panelTitle.add(lblMainTitle);
		
		// Menu buttons section
		btnNewRes.setFont(fontButton);
		btnViewModifyRes.setFont(fontButton);
		btnViewActiveRes.setFont(fontButton);
		btnViewInactiveRes.setFont(fontButton);
		
		// Group title panel and buttons together in menuPanel
		menuPanel.setBackground(bgColor);
		menuPanel.setBorder(new EmptyBorder(20, 40, 10, 40));
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		menuPanel.setLayout(gb);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0; c.gridy = 0; c.gridwidth = 4;
		menuPanel.add(panelTitle, c);
		
		c.insets = new Insets(10, 0, 20, 10);
		c.gridx = 0; c.gridy = 1; c.gridwidth = 1; c.ipady = 15;
		menuPanel.add(btnNewRes, c);
		c.insets = new Insets(10, 10, 20, 10);
		c.gridx = 1; c.gridy = 1; c.gridwidth = 1; c.ipady = 15;
		menuPanel.add(btnViewModifyRes, c);
		c.insets = new Insets(10, 10, 20, 10);
		c.gridx = 2; c.gridy = 1; c.gridwidth = 1; c.ipady = 15;
		menuPanel.add(btnViewActiveRes, c);
		c.insets = new Insets(10, 10, 20, 0);
		c.gridx = 3; c.gridy = 1; c.gridwidth = 1; c.ipady = 15;
		menuPanel.add(btnViewInactiveRes, c);
		
		// Main content section
		mainPanel.setBackground(bgColor);
		mainPanel.setLayout(new BorderLayout(0, 10)); // set gap between the caption and the content form/table
		mainPanel.setPreferredSize(new Dimension(780, 400));
		mainPanel.setBorder(new EmptyBorder(0, 20, 20, 20));
		
		// Place menuPanel and mainPanel vertically in the frame's contentPane
		Container contentPane = mainFrame.getContentPane();
		contentPane.setBackground(bgColor);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(BorderLayout.NORTH, menuPanel);
		contentPane.add(BorderLayout.CENTER, mainPanel);
	}
	
	
	public void displayFrame() {
		displayViewActiveReservation();
		btnViewActiveRes.setForeground(Color.BLUE);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	
	protected void displayNewReservation() {
		mainPanel.removeAll();
		
		JComponent component = newResForm.getContent();
		JLabel lblNewRes = new JLabel(" Book a New Reserveration:");
		lblNewRes.setFont(fontContent);
		mainPanel.add(BorderLayout.NORTH, lblNewRes);
		mainPanel.add(BorderLayout.CENTER, component);
		
		mainPanel.validate();
		mainPanel.repaint();
	}
	
	
	protected void displayViewActiveReservation() {
		mainPanel.removeAll();
		
		JComponent component = activeResTable.getContent();
		JLabel lblActiveRes = new JLabel(" Active/Upcoming Reserverations:");
		lblActiveRes.setFont(fontContent);
		mainPanel.add(BorderLayout.NORTH, lblActiveRes);
		mainPanel.add(BorderLayout.CENTER, component);
		mainPanel.validate();
		mainPanel.repaint();
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.contentEquals(btnNewRes.getText())) {
			System.out.println("NewReservation is clicked");
			displayNewReservation();
		}
		else if (cmd.contentEquals(btnViewModifyRes.getText())) {
			System.out.println("ViewModifyAReservation is clicked");
		}
		else if (cmd.contentEquals(btnViewActiveRes.getText())) {
			System.out.println("ViewActiveReservations is clicked");
			displayViewActiveReservation();
		}
		else if (cmd.contentEquals(btnViewInactiveRes.getText())) {
			System.out.println("ViewInactiveReservations is clicked");
		}
	}
	
	
	
	public static void main(String[] args) {
		ReservationFileHandler.loadReservations("Reservations2022.txt");
		BaseGUI base = new BaseGUI();
		base.initialize();
		base.displayFrame();
	}

}
