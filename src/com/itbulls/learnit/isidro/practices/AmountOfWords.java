package com.itbulls.learnit.isidro.practices;

import java.util.Scanner;

public class AmountOfWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter any text: ");
		String text = sc.nextLine();
		
		int amountOfWords = getWordsAmount(text);
		System.out.println("Amount of words in your text: " + amountOfWords);
	}

	public static int getWordsAmount(String text) {
		String[] words = text.split("[\\s\\W]");
		int a = 0;
		for(int i = 0; i < words.length; i++)
			if(!words[i].isEmpty())
				a++;
		
		return a;
	}
}