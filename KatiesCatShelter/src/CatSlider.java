import javax.swing.*;
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
* <<Add more references here>>
*
* Version: 2026-04-22
*/

/**
 * Purpose: The reponsibility of CatSlider is ...
 *
 * CatSlider is-a ...
 * CatSlider is ...
 */
public class CatSlider extends JSlider
{
	//TODO None of this works at all so whole thing gotta fix
	//paintComponents clearly the wrong method to use
	private Cat cat;
	public CatSlider(int a, Cat cat) {
		super(a);
		this.cat = cat;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (cat.getHappiness() >= 66) {
			g.setColor(Color.GREEN);
		}
		else if (cat.getHappiness() >= 33) {
			g.setColor(Color.ORANGE);
		}
		else {
			g.setColor(Color.RED);
		}
	}
}
