/*
 * Problem: 20. Valid Parentheses
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-parentheses/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
   public static boolean isValid(String s) {
        Stack<Character> chrSt = new Stack<Character>();
        char[] chr = s.toCharArray();
        for (int i = 0; i < chr.length; i++) {
            switch (chr[i]) {
                case '(':
                    chrSt.push('(');
                    break;
                case '[':
                    chrSt.push('[');
                    break;
                case '{':
                    chrSt.push('{');
                    break;
                case ')':
                    if (chrSt.empty()) return false;
                    if (!chrSt.peek().equals('('))
                        return false;
                    chrSt.pop();
                    break;
                case ']':
                    if (chrSt.empty()) return false;
                    if (!chrSt.peek().equals('['))
                        return false;
                    chrSt.pop();
                    break;
                case '}':
                    if (chrSt.empty()) return false;
                    if (!chrSt.peek().equals('{'))
                        return false;
                    chrSt.pop();
                    break;
            }
        }
        if (!chrSt.empty()) return false;
        return true;
    }
}
