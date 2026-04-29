/*
 * Problem: 2677. Chunk Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/chunk-array/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function (arr, size) {
    var res = [];
    var idx = 0;
    for (let i = 0; i < arr.length; i++) {
        if (idx == 0) res.push([]);
        res[res.length - 1].push(arr[i]);
        idx = (idx + 1) % size;
    }
    return res;
};

