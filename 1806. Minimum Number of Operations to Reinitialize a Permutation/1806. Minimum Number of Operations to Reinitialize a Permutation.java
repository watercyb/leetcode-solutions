/*
 * Problem: 1806. Minimum Number of Operations to Reinitialize a Permutation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int reinitializePermutation(int n) {
        int res = 0;
        int i = 1;
        while (i != 1 || res == 0) {
            if (2 * i >= n) {
                i = (i - n / 2) * 2 + 1;
            } else {
                i = 2 * i;
            }
            res++;
        }
        return res;
    }
}
