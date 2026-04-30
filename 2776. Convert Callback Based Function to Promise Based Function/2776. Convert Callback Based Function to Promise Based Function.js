/*
 * Problem: 2776. Convert Callback Based Function to Promise Based Function
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/convert-callback-based-function-to-promise-based-function/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {Function} fn
 * @return {Function<Promise<number>>}
 */
var promisify = function (fn) {

    return async function (...args) {
        try {
            var res;
            await fn((re, e) => {
                if (e === undefined) {
                    res = re;
                } else {
                    throw e;
                }
            }, ...args);
            return res;
        } catch (e) {
            throw e;
        }
    }
};

/**
 * const asyncFunc = promisify(callback => callback(42));
 * asyncFunc().then(console.log); // 42
 */
