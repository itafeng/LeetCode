/**

490. The Maze
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
Example 1
Input 1: a maze represented by a 2D array
 
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
 
Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 
Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2
Input 1: a maze represented by a 2D array
 
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
 
Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 
Output: false
Explanation: There is no way for the ball to stop at the destination.

Note:
	1. There is only one ball and one destination in the maze.
	2. Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
	3. The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
	4. The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 

**/

import java.util.*;

public class Maze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,1,0,1,0},
                {0,1,0,1,1},
                {0,0,1,0,0}
		};
		
		int[] start = {0, 4};
		int[] dest = {4, 4};
		
		System.out.println("Can reach = " + hasPath(maze, start, dest));
		
	}

	private static boolean hasPath(int[][] maze, int[] start, int[] dest) {
		
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		
		Queue<int[]> travQueue = new LinkedList<>();
		travQueue.offer(start);
		
		while (!travQueue.isEmpty()) {
			int[] pos = travQueue.poll();
			if (pos[0] == dest[0] && pos[1] == dest[1]) {
				return true;
			}
			
			int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			
			for (int[] dir : dirs) {
				int x = pos[0] + dir[0];
				int y = pos[1] + dir[1];
				
				while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
					x += dir[0];
					y += dir[1];
				}
				
				if (!visited[x - dir[0]][y - dir[1]]) {
					System.out.println(String.format("Visiting location: (%d, %d)" , x - dir[0], y - dir[1]));
					
					travQueue.offer(new int[]{x - dir[0], y - dir[1]});
					visited[x - dir[0]][y - dir[1]] = true;
				}
			}
		}
				
		return false;
	}
}


/**
	Note:
	
	This problem can be solved by BFS or DFS methods.
		
**/