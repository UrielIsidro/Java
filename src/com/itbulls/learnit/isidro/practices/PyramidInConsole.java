package com.itbulls.learnit.isidro.practices;

import java.util.Scanner;

public class PyramidInConsole {
    
    public static void main(String[] args) {
		System.out.print("Please, enter height of the pyramid: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n1 = (2*n)-1;
        int i=0,k=0;
        while(i<n1)
        {
        	if(i<n)
        		k++;
        	else
        		k--;
        	for(int j=0;j<k;j++)
        	{
        		System.out.print("*");
        	}
        	System.out.println();
        	i++;
        }
        
    }

}
