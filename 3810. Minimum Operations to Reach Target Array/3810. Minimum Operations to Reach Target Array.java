/*
 * Problem: 3810. Minimum Operations to Reach Target Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-reach-target-array/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int minOperations(int[] nums, int[] target) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        boolean[] seens = new boolean[max + 1];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target[i] && !seens[nums[i]]) {
                seens[nums[i]] = true;
                res++;
            }
        }
        return res;
    }
}
