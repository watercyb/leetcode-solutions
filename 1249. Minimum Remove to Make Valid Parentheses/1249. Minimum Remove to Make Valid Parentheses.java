/*
 * Problem: 1249. Minimum Remove to Make Valid Parentheses
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] chrs = s.toCharArray();
        int[] St = new int[chrs.length];
        int idx = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '(') {
                St[idx++] = i;
            } else if (chrs[i] == ')') {
                if (idx == 0) {
                    chrs[i] = '@';
                } else {
                    idx--;
                }
            }
        }
        for (int i = 0; i < idx; i++) {
            chrs[St[i]] = '@';
        }
        StringBuilder SB = new StringBuilder();
        for (char chr : chrs) {
            if (chr != '@')
                SB.append(chr);
        }
        return SB.toString();
    }
}
