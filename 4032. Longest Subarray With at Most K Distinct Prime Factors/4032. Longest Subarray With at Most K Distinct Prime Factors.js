/*
 * Problem: 4032. Longest Subarray With at Most K Distinct Prime Factors
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-subarray-with-at-most-k-distinct-prime-factors/
 * Language: javascript
 * Date: 2026-08-26
 */

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

var longestSubarray = function (nums, k) {
    let max = 0;
    for (let num of nums) {
        max = Math.max(max, num);
    }
    const isPrimes = Array(max + 1);
    isPrimes[0] = false;
    isPrimes[1] = false;
    const primes = [];
    const arr = [];
    for (let i = 0; i <= max; i++) {
        arr.push([]);
    }
    for (let i = 2; i < isPrimes.length; i++) {
        if (isPrimes[i] == false) continue;
        isPrimes[i] = true;
        primes.push(i);
        arr[i].push(i);
        for (let j = i + i; j < isPrimes.length; j += i) {
            isPrimes[j] = false;
            arr[j].push(i);
        }
    }
    let res = 0;
    let j = 0;
    const counts = new Map();
    for (let i = 0; i < nums.length; i++) {
        for (let num of arr[nums[i]]) {
            if (counts.has(num)) {
                counts.set(num, counts.get(num) + 1);
            } else {
                counts.set(num, 1);
            }
        }
        while (counts.size > k) {
            for (let num of arr[nums[j]]) {
                const count = counts.get(num) - 1;
                if (count == 0) {
                    counts.delete(num);
                } else {
                    counts.set(num, count);
                }
            }
            j++;
        }
        res = Math.max(res, i - j + 1);
    }
    return res;
};
