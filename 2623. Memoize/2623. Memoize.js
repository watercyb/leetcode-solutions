/*
 * Problem: 2623. Memoize
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/memoize/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    var map = new Map();
    return function (...args) {
        var k = args.toString();
        if (map.has(k)) return map.get(k);
        var res = fn(...args);
        map.set(k, res);
        return res;
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */
