/*
 * Problem: 3469. Find Minimum Cost to Remove Array Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-minimum-cost-to-remove-array-elements/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int minCost(int[] nums) {
        return dfs(nums, new int[nums.length][nums.length], 1, 0);
    }

    public int dfs(int[] nums, int[][] meme, int i, int prv) {
        if (i == nums.length)
            return nums[prv];
        if (i == nums.length - 1)
            return Math.max(nums[i], nums[prv]);
        if (meme[prv][i] != 0)
            return meme[prv][i];
        if (nums[prv] >= nums[i] && nums[i] >= nums[i + 1])
            return meme[prv][i] = Math.min(dfs(nums, meme, i + 2, i + 1) + nums[prv],
                    dfs(nums, meme, i + 2, prv) + nums[i]);
        if (nums[prv] >= nums[i + 1] && nums[i + 1] >= nums[i])
            return meme[prv][i] = Math.min(dfs(nums, meme, i + 2, i) + nums[prv],
                    dfs(nums, meme, i + 2, prv) + nums[i + 1]);
        if (nums[i] >= nums[prv] && nums[prv] >= nums[i + 1])
            return meme[prv][i] = Math.min(dfs(nums, meme, i + 2, i + 1) + nums[i],
                    dfs(nums, meme, i + 2, i) + nums[prv]);
        if (nums[i] >= nums[i + 1] && nums[i + 1] >= nums[prv])
            return meme[prv][i] = Math.min(dfs(nums, meme, i + 2, prv) + nums[i],
                    dfs(nums, meme, i + 2, i) + nums[i + 1]);
        if (nums[i + 1] >= nums[prv] && nums[prv] >= nums[i])
            return meme[prv][i] = Math.min(dfs(nums, meme, i + 2, i) + nums[i + 1],
                    dfs(nums, meme, i + 2, i + 1) + nums[prv]);
        return meme[prv][i] = Math.min(dfs(nums, meme, i + 2, prv) + nums[i + 1],
                dfs(nums, meme, i + 2, i + 1) + nums[i]);
    }
}
