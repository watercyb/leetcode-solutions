/*
 * Problem: 2821. Delay the Resolution of Each Promise
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/delay-the-resolution-of-each-promise/
 * Language: javascript
 * Date: 2026-05-01
 */

/**
 * @param {Array<Function>} functions
 * @param {number} ms
 * @return {Array<Function>}
 */
var delayAll = function (functions, ms) {
    var res = [];
    for (let i = 0; i < functions.length; i++) {
        res[i] = () => new Promise((resolve, reject) => {
            setTimeout(() => functions[i]().then((re) => resolve(re)).catch((e) => reject(e)), ms);
        });
    }
    return res;
};


