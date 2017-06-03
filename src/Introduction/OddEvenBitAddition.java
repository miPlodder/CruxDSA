package Introduction;

import java.util.Scanner;

public class OddEvenBitAddition {

	public static void main(String args[]) {

		int odd = 0;
		int even = 0;
		int temp;
		int counter = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int num = sc.nextInt();

		while (num > 0) {

			temp = num % 10;
			counter++;

			if (counter % 2 == 0)
				even = even + temp;
			else
				odd = odd + temp;

			num = num / 10;
		}
		
		System.out.println("Even Digits Value "+even);
		System.out.println("Odd Digits Value "+odd);
	}
}
