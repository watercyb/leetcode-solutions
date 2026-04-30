/*
 * Problem: 2744. Find Maximum Number of String Pairs
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-maximum-number-of-string-pairs/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int[] seens = new int[26 * 26];
        int res = 0;
        for (String word : words) {
            int a = word.charAt(0) - 'a';
            int b = word.charAt(1) - 'a';
            res += seens[b * 26 + a];
            seens[a * 26 + b]++;
        }
        return res;
    }
}
