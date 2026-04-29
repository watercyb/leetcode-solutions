/*
 * Problem: 2695. Array Wrapper
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/array-wrapper/
 * Language: javascript
 * Date: 2026-04-29
 */

/**
 * @param {number[]} nums
 * @return {void}
 */
var ArrayWrapper = function (nums) {
    this.nums = nums;
    this.sum = 0;
    for (let i = 0; i < nums.length; i++) {
        this.sum += nums[i];
    }
};

/**
 * @return {number}
 */
ArrayWrapper.prototype.valueOf = function () {
    return this.sum;
}

/**
 * @return {string}
 */
ArrayWrapper.prototype.toString = function () {
    return '[' + this.nums.toString() + ']';
}

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */
