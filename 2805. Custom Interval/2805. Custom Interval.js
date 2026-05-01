/*
 * Problem: 2805. Custom Interval
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/custom-interval/
 * Language: javascript
 * Date: 2026-05-01
 */

/**
 * @param {Function} fn
 * @param {number} delay
 * @param {number} period
 * @return {number} id
 */

var timeout = [];
function customInterval(fn, delay, period) {
    var res = timeout.length;
    timeout.push(null);
    var n = 0;
    function run() {
        timeout[res] = setTimeout(() => { fn(); run(); }, delay + period * n++);
    }
    run();
    return res;
}

/**
 * @param {number} id
 * @return {void}
 */
function customClearInterval(id) {
    clearTimeout(timeout[id]);
}
