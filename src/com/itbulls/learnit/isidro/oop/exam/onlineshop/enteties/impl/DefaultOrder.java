package com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.impl;

import java.util.Arrays;

import com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.Order;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.Product;

public class DefaultOrder implements Order {

	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;
	
	private String creditCardNumber;
	private Product[] products;
	private int customerId;
	
	public DefaultOrder() {
		
	}
	
	@Override
	public boolean isCreditCardNumberValid(String creditCardNumber) {
		if(creditCardNumber.length() == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER &&
				!creditCardNumber.contains(" ") && Long.parseLong(creditCardNumber) > 0) {
			return true;
		}
		else
			return false;
	}

	@Override
	public void setCreditCardNumber(String creditCardNumber) {
		if (creditCardNumber == null) {
			return;
		}
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public void setProducts(Product[] products) {
		this.products = products;
	}

	@Override
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	@Override
	public int getCustomerId() {
		return this.customerId;
	}

	@Override
	public String toString() {
		return "Order: " + "customer id - " + getCustomerId() + "\t" + "credit card number - " 
					+ creditCardNumber + "\t" + " products -" + Arrays.toString(products);
	}	

}
