/**
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

**/

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        boolean[][] dp = new boolean[2][p.length() + 1];
        
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); ++i) {
            dp[0][i] = p.charAt(i - 1) == '*' ? dp[0][i - 1] : false;
        }
        
        for (int i = 1; i <= s.length(); ++i) {
            dp[i % 2][0] = false;
            for (int j = 1; j <= p.length(); ++j) {
                if (p.charAt(j - 1) == '?') {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1];
                }
                else if (p.charAt(j - 1) == '*') {
                    dp[i % 2][j] = dp[i % 2][j - 1] || dp[(i - 1) % 2][j]; 
                }
                else {
                    dp[i % 2][j] = s.charAt(i - 1) == p.charAt(j - 1) ? dp[(i - 1) % 2][j - 1] : false;
                }
            }
        }
        return dp[s.length() % 2][p.length()];
    }
} 

/**
	Note:
	
	2-Dimensional DP
	Let dp[i][j] be if wildcard pattern p[0..j] matches string s[0..i]
	
	dp[i][j] = dp[i - 1][j - 1], if p[j] == s[j] || p[j] == '?'
	           dp[i][j - 1] || dp[i - 1][j], if p[j] == '*' ('*' matches 0 characters or '*' matches arbitrary number of characters)

**/