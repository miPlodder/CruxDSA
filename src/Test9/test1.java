package Test9;

import java.util.*;

public class test1 {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from Scanner.Call the recursive
		 * function here Your class should be named Solution.
		 */
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(countTwins(str));

	}

	public static int countTwins(String str) {
		/* Enter the code here and do not forget the base case */

		if (str.length() == 2)
			return 0;

		
		String temp = str.substring(0, 3);
		char ch1 = temp.charAt(0);
		char ch2 = temp.charAt(2);
		
		String ros = str.substring(1);
		
		int rv = countTwins(ros);
		
		if (ch1 == ch2)
			rv++;

		return rv;
	}

}
