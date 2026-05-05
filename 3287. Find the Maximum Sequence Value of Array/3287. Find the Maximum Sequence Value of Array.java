/*
 * Problem: 3287. Find the Maximum Sequence Value of Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-maximum-sequence-value-of-array/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int maxValue(int[] nums, int k) {
        int[] left = getLeft(nums, k);
        int[] right = getRight(nums, k);
        int res = 0;
        for (int i = 0; i < left.length; i++) {
            if (left[i] == -1)
                continue;
            for (int j = 0; j < right.length; j++) {
                if (left[i] < right[j])
                    res = Math.max(i ^ j, res);
            }
        }
        return res;
    }

    public int[] getRight(int[] nums, int k) {
        int[] res = new int[128];
        Arrays.fill(res, -1);
        boolean[][] DP = new boolean[k][128];
        DP[0][0] = true;
        for (int i = nums.length - 1; i >= k; i--) {
            for (int j = 0; j < 128; j++) {
                if (!DP[k - 1][j])
                    continue;
                int OR = j | nums[i];
                if (res[OR] == -1)
                    res[OR] = i;
            }
            for (int j = k - 2; j >= 0; j--) {
                for (int l = 0; l < 128; l++) {
                    if (!DP[j][l])
                        continue;
                    DP[j + 1][l | nums[i]] = true;
                }
            }
        }
        return res;
    }

    public int[] getLeft(int[] nums, int k) {
        int[] res = new int[128];
        Arrays.fill(res, -1);
        boolean[][] DP = new boolean[k][128];
        DP[0][0] = true;
        for (int i = 0; i < nums.length - k; i++) {
            for (int j = 0; j < 128; j++) {
                if (!DP[k - 1][j])
                    continue;
                int OR = j | nums[i];
                if (res[OR] == -1)
                    res[OR] = i;
            }
            for (int j = k - 2; j >= 0; j--) {
                for (int l = 0; l < 128; l++) {
                    if (!DP[j][l])
                        continue;
                    DP[j + 1][l | nums[i]] = true;
                }
            }
        }
        return res;
    }
}
