/*
 * Problem: 2690. Infinite Method Object
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/infinite-method-object/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @return {Object}
 */
var createInfiniteObject = function () {
    return new Proxy([], {
        get(target, prop, receiver) {
            return () => { return prop };
        },
    })
};

/**
 * const obj = createInfiniteObject();
 * obj['abc123'](); // "abc123"
 */
