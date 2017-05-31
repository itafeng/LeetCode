/**

Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.

**/

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        
        Map<Integer, Integer> rankMap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
        
        for (int i = 0; i < nums.length; ++i) {
            rankMap.put(nums[i], i);
        }
        
        int count = 1;
        for (Map.Entry<Integer, Integer> entry : rankMap.entrySet()) {
            String rank = null;
            if (count == 1) {
                rank = "Gold Medal"; 
            }
            else if (count == 2) {
                rank = "Silver Medal";
            }
            else if (count == 3) {
                rank = "Bronze Medal";
            }
            else {
                rank = String.valueOf(count);
            }
            
            res[entry.getValue()] = rank;
            ++count;
        }
        return res;
    }
}


/**
	Note:
	
	Build map for each athlete's score and sort by score. 

**/