package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class hashMapUtilClass {

	public static void main(String[] args) {


		Integer[] arr1 = { 1, 1, 2, 2, 2, 4, 5, 6, 6 };
		Integer[] arr2 = { 1, 1, 1, 2, 2, 3, 5, 6, 6, 9 };

		System.out.println(gce1(arr1, arr2));
		System.out.println(gce2(arr1, arr2));

		Integer[] inputForConsSequence = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 3, 4, 5, 6 };
		System.out.println("Consective Sequence -->" + consSequence(inputForConsSequence));
		System.out.print("Max Frequency Word --> "+maxFreqWord(
						"Pandora's box is the the the an artifact in Greek mythology, " + "taken from the myth of Pandora's creation in ..."
						+ " Today the phrase to open Pandora's box means to perform "
						+ "an action that may seem small or innocent, " + "but that turns out to have severely"));
	}

	// highest frequency word in sentence
	public static String maxFreqWord(String paragraph) {

		String[] words = paragraph.split(" ");
		HashMap<String, Integer> map = new HashMap<>();

		for (String word : words) {

			if (map.containsKey(word)) {
				int count = map.get(word);
				count++;
				map.put(word, count);
			} else {
				map.put(word, 1);
			}

		}

		int max = Integer.MIN_VALUE;
		String rv = "";

		for (String word : words) {

			Integer temp = map.get(word);
			if (temp > max) {

				max = temp;
				rv = word;

			}

		}

		return rv;
	}

	// get common element - no duplicates
	public static ArrayList<Integer> gce1(Integer[] arr1, Integer[] arr2) {

		HashMap<Integer, Boolean> table = new HashMap<>();

		// only used when we get keySet in return
		Set<Integer> set = table.keySet();

		ArrayList<Integer> rv = new ArrayList<>();

		for (int val : arr1) {

			if (table.containsKey(val)) {
				// contains, don't do any thing

			} else {

				// dont contain
				table.put(val, true);

			}

		}

		System.out.println(set);

		for (int val : arr2) {

			if (table.containsKey(val)) {

				// remove from hashtable
				rv.add(val);
				table.remove(val);

			}
		}

		return rv;
	}

	// get common element - with duplicates
	public static ArrayList<Integer> gce2(Integer[] arr1, Integer[] arr2) {

		HashMap<Integer, Integer> table = new HashMap<>();
		ArrayList<Integer> rv = new ArrayList<>();

		for (int val : arr1) {

			if (table.containsKey(val)) {

				int count = table.get(val);
				count++;
				table.put(val, count);
				// exists

			} else {
				// dont exists
				table.put(val, 1);

			}

		}

		for (int val : arr2) {

			if (table.containsKey(val)) {

				if (table.get(val) > 0) {

					int count = table.get(val);
					rv.add(val);
					count--;
					table.put(val, count);

				} else {
					// do nothing
				}

			} else {
				// do nothing
			}

		}

		return rv;
	}

	// get longest consecutive sequence
	// input = 2 12 9 16 10 5 3 20 25 11 1 8 6
	// output = 8 9 10 11 12
	// input = 15 13 23 21 19 11 16
	// output = 15 16
	public static ArrayList<Integer> consSequence(Integer[] input) {


		ArrayList<Integer> lseq = new ArrayList<>();

		HashMap<Integer, Boolean> map = new HashMap<>();

		// finding the first in the consecutive sequence
		for (int val : input) {

			map.put(val, true);

			if (map.containsKey(val - 1)) {
				map.put(val, false);
			}
			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}

		}

		System.out.println(map.keySet());

		for (int i = 0; i < input.length; i++) {

			ArrayList<Integer> curr = new ArrayList<>();

			if (map.containsKey(input[i])) {

				int count = 0;
				while (map.containsKey(input[i] + count)) {

					curr.add(input[i] + count);
					count++;

				}

			} else {
				// false middle term
			}

			if (curr.size() > lseq.size()) {

				lseq = curr;

			}

		}

		// parsing the consecutive sequence

		// compare length of rv and temp both below

		return lseq;
	}

}
