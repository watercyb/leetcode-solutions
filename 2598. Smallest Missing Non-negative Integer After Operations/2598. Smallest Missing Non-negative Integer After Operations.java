/*
 * Problem: 2598. Smallest Missing Non-negative Integer After Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] counts = new int[value];
        for (int num : nums) {
            num %= value;
            if (num < 0)
                num += value;
            counts[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (counts[i % value]-- == 0)
                return i;
        }
        return nums.length;
    }
}
