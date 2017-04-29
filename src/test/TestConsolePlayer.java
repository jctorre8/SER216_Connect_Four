package test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import connect.four.player.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Class;
import java.lang.reflect.Method;
import connect.four.board.*;

/**
*Test the consolePlayer
*/
public class TestConsolePlayer {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}

	
	@Test
	public void testDumpBoard() {
		
		/**
		*Initialize the players
		*/
		ConsolePlayer player1 = new ConsolePlayer("@");
		ConsolePlayer player2 = new ConsolePlayer("X");
		Method dumpBoard = null;
		
		/**
		*String representation 1 of expected output
		*/
		String expectedOutput1 = "@ is you, X is the other player, and - is empty." + System.lineSeparator() +
					 "- - - - - - - " + System.lineSeparator() +
					 "- - - - - - - " + System.lineSeparator() +
					 "- - - - - - - " + System.lineSeparator() +
					 "- - - - - - - " + System.lineSeparator() +
					 "- - - - - - - " + System.lineSeparator() +
					 "- - - - - - - " + System.lineSeparator() +
					 "=============" + System.lineSeparator() +
					 "1 2 3 4 5 6 7 " + System.lineSeparator();
		/**
		*String representation 2 of expected output
		*/
		String expectedOutput2 = "@ is you, X is the other player, and - is empty." + System.lineSeparator() +
					 "- - - - - - - " + System.lineSeparator() +
					 "- - - - - - - " + System.lineSeparator() +
					 "- - - - - - - " + System.lineSeparator() +
					 "- @ - - - - - " + System.lineSeparator() +
					 "- X - - - @ - " + System.lineSeparator() +
					 "@ X @ - - X - " + System.lineSeparator() +
					 "=============" + System.lineSeparator() +
					 "1 2 3 4 5 6 7 " + System.lineSeparator();
		/**
		*String representation 3 of expected output
		*/
		String expectedOutput3 = "@ is you, X is the other player, and - is empty." + System.lineSeparator() +
					 "- - - X - - - " + System.lineSeparator() +
					 "- - - @ - - - " + System.lineSeparator() +
					 "- - - X - - - " + System.lineSeparator() +
					 "- - - @ - - - " + System.lineSeparator() +
					 "- - - X - - - " + System.lineSeparator() +
					 "- - - @ - - - " + System.lineSeparator() +
					 "=============" + System.lineSeparator() +
					 "1 2 3 4 5 6 7 " + System.lineSeparator();
		/**
		*Setup board layout 1
		*/
		ConsolePlayer[][] board1Layout = {{ null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }};
		/**
		*Setup board layout 2
		*/
		ConsolePlayer[][] board2Layout = {{ player1, null, null, null, null, null }, 
						  { player2, player2, player1, null, null, null }, 
						  { player1, null, null, null, null, null }, 
						  { null, null, null, null, null, null },
						  { null, null, null, null, null, null }, 
						  { player2, player1, null, null, null, null }, 
						  { null, null, null, null, null, null }};
		/**
		*Setup board layout 3
		*/
		ConsolePlayer[][] board3Layout = {{ null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { player1, player2, player1, player2, player1, player2 },
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }};
		
		/**
		*Create the three board layouts
		*/
		Board board1 = new Board(board1Layout);
		Board board2 = new Board(board2Layout);
		Board board3 = new Board(board3Layout);
		

		try{
			dumpBoard = ConsolePlayer.class.getDeclaredMethod("dumpBoard", new Class[] { ReadableBoard.class });
		}
		
		catch(NoSuchMethodException e){
			fail("No such method exception thrown.");
		}
		
		catch(Exception e){
			fail("ERROR");
		}

		dumpBoard.setAccessible(true);
		

		try{
			//Test 1 
			dumpBoard.invoke(player1, new Object[] { board1 });
			assertEquals(expectedOutput1, outContent.toString());
			outContent.reset();
			
			//Test 2 
			dumpBoard.invoke(player1, new Object[] { board2 });
			assertEquals(expectedOutput2, outContent.toString());
			outContent.reset();
			
			//Test 3 
			dumpBoard.invoke(player1, new Object[] { board3 });
			assertEquals(expectedOutput3, outContent.toString());
			outContent.reset();
		}
		
		catch(Exception e){
			fail("ERROR");
		}
	}

}
