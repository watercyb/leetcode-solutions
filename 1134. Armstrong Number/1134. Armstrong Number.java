/*
 * Problem: 1134. Armstrong Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/armstrong-number/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public boolean isArmstrong(int n) {
        int num = n;
        int sum = 0;
        int l = String.valueOf(n).length();
        while (num > 0) {
            sum += Math.pow(num % 10, l);
            num /= 10;
        }
        return sum == n;
    }
}
