import java.util.ArrayList;

public class MazeDrawer
{
	private Maze maze;
	private int charHeight;
	private int charWidth;
	private ArrayList<Cell> cells;

	public MazeDrawer(Maze maze)
	{
		this.maze = maze;

		// note that char width and height is different from the maze width and height.
		// For each cell, 3 char rows and 3 char columns are used
		// how many rows? 2*height + 1
		charHeight = 2 * maze.getHeight() + 1;
		// how many characters in each row? 2*width + 1
		charWidth = 2 * maze.getWidth() + 1;

		cells = maze.getCells();
	}

	// all draw functions use draw() and provide an integer in the argument. 0
	// signifies drawing an empty graph, 1 draws the path, 2 draws discovery times
	public String drawUnsolved()
	{
		String maze = draw(0);
		System.out.println(maze);
		return maze;
	}

	// you can do these next two functions?
	public String drawSolvedPathBFS()
	{
		maze.solveBFS();
		String solved = draw(1);
		System.out.println(solved);
		return solved;
	}

	public String drawSolvedTimedBFS()
	{
		maze.solveBFS();
		String solved = draw(2);
		System.out.println(solved);
		return solved;
	}

	public String drawSolvedPathDFS()
	{
		maze.solveDFS();
		String solved = draw(1);
		System.out.println(solved);
		return solved;
	}

	public String drawSolvedTimedDFS()
	{
		maze.solveDFS();
		String solved = draw(2);
		System.out.println(solved);
		return solved;
	}

	private String draw(int caller)
	{
		// algorithm for drawing cells:
		// the top row of ASCII characters will only be '-' and '+', with the exception
		// of one space above index 0. The bottom row is the same, but the space is
		// below index totalCells-1.
		//
		// Rows that contain cells will always have a space where the cell is, the '|'
		// wall will be present if the cell has does not link to its neighbor. To make
		// this easy to code, we can always put a '|' as the first character, then a
		// space for the cell, and then check if the cell has an east neighbor. If it
		// does, do not put a '|', etc. For the next row (row without cells), we will re
		// check the same row and check if it has a south neighbor

		int cellIndex = 0;
		// beginning row
		String output = "+ ";
		for (int i = 0; i < charWidth - 3; i++)
		{
			if (i % 2 == 0)
			{
				output += "+";
			}
			else
			{
				output += "-";
			}
		}
		output += "+\n";
		// other rows, excluding first and last row
		// i = row index
		for (int i = 0; i < charHeight - 2; i++)
		{
			// first chars
			if (i % 2 == 0)
			{
				output += "|";
			}
			else
			{
				output += "+";
			}

			// next chars
			for (int j = 0; j < charWidth - 1; j++)
			{
				// if in row 1,3,5,7 (row 0 already filled. In this for loop, they are row 0, 2,
				// 4, etc) These rows contain cells
				if (i % 2 == 0)
				{
					// even char indexes are cells (remember counting starts at 0, the first wall
					// has already been included)
					if (j % 2 == 0)
					{
						switch (caller)
						{
						// case 0: Unsolved call
						case 0:
							output += " ";
							break;
						// case 1: draw solvedPath BFS
						case 1:
							if (cells.get(cellIndex).getColor() == Cell.GREY)
								output += "#";
							else
								output += " ";
							break;
						// case 2: draw timed BFS
						case 2:
							int timeDisc = cells.get(cellIndex).getTimeDisc();
							if (timeDisc > -1)
							{
								if (timeDisc > 9)
									timeDisc = timeDisc % 10;
								output += timeDisc;
							}
							else
								output += " ";
							break;

						}

					}
					// odd char indexes are walls
					else
					{
						if (cells.get(cellIndex).hasEastNeighbor())
						{
							output += " ";
						}
						else
						{
							output += "|";
						}
						cellIndex++;
					}

				}
				// else in row 2,4,6,8
				else
				{
					if (j % 2 == 0)
					{
						if (cells.get(cellIndex).hasSouthNeighbor())
						{
							output += " ";
						}
						else
						{
							output += "-";
						}
						cellIndex++;
					}
					else
					{
						output += "+";
					}
				}
			}
			if (i % 2 == 0)
			{
				cellIndex = cellIndex - maze.getWidth();
			}
			output += "\n";

		}
		// last row
		for (int i = 0; i < charWidth - 3; i++)
		{
			if (i % 2 == 0)
			{
				output += "+";
			}
			else
			{
				output += "-";
			}
		}
		output += "+ +\n";
		return output;
	}
}
