/**

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".


**/

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        try {
            if (numerator == 0) {
                return "0";
            }
            
            StringBuilder sb = new StringBuilder();
            boolean isNeg = (numerator > 0) ^ (denominator > 0);
            
            if (isNeg) {
                sb.append("-");
            }
            
            long num = Math.abs(numerator);
            long div = Math.abs(denominator);
            
            long quotient = Math.abs(num / div);
            sb.append(quotient);
            long remainder = Math.abs(num % div);
            
            if (remainder == 0) {
                return sb.toString();
            }
            
            sb.append(".");
            Map<Long, Integer> hash = new HashMap<>();
            hash.put(remainder, sb.length());
    
            while (remainder > 0) {
                remainder *= 10;
                quotient = Math.abs(remainder / div);
                sb.append(quotient);
                remainder %= div;
                
                if (hash.containsKey(remainder)) {
                    sb.insert(hash.get(remainder), "(");
                    sb.append(")");
                    break;
                }
                
                hash.put(remainder, sb.length());
            }
            
            return sb.toString();
        }
        catch (Exception e) {
            return null;
        }
    }
}


/**
	Note:
	
	

**/