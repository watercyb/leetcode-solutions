/*
 * Problem: 2823. Deep Object Filter
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/deep-object-filter/
 * Language: javascript
 * Date: 2026-05-01
 */

/**
 * @param {Object|Array} obj
 * @param {Function} fn
 * @return {Object|Array|undefined}
 */
var deepFilter = function (obj, fn) {
    if (obj === null || typeof obj !== 'object') {
        if (fn(obj)) return obj;
        return undefined;
    }
    if (Array.isArray(obj)) {
        var res = [];
        for (let i = 0; i < obj.length; i++) {
            let r = deepFilter(obj[i], fn);
            if (r !== undefined) res.push(r);
        }
        if (res.length > 0) return res;
        return undefined;
    }
    var res = {};
    var hasItem = false;
    Object.entries(obj).forEach(([k, v]) => {
        let r = deepFilter(v, fn);
        if (r !== undefined) {
            res[k] = r;
            hasItem = true;
        }
    });
    if (hasItem) return res;
    return undefined;
};
