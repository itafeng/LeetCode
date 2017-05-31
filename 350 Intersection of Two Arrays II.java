/**

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

**/

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> hash = new HashMap<>();
        
        for (int i : nums1) {
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }
        
        for (int j : nums2) {
            if (hash.containsKey(j)) {
                res.add(j);
                if (hash.get(j) > 1) {
                    hash.put(j, hash.get(j) - 1);
                } 
                else {
                    hash.remove(j);
                }
            }
        }
        
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}


/**
	Note:

	Follow up:
	1. What if the given array is already sorted? How would you optimize your algorithm?
	Merge sort

	What if nums1's size is small compared to nums2's size? Which algorithm is better?
	Loop through the smaller array and performs binary search on the larger array
	
	What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?	
	Load elements of nums2 batch by batch and combine the results
	

**/