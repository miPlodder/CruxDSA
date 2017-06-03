package Introduction;

import java.util.Scanner;

public class PrintAllPrimes {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter N");
		int N = sc.nextInt();

		int incre;
		int num = 2;
		boolean flag;

		while (num <= N) {

			flag = true;
			incre = 2;

			while (incre < num) {

				if (num % incre == 0) {
					flag = false;
					break;
				}
				incre++;
			}
			
			if (flag == true)
				System.out.println(num);

			num++;
		}

		sc.close();

	}
}
