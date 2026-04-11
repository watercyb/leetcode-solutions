/*
 * Problem: 1021. Remove Outermost Parentheses
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-outermost-parentheses/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder SB = new StringBuilder();
        int count = 0;
        for (char chr : s.toCharArray()) {
            if (chr == '(') {
                count++;
                if (count == 1)
                    continue;
            } else {
                count--;
                if (count == 0)
                    continue;
            }
            SB.append(chr);
        }
        return SB.toString();
    }
}
