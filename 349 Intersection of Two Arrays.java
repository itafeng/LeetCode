/**

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

**/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        
        for (int i : nums2) {
            if (!set.contains(i)) {
                continue;
            }
            res.add(i);
            set.remove(i);
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
	
	Three approach to address the intersection problem:
	1. Hashtable
	2. If two arrays are sorted, use merge sort. O(N + M)
	3. If arrays are sorted, one (N) is much larger than the other (M). Loop through the smaller array and perform binary search on the big one. O(MlogN)


**/