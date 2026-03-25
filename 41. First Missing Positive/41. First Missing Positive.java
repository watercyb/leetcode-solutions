/*
 * Problem: 41. First Missing Positive
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/first-missing-positive/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int tmp = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[tmp] != nums[i]) {
                nums[i] = nums[tmp];
                nums[tmp] = tmp + 1;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }
}
