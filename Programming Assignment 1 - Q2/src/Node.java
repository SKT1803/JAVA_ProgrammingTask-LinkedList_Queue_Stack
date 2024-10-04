//-----------------------------------------------------
// Title: Node class
// Author: Serdar Kemal Topkaya1
// Description: This class creates the elements required for the List as Node. 
// These nodes represent bitcoin values. These Nodes will have their own data value,
// next value and value value. The data required for the node elements are created and 
// their initial values are set.
//-----------------------------------------------------
public class Node {

	public Node next;// Node pointers that points (represents) the right value of a node in the database.
	public int data; // data value that represents the bitcoin values of nodes in the database.
	public int rangeOfBitcoinValue; // data value that represents the range of bitcoin values of nodes in the database.

	public Node(int data)
	// --------------------------------------------------------
	// Summary: Assigns a value to the variables whose.
	// Precondition: Data is an Integer
	// Postcondition: The value of data variable is set, the next variable set as
	// null and rangeOfBitcoinValue set zero.
	// --------------------------------------------------------
	{

		this.next = null;
		this.data = data;
		this.rangeOfBitcoinValue = 0;

	}

	@Override
	public String toString()
	// --------------------------------------------------------
	// Summary: It allows us to assign the range of bitcoin values of the nodes to any String.
	// --------------------------------------------------------
	{

		return "" + rangeOfBitcoinValue;
	}

}
