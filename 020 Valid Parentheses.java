/**

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


**/


public class Solution {
    public boolean isValid(String s) {
        Stack<Character> paren = new Stack<>();
        
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    paren.push(c);
                    break;
                    
                case ')':
                case ']':
                case '}':
                    if (paren.isEmpty() || c != findMatch(paren.pop())) {
                        return false;
                    }
                default:
            }
        }
        
        return paren.isEmpty();
    }
                        
    private Character findMatch(Character c) {
        Character match = ' ';
        switch (c) {
            case '(':
                match = ')';
                break;
            case '[':
                match = ']';
                break;
            case '{':
                match = '}';
                break;
            default:    
        }
        return match;
    }                        
}

/**
	Note:
	
	

**/