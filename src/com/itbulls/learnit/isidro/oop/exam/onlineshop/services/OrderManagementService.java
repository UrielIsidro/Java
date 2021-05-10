package com.itbulls.learnit.isidro.oop.exam.onlineshop.services;

import com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.Order;

public interface OrderManagementService {

	void addOrder(Order order);

	Order[] getOrdersByUserId(int userId);
	
	Order[] getOrders();

}
