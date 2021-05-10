package com.itbulls.learnit.isidro.practices;

import java.util.Scanner;

public class NewLineForDigit {
    
    public static void main(String[] args) {
		System.out.print("Please, enter any integer: ");
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		char[] nums = userInput.toCharArray();
		for(int i=0; i<nums.length;i++)
		{
			System.out.println(nums[i]);
		}
		
    }
   
}
