/*
 * Problem: 4063. Longest Subarray Divisible by K with At Most One Negation I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-subarray-divisible-by-k-with-at-most-one-negation-i/
 * Language: javascript
 * Date: 2026-09-27
 */

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var longestSubarray = function (nums, k) {
    let res = 0;
    for (let i = 0; i < nums.length; i++) {
        let sum = 0;
        seens = new Set();
        seens.add(0);
        for (let j = i; j < nums.length; j++) {
            sum = (sum + nums[j] % k + k) % k;
            seens.add((nums[j] % k + k) * 2 % k);
            if (j - i + 1 > res && seens.has(sum))
                res = j - i + 1;
        }
    }
    return res;
};
