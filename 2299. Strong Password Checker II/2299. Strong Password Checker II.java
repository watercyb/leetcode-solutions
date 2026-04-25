/*
 * Problem: 2299. Strong Password Checker II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/strong-password-checker-ii/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8)
            return false;
        int[] types = new int[256];
        for (char chr : new char[] { '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+' }) {
            types[chr] = 1;
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            types[i] = 4;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            types[i] = 3;
        }
        for (int i = '0'; i <= '9'; i++) {
            types[i] = 2;
        }
        char prv = 0;
        boolean[] hasTypes = new boolean[5];
        for (char chr : password.toCharArray()) {
            if (chr == prv)
                return false;
            hasTypes[types[chr]] = true;
            prv = chr;
        }
        for (int i = 1; i < 5; i++) {
            if (!hasTypes[i])
                return false;
        }
        return true;
    }
}
