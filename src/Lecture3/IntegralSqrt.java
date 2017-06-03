package Lecture3;

import java.util.Scanner;

public class IntegralSqrt {

	public static int IntegralSqrtCheck(int N){
		int i = 1;
		boolean bool = true;
		//int temp ;
		
		while(bool){
			
			int temp = N - ( i * i ) ;
			if(temp < 0)
			{
				break ;
				
			}
			i++;
		}
		
		
		return i-1 ;
	}
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		System.out.println(IntegralSqrtCheck(N));

	}

}
