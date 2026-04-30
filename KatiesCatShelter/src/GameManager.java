import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
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
*https://codegym.cc/groups/posts/java-timer-class
*https://docs.oracle.com/javase/8/docs/api/javax/swing/Timer.html
* Version: 2026-04-08
* 
*/
import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;
import javax.swing.JSlider;

/**
 * Purpose: The reponsibility of GameManager is ...
 *
 * GameManager is-a ...
 * GameManager is ...
 */
public class GameManager
{ 
	//GameManager has-many CatSliders
	private ArrayList<CatSlider> sliders;
	//GameManager has-a AdoptionManager
	private AdoptionManager manager;
	//GameManager has-a HomeGUI
	private HomeGUI home;
	//GameManager has-many Cats
	private ArrayList<Cat> cats;
	//GameManager has-a timer
	private Timer timer;
	//GameManager has-a lastFeedTime
	private long lastFeedTime;
	//GameManager has-a lastPlayTime
	private long lastPlayTime;
	
	/**
	 * Purpose: Constructor for GameManager
	 * @param list of cat sliders
	 * @param adoptionManager that records adopted cats
	 * @param homeGUI that calls this GameManager
	 */
	public GameManager(ArrayList<CatSlider> sliderList, AdoptionManager adoptionManager, HomeGUI homeGUI) {
		sliders = sliderList;
		manager = adoptionManager;
		home = homeGUI;
		cats = adoptionManager.getAdoptedCats();
	}
	
	/**
	 * Purpose: Method to start the game
	 */
	public void startGame() {
		
		ActionListener taskPerformed = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				for (int i = 0; i < cats.size(); i++) {
					cats.get(i).decreaseHappiness(1);
					sliders.get(i).setValue(cats.get(i).getHappiness());
					if (cats.get(i).getHappiness() == 0) {
						runAway(cats.get(i));
					}
				}
				
			}
		};
			
		timer = new Timer(100, taskPerformed);
		timer.start();
	}
	
	/**
	 * Purpose: method to pause the game
	 */
	public void pauseGame() {
		timer.stop();
	}
	
	/**
	 * Purpose: Method to update happiness as a result of cat being pet
	 * @param cat that was pet
	 */
	public void wasPet(Cat cat) {
		if (cat.getSocialLevel().equals("Extroverted")) {
			cat.pet();
		}
		else {
			long currTime = System.currentTimeMillis();
			if (currTime - lastPlayTime <= 1000) {
				//small cats are a little unhappy if they are overfed
				cat.decreaseHappiness(1);
			}
			else {
				cat.pet();
				lastPlayTime = currTime;
			}
		}
	}
	
	/**
	 * Purpose: Method to update happiness as a result of cat being fed
	 * @param cat that was fed
	 */
	public void wasFed(Cat cat) {
		if (cat.getSize().equals("Big")) {
			cat.feed();
		}
		else {
			long currTime = System.currentTimeMillis();
			if (currTime - lastFeedTime <= 1000) {
				//small cats are a little unhappy if they are overfed
				cat.decreaseHappiness(1);
			}
			else {
				cat.feed();
				lastFeedTime = currTime;
			}
		}
	}

	/**
	 * Purpose: Method to call if a cat hits 0 happiness and leaves the home
	 * @param cat that runs away
	 */
	public void runAway(Cat cat) {
		manager.unadoptCat(cat);
		home.updateGUI(cat);
	}
	//TODO - I want to have some sort of indicator that the cat is happy or unhappy. Like top 33% happy middle uneasy bottom sad
}
