package lecture10_Completies;

public class mergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 1, 3, 2, 7, 5 };
		// int[] arr2 = { 4, 5, 6 };
		// int[] arr3 = new int[arr1.length + arr2.length];
		//
		// merge(arr1, arr2);
		/*arr1 = mergeSort(arr1, 0, 4);
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}*/
		quickSort(arr1, 0, arr1.length - 1);
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);}
	}

	public static int[] merge(int[] arr1, int[] arr2) {

		int i = 0, j = 0, k = 0;

		int[] arr3 = new int[arr1.length + arr2.length];

		while (i < arr1.length && j < arr2.length) {

			if (arr1[i] < arr2[j]) {

				arr3[k] = arr1[i];
				k++;
				i++;
			}

			// arr j is smaller
			else {

				arr3[k] = arr2[j];
				j++;
				k++;

			}

		}

		while (i < arr1.length) {
			arr3[k] = arr1[i];
			k++;
			i++;
		}

		while (j < arr2.length) {

			arr3[k] = arr2[j];
			k++;
			j++;

		}
		return arr3;
	}
	
public static void swap(int[] arr,int i1,int i2){
		
		int temp =arr[i1] ;
		arr[i1] = arr[i2] ;
		arr[i2] = temp ;
		
	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {

		// base condition
		int[] rv;

		if (lo == hi) {
			rv = new int[1];

			rv[0] = arr[lo];

			return rv;

		}

		// work here
		int mid = (lo + hi) / 2;

		int[] fhalf = mergeSort(arr, lo, mid);
		int[] shalf = mergeSort(arr, mid + 1, hi);
		rv = merge(fhalf, shalf);

		return rv;
	}

	public static void quickSort(int[] arr,int lo, int hi){
		
		//base case
		if(lo >= hi){
			
			
			
		}
		
		
		
		int left = lo ;
		int right = hi ;
		int mid = (lo+hi)/2;
		
		int pivot = arr[mid];
		
		while(left <= right){
			
			while(arr[left] <= pivot){
				
				left++;
			}
			
			
			while(arr[right]>=pivot){
				
				right--;
			}
			
			
			if(left<=right){
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		
		
		//calls
		quickSort(arr, lo, right);
		quickSort(arr, left, hi);
	}
}
