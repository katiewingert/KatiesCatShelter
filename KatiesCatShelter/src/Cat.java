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

import javax.swing.ImageIcon;

/**
 * Purpose: The reponsibility of Cat is ...
 *
 * Cat is-a ...
 * Cat is ...
 */
public abstract class Cat
{
	//Cat has-a name
	private String name;
	//Cat has-an age
	private int age;
	//Cat has-a adoption status
	private boolean isAdopted;
	//Cat has-a happiness level
	private int happiness;
	//Cat has-a social level
	private SocialLevel socialLevel;
	//Cat has-a picture
	private ImageIcon picture;
	
	public Cat() {
		isAdopted = false;
	}
	/**
	 * Purpose: Constructor for a cat object
	 */
	//TODO - Fix constructor
	public Cat(String name, int age, SocialLevel socialLevel, String pictureFilePath) {
		this.name = name;
		this.age = age;
		this.socialLevel = socialLevel;
		picture = new ImageIcon(pictureFilePath);
		happiness = 100;
		isAdopted = false;
	}
	
	/**
	 * Purpose: Getter for cat picture
	 * @Return the picture of the cat
	 */
	public ImageIcon getPicture() {
		return picture;
	}
	
	/**
	 * Purpose: Setter for cat picture
	 * @param the filepath of the cat picture
	 */
	public void setPicture(String filepath) {
		picture = new ImageIcon(filepath);
	}
	
	/**
	 * Purpose: Getter for cat name
	 * @Return cat name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Purpose: Setter for cat name
	 * @param new name for cat
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Purpose: Getter for cat age
	 * @Return cat age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Purpose: Setter for cat age
	 * @param new cat age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Purpose: Function that returns whether or not a cat is currently adopted
	 * @Return true if cat is adopted, false if cat is not adopted
	 */
	public boolean isAdopted() {
		return isAdopted;
	}
	
	/**
	 * Purpose: Function to adopt cat
	 */
	//TODO
	public void adopt() {
		isAdopted = true;
	}
	
	/**
	 * Purpose: Function to unadopt cat
	 */
	//TODO
	public void unadopt() {
		isAdopted = false;
	}
	
	/**
	 * Purpose: Getter for cat happiness
	 * @Return cat happiness
	 */
	public int getHappiness() {
		return happiness;
	}
	
	/**
	 * Purpose: Increase the happiness of a cat
	 * @param value to increase happiness by
	 */
	public void increaseHappiness(int happiness) {
		this.happiness += happiness;
		//happiness cannot exceed 100
		if (this.happiness > 100) {
			this.happiness = 100;
		}
	}
	
	public void decreaseHappiness(int happiness) {
		this.happiness -= happiness;
		if (this.happiness < 0) {
			this.happiness = 0;
		}
	}
	
	public String getSocialLevel() {
		return socialLevel.toString();
	}
	
	/**
	 * Purpose: Function that increases cat happiness due to being pet
	 */
	public void pet() {
		increaseHappiness(socialLevel.petEffect());
	}
	
	abstract void feed();
	
	abstract String getSize();
}
