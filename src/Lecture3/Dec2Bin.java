package Lecture3;

import java.util.Scanner;

public class Dec2Bin {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int dec = sc.nextInt();
		int bin = 0 ;
		int temp;
		int pow = 1;

		while (dec != 0) {

			temp = dec % 2 ;
			
			bin = (bin + (temp * pow));
			
			pow = pow * 10 ;
			
			dec = dec / 2 ;
		
		}

		System.out.println(bin);
	}

}