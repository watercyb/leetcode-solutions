/*
 * Problem: 2796. Repeat String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/repeat-string/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {number} times
 * @return {string}
 */
String.prototype.replicate = function (times) {
    var res = '';
    var str = this;
    while (times > 0) {
        if (times % 2 == 1) {
            res += str;
            times--;
        }
        str += str;
        times /= 2;
    }
    return res;
}
