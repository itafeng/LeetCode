/**

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

**/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int maxLen = 1;
        
        for (int i = 0; i < s.length(); ++i) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int len = 1;
            for (int j = i + 1; j < s.length(); ++j) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                ++len;
                maxLen = Math.max(maxLen, len);                    
            }
        }
        
        return maxLen;
    }
}


/**
	
	O(N^2)

**/