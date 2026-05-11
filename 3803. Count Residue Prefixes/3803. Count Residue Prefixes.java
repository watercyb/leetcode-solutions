/*
 * Problem: 3803. Count Residue Prefixes
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-residue-prefixes/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int residuePrefixes(String s) {
        int[] counts = new int[26];
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length() && count < 3; i++) {
            int idx = s.charAt(i) - 'a';
            if (counts[idx]++ == 0)
                count++;
            if (count == (i + 1) % 3)
                res++;
        }
        return res;
    }
}
