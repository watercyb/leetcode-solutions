/*
 * Problem: 2619. Array Prototype Last
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/array-prototype-last/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function () {
    if (this.length === 0) return -1;
    return this[this.length - 1];
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */
