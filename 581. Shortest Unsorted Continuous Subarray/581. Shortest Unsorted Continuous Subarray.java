/*
 * Problem: 581. Shortest Unsorted Continuous Subarray
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int r = 0;
        int l = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                r = i;
            } else {
                max = nums[i];
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > min) {
                l = i;
            } else {
                min = nums[i];
            }
        }
        return r - l + 1;
    }
}
