/**

200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

**/


public class Solution {
    class UnionFind {
        int[] root = null;
        int numOfElements;
        int numOfSets;
        
        public UnionFind(int elements, int sets) {
            numOfElements = elements;
            numOfSets = sets;
            root = new int[elements];
            for (int i = 0; i < elements; ++i) {
                root[i] = i;
            }
        }
        
        public int find(int x) {
            if (root[x] == x) {
                return x;
            }
            root[x] = find(root[x]);
            return root[x];
        }
        
        public void connect(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            
            if (rootA != rootB) {
                root[rootA] = rootB;
                --numOfSets;
            }
        }
        
        public int query() {
            return numOfSets;
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int islands = 0;
        
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '1') {
                    ++islands;
                }
            }
        }
        
        UnionFind uf = new UnionFind(rows * cols, islands);
        
        int[] deltaX = new int[] {1, -1, 0, 0};
        int[] deltaY = new int[] {0, 0, 1, -1};
        
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] != '1') {
                    continue;
                }
                
                for (int k = 0; k < 4; ++k) {
                    int x = i + deltaX[k];
                    int y = j + deltaY[k];
                    
                    if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == '0') {
                        continue;
                    }
                    
                    uf.connect(i * cols + j, x * cols + y);
                }
            }
        }
        
        return uf.query();
    }
}

/**
	Note:
	
	Use union find to merge adjacent islands

**/