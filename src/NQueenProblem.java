import java.util.ArrayList;

public class NQueenProblem {
	int boardSize;
	ArrayList<ChessBoard> Solutions = new ArrayList<ChessBoard>();

	public NQueenProblem(int n) {
		boardSize = n;
	}

	private boolean solveAllNQueen(ChessBoard n, int col, int userCol) {

		if (col == userCol) { // If the current column is the column where the user entered a queen
			col++;			  // go to the next column
		}

		// If all N queens have been placed, then problem is solved
		if (col >= n.getBoardWidth()) {
			return true;
		}

		// Recursive part of function
		// For every row
		for (int i = 0; i <= n.getBoardWidth() - 1; i++) {
			// If its safe to place a queen here
			if (isQueenSafe(n, col, i)) {
				// Place the queen here
				n.setPosition(true, col, i);
				// If the this solution has not been found before
				if (solutionIsUnique(n)) {
				// Call function for the next column
					if (solveAllNQueen(n, col + 1, userCol)) {
						return true;
						}
				}
				// If you can't place a queen here
				// Remove the queen
				n.setPosition(false, col, i);
				// Try the next row
			}
		}
		// If you get to the end of the row and are unable to place a queen
		return false;
	}

	private boolean solutionIsUnique(ChessBoard n) {
		ChessBoard toCheck;
		int samePosition;
		// If array of solutions is empty, must be unique so return true
		if (Solutions.size() == 0) {
			return true;
		}

		// For every board in solutions
		for (int i = 0; i < Solutions.size(); i++) {
			samePosition = 0;
			// Get that board
			toCheck = Solutions.get(i);
			// Loops that check if there is a queen in the same position
			// of the two boards
			for (int j = 0; j < boardSize; j++) {
				for (int k = 0; k < boardSize; k++) {
					if (toCheck.getPosition(j, k) && n.getPosition(j, k)) {
						// If there are 2 queens in the same position, increment a counter by one
						samePosition++;
					}
				}
			}
			// If the same number of queens are in the same position as it
			// is possible to have queens on the board. This board is not unique
			if (samePosition >= n.getBoardWidth()) {
				return false;
			}
		}
		return true;
	}

	public void findAllSolutions(int[] userCoord) {
		ChessBoard board = new ChessBoard(boardSize); // Create new board
		board.setPosition(true, userCoord[0], userCoord[1]); // Add users queen to the board
		// Find a solution for it
		if (solveAllNQueen(board, 0, userCoord[0])) {
			// If a solution is found, Add to list of solutions,
			// and display board
			board.display();
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
