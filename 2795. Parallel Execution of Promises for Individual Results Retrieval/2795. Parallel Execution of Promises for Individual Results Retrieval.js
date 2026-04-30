/*
 * Problem: 2795. Parallel Execution of Promises for Individual Results Retrieval
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/parallel-execution-of-promises-for-individual-results-retrieval/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {Array<Function>} functions
 * @return {Promise<Array>}
 */
var promiseAllSettled = function (functions) {
    return new Promise((resolve) => {
        var res = new Array(functions.length);
        var count = 0;
        for (let i = 0; i < functions.length; i++) {
            functions[i]().then((re) => {
                res[i] = { status: "fulfilled", value: re };
                if (++count == functions.length) resolve(res);
            }).catch((e) => {
                res[i] = { status: "rejected", reason: e };
                if (++count == functions.length) resolve(res);
            });
        }
    });
}

/**
 * const functions = [
 *    () => new Promise(resolve => setTimeout(() => resolve(15), 100))
 * ]
 * const time = performance.now()
 *
 * const promise = promiseAllSettled(functions);
 *              
 * promise.then(res => {
 *     const out = {t: Math.floor(performance.now() - time), values: res}
 *     console.log(out) // {"t":100,"values":[{"status":"fulfilled","value":15}]}
 * })
 */
