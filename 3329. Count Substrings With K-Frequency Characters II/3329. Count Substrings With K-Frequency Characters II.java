/*
 * Problem: 3329. Count Substrings With K-Frequency Characters II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-substrings-with-k-frequency-characters-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public long numberOfSubstrings(String s, int k) {
        char[] chrs = s.toCharArray();
        int[] counts = new int[26];
        boolean has = false;
        int j = 0;
        long res = 0;
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
