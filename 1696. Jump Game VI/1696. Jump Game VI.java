/*
 * Problem: 1696. Jump Game VI
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/jump-game-vi/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int maxResult(int[] nums, int k) {
        int[] MQ = new int[nums.length + 1];
        int[] idx = new int[nums.length + 1];
        idx[0] = -k;
        int l = 0;
        int r = 1;
        for (int i = 0; i < nums.length; i++) {
            while (l < r && idx[l] < i - k) {
                l++;
            }
            int sum = MQ[l] + nums[i];
            while (l < r && MQ[r - 1] <= sum) {
                r--;
            }
            idx[r] = i;
            MQ[r++] = sum;
        }
        return MQ[r - 1];
    }
}
