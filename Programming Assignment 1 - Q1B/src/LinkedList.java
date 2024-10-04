//-----------------------------------------------------
// Title: LinkedList class
// Author: Serdar Kemal Topkaya
// Description: In this class, we first convert the matrix, we take as a parameter, 
// into a LinkedList. We connect the elements in the LinkedList from the 
// right, left, up and down directions. Then we check whether the elements 
// in arr1, that we take as parameters, (the elements are taken from the matrix) 
// are connected to the elements in arr2. When checking this, we use the add, 
// isList1ContainsList2, contains and toString methods.
//-----------------------------------------------------
public class LinkedList {
	public static Node head;

	public LinkedList()
	// --------------------------------------------------------
	// Summary: The constructor of the LinkedList class. It sets the initial 
	// values of the necessary variables for this class.
	// Postcondition: The value of the head variable set as null
	// --------------------------------------------------------s
	{

		this.head = null;
	}

	public void add(Node n)
	// --------------------------------------------------------
	// Summary: Adding the n node, which is taken as a parameter, to LinkedList.
	// Precondition: n instance of an Node class
	// Postcondition: The value of the n variable set as new node
	// --------------------------------------------------------
	{

		if (head == null) {
			head = n;
		} else {

			Node curr = head;

			while (curr.next != null) {
				curr = curr.next;
			}

			curr.next = n;

		}

	}

	public static boolean isList1ContainsList2(int[][] matrix, LinkedList matrixToList, int[] arr1, int[] arr2)
	// --------------------------------------------------------
	// Summary: We convert the matrix taken as a parameter into a LinkedList and connect 
	// the elements (node) in it from the right, left, bottom and up directions, 
	// excluding the corners. Then, using the contains methods, we check whether the 
	// values of arr1 values taken from the matrix depend on the values of arr2 obtained 
	// from the matrix.
	// Precondition: matrix is double integer array, matrixToList is an instance of
	// a LinkedList class, arr1 and arr2 is an integer array.
	// --------------------------------------------------------
	{

		// While checking the connection between the corner coordinates of the matrix, 
		// the elements in arr1 and arr2, we will not need to check the corners, 
		// so we find which values should not be looked at.
		int edge1 = matrix[0][0];  // first row first index
		int edge2 = matrix[matrix.length - 1][0]; // last row first index
		int edge3 = matrix[matrix.length - 1][matrix[0].length - 1]; // last row last index
		int edge4 = matrix[0][matrix[0].length - 1]; // first row last index

		
		for (int i = 0; i < matrix.length; i++) 
			// It converts the matrix into a Linked List and connects its elements to each other from the right or left or top or bottom.
		{

			for (int k = 0; k < matrix[0].length; k++) {

				Node n = new Node(matrix[i][k]); // converting the matrix to a LinkedList.
				matrixToList.add(n); 

				if (i == 0 && k > 0 && k < matrix[0].length - 1) 
					//It connects the elements in the first row of the matrix to the elements in a lower row.
					// (except the corners).
				{ 

					n.down = new Node(matrix[i + 1][k]);
					continue;

				}

				else if (i > 0 && i < matrix.length - 1 && k > 0 && k < matrix[0].length - 1)
					//It connects the elements in the middle of the matrix to the elements up, down, left and right.
					// (except the first row, last row, first column, last column)
				{

					

					n.right = new Node(matrix[i][k + 1]);
					n.left = new Node(matrix[i][k - 1]);
					n.down = new Node(matrix[i + 1][k]);
					n.up = new Node(matrix[i - 1][k]);
					continue;
				}

				else if (i == matrix.length - 1 && k > 0 && k < matrix[0].length - 1) 
					// It connects the elements in the last row of the matrix to the elements above it.
					//(except the corners).
				{

					n.up = new Node(matrix[i - 1][k]);
					continue;
				}

				else if (i > 0 && i < matrix.length - 1 && k == 0) 
					// connects the elements in the first column of the matrix to the elements on the right.
					//(except the corners).
				{

				
					n.right = new Node(matrix[i][k + 1]);

					continue;
				}

				else if (i > 0 && i < matrix.length - 1 && k == matrix.length) 
					// It connects the elements in the last column of the matrix to the elements in the previous column.
					//(except the corners).
				{

					
					n.left = new Node(matrix[i][k - 1]);

					continue;

				}

			}

		}

		
		
		// This part is where the boolean values to be returned are assigned if the elements of arr1 are connected with arr2.
		boolean result = false;
		Node curr = matrixToList.head;
		boolean a = false;
		boolean c = false;
		boolean d = false;
		boolean e = false;

		while (curr != null) { 

			for (int i = 0; i < arr1.length; i++) 
				// With the help of matrix, we find whether the elements in arr1 are connected to the elements in arr2.
			{

				if (arr1[i] == edge1 || arr1[i] == edge2 || arr1[i] == edge3 || arr1[i] == edge4) 
					// Since it doesn't matter if the corner points are connected, the loop switches to the other loop when it comes to these points.
				{

					continue;

				} else if (matrixToList.containsData(arr1[i]))
					// It checks whether the arr1[i] element exists in the matrix.
				{ 

					curr = matrixToList.containsGiveNode(arr1[i]); // After finding the existing element in the matrix, 
					                                               // it returns the current node of that element to find out 
					                                               // whether it is connected or not.

					if (containsUp(matrix, arr1[i]))
						//  When the element of arr1 is in the first row of the matrix.
					{ 

						if (curr.down.data == arr2[0] || curr.down.data == arr2[1] || curr.down.data == arr2[2]
								|| curr.down.data == arr2[3]) 
							//  It checks whether the element of arr1 is connected to the element of arr2.
						{
							a = true;

							continue;

						}

					}

					else if (containsDown(matrix, arr1[i]))
						// When the element of arr1 is in the last row of the matrix.
					{ 

						if (curr.up.data == arr2[0] || curr.up.data == arr2[1] || curr.up.data == arr2[2]
								|| curr.up.data == arr2[3]) 
							//  It checks whether the element of arr1 is connected to the element of arr2.
						{
							c = true;

							continue;
						}

					}

					else if (containsLeft(matrix, arr1[i]))
						// When the element of arr1 is in the first column of the matrix.
					{ 

						if (curr.right.data == arr2[0]) 
							// It checks whether the element of arr1 is connected to the element of arr2.
						{
							d = true;

							continue;
						}
					} else if (containsRight(matrix, arr1[i]))
						// When the element of arr1 is in the last column of the matrix.
					{ 

						if (curr.left.data == arr2[1]) 
							// It checks whether the element of arr1 is connected to the element of arr2.
						{
							e = true;

							continue;
						}
					}

				}

			}

			curr = curr.next;

			if (a == true && c == true && d == true && e == true) 
				// result true if all required elements are connected.
			{
				result = true;

				break;
			} else {
				result = false;

				break;

			}
		}

		return result;

	}

