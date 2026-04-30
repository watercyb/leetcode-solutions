/*
 * Problem: 2797. Partial Function with Placeholders
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/partial-function-with-placeholders/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {Function} fn
 * @param {Array} args
 * @return {Function}
 */
var partial = function (fn, args) {

    return function (...restArgs) {
        var i = 0;
        var j = 0;
        while (i < args.length && j < restArgs.length) {
            if (args[i] == '_')
                args[i] = restArgs[j++];
            i++;
        }
        while (j < restArgs.length) {
            args.push(restArgs[j++]);
        }
        return fn(...args);
    }
};
