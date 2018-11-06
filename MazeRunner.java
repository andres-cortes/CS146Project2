import java.util.Scanner;

public class MazeRunner
{
	public static void main(String[] args)
	{
<<<<<<< HEAD
		Scanner reader = new Scanner(System.in); // Reading from System.in
		boolean valid = false;
		int size = 0;
		while (!valid)
		{
			System.out.print("Enter Size of Maze: ");
			size = reader.nextInt(); // Scans the next token of the input as an int.
			// once finished
			if (size >= 4 && size <= 10 && size != 9)
			{
				valid = true;
			}
			else
			{
				System.out.println("use only 4, 5, 6, 7, 8, or 10");
			}

		}
		System.out.println("\nGraph Size:" + "\nMAZE:");
		Maze maze = new Maze(size, size);
=======
		Maze maze = new Maze(10, 10);
>>>>>>> branch 'master' of https://github.com/andres-cortes/CS146Project2.git
		maze.generate(2);
		MazeDrawer drawer = new MazeDrawer(maze);
		drawer.drawUnsolved();
		System.out.println("BFS");
		drawer.drawSolvedPathBFS();
		drawer.drawSolvedTimedBFS();
		System.out.println("DFS");
		drawer.drawSolvedPathDFS();
		drawer.drawSolvedTimedDFS();
		reader.close();
	}
}
