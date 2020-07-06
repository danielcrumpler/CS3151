package edu.westga.dsdm.matrix;

import java.util.Scanner;

/**
 * The Class Main
 * 
 * The entry point into the application
 * 
 * @author CS3151
 */
public class Main {

	/**
	 * Runs the application
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		int length = 0;
		System.out.print("Enter the number rows of the matrix: ");
		try (Scanner input = new Scanner(System.in)) {
			length = input.nextInt();
		}
		Matrix matrix = new Matrix(length);
		matrix.print();
	}
}
