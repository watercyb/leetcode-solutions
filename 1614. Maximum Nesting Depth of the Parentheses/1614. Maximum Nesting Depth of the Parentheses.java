/*
 * Problem: 1614. Maximum Nesting Depth of the Parentheses
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == '(') {
                depth++;
                res = Math.max(depth, res);
            } else if (chr == ')') {
                depth--;
            }
        }
        return res;
    }
}
