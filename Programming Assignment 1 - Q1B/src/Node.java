//-----------------------------------------------------
// Title: Node class
// Author: Serdar Kemal Topkaya
// ID: 71200082370
// Section: 3
// Assignment: 1
// Description: This class creates the elements required for LinkedList as Node. 
// These Nodes will have their own data value, next, right, left, up, down, value. 
// The data required for the node elements are created and their initial values are set.
//-----------------------------------------------------
public class Node {

	public Node next; // Node pointers that points (represents) the right value of a node in the database.
	public int data; // data value that represents the integer values of nodes in the database.

	public Node right; // Node pointers that points (represents) the right value of a node in the matrix(double array).
	public Node left;// Node pointers that points (represents) the left value of a node in the matrix(double array).
	public Node up;// Node pointers that points (represents) the up value of a node in the matrix(double array).
	public Node down;// Node pointers that points (represents) the down value of a node in the matrix(double array).

	public Node(int data)
	// --------------------------------------------------------
	// Summary:Assigns a value to the variables whose
	// names are given.
	// Precondition: data is an integer value
	// Postcondition: The value of data variable is set and the
	// next, right, left, up, down variables set as null
	// --------------------------------------------------------
	{

		this.data = data;
		this.next = null;

		right = left = up = down = null;
	}
}
