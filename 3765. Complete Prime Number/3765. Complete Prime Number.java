/*
 * Problem: 3765. Complete Prime Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/complete-prime-number/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public boolean completePrime(int num) {
        char[] chrs = String.valueOf(num).toCharArray();
        int pre = 0;
        int mask = 10;
        for (char chr : chrs) {
            pre = pre * 10 + chr - '0';
            if (!chk(pre) || !chk(num % mask))
                return false;
            mask *= 10;
        }
        return true;
    }

    public boolean chk(int num) {
        if (num == 1)
            return false;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
