package com.itbulls.learnit.isidro.oop.exam.onlineshop.services;

import com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.Product;

public interface ProductManagementService {

	Product[] getProducts();

	Product getProductById(int productIdToAddToCart);

}
