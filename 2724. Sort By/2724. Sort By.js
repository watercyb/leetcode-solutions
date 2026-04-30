/*
 * Problem: 2724. Sort By
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sort-by/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
var sortBy = function (arr, fn) {
    arr.sort((a, b) => fn(a) - fn(b));
    return arr;
};
