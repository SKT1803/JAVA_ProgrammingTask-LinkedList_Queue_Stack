
//-----------------------------------------------------
// Title: Main class
// Author: Serdar Kemal Topkaya
// ID: 71200082370
// Section: 3
// Assignment: 1
// Description: This class reads 3 file files consisting of the matrix 
// and 2 of the indexes of this matrix, and assigns the received string 
// matrix to an integer matrix with the matrixToDoubleArray method, and 
// assigns the imported index files to the integer array with the indexToArray method. 
// Using the methods created in the LinkedList class, it gives the output showing 
// whether the matrix values corresponding to these index values are related to each other.
//-----------------------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	// --------------------------------------------------------
	// Summary: In this method, three string values, matrix list1 (matrix's indexes) 
	// and list2 (matrix's indexes), are taken from the user with the help of Scanner.
	// Using the matrixToDoubleArray, indexToArray and isList1ContainsList2 methods, 
	// it outputs a boolean value that tells whether the values corresponding to these 
	// indexes given from the matrix are connected to each other. It uses the
	// isList1ContainsList2 method to generate an output corresponding to the input.
	// --------------------------------------------------------
	{

		Scanner scanner = new Scanner(System.in);

		System.out.print("Input filename: ");
		String file = scanner.nextLine(); // Filename written as input is kept.
	    file = file.substring(1, file.length()-1); //If the input is taken as "", it removes the "" sign from the input.

		System.out.print("Input filename: ");
		String list1 = scanner.nextLine();
		list1 = list1.substring(1, list1.length()-1);

		System.out.print("Input filename: ");
		String list2 = scanner.nextLine();
		list2 = list2.substring(1, list2.length()-1);

		int[][] matrix = matrixToDoubleArray(file); // method that converts the matrix received as a string to a double array and assign the new converted matrix.

		int[] arr1 = indexToArray(matrix, list1); // the method that assigns the values corresponding to the matrix indexes received 
		                                          //as strings to the array and assign the returned array to a new array. 
		

		int[] arr2 = indexToArray(matrix, list2);

		LinkedList matrixToList = new LinkedList();
		System.out.println(LinkedList.isList1ContainsList2(matrix, matrixToList, arr1, arr2));
		// Output that tells whether the values corresponding to these indexes given from the matrix are connected or not.
	}

	public static int[] indexToArray(int[][] matrix, String file)
	// --------------------------------------------------------
	// Summary:It reads the file taken as a parameter with the help of BufferedReader,
	// finds the elements corresponding to the matrix indexes in this file using the 
	// matrix taken as a parameter, and assigns these values to a String array first 
	// and then to an integer array.
	// Precondition: matrix is an integer double array, file is a String
	// --------------------------------------------------------
	{

		String fileToStringArray = null; // String, to assigns the values in the file.
		int[] array = null; // The int array where the values in the string array will be assigned.

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file)); // read the txt file.

			fileToStringArray = reader.readLine();

			int count = 0;
			for (int i = 0; i < fileToStringArray.length(); i++)
			// It calculates the number of "-" signs between each index in order to split the indexes in the string file.
			{

				if (fileToStringArray.charAt(i) == '-') {
					count++;
				}

			}

			String[] stringArrayToIntArray = fileToStringArray.split("-", count + 1); // Using the split method, we separate the indexes in the file from the "-" sign 
			                                                                          //and assign each index to the String array.

			array = new int[count + 1];

			int k = 0;

			for (String s : stringArrayToIntArray)
			//------------------------------------------------------------------------
			// Summary: In order to find the values corresponding to the indexes in the matrix, 
			// we separate each index within itself. (Exp. index(1,2) --> 1.row 2. column).
			// After we find the values corresponding to the indexes, we assign these values to the int array.	
			//------------------------------------------------------------------------	
			{

				int num1 = Integer.parseInt(s.substring(0, s.indexOf(","))); // row part of the index
				int num2 = Integer.parseInt(s.substring((s.indexOf(",") + 1), s.length())); // column part of the index

				array[k] = matrix[num1][num2];

				k++;

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return array;

	}

	public static int[][] matrixToDoubleArray(String file)
	// --------------------------------------------------------
	// Summary: It reads the file name taken as a parameter with the help of 
	// the BufferedReader and assigns it to a String value. The last 
	// String matrix is first assigned to the String array, then to the integer array, 
	// and finally to the double integer array after finding the required row and 
	// column numbers for the matrix. It returns the matrix converted to double call.
	// Precondition: file is a String
	// --------------------------------------------------------
	{

		String stringMatrix = ""; // String, where we will keep the matrix in the file.
		String firstLine = ""; // String, to use to calculate the number of columns of the matrix.

		int[][] matrix = null; // The required matrix that we will return.
		String[] stringArrayToMatrix = null; // String array where we will keep the elements of the matrix in the file.
		int countRow = 0; // number of rows of the matrix.
		int countColumn = 0; // number of columns of the matrix

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file)); // read the txt file

			String line;

			while ((line = reader.readLine()) != null)
			// // assigns the read text file to the String, calculates the number of rows required for the matrix.
			{

				stringMatrix += line + " ";
				firstLine = line;

				countRow++;
			}

			for (int i = 0; i < firstLine.length(); i++)
			//Calculates the required number of columns for the matrix. (counting the number of spaces in the first row.)
			{

				if (firstLine.charAt(i) == ' ') {

					countColumn++;
				}
			}
			countColumn++;

			stringMatrix = stringMatrix.substring(0, stringMatrix.length() - 1);//If there is a space at the end of the imported file, it deletes.

			stringArrayToMatrix = stringMatrix.split(" ", (countColumn * countRow));// With the split method, we assign the values in the StringForMatrix to a String array.
			int[] intArrayToMatrix = new int[stringArrayToMatrix.length];// Define the int array to be converted to matrix (double array).

			for (int i = 0; i < stringArrayToMatrix.length; i++)
			// It converts the data of the string array into an integer and assigns it to the integer array.
			{

				intArrayToMatrix[i] = Integer.parseInt(stringArrayToMatrix[i]);

			}

			matrix = new int[countRow][countColumn];// matrix where data will be assigned.

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
