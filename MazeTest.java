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

	/**
	 * To test for loops in a graph, execute DFS and assert that no more than two
	 * grey cells can be seen from any newly cell (the first grey cell would be the
	 * previously visited cell)
	 */
	@Test
	void testLoops()
	{
		maze.generate(5);
		ArrayList<Cell> cells = maze.getCells();
		// all cell colors back to white
		for (Cell c : cells)
		{
			c.setColor(0);
		}
		DFS(cells.get(0), maze);
	}

	private boolean DFS(Cell c, Maze maze)
	{
		ArrayList<Cell> cells = maze.getCells();
		c.setColor(1);

		// check if there are more than two non-white squares
		int n = 0;
		if (c.hasEastNeighbor() && c.getEast().getColor() != 0)
			n++;
		if (c.hasSouthNeighbor() && c.getSouth().getColor() != 0)
			n++;
		if (c.hasWestNeighbor() && c.getWest().getColor() != 0)
			n++;
		if (c.hasNorthNeighbor() && c.getNorth().getColor() != 0)
			n++;
		assert (n < 2);

		// ****************everything beyond here is the same as DFSVisit in Maze.Java
		// end found return true
		if (c == cells.get(maze.getHeight() * maze.getWidth() - 1))
		{
			return true;
		}
		else if (c.deadEnd() && c != cells.get(0))
		{ // dead end return false
			c.setColor(2);
			return false;
		}
		if (c.hasEastNeighbor() && c.getEast().getColor() == 0)
		{
			if (DFS(c.getEast(), maze))
			{
				return true;
			}
		}
		if (c.hasSouthNeighbor() && c.getSouth().getColor() == 0)
		{
			if (DFS(c.getSouth(), maze))
			{
				return true;
			}

		}
		if (c.hasWestNeighbor() && c.getWest().getColor() == 0)
		{
			if (DFS(c.getWest(), maze))
			{
				return true;
			}
		}
		if (c.hasNorthNeighbor() && c.getNorth().getColor() == 0)
		{
			if (DFS(c.getNorth(), maze))
			{
				return true;
			}
		}

		c.setColor(2);
		return false;
	}

	/**
	 * Will test that the maze generation procedure visits all cells Since the color
	 * of the cell is changed when it is visited, test color
	 */
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

	/**
	 * Will test that there is a valid path from first cell (entrance) to last cell
	 * (exit). Since DFS starts at first cell, and creates a path as it traverses,
	 * it is only necessary to test if the last node has been visited
	 */
	@Test
	void testPath()
	{
		maze.generate(5);
		maze.solveDFS();
		ArrayList<Cell> cells = maze.getCells();
		assert (cells.get(maze.getHeight() * maze.getWidth() - 1).getColor() == 1);
	}

}
