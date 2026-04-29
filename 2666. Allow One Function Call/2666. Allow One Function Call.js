/*
 * Problem: 2666. Allow One Function Call
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/allow-one-function-call/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function (fn) {
    var used = false;

    return function (...args) {
        if (used) {
            return undefined;
        } else {
            used = true;
            return fn(...args);
        }
    }
};

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */

