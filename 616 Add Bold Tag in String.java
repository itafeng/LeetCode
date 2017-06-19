/**

Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.

Example 1:
Input: 
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"
Example 2:
Input: 
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"
Note:
The given dict won't contain duplicates, and its length won't exceed 100.
All the strings in input have length in range [1, 1000].


**/

public class Solution {
    public String addBoldTag(String s, String[] dict) {
        List<int[]> intervals = new ArrayList<>();
        for (String w : dict) {
            for (int i = 0; i < s.length(); ++i) {
                int idx = s.indexOf(w, i);
                if (idx >= 0) {
                    intervals.add(new int[] {idx, idx + w.length() - 1});
                }
            }
        }
        
        List<int[]> merged = mergeIntervals(intervals);
        
        StringBuilder sb = new StringBuilder();
        
        int lastIdx = -1;
        for (int[] interval : merged) {
            if (lastIdx < interval[0]) {
                sb.append(s.substring(lastIdx + 1, interval[0]));
            }
            sb.append("<b>").append(s.substring(interval[0], interval[1] + 1)).append("</b>");
            lastIdx = interval[1];
        }
        
        if (lastIdx < s.length() - 1) {
            sb.append(s.substring(lastIdx + 1));
        }
        
        return sb.toString();
    }
    
    private List<int[]> mergeIntervals(List<int[]> intervals) {
        List<int[]> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int i = 0;
        while (i < intervals.size()) {
            int start = intervals.get(i)[0];
            int end = intervals.get(i)[1];
            
            int j = i + 1;
            while (j < intervals.size() && intervals.get(j)[0] <= end + 1) {
                end = Math.max(end, intervals.get(j)[1]);
                ++j;
            }
            res.add(new int[]{start, end});
            i = j;
        }
        return res;
    }
    
}

/**

**/