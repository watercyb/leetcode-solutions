/*
 * Problem: 1547. Minimum Cost to Cut a Stick
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
 * Language: java
 * Date: 2026-08-26
 */

class Solution {
    public int minCost(int n, int[] cuts) {
        int[][] DP = new int[cuts.length + 2][cuts.length + 2];
        int[] arr = new int[cuts.length + 2];
        for (int i = 0; i < cuts.length; i++) {
            arr[i] = cuts[i];
        }
        arr[cuts.length] = 0;
        arr[cuts.length + 1] = n;
        Arrays.sort(arr);
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j--) {
                DP[j][i] = Integer.MAX_VALUE;
                for (int k = j + 1; k < i; k++) {
                    DP[j][i] = Math.min(DP[j][k] + DP[k][i], DP[j][i]);
                }
                DP[j][i] += arr[i] - arr[j];
            }
        }
        return DP[0][DP.length - 1];
    }
}
