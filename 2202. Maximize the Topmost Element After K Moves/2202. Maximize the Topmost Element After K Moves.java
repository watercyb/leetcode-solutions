/*
 * Problem: 2202. Maximize the Topmost Element After K Moves
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-the-topmost-element-after-k-moves/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int maximumTop(int[] nums, int k) {
        if (k == 1 && nums.length == 1)
            return -1;
        if (k > nums.length) {
            if (k % 2 == 1 && nums.length == 1)
                return -1;
            int max = 0;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
        int max = 0;
        for (int i = 0; i < k - 1; i++) {
            max = Math.max(max, nums[i]);
        }
        if (k < nums.length)
            max = Math.max(max, nums[k]);
        return max;
    }
}
