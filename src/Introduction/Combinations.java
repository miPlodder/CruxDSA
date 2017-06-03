package Introduction;

import java.util.Scanner;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// variables
		int row = 0, comb;

		while (row < N) {

			comb = 1 ;
			
			int col = 0;

			while (col <= row) {

				if (col == 0 || col == row ) {
					System.out.print(1 + "\t");
				} else {
					comb = (comb * (row - col + 1)) / col;
					System.out.print(comb + "\t");
				}

				col++;
			}
			System.out.println();
			row++;
		}

	}

}
