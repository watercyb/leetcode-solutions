/*
 * Problem: 2774. Array Upper Bound
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/array-upper-bound/
 * Language: javascript
 * Date: 2026-04-30
 */

/** 
 * @param {number} target
 * @return {number}
 */
Array.prototype.upperBound = function (target) {
    var l = 0;
    var r = this.length;
    while (l < r) {
        var mid = (l + r) >>> 1;
        if (this[mid] > target) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }
    if (l == 0 || this[l - 1] != target) return -1;
    return l - 1;
};


// [3,4,5].upperBound(5); // 2
// [1,4,5].upperBound(2); // -1
// [3,4,6,6,6,6,7].upperBound(6) // 5
