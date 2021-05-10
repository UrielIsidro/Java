package com.itbulls.learnit.isidro.oop.exam.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.isidro.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.menu.Menu;
import com.itbulls.learnit.isidro.oop.exam.onlineshop.Main;

public class MainMenu implements Menu {

	public static final String MENU_COMMAND = "menu";
	
	private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed." + System.lineSeparator()
			+ "1. Sign Up" + System.lineSeparator() + "2. Sign In"
			+ System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
			+ "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() + 
			"6. Customer List";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed." + System.lineSeparator()
			+ "1. Sign Up" + System.lineSeparator() + "2. Sign Out"
			+ System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
			+ "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() + 
			"6. Customer List";;

	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		printMenuHeader();
		if(context.getLoggedInUser() == null){
			System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
		}
		else {
			System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
		}
		
		Menu menuType;
		context.setMainMenu(this);
		Scanner sc = new Scanner(System.in);
		System.out.print("User input: ");
		String op = sc.nextLine();
		switch(op) {
			case "1":
				menuType = new SignUpMenu();
				menuType.start();
				break;
			case "2":
				if(context.getLoggedInUser() == null) {
					menuType = new SignInMenu();
					menuType.start();
				}
				else {
					menuType = new SignOutMenu();
					menuType.start();
				}
				break;
			case "3":
				menuType = new ProductCatalogMenu();
				menuType.start();
				break;
			case "4":					
				menuType = new MyOrdersMenu();
				menuType.start();
				break;
			case "5":				
				if(context.getLoggedInUser() == null) {
					System.out.println("Please, log in or create new account to change your "
							+ "account settings");
				}
				else {
					menuType = new SettingsMenu();
					menuType.start();
				}
				
				break;
			case "6":					
				menuType = new CustomerListMenu();
				menuType.start();
				break;
			case Main.EXIT_COMMAND:
				System.exit(0);
				break;
			default:
				System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time.");
				start();
		}
		
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** MAIN MENU *****");
	}

}
