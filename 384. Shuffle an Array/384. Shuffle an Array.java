/*
 * Problem: 384. Shuffle an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shuffle-an-array/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    int[] nums;
    int[] random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = nums.clone();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = (int) (Math.random() * (i + 1));
            int tmp = random[i];
            random[i] = random[idx];
            random[idx] = tmp;
        }
        return random;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
