package lecture4;

import java.util.Scanner;

public class maxInArray {

	public static Scanner scn = new Scanner(System.in);
	
	public static int[] getArr(){
		
		int[] rv = null ;
		
		System.out.println("Enter length of array");
		

		int n = scn.nextInt();
		rv = new int[n];
		
		for(int i = 0 ; i < n ; i++)
			rv[i] = scn.nextInt();
		
		return rv;
	}
	
	public static void displayArr(int[] arr){
		
		for(int val:arr)
			System.out.print(val+" ");		
	}
	
	public static int max(int[] arr){
		
		int m = Integer.MIN_VALUE ;
		for(int val:arr){
			
			if(val > m)
				m = val ;
			
			}
		return m;
	}
	
	public static int linearSearch(int arr[], int num){
		
		int index = -1 ,counter ;
		
		for(int i = 0 ; i < arr.length ; i ++)
		{
			if(arr[i] == num)
				{
				index = i ;
				break;
				}
			else
				continue;
		}
		
		return index;
	}
	
	public static void reverse(int arr[]){
		
		int len = arr.length;
		int mid = (len/2 - 1);
		int temp ;
		for(int i = 0 ; i <= mid ; i++){
			
			temp = arr[i] ;
			arr[i] = arr[len - i - 1];
			arr[len - i - 1] = temp ;
			
		}
		
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = getArr();
		displayArr(arr);
		System.out.println("Maximum value "+max(arr));
		System.out.println(linearSearch(arr,2));
		reverse(arr);
		displayArr(arr);
	}

}