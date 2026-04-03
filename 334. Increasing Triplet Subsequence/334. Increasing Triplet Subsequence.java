/*
 * Problem: 334. Increasing Triplet Subsequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/increasing-triplet-subsequence/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min1) {
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
