package lecture7_Recursion;

import java.util.Scanner;

public class RevisionRecursion {

	public static void increasing(int num){
		
		if(num == 0 ){
			return;
		}
		System.out.println(num);
		increasing(num-1);
		
	}

	public static void reverseArray(int[] arr, int start , int end){
	        
	        //one condition one loop
	        if(start >= end)
	        	return;
	        
	        //working area
			int temp = arr[start-1];
			arr[start-1] = arr[end-1];
			arr[end-1] = temp;
	        reverseArray(arr,start + 1 , end - 1);
	        
	    }

	 	public static void main(String args[]){
		
	 		
	 		Scanner sc = new Scanner(System.in);
	 		int N = sc.nextInt();
	 		int[] arr = new int[N];
	 		for(int i = 0 ; i < N ; i++)
	 			arr[i] = sc.nextInt();
	 		
	 		reverseArray(arr,1,1);
	}
	
	
}
