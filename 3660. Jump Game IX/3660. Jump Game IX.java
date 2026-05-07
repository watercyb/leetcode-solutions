/*
 * Problem: 3660. Jump Game IX
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/jump-game-ix/?envType=daily-question&envId=2026-05-07
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int[] maxValue(int[] nums) {
        int[] prvMax = new int[nums.length];
        prvMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prvMax[i] = Math.max(prvMax[i - 1], nums[i]);
        }
        int max = prvMax[nums.length - 1];
        int min = Integer.MAX_VALUE;
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (prvMax[i] > min) {
                res[i] = max;
            } else {
                res[i] = prvMax[i];
                max = prvMax[i];
            }
            min = Math.min(min, nums[i]);
        }
        return res;
    }
}
