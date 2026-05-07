/*
 * Problem: 3467. Transform Array by Parity
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/transform-array-by-parity/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int[] transformArray(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0)
                count++;
        }
        for (int i = 0; i < count; i++) {
            nums[i] = 0;
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 1;
        }
        return nums;
    }
}
