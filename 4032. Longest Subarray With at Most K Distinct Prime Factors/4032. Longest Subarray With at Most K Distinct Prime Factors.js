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
    const spf = Array(max + 1);
    for (let i = 2; i <= max; i++) {
        if (spf[i]) continue;
        spf[i] = i;
        for (let j = i * i; j <= max; j += i) {
            if (!spf[j])
                spf[j] = i;
        }
    }
    let res = 0;
    let j = 0;
    const counts = new Int32Array(max + 1);
    const lists = Array(max + 1);
    let count = 0;
    for (let i = 0; i < nums.length; i++) {
        if (!lists[nums[i]]) {
            const arr = [];
            let num = nums[i];
            while (num > 1) {
                const div = spf[num];
                arr.push(div);
                while (num % div == 0) {
                    num /= div;
                }
            }
            lists[nums[i]] = arr;
        }
        for (let num of lists[nums[i]]) {
            if (counts[num]++ == 0)
                count++;
        }
        while (count > k) {
            for (let num of lists[nums[j]]) {
                if (counts[num]-- == 1)
                    count--;
            }
            j++;
        }
        res = Math.max(res, i - j + 1);
    }
    return res;
};
