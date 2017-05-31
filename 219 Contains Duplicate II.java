/**

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

**/

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        
        Map<Integer, Integer> hash = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            if (!hash.containsKey(nums[i])) {
                hash.put(nums[i], i);
            }
            else {
                if (i - hash.get(nums[i]) <= k) {
                    return true;
                }
                hash.put(nums[i], i);
            }
        }
        return false;
    }
}

/**
	Note:
	
	Naive way - use hashmap to keep track of number of occurrance of each number
	
**/