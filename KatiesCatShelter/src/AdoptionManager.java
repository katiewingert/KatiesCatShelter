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

import java.util.ArrayList;

/**
 * Purpose: The reponsibility of AdoptionManager is ...
 *
 * AdoptionManager is-a ...
 * AdoptionManager is ...
 */
public class AdoptionManager
{
	//AdoptionManager has-many unadoptedCats 
	private ArrayList<Cat> unadoptedCats = new ArrayList<>();
	//AdoptionManager has-many adoptedCats 
	private ArrayList<Cat> adoptedCats = new ArrayList<>();
	
	/**
	 * Purpose: Constructor for adoption manager
	 */
	//TODO - make constructor?
	public AdoptionManager() {}
	
	/**
	 * Purpose: Add a cat to the cat shelter
	 * @param cat to add to shelter
	 */
	public void addCat(Cat cat) {
		unadoptedCats.add(cat);
	}
	
	/**
	 * Purpose: Remove a cat from the cat shelter
	 * @param cat that was adopted
	 */
	public void adoptCat(Cat cat) {
		adoptedCats.add(cat);
		unadoptedCats.remove(cat);
		cat.adopt();
	}
	
	/**
	 * Purpose: Add a cat back to the cat shelter
	 * @param cat that was unadopted
	 */
	public void unadoptCat(Cat cat) {
		adoptedCats.remove(cat);
		addCat(cat);
		cat.unadopt();
	}
	
	/**
	 * Purpose: Getter for list of unadopted cats
	 * @Return array of unadopted cats
	 */
	public ArrayList<Cat> getUnadoptedCats() {
		return unadoptedCats;
	}
	
	/**
	 * Purpose: Getter for list of adopted cats
	 * @Return array of adopted cats
	 */
	public ArrayList<Cat> getAdoptedCats() {
		return adoptedCats;
	}
}
