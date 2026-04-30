/*
 * Problem: 2775. Undefined to Null
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/undefined-to-null/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var undefinedToNull = function (obj) {
    if (obj === null || obj === undefined) return null;
    if (typeof obj !== 'object') return obj;
    Object.entries(obj).forEach(([k, v]) => {
        obj[k] = undefinedToNull(v);
    })
    return obj;
};

/**
 * undefinedToNull({"a": undefined, "b": 3}) // {"a": null, "b": 3}
 * undefinedToNull([undefined, undefined]) // [null, null] 
 */
