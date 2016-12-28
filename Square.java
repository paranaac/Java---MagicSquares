// ****************************************************************
// Square.java
// Define a Square class with methods to create and read in
// info for a square matrix and to compute the sum of a row,
// a column, either diagonal, and whether it is magic.       
// ****************************************************************

/*
 * Alejandro Parana
 * 10/2014
 * CSCI300 Exercise 1.3
 * Purpose: Fill in the methods for the Magic Square problem
*/
import java.util.Scanner;

public class Square {
	int[][] square;

	// --------------------------------------
	// create new square of given size
	// --------------------------------------
	public Square(int size) {
		square = new int[size][size];
	}

	// -----------------------------------------------
	// return the sum of the values in the given row
	// -----------------------------------------------
	public int sumRow(int row) {
		int rowSum = 0;
		for (int col = 0; col < square.length; col++) {
			rowSum += square[row][col];
		}
		return rowSum;
	}

	// -------------------------------------------------
	// return the sum of the values in the given column
	// -------------------------------------------------
	public int sumCol(int col) {
		int colSum = 0;
		for (int row = 0; row < square.length; row++) {
			colSum += square[row][col];
		}
		return colSum;
	}

	// ---------------------------------------------------
	// return the sum of the values in the main diagonal
	// ---------------------------------------------------
	public int sumMainDiag() {
		int mDiagSum = 0;
		for (int i = 0; i < square.length; i++) {
			mDiagSum += square[i][i];
		}
		return mDiagSum;
	}

	// ---------------------------------------------------------------
	// return the sum of the values in the other ("reverse") diagonal
	// ---------------------------------------------------------------
	public int sumOtherDiag() {
		int mOtherSum = 0;
		int prevIndex = square.length - 1;
		for (int i = 0; i < square.length; i++) {
			mOtherSum += square[i][prevIndex - i];
		}
		return mOtherSum;
	}

	// -------------------------------------------------------------------
	// return true if the square is magic (all rows, cols, and diags have
	// same sum), false otherwise
	// -------------------------------------------------------------------
	public boolean magic() {
		int mDiagSum = sumMainDiag();

		boolean isMagic = sumOtherDiag() == mDiagSum;
		if (isMagic) {
			int row = 0;
			while (row < square.length && isMagic) {
				if (sumRow(row) != mDiagSum)
					isMagic = false;
				else
					row++;
			}
			int col = 0;
			while (col < square.length && isMagic) {
				if (sumCol(col) != mDiagSum)
					isMagic = false;
				else
					col++;
			}
			return isMagic;
		} else {
			return false;
		}
	}

	// ----------------------------------------------------
	// read info into the square from the standard input.
	// ----------------------------------------------------
	public void readSquare(Scanner in) {
		for (int row = 0; row < square.length; row++)
			for (int col = 0; col < square.length; col++)
				square[row][col] = in.nextInt();
	}

	// ---------------------------------------------------
	// print the contents of the square, neatly formatted
	// ---------------------------------------------------
	public void printSquare() {
		for (int row = 0; row < square.length; row++) {
			for (int col = 0; col < square.length; col++)
				System.out.print(square[row][col] + "  ");
			System.out.println();
		}
	}
}
