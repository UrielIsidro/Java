package com.itbulls.learnit.isidro.practices;

import java.util.Scanner;

public class SumDigitsInNumber {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter integer: ");
		int number = sc.nextInt();
		
		int sumOfDigits = sumDigitsInNumber(number);
		System.out.println(sumOfDigits);
	}

	public static int sumDigitsInNumber(int number) {
		String digits = Integer.toString(Math.abs(number));
		int sum = 0;
		for(int i = 0; i < digits.toCharArray().length;i++)
		{
			sum += Character.getNumericValue(digits.toCharArray()[i]);
		}
		return sum;
	}
}