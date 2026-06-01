import java.util.ArrayList;

/**
 * Lead Author(s):
 * 
 * @author Katie Wingert
 *
 *         Other Contributors:
 *         Chris Wingert chris@wingert.org
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
 * Purpose: The responsibility of AdoptionManager is to store the lists of
 * adoptable and adopted cats and to manage all adoptions and unadoptions of
 * cats.
 */
public class AdoptionManager
{
	// AdoptionManager has-many unadoptedCats
	private ArrayList<Cat> unadoptedCats = new ArrayList<>();
	// AdoptionManager has-many adoptedCats
	private ArrayList<Cat> adoptedCats = new ArrayList<>();

	/**
	 * Purpose: Constructor for adoption manager
	 */
	public AdoptionManager()
	{
	}

	/**
	 * Purpose: Add a cat to the cat shelter
	 * 
	 * @param cat to add to shelter
	 */
	public void addCat(Cat cat)
	{
		unadoptedCats.add(cat);
	}

	/**
	 * Purpose: Remove a cat from the cat shelter
	 * 
	 * @param cat that was adopted
	 */
	public void adoptCat(Cat cat)
	{
		adoptedCats.add(cat);
		unadoptedCats.remove(cat);
		// set the adoption status of the cat object
		cat.adopt();
	}

	/**
	 * Purpose: Add a cat back to the cat shelter
	 * 
	 * @param cat that was unadopted
	 */
	public void unadoptCat(Cat cat)
	{
		adoptedCats.remove(cat);
		addCat(cat);
		// set the adoption status of the cat object
		cat.unadopt();
	}

	/**
	 * Purpose: Getter for list of unadopted cats
	 * 
	 * @Return array of unadopted cats
	 */
	public ArrayList<Cat> getUnadoptedCats()
	{
		return unadoptedCats;
	}

	/**
	 * Purpose: Getter for list of adopted cats
	 * 
	 * @Return array of adopted cats
	 */
	public ArrayList<Cat> getAdoptedCats()
	{
		return adoptedCats;
	}
}
