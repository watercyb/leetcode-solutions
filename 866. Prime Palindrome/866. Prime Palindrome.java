/*
 * Problem: 866. Prime Palindrome
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/prime-palindrome/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int primePalindrome(int n) {
        if (n == 1)
            return 2;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < 10000; i++) {
            int temp = i;
            int num = i;
            while (temp > 0) {
                num = num * 10 + temp % 10;
                temp /= 10;
            }
            if (num >= n && chk(num)) {
                res = num;
                break;
            }
        }
        for (int i = 1; i < 20000; i++) {
            int temp = i / 10;
            int num = i;
            while (temp > 0) {
                num = num * 10 + temp % 10;
                temp /= 10;
            }
            if (num >= res)
                break;
            if (num >= n && chk(num)) {
                res = num;
                break;
            }
        }
        return res;
    }

    public boolean chk(int num) {
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
