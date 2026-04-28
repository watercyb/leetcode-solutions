/*
 * Problem: 2552. Count Increasing Quadruplets
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-increasing-quadruplets/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long countQuadruplets(int[] nums) {
        int[] count123 = new int[nums.length];
        long res = 0;
        for (int i = 2; i < nums.length; i++) {
            int count1 = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    res += count123[j];
                    count1++;
                } else {
                    count123[j] += count1;
                }
            }
        }
        return res;
    }
}
