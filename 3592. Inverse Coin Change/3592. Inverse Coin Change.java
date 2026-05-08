/*
 * Problem: 3592. Inverse Coin Change
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/inverse-coin-change/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public List<Integer> findCoins(int[] numWays) {
        long[] DP = new long[numWays.length + 1];
        DP[0] = 1;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= numWays.length; i++) {
            if (DP[i] > numWays[i - 1] || DP[i] + 1 < numWays[i - 1])
                return new ArrayList<>();
            if (DP[i] == numWays[i - 1])
                continue;
            for (int j = 0; j < DP.length - i; j++) {
                DP[j + i] += DP[j];
            }
            res.add(i);
        }
        return res;
    }
}
