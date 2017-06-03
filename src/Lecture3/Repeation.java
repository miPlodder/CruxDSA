package Lecture3;

import java.util.Scanner;

public class Repeation {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();
		int digit = scn.nextInt();

		System.out.println(countDigit(N, digit));

	}

	public static int countDigit(int num, int digit) {
		int retVal = 0;
		int temp;;
		
		/* Start your code here */

		while (num != 0) {

			temp = num % 10;

			if (temp == digit)
				retVal++;

			num /= 10;

		}

		/* End your code here */

		return retVal;
	}

}
