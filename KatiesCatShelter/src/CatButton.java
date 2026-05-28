import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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
 *         “A Closer Look at the Paint Mechanism (the JavaTM Tutorials >
 *         Creating a GUI with Swing > Performing Custom Painting).” Oracle.com,
 *         docs.oracle.com/javase/tutorial/uiswing/painting/closer.html.
 *         Jiménez, Osvaldo. Draw, Paint, Repaint. Sept. 2008,
 *         https://web.stanford.edu/class/archive/cs/cs108/cs108.1092/handouts081/27PaintRepaint.pdf
 *         Version: 2026-04-20
 */
import java.awt.event.ActionListener;

/**
 * Purpose: The responsibility of CatButton is to display a cat image as a
 * JButton and to draw a cage over the JButton until cat adoption, when
 * CatButton will then fade out the cage.
 * 
 * CatButton is-a JButton
 */
public class CatButton extends JButton
{
	// CatButton has-a cat
	private Cat cat;
	// CatButton has-a scale
	private int scale = 0;
	// CatButton has-a timer
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
	 * 
	 * @param graphics
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int height = getHeight();
		int width = getWidth();

		// draw the vertical lines of the cage
		for (int i = 10; i < width - scale; i += 20)
		{
			g.drawLine(i, 0, i, height);
			g.drawLine(i + 1, 0, i + 1, height);

		}

		// draw the horizontal lines of the cage
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
		// add a new ActionListener to slide the cage
		ActionListener taskPerformed = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// use scale variable to decrease the amount of cage drawn on
				// every repaint call
				scale += 2;
				if (scale > getWidth())
				{
					fadeTimer.stop();
				}
				repaint();
			}
		};

		// at every 10 millisecond interval, perform taskPerformed
		fadeTimer = new Timer(10, taskPerformed);
		fadeTimer.start();
	}
}
