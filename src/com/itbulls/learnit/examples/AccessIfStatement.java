package com.itbulls.learnit.examples;

public class AccessIfStatement {

	public static void main(String[] args) {
		String name = String.join(",", args);
		String admin = "--admin";
		String guest = "--guest";
		
		if(name.contains(admin) && name.contains(guest))
			System.out.println("Please, select either 'ADMIN' or 'GUEST' mode for this program");
		else if(name.contains(admin))
			System.out.println("Hello, Admin!");
		else if(name.contains(guest))
			System.out.println("Hello, guest!");
	}

}
