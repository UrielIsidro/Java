package com.itbulls.learnit.isidro.practices;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxInt {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter integer numbers separated by space: ");
		String userInput = sc.nextLine();
		int[] numbers = convertStringToInt(userInput.split("\\s+"));
	
		System.out.println("*** Initial Array ***");
		System.out.println(Arrays.toString(numbers));
		
		int maxInt = findMaxIntInArray(numbers);
		System.out.println("*** Max number in array ***");
		System.out.println(maxInt);
	}

	
	public static int findMaxIntInArray(int[] intArray) {
		int a = 0;
		for(int i = 0; i < intArray.length; i++)
		{
			if(intArray[i] > a)
				a=intArray[i];
		}
		return a;
	}
	
	public static int[] convertStringToInt(String[] stringArray) {
		int[] intArray = new int[stringArray.length];
		for(int i = 0; i < stringArray.length; i++)
		{
			intArray[i] = Integer.valueOf(stringArray[i]);
		}
		return intArray;
	}
}