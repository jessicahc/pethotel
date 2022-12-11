package pethotel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class TestRadioButtonGroup {
	JRadioButton rbTypeDog = new JRadioButton("Dog", false);
	JRadioButton rbTypeCat = new JRadioButton("Cat", false);
	ButtonGroup grpPetType = new ButtonGroup();
	
	JComboBox<String> cbBreedList = new JComboBox<String>();
	
	private class PetTypeListener implements ActionListener {

		public void actionPerformed(ActionEvent actionEvent) {
			String[] breedList;
			String aeCmd = actionEvent.getActionCommand();
			if (aeCmd.equalsIgnoreCase(rbTypeDog.getText())) {
				breedList = Dog.DOG_BREED_LIST;
				cbBreedList.removeAllItems();
				for (int i=0; i < breedList.length; i++)
					cbBreedList.addItem(breedList[i]);
			}
			else if (aeCmd.equalsIgnoreCase(rbTypeCat.getText())) {
				breedList = Cat.CAT_BREED_LIST;
				cbBreedList.removeAllItems();
				for (int i=0; i < breedList.length; i++)
					cbBreedList.addItem(breedList[i]);
			}	
		}
	}	
	
	public TestRadioButtonGroup() {
		grpPetType.add(rbTypeDog);
		grpPetType.add(rbTypeCat);
		
		// Default animal breed to "Unknown". BreedList will be dynamically set
		// based on user's selection for PetType (dog vs. cat)
		cbBreedList.addItem("Unknown");
		
		// Register ActionListener for radio button Dog and Cat
		rbTypeDog.addActionListener(new PetTypeListener());
		rbTypeDog.setActionCommand(rbTypeDog.getText());
		
		rbTypeCat.addActionListener(new PetTypeListener());
		rbTypeCat.setActionCommand(rbTypeCat.getText());
	}
	
	public void displayFrame() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(200,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); //make frame pop out at the center of screen
		
		JPanel panel = new JPanel(new BorderLayout(10, 0));
		panel.add(BorderLayout.NORTH, rbTypeDog);
		panel.add(BorderLayout.CENTER, rbTypeCat);
		panel.add(BorderLayout.SOUTH, cbBreedList);
		panel.setBorder(new EmptyBorder(20,20,20,20));
		
		Container contentPane = frame.getContentPane();		
		contentPane.add(panel);		
	}
	
	
	public static void main(String[] args) {
		TestRadioButtonGroup test = new TestRadioButtonGroup();
		test.displayFrame();
	}
	
}
