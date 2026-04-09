/**
* Lead Author(s):
* @author katie; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2026-04-06
*/


import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.*;

/**
 * Purpose: The reponsibility of ShelterGUI is ...
 *
 * ShelterGUI is-a ...
 * ShelterGUI is ...
 */
public class ShelterGUI extends JFrame
{
	//ShelterGUI has-a adoptionManager
	private AdoptionManager adoptionManager;
	//ShelterGUI has-many catButtons
	private ArrayList<JButton> catButtons = new ArrayList<>();
	/**
	 * Purpose: GUI for cat shelter
	 * @param adoption manager for shelter
	 */
	public ShelterGUI(AdoptionManager newAdoptionManager) {
		adoptionManager = newAdoptionManager;
		//set the primary layout to BorderLayout
		this.setLayout(new BorderLayout(10, 10));
		//panel for the title
		JPanel titlePanel = new JPanel(new BorderLayout());
		JLabel titleLabel = new JLabel("Welcome to Katie's Cat Shelter"); 
		titleLabel.setFont(new Font("Serif", Font.BOLD, 50));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		titlePanel.add(titleLabel, BorderLayout.CENTER);
		
		//home button
		JButton homeButton = new JButton("\uD83C\uDFE0");
		homeButton.addActionListener(e -> switchToHome());
		homeButton.setSize(200, 200);
		titlePanel.add(homeButton, BorderLayout.EAST);
		this.add(titlePanel, BorderLayout.NORTH);
		
		//panel for the buttons
		JPanel catButtonPanel = new JPanel();
		catButtonPanel.setLayout(new GridLayout(3, 4, 10, 10));
		ArrayList<Cat> adoptableCats = adoptionManager.getUnadoptedCats();
		for (int i = 0; i < adoptableCats.size(); i++) {
			Cat cat = adoptableCats.get(i);
			JPanel panel = new JPanel(new BorderLayout());
			JButton button = new JButton();
			JLabel name = new JLabel(cat.getName());
			ImageIcon pic = new ImageIcon();
			
			name.setHorizontalAlignment(SwingConstants.CENTER);
			button.addActionListener(e -> showCatProfile(cat));
			pic = new ImageIcon(cat.getPicture().getImage().getScaledInstance(250,  250, Image.SCALE_SMOOTH));
			button.setIcon(pic);
			button.setPreferredSize(new Dimension(275, 275));
			panel.add(button, BorderLayout.NORTH);
			panel.add(name, BorderLayout.SOUTH);
			catButtonPanel.add(panel);
			
			catButtons.add(button);
		}
		this.add(catButtonPanel, BorderLayout.CENTER);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	/**
	 * Purpose: Action listener used to switch to home GUI
	 */
	public void switchToHome() {
		new HomeGUI(adoptionManager);
		this.dispose();
	}
	
	/**
	 * Purpose: Action listener used to show profile of a cat
	 * @param cat to show profile of
	 */
	public void showCatProfile(Cat cat) {
		//TODO - organize this code
		//TODO - style aspects. Cat on left half of the screen, profile information on right half, big adopt button
		JFrame catFrame = new JFrame();
		//west panel cat picture
		JPanel westPanel = new JPanel();
		JLabel catPic = new JLabel(cat.getPicture());
		westPanel.add(catPic);
		catFrame.add(westPanel, BorderLayout.WEST);
		
		//east panel info 
		JPanel eastPanel = new JPanel(new GridLayout(3, 1));
		JLabel nameLabel = new JLabel("Name: " + cat.getName());
		JLabel ageLabel = new JLabel("Age: " + cat.getAge());
		
		JButton adoptButton = new JButton();
		adoptButton.setText("Click to Adopt!");
		adoptButton.addActionListener(e -> adoptCat(cat, catFrame));
		
		eastPanel.add(nameLabel);
		eastPanel.add(ageLabel);
		eastPanel.add(adoptButton);
		catFrame.add(eastPanel, BorderLayout.EAST);
		
		catFrame.pack();
		catFrame.setVisible(true);
	}
	
	/**
	 * Purpose: Action listener which allows user to adopt a cat
	 * @param cat to be adopted
	 */
	public void adoptCat(Cat cat, JFrame catFrame) {
		if (!cat.isAdopted()) {
			JOptionPane.showMessageDialog(this, "Congratulations! You have adopted " + cat.getName());
			adoptionManager.adoptCat(cat);
			//close the profile upon adoption
			catFrame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "You have already adopted " + cat.getName());
			catFrame.dispose();
		}
	}
	
	/**
	 * Purpose:
	 * @param
	 * @Return
	 */
	public void updateGUI() {
		//TODO?
	}
	

	
	public static void main(String[] args) {
		//this is all temporary just for testing the GUI
		Cat charisma = new BigCat();
		charisma.setPicture("/Users/katie/eclipse-workspace/KatiesCatShelter/images/Elle.jpg");
		charisma.setName("Charisma");
		charisma.setAge(3);
		Cat one = new BigCat();
		one.setName("Dotty");
		one.setAge(2);
		one.setPicture("/Users/katie/eclipse-workspace/KatiesCatShelter/images/Elle.jpg");
		Cat two = new BigCat();
		two.setPicture("/Users/katie/eclipse-workspace/KatiesCatShelter/images/Elle.jpg");
		Cat three = new BigCat();
		three.setPicture("/Users/katie/eclipse-workspace/KatiesCatShelter/images/Elle.jpg");
		Cat four = new BigCat();
		four.setPicture("/Users/katie/eclipse-workspace/KatiesCatShelter/images/Elle.jpg");
		Cat five = new BigCat();
		five.setPicture("/Users/katie/eclipse-workspace/KatiesCatShelter/images/Elle.jpg");
		Cat six = new BigCat();
		six.setPicture("/Users/katie/eclipse-workspace/KatiesCatShelter/images/Elle.jpg");
		Cat seven = new BigCat();
		seven.setPicture("/Users/katie/eclipse-workspace/KatiesCatShelter/images/Elle.jpg");
		Cat eight = new BigCat();
		eight.setPicture("/Users/katie/eclipse-workspace/KatiesCatShelter/images/Elle.jpg");
		Cat nine = new BigCat();
		nine.setPicture("/Users/katie/eclipse-workspace/KatiesCatShelter/images/Elle.jpg");
		Cat ten = new BigCat();
		ten.setPicture("/Users/katie/eclipse-workspace/KatiesCatShelter/images/Elle.jpg");
		Cat eleven = new BigCat();
		eleven.setPicture("/Users/katie/eclipse-workspace/KatiesCatShelter/images/Elle.jpg");
		AdoptionManager adoptionManager = new AdoptionManager();
		adoptionManager.addCat(charisma);
		adoptionManager.addCat(one);
		adoptionManager.addCat(two);
		adoptionManager.addCat(three);
		adoptionManager.addCat(four);
		adoptionManager.addCat(five);
		adoptionManager.addCat(six);
		adoptionManager.addCat(seven);
		adoptionManager.addCat(eight);
		adoptionManager.addCat(nine);
		adoptionManager.addCat(ten);
		adoptionManager.addCat(eleven);
		new ShelterGUI(adoptionManager);
	}
}
