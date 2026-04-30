import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
/**
 * Lead Author(s):
 * 
 * @author katie; student ID
 * @author Full name; student ID
 *         <<Add additional lead authors here>>
 *
 *         Other Contributors:
 *         Full name; student ID or contact information if not in class
 *         <<Add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 *
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 *         <<Add more references here>>
 *         https://docs.oracle.com/javase/tutorial/uiswing/painting/closer.html
 *         Version: 2026-04-20
 */
import java.awt.event.ActionListener;

/**
 * Purpose: The reponsibility of PaintLines is ...
 *
 * PaintLines is-a ...
 * PaintLines is ...
 */
public class CatButton extends JButton
{
	//CatButton has-a cat
	private Cat cat; 
	//CatButton has-a scale
	private int scale = 0;
	//CatButton has-a timer
	private Timer fadeTimer;

	/**
	 * Purpose: Constructor for CatButton
	 */
	public CatButton(ImageIcon icon, Cat cat)
	{
		super(icon);
		this.cat = cat;
	}

	/**
	 * Purpose: Method to paint the cage on cat buttons
	 * @param graphics
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int height = getHeight();
		int width = getWidth();

		for (int i = 10; i < width - scale; i += 20)
		{
			g.drawLine(i, 0, i, height);
			g.drawLine(i + 1, 0, i + 1, height);

		}
		for (int i = 10; i < height; i += 20)
		{
			g.drawLine(0, i, width - scale, i);
		}

	}

	/**
	 * Purpose: Fade out cage on cat button
	 */
	public void fadeOutCage()
	{
		ActionListener taskPerformed = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				scale += 2;
				if (scale > getWidth())
				{
					fadeTimer.stop();
				}
				repaint();
			}
		};
		fadeTimer = new Timer(10, taskPerformed);
		fadeTimer.start();
	}
}
