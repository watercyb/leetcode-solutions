/*
 * Problem: 2633. Convert Object to JSON String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/convert-object-to-json-string/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {null|boolean|number|string|Array|Object} object
 * @return {string}
 */
var jsonStringify = function (object) {
    if (object === null) return 'null';
    if (typeof object === 'string') return '"' + object + '"';
    if (Array.isArray(object)) {
        var res = '[';
        for (let i = 0; i < object.length - 1; i++) {
            res += jsonStringify(object[i]) + ',';
        }
        if (object.length > 0) res += jsonStringify(object[object.length - 1]);
        res += ']';
        return res;
    }
    if (typeof object === 'object') {
        var res = '{';
        Object.entries(object).forEach(([k, v]) => {
            res += '"' + k + '":' + jsonStringify(v) + ',';
        });
        if (Object.entries(object).length > 0) res = res.substring(0, res.length - 1);
        res += '}';
        return res;
    }
    return object.toString();
};
