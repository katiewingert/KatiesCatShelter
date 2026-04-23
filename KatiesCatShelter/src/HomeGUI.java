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
 * Purpose: The reponsibility of HomeGUI is ...
 *
 * HomeGUI is-a ...
 * HomeGUI is ...
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class HomeGUI extends JFrame
{
	//HomeGUI has-a adoptionManager
	private AdoptionManager adoptionManager;
	//HomeGUI has-many sliders
	private ArrayList<CatSlider> sliderList = new ArrayList<>();
	//HomeGUI has-a GameManager
	private GameManager manager;
	
	/**
	 * Purpose: GUI for home
	 * @param adoption manager 
	 */
	public HomeGUI(AdoptionManager newAdoptionManager) {
		adoptionManager = newAdoptionManager;
		ArrayList<Cat> myCats = adoptionManager.getAdoptedCats();
		manager = new GameManager(sliderList, adoptionManager, this);
		
		this.setLayout(new BorderLayout());
		//this.setPreferredSize(new Dimension(1000, 1000));
		
		JPanel catPanel = new JPanel(new GridLayout(3, myCats.size()));
		
		if (myCats.size() == 0) {
			JLabel label = new JLabel("You have no cats.");
			JLabel label2 = new JLabel("Stop by Katies Cat Shelter to adopt!");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setVerticalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Serif", Font.BOLD, 50));
			label2.setHorizontalAlignment(SwingConstants.CENTER);
			label2.setVerticalAlignment(SwingConstants.CENTER);
			label2.setFont(new Font("Serif", Font.BOLD, 50));
			catPanel.add(label);
			catPanel.add(label2);
		}
		
		//Get images of adopted cats on screen.
		for (int i = 0; i < myCats.size(); i++) {
			//TODO - set size and add some sort of padding
			JLabel label = new JLabel();
			label.setIcon(myCats.get(i).getPicture());
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setVerticalAlignment(SwingConstants.CENTER);
			catPanel.add(label);
		}
		
		//sliders
		for (int i = 0; i < myCats.size(); i++) {
			Cat cat = myCats.get(i);
			CatSlider slider = new CatSlider(JSlider.HORIZONTAL, cat);
			slider.setMaximum(100);
			slider.setMinimum(0);
			slider.setValue(100);
			slider.setEnabled(false);
			sliderList.add(slider);
			catPanel.add(slider);
		}
		
		// buttons		
		for (int i = 0; i < myCats.size(); i++) {
			Cat cat = myCats.get(i);
			JPanel buttonPanel = new JPanel();
			JButton button1 = new JButton();
			button1.setText("Feed");
			button1.addActionListener(e-> manager.wasFed(cat));
			JButton button2 = new JButton();
			button2.setText("Pet");
			button2.addActionListener(e->manager.wasPet(cat));
			buttonPanel.add(button1);
			buttonPanel.add(button2);
			catPanel.add(buttonPanel);
		}
		JPanel topPanel = new JPanel(new BorderLayout());
		
		JButton shelterButton = new JButton("\uD83D\uDC08");
		shelterButton.addActionListener(e -> switchToShelter());
		shelterButton.setSize(200, 200);
		topPanel.add(shelterButton, BorderLayout.EAST);
		this.add(topPanel, BorderLayout.NORTH);	
		
		//add components to the GUI
		this.add(catPanel, BorderLayout.CENTER);
		manager.startGame();
		//make visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public void switchToShelter() {
		manager.pauseGame();
		new ShelterGUI(adoptionManager);
		this.dispose();
	}
	
	//TODO - somethings going wrong where if you have multiple cats run away at the same time the last cat to run away the HomeGUI stays
	//so theres 2 homeGUIs open
	public void updateGUI(Cat cat) {
		JOptionPane.showMessageDialog(this, "Oh no! " + cat.getName() + " ran away! Don't forget to engage with your cats!");
		this.dispose();
		new HomeGUI(adoptionManager);
	}
	//TODO - set background to something interesting
	
	
}
