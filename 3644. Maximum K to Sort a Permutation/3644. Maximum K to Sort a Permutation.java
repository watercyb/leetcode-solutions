/*
 * Problem: 3644. Maximum K to Sort a Permutation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-k-to-sort-a-permutation/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int sortPermutation(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i)
                continue;
            res &= nums[i];
        }
        if (res == Integer.MAX_VALUE)
            return 0;
        return res;
    }
}
