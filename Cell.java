public class Cell
{
	// could also use enums or Java Color class. Would not change overall
	// implementation
	public static final int WHITE = 0;
	public static final int GREY = 1;
	public static final int BLACK = 2;
	private int color;
	// could also use an array of Cells
	private Cell west;
	private Cell east;
	private Cell north;
	private Cell south;
	private int timeDisc;

	public Cell()
	{
		color = WHITE;
		west = null;
		east = null;
		north = null;
		south = null;
		timeDisc = -1; // when not discovered
	}

	// neighbor cell is a cell you can move to, aka does not have wall between
	// current cell and neighbor only has one open neighbor that isn't black
	public boolean deadEnd()
	{
		int n = 0;

		if (hasEastNeighbor() && east.getColor() != 2)
			n++;
		if (hasSouthNeighbor() && south.getColor() != 2)
			n++;
		if (hasWestNeighbor() && west.getColor() != 2)
			n++;
		if (hasNorthNeighbor() && north.getColor() != 2)
			n++;

		return n < 2;
	}

	public void setTimeDisc(int timeDisc)
	{
		this.timeDisc = timeDisc;
	}

	// our implementation frequently checks for neighbors, so these boolean
	// functions are provided for convencience
	public boolean hasEastNeighbor()
	{
		if (east == null)
			return false;
		return true;
	}

	public boolean hasSouthNeighbor()
	{
		if (south == null)
			return false;
		return true;
	}

	public boolean hasWestNeighbor()
	{
		if (west == null)
			return false;
		return true;
	}

	public boolean hasNorthNeighbor()
	{
		if (north == null)
			return false;
		return true;
	}

	public void setWest(Cell input)
	{
		west = input;
		input.east = this;
	}

	public void setEast(Cell input)
	{
		east = input;
		input.west = this;
	}

	public void setNorth(Cell input)
	{
		north = input;
		input.south = this;
	}

	public void setSouth(Cell input)
	{
		south = input;
		input.north = this;
	}

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

	public int getTimeDisc()
	{
		return timeDisc;
	}

}
