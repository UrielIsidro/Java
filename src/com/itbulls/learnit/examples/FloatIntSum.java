package com.itbulls.learnit.examples;

public class FloatIntSum {

	public static void main(String[] args) {
		

		if(args[0].contains(".") || args[1].contains("."))
		{
			double a = Double.parseDouble(args[0]);
			double b = Double.parseDouble(args[1]);
			double res = a+b;
			System.out.println(res);
		}
		else
		{
			int c = Integer.parseInt(args[0]);
			int d = Integer.parseInt(args[1]);
			int result = c+d;
			System.out.println(result);
		}
		
	}

}

