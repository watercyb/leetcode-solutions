/*
 * Problem: 1111. Maximum Nesting Depth of Two Valid Parentheses Strings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        char[] chrs = seq.toCharArray();
        int lv = 0;
        int[] res = new int[chrs.length];
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '(') {
                res[i] = lv;
                lv = 1 - lv;
            } else {
                lv = 1 - lv;
                res[i] = lv;
            }
        }
        return res;
    }
}
