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
 * Purpose: The reponsibility of BigCat is ...
 *
 * BigCat is-a ...
 * BigCat is ...
 */
public class BigCat extends Cat
{
	/**
	 * Purpose: Default constructor for BigCat
	 */
	public BigCat() {}
	
	/**
	 * Purpose: Constructor for BigCat
	 * @param name of cat
	 * @param age of cat
	 * @param socialLevel of cat
	 * @param file path of cat photo
	 */
	public BigCat(String name, int age, SocialLevel level, String filePath) {
		super(name, age, level, filePath);
	}
	/**
	 * Purpose: Increase happiness of cat because of being fed
	 */
	@Override
	public void feed() {
		//the same portion of food increases happiness less for a big cat
		this.increaseHappiness(5);
	}
	
	/**
	 * Purpose: Get size of cat
	 * @return size of cat
	 */
	@Override
	public String getSize() {
		return "Big";
	}
	
	/**
	 * Purpose: toString method for testing purposes
	 * @return string of cat attributes
	 */
	@Override
	public String toString() {
		return getName() + getAge() + getSocialLevel() + getSize();
	}
}