	public static boolean containsLeft(int[][] matrix, int data) {
		// --------------------------------------------------------
		// Summary: This method checks if the data value is in the first column of the matrix.
		// Precondition: matrix is double array, data is an integer
		// --------------------------------------------------------
		int k = 0;
		for (int i = 1; i < matrix.length - 1; i++) {

			if (data == matrix[i][k]) {
				return true;
			}

		}
		return false;

	}

	public static boolean containsRight(int[][] matrix, int data) {
		// --------------------------------------------------------
		// Summary: This method checks if the data value is in the last column of the matrix.
		// Precondition: matrix is double array, data is an integer
		// --------------------------------------------------------
		int k = matrix[0].length - 1;
		for (int i = 1; i < matrix.length - 1; i++) {

			if (data == matrix[i][k]) {
				return true;
			}

		}
		return false;

	}

	public static boolean containsUp(int[][] matrix, int data) {
		// --------------------------------------------------------
		// Summary: This method checks if the data value is in the first row of the matrix.
		// Precondition: matrix is double array, data is an integer
		// --------------------------------------------------------
		int k = 0;
		for (int i = 1; i < matrix[0].length - 1; i++) {

			if (data == matrix[k][i]) {
				return true;
			}

		}
		return false;

	}

	public static boolean containsDown(int[][] matrix, int data) {
		// --------------------------------------------------------
		// Summary:This method checks if the data value is in the last row of the matrix.
		// Precondition: matrix is double array, data is an integer
		// --------------------------------------------------------
		int k = matrix.length - 1;
		for (int i = 1; i < matrix[0].length - 1; i++) {

			if (data == matrix[k][i]) {
				return true;
			}

		}
		return false;

	}

	public Node containsGiveNode(int data) {
		// --------------------------------------------------------
		// Summary: In this method, it finds the node in the matrix corresponding 
		// to the data value and returns it so that we can use this node.
		// Precondition: data is an integer
		// --------------------------------------------------------
		Node curr = this.head;

		while (curr != null) {

			if (curr.data == data) {
				return curr;

			}

			curr = curr.next;
		}

		return null;

	}

	public boolean containsData(int data) {
		// --------------------------------------------------------
		// Summary: In this method, it checks whether the data value is in the matrix or not.
		// Precondition: data is an integer
		// --------------------------------------------------------
		Node curr = this.head;

		while (curr != null) {

			if (curr.data == data) {
				return true;

			}

			curr = curr.next;
		}

		return false;

	}

	@Override
	public String toString()
	// --------------------------------------------------------
	// Summary: This method creates any LinkedList created in the specified format.
	// (Exp. { , , , ,})
	// --------------------------------------------------------
	{

		String result = "{";

		Node curr = head;

		while (curr != null) {

			result += curr.data + ", ";
			curr = curr.next;

		}

		result = result.substring(0, result.length() - 2);

		result += "}";
		return result;

	}

}
