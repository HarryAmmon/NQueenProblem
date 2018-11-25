
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChessBoard board = new ChessBoard(8);
		//board.setPosition(true, 7, 0);
		
		
		/*
		 * Allow user to choose position of first queen
		 */
		System.out.printf("***** %d Queen Problem *****%n",board.getBoardWidth());
		System.out.println("Enter the x coordinate of the first queen: ");
		int xCoord = BIO.getInt();
		System.out.println("Enter the y coordinate of the first queen: ");
		int yCoord = BIO.getInt();
		board.setPosition(true,xCoord,yCoord);
		board.displayBoard();
	}

}
