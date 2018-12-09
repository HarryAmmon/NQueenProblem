import java.util.ArrayList;

public class NQueenProblem {
	int boardSize;
	ArrayList<ChessBoard> Solutions = new ArrayList<ChessBoard>();

	public NQueenProblem(int n) {
		boardSize = n;
	}

	public boolean solveNQueen(ChessBoard n, int col, int userCol) {
		// If the current column is the column where the user placed a queen
		// Go to the next column

		if (col == userCol) {
			col++;
		}

		// If all queens have been placed then return true
		if (col >= n.getBoardWidth()) {
			return true;
		}

		for (int i = 0; i <= n.getBoardWidth() - 1; i++) {
			// If its safe to place a queen in position (col,i)
			if (isQueenSafe(n, col, i)) {
				// Place the queen in that position
				n.setPosition(true, col, i);

				if (solveNQueen(n, col + 1, userCol)) {
					return true;
				}

				n.setPosition(false, col, i);
			}
		}

		return false;
	}

	private boolean solveAllNQueen(ChessBoard n, int col, int userCol) {
		// If the current column is the column where the user entered
		// a queen, go to the next column

		if (col == userCol) {
			col++;
		}

		// If all queens have been placed, then problem is solved
		if (col >= n.getBoardWidth()) {
			return true;
		}

		// Recursive part of function
		// For every column
		for (int i = 0; i <= n.getBoardWidth() - 1; i++) {
			// If its safe to place a queen here
			if (isQueenSafe(n, col, i)) {
				// Place the queen here
				n.setPosition(true, col, i);
				if (solutionIsUnique(n)) {
				// Call function for the next column
					if (solveAllNQueen(n, col + 1, userCol)) {
					
						return true;
						}
				}
				// Unable to place all queens
				// Remove a queen and try again

				n.setPosition(false, col, i);
			}
		}

		return false;
	}

	private boolean solutionIsUnique(ChessBoard n) {
		// Need to check if all N queens are in the same position
		ChessBoard toCheck;
		int samePosition;
		// If array of boards is empty, must be unique so return true
		if (Solutions.size() == 0) {
			return true;
		}

		// For every board in Boards
		for (int i = 0; i < Solutions.size(); i++) {
			samePosition = 0;
			//System.out.printf("%d Boards checked%n", i);
			// Get that board
			toCheck = Solutions.get(i);
			// Loops that check if there is a queen in the same position
			// of the two boards
			for (int j = 0; j < boardSize; j++) {
				for (int k = 0; k < boardSize; k++) {
					if (toCheck.getPosition(j, k) && n.getPosition(j, k)) {
						samePosition++;
					}
				}
			}
			if (samePosition >= n.getBoardWidth()) {
				return false;
			}
		}
		return true;
	}

	public void testIsUnique() {
		System.out.println("Creating new board");
		ChessBoard board0 = new ChessBoard(boardSize);
		for (int i = 0; i < board0.getBoardWidth(); i++) {
			board0.setPosition(true, i, i);
		}
		System.out.println("board0 created:");
		Solutions.add(board0);
		board0.display();

		System.out.println("Creating new board");
		ChessBoard board1 = new ChessBoard(boardSize);
		for (int j = 0; j < board1.getBoardWidth(); j++) {
			board1.setPosition(true, j,7);
		}
		System.out.println("board1 created:");
		board1.display();

		if (solutionIsUnique(board1)) {
			System.out.println("UNIQUE");
		} else {
			System.out.println("SAME");
		}

	}

	public void findAllSolutions(int[] userCoord) {
		ChessBoard board = new ChessBoard(boardSize); // Create new board
		board.setPosition(true, userCoord[0], userCoord[1]); // Add users queen to the board
		
		// Find a solution for it
		if (solveAllNQueen(board, 0, userCoord[0])) {
			// If a solution is found, Add to list of Boards,
			// and display board
			// NOTETOSELF: Might rename Boards -> solutions
			board.display();
			//System.out.printf("%d solutions found%n", Solutions.size());
			Solutions.add(board);
			// Find next solution
			findAllSolutions(userCoord);
		} else {
			System.out.printf("%d solutions found%n", Solutions.size());
		}

	}

	public boolean isQueenSafe(ChessBoard n, int xCoord, int yCoord) {

		// Checks if another queen is on the same column
		for (int j = 0; j < n.getBoardWidth(); j++) {
			if (n.getPosition(xCoord, j)) {
				return false;
			}
		}

		// Checks if another queen is on the same row
		for (int j = 0; j < n.getBoardWidth(); j++) {
			if (n.getPosition(j, yCoord)) {
				return false;
			}
		}

		// Checks if another queen is on the same diagonal (upper left)
		for (int j = xCoord, k = yCoord; j >= 0 && k >= 0; j--, k--) {
			if (n.getPosition(j, k)) {
				return false;
			}
		}

		// Check if another queen is on the same diagonal (lower left)
		for (int j = xCoord, k = yCoord; j >= 0 && k < n.getBoardWidth(); j--, k++) {
			if (n.getPosition(j, k)) {
				return false;
			}
		}

		// Check if another queen is on the same diagonal (upper right)
		for (int j = xCoord, k = yCoord; j < n.getBoardWidth() && k > 0; j++, k--) {
			// System.out.println("Lower upper right is running");
			if (n.getPosition(j, k)) {
				return false;
			}
		}

		// Check if another queen in on the same diagonal (lower right)
		for (int j = xCoord, k = yCoord; j < n.getBoardWidth() && k < n.getBoardWidth(); j++, k++) {
			if (n.getPosition(j, k)) {
				return false;
			}
		}

		return true;

	}
}
