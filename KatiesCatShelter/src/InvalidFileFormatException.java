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
 *         <<Add more references here>>
 *         “UserDefined Custom Exception in Java.” GeeksforGeeks, 24 Apr. 2026,
 *         www.geeksforgeeks.org/java/user-defined-custom-exception-in-java/.
 *
 *         Version: 2026-04-14
 */

/**
 * Purpose: The responsibility of InvalidFileFormatException is to represent an
 * error that occurs when a file does not match the expected format.
 *
 * InvalidFileFormatException is-a exception
 */
public class InvalidFileFormatException extends Exception
{
	public InvalidFileFormatException(String message)
	{
		super(message);
	}
}
