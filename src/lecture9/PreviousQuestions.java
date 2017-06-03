package lecture9;

import java.util.ArrayList;

public class PreviousQuestions {

	public static void inverse(int[] arr, int si) {

		// base case
		if (si == arr.length)
			return;
		// call
		int index = arr[si];

		// si == value waala index

		inverse(arr, si + 1);

		arr[index] = si;
		return;
	}

	public static void main(String args[]) {

		/*
		 * int[] arr = {4,0,1,3,2}; inverse(arr,0); for(int i = 0 ;i < 5;i++)
		 * System.out.print(arr[i]);
		 */
		/* System.out.print(countMazePath(2, 2, 0, 0)); */
		/* System.out.print(printMazePath(2, 2, 0, 0,"")); */
		System.out.println(arrayMazePath(2, 2, 0, 0));
	}

	/*
	 * public static void cbp(int end, int curr){
	 * 
	 * //base case
	 * 
	 * //recursion for()
	 * 
	 * }
	 */
	public static int countMazePath(int er, int ec, int cr, int cc) {

		// base
		if (cr == er && cc == ec)
			return 1;

		if (cr > er || cc > er)
			return 0;

		int rv = 0;

		rv += countMazePath(er, ec, cr + 1, cc);// vertical
		rv += countMazePath(er, ec, cr, cc + 1);// horizontal

		return rv;
	}

	public static int printMazePath(int er, int ec, int cr, int cc, String osf) {

		// base
		if (cr == er && cc == ec) {
			System.out.println(osf);
			return 1;
		}
		if (cr > er || cc > er)
			return 0;

		int rv = 0;

		rv += printMazePath(er, ec, cr + 1, cc, osf + "V");// vertical

		rv += printMazePath(er, ec, cr, cc + 1, osf + "H");// horizontal

		return rv;
	}

	public static ArrayList<String> arrayMazePath(int er, int ec, int cr, int cc) {

		ArrayList<String> myResult = new ArrayList<>();

		ArrayList<String> hR = new ArrayList<>();
		ArrayList<String> vR = new ArrayList<>();

		if (cr == er && cc == ec) {
			// array add one - 2 - 4 - 8
			ArrayList<String> baseArray = new ArrayList<>();
			baseArray.add("");
			return baseArray;

		}
		if (cr > er || cc > er) {
			ArrayList<String> baseArray = new ArrayList<>();
			return baseArray;

		}

		vR = arrayMazePath(er, ec, cr + 1, cc);// vertical

		hR = arrayMazePath(er, ec, cr, cc + 1);// horizontal

		for (int i = 0; i < hR.size(); i++)
			myResult.add("H" + hR.get(i));

		for (int i = 0; i < vR.size(); i++)
			myResult.add("V" + vR.get(i));

		return myResult;
	}

	
	//k-1 case here -----------------------------------------------------------------
	public static int countMazePathWD(int er, int ec, int cr, int cc) {

		// base case
		if (cr == er && cc == ec)
			return 1;

		if (cr > er || cc > er)
			return 0;

		int rv = 0;

		rv += countMazePath(er, ec, cr + 1, cc);// vertical
		rv += countMazePath(er, ec, cr, cc + 1);// horizontal

		return rv;
	}

}
