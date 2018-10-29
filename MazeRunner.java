public class MazeRunner
{
	public static void main(String[] args)
	{
		Maze maze = new Maze(6, 6);
		maze.generate(14);
		MazeDrawer drawer = new MazeDrawer(maze);
		drawer.drawUnsolved();
	}
}
