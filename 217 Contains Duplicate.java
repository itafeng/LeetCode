/**

Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

**/

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i : nums) {
            hash.put(i, hash.getOrDefault(i, 0) + 1);
            if (hash.get(i) > 1) {
                return true;
            }
        }
        
        return false;
    }
}

/**
	Note:
	
	Naive way - use hashmap to keep track of number of occurrance of each number
	
**/