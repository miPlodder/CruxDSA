//Math.pow(2,arr.length) -- gives double

package lecture5;

import java.util.Scanner;

public class SubsetOfSet {

	public static Scanner s = new Scanner(System.in);
	
	public static void getSubset(int[] arr){
		
		int counter = 0 ;
		
		double pow = Math.pow(2, arr.length);
		
		int rem = 1 ;		
		
		while(counter < pow ){
		
			int index = 0 ;
			
			int ic = counter;
			
			while(ic != 0){
			
			rem = ic % 2 ;
			
			if(rem == 1)
				System.out.print(arr[index]+", ");
			
			ic /= 2 ;
			index++ ;
		
		}
			
		System.out.println("END");
		
		counter++;
		}
			
}
	
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int[] arr = lecture5.DifferentSorts.getArray(num);
		
		lecture5.SubsetOfSet.getSubset(arr);	
	
		//lecture5.DifferentSorts.displayArray(arr);
	}

}
