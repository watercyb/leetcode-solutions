/*
 * Problem: 1208. Get Equal Substrings Within Budget
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/get-equal-substrings-within-budget/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] diffs = new int[s.length()];
        for (int i = 0; i < diffs.length; i++) {
            diffs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int j = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            maxCost -= diffs[i];
            while (maxCost < 0) {
                maxCost += diffs[j];
                j++;
            }
            res = Math.max(i - j + 1, res);
        }
        return res;
    }
}
