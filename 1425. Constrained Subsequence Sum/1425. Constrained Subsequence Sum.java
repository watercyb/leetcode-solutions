/*
 * Problem: 1425. Constrained Subsequence Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/constrained-subsequence-sum/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] MQ = new int[nums.length];
        MQ[0] = nums[0];
        int l = 0;
        int r = 1;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(MQ[l] + nums[i], nums[i]);
            while (r > l && MQ[r - 1] < nums[i]) {
                r--;
            }
            MQ[r] = nums[i];
            r++;
            if (i >= k && MQ[l] == nums[i - k])
                l++;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(nums[i], res);
        }
        return res;
    }
}
