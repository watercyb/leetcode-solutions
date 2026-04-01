/*
 * Problem: 322. Coin Change
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/coin-change/
 * Language: java
 * Date: 2026-04-01
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] DP = new int[amount + 1];
        Arrays.fill(DP, Integer.MAX_VALUE / 2);
        DP[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                DP[i] = Math.min(DP[i - coin] + 1, DP[i]);
            }
        }
        if (DP[amount] == Integer.MAX_VALUE / 2)
            return -1;
        return DP[amount];
    }
}
