package lecture6;

import java.util.ArrayList;

public class ArrayListQuestion {

	// RECURSION = ITERACTION + STACK CONCEPT

	public static void printSubsequence(String str) {

		ArrayList<String> al = new ArrayList<String>();
		String temp;

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				str.substring(i, j);
			}
		}
		System.out.println();

	}

	public static ArrayList<Integer> getIntersection(int[] arr1, int[] arr2) {

		ArrayList<Integer> rv = new ArrayList<>();

		// work space

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {

				if (arr1[i] == arr2[j]) {
					rv.add(arr1[i]);
					arr2[j] = -1;
					break;
				}

			}
		}

		// workspace

		return rv;
	}

	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<>();
		System.out.print(al);
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 5, 6 };
		al = getIntersection(arr1, arr2);
	}

}
