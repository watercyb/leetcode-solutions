/*
 * Problem: 2727. Is Object Empty
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/is-object-empty/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function (obj) {
    for (let k in obj) {
        return false;
    }
    return true;
};
