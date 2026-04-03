/*
 * Problem: 504. Base 7
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/base-7/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String convertToBase7(int num) {
        boolean p = num >= 0;
        num = Math.abs(num);
        int res = 0;
        int base = 1;
        while (num > 0) {
            res += num % 7 * base;
            num /= 7;
            base *= 10;
        }
        if (!p)
            res = -res;
        return String.valueOf(res);
    }
}
