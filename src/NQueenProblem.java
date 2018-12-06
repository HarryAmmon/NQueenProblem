public class NQueenProblem {
	public NQueenProblem(int n) {

	}
	
	
	
	
	
	public boolean solveNQueen(ChessBoard n, int col, int userCol) {
		// If the current column is the column where the user placed a queen
		// Go to the next column
		
		if (col == userCol) {
			col++;
		}
		
		// If all queens have been placed then return true
		if (col >= (n.getBoardWidth())) {
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
		
		if (col >= n.getBoardWidth() ) {
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
