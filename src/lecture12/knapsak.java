package lecture12;

public class knapsak {

	public static int knapSack(int[] val, int[] wts, int capacity, int si, int vsf) {

		if (capacity < 0)
			return 0;

		if (si == wts.length) {
			return vsf;
		}

		int rv = 0;
		int f1, f2;

		f1 = knapSack(val, wts, capacity, si + 1, vsf);
		f2 = knapSack(val, wts, capacity - wts[si], si + 1, vsf + val[si]);

		return Math.max(f1, f2);
	}

	public static int knapSackSubset(int[] val, int[] wts, int capacity, int si, int vsf) {

		if (capacity <= 0)
			return 0;

		if (si == wts.length) {
			return vsf;
		}

		int rv = 0;
		int f1, f2;

		f1 = knapSack(val, wts, capacity, si + 1, vsf);
		f2 = knapSack(val, wts, capacity - wts[si], si + 1, vsf + val[si]);

		return Math.max(f1, f2);

	}

	public static int knapSackOptmised(int[] val, int[] wts, int capacity, int si, int vsf, int[][] storage) {

		if (capacity <= 0)
			return 0;

		if (si == wts.length) {
			return vsf;
		}

		if (storage[si][capacity] != 0) {

			return storage[si][capacity];

		}

		int rv = 0;
		int f1, f2;

		f1 = knapSackOptmised(val, wts, capacity, si + 1, vsf, storage);
		f2 = knapSackOptmised(val, wts, capacity - wts[si], si + 1, vsf + val[si], storage);

		storage[si][capacity] = Math.max(f1, f2);

		return Math.max(f1, f2);

	}

	public static void main(String[] args) {

		int[] val = { 10, 8, 12, 6, 14 };
		int[] wts = { 8, 6, 10, 5, 10 };
		int capacity = 30;

		System.out.println(knapSack(val, wts, capacity, 0, 0));

		System.out.println(knapSackOptmised(val, wts, capacity, 0, 0, new int[val.length + 1][capacity + 1]));
	}

}
