package Lecture3;

import java.util.Scanner;

public class F2C {

	public static void main(String args[]) {

		int Fmax, Fmin, steps;
		Scanner sc= new Scanner(System.in);

		Fmin = sc.nextInt();
		Fmax = sc.nextInt();
		steps = sc.nextInt();
		int F = Fmin;

		while (F <= Fmax) {
			
			double c = ((5 * (F - 32)) / 9);
			System.out.println(F + "\t" + c);
			F = F + steps;
		}

	}
}
