/**

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".


**/

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            printRow(s, sb, i, numRows);
        }
        return sb.toString();
    }
    
    private void printRow(String s, StringBuilder sb, int row, int numRows) {
        int distance = 2 * numRows - 2;
        int index = row;
            
        if (row == 0 || row == numRows - 1) {
            while (index < s.length()) {
                sb.append(s.charAt(index));
                index += distance;
            }
        }
        else {
            int dist = distance - 2 * index;
            boolean isEven = true;
            while (index < s.length()) {
                sb.append(s.charAt(index));
                index += isEven ? dist : distance - dist;
                isEven = !isEven;
            }
        }
    }
}

/**
	Note:
	
	Find formular
		
**/