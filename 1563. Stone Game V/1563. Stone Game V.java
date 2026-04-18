/*
 * Problem: 1563. Stone Game V
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/stone-game-v/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int stoneGameV(int[] stoneValue) {
        int[] sums = new int[stoneValue.length + 1];
        for (int i = 0; i < stoneValue.length; i++) {
            sums[i + 1] = sums[i] + stoneValue[i];
        }
        int[][] DP = new int[stoneValue.length][stoneValue.length];
        for (int i = 0; i < stoneValue.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int sum = sums[i + 1] - sums[j];
                if (i < stoneValue.length - 1 && sum * 2 > sums[stoneValue.length])
                    break;
                for (int k = j; k < i; k++) {
                    int l = sums[k + 1] - sums[j];
                    int r = sums[i + 1] - sums[k + 1];
                    if (l < r) {
                        DP[j][i] = Math.max(DP[j][k] + l, DP[j][i]);
                    } else if (l > r) {
                        DP[j][i] = Math.max(DP[k + 1][i] + r, DP[j][i]);
                    } else {
                        DP[j][i] = Math.max(Math.max(DP[k + 1][i] + r, DP[j][k] + l), DP[j][i]);
                    }
                }
            }
        }
        return DP[0][stoneValue.length - 1];
    }
}
