/*
 * Problem: 2693. Call Function with Custom Context
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/call-function-with-custom-context/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Object} context
 * @param {Array} args
 * @return {null|boolean|number|string|Array|Object}
 */
Function.prototype.callPolyfill = function (context, ...args) {
    return this.bind(context)(...args);
}

/**
 * function increment() { this.count++; return this.count; }
 * increment.callPolyfill({count: 1}); // 2
 */
