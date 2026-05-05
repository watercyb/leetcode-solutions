/*
 * Problem: 3258. Count Substrings That Satisfy K-Constraint I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        char[] chrs = s.toCharArray();
        int res = 0;
        int j = 0;
        int[] counts = new int[2];
        for (int i = 0; i < chrs.length; i++) {
            counts[chrs[i] - '0']++;
            while (counts[0] > k && counts[1] > k) {
                counts[chrs[j++] - '0']--;
            }
            res += i - j + 1;
        }
        return res;
    }
}
