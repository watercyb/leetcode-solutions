/*
 * Problem: 2562. Find the Array Concatenation Value
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-array-concatenation-value/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            long base = 1;
            res += nums[r];
            while (nums[r] > 0) {
                nums[r] /= 10;
                base *= 10;
            }
            res += base * nums[l];
            l++;
            r--;
        }
        if (l == r)
            res += nums[l];
        return res;
    }
}
