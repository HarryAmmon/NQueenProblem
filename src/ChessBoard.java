
public class ChessBoard {
	/**
	 * False in matrix means blank space on board True in matrix means queen on
	 * board
	 */
	private int boardWidth;
	boolean[][] board;

	/**
	 * Constructor that creates an n x n board. This is done with a 2D array
	 * @param n
	 */
	public ChessBoard(int n) {
		boardWidth = n;
		board = new boolean[boardWidth][boardWidth];
	}

	/**
	 * 
	 * @return boardWidth
	 */
	public int getBoardWidth() {
		return boardWidth;
	}

	/**
	 * 
	 * @param xCoord
	 * @param yCoord
	 * @return true if queen is in position
	 */
	public boolean getPosition(int xCoord, int yCoord) {
		return board[yCoord][xCoord];
	}

	/**
	 * 
	 * @param true for a queen, false for blank board space
	 * @param xCoord
	 * @param yCoord
	 * @return true once position has been set
	 */
	public boolean setPosition(boolean q, int xCoord, int yCoord) {
		board[yCoord][xCoord] = q;
		return true;
	}

	/**
	 * Will print the whole board
	 */
	public void display() {
		System.out.print("  ");
		for (int k = 0; k < board.length; k++) {
			System.out.print("  "+k);
		}
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			System.out.printf(" %2d",i);
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j]) {
					System.out.print(" Q ");
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}

