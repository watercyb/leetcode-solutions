/*
 * Problem: 2567. Minimum Score by Changing Two Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-score-by-changing-two-elements/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        return Math.min(nums[nums.length-2]-nums[1], Math.min(nums[nums.length-1]-nums[2], nums[nums.length-3]-nums[0]));
    }
}
