// Title: Main class
// Author: Serdar Kemal Topkaya
// Description: This class takes bitcoin values from text files as String values 
// and converts them to integer values. By calling the methods in the Queue class, 
// it outputs the required bitcoin values and the range of these values.
//-----------------------------------------------------

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// --------------------------------------------------------
		// Summary: In this method, a String input value is taken from the user 
		// with the help of Scanner. It creates an output by calling the stringToArray, 
		// arrayToQueue, and valueOfRange methods.
		// --------------------------------------------------------

		System.out.print("Input filename: ");
		Scanner scan = new Scanner(System.in);

		String file = scan.nextLine(); // String value that will be read from the console

		int[] array = stringToArray(file);// In order to use the file converted to an int array, we assign it to a new array.

		Queue queue = new Queue(); // instance of Queue class

		queue.arrayToQueue(array); // It puts the final bitcoin values into a queue.

		Queue.RangeOfBitcoinValues(queue); // It outputs bitcoin values and the value of range of these values.

	}

	public static int[] stringToArray(String file)
	// --------------------------------------------------------
	// Summary: It reads the file name taken as a parameter with the help of BufferedReade
	// and assigns the read file to a String value. Then it assigns this String to a 
	// String array and then the String array to an integer array.
	// Precondition: File is a String
	// --------------------------------------------------------
	{

		String stringToArray = null; // String to which the text file will be assigned.
		int spaceCount = 0; // To find how many values are in the text file, I calculate the spaces between the values.

		try {

			BufferedReader reader = new BufferedReader(new FileReader(file)); // read the txt file

			stringToArray = reader.readLine(); // Since the txt file is one line, it reads the first line and assigns it to the String.
			if (stringToArray.charAt(stringToArray.length() - 1) == ' ')
			// If there is a space at the end of the String from the txt file, it deletes. (To avoid errors when separating values.)
			{

				stringToArray = stringToArray.substring(0, stringToArray.length() - 1);
			}

			spaceCount = 0;
			for (int i = 0; i < stringToArray.length(); i++) {

				if (stringToArray.charAt(i) == ' ')
				// Calculating number of spaces between two values in stringToArray
				{
					spaceCount++;
				}

			}

			reader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] stringArray = stringToArray.split(" ", spaceCount + 1);// With the help of the split method, it separates the values 
		                                                                //in the stringToArray from spaces and assigns it to a String array.

		int[] intArray = new int[stringArray.length]; // Integer array to which the string array will be assigned.

		for (int i = 0; i < stringArray.length; i++)
		// Converts the elements of the string array to int values and assigns them to the int array.
		{

			intArray[i] = Integer.parseInt(stringArray[i]);

		}

		return intArray;
	}

}
