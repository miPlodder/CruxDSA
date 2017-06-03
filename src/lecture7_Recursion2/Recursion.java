package lecture7_Recursion2;

import java.util.ArrayList;

public class Recursion {

	public static ArrayList<String> getSS(String str) {

		ArrayList<String> resArray = new ArrayList<>();

		// base case
		if (str.length() == 0) {
			resArray.add("");
			return resArray;
		}

		// code here

		char ch = str.charAt(0);
		String ros = str.substring(1);

		resArray = getSS(ros);

		int constant = resArray.size();
		for (int i = 0; i < constant; i++) {
			// resArray.ad
			resArray.add(resArray.size(), resArray.get(i) + ch);
		}

		return resArray;
	}

	// problem
	public static ArrayList<String> getSSWithAscii(String str) {

		ArrayList<String> resArray = new ArrayList<>();

		// base case
		if (str.length() == 0) {
			resArray.add("");
			return resArray;
		}

		// code here

		char ch = str.charAt(0);
		String ros = str.substring(1);

		resArray = getSSWithAscii(ros);

		int constant = resArray.size();

		for (int i = 0; i < constant; i++) {
			// resArray.ad
			resArray.add(resArray.size(), ch + resArray.get(i));
			resArray.add(resArray.size(), (int) ch + resArray.get(i));
			// System.out.println((int)ch);
		}

		return resArray;
	}

	public static ArrayList<String> permutation(String str) {

		ArrayList<String> resArray = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();

		// base case
		if (str.length() == 1) {
			resArray.add(str);
			return resArray;
		}

		// code here

		char ch = str.charAt(0);
		String ros = str.substring(1);

		resArray = permutation(ros);

		int constant = resArray.size();

		for (int i = 0; i < constant; i++) {
			String temp = resArray.get(i);

			for (int j = 0; j <= temp.length(); j++) {

				String temp1 = temp.substring(0, j);
				String temp2 = temp.substring(j);
				result.add(temp1 + ch + temp2);
			}
		}

		return result;

	}

	public static ArrayList<String> keypad(String number) {

		ArrayList<String> tempArray = new ArrayList<>();

		// bc 1
		if (number.length() == 0) {
			tempArray.add("");
			return tempArray;
		}

		// OUTPUT ARRAY

		ArrayList<String> myResult = new ArrayList<>();

		// call and variables change
		int len = number.length() - 1;
		char parameter = number.charAt(len); // last
		String subString = number.substring(0, len);

		tempArray = keypad(subString);

		// work
		String letters = getCode(parameter);

		for (int i = 0; i < letters.length(); i++) {

			char var = letters.charAt(i);

			for (int j = 0; j < tempArray.size(); j++) {

				String add = tempArray.get(j) + var;
				myResult.add(add);

			}

		}

		return myResult;

	}

	public static String getCode(char ch) {

		String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz" };
		return codes[ch - '0'];

	}

	public static ArrayList<String> ladder(int end, int current) {

		// base
		if (current == end) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;

		}
		if (current > end) {
			ArrayList<String> baseResult = new ArrayList<>();
			return baseResult;

		}

		ArrayList<String> myResult = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> recResult = ladder(end, current + dice);

			for (int i = 0; i < recResult.size(); i++) {
				myResult.add(recResult.get(i) + dice);
			}

		}

		return myResult;
	}

	public static void main(String[] args) {

		// System.out.print(getSS("abc"));
		// System.out.println(getSSWithAscii("abc"));
		// System.out.println(permutation("abcd").size());
		// System.out.println(keypad("123").size());

		System.out.print(ladder(12, 0));
	}

}
