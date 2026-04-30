/*
 * Problem: 2794. Create Object from Two Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/create-object-from-two-arrays/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {Array} keysArr
 * @param {Array} valuesArr
 * @return {Object}
 */
var createObject = function (keysArr, valuesArr) {
    var res = {};
    for (let i = 0; i < keysArr.length; i++) {
        if (res[keysArr[i]] === undefined) res[keysArr[i]] = valuesArr[i];
    }
    return res;
};
