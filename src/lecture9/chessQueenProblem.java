package lecture9;

public class chessQueenProblem {

	public static void main(String[] args) {
		// countNQueens();
		boolean[][] board = new boolean[4][4];
		printNQueens(0, board,"");
		/*char ch = 'a';
		String str = ch;*/
	}

	public static int countNQueens(int row, boolean[][] board) {

		if (row == board.length) {
			return 1;
		}
		
		int count = 0;

		for (int col = 0; col < board.length; col++) {

			if (isItSafeTPQ(board, row, col)) {
				board[row][col] = true;
				count += countNQueens(row + 1, board);
				board[row][col] = false;
			}
		}

		return count;
	}

	public static void printNQueens(int row, boolean[][] board, String osf) {

		if (row == board.length) {
			System.out.println(osf);
			return;
		}
		int count = 0;
		
		String temp = osf;

		for (int col = 0; col < board.length; col++) {

			if (isItSafeTPQ(board, row, col)) {
				board[row][col] = true;
				printNQueens(row + 1, board,osf+" "+row+"-"+col+",");
				board[row][col] = false;
			}
		}

		return;
	}

	public static boolean isItSafeTPQ(boolean[][] board, int row, int col) {

		// diagonal left row times check
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}

		// diagonal right column times check
		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j]) {
				return false;
			}
		}

		// diagonal vertically upwards
		for (int i = row - 1; i >= 0; i--) {
			if (board[i][col]) {
				return false;
			}
		}
		return true;
	}

}
