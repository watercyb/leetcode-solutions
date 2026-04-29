/*
 * Problem: 2675. Array of Objects to Matrix
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/array-of-objects-to-matrix/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {Array} arr
 * @return {(string | number | boolean | null)[][]}
 */
var jsonToMatrix = function (arr) {
    var map = new Map();
    function dfs(arr, str, n) {
        Object.entries(arr).forEach(([k, v]) => {
            if (typeof v === 'object' && v !== null) {
                dfs(v, str + k + '.', n);
            } else {
                key = str + k;
                if (!map.has(key)) {
                    map.set(key, [[n, v]]);
                } else {
                    map.get(key).push([n, v]);
                }
            }
        });
    }
    for (let i = 0; i < arr.length; i++) {
        dfs(arr[i], '', i);
    }
    var res = new Array(arr.length + 1);
    for (let i = 0; i < res.length; i++) {
        res[i] = new Array(map.size);
        res[i].fill('');
    }
    var arrSort = [];
    for (let ar of map) {
        arrSort.push(ar);
    }
    arrSort.sort((a, b) => a[0].localeCompare(b[0]));
    for (let i = 0; i < arrSort.length; i++) {
        res[0][i] = arrSort[i][0];
    }
    for (let i = 0; i < arrSort.length; i++) {
        for (let j = 0; j < arrSort[i][1].length; j++) {
            res[arrSort[i][1][j][0] + 1][i] = arrSort[i][1][j][1];
        }
    }
    return res;
};
