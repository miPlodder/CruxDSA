package Introduction;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int row = 1;
		int col;

		while (row <= N) {

			col = 1;

			// printing numbers
			while (col <= row) {

				if (col == 1 || col == row)
					System.out.print(row);
				else
					System.out.print("0");
				col++;
			}
			System.out.println("\t");
			row++;
		}
		sc.close();
	 }
}
