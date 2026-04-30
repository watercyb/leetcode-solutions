/*
 * Problem: 2721. Execute Asynchronous Functions in Parallel
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/execute-asynchronous-functions-in-parallel/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function (functions) {
    var n = functions.length;
    var res = new Array(n);
    return new Promise((resolve, reject) => {
        for (let i = 0; i < functions.length; i++) {
            functions[i]().then((re) => {
                res[i] = re;
                if (--n == 0) resolve(res);
            }).catch((e) => {
                reject(e);
            });
        }
    });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */
