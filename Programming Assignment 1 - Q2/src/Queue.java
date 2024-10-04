//-----------------------------------------------------
// Title: Node class
// Author: Serdar Kemal Topkaya
// ID: 71200082370
// Section: 3
// Assignment: 1
// Description: In this class, an integer array whose elements are bitcoin values,
// which is taken as a parameter, turns this array into a queue with the help of 
// enqueue, arrayToQueue, valueOfRange, toString, valueToString methods and then 
// calculates the range of these bitcoin values. It creates the Bitcon values and 
// the ranges of these values in the desired format and outputs them in the valueOfRange method.
//-----------------------------------------------------
public class Queue {

	public static Node front, rear;
	public int size; // Queue'nun size'ı

	public Queue()
	// --------------------------------------------------------
	// Summary:Queue class in constructor It sets the initial values of the necessary 
	// variables for this class.
	// Postcondition: The value of the front and rear variable set as null, size set
	// zero.
	// --------------------------------------------------------
	{

		front = rear = null;
		size = 0;
	}

	public void enqueue(int data)
	// --------------------------------------------------------
	// Summary: It takes the data value taken as a parameter and creates 
	// a new Node with this data value. It adds these created nodes to the Queue.
	// Precondition: data is an integer
	// Postcondition: The value of the data set as new data of node
	// --------------------------------------------------------
	{

		Node n = new Node(data); // new Node that created and assigned data

		if (front == null) {
			front = rear = n;
			size++;
		} else {

			rear.next = n;
			rear = n;
			size++;

		}

	}

	public void arrayToQueue(int[] arr)
	// --------------------------------------------------------
	// Summary: It assigns the elements of the integer array, that is taken as a parameter, to a 
	// Queue and converts the array to this Queue.
	// Precondition: arr is an integer array.
	// --------------------------------------------------------
	{

		Node curr = front;

		int i = 0;
		while (i < arr.length)
		// adds each element of the array to the Queue.
		{

			enqueue(arr[i]);

			i++;

		}

	}

	public static void RangeOfBitcoinValues(Queue queue)
	// --------------------------------------------------------
	// Summary:It checks the elements (bitcoin values) of the Queue which is taken as parameters 
	// and calculates the range of bitcoin values of these elements (bitcoin values). 
	// Finally, it outputs bitcoin values and range of bitcoin values in the required format.
	// Precondition: queue is an instance of class Queue
	// --------------------------------------------------------
	{

		Node curr = queue.front;
		Node temp = curr;

		while (curr != null) {
			int k = 1; //The initial value when the bitcoin value is less than the previous value.

			if (curr.data == queue.front.data)
			// If bitcoin value is the first element of the queue.
			{
				curr.rangeOfBitcoinValue = 1;
			}

			else if (curr.data > temp.data)
			// If bitcoin value is greater than the previous bitcoin value.
			{

				curr.rangeOfBitcoinValue = 1;

			}

			else if (curr.data <= temp.data)
			// If bitcoin value is less than the previous bitcoin value.

			{

				Node first = queue.front;

				while (first != null && first.next != curr.next)
				//---------------------------------------------------------------	
				// Summary: It checks the queue from the beginning to the current bitcoin value 
				// to find the range of bitcoin value. It adds the number of elements whose 
				// bitcoin value is greater than itself to the initial value.
				//---------------------------------------------------------------	
				{

					if (curr.data <= first.data) {

						k++;

					}

					first = first.next;

				}
				curr.rangeOfBitcoinValue = k;

			}

			temp = curr;

			curr = curr.next;

		}

		System.out.println(queue); // It outputs the values of bitcoins in the queue.
		System.out.println(valueToString(queue));// It outputs range of bitcoin values in queue

	}

	@Override
	public String toString()
	// --------------------------------------------------------
	// Summary:It creates the queue in the specified format.
	// (Exp. [, , , , ]) /
	// --------------------------------------------------------
	{

		String result = "[";

		Node curr = front;

		while (curr != null) {
			result += curr.data + ", ";
			curr = curr.next;
		}
		result = result.substring(0, result.length() - 2);
		result += "]";
		return result;

	}

	public static String valueToString(Queue queue)
	// --------------------------------------------------------
	// Summary: It creates the range of bitcoin values in the queue class, 
	// which is taken as a parameter, in the specified format.(Exp. [, , , , ])
	// Precondition: queue is an instance of Queue class.
	// Postcondition: The front value of queue set as new node.
	// --------------------------------------------------------
	{
		String result = "[";

		Node curr = queue.front;

		while (curr != null) {
			result += curr.rangeOfBitcoinValue + ", ";
			curr = curr.next;
		}
		result = result.substring(0, result.length() - 2);
		result += "]";
		return result;

	}

}
