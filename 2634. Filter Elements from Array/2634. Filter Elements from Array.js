/*
 * Problem: 2634. Filter Elements from Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/filter-elements-from-array/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function (arr, fn) {
    var res = [];
    for (let i = 0; i < arr.length; i++) {
        if (fn(arr[i], i)) res.push(arr[i]);
    }
    return res;
};
