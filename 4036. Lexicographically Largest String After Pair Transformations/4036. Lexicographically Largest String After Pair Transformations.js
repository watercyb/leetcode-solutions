/*
 * Problem: 4036. Lexicographically Largest String After Pair Transformations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lexicographically-largest-string-after-pair-transformations/
 * Language: javascript
 * Date: 2026-09-01
 */

/**
 * @param {number[]} nums
 * @return {string[]}
 */
var largestString = function (nums) {
    const res = [];
    for (let num of nums) {
        let str = '';
        for (let i = 25; i >= 0; i--) {
            const b = 1 << i;
            while (num >= b) {
                num -= b;
                str += String.fromCharCode('a'.charCodeAt(0) + i);
            }
        }
        res.push(str);
    }
    return res;
};
