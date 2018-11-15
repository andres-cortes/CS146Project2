import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MazeDrawerTester
{
	Maze maze1, maze2, maze3, maze4, maze5;
	MazeDrawer drawer;
	String solvedTest1, solvedTest2, solvedTest3, solvedTest4, solvedTest5;
	
	@BeforeEach
	void setUp() throws Exception
	{
		maze1 = new Maze(4,4);
		maze1.generate(5);
		maze2 = new Maze(5,5);
		maze2.generate(5);
		maze3 = new Maze(6,6);
		maze3.generate(5);
		maze4 = new Maze(6,6);
		maze4.generate(2);
		maze5 = new Maze(6,6);
		maze5.generate(8);
		solvedTest1 = "+ +-+-+-+\n" + 
					  "|# # #| |\n" + 
					  "+-+-+ + +\n" + 
					  "| |# #| |\n" + 
					  "+ + +-+ +\n" + 
					  "| |#|   |\n" + 
					  "+ + +-+ +\n" + 
					  "|  # # #|\n" + 
					  "+-+-+-+ +\n";
		solvedTest2 = "+ +-+-+-+-+\n" + 
					  "|# # #|# #|\n" + 
					  "+-+-+ + + +\n" + 
					  "| |# #|#|#|\n" + 
					  "+ + +-+ + +\n" + 
					  "| |#|  #|#|\n" + 
					  "+ + + + + +\n" + 
					  "|# #| |#|#|\n" + 
					  "+ +-+-+ + +\n" + 
					  "|# # # #|#|\n" + 
					  "+-+-+-+-+ +\n";
		solvedTest3 = "+ +-+-+-+-+-+\n" + 
					"|# # #|# # #|\n" + 
					"+-+-+ + +-+ +\n" + 
					"| |# #|# #|#|\n" + 
					"+ + +-+-+ + +\n" + 
					"| |#|  # #|#|\n" + 
					"+ + + + +-+ +\n" + 
					"|# #| |#| |#|\n" + 
					"+ +-+ + + + +\n" + 
					"|#|   |#| |#|\n" + 
					"+ +-+-+ + + +\n" + 
					"|# # # #|  #|\n" + 
					"+-+-+-+-+-+ +\n";
		solvedTest4 = "+ +-+-+-+-+-+\n" + 
					"|# #| |     |\n" + 
					"+-+ + + + + +\n" + 
					"| |#|   | | |\n" + 
					"+ + + +-+ + +\n" + 
					"| |#|   | | |\n" + 
					"+ + +-+ + + +\n" + 
					"| |#|   | | |\n" + 
					"+ + +-+-+ +-+\n" + 
					"|# #|# #|   |\n" + 
					"+ +-+ + +-+ +\n" + 
					"|# # #|# # #|\n" + 
					"+-+-+-+-+-+ +\n";
		solvedTest5 ="+ +-+-+-+-+-+\n" + 
					"|# # #|     |\n" + 
					"+-+-+ +-+-+ +\n" + 
					"|   |# # # #|\n" + 
					"+ +-+-+-+-+ +\n" + 
					"|# # # # # #|\n" + 
					"+ +-+-+-+-+-+\n" + 
					"|# # #|# #| |\n" + 
					"+-+-+ + + + +\n" + 
					"|   |#|#|# #|\n" + 
					"+ +-+ + +-+ +\n" + 
					"|    # #|  #|\n" + 
					"+-+-+-+-+-+ +\n";
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testDraw() {
		Maze test1 = new Maze(4,4);
		test1.generate(5);
		drawer = new MazeDrawer(maze1);
		String[] actual = drawer.drawUnsolved().split("\n");
		String[] expected = new MazeDrawer(test1).drawUnsolved().split("\n");
		int i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		Maze test2 = new Maze(5,5);
		test2.generate(5);
		drawer = new MazeDrawer(maze2);
		actual = drawer.drawUnsolved().split("\n");
		expected = new MazeDrawer(test2).drawUnsolved().split("\n");
		i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		Maze test3 = new Maze(6,6);
		test3.generate(5);
		drawer = new MazeDrawer(maze3);
		actual = drawer.drawUnsolved().split("\n");
		expected = new MazeDrawer(test3).drawUnsolved().split("\n");
		i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		Maze test4 = new Maze(6,6);
		test4.generate(2);
		drawer = new MazeDrawer(maze4);
		actual = drawer.drawUnsolved().split("\n");
		expected = new MazeDrawer(test4).drawUnsolved().split("\n");
		i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		Maze test5 = new Maze(6,6);
		test5.generate(8);
		drawer = new MazeDrawer(maze5);
		actual = drawer.drawUnsolved().split("\n");
		expected = new MazeDrawer(test5).drawUnsolved().split("\n");
		i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		
	}
	
	void testDrawBFS()
	{
		drawer = new MazeDrawer(maze1);
		String[] actual = drawer.drawSolvedPathBFS().split("\n");
		String[] expected = solvedTest1.split("\n");
		int i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		
		drawer = new MazeDrawer(maze2);
		actual = drawer.drawSolvedPathBFS().split("\n");
		expected = solvedTest2.split("\n");
		i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		
		drawer = new MazeDrawer(maze3);
		actual = drawer.drawSolvedPathBFS().split("\n");
		expected = solvedTest3.split("\n");
		i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		
		drawer = new MazeDrawer(maze4);
		actual = drawer.drawSolvedPathBFS().split("\n");
		expected = solvedTest4.split("\n");
		i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		
		drawer = new MazeDrawer(maze5);
		actual = drawer.drawSolvedPathBFS().split("\n");
		expected = solvedTest5.split("\n");
		i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		actual = drawer.drawSolvedPathDFS().split("\n");
		i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
	}
	
	void testDrawDFS()
	{
		drawer = new MazeDrawer(maze1);
		String[] actual = drawer.drawSolvedPathDFS().split("\n");
		String[] expected = solvedTest1.split("\n");
		int i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		
		drawer = new MazeDrawer(maze2);
		actual = drawer.drawSolvedPathDFS().split("\n");
		expected = solvedTest2.split("\n");
		i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		
		drawer = new MazeDrawer(maze3);
		actual = drawer.drawSolvedPathDFS().split("\n");
		expected = solvedTest3.split("\n");
		i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		
		drawer = new MazeDrawer(maze4);
		actual = drawer.drawSolvedPathDFS().split("\n");
		expected = solvedTest4.split("\n");
		i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		
		drawer = new MazeDrawer(maze5);
		actual = drawer.drawSolvedPathDFS().split("\n");
		expected = solvedTest5.split("\n");
		i = 0;
		for(String s: expected) {
			assertEquals(s, actual[i]);
			i++;
		}
		
	}


}
