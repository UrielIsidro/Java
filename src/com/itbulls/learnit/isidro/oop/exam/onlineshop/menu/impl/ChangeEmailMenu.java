package com.itbulls.learnit.isidro.oop.exam.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.isidro.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.User;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.menu.Menu;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.services.UserManagementService;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.services.impl.DefaultUserManagementService;

public class ChangeEmailMenu implements Menu {
	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		String newEmail = sc.next();
		context.getLoggedInUser().setEmail(newEmail);
		System.out.println("Your email has been succesfully changed");
		new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** CHANGE EMAIL *****");	
		System.out.println("Enter new email: ");
	}

}
