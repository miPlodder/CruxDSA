package HeapDSGeneric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import lecture10_Completies.mergeSort;

public class heapQuestion {

	// print k largest items in n items array
	public ArrayList<Integer> giveKlargest(ArrayList<Integer> al) {

		return null;
	}

	// merge n sorted arrays
	public static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> lists) {

		ArrayList<Integer> rv = new ArrayList<>();
		Heap<Pair> heap = new Heap<>();

		for (int i = 0; i < lists.size(); i++) {

			Pair p = new Pair();
			p.li = i;
			p.di = 0;
			p.data = lists.get(p.li).get(p.di);
			heap.add(p);

		}

		while (!heap.isEmpty()) {

			Pair rem = heap.removeHP();
			rv.add(rem.data);
			rem.di++;
			if (rem.di < lists.get(rem.li).size()) {
				rem.data = lists.get(rem.li).get(rem.di);
				heap.add(rem);
			}

		}

		// Heap<ArrayList<Integer>>[] heap = new Heap[index];
		return rv;
	}

	public static class Pair implements Comparable<Pair> {

		// di - data index //li - list index
		int di;
		int li;
		int data;

		@Override
		public int compareTo(Pair other) {

			return other.data - this.data;

		}

	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		al.add(new ArrayList<>(Arrays.asList(10, 20, 30, 40)));
		al.add(new ArrayList<>(Arrays.asList(11, 17, 45, 55)));
		al.add(new ArrayList<>(Arrays.asList(12, 22, 28, 138)));
		al.add(new ArrayList<>(Arrays.asList(9, 16, 23, 27)));

		System.out.println(merge(al));

	}
}