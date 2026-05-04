/*
 * Problem: 3191. Minimum Operations to Make Binary Array Elements Equal to One I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                res++;
            }
        }
        if (nums[nums.length - 1] + nums[nums.length - 2] == 2)
            return res;
        return -1;
    }
}
