
public class NQueenProblem {
	public NQueenProblem(int n) {

	}
	
	public boolean isQueenSafe(ChessBoard n, int xCoord, int yCoord) {
		
		// Checks if another queen is on the same column
		for (int j = 0;j<n.getBoardWidth();j++) {
			if(n.getPosition(xCoord, j)) {
				System.out.println("Same column");
				return false;
			}
		}
		
		// Checks if another queen is on the same row
		for (int j = 0;j<n.getBoardWidth();j++) {
			if(n.getPosition(j, yCoord)) {
				System.out.println("Same row");
				return false;
			}
		}
		
		// Checks if another queen is on the same diagonal (upper left)
		for(int j = xCoord, k = yCoord; j>=0 && k>=0; j--, k--) {
			if(n.getPosition(j, k)) {
				System.out.println("Same upper left diagonal");
				return false;
			}
		}
		
		// Check if another queen is on the same diagonal (lower left)
		for(int j = xCoord, k = yCoord; j>=0 && k<n.getBoardWidth(); j--, k++) {
			// System.out.println("Lower left loop is running");
			if(n.getPosition(j, k)) {
				System.out.println("Same lower left diagonal");
				return false;
			}
		}
		
		// Check if another queen is on the same diagonal (upper right)
		for(int j = xCoord, k = yCoord; j<=n.getBoardWidth() && k>0; j++, k--) {
			// System.out.println("Lower upper right is running");
			if(n.getPosition(j, k)) {
				System.out.println("Same upper right diagonal");
				return false;
			}
		}
		
		// Check if another queen in on the same diagonal (lower right)
		for(int j = xCoord, k = yCoord; j<=n.getBoardWidth() && k<=n.getBoardWidth(); j++,k++) {
			if(n.getPosition(j, k)) {
				System.out.println("Same lower right diagonal");
				return false;
			}
		}
		
		return true;
		
	}
}
