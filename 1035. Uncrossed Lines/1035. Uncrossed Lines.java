/*
 * Problem: 1035. Uncrossed Lines
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/uncrossed-lines/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[] DP = new int[nums2.length + 1];
        for (int i = 0; i < nums1.length; i++) {
            int prv = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int tmp = DP[j + 1];
                    DP[j + 1] = prv + 1;
                    prv = tmp;
                } else {
                    prv = DP[j + 1];
                    DP[j + 1] = Math.max(DP[j], DP[j + 1]);
                }
            }
        }
        return DP[nums2.length];
    }
}
