/*
 * Problem: 1979. Find Greatest Common Divisor of Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-greatest-common-divisor-of-array/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        return getGCD(max, min);
    }

    public int getGCD(int a, int b) {
        if (b == 0)
            return a;
        return getGCD(b, a % b);
    }
}
