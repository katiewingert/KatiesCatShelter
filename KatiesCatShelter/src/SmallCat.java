/**
* Lead Author(s):
* @author Katie Wingert
*
* Other Contributors:
* Chris Wingert, chris@wingert.org
* 
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* Version: 2026-04-06
*/

/**
 * Purpose: The responsibility of SmallCat is to represent a small cat with
 * feeding behavior specific to small cats.
 * 
 * SmallCat is-a Cat
 */
public class SmallCat extends Cat
{
	/**
	 * Purpose: Constructor for SmallCat.
	 * @param name of cat
	 * @param age of cat
	 * @param SocialLevel of cat
	 * @param filepath of cat picture
	 */
	public SmallCat(String name, int age, SocialLevel level, String filePath) {
		super(name, age, level, filePath);
	}
	
	/**
	 * Purpose: increase cat happiness based on feed effect.
	 */
	@Override
	public void feed() {
		//the same portion of food increases happiness more for a small cat
		this.increaseHappiness(10);
	}
	
	/**
	 * Purpose: Method to get the size of the cat.
	 * @return small for small cats
	 */
	@Override
	public String getSize() {
		return "Small";
	}
	
	/**
	 * Purpose: toString method for testing purposes.
	 * @return string of cat attributes
	 */
	@Override
	public String toString() {
		return getName() + getAge() + getSocialLevel() + getSize();
	}
}
