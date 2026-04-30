/*
 * Problem: 2772. Apply Operations to Make All Array Elements Equal to Zero
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/apply-operations-to-make-all-array-elements-equal-to-zero/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public boolean checkArray(int[] nums, int k) {
        int[] arr = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += arr[i];
            if (sum > nums[i])
                return false;
            if (sum < nums[i]) {
                if (i > nums.length - k)
                    return false;
                arr[i + k] -= nums[i] - sum;
                sum = nums[i];
            }
        }
        return true;
    }
}
