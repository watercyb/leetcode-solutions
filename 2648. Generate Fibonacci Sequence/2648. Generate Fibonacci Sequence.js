/*
 * Problem: 2648. Generate Fibonacci Sequence
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/generate-fibonacci-sequence/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @return {Generator<number>}
 */
var fibGenerator = function* () {
    var a = 0;
    var b = 1;
    while (true) {
        yield a;
        let temp = a;
        a = b;
        b = temp + b;
    }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
