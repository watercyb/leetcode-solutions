/*
 * Problem: 2544. Alternating Digit Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/alternating-digit-sum/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int alternateDigitSum(int n) {
        int res = 0;
        int p = 1;
        while (n > 0) {
            res += p * n % 10;
            n /= 10;
            p = -p;
        }
        return -p * res;
    }
}
