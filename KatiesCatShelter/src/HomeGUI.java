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
	
	/**
	 * Purpose: GUI for home
	 * @param adoption manager 
	 */
	public HomeGUI(AdoptionManager newAdoptionManager) {
		//adoption manager
		adoptionManager = newAdoptionManager;
		//get ArrayList of owners adopted cats
		ArrayList<Cat> myCats = new ArrayList<>();
		myCats = adoptionManager.getAdoptedCats();
		
		this.setLayout(new BorderLayout());
		
		//create panel for cats
		JPanel catPanel = new JPanel();
		JPanel sliderPanel = new JPanel();
		//Get images of adopted cats on screen.
		for (int i = 0; i < myCats.size(); i++) {
			//Creating cat pictures
			//TODO - set size and add some sort of padding
			JLabel label = new JLabel();
			label.setIcon(myCats.get(i).getPicture());
			catPanel.add(label);
			
			//Happiness sliders
			//TODO - related to the game aspect, much work to be done
			JSlider slider = new JSlider(JSlider.HORIZONTAL);
			slider.disable();
			sliderPanel.add(slider);
		}
		
		//add components to the GUI
		this.add(sliderPanel, BorderLayout.SOUTH);
		this.add(catPanel, BorderLayout.CENTER);
		//make visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	//TODO - game component - new class?
	//TODO - set background to something interesting
	//TODO - I want to have some sort of indicator that the cat is happy or unhappy. Like top 33% happy middle uneasy bottom sad
	//thats probably connected to the game aspect
	
}
