/*
 * Problem: 2618. Check if Object Instance of Class
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/check-if-object-instance-of-class/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function (obj, classFunction) {
    if (obj == null) return false;
    if (obj.constructor == classFunction) return true;
    return checkIfInstanceOf(Object.getPrototypeOf(obj), classFunction);
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */
