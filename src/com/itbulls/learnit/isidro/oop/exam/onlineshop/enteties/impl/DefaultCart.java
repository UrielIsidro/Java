package com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.impl;

import java.util.Arrays;

import com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.Cart;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.Product;

public class DefaultCart implements Cart {
	
	private static final int DEFAULT_CART_CAPACITY = 10;
	private int cartCounter;
	
	private Product[] cartProducts;
	
	{
		cartProducts = new Product[DEFAULT_CART_CAPACITY];
	}
	
	@Override
	public boolean isEmpty() {
		if(cartProducts == null || cartProducts.length == 0) {
			return true;
		}
		for(Product product : cartProducts) {
			if(product != null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void addProduct(Product product) {
		if(product == null) {
			return;
		}
		
		if(cartProducts.length <= cartCounter) {
			cartProducts = Arrays.copyOf(cartProducts, cartProducts.length << 1);
		}
		cartProducts[cartCounter++] = product;
	}

	@Override
	public Product[] getProducts() {
		int validProducts = 0;
		for(Product product : cartProducts) {
			if(product != null) {
				validProducts++;
			}
		}
		
		Product[] noNullProducts = new Product[validProducts];
		int index = 0;
		for(Product product : cartProducts) {
			if(product != null) {
				noNullProducts[index++] = product;
			}
		}		
		return noNullProducts;
	}

	@Override
	public void clear() {
		cartProducts = new Product[DEFAULT_CART_CAPACITY];
	}

}
