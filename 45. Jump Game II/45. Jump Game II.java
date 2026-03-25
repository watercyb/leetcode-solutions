/*
 * Problem: 45. Jump Game II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/jump-game-ii/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        if (nums[0] >= nums.length - 1)
            return 1;
        int[] stp = { 1, nums[0] };
        int[] stpNext = { 2, nums[0] };
        for (int i = 0; i < nums.length; i++) {
            if (stp[1] < i) {
                stp = stpNext.clone();
                stpNext[0]++;
            }
            int max = i + nums[i];
            if (max >= nums.length - 1)
                return stp[0] + 1;
            if (max > stpNext[1])
                stpNext[1] = max;
        }
        return -1;
    }
}
