package edu.westga.dsdm.matrix;

/**
 * The Class Matrix
 * 
 * @author CS3151
 */
public class Matrix {

	private int[][] matrix;

	/**
	 * Creates a new upper triangle matrix with the specified number of rows and
	 * columns
	 * 
	 * @param length the number rows and columns
	 */
	public Matrix(int length) {
		this.matrix = new int[length][length];
		for (int rowIdx = 0; rowIdx < this.matrix.length; rowIdx++) {
			this.matrix[rowIdx] = new int[length - rowIdx];
			for (int colIdx = 0; colIdx < this.matrix[rowIdx].length; colIdx++) {
				this.matrix[rowIdx][colIdx] = 1;
			}
		}
	}

	/**
	 * Prints the matrix row by row
	 */
	public void print() {
		System.out.println("Upper triangular matrix: ");
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix.length; j++) {
				if (i > j) {
					System.out.print("0 ");
				} else {
					System.out.print(this.matrix[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
