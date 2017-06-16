/**
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

**/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }

        int ceiling = 0, floor = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (ceiling <= floor && left <= right) {
            for (int i = left; i <= right; ++i) {
                res.add(matrix[ceiling][i]);
            }
            ++ceiling;
            
            for (int i = ceiling; i <= floor; ++i) {
                res.add(matrix[i][right]);
            }
            --right;
            
            if (ceiling <= floor) {
                for (int i = right; i >= left; --i) {
                    res.add(matrix[floor][i]);
                }
            }
            --floor;

            if (left <= right) {
                for (int i = floor; i >= ceiling; --i) {
                    res.add(matrix[i][left]);
                }
            }
            ++left;
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