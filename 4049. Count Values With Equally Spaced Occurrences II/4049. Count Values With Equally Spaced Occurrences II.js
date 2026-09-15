/*
 * Problem: 4049. Count Values With Equally Spaced Occurrences II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-values-with-equally-spaced-occurrences-ii/
 * Language: javascript
 * Date: 2026-09-15
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var countSpecialIntegers = function (nums) {
    mp = new Map();
    for (let i = 0; i < nums.length; i++) {
        if (!mp.has(nums[i])) {
            mp.set(nums[i], [i, -1, 1]);
        } else {
            let pair = mp.get(nums[i]);
            if (pair[2] < 0) continue;
            if (pair[1] == -1) {
                pair[1] = i - pair[0];
                pair[0] = i;
                pair[2]++;
            } else if (pair[1] == i - pair[0]) {
                pair[0] = i;
                pair[2]++;
            } else {
                pair[2] = -10000000;
            }
        }
    }
    let res = 0;
    for (const [, [, , count]] of mp) {
        if (count >= 3) res++;
    }
    return res;
};
