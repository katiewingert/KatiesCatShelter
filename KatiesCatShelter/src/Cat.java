import javax.swing.ImageIcon;

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
 *         Version: 2026-04-06
 */

/**
 * Purpose: The responsibility of Cat is to represent a cat, describe a cat's
 * attributes and abstractly describe its behaviors.
 *
 * Cat is an abstract class.
 */
public abstract class Cat
{
	// Cat has-a name
	private String name;
	// Cat has-an age
	private int age;
	// Cat has-a adoption status
	private boolean isAdopted;
	// Cat has-a happiness level
	private int happiness;
	// Cat has-a social level
	private SocialLevel socialLevel;
	// Cat has-a picture
	private ImageIcon picture;

	/**
	 * Purpose: Default constructor for a cat object.
	 */
	public Cat()
	{
		name = "NoName";
		age = -1;
		socialLevel = null;
		picture = null;
		isAdopted = false;
		happiness = 100;
	}

	/**
	 * Purpose: Constructor for a cat object.
	 */
	public Cat(String name, int age, SocialLevel socialLevel,
			String pictureFilePath)
	{
		this.name = name;
		this.age = age;
		this.socialLevel = socialLevel;
		picture = new ImageIcon(pictureFilePath);
		happiness = 100;
		isAdopted = false;
	}

	/**
	 * Purpose: Getter for cat picture.
	 * 
	 * @return the picture of the cat
	 */
	public ImageIcon getPicture()
	{
		return picture;
	}

	/**
	 * Purpose: Setter for cat picture.
	 * 
	 * @param the filepath of the cat picture
	 */
	public void setPicture(String filepath)
	{
		picture = new ImageIcon(filepath);
	}

	/**
	 * Purpose: Getter for cat name.
	 * 
	 * @return cat name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Purpose: Setter for cat name.
	 * 
	 * @param new name for cat
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Purpose: Getter for cat age.
	 * 
	 * @return cat age
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * Purpose: Setter for cat age.
	 * 
	 * @param new cat age
	 */
	public void setAge(int age)
	{
		this.age = age;
	}

	/**
	 * Purpose: Function that returns whether or not a cat is currently adopted.
	 * 
	 * @return true if cat is adopted, false if cat is not adopted
	 */
	public boolean isAdopted()
	{
		return isAdopted;
	}

	/**
	 * Purpose: Function to adopt cat.
	 */
	public void adopt()
	{
		isAdopted = true;
	}

	/**
	 * Purpose: Function to unadopt cat.
	 */
	public void unadopt()
	{
		isAdopted = false;
	}

	/**
	 * Purpose: Getter for cat happiness.
	 * 
	 * @return cat happiness
	 */
	public int getHappiness()
	{
		return happiness;
	}

	/**
	 * Purpose: Increase the happiness of a cat.
	 * 
	 * @param value to increase happiness by
	 */
	public void increaseHappiness(int happiness)
	{
		this.happiness += happiness;
		// happiness cannot exceed 100
		if (this.happiness > 100)
		{
			this.happiness = 100;
		}
	}

	/**
	 * Purpose: Decrease the happiness of a cat.
	 * 
	 * @param value to decrease happiness by
	 */
	public void decreaseHappiness(int happiness)
	{
		this.happiness -= happiness;
		// happiness cannot be less than 0
		if (this.happiness < 0)
		{
			this.happiness = 0;
		}
	}

	/**
	 * Purpose: Getter for cats social level.
	 * 
	 * @return social level
	 */
	public String getSocialLevel()
	{
		return socialLevel.toString();
	}

	/**
	 * Purpose: Function that increases cat happiness due to being pet.
	 */
	public void pet()
	{
		//pet response is specific to socialLevel
		increaseHappiness(socialLevel.petEffect());
	}

	/**
	 * Purpose: Define how feeding affects the cats happiness.
	 */
	abstract void feed();

	/**
	 * Purpose: Return the size of the cat.
	 * 
	 * @return size of cat
	 */
	abstract String getSize();
}
