/**
 * Lead Author(s):
 * 
 * @author Katie Wingert
 *
 *         Other Contributors:
 *         Chris Wingert, chris@wingert.org
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 *
 *         Version: 2026-04-06
 */

/**
 * Purpose: The responsibility of Extroverted is to define the behavior of
 * extroverted cats.
 *
 * Extroverted is-a SocialLevel
 */
public class Extroverted implements SocialLevel
{
	/**
	 * Purpose: increase cat happiness based on pet effect.
	 */
	public int petEffect()
	{
		// extroverted cats need more pets to be happy
		return 5;
	}

	/**
	 * Purpose: toString method used to check cats SocialLevel.
	 * 
	 * @return extroverted for extroverted cats
	 */
	@Override
	public String toString()
	{
		return "Extroverted";
	}
}
