/*
 * Problem: 3024. Type of Triangle
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/type-of-triangle/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public String triangleType(int[] nums) {
        if (nums[0] + nums[1] + nums[2] <= 2 * (Math.max(Math.max(nums[0], nums[1]), nums[2])))
            return "none";
        if (nums[0] == nums[1] && nums[1] == nums[2])
            return "equilateral";
        if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2])
            return "isosceles";
        return "scalene";
    }
}
