/*
 * Problem: 1567. Maximum Length of Subarray With Positive Product
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int getMaxLen(int[] nums) {
        int beginning = -1;
        int first = -1;
        int last = -1;
        int res = 0;
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                if (first == -1)
                    first = i;
                last = i;
                p = -p;
            } else if (nums[i] == 0) {
                if (p > 0) {
                    res = Math.max(i - beginning - 1, res);
                } else {
                    res = Math.max(Math.max(i - first - 1, last - beginning - 1), res);
                }
                beginning = i;
                first = -1;
                p = 1;
            }
        }
        if (p > 0) {
            res = Math.max(nums.length - 1 - beginning, res);
        } else {
            res = Math.max(Math.max(nums.length - first - 1, last - beginning - 1), res);
        }
        return res;
    }
}
