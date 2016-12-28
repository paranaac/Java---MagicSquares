
// ****************************************************************
// SquareTest.java
//
// Uses the Square class to read in square data and tell if 
// each square is magic.
//          
// ****************************************************************

/*
 * Alejandro Parana
 * 10/2014
 * CSCI300 Exercise 1.3
 * Test Class for Magic Square problem
 */
import java.util.Scanner;

public class SquareTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input the size of a square: ");
		int size = input.nextInt(); // size of next square

		// create a new Square of the given size
		Square magicSquare = new Square(size);

		// call its read method to read the values of the square
		System.out.println("Input square values: ");
		magicSquare.readSquare(input);

		System.out.println("\n******** Square ********");
		// print the square
		magicSquare.printSquare();

		// print the sums of its rows
		for (int row = 0; row < size; row++)
			System.out.println("Row " + (row + 1) + " sum: " + magicSquare.sumRow(row));

		// print the sums of its columns
		for (int col = 0; col < size; col++)
			System.out.println("Col " + (col + 1) + " sum: " + magicSquare.sumCol(col));

		// print the sum of the main diagonal
		System.out.println("Main diagonal: " + magicSquare.sumMainDiag());

		// print the sum of the other diagonal
		System.out.println("Other diagonal: " + magicSquare.sumOtherDiag());

		// determine and print whether it is a magic square
		if (magicSquare.magic())
			System.out.println("It's magic.\n");
		else
			System.out.println("It's not magic.\n");
	}
}
