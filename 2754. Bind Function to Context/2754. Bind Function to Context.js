/*
 * Problem: 2754. Bind Function to Context
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/bind-function-to-context/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {Object} obj
 * @return {Function}
 */
Function.prototype.bindPolyfill = function (obj) {
    const sym = Symbol();
    obj[sym] = this;

    return (...args) => {
        let res = obj[sym](...args);
        return res;
    };
}
