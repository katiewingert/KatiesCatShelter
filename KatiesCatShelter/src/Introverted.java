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
*
* Version: 2026-04-06
*/

/**
 * Purpose: The reponsibility of Introverted is to define the behavior of introverted cats.
 *
 * Introverted is-a SocialLevel
 */
public class Introverted implements SocialLevel
{
	/**
	 * Purpose: increase cat happiness based on pet effect.
	 */
	public int petEffect() {
		//introverted cats need less pets to be happy
		return 10;
	}
	
	/**
	 * Purpose: Method to return cats SocialLevel.
	 * @return introverted for introverted cats
	 */
	@Override
	public String toString() {
		return "Introverted";
	}
}
