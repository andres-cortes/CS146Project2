public class MazeRunner
{
	public static void main(String[] args)
	{
		Maze maze = new Maze(5, 6);
		maze.generate(19);
		MazeDrawer drawer = new MazeDrawer(maze);
		drawer.drawUnsolved();
	}
}
