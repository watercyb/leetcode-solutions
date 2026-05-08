/*
 * Problem: 3523. Make Array Non-decreasing
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/make-array-non-decreasing/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int maximumPossibleSize(int[] nums) {
        int res = 1;
        int prv = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= prv) {
                res++;
                prv = nums[i];
            }
        }
        return res;
    }
}
