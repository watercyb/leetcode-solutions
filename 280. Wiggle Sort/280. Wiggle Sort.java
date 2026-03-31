/*
 * Problem: 280. Wiggle Sort
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/wiggle-sort/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public void wiggleSort(int[] nums) {
        int p = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] - nums[i + 1]) * p < 0) {
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
            p *= -1;
        }
    }
}
