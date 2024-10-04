//-----------------------------------------------------
// Title: Main Class
// Author: Serdar Kemal Topkaya
// Description: This class takes inputs from text files as String matrix 
// and converts them to integer matrices. Using the methods created in the 
// LinkedList class, it outputs these matrices in a spiral way.
//-----------------------------------------------------

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	// --------------------------------------------------------
	// Summary: In this method, a String input from the user with the help of Scanner,
	// value is taken. By calling the matrixToDoubleArray and matrixToSpiralList methods, 
	// it provides an output corresponding to the input input.
	// --------------------------------------------------------
	{

		Scanner scanner = new Scanner(System.in);
		System.out.print("Input filename: ");
		String file = scanner.nextLine();

		int[][] matrix = matrixToDoubleArray(file); // We equate the value from the matrixToDoubleArray method to the matrix that we created ourselves.

		LinkedList list = new LinkedList();

		list.matrixToSpiralList(matrix);
		System.out.println(list); // outputs the (Spiral state) last state of the matrix.

	}

	public static int[][] matrixToDoubleArray(String file)
	// --------------------------------------------------------
	// Summary: It reads the file name taken as a parameter with the help of BufferedReader 
	// and assigns the read file to a String value. Then this converts, firstly, String to 
	// a String array, then this String array to an integer array, and finally an integer array 
	// to double integer array and returns this array.
	// Precondition: File is a String
	// --------------------------------------------------------
	{

		String stringForMatrix = ""; // value in the file will be assigned.
		String firstLine = ""; // It was created to find the required number of columns for the matrix.
		                       //(We will calculate the number of spaces between the values in the first row.)
		int[][] matrix = null;
		String[] stringArrayToMatrix = null;
		int countRow = 0; // number of rows of the matrix
		int countColumn = 0; // number of column of the matrix

		try {

			BufferedReader reader = new BufferedReader(new FileReader(file)); // read the txt file
			String line;

			while ((line = reader.readLine()) != null)
		    //It assigns the read text file to the String and calculates the number of rows required for the matrix.
			{
				stringForMatrix += line + " ";
				firstLine = line;
				countRow++;
			}

			for (int i = 0; i < firstLine.length(); i++)
				// Calculates the required number of columns for the matrix. (counting the number of spaces in the first row.)
			{

				if (firstLine.charAt(i) == ' ') {
					countColumn++;
				}
			}
			countColumn++;

			stringForMatrix = stringForMatrix.substring(0, stringForMatrix.length() - 1); // at the end of the inputted file  if there is a space, it deletes it.
			                                                                              

			stringArrayToMatrix = stringForMatrix.split(" ", (countColumn * countRow));// With the split method, we assign the values in the StringForMatrix to a String array.

			int[] intArrayToMatrix = new int[stringArrayToMatrix.length]; // We define the int array that will be converted to matrix (double array).

			for (int i = 0; i < stringArrayToMatrix.length; i++)
			// It converts the data of the string array into an integer and assigns it to the integer array.
			{

				intArrayToMatrix[i] = Integer.parseInt(stringArrayToMatrix[i]);
			}

			matrix = new int[countRow][countColumn]; // matrix where data will be assigned.
			int z = 0;
			for (int i = 0; i < countRow; i++)
			// assign the values in the int array to the matrix.
			{
				for (int k = 0; k < countColumn; k++) {
					matrix[i][k] = intArrayToMatrix[z];
					z++;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return matrix;

	}

}
