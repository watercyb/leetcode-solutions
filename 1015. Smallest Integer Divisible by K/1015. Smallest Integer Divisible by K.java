/*
 * Problem: 1015. Smallest Integer Divisible by K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-integer-divisible-by-k/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0)
            return -1;
        if (k == 1)
            return 1;
        int num = 1;
        int res = 1;
        while (num > 0) {
            num = (num * 10 + 1) % k;
            res++;
        }
        return res;
    }
}
