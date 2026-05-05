/*
 * Problem: 3201. Find the Maximum Length of Valid Subsequence I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int maximumLength(int[] nums) {
        int[] counts = new int[2];
        int len = 0;
        int target = nums[0] % 2;
        for (int num : nums) {
            int idx = num & 1;
            counts[idx]++;
            if (idx == target) {
                len++;
                target = 1 - target;
            }
        }
        return Math.max(Math.max(counts[0], counts[1]), len);
    }
}
