/*
 * Problem: 3270. Find the Key of the Numbers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-key-of-the-numbers/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int res = 0;
        int base = 1;
        while (num1 > 0 && num2 > 0 && num3 > 0) {
            res += base * Math.min(Math.min(num1 % 10, num2 % 10), num3 % 10);
            base *= 10;
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        return res;
    }
}
