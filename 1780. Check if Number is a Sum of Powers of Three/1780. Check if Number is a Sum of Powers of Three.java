/*
 * Problem: 1780. Check if Number is a Sum of Powers of Three
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public boolean checkPowersOfThree(int n) {
        int p = (int) Math.pow(3, (int) (Math.log(n) / Math.log(3)));
        while (n > 0 && p > 0) {
            if (n >= p)
                n -= p;
            p /= 3;
        }
        return n == 0;
    }
}
