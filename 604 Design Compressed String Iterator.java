/**

Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.

The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.

next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.

Note:
Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.

Example:

StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' '

**/

public class StringIterator {
    private Queue<int[]> q = null;

    public StringIterator(String compressedString) {
        q = new LinkedList<>();
        int i = 0;
        char letter = ' ';
        while (i < compressedString.length()) {
            char c = compressedString.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                letter = c;
                ++i;
            }
            else if (c >= '0' && c <= '9') {
                int j = i + 1;
                while (j < compressedString.length() && compressedString.charAt(j) >= '0' && compressedString.charAt(j) <= '9') {
                    ++j;
                }
                
                int reps = Integer.parseInt(compressedString.substring(i, j));
                q.offer(new int[]{letter - 'A', reps});
                i = j;
            }
        }
        
    }
    
    public char next() {
        if (q.isEmpty()) {
            return ' ';
        }
        
        int[] first = q.peek();
        char letter = (char) (first[0] + 'A');
        if (--first[1] == 0) {
            q.poll();
        }
        return letter;
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
 
 
/**

**/