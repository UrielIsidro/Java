package com.itbulls.learnit.isidro.oop.present;

import java.util.Arrays;

public class Present {
	
	private static final int DEFAULT_PRESENT_CAPACITY = 20;
	private static int presentCounter;
	
	private Sweet[] sweets;
	
	{
		sweets = new Sweet[DEFAULT_PRESENT_CAPACITY];
	}
	
	
	// the method that adds sweet to the present
	public void addSweet(Sweet sweet) {
		if(sweet == null)
		{
			return;
		}

		if(sweets.length < presentCounter + 1) {
			sweets = Arrays.copyOf(sweets, sweets.length * 2);
		}	
		sweets[presentCounter++] = sweet;
		
	}
	
	// the method filters sweets by sugar weight inclusively 
	public Sweet[] filterSweetsBySugarRange(double minSugarWeight, double maxSugarWeight) {
		
		int numberValidSweets = 0;
		for(Sweet sweet : sweets) {
			if(sweet != null && (sweet.getSugarWeight() >= minSugarWeight)
					&& (sweet.getSugarWeight() <= maxSugarWeight)) {
				numberValidSweets++;
			}
		}
		
		int i = 0;
		Sweet[] validSweets = new Sweet[numberValidSweets];
		
		for(Sweet sweet : sweets) {
			if(sweet != null && (sweet.getSugarWeight() >= minSugarWeight)
					&& (sweet.getSugarWeight() <= maxSugarWeight)) {
				validSweets[i++] = sweet;
			}
		}
		
		return validSweets;
	}

	// the method calculates total weight of the present
	public double calculateTotalWeight() {
		double totalWeight = 0;
		
		for(Sweet sweet : sweets) {
			if(sweet != null) {
				totalWeight += sweet.getWeight();
			}
		}
		
		return totalWeight;
	}
	
	// the method returns copy of the Sweet[] array so that nobody could 
	// modify state of the present without addSweet() method. 
	// Also array shouldn’t contain null values.
	public Sweet[] getSweets() {
		int validSweets = 0;
		for(Sweet sweet : sweets) {
			if(sweet != null) {
				validSweets++;
			}
		}
		
		int i = 0;
		Sweet[] newSweets = new Sweet[validSweets];
		
		for(Sweet sweet : sweets) {
			if(sweet != null) {
				newSweets[i++] = sweet;
			}
		}
		
		return newSweets;		
	}
	
}
