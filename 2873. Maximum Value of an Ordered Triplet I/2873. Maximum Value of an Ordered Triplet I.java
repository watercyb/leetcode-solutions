/*
 * Problem: 2873. Maximum Value of an Ordered Triplet I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public long maximumTripletValue(int[] nums) {
        int max = 0;
        int diff = 0;
        long res = 0;
        for (int num : nums) {
            res = Math.max((long) diff * num, res);
            diff = Math.max(max - num, diff);
            max = Math.max(num, max);
        }
        return res;
    }
}
