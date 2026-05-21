import java.util.ArrayList;

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
 * Purpose: The responsibility of Main is to read the cat file and start the
 * game
 */

public class Main
{

	public static void main(String[] args)
	{
		AdoptionManager manager = new AdoptionManager();
		CatFileReader reader = new CatFileReader();
		try
		{
			reader.readCatFile("CatInfo.txt", manager);
			new ShelterGUI(manager);
		}
		catch (InvalidFileFormatException e)
		{
			System.out.print("File format error: " + e.getMessage());
		}
	}
}
