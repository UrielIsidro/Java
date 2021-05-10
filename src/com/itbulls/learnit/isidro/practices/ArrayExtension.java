package com.itbulls.learnit.isidro.practices;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayExtension {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter length of initial array: ");
		int baseArrayLength = sc.nextInt();
		int[] arr = generateRandomArray(baseArrayLength);
		int[] extendedArray = extendArray(arr);
		System.out.println("*** Initial array ***");
		System.out.println(Arrays.toString(arr));
		System.out.println("*** Extended array ***");
		System.out.println(Arrays.toString(extendedArray));
	}

	/**
	 * The method extends array.
	 * If array {1, 2, 3} has been passed to this method then array {1, 2, 3, 2, 4, 6}
	 * is returned from this method.
	 * 
	 * @param arr - base of extension. Extended array contains elements from this array
	 * and additionally contains the same elements multiplied by two. 
	 * @return extended array.
	 */
	public static int[] extendArray(int[] arr) {
	    int[] newArr = new int[arr.length*2];
		for(int i = 0; i < arr.length*2; i++)
	    {
	    	if(i < arr.length)
	    		newArr[i] = arr[i];
	    	else
	    		newArr[i] = arr[i-arr.length]*2;
	    	
	    }
		return newArr;
	}

	public static int[] generateRandomArray(int amountOfElements) {
		Random r = new Random();
		int[] elements = new int[amountOfElements];
		for(int i = 0; i < amountOfElements; i++)
			elements[i] = r.nextInt(100);
		return elements;
	}

}
