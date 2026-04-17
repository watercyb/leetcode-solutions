/*
 * Problem: 1458. Max Dot Product of Two Subsequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/max-dot-product-of-two-subsequences/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] DP = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i <= nums1.length; i++) {
            DP[i][0] = Integer.MIN_VALUE;
        }
        for (int j = 0; j <= nums2.length; j++) {
            DP[0][j] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int pro = nums1[i] * nums2[j];
                int tmp = DP[i][j];
                if (tmp < 0) {
                    tmp = pro;
                } else if (pro > 0) {
                    tmp += pro;
                }
                DP[i + 1][j + 1] = Math.max(tmp, Math.max(DP[i + 1][j], DP[i][j + 1]));
            }
        }
        return DP[nums1.length][nums2.length];
    }
}
