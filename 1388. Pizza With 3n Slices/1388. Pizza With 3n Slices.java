/*
 * Problem: 1388. Pizza With 3n Slices
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/pizza-with-3n-slices/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int maxSizeSlices(int[] slices) {
        return Math.max(calc(slices, 0, slices.length - 1), calc(slices, 1, slices.length));
    }

    public int calc(int[] slices, int l, int r) {
        int n = slices.length / 3;
        int[] DP1 = new int[n + 1];
        int[] DP2 = new int[n + 1];
        Arrays.fill(DP1, Integer.MIN_VALUE);
        Arrays.fill(DP2, Integer.MIN_VALUE);
        DP1[0] = 0;
        DP2[0] = 0;
        for (int i = l; i < r; i++) {
            DP2[n] = Math.max(DP1[n], DP2[n]);
            for (int j = Math.min(n - 1, (i - l + 1) / 2); j >= 0; j--) {
                DP1[j + 1] = DP2[j] + slices[i];
                DP2[j] = Math.max(DP1[j], DP2[j]);
            }
        }
        return Math.max(DP1[n], DP2[n]);
    }
}
