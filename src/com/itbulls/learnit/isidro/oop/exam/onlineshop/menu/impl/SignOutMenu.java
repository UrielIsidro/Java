package com.itbulls.learnit.isidro.oop.exam.onlineshop.menu.impl;

import com.itbulls.learnit.isidro.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.menu.Menu;

public class SignOutMenu implements Menu {

	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		printMenuHeader();
		System.out.println("Have a nice day! Look forward to welcoming back!");
		context.setLoggedInUser(null);
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SIGN OUT *****");
	}

}
