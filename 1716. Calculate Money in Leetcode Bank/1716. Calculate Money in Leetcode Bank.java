/*
 * Problem: 1716. Calculate Money in Leetcode Bank
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/calculate-money-in-leetcode-bank/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int totalMoney(int n) {
        int a = n / 7;
        int b = n % 7;
        return (a * 7 + 49) * a / 2 + (a * 2 + b + 1) * b / 2;
    }
}
