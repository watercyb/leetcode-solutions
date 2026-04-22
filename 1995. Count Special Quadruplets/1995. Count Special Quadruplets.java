/*
 * Problem: 1995. Count Special Quadruplets
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-special-quadruplets/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int countQuadruplets(int[] nums) {
        int[] counts = new int[201];
        int res = 0;
        for (int c = nums.length - 2; c >= 2; c--) {
            for (int d = c + 1; d < nums.length; d++) {
                int diff = nums[d] - nums[c];
                if (diff >= 0)
                    counts[diff]++;
            }
            int b = c - 1;
            for (int a = 0; a < b; a++) {
                res+=counts[nums[a]+nums[b]];
            }

        }
        return res;
    }
}
