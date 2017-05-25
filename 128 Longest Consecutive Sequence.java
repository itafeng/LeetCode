/**

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

**/

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        
        for (int i : nums) {
            set.add(i);
        }
        
        int maxLen = 0;
        for (int i : nums) {
            if (!set.contains(i)) {
                continue;
            }
            set.remove(i);
            
            int up = i + 1;
            while (set.contains(up)) {
                set.remove(up);
                ++up;
            }
            
            int down = i - 1;
            while (set.contains(down)) {
                set.remove(down);
                --down;
            }
            
            int len = up - down - 1;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;        
    }
}

/**
	Note:
	
	

**/