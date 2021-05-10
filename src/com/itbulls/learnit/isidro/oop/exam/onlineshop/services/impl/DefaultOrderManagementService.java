package com.itbulls.learnit.isidro.oop.exam.onlineshop.services.impl;

import java.util.Arrays;

import com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.Order;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

	private static final int DEFAULT_ORDER_CAPACITY = 10;

	private static DefaultOrderManagementService instance;
	private int indexToAddOrder;
	private Order[] orders;
	{
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}
	
	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {
		if(order == null) {
			return;
		}
		if (orders.length <= indexToAddOrder) {
			orders = Arrays.copyOf(orders, orders.length << 1);
		}
		orders[indexToAddOrder++] = order;
	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		int matchOrders = 0;
		for(Order order : orders) {
			if(order != null && order.getCustomerId() == userId) {
				matchOrders++;
			}
		}
		
		Order[] userOrders = new Order[matchOrders];
		int index = 0;
		
		for(Order order : orders) {
			if(order != null && order.getCustomerId() == userId) {
				userOrders[index++] = order;
			}
		}
		return userOrders;
	}

	@Override
	public Order[] getOrders() {
		int validOrders = 0;
		for(Order order : orders) {
			if(order != null) {
				validOrders++;
			}
		}
		
		int index = 0;
		Order[] noNullOrders = new Order[validOrders];
		for(Order order : orders) {
			if(order != null) {
				noNullOrders[index++] = order;
			}
		}
		return noNullOrders;
	}
	
	void clearServiceState() {
		indexToAddOrder = 0;
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}

}
