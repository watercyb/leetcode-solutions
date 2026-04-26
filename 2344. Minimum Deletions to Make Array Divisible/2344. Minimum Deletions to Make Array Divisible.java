/*
 * Problem: 2344. Minimum Deletions to Make Array Divisible
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            gcd = GCD(numsDivide[i], gcd);
        }
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (gcd % num == 0 && num < min)
                min = num;
        }
        if (min == Integer.MAX_VALUE)
            return -1;
        int res = 0;
        for (int num : nums) {
            if (num < min)
                res++;
        }
        return res;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
