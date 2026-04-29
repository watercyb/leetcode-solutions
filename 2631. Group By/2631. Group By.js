/*
 * Problem: 2631. Group By
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/group-by/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function (fn) {
    var res = {};
    for (let i = 0; i < this.length; i++) {
        var k = fn(this[i]);
        if (res[k] != undefined) {
            res[k].push(this[i]);
        } else {
            res[k] = [this[i]];
        }
    }
    return res;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */
