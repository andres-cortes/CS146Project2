import java.util.ArrayList;

public class Maze
{
	private int height;
	private int width;
	private ArrayList<Cell> cells;

	public Maze(int height, int width)
	{
		this.height = height;
		this.width = width;
		cells = new ArrayList<>();
		int dim = height * width;
		for (int i = 0; i < dim; i++)
		{
			cells.add(new Cell());
		}
	}

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}

	public void generate(int seed)
	{
		// maze indexes as follows (for a 3x4 maze):
		// 01234
		// 56789
		// ABCDE
		// cells can link to the cell on the left or right of them (index -1 or index
		// +2)
		// cells can also link to cell above or below it (index + width or index -
		// width)
		// the entrance for a maze is always at index 0, the exit is at the last index
		// (height*width -1)
		// by default, all cells start with color = white
		// if an encountered cell is grey, do not knock down wall

	}
}
