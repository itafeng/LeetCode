/**

There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.

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

Output: 12
Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
             The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

Example 2

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: -1
Explanation: There is no way for the ball to stop at the destination.

Note:
There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 

**/

import java.util.*;

public class MazeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,1,0,0,0},
                {0,1,0,0,1},
                {0,0,0,0,0}
		};
		
		int[] start = {0, 4};
		int[] dest = {4, 4};
		
		System.out.println("Min distance = " + shortestDist(maze, start, dest));
		
	}
	
	
	private static int shortestDist(int[][] maze, int[] start, int[] end) {
		int[][] dist = new int[maze.length][maze[0].length];
		for (int[] row : dist) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		dist[start[0]][start[1]] = 0;
		
		Dijkstra(maze, start, dist);
				
		return dist[end[0]][end[1]] == Integer.MAX_VALUE ? -1 : dist[end[0]][end[1]];
	}
	
	private static void Dijkstra(int[][] maze, int[] start, int[][] dist) {
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		
		heap.offer(new int[]{start[0], start[1], dist[start[0]][start[1]]});
		
		while (!heap.isEmpty()) {
			int[] d = heap.poll();
			
			int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			
			for (int[] dir : dirs) {
				int x = d[0] + dir[0];
				int y = d[1] + dir[1];
				int count = 0;
				while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
					x += dir[0];
					y += dir[1];
					++count;
				}
				
				if (dist[d[0]][d[1]] + count < dist[x - dir[0]][y - dir[1]]) {
					dist[x - dir[0]][y - dir[1]] = dist[d[0]][d[1]] + count;
					heap.offer(new int[]{x - dir[0], y - dir[1], dist[x - dir[0]][y - dir[1]]});
				}
			}
		}
	
	} 
}


/**
	Note:
	
	Dijkstra's algorithm + PriorityQueue
		
**/