package lecture9;

public class sortingByRecursion {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 2, 33, 2, 22, 55, 3, 33 };

		char ch = '6';
		String str;
		/*str.sub*/
		int i = (int)ch - 48;
		System.out.println(i);
		System.out.println(linearSearch(arr, 33, 0));
	}

	public static void swap(int[] arr, int i1, int i2) {

		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;

	}

	public static void bsort(int[] arr, int si, int ei) {

		// basecase
		if (si == ei) {
			return;
		}

		// call downwards -- backtracking
		bsort(arr, si, ei - 1);

		// working here
		for (int i = si; i < ei; i++) {

			if (arr[i] > arr[i + 1]) {
				swap(arr, i, i + 1);
			}

		}

		// call upwards

	}

	public static int linearSearch(int[] arr, int num, int counter) {

		int rv;
		// base
		if (counter == arr.length) {

			return -1;
		}
		// call1

		rv = linearSearch(arr, num, counter + 1);

		// work
		if (arr[counter] == num) {
			// rv = counter;
			return counter;
		}

		// call2
		return rv;
	}

	// problem

	public static int linearSearchFromLastIndex(int[] arr, int num, int counter) {

		int rv;
		// base
		if (counter == arr.length) {

			return -1;
		}
		// call1

		rv = linearSearch(arr, num, counter + 1);

		// work
		if (arr[counter] == num) {

			return counter;
		}

		// call2
		return rv;
	}

	public static void binarySearch(int[] arr,int num)
	{
		
		
	}

}
