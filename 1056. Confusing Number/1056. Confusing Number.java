/*
 * Problem: 1056. Confusing Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/confusing-number/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public boolean confusingNumber(int n) {
        int[] nums = { 0, 1, -1, -1, -1, -1, 9, -1, 8, 6 };
        int a = 0;
        int b = n;
        while (b > 0) {
            int tmp = b % 10;
            if (nums[tmp] == -1)
                return false;
            a *= 10;
            a += nums[tmp];
            b /= 10;
        }
        return a != n;
    }
}
