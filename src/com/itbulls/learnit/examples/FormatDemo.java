package com.itbulls.learnit.examples;

import java.util.Formatter;

public class FormatDemo {

	public static void main(String[] args) {
		
		StringBuffer f = new StringBuffer("%.1f");
		
		for(int i=1;i<6;i++) {
						
			f.setCharAt(2,(char)(i+'0'));
			String f2 = new String(f);
			Formatter formatter = new Formatter();
			formatter.format(f2, Math.PI);
			System.out.println(formatter);
		}

	}

}
