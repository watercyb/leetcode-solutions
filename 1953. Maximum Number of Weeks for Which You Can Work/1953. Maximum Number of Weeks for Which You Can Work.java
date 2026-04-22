/*
 * Problem: 1953. Maximum Number of Weeks for Which You Can Work
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public long numberOfWeeks(int[] milestones) {
        int max = 0;
        long sum = 0;
        for (int milestone : milestones) {
            max = Math.max(milestone, max);
            sum += milestone;
        }
        return Math.min(sum, (sum - max) * 2 + 1);
    }
}
