package com.itbulls.learnit.isidro.oop.exam.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.isidro.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.User;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.menu.Menu;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.services.UserManagementService;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.services.impl.DefaultUserManagementService;

public class SignInMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;

	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your email: ");
		String email = sc.next();
		
		System.out.print("Please enter your password: ");
		String password = sc.next();
		
		checkCredentials(email, password);
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SIGN IN *****");	
	}
	
	public void checkCredentials(String email, String password) {
		User signInUser = userManagementService.getUserByEmail(email);
		if(signInUser != null && signInUser.getPassword().equals(password)) {
			System.out.println("Glad to see you back " + signInUser.getFirstName() +
					" " + signInUser.getLastName());
			context.setLoggedInUser(signInUser);
		}
		else {
			System.out.println("Unfortunately, such login and password doesn’t exist");
		}
	}

}
