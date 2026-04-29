/*
 * Problem: 2624. Snail Traversal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/snail-traversal/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function (rowsCount, colsCount) {
    if (rowsCount * colsCount != this.length) return [];
    var res = new Array(rowsCount);
    for (let i = 0; i < rowsCount; i++) {
        res[i] = new Array(colsCount);
    }
    var i = 0;
    var j = 0;
    var d = 1;
    for (let k = 0; k < this.length; k++) {
        if (i == rowsCount) {
            d = -1;
            i--;
            j++;
        } else if (i == -1) {
            d = 1;
            i++;
            j++;
        }
        res[i][j] = this[k];
        i += d;
    }
    return res;
}

/**
 * const arr = [1,2,3,4];
 * arr.snail(1,4); // [[1,2,3,4]]
 */
