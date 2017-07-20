/**

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"

**/

public class Solution {
    private int subStrStart = 0;
    private int subStrEnd = 0;
    private int maxLen = 1;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); ++i) {
            getMaxPalindrome(s, i - 1, i + 1);
            getMaxPalindrome(s, i, i + 1);
        }
        
        return s.substring(subStrStart, subStrEnd + 1);
    }
    
    private void getMaxPalindrome(String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            --start;
            ++end;
        }
       
        ++start;
        --end;
        
        if (start >= 0 && end < s.length() && end - start + 1 > maxLen) {
            maxLen = end - start + 1;
            subStrStart = start;
            subStrEnd = end;
        }
    }
}


/**
	Note:
	
	Discuss two scenarios:
	1. Palindromic string has odd number of characters
	2. Palindromic string has even number of characters
	
**/