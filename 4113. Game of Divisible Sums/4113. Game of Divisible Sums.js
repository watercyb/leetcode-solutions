/*
 * Problem: 4113. Game of Divisible Sums
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/game-of-divisible-sums/
 * Language: javascript
 * Date: 2026-11-18
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var maxDifference = function (nums) {
    const n = nums.length;
    if (n == 1) return nums[0];
    dp2 = nums[n - 1];
    dp1 = nums[n - 2] + nums[n - 1];
    for (let i = n - 3; i >= 0; i--) {
        let dp;
        if (nums[i] % 3 != 0) {
            dp = nums[i] + dp1;
        } else {
            dp = nums[i] - dp1;
        }
        if ((nums[i] + nums[i + 1]) % 3 != 0) {
            dp = Math.max(dp, nums[i] + nums[i + 1] + dp2)
        } else {
            dp = Math.max(dp, nums[i] + nums[i + 1] - dp2)
        }
        dp2 = dp1;
        dp1 = dp;
    }
    return dp1;
};
