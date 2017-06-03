package Lecture3;
import java.lang.*;

public class uniqueReverse {

	public static int newNum(int number) {
		
		int rv = 0 ,temp ;
		int counter = 0;
		int pow = 0 ;
		while(number != 0){
			
			counter ++ ;
			temp = number % 10 ; 
			
			pow = (int)(Math.pow(10,temp - 1 ));
			
			rv = rv + pow * counter ;
			
			number /= 10;
		}
		
		return rv;
	}
	
	public static void main(String[] args) {
		
		System.out.println(newNum(32145));

	}

}
