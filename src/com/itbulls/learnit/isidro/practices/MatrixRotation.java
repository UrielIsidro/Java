package com.itbulls.learnit.isidro.practices;

import java.util.Scanner;

public class MatrixRotation {
    
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Please, enter matrix size: ");
		int size = in.nextInt();
		double[][] matrix = generateMatrix(size);

		System.out.println("How you want to rotate matrix:" + System.lineSeparator() +
				"\t1 - 90" + System.lineSeparator() +
				"\t2 - 180" + System.lineSeparator() +
				"\t3 - 270");
		int mode = in.nextInt();

		System.out.println(System.lineSeparator() + "Base matrix:" + System.lineSeparator());
		printMatrixToConsole(matrix);
		System.out.println();

		if (rotateMatrix(matrix, mode)) {
			printMatrixToConsole(matrix);
		}
	}
    
	public static double[][] generateMatrix(int size) {
		double[][] matrix = new double[size][size]; 
		
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
			{
				matrix[i][j] = (i + (j*0.1));
			}
		return matrix;
	}
	
	public static void printMatrixToConsole(double[][] matrix) {
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
				System.out.printf("%.1f\t",matrix[i][j]);
			System.out.print("\n");
		}
	}
	
	public static boolean rotateMatrix(double[][] matrix, int mode) {
		switch(mode) {
			case 1:
				System.out.println("90 degrees rotated:" + System.lineSeparator());
				valueMatrix(matrix,rotate90(matrix));
				break;
			case 2:
				System.out.println("180 degrees rotated:" + System.lineSeparator());
				valueMatrix(matrix,rotate90(rotate90(matrix)));
				break;
			case 3:
				System.out.println("270 degrees rotated:" + System.lineSeparator());
				valueMatrix(matrix,rotate90(rotate90(rotate90(matrix))));
				break;
			default:
				return false;
		}
		return true;
	}
	
	public static double[][] rotate90(double[][] matrix) {
		double[][] newMatrix = new double[matrix.length][matrix.length];
		for(int i = 0, k = matrix.length - 1; i < matrix.length; i++,k--)
		{
			for(int j = 0; j < matrix[i].length; j++)
				newMatrix[j][k] = matrix[i][j];
		}
		return newMatrix;
	}
	
	public static void valueMatrix(double[][] matrix, double[][] newMatrix) {
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = newMatrix[i][j];
		}
	}

}