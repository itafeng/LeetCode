/**

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

**/

public class Solution {
    public boolean isHappy(int n) {
        if (n == 0) {
            return false;
        }        
        
        int num = getDigitSquareSum(Math.abs(n));
        
        Set<Integer> set = new HashSet<>();
        while (set.add(num)) {
            if (num == 1) {
                return true;
            }
            num = getDigitSquareSum(num);
        }
        return false;        
    }
    
    private int getDigitSquareSum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            sum += digit * digit;
        }
        return sum;
    }
}

/**
	Note:
	
	1. Use hashmap to keep track of visited numbers, O(N) space
	2. Use Floyd circle detection to detect circle, O(1) space
	
**/