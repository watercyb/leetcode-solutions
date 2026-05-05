/*
 * Problem: 3269. Constructing Two Increasing Arrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/constructing-two-increasing-arrays/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int minLargest(int[] nums1, int[] nums2) {
        int[][] DP = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i < nums1.length; i++) {
            DP[i + 1][0] = DP[i][0] + 2 - ((nums1[i] & 1) ^ (DP[i][0] & 1));
        }
        for (int i = 0; i < nums2.length; i++) {
            DP[0][i + 1] = DP[0][i] + 2 - ((nums2[i] & 1) ^ (DP[0][i] & 1));
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                DP[i + 1][j + 1] = Math.min(DP[i][j + 1] + 2 - ((DP[i][j + 1] & 1) ^ (nums1[i] & 1)),
                        DP[i + 1][j] + 2 - ((DP[i + 1][j] & 1) ^ (nums2[j] & 1)));
            }
        }
        return DP[nums1.length][nums2.length];
    }
}
