/**

Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.

Example:
Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True
Note:

All the input integers are in the range [-10000, 10000].
A valid square has four equal sides with positive length and four equal angles (90-degree angles).
Input points have no order.


**/

public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d12 = getDist(p1, p2);
        int d14 = getDist(p1, p4);
        int d34 = getDist(p4, p3);
        int d13 = getDist(p1, p3);
        int d23 = getDist(p3, p2);
        int d24 = getDist(p2, p4);
        
        
        
        if (d12 > 0 && d13 > 0 && d14 > 0 && d12 == d34 && d13 == d24 && d14 == d23) {
            if (d12 == d13 || d12 == d14) {
                // (1,2) is edge
                return true;
            }
            else {
                // (1,2) is diagonal
                if (d13 == d23) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private int getDist(int[] p1, int[] p2) {
        return (int) (Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }
}


/**
	Note: 
	A polygon is a square if it satisfies the following conditions:
	- Length of four edges are equal
	- Length of two diagonals are equal
	
	Discuss the two possibilities of (1,2): 1) an edge 2) a diagonal

	Corner cases: some points are overlapped	

**/