import java.util.ArrayList;

public class NQueenProblem {
	int boardSize;
	ArrayList<ChessBoard> Boards = new ArrayList<ChessBoard>();
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
		
		for(int i = 0;i<= n.getBoardWidth()-1;i++) {
			// If its safe to place a queen in position (col,i)
			if(isQueenSafe(n,col,i)) {
				// Place the queen in that position
				n.setPosition(true, col, i);
				
				if(solveNQueen(n,col+1, userCol)) {
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
		// If all queens have been placed AND its a unique solution
		if (col >= n.getBoardWidth() && solutionIsUnique(n) ) {
			return true;
		}
		
		// Recursive part of function
		// For every column
		for(int i = 0;i<=n.getBoardWidth()-1;i++) {
			// If its safe to place a queen here
			if (isQueenSafe(n,col,i)) {
				// Place the queen here
				n.setPosition(true, col, i);
				
				// Call function for the next column
				if(solveNQueen(n,col+1,userCol)) {
					return true;
				}
				
				
				// Unable to place all queens
				// Remove a queen and try again
				
				n.setPosition(false, col, i);
			}
		}
		
		return false;
	}
	
	private boolean solutionIsUnique(ChessBoard n) {
		ChessBoard toCheck;
		for(int i = 0;i<Boards.size();i++) {
			toCheck = Boards.get(i);
			for (int j = 0; j<=boardSize; j++) {
				for (int k = 0; k<=boardSize; k++) {
					if(toCheck.getPosition(j, k) == n.getPosition(j, k)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void testIsUnique() {
		System.out.println("Creating new board");
		ChessBoard board0 = new ChessBoard(boardSize);
		for (int i = 0;i<board0.getBoardWidth();i++) {
			board0.setPosition(true, i, i);
		}
		System.out.println("board0 created:");
		Boards.add(board0);
		board0.display();
		
		System.out.println("Creating new board");
		ChessBoard board1 = new ChessBoard(boardSize);
		for (int i = 0;i<board1.getBoardWidth();i++) {
			board1.setPosition(true, i, i);
		}
		System.out.println("board1 created:");
		board1.display();
		
		if(solutionIsUnique(board1)) {
			System.out.println("Boards are unique");
		} else {
			System.out.println("NOT UNIQUE");
		}
		
	}
	
	
	public boolean findAllSolutions(int[] userCoord) {
		Boards.add(new ChessBoard(boardSize));
		Boards.get(Boards.size()-1).setPosition(true, userCoord[0], userCoord[1]);
		if(solveAllNQueen(Boards.get(Boards.size()-1), 0, userCoord[0])) {
			Boards.get(0).display();
			findAllSolutions(userCoord);
			return true;
		}
		return false;
	}
	
	public boolean isQueenSafe(ChessBoard n, int xCoord, int yCoord) {
		
		// Checks if another queen is on the same column
		for (int j = 0;j<n.getBoardWidth();j++) {
			if(n.getPosition(xCoord, j)) {
				return false;
			}
		}
		
		// Checks if another queen is on the same row
		for (int j = 0;j<n.getBoardWidth();j++) {
			if(n.getPosition(j, yCoord)) {
				return false;
			}
		}
		
		// Checks if another queen is on the same diagonal (upper left)
		for(int j = xCoord, k = yCoord; j>=0 && k>=0; j--, k--) {
			if(n.getPosition(j, k)) {
				return false;
			}
		}
		
		// Check if another queen is on the same diagonal (lower left)
		for(int j = xCoord, k = yCoord; j>=0 && k<n.getBoardWidth(); j--, k++) {
			if(n.getPosition(j, k)) {
				return false;
			}
		}
	
		// Check if another queen is on the same diagonal (upper right)
		for(int j = xCoord, k = yCoord; j<n.getBoardWidth() && k>0; j++, k--) {
			// System.out.println("Lower upper right is running");
			if(n.getPosition(j, k)) {
				return false;
			}
		}
		
		// Check if another queen in on the same diagonal (lower right)
		for(int j = xCoord, k = yCoord; j<n.getBoardWidth() && k<n.getBoardWidth(); j++,k++) {
			if(n.getPosition(j, k)) {
				return false;
			}
		}
		
		return true;
		
	}
}
