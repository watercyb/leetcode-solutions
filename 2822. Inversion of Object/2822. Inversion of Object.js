/*
 * Problem: 2822. Inversion of Object
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/inversion-of-object/
 * Language: javascript
 * Date: 2026-05-01
 */

/**
 * @param {Object|Array} obj
 * @return {Object}
 */
var invertObject = function (obj) {
    var res = {};
    Object.entries(obj).forEach(([k, v]) => {
        if (res[v] == undefined) {
            res[v] = k;
        } else if (!Array.isArray(res[v])) {
            res[v] = [res[v], k];
        } else {
            res[v].push(k);
        }
    });
    return res;
};
