/*
 * Problem: 3914. Minimum Operations to Make Array Non Decreasing
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-array-non-decreasing/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var minOperations = function (nums) {
    let res = 0;
    for (let i = 1; i < nums.length; i++) {
        res += Math.max(nums[i - 1] - nums[i], 0);
    }
    return res;
};
