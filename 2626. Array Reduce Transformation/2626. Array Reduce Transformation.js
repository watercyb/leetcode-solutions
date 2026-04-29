/*
 * Problem: 2626. Array Reduce Transformation
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/array-reduce-transformation/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function (nums, fn, init) {
    for (let i = 0; i < nums.length; i++) {
        init = fn(init, nums[i]);
    }
    return init;
};
