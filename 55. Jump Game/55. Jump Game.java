/*
 * Problem: 55. Jump Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/jump-game/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length==1) return true;
        int max=nums[0];
        for (int i=0;i<nums.length-1;i++) {
            if (i>max) return false;
            max=Math.max(i+nums[i],max);
            if (max>=nums.length-1) return true;
        }
        return false;
    }
}
