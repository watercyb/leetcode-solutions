/*
 * Problem: 132 Pattern
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/132-pattern/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean find132pattern(int[] nums) {
        int[] mins = new int[nums.length];
        int idx = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                while (idx > 0 && nums[idx - 1] <= nums[i]) {
                    idx--;
                }
                if (idx > 0 && mins[idx - 1] < nums[i])
                    return true;
                nums[idx] = nums[i];
                mins[idx] = min;
                idx++;
            }
        }
        return false;
    }
}
