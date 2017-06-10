/**
	You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).

**/

public class Solution {
    public int trap(int[] height) {
        int res = 0;
        
        if (height == null || height.length == 0) {
            return res;
        }
        
        int maxLeftHeight = height[0];
        int maxRightHeight = height[height.length - 1];
        
        int left = 1, right = height.length - 2;
        
        while (left <= right) {
            if (maxLeftHeight < maxRightHeight) {
                res += Math.max(0, maxLeftHeight - height[left]);
                maxLeftHeight = Math.max(maxLeftHeight, height[left]);
                ++left;
            }
            else {
                res += Math.max(0, maxRightHeight - height[right]);
                maxRightHeight = Math.max(maxRightHeight, height[right]);
                --right;
            }
        }
        
        return res;
    }
}

/**
	Note:
	
	Two pointers
	Corner case: [2, 0, 2] left <= right

**/