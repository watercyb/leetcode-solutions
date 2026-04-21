/*
 * Problem: 1827. Minimum Operations to Make the Array Increasing
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int minOperations(int[] nums) {
        int res = 0;
        int prv = -1;
        for (int num : nums) {
            if (num <= prv) {
                prv++;
                res += prv - num;
            } else {
                prv = num;
            }
        }
        return res;
    }
}
