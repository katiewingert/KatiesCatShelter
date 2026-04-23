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
	private ArrayList<CatSlider> sliders;
	private AdoptionManager manager;
	private HomeGUI home; //necisary?
	private ArrayList<Cat> cats; 
	private Timer timer;
	private long lastFeedTime;
	private long lastPlayTime;
	public GameManager(ArrayList<CatSlider> sliderList, AdoptionManager adoptionManager, HomeGUI homeGUI) {
		sliders = sliderList;
		manager = adoptionManager;
		home = homeGUI;
		cats = adoptionManager.getAdoptedCats();
	}
	
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
	public void pauseGame() {
		timer.stop();
	}
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

	public void runAway(Cat cat) {
		manager.unadoptCat(cat);
		home.updateGUI(cat);
	}
	//TODO - I want to have some sort of indicator that the cat is happy or unhappy. Like top 33% happy middle uneasy bottom sad
}
