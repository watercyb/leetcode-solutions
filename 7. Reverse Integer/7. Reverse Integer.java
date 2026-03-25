/*
 * Problem: 7. Reverse Integer
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reverse-integer/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int reverse(int x) {
        int p = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int res = 0;
        int prv = 0;
        while (x > 0) {
            int digit = x % 10;
            res = res * 10 + digit;
            if (res / 10 != prv)
                return 0;
            x /= 10;
            prv = res;
        }
        return p * res;
    }
}
