/*
 * Problem: 377. Combination Sum IV
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/combination-sum-iv/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] mems = new int[target + 1];
        Arrays.fill(mems, -1);
        return dfs(mems, nums, 0, target);
    }

    public int dfs(int[] mems, int[] nums, int sum, int target) {
        if (sum > target)
            return 0;
        if (sum == target)
            return 1;
        if (mems[sum] != -1)
            return mems[sum];
        int res = 0;
        for (int num : nums) {
            res += dfs(mems, nums, sum + num, target);
        }
        mems[sum] = res;
        return res;
    }
}
