/*
 * Problem: 3507. Minimum Pair Removal to Sort Array I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int minimumPairRemoval(int[] nums) {
        if (nums.length == 1)
            return 0;
        int min = Integer.MAX_VALUE;
        int idx = -1;
        boolean isDec = false;
        int prv = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < prv)
                isDec = true;
            if (nums[i] + nums[i - 1] < min) {
                min = nums[i] + nums[i - 1];
                idx = i;
            }
            prv=nums[i];
        }
        if (!isDec)
            return 0;
        int[] next = new int[nums.length - 1];
        for (int i = 0; i < idx; i++) {
            next[i] = nums[i];
        }
        for (int i = idx; i < nums.length; i++) {
            next[i - 1] += nums[i];
        }
        return minimumPairRemoval(next) + 1;
    }
}
