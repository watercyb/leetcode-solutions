/*
 * Problem: 2705. Compact Object
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/compact-object/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function (obj) {
    if (!obj) return null;
    if (Array.isArray(obj)) {
        var res = [];
        for (let i = 0; i < obj.length; i++) {
            var v = compactObject(obj[i]);
            if (v !== null) res.push(v);
        }
        return res;
    }
    if (typeof obj === 'object') {
        var res = {};
        Object.entries(obj).forEach(([k, v]) => {
            var v = compactObject(obj[k]);
            if (v !== null) res[k] = v;
        });
        return res;
    }
    return obj;
};
