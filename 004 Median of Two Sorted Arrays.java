/**

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

**/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalNum = nums1.length + nums2.length;
        if (totalNum % 2 == 1) {
            return (double) findKthSmallest(nums1, 0, nums2, 0, totalNum / 2 + 1);
        }
        else {
            int left = findKthSmallest(nums1, 0, nums2, 0, totalNum / 2);
            int right = findKthSmallest(nums1, 0, nums2, 0, totalNum / 2 + 1);
            return (double) (left + right) / 2.0;
        }
    }
    
    private int findKthSmallest(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        
        int mid1 = (start1 + k / 2 - 1 < nums1.length) ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (start2 + k / 2 - 1 < nums2.length) ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
        
        if (mid1 < mid2) {
            return findKthSmallest(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        }
        else {
            return findKthSmallest(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    
    }
}

/**
	
	1. Compare A[k/2 - 1] to B[k/2 - 1], if A[k/2 - 1] > B[k/2 - 1] discard B[0 .. k/2 - 1] and find k - k/2 numbers in subarrays A[0 .. k/2-1] and B[k/2 .. B.length-1]
	2. If A or B does not have k/2 th number, set it to Integer.MAX_VALUE

**/