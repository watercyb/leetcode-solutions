/*
 * Problem: 2628. JSON Deep Equal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/json-deep-equal/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {null|boolean|number|string|Array|Object} o1
 * @param {null|boolean|number|string|Array|Object} o2
 * @return {boolean}
 */
var areDeeplyEqual = function (o1, o2) {
    if (o1 === undefined || o2 === undefined) return false;
    if (o1 === o2) return true;
    if (o1 === null || o2 === null) return false;
    if ((typeof o1 !== 'object' && typeof o2 === 'object') || (typeof o1 === 'object' && typeof o2 !== 'object')) return false;
    if ((!Array.isArray(o1) && Array.isArray(o2)) || (Array.isArray(o1) && !Array.isArray(o2))) return false;
    if (typeof o1 === 'object') {
        if (Object.keys(o1).length !== Object.keys(o2).length) return false;
        for (let k in o1) {
            if (!areDeeplyEqual(o1[k], o2[k])) return false;
        }
        return true;
    }
    return false;
};
