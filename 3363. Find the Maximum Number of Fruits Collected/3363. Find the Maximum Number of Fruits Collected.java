/*
 * Problem: 3363. Find the Maximum Number of Fruits Collected
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int res = fruits[0][0];
        for (int i = 1; i < n - 1; i++) {
            res += fruits[i][i];
            for (int j = 0; j < Math.min(i + 1, n - 1 - i); j++) {
                int max1 = 0;
                int max2 = 0;
                for (int k = Math.max(j - 1, 0); k < Math.min(i, j + 2); k++) {
                    max1 = Math.max(fruits[n - 1 - k][i - 1], max1);
                    max2 = Math.max(fruits[i - 1][n - 1 - k], max2);
                }
                fruits[n - 1 - j][i] += max1;
                fruits[i][n - 1 - j] += max2;
            }
        }
        return res + fruits[n - 1][n - 1] + fruits[n - 1][n - 2] + fruits[n - 2][n - 1];
    }
}
