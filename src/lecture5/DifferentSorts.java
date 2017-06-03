package lecture5;

import java.util.Scanner;

public class DifferentSorts {

	public static int[] getArray(int num) {

		Scanner s = new Scanner(System.in);

		int[] arr = new int[num];

		for (int i = 0; i < num; i++)
			arr[i] = s.nextInt();
		s.close();
		return arr;
		
	}

	public static void displayArray(int[] arr) {

		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i] + " ");

	}

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

	public static void selectionSort(int arr[]) {

		int counter = 1;

		while (counter < arr.length) {

			for (int i = counter; i <= arr.length - 1; i++)

			{
				if (arr[counter - 1] > arr[i]) {
					int temp = arr[counter - 1];
					arr[counter - 1] = arr[i];
					arr[i] = temp;
				}
			}

			counter++;
		}

	}

	public static void insertionSort(int arr[]) {

		int counter = 1;
		while (counter < arr.length) {

			for (int i = counter; i > 0; i--) {

				if (arr[i] < arr[i - 1]) {
					int temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
				} else {
					break;
				}

			}

			counter++;
		}

	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int[] arr = getArray(num);
		insertionSort(arr);
		displayArray(arr);

	}

}
