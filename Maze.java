import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Maze
{
	private int height;
	private int width;
	private int totalCells;
	private ArrayList<Cell> cells;
	private int time;

	// I AM TESTING
	public Maze(int height, int width)
	{
		this.height = height;
		this.width = width;
		cells = new ArrayList<>();
		totalCells = height * width;
		// populate map with appropriate amount of cells
		for (int i = 0; i < totalCells; i++)
		{
			cells.add(new Cell());
		}
	}

	public void generate(int seed)
	{
		// maze indexes as follows (for a 3x4 maze):
		// 01234
		// 56789
		// ABCDE
		// cells can link to the cell on the left or right of them (index -1 or index
		// +1)
		// cells can also link to cell above or below it (index + width or index -
		// width)
		// the entrance for a maze is always at index 0, the exit is at the last index
		// (totalCells -1)
		// by default, all cells start with color = white
		// if an encountered cell is grey, do not knock down wall
		Random rand = new Random(seed);
		Stack<Integer> stack = new Stack<>();

		// note that currentIndex and the current cell are both given variables to
		// reduce amount of accessing the cell ArrayList
		Cell current = cells.get(0);
		int currentIndex = 0;
		int visitedCells = 1; // because we start at cell 0 so it's "visited"

		while (visitedCells < totalCells)
		{
			// current cell has been visited
			current.setColor(Cell.GREY);
			// array will keep track of neighbors that are valid to visit, -1 indicates that
			// it is invalid
			int possibleNextIndex[] =
			{ -1, -1, -1, -1 };
			// check west, make sure not along west border, and that west cell is white
			if (currentIndex % width != 0 && cells.get(currentIndex - 1).getColor() == Cell.WHITE)
			{
				possibleNextIndex[0] = currentIndex - 1;
			}
			// check north, make sure not along north border, and that north cell is white
			if (currentIndex >= width && cells.get(currentIndex - width).getColor() == Cell.WHITE)
			{
				possibleNextIndex[1] = currentIndex - width;
			}
			// check east, make sure not along east border, and that east cell is white
			if (currentIndex % width != width - 1 && cells.get(currentIndex + 1).getColor() == Cell.WHITE)
			{
				possibleNextIndex[2] = currentIndex + 1;
			}
			// check south, make sure not along south border, and that south cell is white
			if (currentIndex + width < totalCells && cells.get(currentIndex + width).getColor() == Cell.WHITE)
			{
				possibleNextIndex[3] = currentIndex + width;
			}
			// *****************************************************************************************************
			// if none of above conditions met, dead end, go back ( current = pop off stack)
			if (possibleNextIndex[0] == -1 && possibleNextIndex[1] == -1 && possibleNextIndex[2] == -1
					&& possibleNextIndex[3] == -1)
			{
				currentIndex = stack.pop();
				current = cells.get(currentIndex);
			}

			// else, use rand to decide next current. push current onto stack
			// current will be linked to new current. increment visited cells
			else
			{
				boolean chosen = false;
				double decide;
				visitedCells++;
				// loop will guarantee that a cell will be visited, a better implementation
				// would not check every direction, and only check valid directions (valid as
				// defined above)

				while (!chosen)
				{
					decide = rand.nextDouble();
					if (decide <= 0.25)
					{
						// go west
						if (possibleNextIndex[0] != -1)
						{
							// repeated code, can move this to a helper function
							int next = possibleNextIndex[0];
							chosen = true;
							// link west cell to current
							current.setWest(cells.get(next));
							// push current onto stack (so we can backtrack if necessary)
							stack.push(currentIndex);
							// move current to newly linked cell
							currentIndex = next;
							current = cells.get(next);
						}
					}
					else if (decide <= 0.50)
					{
						// go north
						if (possibleNextIndex[1] != -1)
						{
							int next = possibleNextIndex[1];
							chosen = true;
							current.setNorth(cells.get(next));
							stack.push(currentIndex);
							currentIndex = next;
							current = cells.get(next);
						}
					}
					else if (decide <= 0.75)
					{
						// go east
						if (possibleNextIndex[2] != -1)
						{
							int next = possibleNextIndex[2];
							chosen = true;
							current.setEast(cells.get(next));
							stack.push(currentIndex);
							currentIndex = next;
							current = cells.get(next);
						}
					}
					else if (decide <= 1.00)
					{
						// go south
						if (possibleNextIndex[3] != -1)
						{
							int next = possibleNextIndex[3];
							chosen = true;
							current.setSouth(cells.get(next));
							stack.push(currentIndex);
							currentIndex = next;
							current = cells.get(next);
						}
					}
				} // end inner while loop (make sure a direction is chosen)

			} // end else
		} // end outer while loop (visit all cells)
		current.setColor(Cell.GREY); // last cell is visited, but did not have while loop executed. So change color
										// to GREY here
	}

	// set cells white for solving after it's drawn and time discovered -1
	private void erase()
	{
		for (Cell c : cells)
		{

			c.setColor(0);
			c.setTimeDisc(-1);
		}
	}

	public void solveBFS()
	{
		erase();
		time = 0;
		Queue<Cell> queue = new LinkedList<Cell>();
		Cell currentCell = cells.get(0);
		currentCell.setColor(1);
		currentCell.setTimeDisc(time);
		time++;

		// loop will execute until exit cell is found
		while (currentCell != cells.get(totalCells - 1))
		{
			// if cell is not a dead end (starting cell doesnt count as a dead end)
			if (!currentCell.deadEnd() || currentCell == cells.get(0))
			{
				// add neighbors to queue, set discovery time.
				if (currentCell.hasEastNeighbor() && currentCell.getEast().getColor() == 0)
				{
					queue.add(currentCell.getEast());
					currentCell.getEast().setTimeDisc(time);
					time++;

				}
				if (currentCell.hasWestNeighbor() && currentCell.getWest().getColor() == 0)
				{
					queue.add(currentCell.getWest());
					currentCell.getWest().setTimeDisc(time);
					time++;

				}
				if (currentCell.hasSouthNeighbor() && currentCell.getSouth().getColor() == 0)
				{
					queue.add(currentCell.getSouth());
					currentCell.getSouth().setTimeDisc(time);
					time++;

				}
				if (currentCell.hasNorthNeighbor() && currentCell.getNorth().getColor() == 0)
				{
					queue.add(currentCell.getNorth());
					currentCell.getNorth().setTimeDisc(time);
					time++;
				}
				currentCell.setColor(1);
			}
			// if a dead end, set color to black, check if neighbors are black as well, if
			// not, set them black. (for drawer)
			else
			{
				while (currentCell.deadEnd() && currentCell != cells.get(0))
				{
					currentCell.setColor(2);
					if (currentCell.hasEastNeighbor() && currentCell.getEast().getColor() != 2)
						currentCell = currentCell.getEast();
					else if (currentCell.hasSouthNeighbor() && currentCell.getSouth().getColor() != 2)
						currentCell = currentCell.getSouth();
					else if (currentCell.hasWestNeighbor() && currentCell.getWest().getColor() != 2)
						currentCell = currentCell.getWest();
					else if (currentCell.hasNorthNeighbor() && currentCell.getNorth().getColor() != 2)
						currentCell = currentCell.getNorth();

				}
			}
			// current cell equal to first cell it saw
			currentCell = queue.poll();
		}

		// set current cell grey
		currentCell.setColor(1);

		// backtrack queue to find dead ends, set their color to black (BFS might finish
		// before visiting all cells,need to set these to black for drawer)
		while (!queue.isEmpty())
		{
			Cell c = queue.poll();
			c.setColor(2);
			if (c.hasEastNeighbor() && c.getEast().getColor() == 1 && c.getEast().deadEnd())
			{
				queue.add(c.getEast());
			}
			if (c.hasWestNeighbor() && c.getWest().getColor() == 1 && c.getWest().deadEnd())
			{
				queue.add(c.getWest());
			}
			if (c.hasNorthNeighbor() && c.getNorth().getColor() == 1 && c.getNorth().deadEnd())
			{
				queue.add(c.getNorth());
			}
			if (c.hasSouthNeighbor() && c.getSouth().getColor() == 1 && c.getSouth().deadEnd())
			{
				queue.add(c.getSouth());
			}

		}
	}

	// DFS uses recursive implementation
	public void solveDFS()
	{
		erase();
		time = 0;
		DFSVisit(cells.get(0));

	}

	// returns true if found the end
	private boolean DFSVisit(Cell c)
	{
		c.setColor(1);
		c.setTimeDisc(time);
		time++;
		// end found return true
		if (c == cells.get(totalCells - 1))
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
			if (DFSVisit(c.getEast()))
			{
				return true;
			}
		}
		if (c.hasSouthNeighbor() && c.getSouth().getColor() == 0)
		{
			if (DFSVisit(c.getSouth()))
			{
				return true;
			}

		}
		if (c.hasWestNeighbor() && c.getWest().getColor() == 0)
		{
			if (DFSVisit(c.getWest()))
			{
				return true;
			}
		}
		if (c.hasNorthNeighbor() && c.getNorth().getColor() == 0)
		{
			if (DFSVisit(c.getNorth()))
			{
				return true;
			}
		}

		c.setColor(2);
		return false;
	}

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}

	public ArrayList<Cell> getCells()
	{
		return cells;
	}

}
