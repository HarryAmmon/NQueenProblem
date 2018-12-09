
public class Main {
	// TODO
	// print out all the possible solutions for the NQueenProblem

	// Defines the board size, can be any value lower than 27
	static final int boardSize = 6;
	// Array of length 2 where userCoord[0] is x coordinate and userCoords[1] is y
	// coordinate
	static int[] userCoord = new int[2];

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		if (boardSize <= 27) {
			// Construct ChessBoard and NQueenProblem
			ChessBoard UIboard = new ChessBoard(boardSize);
			NQueenProblem problem = new NQueenProblem(boardSize);

			// Get user coordinates
			System.out.printf("***** %d Queen Problem *****%n", boardSize);
			UIboard.display();
			// Get coordinate for x-axis
			System.out.printf("Enter the x coordinate of the first queen: %n");
			userCoord[0] = getUserInput();
			// Get coordinate for y-axis
			System.out.printf("Enter the y coordinate of the first queen: %n");
			userCoord[1] = getUserInput();

			// Start timer
			long startTime = System.currentTimeMillis();
			UIboard.setPosition(true, userCoord[0], userCoord[1]);
			System.out.println("This is the position you have chosen");
			UIboard.display();
			problem.findAllSolutions(userCoord);
			//problem.testIsUnique();
			/*// If a solution can be found, display the solution
			if (findAllSolutions(board, 0, userCoord)) {
				System.out.println("Solution found");
				board.display();
			} else {
				System.out.println("Unable to find solution");
			}*/
			
			// End timer
			long endTime = System.currentTimeMillis();
			long duration = endTime - startTime;
			System.out.println("Solution found in " + duration + "m/s");
		} else {
			System.out.println("BoardSize needs to be lower than 28");
		}
	}

	/**
	 * Checks that the number input by the user is valid
	 * 
	 * @return n if between
	 */
	private static int getUserInput() {
		int n = BIO.getInt();
		boolean format = false;
		while (!format) {
			if (n <= (boardSize - 1) && n >= 0) {
				format = true;
			} else {
				System.out.printf("Please enter a number between 0 and %d%n", boardSize - 1);
				n = BIO.getInt();
			}
		}
		return n;
	}
	
	

}
