/*
 * Problem: 2627. Debounce
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/debounce/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function (fn, t) {
    var timeout = null;
    return function (...args) {
        if (timeout != null) clearTimeout(timeout);
        timeout = setTimeout(() => { fn(...args); timeout = null; }, t);
    }
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */
