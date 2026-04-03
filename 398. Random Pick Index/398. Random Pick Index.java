/*
 * Problem: 398. Random Pick Index
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/random-pick-index/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int idx = (int) (Math.random() * nums.length);
        while (nums[idx] != target) {
            idx = (int) (Math.random() * nums.length);
        }
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
