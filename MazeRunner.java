public class MazeRunner
{
	public static void main(String[] args)
	{
		Maze maze = new Maze(7, 7);
		maze.generate(9);
		MazeDrawer drawer = new MazeDrawer(maze);
		drawer.drawUnsolved();
		System.out.println("BFS");
		drawer.drawSolvedPathBFS();
		drawer.drawSolvedTimedBFS();
		System.out.println("DFS");
		drawer.drawSolvedPathDFS();
		drawer.drawSolvedTimedDFS();
	}
}
