package lecture11_dynamic_programming;

public class checkBoardPathDP {

	public static int countBoardPath(int start, int end) {

		int count = 0;
		if (start == end) {

			count++;
			return count;

		}

		if (start > end)
			return 0;

		count += countBoardPath(start + 1, end);
		count += countBoardPath(start + 2, end);
		count += countBoardPath(start + 3, end);
		count += countBoardPath(start + 4, end);
		count += countBoardPath(start + 5, end);
		count += countBoardPath(start + 6, end);

		return count;
	}

	public static int countBoardPathDP(int start, int end, int[] storage) {

		int count = 0;
		if (start == end) {

			count++;
			return count;

		}

		if (start > end)
			return 0;

		if (storage[start] != 0)
			return storage[start];

		count += countBoardPathDP(start + 1, end, storage);
		count += countBoardPathDP(start + 2, end, storage);
		count += countBoardPathDP(start + 3, end, storage);
		count += countBoardPathDP(start + 4, end, storage);
		count += countBoardPathDP(start + 5, end, storage);
		count += countBoardPathDP(start + 6, end, storage);

		return count;
	}

	public static int countBoardPathIterative(int start, int end) {


		// int[] = {1};

		int[] storage = new int[end + 1];
		storage[end] = 1;

		for (int i = end - 1; i >= 0; i--) {

			for (int j = 1; j <= 6; j++) {
				if ((i + j) <= end) {
					storage[i] += storage[i + j];

				}
			}
		}

		return storage[0];
	}

	public static int countBoardPathBest(int start, int end) {


		int[] storage = {1,0,0,0,0,0};
		int sum = 0;
		
		for (int i = end - 1; i >= 0; i--) {

			sum = 0;
			
			for (int j = 5; j >= 1; j--) {
				
				sum += storage[j];
				storage[j] = storage[j-1];	
				
			}
			
			sum += storage[0];
			storage[0] = sum ;
		}

		return storage[0];
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(countBoardPathDP(0, 10, new int[11]));
		System.out.println(countBoardPath(0, 10));
		System.out.println(countBoardPathBest(0, 10));
		System.out.println(countBoardPathIterative(0, 10));
	
	}

}
