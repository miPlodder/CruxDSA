package lecture5;

import java.util.Scanner;

public class SumOf2Array {

	public static int[] calculateSum(int[] arr1, int[] arr2) {

		int[] rv = null;
		int maxlen, minlen, diff;
		if (arr1.length > arr2.length) {

			maxlen = arr1.length;
			minlen = arr2.length;
			diff = maxlen - minlen;
			rv = new int[maxlen + 1];
			int carry = 0, temp = 0;

			for (int i = maxlen - 1; i >= -1; i--) {
				if ((i - 1) >= 0) {
					temp = (arr1[i] + arr2[i - diff] + carry);
					rv[i + 1] = temp % 10;
					carry = temp / 10;
				} else if (i == 0) {
					temp = (arr1[i] + carry);
					rv[i + 1] = temp % 10;
					carry = temp / 10;
				} else {
					rv[i + 1] = carry;
				}
			}
		}

		else if(arr1.length < arr2.length){

			maxlen = arr2.length;
			minlen = arr1.length;
			diff = maxlen - minlen;
			rv = new int[maxlen + 1];
			int carry = 0, temp = 0;

			for (int i = maxlen - 1; i >= -1; i--) {
				if ((i - 1) >= 0) {
					temp = (arr2[i] + arr1[i - diff] + carry);
					rv[i + 1] = temp % 10;
					carry = temp / 10;
				} else if (i == 0) {
					temp = (arr2[i] + carry);
					rv[i + 1] = temp % 10;
					carry = temp / 10;
				} else {
					rv[i + 1] = carry;
				}
			}
		}
		
		else{
			
			maxlen = arr1.length ;
			rv = new int[maxlen + 1];
			int carry = 0, temp = 0;

			for (int i = maxlen - 1; i >= -1; i--) {
				if (i >= 0) {
					temp = (arr2[i] + arr1[i] + carry);
					rv[i + 1] = temp % 10;
					carry = temp / 10;
				} 
					
				else {
					rv[i + 1] = carry;
				}
			}
			
		}

		return rv;
	}

	public static void main(String[] args) {

		//int[] arr1, arr2;

		Scanner sc = new Scanner(System.in);

		/*int len1 = sc.nextInt();
		arr1 = new int[len1];
		for (int i = 0; i < len1; i++)
			arr1[i] = sc.nextInt();

		int len2 = sc.nextInt();
		arr2 = new int[len2];
		for (int i = 0; i < len2; i++)
			arr2[i] = sc.nextInt();*/
		
		
		int[] arr1 = {1,2,3};
		int[] arr2 = {2,3,4};
		int[] sum = calculateSum(arr1, arr2);
		for (int i = 0; i < sum.length; i++)
			System.out.println(sum[i]);

	}

}
