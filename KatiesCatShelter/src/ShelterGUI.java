import java.util.ArrayList;
import javax.swing.*;
import java.util.Hashtable;
import java.awt.*;
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
	private Hashtable<String, CatButton> catHashTable = new Hashtable<>();
	
	/**
	 * Purpose: GUI for cat shelter
	 * @param adoption manager for shelter
	 */
	public ShelterGUI(AdoptionManager newAdoptionManager) {
		adoptionManager = newAdoptionManager;
		
		//set the primary layout to BorderLayout
		//TODO I forget what the parameters are for 
		
		
//		JLabel backgroundLabel = new JLabel(new ImageIcon("images/CatShelterPic.jpg"));
//		this.setContentPane(backgroundLabel);
		this.setLayout(new BorderLayout(10, 10));
		//panel to store title and home button
		JPanel titlePanel = new JPanel(new BorderLayout());
		
		//title label
		JLabel titleLabel = new JLabel("Welcome to Katie's Cat Shelter"); 
		titleLabel.setFont(new Font("Times New Roman", Font.ITALIC, 50));
		//titleLabel.setFont(new Font(""));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(titleLabel, BorderLayout.CENTER);
		titlePanel.setOpaque(false);
		//home button
		JButton homeButton = new JButton("\uD83C\uDFE0");
		homeButton.addActionListener(e -> switchToHome());
		homeButton.setBackground(Color.LIGHT_GRAY);
		
		titlePanel.add(homeButton, BorderLayout.EAST);
		this.add(titlePanel, BorderLayout.NORTH);
	
		//panel for the cat buttons
		JPanel catButtonPanel = new JPanel();
		//TODO again forgor what the params are and if are necisary 
		catButtonPanel.setLayout(new GridLayout(3, 4, 10, 10));
		
		//for loop to display all cats in ArrayList adoptableCats 
		ArrayList<Cat> adoptableCats = adoptionManager.getUnadoptedCats();
		for (int i = 0; i < adoptableCats.size(); i++) {
			
			Cat cat = adoptableCats.get(i);
			
			//each cat button is stored in its own cat panel
			JPanel catPanel = new JPanel(new BorderLayout());
			catPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			
			//each cat panel stores cat name and cat picture
			JLabel nameLabel = new JLabel(cat.getName());
			nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			ImageIcon catPicture = new ImageIcon();
			catPicture = new ImageIcon(cat.getPicture().getImage().getScaledInstance(250,  250, Image.SCALE_SMOOTH));
			CatButton catButton = new CatButton(catPicture, cat);
			catButton.setBackground(Color.LIGHT_GRAY);
			catButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			
			//add action listener so that clicking on a cat button will display the cats profile
			catButton.addActionListener(e -> showCatProfile(cat));
			catButton.setPreferredSize(new Dimension(275, 275));
			
			//add components to cat panel, then add cat panel to cat button panel
			catPanel.add(catButton, BorderLayout.NORTH);
			catPanel.add(nameLabel, BorderLayout.SOUTH);
			catButtonPanel.add(catPanel);
			
			//HashTable stores each cat button with the cats name being the key
			catHashTable.put(cat.getName(), catButton);
		}
		
		//add cat button panel to the GUI
		this.add(catButtonPanel, BorderLayout.CENTER);
		
		//pack();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Purpose: Action listener used to switch to home GUI
	 */
	public void switchToHome() {
		new HomeGUI(adoptionManager);
		//close the ShelterGUI when opening HomeGUI
		this.dispose();
	}
	
	/**
	 * Purpose: Action listener used to show profile of a cat
	 * @param cat to show profile of
	 */
	public void showCatProfile(Cat cat) {
		//JFrame for cat profiles
		JFrame catFrame = new JFrame();
		catFrame.setLayout(new GridLayout(1,2));
		catFrame.setPreferredSize(new Dimension(1000, 500));
		
		//west panel - cat picture
		JPanel westPanel = new JPanel();
		
		Image pic = cat.getPicture().getImage();
		pic = pic.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		
		JLabel catPic = new JLabel(new ImageIcon(pic));
		//catPic.setPreferredSize(new Dimension(500, 250));
		
		//Add component to the panel and add panel to the catFrame
		westPanel.add(catPic);
		catFrame.add(westPanel, BorderLayout.WEST);
		
		//east panel - cat information
		JPanel eastPanel = new JPanel(new GridLayout(6, 1));
		
		//JLabels for all the information to be displayed
		JLabel nameLabel = new JLabel("Here is some information about " + cat.getName());
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		JLabel ageLabel = new JLabel("Age: " + cat.getAge());
		ageLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ageLabel.setHorizontalAlignment(JLabel.CENTER);
		JLabel sizeLabel = new JLabel("Size: " + cat.getSize());
		sizeLabel.setHorizontalAlignment(JLabel.CENTER);
		sizeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		JLabel socialLevelLabel = new JLabel("Social Level: " + cat.getSocialLevel());
		socialLevelLabel.setHorizontalAlignment(JLabel.CENTER);
		socialLevelLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		JLabel adoptLabel = new JLabel("Ready to adopt " + cat.getName() + "?");
		adoptLabel.setHorizontalAlignment(JLabel.CENTER);
		adoptLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton adoptButton = new JButton();
		adoptButton.setText("Click to Adopt!");
		
		//Add action listener that lets the user adopt a cat on button click
		adoptButton.addActionListener(e -> adoptCat(cat, catFrame));
		
		//Add components to the panel and add panel to the catFrame
		eastPanel.add(nameLabel);
		eastPanel.add(ageLabel);
		eastPanel.add(sizeLabel);
		eastPanel.add(socialLevelLabel);
		eastPanel.add(adoptLabel);
		eastPanel.add(adoptButton);
		catFrame.add(eastPanel, BorderLayout.EAST);
		
		//Display the catFrame
		catFrame.pack();
		catFrame.setVisible(true);
	}
	
	/**
	 * Purpose: Action listener which allows user to adopt a cat
	 * @param cat to be adopted
	 * @param catFrame to be closed upon adoption
	 */
	public void adoptCat(Cat cat, JFrame catFrame) {
		JOptionPane.showMessageDialog(this, "Congratulations! You have adopted " + cat.getName());
		adoptionManager.adoptCat(cat);
		
		CatButton catButton = catHashTable.get(cat.getName());
		ImageIcon icon = (ImageIcon) catButton.getIcon();
		
		//Display an adopted message on the cat button and disable button click
		catButton.setEnabled(false);
		//remove the cage upon adoption
		catButton.fadeOutCage();
		//do not grey out button
		catButton.setDisabledIcon(icon);
		
		//close the catFrame after adoption
		catFrame.dispose();
	}
}
