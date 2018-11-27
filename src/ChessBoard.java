
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
	public boolean getPosition(int xCoord, int yCoord) {
		return board[yCoord][xCoord];
	}
	
	public boolean setPosition(boolean q, int xCoord, int yCoord) {
		System.out.println("Position set");
		board[yCoord][xCoord]= q;
		return true;
	}
	
	public void displayBoard() {
		for(int i = 0;i<board.length;i++) {
			for(int j = 0;j<board[i].length;j++) {
				if(board[i][j]) {
					System.out.print(" Q ");
				}
				else {
					System.out.print(" - ");
				}
				
			}
			System.out.println();
		}
		System.out.println();
	}
}
