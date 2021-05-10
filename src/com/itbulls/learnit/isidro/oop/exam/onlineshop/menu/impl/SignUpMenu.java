package com.itbulls.learnit.isidro.oop.exam.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.isidro.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.menu.Menu;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.services.UserManagementService;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.services.impl.DefaultUserManagementService;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.User;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.impl.DefaultUser;

public class SignUpMenu implements Menu {

	private UserManagementService userManagementService;
	private ApplicationContext context;
	private User user;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your first name: ");
		String firstName = sc.next();
		System.out.print("Please enter your last name: ");
		String lastName = sc.next();
		System.out.print("Please enter your password: ");
		String password = sc.next();
		System.out.print("Please enter your email: ");
		sc = new Scanner(System.in);
		String email = sc.nextLine();
		
		user = new DefaultUser(firstName, lastName, password, email);
		
		String errorMessage = userManagementService.registerUser(user);
		if (errorMessage == null || errorMessage.isEmpty()) {
			context.setLoggedInUser(user);
			System.out.println("New user is created");
		} else {
			System.out.println(errorMessage);
		}

		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SIGN UP *****");
	}

}
