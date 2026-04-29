/*
 * Problem: 2632. Curry
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/curry/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Function} fn
 * @return {Function}
 */
var curry = function (fn) {

    return function curried(...args) {
        if (args.length >= fn.length) return fn(...args);
        return function next(...nextArgs) {
            return curried(...args, ...nextArgs);
        }
    }
};

/**
 * function sum(a, b) { return a + b; }
 * const csum = curry(sum);
 * csum(1)(2) // 3
 */

