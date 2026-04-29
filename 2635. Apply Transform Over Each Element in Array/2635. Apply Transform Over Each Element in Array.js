/*
 * Problem: 2635. Apply Transform Over Each Element in Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/apply-transform-over-each-element-in-array/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function (arr, fn) {
    var res = [];
    for (let i = 0; i < arr.length; i++) {
        res.push(fn(arr[i], i));
    }
    return res;
};
