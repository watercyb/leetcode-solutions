/*
 * Problem: 2630. Memoize II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/memoize-ii/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    var map = new Map();
    var map1 = new Map();
    return function (...args) {
        var arr = [];
        for (let i = 0; i < args.length; i++) {
            if (map1.has(args[i])) {
                arr.push(map1.get(args[i]));
            } else {
                let n = map1.size;
                map1.set(args[i], n);
                arr.push(n);
            }
        }
        var k = JSON.stringify(arr);
        if (map.has(k))
            return map.get(k);
        var v = fn(...args);
        map.set(k, v);
        return v;
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
