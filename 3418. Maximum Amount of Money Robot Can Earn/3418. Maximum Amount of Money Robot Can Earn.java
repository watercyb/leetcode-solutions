/*
 * Problem: 3418. Maximum Amount of Money Robot Can Earn
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maximumAmount(int[][] coins) {
        int min = Integer.MIN_VALUE / 2;
        int[] DP = new int[coins[0].length];
        Arrays.fill(DP, min);
        int[] DP1 = new int[coins[0].length];
        Arrays.fill(DP1, min);
        int[] DP2 = new int[coins[0].length];
        Arrays.fill(DP2, min);
        int prv = 0;
        int prv1 = 0;
        int prv2 = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < coins[0].length; j++) {
                DP2[j] = Math.max(DP2[j], prv2) + coins[i][j];
                DP1[j] = Math.max(DP1[j], prv1) + coins[i][j];
                DP2[j] = Math.max(DP1[j] - coins[i][j], DP2[j]);
                DP[j] = Math.max(DP[j], prv) + coins[i][j];
                DP1[j] = Math.max(DP[j] - coins[i][j], DP1[j]);
                prv = DP[j];
                prv1 = DP1[j];
                prv2 = DP2[j];
            }
            prv = min;
            prv1 = min;
            prv2 = min;
        }
        return Math.max(Math.max(DP[coins[0].length - 1], DP1[coins[0].length - 1]), DP2[coins[0].length - 1]);
    }
}
