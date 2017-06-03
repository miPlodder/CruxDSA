//foobar.withgoogle.com

package lecture4;

import java.util.Scanner;

public class SpiralTraversal {

	public static int[][] getArray() {

		Scanner sc = new Scanner(System.in);

		int row = sc.nextInt();
		int col = sc.nextInt();

		int[][] rv = new int[row][col];

		for (row = 0; row < rv.length; row++)
			for (col = 0; col < rv[0].length; col++)
				rv[row][col] = sc.nextInt();

		return rv;
	}

	public static void spiralAntiPrint(int[][] arr) {

		int colmin = 0;
		int colmax = arr[0].length - 1;
		int rowmin = 0;
		int rowmax = arr.length - 1;
		int counter = 0;
		int total = (colmax + 1) * (rowmax + 1);
		while (counter < total) {

			// up2down
			for (int i = rowmin; i <= rowmax; i++) {
				System.out.println(arr[i][colmin] + " ");
				counter++;
			}
			colmin++;

			// left2right
			for (int j = colmin; j <= colmax; j++) {
				System.out.println(arr[rowmax][j] + " ");
				counter++;
			}
			rowmax--;
			// down2up
			for (int i = rowmax; i >= rowmin; i--) {
				System.out.println(arr[i][colmax] + " ");
				counter++;
			}
			colmax--;
			// right2left
			for (int j = colmax; j >= colmin; j--) {
				System.out.println(arr[rowmin][j] + " ");
				counter++;
			}
			rowmin++;

		}

	}

	public static void spiralClockPrint(int[][] arr){
		
		int counter = 0 ;
		int rowmin = 0 ,rowmax = arr.length ,colmin = 0 ,colmax = arr[0].length ;
		
		int total = (rowmax+1) * (colmax + 1);
		
		while(counter < total){ 
			//left2right -- rowmin
		
		for(int j = colmin ; j <= colmax ; j++)
		{
			System.out.print(arr[rowmin][j]);
			counter++;
		}
		
		rowmin++;
		//top2bottom -- colmax
		
		for(int i = rowmin ; i <= rowmax ; i++){
			
			System.out.print(arr[i][colmax]);
			counter++;
		}
		colmax--;
		
		//right2left -- rowmax
		for(int j = colmax ; j>= colmin ; j--)
		{
			System.out.print(arr[rowmax][j]);
			counter++;
		}
		rowmax--;
		
		//down2top -- colmin
		for(int i = rowmax ; i >= rowmin ; i--){
			System.out.print(arr[i][colmin]);
			counter++;
		}
		colmin++;
		}
		}

	public static void main(String[] args) {

		// int arr[][] = getArray();
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		spiralClockPrint(arr);

	}

}
