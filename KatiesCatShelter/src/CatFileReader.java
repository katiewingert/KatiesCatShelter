import java.io.*;
import java.io.File;
import java.util.Scanner;
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
 * Purpose: The reponsibility of CatFileReader is to read cat files, verify they
 * adhere to the expected file format, and save cat information as cat objects.
 */

public class CatFileReader
{
	/**
	 * Purpose: Default constructor for CatFileReader
	 */
	public CatFileReader()
	{
	}

	/**
	 * Purpose: Method to call to read a cat file
	 * 
	 * @param filePath        of file to be read
	 * @param AdoptionManager to send cat objects to
	 * @throws InvalidFileFormatException if file does not match expected format
	 */
	public void readCatFile(String filePath, AdoptionManager manager)
			throws InvalidFileFormatException
	{

		Scanner scan = null;
		String name;
		int age;
		SocialLevel socialLevel;
		String pictureFilePath;
		String catSize;
		String level;
		String tempString;
		int currLineNumber = 0;

		try
		{
			File file = new File(filePath);
			scan = new Scanner(file);

			// there cannot be more than 12 cats in the shelter
			for (int i = 0; i < 12; i++)
			{
				Cat cat;

				currLineNumber++;
				tempString = scan.next();
				if (!tempString.equals("Name:"))
				{

					throw new InvalidFileFormatException(
							"Expected \"Name:\" but recieved \"" + tempString
									+ "\" on line " + currLineNumber);
				}

				name = scan.next();

				currLineNumber++;
				tempString = scan.next();
				if (!tempString.equals("Age:"))
				{
					throw new InvalidFileFormatException(
							"Expected \"Age:\" but recieved \"" + tempString
									+ "\" on line " + currLineNumber);
				}

				age = scan.nextInt();

				currLineNumber++;
				tempString = scan.next();
				if (!tempString.equals("SocialLevel:"))
				{
					throw new InvalidFileFormatException(
							"Expected \"SocialLevel:\" but recieved \""
									+ tempString + "\" on line "
									+ currLineNumber);
				}

				level = scan.next();

				currLineNumber++;
				tempString = scan.next();
				if (!tempString.equals("Filepath:"))
				{
					throw new InvalidFileFormatException(
							"Expected \"Filepath:\" but recieved \""
									+ tempString + "\" on line "
									+ currLineNumber);
				}

				pictureFilePath = scan.next();

				currLineNumber++;
				tempString = scan.next();
				if (!tempString.equals("Size:"))
				{
					throw new InvalidFileFormatException(
							"Expected \"Size:\" but recieved \"" + tempString
									+ "\" on line " + currLineNumber);
				}

				catSize = scan.next();

				// set cat as introverted if introverted
				if (level.equals("Introverted"))
				{
					socialLevel = new Introverted();
				}

				// set cat as extroverted if extroverted
				else if (level.equals("Extroverted"))
				{
					socialLevel = new Extroverted();
				}
				else
				{
					throw new InvalidFileFormatException("SocialLevel for "
							+ name
							+ " must be \"Introverted\" or \"Extroverted\"");
				}

				// if cat is big, create a new BigCat object
				if (catSize.equals("Big"))
				{
					cat = new BigCat(name, age, socialLevel, pictureFilePath);
				}

				// if cat is small, create a new SmallCat object
				else if (catSize.equals("Small"))
				{
					cat = new SmallCat(name, age, socialLevel, pictureFilePath);
				}
				else
				{
					throw new InvalidFileFormatException("Size for " + name
							+ " must be \"Big\" or \"Small\"");
				}

				manager.addCat(cat);
			}

		}

		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		finally
		{
			if (scan != null)
			{
				scan.close();
			}
		}
	}

}
