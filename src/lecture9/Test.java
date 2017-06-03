package lecture9;

public class Test {

	public static int str2Int(String str) {

		int rv = 0;
		// base
		if (str.length() == 0)
			return 0;

		// call

		// work
		char ch = str.charAt(0);
		String ros = str.substring(1);
		int temp = str2Int(ros);
		int i = ch - 48;
		rv = temp + (i * (int) (Math.pow(10, str.length() - 1)));

		return rv;

	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		System.out.println(str2Int("1234"));

	}
}
