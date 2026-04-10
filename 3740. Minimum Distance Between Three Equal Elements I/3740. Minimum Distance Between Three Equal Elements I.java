/*
 * Problem: 3740. Minimum Distance Between Three Equal Elements I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/?envType=daily-question&envId=2026-04-10
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int minimumDistance(int[] nums) {
        int[] idx1 = new int[nums.length + 1];
        int[] idx2 = new int[nums.length + 1];
        Arrays.fill(idx1, -1);
        Arrays.fill(idx2, -1);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (idx2[nums[i]] != -1 && i - idx2[nums[i]] < res)
                res = i - idx2[nums[i]];
            idx2[nums[i]] = idx1[nums[i]];
            idx1[nums[i]] = i;
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res * 2;
    }
}
