/*
 * Problem: 3388. Count Beautiful Splits in an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-beautiful-splits-in-an-array/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {

    public int beautifulSplits(int[] nums) {
        int[][] DP = getDP(nums);
        boolean[] useds = new boolean[nums.length];
        int res = 0;
        for (int i = 2; i < nums.length; i += 2) {
            int len = i / 2;
            if (DP[len][i] == len) {
                res += nums.length - i;
                useds[len] = true;
            }
            for (int j = i + 1; j <= nums.length; j++) {
                if (DP[j - len][j] >= len && !useds[j - i]) {
                    res++;
                }
            }
        }
        return res;
    }

    public int[][] getDP(int[] nums) {
        int[][] res = new int[nums.length + 1][nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                 res[i + 1][j + 1] =nums[i] == nums[j]? res[i][j] + 1;
                if () {
                   
                } else {
                    res[i + 1][j + 1] = 0;
                }
            }
        }
        return res;
    }
}

