/*
 * Problem: 4065. Rearrange Array by Removing Distinct Values
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/rearrange-array-by-removing-distinct-values/
 * Language: javascript
 * Date: 2026-09-28
 */

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var rearrangeArray = function (nums) {
    const counts = new Array(101);
    for (let i = 0; i < counts.length; i++) {
        counts[i] = [];
    }
    for (let num of nums) {
        counts[num]++;
    }
    const arr = [];
    for (let i = 0; i < counts.length; i++) {
        for (let j = 0; j < counts[i]; j++) {
            if (j == arr.length) arr.push([]);
            arr[j].push(i);
        }
    }
    const res = [];
    for (let ar of arr) {
        if (!ar) break;
        for (let num of ar) {
            res.push(num);
        }
    }
    return res;
};
