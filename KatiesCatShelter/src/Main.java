import java.util.ArrayList;
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
 * Purpose: The reponsibility of Main is ...
 *
 * Main is-a ...
 * Main is ...
 */
public class Main
{
	
	public static void main(String[] args) {
		AdoptionManager manager = new AdoptionManager();
		CatFileReader reader = new CatFileReader();
		try
		{
			reader.readCatFile("CatInfo.txt", manager);
		}
		catch (InvalidFileFormatException e)
		{
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		new ShelterGUI(manager);
	}
}
