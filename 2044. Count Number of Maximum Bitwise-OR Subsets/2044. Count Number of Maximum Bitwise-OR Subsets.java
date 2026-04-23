/*
 * Problem: 2044. Count Number of Maximum Bitwise-OR Subsets
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int target = 0;
        for (int num : nums) {
            target |= num;
        }
        return dfs(nums, 0, 0, target);
    }

    public int dfs(int[] nums, int i, int or, int target) {
        if (or == target)
            return (int) Math.pow(2, nums.length - i);
        if (i == nums.length) {
            return 0;
        }
        return dfs(nums, i + 1, or, target) + dfs(nums, i + 1, or | nums[i], target);
    }
}
