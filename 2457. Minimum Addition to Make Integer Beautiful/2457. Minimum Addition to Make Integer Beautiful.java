/*
 * Problem: 2457. Minimum Addition to Make Integer Beautiful
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long res = 0;
        long base = 1;
        while (getCount(n) > target) {
            long digit = n % 10;
            res += (10 - digit) * base;
            n = n / 10 + 1;
            base *= 10;
        }
        return res;
    }

    public int getCount(long num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
