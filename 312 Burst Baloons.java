/**

Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

**/

public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int length = nums.length;
        int[] score = new int[length + 2];
        score[0] = 1;
        score[length + 1] = 1;
        
        for (int i = 0; i < length; ++i) {
            score[i + 1] = nums[i];    
        }
        
        int[][] dp = new int[length + 2][length + 2];

        for (int len = 1; len <= length; ++len) {
            for (int i = 1; i + len - 1 < length + 1; ++i) {
                int j = i + len - 1;
                
                for (int k = i; k <= j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], score[i - 1] * score[k] * score[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
                }
            }
        }
        
        return dp[1][length];
    }
}

/**
	Note:
	
	2-D dynamica programming. 
	1) Recursion with memoization
	2) Bottom-up: bigger range relies on smaller range. Calculate small range first.

**/