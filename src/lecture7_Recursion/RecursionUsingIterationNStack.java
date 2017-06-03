//When we remove any index from ArrayList or StringBuilder, those functions return the the values of that removed index which we can store and use; 

package lecture7_Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionUsingIterationNStack {

	public static ArrayList<String> getSS(String str) {

		ArrayList<String> rv = new ArrayList<>();

		ArrayList<String[]> solver = new ArrayList<>();

		String[] init = { str, "" };

		solver.add(init);

		while (!solver.isEmpty()) { // solver not empty

			String[] sa = solver.remove(solver.size() - 1);

			if (sa[0].length() > 0) {

				// fc - firstCharacter , ros - restOfString

				String fc = sa[0].substring(0, 1);
				String ros = sa[0].substring(1);

				String[] posDa = { ros, sa[1] + fc };
				String[] negDa = { ros, sa[1] + "" };

				solver.add(posDa);
				solver.add(negDa);
			}

			else {

				rv.add(sa[1]);

			}

		}

		return rv;
	}

	// mine
	public static ArrayList<String> getSubset(String str) {

		ArrayList<String> rv = new ArrayList<>();

		ArrayList<String[]> stack = new ArrayList<>();

		String[] array = { str, "" };

		stack.add(array);

		while (!stack.isEmpty()) {

			// removing top from the stack
			String[] temp = stack.remove(stack.size() - 1);

			// question(0th index) is not empty

			// String cannot be compared normally, but with // equals("")
			// function
			if (!temp[0].equals("")) {

				// if(temp[0].length() > 0 ){

				String fc = temp[0].substring(0, 1);
				String restString = temp[0].substring(1);

				String[] s1 = { restString, temp[1] + fc };
				String[] s2 = { restString, temp[1] };

				stack.add(s1);
				stack.add(s2);

			}
			// question(0th index) is empty
			// then add to arrayList rv
			else {
				// System.out.println("456");
				rv.add(temp[1]);
			}

		}

		return rv;
	}

	public static ArrayList<String> getPerm(String str) {
		return null;
	}

	public static void main(String[] args) {

		System.out.println(getSS("abc"));
		System.out.println(getSubset("abc"));
		String str = "df";
	}

}
