/*
 * Problem: 3686. Number of Stable Subsequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-stable-subsequences/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int countStableSubsequences(int[] nums) {
        int mod = 1_000_000_007;
        long e1 = 0;
        long e2 = 0;
        long o1 = 0;
        long o2 = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                e2 = (e2 + e1) % mod;
                e1 = (e1 + o1 + o2 + 1) % mod;
            } else {
                o2 = (o2 + o1) % mod;
                o1 = (o1 + e1 + e2 + 1) % mod;
            }
        }
        return (int) ((e1 + e2 + o1 + o2) % mod);
    }
}
