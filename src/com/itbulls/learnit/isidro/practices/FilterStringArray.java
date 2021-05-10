package com.itbulls.learnit.isidro.practices;

import java.util.Arrays;
import java.util.Scanner;

public class FilterStringArray {
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter any words separated by space: ");
		String userInput = sc.nextLine();
		System.out.print("Please, enter minumum word length to filter words: ");
		int minLength = sc.nextInt();
		
		String[] words = userInput.split("\\s+");
		String[] filteredWords = filterWordsByLength(minLength, words);
		System.out.println(Arrays.toString(filteredWords));
	}

	
	
	public static String[] filterWordsByLength(int minLength, String[] words) {
		String filter = "";
		
		for(int i =0; i < words.length; i++)
		{
			if(words[i].toCharArray().length >= minLength)
				filter = filter + words[i] + " ";
		}
		String[] newWords = filter.split("\\s+");
		
		return newWords;
	}

}