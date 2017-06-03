package lecture7_Recursion;

import java.util.*;

public class Test {
	
			
		public static void printTriplet(int[] arr, int target){
			
			
			int i = 0 , length = arr.length ;
			
			while(i < length - 2)
			{
				int j = i + 1;
				while(j < length - 1){
					int k = j + 1;
					while(k < length ){
						int temp = arr[i] + arr[j] + arr[k];
						if(temp == target)
							System.out.println(arr[i]+", "+arr[j]+" and "+arr[k]);
						k++;
					}
					j++;
				}
				
				i++;
			}
			
		}
		
		public static void main(String[] args) {
			
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

		
			
			printTriplet(arr,target);
		}

	


	}

