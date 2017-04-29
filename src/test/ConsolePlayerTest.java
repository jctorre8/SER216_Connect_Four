package test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import connect.four.Game;
import connect.four.board.Board;
import connect.four.player.ConsolePlayer;
import connect.four.player.Player;

public class ConsolePlayerTest {
	
	Board testboard1;
	Board testboard2;
	Board testboard3;
	ConsolePlayer plyX;
	ConsolePlayer plyO;
	Game game;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		plyX = new ConsolePlayer("X");						
		plyO = new ConsolePlayer("@");
		
		/**
        	* Case 1, 7x6 Null board.
        	*/
		ConsolePlayer[][] layout1 = {{ null, null, null, null, null, null },
					     { null, null, null, null, null, null },
					     { null, null, null, null, null, null },
					     { null, null, null, null, null, null },
					     { null, null, null, null, null, null },
					     { null, null, null, null, null, null },
					     { null, null, null, null, null, null }};
									
		/**
        	* Case 2
        	*/
		ConsolePlayer[][] layout2  ={{ null, null, null, null, null, null },
					     { null, null, null, null, null, null },
				 	     { null, null, null, null, null, null },
	            			     { null, null, null, null, null, null },
				 	     { null, plyO, null, null, null, null },
				 	     { null, plyX, null, null, null, plyO },
				 	     { plyO, plyX, null, null, null, plyX }};
		/**
        	* Case 3
        	*/
		ConsolePlayer[][] layout3 = {{ null, null, null, plyX, null, null },
					     { null, null, null, null, null, null },
				 	     { null, null, null, plyO, null, null },
				 	     { null, null, null, plyX, null, null },
				 	     { null, null, null, plyO, null, null },
				 	     { null, null, null, plyX, null, null },
				 	     { null, null, null, plyO, null, null }};
		
		testboard1 = new Board(layout1);
		game = new Game(new Player[] {plyX, plyO}, testboard1, 4);
		testboard2 = new Board(layout2);
		game = new Game(new Player[] {plyX, plyO}, testboard2, 4);
		testboard3 = new Board(layout3);
		game = new Game(new Player[] {plyX, plyO}, testboard3, 4);
		game.start();		
	}

	@After
	public void tearDown() throws Exception {
	}

}
