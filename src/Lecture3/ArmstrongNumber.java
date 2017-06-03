package Lecture3;

import java.util.Scanner;

public class ArmstrongNumber {

	public static int length(int num) {

		int len = 0;
		while (num != 0) {

			num /= 10;
			len++;

		}

		return len;
	}

	public static boolean isArmstrong(int num) {

		boolean rv = false;

		int len = length(num);

		// System.out.println(len);

		int sum = 0, temp;

		int dummy = num;

		while (dummy != 0) {

			temp = dummy % 10;

			// System.out.println((int)((Math.pow(temp, len))));

			sum = sum + (int) ((Math.pow(temp, len)));

			dummy /= 10;
		}

		System.out.println(sum+"left"+num);

		if (sum == num)
			rv = true;
		return rv;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		
		int lowerLimit = sc.nextInt();
		int upperLimit = sc.nextInt();
		
		while (upperLimit != lowerLimit) {

			if (isArmstrong(lowerLimit))
				System.out.println(lowerLimit+"right");

			lowerLimit++;
		}

	}
}