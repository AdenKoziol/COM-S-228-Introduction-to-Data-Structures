package edu.iastate.cs228.hw2;

//import sun.security.util.Length;

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
 * This class implements the mergesort algorithm.   
 *
 */

public class MergeSorter extends AbstractSorter
{
	// Other private instance variables if needed
	
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *  
	 * @param pts   input array of integers
	 */
	public MergeSorter(Point[] pts) 
	{
		// TODO
		super(pts);
		algorithm = "mergesort";
	}


	/**
	 * Perform mergesort on the array points[] of the parent class AbstractSorter. 
	 * 
	 */
	@Override 
	public void sort()
	{
		// TODO
		mergeSortRec(points);
	}

	
	/**
	 * This is a recursive method that carries out mergesort on an array pts[] of points. One 
	 * way is to make copies of the two halves of pts[], recursively call mergeSort on them, 
	 * and merge the two sorted subarrays into pts[].   
	 * 
	 * @param pts	point array 
	 */
	private void mergeSortRec(Point[] pts)
	{
		int k = 0;
		Point[] lower = new Point[pts.length / 2];
		Point[] higher = new Point[pts.length - lower.length];

		for(int i = 0; i < lower.length; i++)
		{
			lower[i] = pts[k];
			k++;
		}
		for(int j = 0; j < higher.length; j++)
		{
			higher[j] = pts[k];
			k++;
		}

		if(lower.length > 1)
			mergeSortRec(lower);
		if(higher.length > 1)
			mergeSortRec(higher);

		int index = 0, indexLower = 0, indexHigher = 0;
		while(indexLower < lower.length && indexHigher < higher.length) {
			if (pointComparator.compare(lower[indexLower], higher[indexHigher]) < 0) {
				pts[index] = lower[indexLower];
				index++;
				indexLower++;
			} else {
				pts[index] = higher[indexHigher];
				index++;
				indexHigher++;
			}
		}
		while(indexLower <lower.length)
		{
			pts[index] = lower[indexLower];
			index++;
			indexLower++;
		}
		while(indexHigher < higher.length)
		{
			pts[index] = higher[indexHigher];
			index++;
			indexHigher++;
		}
		if(pts.length == points.length)
		{
			for(int i = 0; i < points.length; i++)
				points[i] = pts[i];
		}
	}

	
	// Other private methods if needed ...

}
