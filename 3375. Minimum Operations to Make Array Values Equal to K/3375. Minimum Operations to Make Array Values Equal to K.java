/*
 * Problem: 3375. Minimum Operations to Make Array Values Equal to K
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minOperations(int[] nums, int k) {
        boolean[] seens = new boolean[101];
        int res = 0;
        for (int num : nums) {
            if (num < k)
                return -1;
            if (!seens[num]) {
                seens[num] = true;
                res++;
            }
        }
        if (seens[k])
             res--;
        return res;
    }
}
