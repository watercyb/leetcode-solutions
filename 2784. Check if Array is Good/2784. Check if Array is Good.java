/*
 * Problem: 2784. Check if Array is Good
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-array-is-good/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public boolean isGood(int[] nums) {
        int[] counts = new int[nums.length];
        for (int num : nums) {
            if (num >= counts.length)
                return false;
            counts[num]++;
        }
        counts[counts.length - 1]--;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] != 1)
                return false;
        }
        return true;
    }
}
