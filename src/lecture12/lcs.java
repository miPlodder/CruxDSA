//largest common subset
package lecture12;

public class lcs {

	public static int lcsWithRecursion(String str1, String str2) {

		int rv;

		if (str1.length() == 0 || str2.length() == 0)
			return 0;

		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(0);
		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);

		if (ch1 == ch2) {

			rv = 1 + lcsWithRecursion(ros1, ros2);

		}

		else {

			int f1 = lcsWithRecursion(str1, ros2);
			int f2 = lcsWithRecursion(ros1, str2);
			rv = Math.max(f1, f2);

		}

		return rv;
	}

	public static int lcsRecursionPractice(String str1, String str2) {

		if (str1.length() == 0 || str2.length() == 0) {

			return 0;

		}

		int rv = 0;
		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(0);
		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);

		if (ch1 == ch2) {

			rv = 1 + lcsRecursionPractice(ros1, ros2);

		} else {

			int val1 = lcsRecursionPractice(str1, ros2);
			int val2 = lcsRecursionPractice(ros1, str2);

			rv = Math.max(val1, val2);
		}

		return rv;
	}

	public static int lcsWithIterative(String str1, String str2, int[][] arr) {

		for (int i = 0; i <= str1.length(); i++) {

			for (int j = 0; j <= str2.length(); j++) {

				if (i == 0 || j == 0) {

					arr[0][0] = 0;
					continue;

				} else {

					if (str1.charAt(i-1) == str2.charAt(j-1)) {

						arr[i][j] = 1 + arr[i - 1][j - 1];

					} else {

						int val1 = arr[i - 1][j];
						int val2 = arr[i][j - 1];

						arr[i][j] = Math.max(val1, val2);

					}

				}

			}

		}

		return arr[str1.length() - 1][str2.length() - 1 ];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lcsRecursionPractice("abc", "bcd"));
		System.out.println(lcsWithRecursion("abc", "bcd"));
		System.out.println(lcsWithIterative("abc", "bcd", new int[4][4]));
	}

}
