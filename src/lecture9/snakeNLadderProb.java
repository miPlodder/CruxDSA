package lecture9;

import java.util.ArrayList;

public class snakeNLadderProb {

	public static void main(String[] args) {

		// System.out.println(getPathWAL(4, 10));
		System.out.println(getPathWALModified(0, 10));
		
	}

	public static ArrayList<String> getPathWAL(int start, int end) {

		// base condition
		// +ve base condition -- destination
		if (start == end) {

			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;

		}

		// -ve base condition -- invalid positions
		if (start > end) {

			ArrayList<String> baseResult = new ArrayList<>();
			return baseResult;

		}

		// no -ve base case as 1D motion is possible in snakeNLadder

		// work here
		ArrayList<String> tempResult = new ArrayList<>();
		ArrayList<String> myResult = new ArrayList<>();

		tempResult = getPathWAL(start + 1, end);

		for (int i = 0; i < tempResult.size(); i++) {

			myResult.add('1' + tempResult.get(i));

		}

		tempResult = getPathWAL(start + 2, end);

		for (int i = 0; i < tempResult.size(); i++) {

			myResult.add('2' + tempResult.get(i));

		}

		tempResult = getPathWAL(start + 3, end);

		for (int i = 0; i < tempResult.size(); i++) {

			myResult.add('3' + tempResult.get(i));

		}

		tempResult = getPathWAL(start + 4, end);

		for (int i = 0; i < tempResult.size(); i++) {

			myResult.add('4' + tempResult.get(i));

		}

		tempResult = getPathWAL(start + 5, end);

		for (int i = 0; i < tempResult.size(); i++) {

			myResult.add('5' + tempResult.get(i));

		}

		tempResult = getPathWAL(start + 6, end);

		for (int i = 0; i < tempResult.size(); i++) {

			myResult.add('6' + tempResult.get(i));

		}

		return myResult;
	}

	public static ArrayList<String> getPathWALModified(int start, int end) {

		// base condition
		// +ve base condition -- destination
		if (start == end) {

			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;

		}

		// -ve base condition -- invalid positions
		if (start > end) {

			ArrayList<String> baseResult = new ArrayList<>();
			return baseResult;

		}

		// no -ve base case as 1D motion is possible in snakeNLadder

		// work here
		ArrayList<String> tempResult = new ArrayList<>();
		ArrayList<String> myResult = new ArrayList<>();
		
		for(int i = 1; i <=6;i++){
		
			tempResult = getPathWALModified(start + i, end);
			
			for (int j = 0; j < tempResult.size(); j++) {
	
				myResult.add(i + tempResult.get(j));
	
			}
		}
		return myResult;
	}
}
