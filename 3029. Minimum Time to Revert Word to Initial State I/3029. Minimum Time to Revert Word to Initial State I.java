/*
 * Problem: 3029. Minimum Time to Revert Word to Initial State I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-time-to-revert-word-to-initial-state-i/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        char[] chrs = word.toCharArray();
        int res = 1;
        for (int i = k; i < chrs.length; i += k) {
            int j = 0;
            int l = i + j;
            while (l < chrs.length && chrs[l] == chrs[j]) {
                j++;
                l++;
            }
            if (l == chrs.length)
                return res;
            res++;
        }
        return res;
    }
}
