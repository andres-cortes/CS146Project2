import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MazeTest
{
	Maze maze;

	@BeforeEach
	void setUp() throws Exception
	{
		maze = new Maze(5, 5);
	}

	@AfterEach
	void tearDown() throws Exception
	{

	}

	@Test
	void testLoops()
	{

	}

	@Test
	void testAllCellsVisited()
	{
		ArrayList<Cell> cells = maze.getCells();
		for (Cell c : cells)
		{
			assert (c.getColor() == 0); // before maze generated, cells must be white
		}
		maze.generate(5);

		for (Cell c : cells)
		{
			assert (c.getColor() != 0); // after maze generated, cells must not be white
		}
	}

	@Test
	void testPath()
	{
		maze.solveDFS();
		ArrayList<Cell> cells = maze.getCells();
		for (Cell c : cells)
		{
			// System.out.println(c.getColor());
			// assert (c.getColor() != 0);
		}
		// assert (cells.get(maze.getHeight() * maze.getWidth() - 1).getColor() == 1);
	}

}
