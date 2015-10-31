package by.epam.tat.lecture1.matrix;

import java.util.Scanner;

/**
 * Turn a matrix on 90 degrees clockwise
 *
 * @author Elena
 *
 */

public class Matrix {
	
	public static int[][] createMatrix(){
		Scanner in = new Scanner ( System.in );
		System.out.println("How many rows in matrix do you want?");
		int nRow = in.nextInt();
		System.out.println("How many columns in matrix do you want?");
		int nColumns = in.nextInt();
		int[][] table1 = new int[nRow][nColumns];
		System.out.println("Fill the matrix");
		
		for (int i = 0; i < nRow; i++){
			for (int x = 0; x < nColumns;){
				try{
					System.out.println("Enter " + (i+1) + " value in " + (x+1) + " row");
					table1[i][x] = in.nextInt();
					x++;
				}
				catch(java.util.InputMismatchException exc){
					System.out.print("Error: Only integer can be used. ");
					in.nextLine();  // Consume newline left-over
					continue ;
				}
			}
		}
		in.close();
		System.out.println("The matrix is created");
		System.out.println("-----------------");
		return table1;
	}
	
	public static void viewMatrix(int[][] table){ //print matrix
		int tablLeng1 = table.length;
		int tablLeng2 = table[0].length;
		for (int i = 0; i < tablLeng1; i++){
			for (int k = 0; k < tablLeng2; k++){
				System.out.print(table[i][k] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] turnMatrix90Degrees(int[][] table){ // Turn a matrix on 90 degrees clockwise 
		int tablLeng1 = table.length;
		int tablLeng2 = table[0].length;
		int table2[][] = new int [tablLeng2][tablLeng1];
		for (int l = 0; l < tablLeng2; l++){
			int n = 0;
			for (int h = tablLeng1 - 1; h >=0; h--){
				table2[l][n]=table[h][l];
				n++;
			}			
		}
		return table2;
	}

	public static void main(String[] arg){
		int[][] tableInitial = createMatrix();
		System.out.println("Initial matrix:");
		viewMatrix(tableInitial);
		System.out.println();
		
		int[][] tableTurned = turnMatrix90Degrees(tableInitial);
		System.out.println("Matrix is turned on 90 degrees clockwise:");
		viewMatrix(tableTurned);
	}
}
