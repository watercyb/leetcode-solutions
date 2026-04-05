/*
 * Problem: 625. Minimum Factorization
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-factorization/
 * Language: java
 * Date: 2026-04-05
 */

class Solution {
    public int smallestFactorization(int num) {
        if (num == 1)
            return 1;
        long res = 0;
        long base = 1;
        for (int i = 9; i >= 2; i--) {
            while (num % i == 0) {
                res += i * base;
                if (res > Integer.MAX_VALUE)
                    return 0;
                base *= 10;
                num /= i;
            }
        }
        if (num > 10)
            return 0;
        return (int) res;
    }
}
