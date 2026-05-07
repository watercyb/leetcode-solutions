/*
 * Problem: 3413. Maximum Coins From K Consecutive Bags
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-coins-from-k-consecutive-bags/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long maximumCoins(int[][] coins, int k) {
        Arrays.sort(coins, (a, b) -> a[0] - b[0]);
        int j = 0;
        long res = 0;
        long sum = 0;
        long[] sums = new long[coins.length];
        for (int i = 0; i < coins.length; i++) {
            while (j < coins.length - 1 && coins[j + 1][0] - k < coins[i][0]) {
                sums[j] = (long) coins[j][2] * (coins[j][1] - coins[j][0] + 1);
                sum += sums[j];
                j++;
            }
            sums[j] = (long) coins[j][2] * (coins[j][1] - coins[j][0] + 1);
            res = Math.max(sum + (long) coins[j][2] * (Math.min(coins[j][1], coins[i][0] + k - 1) - coins[j][0] + 1),
                    res);
            sum -= sums[i];
        }
        j = coins.length - 1;
        sum = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (j > 0 && coins[j - 1][1] + k > coins[i][1]) {
                sum += sums[j];
                j--;
            }
            res = Math.max(sum + (long) coins[j][2] * (coins[j][1] - Math.max(coins[j][0], coins[i][1] - k + 1) + 1),
                    res);
            sum -= sums[i];
        }
        return res;
    }
}
