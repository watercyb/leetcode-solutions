/*
 * Problem: 3332. Maximum Points Tourist Can Earn
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-points-tourist-can-earn/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int[][] travelScoreT = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                travelScoreT[j][i] = travelScore[i][j];
            }
        }
        int[] DP = new int[n];
        int[] DPNext = new int[n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                int max = DP[j] + stayScore[i][j];
                for (int l = 0; l < n; l++) {
                    max = Math.max(DP[l] + travelScoreT[j][l], max);
                }
                DPNext[j] = max;
            }
            int[] temp = DP;
            DP = DPNext;
            DPNext = temp;
        }
        int res = 0;
        for (int num : DP) {
            res = Math.max(num, res);
        }
        return res;
    }
}
