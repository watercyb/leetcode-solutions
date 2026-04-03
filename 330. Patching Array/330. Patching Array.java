/*
 * Problem: 330. Patching Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/patching-array/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int minPatches(int[] nums, int n) {
        long max = 0;
        int res = 0;
        int idx = 0;
        while (max < n) {
            if (idx < nums.length && max + 1 >= nums[idx]) {
                max += nums[idx++];
            } else {
                max += max + 1;
                res++;
            }
        }
        return res;
    }
}
