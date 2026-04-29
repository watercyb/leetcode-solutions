/*
 * Problem: 2667. Create Hello World Function
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/create-hello-world-function/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @return {Function}
 */
var createHelloWorld = function() {
    
    return function(...args) {
        return 'Hello World';
    }
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */
