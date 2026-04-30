/*
 * Problem: 2703. Return Length of Arguments Passed
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/return-length-of-arguments-passed/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */
var argumentsLength = function(...args) {
    return args.length;
};

/**
 * argumentsLength(1, 2, 3); // 3
 */
