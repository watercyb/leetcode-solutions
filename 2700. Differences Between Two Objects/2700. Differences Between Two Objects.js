/*
 * Problem: 2700. Differences Between Two Objects
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/differences-between-two-objects/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Object|Array} obj1
 * @param {Object|Array} obj2
 * @return {Object|Array}
 */
function objDiff(obj1, obj2) {
    if (obj1 === undefined || obj2 === undefined || obj1 === obj2) return {};
    if (obj1 === null || obj2 === null || (Array.isArray(obj1) && !Array.isArray(obj2)) || (!Array.isArray(obj1) && Array.isArray(obj2))) return [obj1, obj2];
    if (typeof obj1 == 'object' && typeof obj1 == 'object') {
        var res = {};
        Object.entries(obj1).forEach(([k, v]) => {
            var re = objDiff(v, obj2[k]);
            if (Object.keys(re).length != 0) res[k] = re;
        });
        return res;
    }
    if (typeof obj1 == 'object' || typeof obj1 == 'object') return [obj1, obj2];
    return [obj1, obj2];
};
