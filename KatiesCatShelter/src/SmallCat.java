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
 * Purpose: The reponsibility of SmallCat is ...
 *
 * SmallCat is-a ...
 * SmallCat is ...
 */
public class SmallCat extends Cat
{
	public SmallCat(String name, int age, SocialLevel level, String filePath) {
		super(name, age, level, filePath);
	}
	/**
	 * Purpose: increase cat happiness based on feed effect
	 */
	@Override
	public void feed() {
		//the same portion of food increases happiness more for a small cat
		this.increaseHappiness(10);
	}
}
