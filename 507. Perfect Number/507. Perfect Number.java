/*
 * Problem: 507. Perfect Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/perfect-number/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        int lim = (int) Math.sqrt(num);
        for (int i = 2; i < lim; i++) {
            if (num % i == 0)
                sum += i + num / i;
        }
        if (num % lim == 0)
            sum += lim * lim == num ? lim : lim + num / lim;
        return sum == num;
    }
}
