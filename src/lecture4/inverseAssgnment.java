package lecture4;

import java.util.Scanner;

public class inverseAssgnment {

	public static int binarySearch(int[] arr, int number) {
		int rv = -1;
		int left = 0;
		int right = arr.length - 1;
		int mid ;

		while (left <= right) {
			
			mid = (left + right) / 2;
			
			if (arr[mid] == number) {

				rv = mid;
				break;
				
			} 
			else if (arr[mid] > number) {

				right = mid - 1;

			}
			else {

				left = mid + 1;

			}

		}
		return rv;
	}

	public static int[] inverse(int[] arr){
		
		int[] rv = new int[arr.length] ;
	
		for(int i = 0 ; i < arr.length ; i ++)
			{
				int temp = arr[i];
				rv[temp] = i;
			}
	
		return rv ;
	}
	
	public static boolean isMirror(int[] arr, int[] inv){
		boolean b = true;
		
		for(int i = 0 ; i < arr.length ; i++)
			{
				if(arr[i] != inv[i]){
					b = false;
					break;
				}
			}
		return b ;
		
	}
	
	public static void main(String[] args) {

		System.out.println("Enter length of array");
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0 ; i < n ; i ++)
			arr[i] = sc.nextInt();
		
		int[] inv = inverse(arr);
		
//		maxInArray.displayArr(inv);
//		maxInArray.displayArr(arr);
		
		for(int i = 0 ; i < n ; i ++){
			System.out.print(inv[i]+" ");
			 
		}
		System.out.println(isMirror(arr,inv));
	}

}
