/*
 * Problem: 3353. Minimum Total Operations
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-total-operations/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minOperations(int[] nums) {
        int prv = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prv) {
                res++;
                prv = nums[i];
            }
        }
        return res;
    }
}
