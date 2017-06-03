package Introduction;

import java.util.Scanner;

public class FibonnaciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int fn = 0;
		int sn = 1;
		int sum = 0;
		
		while(sum <= N+1){
						
			System.out.println(fn);
			sum = fn + sn ;
			fn = sn ;
			sn = sum;
			
		}
	}

}
