/**

Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


American keyboard


Example 1
Input [Hello, Alaska, Dad, Peace]
Output [Alaska, Dad]
Note
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.

**/

public class Solution {
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        
        String[] keyboard = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> keyMap = new HashMap<>();
        
        for (char c = 'A'; c <= 'Z'; ++c) {
            for (int i = 0; i < keyboard.length; ++i) {
                for (char k : keyboard[i].toCharArray()) {
                    if (c == k) {
                        keyMap.put(c, i);
                    }
                }
            }
        }
        
        for (String w : words) {
            if (w == null || w.isEmpty()) {
                continue;
            }
            
            int index = keyMap.get(w.toUpperCase().charAt(0));
            for (int i = 1; i < w.length(); ++i) {
                if (keyMap.get(w.toUpperCase().charAt(i)) != index) {
                    index = -1;
                    break;
                }
            }
            if (index >= 0) {
                res.add(w);
            }
        }
        
        return res.toArray(new String[0]);
    }
}


/**
	Note:
	
	Use hashmap to avoid duplicate results

**/