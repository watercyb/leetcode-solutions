/*
 * Problem: 1246. Palindrome Removal
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/palindrome-removal/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int minimumMoves(int[] arr) {
        int[][] DP = new int[arr.length][arr.length];
        DP[0][0] = 1;
        for (int i = 1; i < arr.length; i++) {
            DP[i][i] = 1;
            DP[i - 1][i] = arr[i - 1] == arr[i] ? 1 : 2;
            for (int j = i - 2; j >= 0; j--) {
                int min = arr[j] == arr[i] ? DP[j + 1][i - 1] : DP[j + 1][i - 1] + 2;
                for (int k = j; k < i; k++) {
                    min = Math.min(min, DP[j][k] + DP[k + 1][i]);
                }
                DP[j][i] = min;
            }
        }
        return DP[0][DP.length - 1];
    }
}
