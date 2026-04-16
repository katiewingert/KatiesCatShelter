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
 * Purpose: The reponsibility of Introverted is ...
 *
 * Introverted is-a ...
 * Introverted is ...
 */
public class Introverted implements SocialLevel
{
	/**
	 * Purpose: increase cat happiness based on pet effect
	 */
	public int petEffect() {
		//introverted cats need less pets to be happy
		return 10;
	}
	
	@Override
	public String toString() {
		return "Introverted";
	}
}
