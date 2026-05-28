import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.JSlider;

/**
 * Lead Author(s):
 * 
 * @author Katie Wingert
 *
 *         Other Contributors:
 *         Chris Wingert, chris@wingert.org
 *
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 * 
 *         Miadelets, Oleksandr. “Java Timer Class.” CodeGym, 6 Jan. 2025,
 *         codegym.cc/groups/posts/java-timer-class.
 * 
 *         “Timer (Java Platform SE 8 ).” Docs.oracle.com,
 *         docs.oracle.com/javase/8/docs/api/javax/swing/Timer.html.
 * 
 *         “Using the Timer and TimerTask Classes.” Iitk.ac.in,
 *         www.iitk.ac.in/esc101/05Aug/tutorial/essential/threads/timer.html.
 * 
 *         “Java.util.Timer Class in Java.” GeeksforGeeks, 14 Nov. 2021,
 *         www.geeksforgeeks.org/java/java-util-timer-class-java/.
 *
 *         Version: 2026-04-08
 * 
 */

/**
 * Purpose: The responsibility of GameManager is to manage the cat game mechanics
 * by updating happiness based on feeding and petting, and returning cats to
 * shelter according to their happiness
 */
public class GameManager
{
	// GameManager has-many CatSliders
	private ArrayList<JSlider> sliders;
	// GameManager has-a AdoptionManager
	private AdoptionManager manager;
	// GameManager has-a HomeGUI
	private HomeGUI home;
	// GameManager has-many Cats
	private ArrayList<Cat> cats;
	// GameManager has-a timer
	private Timer timer;
	// GameManager has-a lastFeedTime
	private long lastFeedTime;
	// GameManager has-a lastPlayTime
	private long lastPlayTime;

	/**
	 * Purpose: Constructor for GameManager
	 * 
	 * @param list            of cat sliders
	 * @param adoptionManager that records adopted cats
	 * @param homeGUI         that calls this GameManager
	 */
	public GameManager(ArrayList<JSlider> sliderList,
			AdoptionManager adoptionManager, HomeGUI homeGUI)
	{
		sliders = sliderList;
		manager = adoptionManager;
		home = homeGUI;
		cats = adoptionManager.getAdoptedCats();
	}

	/**
	 * Purpose: Method to start the game
	 */
	public void startGame()
	{

		// create a new ActionListener
		ActionListener taskPerformed = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				for (int i = 0; i < cats.size(); i++)
				{
					cats.get(i).decreaseHappiness(1);
					// update the slider to the current happiness value
					sliders.get(i).setValue(cats.get(i).getHappiness());
					// check to see if the cats happiness has reached 0, and
					// have the cat run away if so
					if (cats.get(i).getHappiness() == 0)
					{
						runAway(cats.get(i));
					}
				}

			}
		};

		// timer performs taskPerformed every 1 second
		timer = new Timer(100, taskPerformed);
		timer.start();
	}

	/**
	 * Purpose: method to pause the game
	 */
	public void pauseGame()
	{
		timer.stop();
	}

	/**
	 * Purpose: Method to update happiness as a result of cat being pet
	 * 
	 * @param cat that was pet
	 */
	public void wasPet(Cat cat)
	{
		if (cat.getSocialLevel().equals("Extroverted"))
		{
			cat.pet();
		}
		else
		{
			long currTime = System.currentTimeMillis();
			if (currTime - lastPlayTime <= 1000)
			{
				// introverted cats are unhappy if they are overpet
				//pet is not successful
				cat.decreaseHappiness(1);
			}
			//when pet is successful
			else
			{
				cat.pet();
				lastPlayTime = currTime;
			}
		}
	}

	/**
	 * Purpose: Method to update happiness as a result of cat being fed
	 * 
	 * @param cat that was fed
	 */
	public void wasFed(Cat cat)
	{
		if (cat.getSize().equals("Big"))
		{
			cat.feed();
		}
		else
		{
			//use currTime variable to keep track of current time
			long currTime = System.currentTimeMillis();
			if (currTime - lastFeedTime <= 1000)
			{
				// small cats are unhappy if they are overfed
				// feed is not successful
				cat.decreaseHappiness(1);
			}
			//when feed is successful
			else
			{
				cat.feed();
				lastFeedTime = currTime;
			}
		}
	}

	/**
	 * Purpose: Method to call if a cat hits 0 happiness and leaves the home
	 * 
	 * @param cat that runs away
	 */
	public void runAway(Cat cat)
	{
		manager.unadoptCat(cat);
		home.updateGUI(cat);
	}
}
