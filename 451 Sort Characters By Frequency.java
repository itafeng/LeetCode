/**

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

**/

//Solution I: HashMap + Bucket Sort O(N)

public class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> freqTable = new HashMap<>();
        for (Character c : s.toCharArray()) {
            freqTable.put(c, freqTable.getOrDefault(c, 0) + 1);
        }
        
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        
        for (Map.Entry<Character, Integer> entry : freqTable.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new ArrayList<Character>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }
        
        for (int i = s.length(); i > 0; --i) {
            if (buckets[i] == null) {
                continue;
            }
            for (Character c : buckets[i]) {
                for (int j = 0; j < i; ++j) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}

//Solution II: HashMap + PriorityQueue O(NlogN)

public class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> freqTable = new HashMap<>();
        for (Character c : s.toCharArray()) {
            freqTable.put(c, freqTable.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>(){
            @Override
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                return b.getValue() - a.getValue();
            }
        }); 
        
        heap.addAll(freqTable.entrySet());
        
        while (!heap.isEmpty()) {
            Map.Entry<Character, Integer> entry = heap.poll();
            for (int i = 0; i < entry.getValue(); ++i) {
                sb.append(entry.getKey());
            }
        }
                
        return sb.toString();
    }
}



/**
	Note:
	
	1. HashMap + Bucket Sort
	2. HashMap + PriorityQueue
		
**/