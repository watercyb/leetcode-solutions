/*
 * Problem: 2636. Promise Pool
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/promise-pool/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Promise<any>}
 */
var promisePool = async function (functions, n) {
    var idx = 0;
    var count = 0;
    var res = new Array(functions.length);

    return new Promise((resolve) => {
        if (functions.length == 0) resolve(res);
        function run(i) {
            if (i < functions.length) {
                functions[i]().then((re) => {
                    res[i] = re;
                    if (++count == functions.length) {
                        resolve(res);
                    } else {
                        run(idx++);
                    }
                });
            }
        }
        for (let i = 0; i < n; i++) {
            run(idx++);
        }
    });
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */
