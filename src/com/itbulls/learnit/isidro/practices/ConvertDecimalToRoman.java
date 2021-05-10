package com.itbulls.learnit.isidro.practices;

import java.util.Scanner;

public class ConvertDecimalToRoman {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		mainLoop: while (true) {
			System.out.print("Please, select mode. If you want to convert Roman "
					+ "numbers to decimal - type 'R2D' and press enter."
					+ System.lineSeparator()
					+ "If you want to convert decimal numbers to Roman - type 'D2R' and press enter: ");

			String mode = sc.next();
			if (mode.equalsIgnoreCase("R2D")) {
				while (true) {
					System.out.print("Please, enter Roman number you want to convert: ");
					String romanNumber = sc.next();
					if (isRomanNumberValid(romanNumber)) {
						System.out.println(roman2Decimal(romanNumber));
						break mainLoop;
					} else {
						System.out.println("You entered invalid Roman number. "
								+ "Please, try one more time.");
						continue;
					}
				}
			} else if (mode.equalsIgnoreCase("D2R")) {
				while (true) {
					System.out.print("Please, enter decimal number "
							+ "you want to convert: ");
					int decimalNumber = sc.nextInt();
					if (isDecimalNumberValid(decimalNumber)) {
						System.out.println(decimal2Roman(decimalNumber));
						break mainLoop;
					} else {
						System.out.println("Please, enter positive integer from 1 to 100.");
						continue;
					}

				}

			}
			
			System.out.println("Please, enter 'R2D' or 'D2R.");
		}
	}

	

	/**
	 * Converts decimal numbers to Roman.
	 * 
	 * Takes int value as a parameter. Works only with numbers from 1 to 100.
	 * 
	 * @param number to convert to Roman.
	 * @return string of Roman number.
	 */
	public static String decimal2Roman(int number) {
		String[] letters = {"C","XC","L","XL","X","IX","V","IV","I"};
		int[] value = {100,90,50,40,10,9,5,4,1};
		String decimal = "";
		
		for(int i = 0; i < letters.length;)
		{
			if(number >= value[i])
			{
				decimal += letters[i];
				number -= value[i];
			}
			else
				i++;
				
		}
		return decimal;
		
	}

	/**
	 * Converts Roman numbers to decimal.
	 * 
	 * Takes string value with Roman number as a parameter.
	 * 
	 * At first method validates if input string could be Roman number. After method
	 * uses algorithm to convert Roman numeral to decimal.
	 * 
	 * @param romanNumber
	 * @return decimal representation of Roman number
	 */

	public static int roman2Decimal(String romanNumber) {
		String romanNumberUp = romanNumber.toUpperCase();
		int lastValue = 0;
		int decimal = 0;
		
		for(int i = romanNumberUp.length()-1; i >= 0; i-- )
		{
			char number = romanNumberUp.charAt(i);
			switch(number) {
				case 'M':
					decimal += sumValue(lastValue,1000);
					lastValue = 1000;
					break;
					
				case 'D':
					decimal += sumValue(lastValue,500);
					lastValue = 500;
					break;
					
				case 'C':
					decimal += sumValue(lastValue,100);
					lastValue = 100;
					break;
					
				case 'L':
					decimal += sumValue(lastValue,50);
					lastValue = 50;
					break;
					
				case 'X':
					decimal += sumValue(lastValue,10);
					lastValue = 10;
					break;
				case 'V':
					decimal += sumValue(lastValue,5);
					lastValue = 5;
					break;
				case 'I':
					decimal += sumValue(lastValue,1);
					lastValue = 1;
					break;		
			
			}
		}
		return decimal;
	}
	
	public static int sumValue(int lastValue, int actualValue) {
		if(lastValue > actualValue)
			return -actualValue;
		else
			return actualValue;
	}


	/**
	 * Validation for Roman numbers.
	 * 
	 * Use regular expression which is checking if string really could be Roman
	 * number.
	 * 
	 * @param romanNumber
	 * @return true if String is Roman number
	 */
	public static boolean isRomanNumberValid(String romanNumber) {
	    return romanNumber.matches("^(?i)M{0,3}(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$");
	}
	
	public static boolean isDecimalNumberValid(int decimalNumber) {
		if(decimalNumber >= 1 && decimalNumber <= 100)
			return true;
		else
			return false;
	}
}
