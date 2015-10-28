package Massive;
/**
 * Turn a matrix on 90 degrees clockwise
 * (ѕовернуть матрицу на 90 градусов по часовой стрелке)
 *
 * @author Elena
 *
 */

public class Massive {
	public static void main(String[] arg){
		int[][] table1 = {
			{1, 2, 3, 4, 5},
			{6, 7, 8, 9, 10},
			{11, 12, 13, 14, 15},
			{16, 17, 18, 19, 20}, 
			{21, 22, 23, 24, 25},
		};
		int tablLeng1 = table1.length;
		int tablLeng2 = table1[0].length;
		
		int[][] table2 = new int[tablLeng2][tablLeng1];
// Turn a matrix on 90 degrees clockwise 		
		for (int l = 0; l < tablLeng2; l++){
			int n = 0;
			for (int h = tablLeng1 - 1; h >=0; h--){
				table2[l][n]=table1[h][l];
				n++;
			}			
		}
// 	Display initial matrix
		System.out.println("old matrix: " );
		for (int i = 0; i < tablLeng1; i++){
			for (int k = 0; k < tablLeng2; k++){
				System.out.print(table1[i][k] + " ");
			}
			System.out.println();
		}
//	 	Display Turned matrix		
		System.out.println("new matrix: " );
		for (int i = 0; i < tablLeng2; i++){
			for (int k = 0; k < tablLeng1; k++){
				System.out.print(table2[i][k] + " ");
			}
			System.out.println();
		}
	}
}
