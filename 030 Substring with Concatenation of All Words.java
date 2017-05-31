/**
	You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).

**/


public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        
        if (s == null || s.length() == 0) {
            return res;
        }
        
        Map<String, Integer> hash = new HashMap<>();
        for (String word : words) {
            hash.put(word, hash.getOrDefault(word, 0) + 1); 
        }
        
        int wLen = words[0].length();
        for (int i = 0; i <= s.length() - words.length * wLen; ++i) {
            Map<String, Integer> toMatch = new HashMap<>(hash);
            for (int j = 0; j < words.length; ++j) {
                String subStr = s.substring(i + j * wLen, i + j * wLen + wLen);
                if (!toMatch.containsKey(subStr)) {
                    break;
                }
                if (toMatch.get(subStr) == 1) {
                    toMatch.remove(subStr);
                }
                else {
                    toMatch.put(subStr, toMatch.get(subStr) - 1);
                }
                if (toMatch.isEmpty()) {
                    res.add(i);
					break;
                }
            }
        }
        
        return res;
    }
}

/**
	Note:
	
	Use hashmap to keep track of words to match

**/