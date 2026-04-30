/*
 * Problem: 2722. Join Two Arrays by ID
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/join-two-arrays-by-id/
 * Language: javascript
 * Date: 2026-04-30
 */

/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function (arr1, arr2) {
    arr1.sort((a, b) => a.id - b.id);
    arr2.sort((a, b) => a.id - b.id);
    var i = 0;
    var j = 0;
    var lim = arr2.length;
    while (i < arr1.length) {
        if (j == lim || arr2[j].id > arr1[i].id) {
            arr2.push(arr1[i]);
            i++;
        } else if (arr2[j].id == arr1[i].id) {
            Object.entries(arr1[i]).forEach(([k, v]) => {
                if (arr2[j][k] === undefined) arr2[j][k] = v;
            })
            i++;
            j++;
        } else {
            j++;
        }
    }
    arr2.sort((a, b) => a.id - b.id);
    return arr2;
};
