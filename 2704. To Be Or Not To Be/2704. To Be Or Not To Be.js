/*
 * Problem: 2704. To Be Or Not To Be
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/to-be-or-not-to-be/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {string} val
 * @return {Object}
 */
var expect = function (val) {
    return {
        toBe: (v) => {
            if (v === val) return true;
            throw 'Not Equal';
        },
        notToBe: (v) => {
            if (v !== val) return true;
            throw 'Equal';
        }
    }
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */
