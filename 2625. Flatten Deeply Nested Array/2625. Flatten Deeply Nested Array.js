/*
 * Problem: 2625. Flatten Deeply Nested Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/flatten-deeply-nested-array/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    var res = [];
    function run(arr, n) {
        for (let i = 0; i < arr.length; i++) {
            if (Array.isArray(arr[i]) && n > 0) {
                run(arr[i], n - 1);
            } else {
                res.push(arr[i]);
            }
        }
    }
    run(arr, n);
    return res;
};
