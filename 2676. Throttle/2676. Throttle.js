/*
 * Problem: 2676. Throttle
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/throttle/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var throttle = function (fn, t) {
    var arg;
    var isWaiting = false;
    function run() {
        fn(...arg);
        arg = null;
        isWaiting = true;
        setTimeout(() => {
            isWaiting = false;
            if (arg != null) run();
        }, t);
    }
    return function (...args) {
        arg = args;
        if (!isWaiting)
            run();
    }
};

/**
 * const throttled = throttle(console.log, 100);
 * throttled("log"); // logged immediately.
 * throttled("log"); // logged at t=100ms.
 */
