package lecture5;

import java.util.Scanner;

public class TargetSumPairs {

	public static void printPairs(int[] arr, int target){
		
		int i = 0 , j ;
		
		while(i < arr.length){
			
			j = i + 1;
			
			while(j < arr.length)
			{
				
				int temp = arr[i] + arr[j];
				if(target == temp)
					System.out.println(arr[i]+" and "+arr[j]);
				
				
				j++;
			}
			
			i++;
		}
		
	}
	
	public static void main(String[] args) {
		/*
		//arr len
		int arr[];
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		
		//arr elements
		arr = new int[length];
		
		for(int i = 0 ; i < arr.length ; i++)
			arr[i] = sc.nextInt();
		
		//target
		int target = sc.nextInt();
*/
	
		int length = 5 ;
		int[] arr = {1,2,3,4,5};
		int target = 2 ;
		
		printPairs(arr,target);
	}

}
