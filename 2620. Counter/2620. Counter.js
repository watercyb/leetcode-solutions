/*
 * Problem: 2620. Counter
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/counter/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function (n) {

    return function () {
        return n++;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */
