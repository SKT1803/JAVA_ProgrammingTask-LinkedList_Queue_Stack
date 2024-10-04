
//-----------------------------------------------------
// Title: LinkedList class
// Description: In this class, a matrix taken as a parameter is translated and displayed 
// in a spiral format LinkedList with the help of add, matrixToSpiralList and toString methods.
//-----------------------------------------------------
public class LinkedList {

	public Node head;

	public LinkedList()
	// --------------------------------------------------------
	// Summary: The constructor of the LinkedList class. It sets the 
	// initial values of the necessary variables for this class.
	// Postcondition: The value of the head variable set as null
	// --------------------------------------------------------
	{

		this.head = null;
	}

	public void add(int data)
	// --------------------------------------------------------
	// Summary: It creates a new Node with data values taken as parameters. 
	// Then it adds this Node to LinkedList.
	// Precondition: Data is an integer value
	// Postcondition: The value of the data variable set as Node's data
	// --------------------------------------------------------
	{

		Node n = new Node(data);

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

	public void matrixToSpiralList(int[][] matrix)
	// --------------------------------------------------------
	// Summary: In order to convert the matrix, that taken as a parameter, 
	// into a LinkedList in the desired spiral direction (down -> right -> up -> left), 
	// it finds the necessary values and adds the values taken from the matrix to the 
	// LinkedList spirally using the add method. The spiral ends  when it sees as -1 
	// in the values in the structure.                                          
	// Precondition: Matrix is double integer array
	// --------------------------------------------------------
	{

		int firstRowIndex = 0; // start index of spiral direction.
		int lastRowIndex = matrix.length - 1; // The index at which the curl will occur in the spiral direction.
		int firstColumnIndex = 0; // The index at which the curl will occur in the spiral direction.
		int lastColumnIndex = matrix[0].length - 1; // The index at which the curl will occur in the spiral direction.

		while (firstRowIndex <= lastRowIndex && firstColumnIndex <= lastColumnIndex) {

			for (int i = firstRowIndex; i <= lastRowIndex; i++) 
				// --------------------------------------------------------
				// Summary: The values from the lower curl to the 
				// upper curl are assigned to the LinkedList.
				// --------------------------------------------------------
		    	{

				if (matrix[i][firstColumnIndex] == -1) {
					return;
				}

				add(matrix[i][firstColumnIndex]);
			}

			firstColumnIndex++;

			for (int i = firstColumnIndex; i <= lastColumnIndex; i++) 
				// --------------------------------------------------------
				// Summary: The values from the left curl to the 
				// right curl are assigned to the LinkedList.
				// --------------------------------------------------------
			{
				if (matrix[lastRowIndex][i] == -1) {
					return;
				}

				add(matrix[lastRowIndex][i]);
			}

			lastRowIndex--;

			for (int i = lastRowIndex; i >= firstRowIndex; i--) 
				// --------------------------------------------------------
				// Summary: The values from the up curl to the 
				// down curl are assigned to the LinkedList.
				// --------------------------------------------------------
			{

				if (matrix[i][lastColumnIndex] == -1) {
					return;
				}
				add(matrix[i][lastColumnIndex]);
			}

			lastColumnIndex--;

			for (int i = lastColumnIndex; i >= firstColumnIndex; i--)
				// --------------------------------------------------------
				// Summary: The values from the right curl to the 
				// left curl are assigned to the LinkedList.
				// --------------------------------------------------------
			{

				if (matrix[firstRowIndex][i] == -1) {
					return;
				}
				add(matrix[firstRowIndex][i]);
			}

			firstRowIndex++;

		}

	}

	@Override
	public String toString()
	// --------------------------------------------------------
	// Summary: This method creates any LinkedList created in the specified format.
	// (Exp. [ , , , ,])
	// --------------------------------------------------------
	{

		String result = "[";

		Node curr = head;

		while (curr != null) {
			result += curr.data + ", ";
			curr = curr.next;
		}
		if (result.length() >= 2) { // checks if there is at least one element in the list.
			result = result.substring(0, result.length() - 2);
		} else if (result.length() == 1) { // to leave the output blank when there is no element in our list.
			return "";
		}

		result += "]";
		return result;

	}
}
