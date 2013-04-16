import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import dk.cphbusiness.Board;
import dk.cphbusiness.Die;
import dk.cphbusiness.Piece;
import dk.cphbusiness.Player;
import dk.cphbusiness.Square;


public class PlayerTest {
	
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery(); 

	@Test
	public void testTakeTurn() {
		final Die die1 = context.mock(Die.class, "Die1");
		final Die die2 = context.mock(Die.class, "Die2");
		
		final Board board = context.mock(Board.class);
		
		final Piece piece = context.mock(Piece.class);
		
		final Square oldLocation = context.mock(Square.class, "Square1");
		final Square newLocation = context.mock(Square.class, "Square2");
		
		context.checking(new Expectations() {{
			oneOf(die1).roll();
			oneOf(die1).getFaceValue(); will(returnValue(2));
			
			oneOf(die2).roll();
			oneOf(die2).getFaceValue(); will(returnValue(2));
			
			oneOf(piece).getLocation(); will(returnValue(oldLocation));
			oneOf(piece).setNewLocation(newLocation);
			
			oneOf(board).getSquare(oldLocation, 4); will(returnValue(newLocation));
			
			}});
		
		Die[] dice = new Die[2];
		dice[0] = die1;
		dice[1] = die2;
		
		Player player = new Player(dice, board, piece);
		player.takeTurn();
	}

}