/**

Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

**/

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1 || t < 0) {
            return false;
        }
        
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            SortedSet<Long> subSet = set.subSet((long)nums[i] - t, (long)nums[i] + t + 1);
            if (subSet != null && !subSet.isEmpty()) {
                return true;
            } 

            if (set.size() == k) {
                set.remove((long)nums[i - k]);
            }            
    
            set.add((long)nums[i]);
        }

        return false;
    }
}


/**
	Note:
	
	Maintain a window of size k use SortedMap to speed up search a candidate falling into range of [nums[i] - t, nums[i] + t]
	
	Running time: O(NlogK)
	
**/