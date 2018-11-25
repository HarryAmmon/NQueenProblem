
public class ChessBoard {
	/*
	 * False in matrix means blank space on board
	 * True in matrix means queen on board
	 */
	private int boardWidth;
	boolean [][] board;
	/**
	 * Constructor that creates an n x n board
	 * This is done with a 2D array
	 * @param n
	 */
	public ChessBoard(int n) {
		boardWidth=n;
		board = new boolean [boardWidth][boardWidth];
	}
	public int getBoardWidth() {
		return boardWidth;
	}
	public boolean getPosition(int i, int j) {
		return board[i][j];
	}
	
	public boolean setPosition(boolean q, int x, int y) {
		board[y][x] = q;
		return true;
	}
	
	public void displayBoard() {
		for(int i = 0;i<board.length;i++) {
			for(int j = 0;j<board[0].length;j++) {
				if(board[i][j]) {
					System.out.print(" Q ");
				}
				else {
					System.out.print(" - ");
				}
				
			}
			System.out.println();
		}
	}
}
