package com.itbulls.learnit.isidro.oop.exam.onlineshop.menu.impl;

import com.itbulls.learnit.isidro.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.Order;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.menu.Menu;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.services.OrderManagementService;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.services.impl.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		if(context.getLoggedInUser() == null) {
			System.out.println("Please, log in or create new account to see list of your orders");
			context.getMainMenu().start();
			return;
		}
		else {
			Order[] orders = orderManagementService.getOrdersByUserId(context.getLoggedInUser().getId());
			if(orders == null || orders.length == 0) {
				System.out.println("Unfortunately, you don’t have any orders yet. Navigate back to " +
						"main menu to place a new order");
				context.getMainMenu().start();
			}
			else {
				for(Order order : orders) {
					System.out.println(order);
				}
				context.getMainMenu().start();
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** MY ORDERS *****");			
	}

}
