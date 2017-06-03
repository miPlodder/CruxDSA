package Introduction;

import java.util.Scanner;

public class PatternIncDec {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		//variables
		int x = 0 ; 
		
		int space = N - 1 ;
		
		N = (2 * N) - 1 ;
		
		int row = 1;
			
		int fincre = 1 ;
		int ldecre = 0 ;
		
		int condn = (N+1)/2 ;
		
		//logic
		
		int val = 0 ;
		
		while( row <= N ){
			int col = 1 ;
			
			//decre spacing
			while(col <= space ){
				
				System.out.print("\t");
				col++;
				
			}
			
			//asterick
			col = 1 ; 
			val += x ;
			
			while(col <= fincre){
				
				val ++ ;
				System.out.print(val + "\t");
				col++;
				
			
			}
			
			//incre spacing
			col = 1 ;
			while(col <= ldecre){
				
				val -- ;
				System.out.print(val+"\t");
				col++;
				
			}
			
			if(row < condn ){
				
				
				fincre ++ ;
				ldecre ++ ;
				space-- ;
				
			}
			
			else {
				
				x = -2 ;
				fincre -- ;
				ldecre -- ;				
				space ++ ;
			}
			
		System.out.println();	
		row++;	
		}
		
	}
}
