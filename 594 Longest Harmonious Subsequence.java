/**

We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
Note: The length of the input array will not exceed 20,000.

**/

public class Solution {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        TreeMap<Integer, Integer> hash = new TreeMap<>();
        for (int n : nums) {
            hash.put(n, hash.getOrDefault(n, 0) + 1);
        }
        
        int maxLen = 0;
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            int key = entry.getKey();
            if (!hash.containsKey(key + 1)) {
                continue;
            }
            
            maxLen = Math.max(maxLen, entry.getValue() + hash.get(key + 1));
        }
        
        return maxLen;
    }
}

/**
	Note: 
	Use SortedMap to save the number of instances of each value
	

**/