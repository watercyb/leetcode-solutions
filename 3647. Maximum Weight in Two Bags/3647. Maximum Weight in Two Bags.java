/*
 * Problem: 3647. Maximum Weight in Two Bags
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-weight-in-two-bags/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int maxWeight(int[] weights, int w1, int w2) {
        boolean[][] DP = new boolean[w1 + 1][w2 + 1];
        DP[0][0] = true;
        int lim = Math.max(w1, w2);
        for (int weight : weights) {
            if (weight > lim)
                continue;
            boolean[][] DPNext = new boolean[w1 + 1][w2 + 1];
            for (int i = 0; i <= w1; i++) {
                for (int j = 0; j <= w2; j++) {
                    if (DP[i][j]) {
                        DPNext[i][j] = true;
                        if (i + weight <= w1)
                            DPNext[i + weight][j] = true;
                        if (j + weight <= w2)
                            DPNext[i][j + weight] = true;
                    }
                }
            }
            if (DPNext[w1][w2])
                return w1 + w2;
            DP = DPNext;
        }
        int res = 0;
        for (int i = 0; i <= w1; i++) {
            for (int j = 0; j <= w2; j++) {
                if (DP[i][j] && res < i + j)
                    res = i + j;
            }
        }
        return res;
    }
}
