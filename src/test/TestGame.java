package test;
import static org.junit.Assert.*;
import org.junit.Test;
import connect.four.Game;
import connect.four.board.*;
import connect.four.player.*;


public class TestGame {

	@Test
	public void testDetectWinner() {
		
		/**
		*Initialize variable for how many coins must be in a row to win a game.
		*/
		int inRow = 4;
		
		/**
		*Initialize the console players
		*/
		ConsolePlayer plyX = new ConsolePlayer("X");
		ConsolePlayer plyO = new ConsolePlayer("@");
		
		/**
		*Setup board layout 1 of the six board layouts.
		* Diagonal Wins plyO
		*/
		ConsolePlayer[][] board1Layout = {{ plyO, null, null, null, null, null }, 
						  { plyO, plyO, plyO, null, null, null }, 
						  { plyX, plyX, plyO, null, null, null }, 
						  { plyO, plyX, plyO, plyO, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }};
		/**
		*Setup board layout 2.
		* Horizontal Wins plyO
		*/		
		ConsolePlayer[][] board2Layout = {{ plyO, null, null, null, null, null }, 
						  { plyO, plyX, plyO, null, null, null }, 
						  { plyO, plyX, plyX, null, null, null }, 
						  { plyO, plyX, plyO, plyX, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }};
		/**
		*Setup board layout 3.
		* Diagonal Wins plyO
		*/
		ConsolePlayer[][] board3Layout = {{ plyX, plyX, plyX, plyO, null, null }, 
						  { plyX, plyX, plyO, null, null, null }, 
						  { plyX, plyO, plyO, null, null, null }, 
						  { plyO, plyX, plyO, plyO, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }};
		/**
		*Setup board layout 4.
		* Vertical Wins plyX
		*/		
		ConsolePlayer[][] board4Layout = {{ plyX, plyX, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { plyX, plyO, plyO, plyO, null, null }, 
						  { plyX, plyX, plyX, plyX, null, null }, 
						  { plyO, plyO, null, null, null, null }, 
						  { plyO, null, null, null, null, null }};
		/**
		*Setup board layout 5.
		* No winner
		*/		
		ConsolePlayer[][] board5Layout = {{ plyX, plyX, null, null, null, null }, 
						  { plyX, plyX, plyX, null, null, null }, 
						  { plyO, plyX, plyO, plyX, null, null }, 
						  { plyX, plyO, null, null, null, null }, 
						  { plyX, plyO, plyX, plyO, plyO, plyX }, 
						  { plyO, plyO, plyX, null, null, null }, 
						  { plyO, plyX, plyO, plyO, plyO, plyX }};
		/**
		*Setup board layout 4.
		* No winner
		*/		
		ConsolePlayer[][] board6Layout = {{ null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }};

		Board board1 = new Board(board1Layout);
		Board board2 = new Board(board2Layout);
		Board board3 = new Board(board3Layout);
		Board board4 = new Board(board4Layout);
		Board board5 = new Board(board5Layout);
		Board board6 = new Board(board6Layout);
		
		/**
		*Test layouts with the winners
		*/
		assertEquals(plyO, Game.detectWinner(board1, inRow));
		assertEquals(plyO, Game.detectWinner(board2, inRow));
		assertEquals(plyO, Game.detectWinner(board3, inRow));
		assertEquals(plyX, Game.detectWinner(board4, inRow));
		
		/**
		*Test layouts with no winners
		*/		
		assertNull(Game.detectWinner(board5, inRow));
		assertNull(Game.detectWinner(board6, inRow));
	}//end testDetectWinners
	
}//end testGame class