/*
 * Problem: 660. Remove 9
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/remove-9/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int newInteger(int n) {
        int res = 0;
        int base = 1;
        while (n > 0) {
            res += +n % 9 * base;
            base *= 10;
            n /= 9;
        }
        return res;
    }
}
