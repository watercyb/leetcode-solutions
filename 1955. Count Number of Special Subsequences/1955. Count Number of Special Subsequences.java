/*
 * Problem: 1955. Count Number of Special Subsequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-number-of-special-subsequences/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int countSpecialSubsequences(int[] nums) {
        int mod = 1_000_000_007;
        long zeros = 0, ones = 0, res = 0;
        for (int num : nums) {
            if (num == 0) {
                zeros = (zeros * 2 + 1) % mod;
            } else if (num == 1) {
                ones = (ones * 2 + zeros) % mod;
            } else if (num == 2) {
                res = (res * 2 + ones) % mod;
            }
        }
        return (int) res;
    }
}
