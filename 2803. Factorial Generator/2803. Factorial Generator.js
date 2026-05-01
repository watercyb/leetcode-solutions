/*
 * Problem: 2803. Factorial Generator
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/factorial-generator/
 * Language: javascript
 * Date: 2026-05-01
 */

/**
 * @param {number} n
 * @yields {number}
 */
function* factorial(n) {
    var res = 1;
    yield res;
    for (let i = 2; i <= n; i++) {
        yield res *= i;
    }
};

/**
 * const gen = factorial(2);
 * gen.next().value; // 1
 * gen.next().value; // 2
 */
