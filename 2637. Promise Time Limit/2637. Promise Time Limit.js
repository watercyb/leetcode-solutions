/*
 * Problem: 2637. Promise Time Limit
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/promise-time-limit/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function (fn, t) {

    return async function (...args) {
        return new Promise(async (resolve, reject) => {
            setTimeout(() => reject('Time Limit Exceeded'), t);
            fn(...args).then((re) => resolve(re)).catch((e) => reject(e));
        })
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */
