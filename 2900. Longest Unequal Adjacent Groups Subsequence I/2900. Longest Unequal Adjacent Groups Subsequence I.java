/*
 * Problem: 2900. Longest Unequal Adjacent Groups Subsequence I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        int prv = groups[0];
        for (int i = 0; i < words.length; i++) {
            if (groups[i] != prv) {
                res.add(words[i]);
            }
            prv = groups[i];
        }
        return res;
    }
}
