import java.util.*;
import java.io.*;
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
 * Purpose: The reponsibility of CatFileReader is ...
 *
 * CatFileReader is-a ...
 * CatFileReader is ...
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CatFileReader
{
	private String filePath;
	
	public CatFileReader() {}
	
	//there is an expected file format which is to be included in this project
	//invalid file format is when file format is not correct

	public void readCatFile(String filePath, AdoptionManager manager) throws InvalidFileFormatException {
		Scanner scan = null;
		String name;
		int age;
		SocialLevel socialLevel;
		String pictureFilePath;
		String catSize;
		String level;
		try {
			File file = new File(filePath);
			scan = new Scanner(file);
			for (int i = 0; i < 12; i++) {
				Cat cat;
				if (!scan.next().equals("Name:"))
				{
					throw new InvalidFileFormatException();
				}
				
				name = scan.next();
				
				if (!scan.next().equals("Age:")) {
					throw new InvalidFileFormatException();
				}
				
				age = scan.nextInt();
				
				if (!scan.next().equals("SocialLevel:")) {
					throw new InvalidFileFormatException();
				}
				
				level = scan.next();
				
				if (!scan.next().equals("Filepath:")) {
					throw new InvalidFileFormatException();
				}
				
				pictureFilePath = scan.next();
				
				if (!scan.next().equals("Size:")) {
					throw new InvalidFileFormatException();
				}
				
				catSize = scan.next();
				
				if (level.equals("Introverted")) {
					socialLevel = new Introverted();
				}
				else if (level.equals("Extroverted")) {
					socialLevel = new Extroverted();
				}
				else {
					throw new InvalidFileFormatException();
				}
				
				if (catSize.equals("Big")) {
					cat = new BigCat(name, age, socialLevel, pictureFilePath);
				}
				else if (catSize.equals("Small")) {
					cat = new SmallCat(name, age, socialLevel, pictureFilePath);
				}
				else {
					throw new InvalidFileFormatException();
				}
				cat = new BigCat(name, age, socialLevel, pictureFilePath);
				
				manager.addCat(cat);
			}
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if (scan != null) {
				scan.close();
			}
		}
	}
	
}
