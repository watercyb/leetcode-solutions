/*
 * Problem: 2393. Count Strictly Increasing Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-strictly-increasing-subarrays/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public long countSubarrays(int[] nums) {
        long res = 0;
        int len = 0;
        int prv = -1;
        for (int num : nums) {
            if (num > prv) {
                len++;
            } else {
                len = 1;
            }
            res += len;
            prv = num;
        }
        return res;
    }
}
