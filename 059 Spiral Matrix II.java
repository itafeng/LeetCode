/**
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

**/

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        int ceiling = 0, floor = n - 1;
        int left = 0, right = n - 1;
        
        int count = 0;
        while (ceiling <= floor && left <= right) {
            for (int i = left; i <= right; ++i) {
                res[ceiling][i] = ++count;
            }
            ++ceiling;
            for (int i = ceiling; i <= floor; ++i) {
                res[i][right] = ++count;
            }
            --right;
            
            if (ceiling <= floor) {
                for (int i = right; i >= left; --i) {
                    res[floor][i] = ++count;
                }
                --floor;
            }
            
            if (left <= right) {
                for (int i = floor; i >= ceiling; --i) {
                    res[i][left] = ++count;
                }
                ++left;
            }
        }
        
        return res;
    }
}
/**
	Note:
	
	Edge cases:
	1. {{2, 3, 4, 5}}
	When going from right to left, check if ceiling <= floor.
	2. {{1}, {2}, {3}}
	When going from bottom to top, check if left <= right.
	
**/