package genericsHashMap;

import java.util.HashMap;

public class hashMapClient {

	// make numbers equal in an array
	public static int equalize(Integer[] arr) throws Exception {

		int rv = 0;
		int min = Integer.MAX_VALUE;

		hashMap<Integer, Integer> table = new hashMap<>(5);

		table.put(0, 0);
		table.put(1, 0);
		table.put(2, 0);
		table.put(3, 0);
		table.put(4, 0);

		// finding the min

		for (int val : arr) {

			if (val < min) {

				min = val;

			}

		}

		// bring in range
		for (int i = 0; i < arr.length; i++) {

			int item = arr[i] - min;
			rv += item / 5;
			table.put(item % 5, table.get(item % 5) + 1);

		}

		// find 3 cost (using frequency)
		int cost0 = table.get(0) * 0 + table.get(1) * 1 + table.get(2) * 1 + table.get(3) * 2 + table.get(4) * 2;
		int cost1 = table.get(0) * 1 + table.get(1) * 1 + table.get(2) * 2 + table.get(3) * 2 + table.get(4) * 1;
		int cost2 = table.get(0) * 1 + table.get(1) * 2 + table.get(2) * 2 + table.get(3) * 1 + table.get(4) * 2;

		// return minimum cost
		rv += Math.min(cost0, Math.min(cost1, cost2));

		return rv;
	}

	// not perfect code
	public static int makeNumSame(int[] arr) {

		int minStep = 0;

		for (int i = 0; i < arr.length; i++) {

			int counter = 0;

			while (arr[i] != 0) {

				if ((arr[i] % 5) == 0) {

					arr[i] = arr[i] - 5;

				} else if ((arr[i] % 5) == 2) {

					arr[i] = arr[i] - 2;

				} else {

					arr[i] = arr[i] - 1;

				}

				counter++;
			}

			// if (counter < minStep) {

			minStep += counter;

			// }

		}

		return minStep;
	}

	public static void main(String[] args) throws Exception {

		hashMap<String, Integer> table = new hashMap<>(4);

		table.put("I", 10);
		table.display();

		table.put("P", 20);
		table.display();

		table.put("US", 30);
		table.display();

		table.put("UK", 40);
		table.display();

		table.put("Uto", 50);
		table.display();

		table.put("Aus", 60);
		table.display();

		table.put("B", 70);
		table.display();

		table.put("R", 80);
		table.display();

		System.out.println("\nSize = " + table.getSize() + "\n");

		table.put("I", 110);
		table.display();

		table.remove("I");
		table.display();

		table.put("NZ", 100);
		table.display();

		// ?----------------------------------------------------------------------problem
		// here after crossing the threshold

		table.put("I", 110);
		table.display();

		table.put("I", 210);
		table.display();

		table.put("V", 110);
		table.display();

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		Integer[] arr = { 1, 5, 5, 10, 10 };
		System.out.println(equalize(arr));

	}

}
