/*
 * Problem: 3117. Minimum Sum of Values by Dividing Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-sum-of-values-by-dividing-array/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int minimumValueSum(int[] nums, int[] andValues) {
        if (((nums[0] & andValues[0]) < andValues[0])
                || ((nums[nums.length - 1] & andValues[andValues.length - 1]) < andValues[andValues.length - 1])) {
            return -1;
        }
        int[][] DP = new int[andValues.length + 1][nums.length + 1];
        DP[0][0] = 1;

        int[] Qu = new int[nums.length + 1];

        for (int i = 0; i < andValues.length; i++) {
            int[] ands = nums.clone();
            int andsLeft = 0;
            int andsRight = 0;
            int QuLeft = 0;
            int QuRight = 0;
            int DPIdx = 0;

            for (int j = 0; j < nums.length; j++) {
                for (int k = j - 1; k >= andsLeft && (ands[k] & nums[j]) != ands[k]; k--) {
                    ands[k] &= nums[j];
                }
                while (andsLeft <= j && ands[andsLeft] < andValues[i]) {
                    andsLeft++;
                }
                while (andsRight <= j && ands[andsRight] <= andValues[i]) {
                    andsRight++;
                }
                if (andsLeft < andsRight) {
                    while (DPIdx < andsRight) {
                        if (DP[i][DPIdx] != 0) {
                            while (QuRight > QuLeft && DP[i][Qu[QuRight - 1]] >= DP[i][DPIdx]) {
                                QuRight--;
                            }
                            Qu[QuRight++] = DPIdx;
                        }
                        DPIdx++;
                    }
                    while (QuLeft < QuRight && Qu[QuLeft] < andsLeft) {
                        QuLeft++;
                    }
                    if (QuLeft < QuRight)
                        DP[i + 1][j + 1] = DP[i][Qu[QuLeft]] + nums[j];
                }
            }
        }
        return DP[andValues.length][nums.length] - 1;
    }
}
