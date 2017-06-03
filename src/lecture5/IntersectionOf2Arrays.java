package lecture5;

import java.util.Scanner;

public class IntersectionOf2Arrays {
	
	public static void bubbleSort(int[] arr) {

		int counter = 1;

		while (counter < arr.length) {

			for (int i = 0; i < arr.length - counter; i++) {

				if (arr[i] > arr[i + 1]) {

					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}

			}
			counter++;
		}

	}

	public static int[] intersectionArrays(int[] arr1 , int[] arr2){
		
		int[] temp , rv ;
		int length = arr1.length;
		
		int i = 0 , j , counter = 0;
		//anonymous block starts
		{
		temp = new int[length];
		
		counter = 0 ;
		while(i < length){
			
			
			j = 0 ;
			while(j < length){
				if(arr1[i] == arr2[j]){
					temp[counter] = arr1[i];
					arr2[j] = Integer.MIN_VALUE;
					counter++;
					break;
				}
				
				j++;
			}
			i++;		
		}
		}
		//anonymous block ends
		
		rv = new int[counter];
		
		for(i = 0 ; i < counter ; i++)
			rv[i] = temp[i];
		
		return rv;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] arr1 = new int[length];
		int[] arr2 = new int[length];
		
		for(int i = 0 ; i < length ; i++)
			arr1[i] = sc.nextInt();
		
		for(int i = 0 ; i < length ; i++)
			arr2[i] = sc.nextInt();
		
		/*int[] arr1 = {1,2,3,1,2,4,1};
		int[] arr2 = {2,1,3,1,5,2,2};*/
		
		int[] intersection = intersectionArrays(arr1,arr2);
		
		bubbleSort(intersection);
		System.out.print("[");
		for(int i = 0 ; i < intersection.length ; i ++)
			{
			System.out.print(intersection[i]);
			if(i !=intersection.length - 1)
				System.out.print(", ");
				
			}
		System.out.print("]");
	}

}
