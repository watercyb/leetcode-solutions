/*
 * Problem: 4021. Minimum Operations to Make a Rotated Palindrome I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-a-rotated-palindrome-i/
 * Language: javascript
 * Date: 2026-08-18
 */

/**
 * @param {string} s
 * @return {number}
 */
var minOperations = function (s) {
    const arr = [];
    for (let chr of s) {
        arr.push(chr.charCodeAt(0) - 97);
    }
    var res = 10000000;
    for (let i = 0; i < s.length; i++) {
        l = i;
        r = i - 1;
        if (r == -1) r = s.length - 1;
        res = Math.min(res, chk(arr, l, r) + i);
    }
    return res;
};

const chk = (arr, l, r) => {
    var res = 0;
    for (let i = 0; i < arr.length / 2; i++) {
        let diff = Math.abs(arr[l] - arr[r]);
        if (diff > 13) diff = 26 - diff;
        res += diff;
        l++;
        if (l == arr.length) l = 0;
        r--;
        if (r == -1) r = arr.length - 1;
    }
    return res;
}
