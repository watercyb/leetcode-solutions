/*
 * Problem: 413. Arithmetic Slices
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/arithmetic-slices/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        int idx = 0;
        while (idx < nums.length - 2) {
            int diff = nums[idx + 1] - nums[idx];
            int idxNext = idx + 1;
            while (idxNext < nums.length - 1 && nums[idxNext + 1] - nums[idxNext] == diff) {
                res += idxNext - idx;
                idxNext++;
            }
            idx = idxNext;
        }
        return res;
    }
}
