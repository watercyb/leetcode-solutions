/*
 * Problem: 2436. Minimum Split Into Subarrays With GCD Greater Than One
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-split-into-subarrays-with-gcd-greater-than-one/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int minimumSplits(int[] nums) {
        int res = 1;
        int gcd = nums[0];
        for (int i = 0; i < nums.length; i++) {
            gcd = GCD(gcd, nums[i]);
            if (gcd == 1) {
                res++;
                gcd = nums[i];
            }
        }
        return res;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
