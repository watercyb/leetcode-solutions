/*
 * Problem: 2320. Count Number of Ways to Place Houses
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-number-of-ways-to-place-houses/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int countHousePlacements(int n) {
        int mod = 1_000_000_007;
        long a = 1;
        long b = 0;
        for (int i = 0; i < n; i++) {
            long temp = a;
            a = (a + b) % mod;
            b = temp;
        }
        return (int) ((a + b) * (a + b) % mod);
    }
}
