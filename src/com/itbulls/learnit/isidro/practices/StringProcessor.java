package com.itbulls.learnit.isidro.practices;

public class StringProcessor {
    public static final String INPUT_DATA = "Login;Name;Email" + System.lineSeparator() +
			"peterson;Chris Peterson;peterson@outlook.com" + System.lineSeparator() +
			"james;Derek James;james@gmail.com" + System.lineSeparator() +
			"jackson;Walter Jackson;jackson@gmail.com" + System.lineSeparator() +
			"gregory;Mike Gregory;gregory@yahoo.com";
	
	public static void main(String[] args) {
		System.out.println("===== Convert 1 demo =====");
		System.out.println(convert1(INPUT_DATA));
		
		System.out.println("===== Convert 2 demo =====");
		System.out.println(convert2(INPUT_DATA));
		
	}
	
	public static String convert1(String input) {
		String[] lineData = input.split(System.lineSeparator());
		String newData = "";
		for(int i = 1; i < lineData.length; i++)
		{
			String[] data = lineData[i].split(";");
			newData += data[0] + " ==> " + data[2] + System.lineSeparator();
		}
		
		return newData;	
	}
	
	
	public static String convert2(String input) {
		String[] lineData = input.split(System.lineSeparator());
		String newData = "";
		for(int i = 1; i < lineData.length; i++)
		{
			String[] data = lineData[i].split(";");
			newData += data[1] + " (email: " + data[2] + ")" + System.lineSeparator();
		}
		
		return newData;		
	}

}
