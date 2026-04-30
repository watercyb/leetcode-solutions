/*
 * Problem: 2756. Query Batching
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/query-batching/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {Function} queryMultiple
 * @param {number} t
 * @return {void}
 */
var QueryBatcher = function (queryMultiple, t) {
    var r = [[]];
    var k = [[]];
    var isWaiting = false;
    this.run = function (resolve, key) {
        if (isWaiting) {
            r[r.length - 1].push(resolve);
            k[k.length - 1].push(key);
        } else {
            isWaiting = true;
            queryMultiple([key]).then((re) => {
                console.log()
                resolve(re[0]);
            });
            setTimeout(() => {
                if (r[r.length - 1].length == 0) {
                    isWaiting = false;
                } else {
                    time();
                }
            }, t);
        }
    }

    function time() {
        isWaiting = true;
        var id = r.length - 1;
        r.push([]);
        k.push([]);
        queryMultiple(k[id]).then((re) => {
            for (let i = 0; i < re.length; i++) {
                r[id][i](re[i]);
            }
        });
        setTimeout(() => {
            if (r[id + 1].length == 0) {
                isWaiting = false;
            } else {
                time();
            }
        }, t);
    }
};

/**
 * @param {string} key
 * @return {Promise<string>}
 */
QueryBatcher.prototype.getValue = async function (key) {
    return new Promise((resolve) => {
        this.run(resolve, key);
    });
};

/**
 * async function queryMultiple(keys) { 
 *   return keys.map(key => key + '!');
 * }
 *
 * const batcher = new QueryBatcher(queryMultiple, 100);
 * batcher.getValue('a').then(console.log); // resolves "a!" at t=0ms 
 * batcher.getValue('b').then(console.log); // resolves "b!" at t=100ms 
 * batcher.getValue('c').then(console.log); // resolves "c!" at t=100ms 
 */
