import java.util.Date;
import java.util.ArrayList;
import java.util.Timer;
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
* Version: 2026-04-08
*/
import java.util.TimerTask;

import javax.swing.JSlider;

/**
 * Purpose: The reponsibility of GameManager is ...
 *
 * GameManager is-a ...
 * GameManager is ...
 */
public class GameManager
{
	//So, each slider needs a timer. Every 5ish seconds the timer 'goes off' and reduces happiness UNLESS an action is performed that
	//increases happiness. How to approach this? Who knows
	Timer timer;
	ArrayList<JSlider> sliders;
	AdoptionManager manager;
	HomeGUI home;
	public GameManager(ArrayList<JSlider> sliderList, AdoptionManager adoptionManager, HomeGUI homeGUI) {
		sliders = sliderList;
		manager = adoptionManager;
		home = homeGUI;
		timer = new Timer();
		ArrayList<Cat> cats = adoptionManager.getAdoptedCats();
		TimerTask task = new TimerTask() {
			public void run() {
				for (int i = 0; i < cats.size(); i++) {
					sliderList.get(i).setValue(cats.get(i).getHappiness() - 1);
					cats.get(i).decreaseHappiness(1);
				}
			}
		};
		Date startTime = new Date();
		timer.schedule(task, startTime, 1000);
	}
	
	public void wasPet(Cat cat) {
		cat.pet();
	}
	
	public void wasFed(Cat cat) {
		cat.feed();
	}


	
}
