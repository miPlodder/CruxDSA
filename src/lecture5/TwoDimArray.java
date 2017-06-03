package lecture5;

import java.util.Scanner;

public class TwoDimArray {

	public static int[][] getArray(int[][] arr) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Rows?");

		int row = sc.nextInt();

		arr = new int[row][];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("Cols in " + (i + 1));
			int col = sc.nextInt();
			arr[i] = new int[col];
			for (int j = 0; j < arr[i].length; j++) {
				// System.out.println("Element ["+(i+1)+","+(col+1)+"]");
				arr[i][j] = sc.nextInt();
			}
		}
		return arr;
	}

	public static void displayArray(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + ",");
			}
			System.out.println();
		}
	}

	public static void wavePrint(int[][] arr) {

		for (int col = 0; col < arr[0].length; col++) {
			
			if (col % 2 == 0) { // even

				for (int row = 0; row < arr.length; row++) {
					System.out.print(arr[row][col] + ",");
				}
			} else { //odd 
				
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.print(arr[row][col]+" ");
				}
			}
		}
	}

	public static void spiralPrint(int[][] arr){
		
		int colmin = 0; 
		int colmax = arr[0].length - 1;
		int rowmin = 0;
		int rowmax = arr.length - 1;
		int length = arr.length * arr[0].length;
		int counter = 0;
		while(counter <= length){
		//down
			for(int row = rowmin; row <= rowmax;row++){
				System.out.print(arr[row][colmin]+" ");
				counter++;
			}
		//right
			for(int col = colmin ; col <= colmax ; col++){
				System.out.print(arr[rowmax][col]+" ");
				counter++;
			}
			
		//top
			for(int row = rowmax ; row >= 0 ; row--){
				System.out.print(arr[rowmax][colmax]+" ");
				counter++;
			}
				
		//left
			for(int col = colmax ; col >= 0;col--){
				System.out.print(arr[rowmin][col]+" ");
				counter++;
			}
		System.out.print("\n");
		
	}
}
	
	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		spiralPrint(arr);
	}

}
