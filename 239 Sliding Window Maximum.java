/**

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

**/


public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return new int[0];
        }
        
        List<Integer> res = new ArrayList<>();
        
        Deque<Integer> window = new LinkedList<>();
        
        for (int i = 0; i < k - 1; ++i) {
            enQueue(window, nums[i]);
        }
        
        for (int i = k - 1; i < nums.length; ++i) {
            enQueue(window, nums[i]);
            res.add(window.peekFirst());
            deQueue(window, nums[i - k + 1]);
        }
        
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            ans[i] = res.get(i);
        }
        
        return ans;
        
    }
    
    private void enQueue(Deque<Integer> window, int num) {
        while (!window.isEmpty() && window.peekLast() < num) {
            window.pollLast();
        }
        window.offerLast(num);
    }
    
    private void deQueue(Deque<Integer> window, int num) {
        if (!window.isEmpty() && window.peekFirst() == num) {
            window.pollFirst();
        }
    }
}


/**
	
	Maintain a monotonically descrasing deque
	
	The max element is in the front of the queue.
	Remove element from head and push new element to the end of the queue before removing the smaller elements
	
	
 **/