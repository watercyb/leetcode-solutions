/*
 * Problem: 3759. Count Elements With at Least K Greater Values
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-elements-with-at-least-k-greater-values/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int countElements(int[] nums, int k) {
        if (k == 0)
            return nums.length;
        if (nums.length == 1)
            return 0;
        Arrays.sort(nums);
        if (nums[0] == nums[nums.length - k])
            return 0;
        for (int i = nums.length - 1 - k; i >= 0; i--) {
            if (nums[i + 1] != nums[i])
                return i + 1;
        }
        return 0;
    }
}
