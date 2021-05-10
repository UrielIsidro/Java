package com.itbulls.learnit.isidro.oop.exam.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.isidro.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.menu.Menu;

public class SettingsMenu implements Menu {

	private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
			+ "2. Change Email";

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		Menu option = null;
		Scanner sc = new Scanner(System.in);
		printMenuHeader();
		if (context.getLoggedInUser() == null) {
			System.out.println("Please, log in or create new account to change your account settings");
			option = new MainMenu();
			option.start();
		}
		else {
			System.out.println(SETTINGS);
			System.out.println("User input: ");
			String op = sc.next();
			switch(op) {
			case "1":
					option = new ChangePasswordMenu();
					option.start();
					break;
			case "2":
					option = new ChangeEmailMenu();
					option.start();
					break;
			case MainMenu.MENU_COMMAND:
				context.getMainMenu().start();
			default:
					System.out.println("Only 1, 2 is allowed. Try one more time");
			}
			
		}
		
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SETTINGS *****");		
	}

}
