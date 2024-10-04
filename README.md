<h2 align="left">Q1:</h2>
<div align="center">
  <img src="https://github.com/user-attachments/assets/c3cb20ed-4c41-4629-8260-332537a7068f" alt="path" width=400px/>
</div>


<b>Part A.</b>	Return the elements of the given matrix in spiral form. The program should stop when it sees -1. 
The starting point will be 3 and the direction will be down until the end of the column, then right until the end of the row, up to the top and left.

The sequence should be as follows: 3→5→5→2→4→9→7→1→8→6→2→0→0

<b>Example Input/Output:</b>
<pre>
Input filename:matrix.txt
[3, 5, 5, 2, 4, 9, 7, 1, 8, 6, 2, 0, 0]
</pre>
<br>
<br>


<b>Part B.</b>	The lists will be given as input, for example:

List 1: {3, 5, 5, 2, 4, 9, 7, 1, 8, 2, 6, 2, 0, 0}
List 2: {0, -1, -1}

You need to find out if the neighborhood of list 1 contains list 2 or not. To do this, you need to check whether any node from list 1 is connected to any node in list 2. The nodes to the right, left, under, and above should all be checked. (Checking diagonally is not necessary.)

<b>Example Input/Output:</b>
<pre>
Input filename:matrixb.txt 
Input filename:list1.txt 
Input filename:list2.txt 
TRUE
</pre>
The direction of the arrow is the same as in 1A. You need to read 3 txt files, the first is the matrixb, the second and third are the lists with the indices of the matrices. The output will be TRUE or FALSE.

<div align="center">
  <img src="https://github.com/user-attachments/assets/369f6376-f675-47c2-a02e-b7638db15786" alt="path" width=400px/>
</div>
Use LinkedList for this question.
<br>
<br>
<h2 align="left">Q2:</h2>
Use stack/queue for the solution of this question.
<br>
Implement a Java solution that calculates the range of bitcoin values for the current day, given the series of n daily values of this coin.
<br>
<br>
Range definition:
<br>
<br>
The maximum number of <b>consecutive </b>days (starting today and going backwards) that the bitcoin value was higher than or equal to today's value.
<br>
<br>
For example, if the value of a bitcoin over the next 6 days were 90, 65, 70, 60, 75, 80, then the range returned would be 1, 2, 1, 4, 1, 1.
<br>
<br>
<b>Example Input/Output:</b>
<pre>
Input filename:price2.txt [90, 65, 70, 60, 75, 80]
[1, 2, 1, 4, 1, 1]
</pre>

<pre>
Explanation:
90 → return 1 because it is the first element of the range 65 → return 2 because 65 is smaller than 90
70 → return 1 because 90 is greater than 70
60 → return 4 because the last 4 values (60,70,65,90) were higher than or equal to today’s value 75 → return 1 because 90 is greater than 75
80 → return 1
</pre>



