/*
 * Problem: 2757. Generate Circular Array Values
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/generate-circular-array-values/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {Array<number>} arr
 * @param {number} startIndex
 * @yields {number}
 */
var cycleGenerator = function* (arr, startIndex) {
    while (true) {
        startIndex = ((startIndex + (yield arr[startIndex])) % arr.length + arr.length) % arr.length;
    }
};

/**
 *  const gen = cycleGenerator([1,2,3,4,5], 0);
 *  gen.next().value  // 1
 *  gen.next(1).value // 2
 *  gen.next(2).value // 4
 *  gen.next(6).value // 5
 */
