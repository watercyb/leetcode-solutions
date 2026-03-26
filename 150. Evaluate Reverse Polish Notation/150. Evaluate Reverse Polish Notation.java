/*
 * Problem: 150. Evaluate Reverse Polish Notation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> St = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            int a, b;
            switch (tokens[i]) {
                case "+":
                    a = St.peek();
                    St.pop();
                    b = St.peek();
                    St.pop();
                    St.push(b + a);
                    break;
                case "-":
                    a = St.peek();
                    St.pop();
                    b = St.peek();
                    St.pop();
                    St.push(b - a);
                    break;
                case "*":
                    a = St.peek();
                    St.pop();
                    b = St.peek();
                    St.pop();
                    St.push(b * a);
                    break;
                case "/":
                    a =St.peek();
                    St.pop();
                    b =St.peek();
                    St.pop();
                    St.push(b / a);
                    break;
                default:
                    St.push(Integer.valueOf(tokens[i]));
            }
        }
        return St.peek();
    }
}
