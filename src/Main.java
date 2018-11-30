import java.util.Random;

public class Main {
	// Defines the board size, can be any value lower than 27
	static final int boardSize = 15;
	// Array of length 2 where userCoord[0] is x coordinate and userCoords[1] is y coordinate
	static int[] userCoord = new int[2];
	
	public static void main(String[] args) {
		ChessBoard board = new ChessBoard(boardSize);
		NQueenProblem problem = new NQueenProblem(boardSize);
		System.out.printf("***** %d Queen Problem *****%n", board.getBoardWidth());
		System.out.printf("Enter the x coordinate of the first queen: %n");
		// Get coordinate for x-axis
		userCoord[0] = getUserInput();
		System.out.printf("Enter the y coordinate of the first queen: %n");
		// Get coordinate for y-axis
		userCoord[1]= getUserInput();
		board.setPosition(true, userCoord[0], userCoord[1]);
		long startTime = System.currentTimeMillis();
		problem.solveNQueen(board, 0, userCoord[0]);
		long endTime = System.currentTimeMillis();
		board.display();
		long duration = endTime - startTime;
		System.out.println("Solution found in "+ duration +"m/s");
	}
	
	/*public static void main(String[] args) {
		ChessBoard board = new ChessBoard(boardSize);
		NQueenProblem problem = new NQueenProblem(boardSize);
		System.out.printf("***** %d Queen Problem *****%n", board.getBoardWidth());
		System.out.printf("Enter the x coordinate of the first queen: %n");
		// Get coordinate for x-axis
		userCoord[0] = getUserInput();
		System.out.printf("Enter the y coordinate of the first queen: %n");
		// Get coordinate for y-axis
		userCoord[1]= getUserInput();
		board.setPosition(true, userCoord[0], userCoord[1]);
		board.display();
		
	}*/
	/*public static void main(String[] args) {
		ChessBoard boards[] = new ChessBoard[1];
		NQueenProblem problems[] = new NQueenProblem[1];		
		int xCoord;
		int yCoord;

		for (int i = 0; i < boards.length; i++) {
			boards[i] = new ChessBoard(boardSize);
			problems[i] = new NQueenProblem(boardSize);
			System.out.printf("***** %d Queen Problem *****%n", boards[i].getBoardWidth());
			System.out.printf("Enter the x coordinate of the first queen, board%d: %n", i);
			xCoord = getUserInput();
			System.out.printf("Enter the y coordinate of the first queen, board%d: %n", i);
			yCoord = getUserInput();
			boards[i].setPosition(true, xCoord, yCoord);
		}
		
		for (int j = 0;j<boards.length;j++) {
			addNQueens(boards[j], problems[j],5);
			System.out.printf("5 Queens added for board %d%n", j);
		}
		
		for (int k = 0; k<boards.length;k++) {
			System.out.println();
			System.out.println("***********************");
			System.out.printf("This is board %d%n", k);
			boards[k].displayBoard();
		}
		

	}*/

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

	private static void addNQueens(ChessBoard board, NQueenProblem problem,int n) {
		Random rand = new Random();
		int added = 0;
		int xCoord = rand.nextInt(boardSize-1)+0;
		int yCoord = rand.nextInt(boardSize-1)+0;
		while (added < n) {
			if (problem.isQueenSafe(board, xCoord, yCoord)) {
				board.setPosition(true, xCoord, yCoord);
				added++;
			} else {
				xCoord = rand.nextInt(boardSize-1)+0;
				yCoord = rand.nextInt(boardSize-1)+0;
			}
			
		}
		

	}
}
