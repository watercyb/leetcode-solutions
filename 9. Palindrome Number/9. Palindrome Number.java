/*
 * Problem: 9. Palindrome Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/palindrome-number/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int tmp = x;
        int sum = 0;
        while (tmp > 0) {
            sum *= 10;
            sum += tmp % 10;
            tmp /= 10;
        }
        return sum == x;
    }
}
