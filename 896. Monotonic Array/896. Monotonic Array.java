/*
 * Problem: 896. Monotonic Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/monotonic-array/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length < 2)
            return true;
        int i = 1;
        while (i < nums.length - 1 && nums[i] == nums[i - 1]) {
            i++;
        }
        if (nums[i] > nums[i - 1]) {
            for (i = i + 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1])
                    return false;
            }
        } else {
            for (i = i + 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1])
                    return false;
            }
        }
        return true;
    }
}
