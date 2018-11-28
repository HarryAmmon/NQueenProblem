import java.util.Random;

public class Main {
	static final int boardSize = 8;

	public static void main(String[] args) {
		/*
		 * // Create chess board ChessBoard board = new ChessBoard(boardSize); // Start
		 * NQueenProblem NQueenProblem problem = new NQueenProblem(boardSize);
		 * //board.setPosition(true, 7, 0);
		 * 
		 * 
		 * 
		 * // Allow user to choose position of first queen
		 * 
		 * System.out.printf("***** %d Queen Problem *****%n",board.getBoardWidth());
		 * System.out.println("Enter the x coordinate of the first queen: "); int xCoord
		 * = 3;//getUserInput();
		 * System.out.println("Enter the y coordinate of the first queen: "); int yCoord
		 * = 3;//getUserInput(); board.setPosition(true,xCoord,yCoord);
		 * board.displayBoard();
		 * 
		 * 
		 * 
		 * //System.out.println("Enter the x coordinate of the second queen: "); xCoord
		 * = 3;//getUserInput();
		 * //System.out.println("Enter the y coordinate of the second queen: "); yCoord
		 * = 4;//getUserInput(); // Checks same column if(problem.isQueenSafe(board,
		 * xCoord, yCoord)) { board.setPosition(true,xCoord,yCoord); } else {
		 * System.out.println("Not safe"); } // Checks same row xCoord = 1; yCoord = 3;
		 * if(problem.isQueenSafe(board, xCoord, yCoord)) { board.setPosition(true,
		 * xCoord, yCoord); } else { System.out.println("Not safe"); }
		 * //board.displayBoard();
		 * 
		 * // Check if queen is on the upper left diagonal xCoord = 4; yCoord = 4;
		 * if(problem.isQueenSafe(board, xCoord, yCoord)) { board.setPosition(true,
		 * xCoord, yCoord); } else { System.out.println("Not Safe"); }
		 * 
		 * // Check if queen is on the lower left diagonal xCoord = 6; yCoord = 0;
		 * if(problem.isQueenSafe(board, xCoord, yCoord)) { board.setPosition(true,
		 * xCoord, yCoord); } else { System.out.println("Not safe"); }
		 * 
		 * // Check if queen is on the upper right diagonal xCoord = 0; yCoord = 6;
		 * if(problem.isQueenSafe(board, xCoord, yCoord)) { board.setPosition(true,
		 * xCoord, yCoord); } else { System.out.println("Not safe"); }
		 * 
		 * // Check if queen is on the lower right diagonal xCoord = 2; yCoord = 2;
		 * if(problem.isQueenSafe(board, xCoord, yCoord)) { board.setPosition(true,
		 * xCoord, yCoord); } else { System.out.println("Not safe"); } }
		 * 
		 */
		ChessBoard boards[] = new ChessBoard[5];
		NQueenProblem problems[] = new NQueenProblem[5];		
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
			addFiveQueens(boards[j], problems[j]);
			System.out.printf("5 Queens added for board %d%n", j);
		}
		
		for (int k = 0; k<boards.length;k++) {
			System.out.println();
			System.out.println("***********************");
			System.out.printf("This is board %d%n", k);
			boards[k].displayBoard();
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

	private static void addFiveQueens(ChessBoard board, NQueenProblem problem) {
		Random rand = new Random();
		int added = 0;
		int xCoord = rand.nextInt(7)+0;
		int yCoord = rand.nextInt(7)+0;
		while (added < 5) {
			if (problem.isQueenSafe(board, xCoord, yCoord)) {
				board.setPosition(true, xCoord, yCoord);
				added++;
			} else {
				xCoord = rand.nextInt(7)+0;
				yCoord = rand.nextInt(7)+0;
			}
			
		}
		

	}
}
