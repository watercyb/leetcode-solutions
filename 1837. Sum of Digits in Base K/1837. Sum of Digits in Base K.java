/*
 * Problem: 1837. Sum of Digits in Base K
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sum-of-digits-in-base-k/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int sumBase(int n, int k) {
        int res = 0;
        while (n > 0) {
            res += n % k;
            n /= k;
        }
        return res;
    }
}
