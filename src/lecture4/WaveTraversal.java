package lecture4;

import java.util.Scanner;

public class WaveTraversal {

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

	public static void putArray(int[][] arr) {

	}

	public static void waveRowWisePrint(int[][] arr) {

		for (int row = 0; row < arr.length; row++) {

			if (row % 2 == 0) // even
			{
				for (int col = 0; col < arr[0].length; col++)
					System.out.print(arr[row][col] + ", ");
			} else {
				for (int col = arr[0].length - 1; col >= 0; col--) // decrement
																	// the
																	// column
																	// value
					System.out.print(arr[row][col] + ", ");
			}
		}
		System.out.print("END");
	}

	public static void waveColWisePrint(int[][] arr) {
		
		for (int col = 0; col < arr[0].length; col++) {

			if (col % 2 == 0) // even
			{
				for (int row = 0; row < arr.length; row++)
					System.out.print(arr[row][col] + ", ");
			} else {
				for (int row = arr.length - 1; row >= 0; row--) 
					System.out.print(arr[row][col] + ", ");
			}
		}
		System.out.print("END");
	}

	public static void main(String[] args) {

		int[][] arr;

		arr = getArray();
		waveColWisePrint(arr);
		
	}

}
