/*
 * Problem: 518. Coin Change II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/coin-change-ii/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int change(int amount, int[] coins) {
        int[] DP = new int[amount + 1];
        DP[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                DP[i] += DP[i - coin];
            }
        }
        return DP[amount];
    }
}
