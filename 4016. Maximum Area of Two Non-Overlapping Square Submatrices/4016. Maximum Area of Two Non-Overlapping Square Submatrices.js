/*
 * Problem: 4016. Maximum Area of Two Non-Overlapping Square Submatrices
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-area-of-two-non-overlapping-square-submatrices/
 * Language: javascript
 * Date: 2026-08-10
 */

/**
 * @param {number[][]} mat
 * @return {number}
 */
var maxArea = function (mat) {
    const r = mat.length;
    const c = mat[0].length;
    var dp = Array.from({ length: r + 1 }, () => Array(c + 1).fill(0));
    var tops = Array(r + 1).fill(0);
    var lefts = Array(c + 1).fill(0);
    for (let i = 0; i < r; i++) {
        for (let j = 0; j < c; j++) {
            var len = 0;
            if (mat[i][j] == 1)
                len = Math.min(dp[i][j + 1], dp[i + 1][j], dp[i][j]) + 1;
            dp[i + 1][j + 1] = len
            tops[i + 1] = Math.max(tops[i + 1], len);
            lefts[j + 1] = Math.max(lefts[j + 1], len);
        }
    }
    for (let i = 1; i < r; i++) {
        tops[i] = Math.max(tops[i], tops[i - 1]);
    }
    for (let i = 1; i < c; i++) {
        lefts[i] = Math.max(lefts[i], lefts[i - 1]);
    }
    dp = Array.from({ length: r + 1 }, () => Array(c + 1).fill(0));
    var bottoms = Array(r).fill(0);
    var rights = Array(c).fill(0);
    for (let i = r - 1; i >= 0; i--) {
        for (let j = c - 1; j >= 0; j--) {
            var len = 0;
            if (mat[i][j] == 1)
                len = Math.min(dp[i + 1][j], dp[i][j + 1], dp[i + 1][j + 1]) + 1;
            dp[i][j] = len
            bottoms[i] = Math.max(bottoms[i], len);
            rights[j] = Math.max(rights[j], len);
        }
    }
    var res = 0;
    var max = 0;
    for (let i = r - 1; i >= 1; i--) {
        max = Math.max(max, bottoms[i]);
        res = Math.max(res, Math.min(tops[i], max));
    }
    max = 0;
    for (let i = c - 1; i >= 1; i--) {
        max = Math.max(max, rights[i]);
        res = Math.max(res, Math.min(lefts[i], max));
    }
    return res * res;
};
