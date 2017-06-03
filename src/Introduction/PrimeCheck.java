package Introduction;

import java.util.Scanner;

public class PrimeCheck {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		int num;
		System.out.println("Enter number");
		num = input.nextInt();

		int i = 2;
		while (i < num) {

			if (num % i == 0) {
				System.out.println("Not a Prime Numeber");
				return;
			}
			i++;
		}
		
		System.out.println("Prime Number");
		input.close();
	}
}
