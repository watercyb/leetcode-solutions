/*
 * Problem: 2520. Count the Digits That Divide a Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-the-digits-that-divide-a-number/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int countDigits(int num) {
        int n = num;
        int res = 0;
        while (n > 0) {
            if (num % (n % 10) == 0)
                res++;
            n /= 10;
        }
        return res;
    }
}
