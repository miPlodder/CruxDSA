package Lecture3;

import java.util.Scanner;

public class Lcm {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println(lcm(a, b));

	}

	public static int lcm(int a, int b) {

		int hcf = gcd(a, b);
		int rv = (a * b) / hcf;

		return rv;

	}

	public static int gcd(int div, int divd) {

		int rem = 1;

		while( rem != 0 ){
			
			int temp = div ;
			
			rem = divd % div ; 
			div = rem ;//dividend
			divd = temp;//divisor
			
		}
		
		return divd;

	}

}