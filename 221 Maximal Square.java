/**

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.


**/

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int maxLen = 0;
        int[][] dp = new int[2][matrix[0].length + 1];
        
        for (int i = 1; i <= matrix.length; ++i) {
            for (int j = 1; j <= matrix[0].length; ++j) {
                dp[i % 2][j] = matrix[i - 1][j - 1] == '0' ? 0 : Math.min(dp[(i - 1) % 2][j - 1], Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1])) + 1;
                
                maxLen = Math.max(maxLen, dp[i % 2][j]);
            }
        }
        
        return maxLen * maxLen;
    }
}

/**
	Note:
	
	2D DP
	
	dp[i][j] = matrix[i - 1][j - 1] == '0' ? 0 : min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j])
	
	
**/