package dk.cphbusiness;

public class Player {
	private Die[] dice;
	private Board board;
	private Piece piece;
	
	public Player(Die[] dice, Board board, Piece piece) {
		this.dice = dice;
		this.board = board;
		this.piece = piece;
	}
	
	public void takeTurn() {
		int numberOfMoves = 0;
		for (int i = 0; i < dice.length; i++) {
			dice[i].roll();
			numberOfMoves += dice[i].getFaceValue();
		}
		
		Square oldLocation = piece.getLocation();
		
		Square newLocation = board.getSquare(oldLocation, numberOfMoves);
		
		piece.setNewLocation(newLocation);
	}
}
