/*
 * Problem: 2293. Min Max Game
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/min-max-game/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int minMaxGame(int[] nums) {
        return dfs(nums, 0, (int) (Math.log(nums.length) / Math.log(2)), 0);
    }

    public int dfs(int[] nums, int i, int n, int offset) {
        if (n == 0) {
            return nums[i - offset];
        }
        if (((i - offset) & 1) == 1) {
            return Math.max(dfs(nums, 2 * i + 1, n - 1, offset * 2 + 1), dfs(nums, 2 * i + 2, n - 1, offset * 2 + 1));
        } else {
            return Math.min(dfs(nums, 2 * i + 1, n - 1, offset * 2 + 1), dfs(nums, 2 * i + 2, n - 1, offset * 2 + 1));
        }
    }
}
