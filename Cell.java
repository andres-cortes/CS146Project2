
public class Cell
{
	
	// test yiss
	// something
	public static final int WHITE = 0;
	public static final int GREY = 1;
	public static final int BLACK = 2;
	private int color;
	private Cell west;
	private Cell east;
	private Cell north;
	private Cell south;

	public Cell()
	{
		color = WHITE;
		west = null;
		east = null;
		north = null;
		south = null;
	}

	public void setWest(Cell input)
	{
		west = input;
	}

	public void setEast(Cell input)
	{
		east = input;
	}

	public void setNorth(Cell input)
	{
		north = input;
	}

	public void setSouth(Cell input)
	{
		south = input;
	}

	/*
	 * public Cell[] getNeighbors() { Cell[] ret = { west, north, east, south };
	 * return ret; }
	 */
	public void setColor(int color)
	{
		assert (color == 0 || color == 1 || color == 2);
		this.color = color;
	}

	public int getColor()
	{
		return color;
	}

	public Cell getWest()
	{
		return west;
	}

	public Cell getEast()
	{
		return east;
	}

	public Cell getNorth()
	{
		return north;
	}

	public Cell getSouth()
	{
		return south;
	}

	public boolean hasEastNeighbor()
	{
		if (east == null)
		{
			return false;
		}
		return true;
	}

	public boolean hasSouthNeighbor()
	{
		if (south == null)
		{
			return false;
		}
		return true;
	}
}
