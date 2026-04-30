/*
 * Problem: 2755. Deep Merge of Two Objects
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/deep-merge-of-two-objects/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {null|boolean|number|string|Array|Object} obj1
 * @param {null|boolean|number|string|Array|Object} obj2
 * @return {null|boolean|number|string|Array|Object}
 */
var deepMerge = function (obj1, obj2) {
    if (obj1 == null) return obj2;
    if (obj2 == null) return null;
    if ((Array.isArray(obj1) && !Array.isArray(obj2)) || (!Array.isArray(obj1) && Array.isArray(obj2))) return obj2;
    if (typeof obj1 === 'object' && typeof obj2 === 'object') {
        Object.entries(obj1).forEach(([k, v]) => {
            if (obj2[k] === undefined) {
                obj2[k] = v;
            } else {
                obj2[k] = deepMerge(v, obj2[k]);
            }
        })
        return obj2;
    }
    return obj2;
};

/**
 * let obj1 = {"a": 1, "c": 3}, obj2 = {"a": 2, "b": 2};
 * deepMerge(obj1, obj2); // {"a": 2, "c": 3, "b": 2}
 */

