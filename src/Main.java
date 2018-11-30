import java.util.Random;

public class Main {
	static final int boardSize = 8;

	public static void main(String[] args) {
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
			addNQueens(boards[j], problems[j],5);
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

	private static void addNQueens(ChessBoard board, NQueenProblem problem,int n) {
		Random rand = new Random();
		int added = 0;
		int xCoord = rand.nextInt(7)+0;
		int yCoord = rand.nextInt(7)+0;
		while (added < n) {
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
