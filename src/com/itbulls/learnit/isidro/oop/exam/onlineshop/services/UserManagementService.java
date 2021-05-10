package com.itbulls.learnit.isidro.oop.exam.onlineshop.services;

import com.itbulls.learnit.isidro.oop.exam.onlineshop.enteties.User;

public interface UserManagementService {

	String registerUser(User user);
	
	User[] getUsers();

	User getUserByEmail(String userEmail);

}