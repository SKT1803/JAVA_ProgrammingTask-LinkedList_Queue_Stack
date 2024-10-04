
//-----------------------------------------------------
// Title: Node Class
// Author: Serdar Kemal Topkaya
// ID: 71200082370
// Section: 3
// Assignment: 1
// Description: This class creates the elements required for LinkedList as Node. 
// These nodes will have their own data value and next value. The data required for 
// the node elements are created and their initial values are set.
//-----------------------------------------------------
public class Node {

	public int data; // data value that represents the integer values of nodes in the database
	public Node next; // Node pointers that points (represents) the right value of a node in the database
					

	public Node(int data)
	// --------------------------------------------------------
	// Summary: Assigns a value to the variables whose
	// names are given.
	// Precondition: Data is an integer
	// Postcondition: The value of data variable is set and the next variable set as null
	// --------------------------------------------------------
	{

		this.data = data;
		this.next = null;
	}
}
