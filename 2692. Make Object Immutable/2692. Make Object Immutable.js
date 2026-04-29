/*
 * Problem: 2692. Make Object Immutable
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/make-object-immutable/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Object|Array} obj
 * @return {Object|Array} immutable obj
 */
var makeImmutable = function (obj) {
    const set = new Set(['pop', 'push', 'shift', 'unshift', 'splice', 'sort', 'reverse']);
    const handler = {
        get: function (target, prop, receiver) {
            if (set.has(prop)) {
                return () => { throw 'Error Calling Method: ' + prop };
            } else if (target[prop] !== null && typeof target[prop] === 'object') {
                return new Proxy(target[prop], handler);
            } else {
                return target[prop];
            }
        },
        set: function (obj, prop, value) {
            if (Array.isArray(obj)) {
                throw 'Error Modifying Index: ' + prop;
            } else {
                throw 'Error Modifying: ' + prop;
            }
        },
    };
    return new Proxy(obj, handler);
};

/**
 * const obj = makeImmutable({x: 5});
 * obj.x = 6; // throws "Error Modifying x"
 */
