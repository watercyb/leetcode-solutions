/*
 * Problem: 462. Minimum Moves to Equal Array Elements II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int res = 0;
        while (l < r) {
            res += nums[r] - nums[l];
            l++;
            r--;
        }
        return res;
    }
}
