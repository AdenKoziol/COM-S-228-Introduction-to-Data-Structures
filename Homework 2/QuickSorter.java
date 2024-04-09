package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;


/**
 *  
 * @author Aden Koziol
 *
 */

/**
 * 
 * This class implements the version of the quicksort algorithm presented in the lecture.   
 *
 */

public class QuickSorter extends AbstractSorter
{
	
	// Other private instance variables if you need ... 
		
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *   
	 * @param pts   input array of integers
	 */
	public QuickSorter(Point[] pts)
	{
		// TODO
		super(pts);
		algorithm = "quicksort";
	}
		

	/**
	 * Carry out quicksort on the array points[] of the AbstractSorter class.  
	 * 
	 */
	@Override 
	public void sort()
	{
		// TODO
		quickSortRec(0, points.length - 1);
	}
	
	
	/**
	 * Operates on the subarray of points[] with indices between first and last. 
	 * 
	 * @param first  starting index of the subarray
	 * @param last   ending index of the subarray
	 */
	private void quickSortRec(int first, int last)
	{
		// TODO
		// Base case: If the partition size is 1 or zero
		// elements, then the partition is already sorted
		if (first >= last) {
			return;
		}

		// Partition the data within the array. Value lowEndIndex
		// returned from partitioning is the index of the low
		// partition's last element.
		int lowEndIndex = partition(first, last);

		// Recursively sort low partition (lowIndex to lowEndIndex)
		// and high partition (lowEndIndex + 1 to highIndex)
		quickSortRec(first, lowEndIndex);
		quickSortRec(lowEndIndex + 1, last);
	}
	
	
	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * 
	 * @param first
	 * @param last
	 * @return
	 */
	private int partition(int first, int last)
	{
		// Pick middle element as pivot
		int midpoint = first + (last - first) / 2;
		Point pivot = points[midpoint];

		boolean done = false;
		while (!done) {
			while (pointComparator.compare(points[first], pivot) < 0)
			{
				first++;
			}
			while (pointComparator.compare(pivot, points[last]) < 0) {
				last--;
			}

			// If zero or one elements remain, then all numbers are
			// partitioned
			if (first >= last) {
				done = true;
			}
			else {
				// Swap numbers[lowIndex] and numbers[highIndex]
				swap(first, last);

				// Update lowIndex and highIndex
				first++;
				last--;
			}
		}
		return last;
	}	
		


	
	// Other private methods if needed ...
}
