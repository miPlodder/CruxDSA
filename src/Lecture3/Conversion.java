package Lecture3;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Conversion {

	public static int dec2bin(int dec) {

		int bin = 0, pow = 1, temp;

		while (dec != 0) {

			temp = dec % 2;

			bin = bin + (pow * temp);

			pow *= 10;

			dec /= 2;
		}

		return bin;
	}

	public static int dec2any(int num , int dbase) {

		int any = 0 ;
		int temp , pow = 1 ;
		
		while(num != 0){
			
			temp = num % dbase;
			
			any = any + (temp * pow);
			
			num /= dbase ;
			
			pow *= 10 ;
			
		}
		
		return any ;
		
	}

	public static int any2dec(int num , int sbase) {

		int dec = 0, pow = 1, temp;

		while (num != 0) {

			temp = num % 10;

			dec = dec + (pow * temp);

			pow *= sbase;

			num /= 10;
		}

		return dec;
	}

	public static int bin2dec(int bin) {

		int dec = 0, pow = 1, temp;

		while (bin != 0) {

			temp = bin % 10;

			dec = dec + (pow * temp);

			pow *= 2;

			bin /= 10;
		}

		return dec;
	}
	
	public static int any2any(int num , int sbase , int dbase){
		
		int temp = any2dec(num , sbase);
		
		int res = dec2any(temp , dbase);
		
		return res;
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// int dec = sc.nextInt();
		//
		// int bin = dec2bin(dec);
		//
		// System.out.println(bin);
		//
		// int decAgain = bin2dec(bin);
		//
		// System.out.println(decAgain);

		int decAgain = any2any(1011 , 3 , 2);
		System.out.println(decAgain);

	}

}
