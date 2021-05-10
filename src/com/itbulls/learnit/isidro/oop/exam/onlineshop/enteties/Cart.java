package com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties;

public interface Cart {

	boolean isEmpty();

	void addProduct(Product productById);

	Product[] getProducts();

	void clear();

}
