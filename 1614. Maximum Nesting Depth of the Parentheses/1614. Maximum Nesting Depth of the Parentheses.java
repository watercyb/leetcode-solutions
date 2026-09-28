/*
 * Problem: 1614. Maximum Nesting Depth of the Parentheses
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/?envType=daily-question&envId=2026-09-28
 * Language: java
 * Date: 2026-09-28
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
