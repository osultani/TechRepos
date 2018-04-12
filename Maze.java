//Omar Sultani
//Project 5 Maze
//Stein

package Project5;


import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

@SuppressWarnings("unused")
public class Maze {

	String[][] maze;
	boolean Complete = false;

	public Maze() {
		maze = new String[41][41];
	}

	public static void main(String[] args) throws IOException {
		Maze obj = new Maze();
		obj.printGuide();
		obj.readCSV();
		obj.solveMaze(0, 27);
		obj.printMaze();
		obj.printGuide2();

	}

	//Prints guide for maze
	public void printGuide(){
		System.out.println("--Guide--");
		System.out.println("1. Correct Path Indicated by '.' (Period)");
		System.out.println("2. Paths Visited And Backtracked Indicated By 'V' ");
		System.out.println("");
		
	}
	//Prints end statement for solved maze
	public void printGuide2() {
		System.out.println("\nMaze Has Been Solved And Is Displayed With The Correct Path!");
		
	}

	public void solveMaze(int x, int y) {
		
		//Prints character assigned to show correct path
		maze[x][y] = ".";
		if (x == 40 && y == 17) {

			Complete = true;
			return;
		}

		//Prints paths that were visited
		if (y - 1 > 0 && maze[x][y - 1].equals("1") && !Complete) {
			
			solveMaze(x, y - 1);
			if (!Complete)
				maze[x][y - 1] = "v";
		}

		//Prints paths that were visited
		if (y + 1 < 40 && maze[x][y + 1].equals("1") && !Complete) {
		
			solveMaze(x, y + 1);
			if (!Complete)
				maze[x][y + 1] = "v";
		}
		
		//Prints paths that were visited
		if (x - 1 > 0 && maze[x - 1][y].equals("1") && !Complete) {
			
			solveMaze(x - 1, y);
			if (!Complete)
				maze[x - 1][y] = "v";
		}
		
		//Prints paths that were visited
		if (x + 1 <= 40 && maze[x + 1][y].equals("1") && !Complete) {
		
			solveMaze(x + 1, y);
			if (!Complete)
				maze[x + 1][y] = "v";
		}
	}

	//Prints completed maze showing appropriate path and visited paths
	public void printMaze() {
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze[0].length; col++) {
				System.out.print(maze[row][col] + " ");
			}
			System.out.println();
			
		}
	}

	//Reads Maze.csv file
	public void readCSV() throws IOException {
		BufferedReader br1 = null;

		String line = " ";
		try {
			br1 = new BufferedReader(new FileReader("/Users/sulom/Documents/Comp 182 Java Projects/Project 5/Maze.csv"));
			br1.readLine();
			int row = 0;
			while ((line = br1.readLine()) != null) {
				String[] m = line.split(",");

				for (int i = 0; i < m.length - 1; i++) {
					maze[row][i] = m[i + 1];
				}
				row++;
			}
		} catch (IOException e) {
	}
}
}
