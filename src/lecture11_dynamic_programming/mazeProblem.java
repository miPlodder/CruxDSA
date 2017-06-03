//In Iteration we are just filling our array from the last element

package lecture11_dynamic_programming;

public class mazeProblem {

	public static int mazeProblem(int cr, int cc, int er, int ec) {

		int rv;
		// +ve testcase // my destination
		if (cr == er && cc == ec)
			return 1;

		// -ve testcase
		if (cr > er || cc > ec)
			return 0;

		rv = mazeProblem(cr + 1, cc, er, ec) + mazeProblem(cr, cc + 1, er, ec);

		return rv;
	}

	public static int mazeProblemDynamicProgRecursion(int cr, int cc, int er, int ec, int[][] storage) {

		int rv;
		// +ve testcase // my destination
		if (cr == er && cc == ec)
			return 1;

		// -ve testcase
		if (cr > er || cc > ec)
			return 0;

		// base case to use array
		if (storage[cr][cc] != 0) {

			return storage[cr][cc];

		}

		rv = mazeProblemDynamicProgRecursion(cr + 1, cc, er, ec, storage)
				+ mazeProblemDynamicProgRecursion(cr, cc + 1, er, ec, storage);

		storage[cr][cc] = rv;
		// store this value

		return rv;
	}

	public static int mazeProblemIterative(int er, int ec) {

		int rv = 0;

		int[][] storage = new int[er + 1][ec + 1];

		storage[er][ec] = 1;

		for (int i = er; i >= 0; i--) {

			for (int j = ec; j >= 0; j--) {

				if ((i + 1) > er || (j + 1) > ec)
					storage[i][j] = 1;

				else {
					storage[i][j] = storage[i + 1][j] + storage[i][j + 1];
				}

			}

		}

		return storage[0][0];
	}

	public static int mazeProblemBest(int row, int col) {

		int[] storage = new int[col + 1];

		// initialise
		for (int i = 0; i < storage.length; i++) {

			storage[i] = 1;

		}

		for (int i = row - 1; i >= 0; i--) {
			for (int j = col; j >= 0; j--) {

				if (j == col) {
					storage[j] = 1;
				} else {

					storage[j] = storage[j] + storage[j+1];

				}
			}
		}

		return storage[0];
	}

	public static void main(String[] args) {

		System.out.println(mazeProblem(0, 0, 3, 3));
		System.out.println(mazeProblemDynamicProgRecursion(0, 0, 3, 3, new int[4][4]));
		System.out.println(mazeProblemIterative(3, 3));
		System.out.println(mazeProblemBest(3,3));
	}

}
