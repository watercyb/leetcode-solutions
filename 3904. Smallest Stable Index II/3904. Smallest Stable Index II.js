/*
 * Problem: 3904. Smallest Stable Index II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-stable-index-ii/
 * Language: javascript
 * Date: 2026-04-20
 */

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var firstStableIndex = function (nums, k) {
    let arr = [];
    max = 0;
    for (let num of nums) {
        max = Math.max(max, num);
        arr.push(max);
    }
    res = -1;
    let min = Number.MAX_SAFE_INTEGER;
    for (let i = nums.length - 1; i >= 0; i--) {
        min = Math.min(min, nums[i]);
        if (arr[i] - min <= k)
            res = i;
    }
    return res;
};
