/*
 * Problem: 2970. Count the Number of Incremovable Subarrays I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int j = nums.length - 2;
        while (j >= 0 && nums[j] < nums[j + 1]) {
            j--;
        }
        if (j < 0)
            return (nums.length + 1) * nums.length / 2;
        j++;
        int prv = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && prv >= nums[j]) {
                j++;
            }
            res += nums.length - j + 1;
            if (nums[i] <= prv)
                break;
            prv = nums[i];
        }
        return res;
    }
}
