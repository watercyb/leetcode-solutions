/*
 * Problem: 2944. Minimum Number of Coins for Fruits
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-coins-for-fruits/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int minimumCoins(int[] prices) {
        int[][] MQ = new int[prices.length + 1][2];
        MQ[0][0] = 1;
        int l = 1;
        int r = 1;
        for (int i = 0; i < prices.length; i++) {
            while (MQ[l][0] < i) {
                l++;
            }
            int current = prices[i] + MQ[l][1];
            while (MQ[r - 1][1] >= current) {
                r--;
            }
            MQ[r][0] = i + i + 2;
            MQ[r++][1] = current;
        }
        while (MQ[l][0] < prices.length) {
            l++;
        }
        return MQ[l][1];
    }
}
