package com.itbulls.learnit.isidro.practices;

import java.util.Scanner;

public class FirstCharCapital {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter any text: ");
		String userInput = sc.nextLine();
		
		
		System.out.println(firstCharToTitleCase(userInput));
	}

	public static String firstCharToTitleCase(String string) {
		char[] words = string.toLowerCase().toCharArray();
		for(int i =0; i < words.length; i++)
		{
			if(i == 0)
				words[i] = Character.toUpperCase(words[i]);
			else if(Character.isLetter(words[i]) && Character.isWhitespace(words[i-1]))
				words[i] = Character.toUpperCase(words[i]);
					

		}
		
		return String.valueOf(words);
		
	}
}