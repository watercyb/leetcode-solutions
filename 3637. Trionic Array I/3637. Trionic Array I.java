/*
 * Problem: 3637. Trionic Array I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/trionic-array-i/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public boolean isTrionic(int[] nums) {
        int idx = 0;
        while (idx < nums.length - 1 && nums[idx] < nums[idx + 1]) {
            idx++;
        }
        if (idx == 0 || idx == nums.length - 1 || nums[idx] == nums[idx + 1])
            return false;
        while (idx < nums.length - 1 && nums[idx] > nums[idx + 1]) {
            idx++;
        }
        if (idx == nums.length - 1 || nums[idx] == nums[idx + 1])
            return false;
        while (idx < nums.length - 1 && nums[idx] < nums[idx + 1]) {
            idx++;
        }
        return idx == nums.length - 1;
    }
}
