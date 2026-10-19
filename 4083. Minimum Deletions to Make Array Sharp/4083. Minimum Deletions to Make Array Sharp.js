/*
 * Problem: 4083. Minimum Deletions to Make Array Sharp
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-deletions-to-make-array-sharp/
 * Language: javascript
 * Date: 2026-10-19
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var minDeletions = function(nums) {
    let res=nums.length;
    let prv=0;
    for (let num of nums) {
        if (num!=prv) {
            res--;
            prv=num;
        }
    }
    return res;
};
