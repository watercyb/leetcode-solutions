/*
 * Problem: 3068. Find the Maximum Sum of Node Values
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-maximum-sum-of-node-values/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long res = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i] ^ k;
            if (tmp >= nums[i]) {
                res += tmp;
                count = 1 - count;
            } else {
                res += nums[i];
            }
            min = Math.min(Math.abs(tmp - nums[i]), min);
        }
        if (count == 0) {
            return res;
        } else {
            return res - min;
        }
    }
}
