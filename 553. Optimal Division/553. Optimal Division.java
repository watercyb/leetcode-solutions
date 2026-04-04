/*
 * Problem: 553. Optimal Division
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/optimal-division/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1)
            return String.valueOf(nums[0]);
        if (nums.length == 2)
            return new StringBuilder().append(nums[0]).append('/').append(nums[1]).toString();
        StringBuilder SB = new StringBuilder();
        SB.append(nums[0]).append("/(");
        for (int i = 1; i < nums.length - 1; i++) {
            SB.append(nums[i]).append('/');
        }
        SB.append(nums[nums.length - 1]).append(')');
        return SB.toString();
    }
}
