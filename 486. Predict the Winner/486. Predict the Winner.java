/*
 * Problem: 486. Predict the Winner
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/predict-the-winner/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean predictTheWinner(int[] nums) {
        if (nums.length % 2 == 0)
            return true;
        return dfs(new Integer[nums.length][nums.length], nums, 0, nums.length - 1) >= 0;
    }

    public int dfs(Integer[][] mems, int[] nums, int l, int r) {
        if (l > r)
            return 0;
        if (mems[l][r] != null)
            return mems[l][r];
        int left = nums[l] - dfs(mems, nums, l + 1, r);
        int right = nums[r] - dfs(mems, nums, l, r - 1);
        mems[l][r] = Math.max(left, right);
        return mems[l][r];
    }
}
