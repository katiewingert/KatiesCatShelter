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
* GeeksforGeeks. “Introduction to Java Swing.” GeeksforGeeks, 15 Feb. 2022, 
* www.geeksforgeeks.org/java/introduction-to-java-swing/.
* 
* Oracle. “Javax.swing (Java Platform SE 8 ).” Docs.oracle.com, 
* docs.oracle.com/javase/8/docs/api/javax/swing/package-summary.html.
*
* www.leepoint.net /fred, Fred Swartz. “Java: Images - ImageIcon.” Puc-Rio.br, 2026, 
* web.tecgraf.puc-rio.br/~ismael/Cursos/apostilas/Java-Notes/30GUI/20graphics/45imageicon.html. Accessed 9 Apr. 2026.
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
			JLabel name = new JLabel(cat.getName());
			ImageIcon pic = new ImageIcon();
			pic = new ImageIcon(cat.getPicture().getImage().getScaledInstance(250,  250, Image.SCALE_SMOOTH));
			JButton button = new JButton(pic);
			
			name.setHorizontalAlignment(SwingConstants.CENTER);
			button.addActionListener(e -> showCatProfile(cat, button));
			button.setPreferredSize(new Dimension(275, 275));
			panel.add(button, BorderLayout.NORTH);
			panel.add(name, BorderLayout.SOUTH);
			catButtonPanel.add(panel);
			
			//so if user adopts 2 cats from shelter but one runs away, when the shelter reloads itll still show the adopted cat
			if (cat.isAdopted()) {
				button.setEnabled(false);
				button.setText("Adopted");
				button.setHorizontalTextPosition(JButton.CENTER);
				button.setVerticalTextPosition(JButton.CENTER);
				button.setFont(new Font("Serif", Font.BOLD, 30));
			}
			
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
	public void showCatProfile(Cat cat, JButton catButton) {
		//TODO - organize this code
		//TODO - style aspects. Cat on left half of the screen, profile information on right half, big adopt button
		JFrame catFrame = new JFrame();
		//west panel cat picture
		JPanel westPanel = new JPanel();
		JLabel catPic = new JLabel(cat.getPicture());
		westPanel.add(catPic);
		catFrame.add(westPanel, BorderLayout.WEST);
		
		//east panel info 
		JPanel eastPanel = new JPanel(new GridLayout(6, 1));
		JLabel nameLabel = new JLabel("Here is some information about " + cat.getName());
		JLabel ageLabel = new JLabel("Age: " + cat.getAge());
		JLabel sizeLabel = new JLabel("Size: " + cat.getSize());
		JLabel socialLevelLabel = new JLabel("Social Level: " + cat.getSocialLevel());
		JLabel adoptLabel = new JLabel("Ready to adopt " + cat.getName() + "?");
		
		JButton adoptButton = new JButton();
		adoptButton.setText("Click to Adopt!");
		adoptButton.addActionListener(e -> adoptCat(cat, catFrame,catButton));
		
		eastPanel.add(nameLabel);
		eastPanel.add(ageLabel);
		eastPanel.add(sizeLabel);
		eastPanel.add(socialLevelLabel);
		eastPanel.add(adoptLabel);
		eastPanel.add(adoptButton);
		catFrame.add(eastPanel, BorderLayout.EAST);
		
		catFrame.pack();
		catFrame.setVisible(true);
	}
	
	/**
	 * Purpose: Action listener which allows user to adopt a cat
	 * @param cat to be adopted
	 */
	public void adoptCat(Cat cat, JFrame catFrame, JButton catButton) {
		JOptionPane.showMessageDialog(this, "Congratulations! You have adopted " + cat.getName());
		adoptionManager.adoptCat(cat);
		catFrame.dispose();
		catButton.setEnabled(false);
		catButton.setText("Adopted");
		catButton.setHorizontalTextPosition(JButton.CENTER);
		catButton.setVerticalTextPosition(JButton.CENTER);
		catButton.setFont(new Font("Serif", Font.BOLD, 30));
		
	}
	
	/**
	 * Purpose:
	 * @param
	 * @Return
	 */
	public void updateGUI(JButton catButton) {
	}
}
