/**

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, , . Each operand may be an integer or another expression.

Some examples
  [2, 1, +, 3, ] - ((2 + 1)  3) - 9
  [4, 13, 5, , +] - (4 + (13  5)) - 6


**/

public class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> operands = new Stack<>();
        
        for (String token : tokens) {
            switch(token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int op2 = operands.pop();
                    int op1 = operands.pop();
                    try 
                    {
                        res = evalHelper(op1, op2, token);
                    }
                    catch (ArithmeticException ex) 
                    {
                        throw new ArithmeticException("Invalid arithmetic operation");
                    }
                    operands.push(Integer.valueOf(res));
                    break;
                default:
                    operands.push(Integer.valueOf(token));
            }
        }
        return operands.isEmpty() ? res : operands.peek();    
    }
    
    private int evalHelper(int op1, int op2, String token) throws ArithmeticException {
        int res;
        switch (token) {
            case "+":
                res = op1 + op2;
                break;
            case "-":
                res = op1 - op2;
                break;
            case "*":
                res = op1 * op2;
                break;
            case "/":
                res = op1 / op2;
                break;
            default:
        }
        return res;
    }
}

/**
	Note:
	
	Use stack to store the operands and push the intermediate results back to stack.

**/