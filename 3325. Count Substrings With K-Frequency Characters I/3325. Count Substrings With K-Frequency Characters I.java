/*
 * Problem: 3325. Count Substrings With K-Frequency Characters I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-substrings-with-k-frequency-characters-i/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int numberOfSubstrings(String s, int k) {
        char[] chrs = s.toCharArray();
        int[] counts = new int[26];
        boolean has = false;
        int j = 0;
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            while (j < chrs.length && !has) {
                if (++counts[chrs[j] - 'a'] == k)
                    has = true;
                j++;
            }
            if (!has)
                break;
            res += chrs.length - j + 1;
            if (counts[chrs[i] - 'a']-- == k)
                has = false;
        }
        return res;
    }
}
