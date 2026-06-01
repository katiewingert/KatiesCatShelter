/**
 * Lead Author(s):
 * 
 * @author Katie Wingert
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
 * Purpose: The responsibility of BigCat is to represent a large cat with
 * feeding behavior specific to big cats.
 *
 * BigCat is-a Cat
 */
public class BigCat extends Cat
{
	/**
	 * Purpose: Default constructor for BigCat
	 */
	public BigCat()
	{
	}

	/**
	 * Purpose: Constructor for BigCat
	 * 
	 * @param name        of cat
	 * @param age         of cat
	 * @param socialLevel of cat
	 * @param file        path of cat photo
	 */
	public BigCat(String name, int age, SocialLevel level, String filePath)
	{
		// call the Cat constructor
		super(name, age, level, filePath);
	}

	/**
	 * Purpose: Increase happiness of cat because of being fed
	 */
	@Override
	public void feed()
	{
		// the same portion of food increases happiness less for a big cat
		this.increaseHappiness(5);
	}

	/**
	 * Purpose: Get size of cat
	 * 
	 * @return size of cat
	 */
	@Override
	public String getSize()
	{
		return "Big";
	}
}
